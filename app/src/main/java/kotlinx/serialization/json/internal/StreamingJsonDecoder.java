package kotlinx.serialization.json.internal;

import androidx.compose.foundation.FocusableNode$focusTargetNode$1;
import androidx.compose.material.icons.filled.EditKt;
import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.ElementMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.Request;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamingJsonDecoder extends EditKt implements JsonDecoder {
    public final JsonConfiguration configuration;
    public int currentIndex = -1;
    public Symbol discriminatorHolder;
    public final JsonElementMarker elementMarker;
    public final Json json;
    public final RoomOpenHelper lexer;
    public final WriteMode mode;
    public final Request serializersModule;

    public StreamingJsonDecoder(Json json, WriteMode writeMode, RoomOpenHelper roomOpenHelper, SerialDescriptor serialDescriptor, Symbol symbol) {
        this.json = json;
        this.mode = writeMode;
        this.lexer = roomOpenHelper;
        this.serializersModule = json.serializersModule;
        this.discriminatorHolder = symbol;
        JsonConfiguration jsonConfiguration = json.configuration;
        this.configuration = jsonConfiguration;
        this.elementMarker = jsonConfiguration.explicitNulls ? null : new JsonElementMarker(serialDescriptor);
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Json json = this.json;
        WriteMode writeModeSwitchMode = WriteModeKt.switchMode(serialDescriptor, json);
        RoomOpenHelper roomOpenHelper = this.lexer;
        StatusLine statusLine = (StatusLine) roomOpenHelper.configuration;
        int i = statusLine.code + 1;
        statusLine.code = i;
        Object[] objArr = (Object[]) statusLine.protocol;
        if (i == objArr.length) {
            int i2 = i * 2;
            statusLine.protocol = Arrays.copyOf(objArr, i2);
            statusLine.message = Arrays.copyOf((int[]) statusLine.message, i2);
        }
        ((Object[]) statusLine.protocol)[i] = serialDescriptor;
        roomOpenHelper.consumeNextToken(writeModeSwitchMode.begin);
        if (roomOpenHelper.peekNextToken() == 4) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        int iOrdinal = writeModeSwitchMode.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
            return new StreamingJsonDecoder(json, writeModeSwitchMode, roomOpenHelper, serialDescriptor, this.discriminatorHolder);
        }
        return (this.mode == writeModeSwitchMode && json.configuration.explicitNulls) ? this : new StreamingJsonDecoder(json, writeModeSwitchMode, roomOpenHelper, serialDescriptor, this.discriminatorHolder);
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        boolean z;
        boolean z2;
        RoomOpenHelper roomOpenHelper = this.lexer;
        int iSkipWhitespaces = roomOpenHelper.skipWhitespaces();
        String str = (String) roomOpenHelper.legacyHash;
        if (iSkipWhitespaces == str.length()) {
            RoomOpenHelper.fail$default(roomOpenHelper, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iSkipWhitespaces) == '\"') {
            iSkipWhitespaces++;
            z = true;
        } else {
            z = false;
        }
        int iPrefetchOrEof = roomOpenHelper.prefetchOrEof(iSkipWhitespaces);
        if (iPrefetchOrEof >= str.length() || iPrefetchOrEof == -1) {
            RoomOpenHelper.fail$default(roomOpenHelper, "EOF", 0, null, 6);
            throw null;
        }
        int i = iPrefetchOrEof + 1;
        int iCharAt = str.charAt(iPrefetchOrEof) | ' ';
        if (iCharAt == 102) {
            roomOpenHelper.consumeBooleanLiteral("alse", i);
            z2 = false;
        } else {
            if (iCharAt != 116) {
                RoomOpenHelper.fail$default(roomOpenHelper, "Expected valid boolean literal prefix, but had '" + roomOpenHelper.consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
            roomOpenHelper.consumeBooleanLiteral("rue", i);
            z2 = true;
        }
        if (!z) {
            return z2;
        }
        if (roomOpenHelper.version == str.length()) {
            RoomOpenHelper.fail$default(roomOpenHelper, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(roomOpenHelper.version) == '\"') {
            roomOpenHelper.version++;
            return z2;
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        long jConsumeNumericLiteral = roomOpenHelper.consumeNumericLiteral();
        byte b = (byte) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == b) {
            return b;
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse byte for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        if (strConsumeStringLenient.length() == 1) {
            return strConsumeStringLenient.charAt(0);
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Expected single char, but got '" + strConsumeStringLenient + '\'', 0, null, 6);
        throw null;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            double d = Double.parseDouble(strConsumeStringLenient);
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                return d;
            }
            RoomOpenHelper.fail$default(roomOpenHelper, "Unexpected special floating-point value " + Double.valueOf(d) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'double' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x020e A[EDGE_INSN: B:120:0x020e->B:121:0x020f BREAK  A[LOOP:0: B:48:0x0091->B:99:0x0199]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        RoomOpenHelper roomOpenHelper = this.lexer;
        StatusLine statusLine = (StatusLine) roomOpenHelper.configuration;
        String str = (String) roomOpenHelper.legacyHash;
        WriteMode writeMode = this.mode;
        int iOrdinal = writeMode.ordinal();
        char c = ':';
        int i = 0;
        zTryConsumeComma = false;
        boolean zTryConsumeComma = false;
        int i2 = -1;
        if (iOrdinal == 0) {
            boolean zTryConsumeComma2 = roomOpenHelper.tryConsumeComma();
            while (true) {
                boolean zCanConsumeValue = roomOpenHelper.canConsumeValue();
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (zCanConsumeValue) {
                    String strConsumeKeyString = roomOpenHelper.consumeKeyString();
                    roomOpenHelper.consumeNextToken(c);
                    int jsonNameIndex = WriteModeKt.getJsonNameIndex(serialDescriptor, this.json, strConsumeKeyString);
                    if (jsonNameIndex != -3) {
                        if (jsonElementMarker != null) {
                            ElementMarker elementMarker = jsonElementMarker.origin;
                            if (jsonNameIndex < 64) {
                                elementMarker.lowerMarks |= 1 << jsonNameIndex;
                            } else {
                                int i3 = (jsonNameIndex >>> 6) - 1;
                                long[] jArr = elementMarker.highMarksArray;
                                jArr[i3] = jArr[i3] | (1 << (jsonNameIndex & 63));
                            }
                        }
                        i2 = jsonNameIndex;
                        break;
                    }
                    if (!this.configuration.ignoreUnknownKeys) {
                        Symbol symbol = this.discriminatorHolder;
                        if (symbol == null || !Intrinsics.areEqual(symbol.symbol, strConsumeKeyString)) {
                            roomOpenHelper.fail(StringsKt.lastIndexOf$default(6, str.subSequence(0, roomOpenHelper.version).toString(), strConsumeKeyString), "Encountered an unknown key '" + strConsumeKeyString + '\'', "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
                            throw null;
                        }
                        symbol.symbol = null;
                    }
                    ArrayList arrayList = new ArrayList();
                    byte bPeekNextToken = roomOpenHelper.peekNextToken();
                    if (bPeekNextToken == 8 || bPeekNextToken == 6) {
                        while (true) {
                            byte bPeekNextToken2 = roomOpenHelper.peekNextToken();
                            if (bPeekNextToken2 == 1) {
                                roomOpenHelper.consumeKeyString();
                            } else {
                                if (bPeekNextToken2 == 8 || bPeekNextToken2 == 6) {
                                    arrayList.add(Byte.valueOf(bPeekNextToken2));
                                } else if (bPeekNextToken2 == 9) {
                                    if (((Number) CollectionsKt.last(arrayList)).byteValue() != 8) {
                                        throw WriteModeKt.JsonDecodingException(roomOpenHelper.version, str, "found ] instead of } at path: " + statusLine);
                                    }
                                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                } else if (bPeekNextToken2 == 7) {
                                    if (((Number) CollectionsKt.last(arrayList)).byteValue() != 6) {
                                        throw WriteModeKt.JsonDecodingException(roomOpenHelper.version, str, "found } instead of ] at path: " + statusLine);
                                    }
                                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                                } else if (bPeekNextToken2 == 10) {
                                    RoomOpenHelper.fail$default(roomOpenHelper, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                    throw null;
                                }
                                roomOpenHelper.consumeNextToken();
                                if (arrayList.size() == 0) {
                                    break;
                                }
                            }
                        }
                    } else {
                        roomOpenHelper.consumeStringLenient();
                    }
                    zTryConsumeComma2 = roomOpenHelper.tryConsumeComma();
                    c = ':';
                } else if (!zTryConsumeComma2) {
                    if (jsonElementMarker == null) {
                        i2 = -1;
                        break;
                    }
                    ElementMarker elementMarker2 = jsonElementMarker.origin;
                    FocusableNode$focusTargetNode$1 focusableNode$focusTargetNode$1 = elementMarker2.readIfAbsent;
                    SerialDescriptor serialDescriptor2 = elementMarker2.descriptor;
                    int elementsCount = serialDescriptor2.getElementsCount();
                    while (true) {
                        long j = elementMarker2.lowerMarks;
                        long j2 = -1;
                        if (j == -1) {
                            if (elementsCount <= 64) {
                                i2 = -1;
                                break;
                            }
                            long[] jArr2 = elementMarker2.highMarksArray;
                            int length = jArr2.length;
                            loop3: while (true) {
                                if (i >= length) {
                                    i2 = -1;
                                    break;
                                }
                                int i4 = i + 1;
                                int i5 = i4 * 64;
                                long j3 = jArr2[i];
                                while (true) {
                                    if (j3 != j2) {
                                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j3);
                                        j3 |= 1 << iNumberOfTrailingZeros;
                                        i2 = iNumberOfTrailingZeros + i5;
                                        if (((Boolean) focusableNode$focusTargetNode$1.invoke(serialDescriptor2, Integer.valueOf(i2))).booleanValue()) {
                                            jArr2[i] = j3;
                                            break;
                                        }
                                        j2 = -1;
                                    } else {
                                        jArr2[i] = j3;
                                        i = i4;
                                        j2 = -1;
                                    }
                                }
                            }
                        } else {
                            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j);
                            elementMarker2.lowerMarks |= 1 << iNumberOfTrailingZeros2;
                            if (((Boolean) focusableNode$focusTargetNode$1.invoke(serialDescriptor2, Integer.valueOf(iNumberOfTrailingZeros2))).booleanValue()) {
                                i2 = iNumberOfTrailingZeros2;
                                break;
                            }
                        }
                    }
                } else {
                    WriteModeKt.invalidTrailingComma$default(roomOpenHelper);
                    throw null;
                }
            }
        } else if (iOrdinal != 2) {
            boolean zTryConsumeComma3 = roomOpenHelper.tryConsumeComma();
            if (roomOpenHelper.canConsumeValue()) {
                int i6 = this.currentIndex;
                if (i6 != -1 && !zTryConsumeComma3) {
                    RoomOpenHelper.fail$default(roomOpenHelper, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                i2 = i6 + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma3) {
                WriteModeKt.invalidTrailingComma(roomOpenHelper, "array");
                throw null;
            }
        } else {
            int i7 = this.currentIndex;
            Object[] objArr = i7 % 2 != 0;
            if (objArr != true) {
                roomOpenHelper.consumeNextToken(':');
            } else if (i7 != -1) {
                zTryConsumeComma = roomOpenHelper.tryConsumeComma();
            }
            if (roomOpenHelper.canConsumeValue()) {
                if (objArr != false) {
                    if (this.currentIndex == -1) {
                        int i8 = roomOpenHelper.version;
                        if (zTryConsumeComma) {
                            RoomOpenHelper.fail$default(roomOpenHelper, "Unexpected leading comma", i8, null, 4);
                            throw null;
                        }
                    } else {
                        int i9 = roomOpenHelper.version;
                        if (!zTryConsumeComma) {
                            RoomOpenHelper.fail$default(roomOpenHelper, "Expected comma after the key-value pair", i9, null, 4);
                            throw null;
                        }
                    }
                }
                i2 = this.currentIndex + 1;
                this.currentIndex = i2;
            } else if (zTryConsumeComma) {
                WriteModeKt.invalidTrailingComma$default(roomOpenHelper);
                throw null;
            }
        }
        if (writeMode != WriteMode.MAP) {
            ((int[]) statusLine.message)[statusLine.code] = i2;
        }
        return i2;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor serialDescriptor) {
        RoomOpenHelper roomOpenHelper = this.lexer;
        return WriteModeKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, roomOpenHelper.consumeString(), " at path ".concat(((StatusLine) roomOpenHelper.configuration).getPath()));
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            float f = Float.parseFloat(strConsumeStringLenient);
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                return f;
            }
            RoomOpenHelper.fail$default(roomOpenHelper, "Unexpected special floating-point value " + Float.valueOf(f) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'float' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor serialDescriptor) {
        return StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : this;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        long jConsumeNumericLiteral = roomOpenHelper.consumeNumericLiteral();
        int i = (int) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == i) {
            return i;
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse int for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return new RealWeakMemoryCache(this.json.configuration, this.lexer).read();
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        if (!(jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull : false)) {
            RoomOpenHelper roomOpenHelper = this.lexer;
            int iPrefetchOrEof = roomOpenHelper.prefetchOrEof(roomOpenHelper.skipWhitespaces());
            String str = (String) roomOpenHelper.legacyHash;
            int length = str.length() - iPrefetchOrEof;
            boolean z = false;
            if (length >= 4 && iPrefetchOrEof != -1) {
                for (int i = 0; i < 4; i++) {
                    if ("null".charAt(i) == str.charAt(iPrefetchOrEof + i)) {
                    }
                }
                if (length <= 4 || WriteModeKt.charToTokenClass(str.charAt(iPrefetchOrEof + 4)) != 0) {
                    z = true;
                    roomOpenHelper.version = iPrefetchOrEof + 4;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, KSerializer kSerializer, Object obj) {
        StatusLine statusLine = (StatusLine) this.lexer.configuration;
        boolean z = this.mode == WriteMode.MAP && (i & 1) == 0;
        if (z) {
            int[] iArr = (int[]) statusLine.message;
            int i2 = statusLine.code;
            if (iArr[i2] == -2) {
                ((Object[]) statusLine.protocol)[i2] = JsonPath$Tombstone.INSTANCE;
            }
        }
        Object objDecodeSerializableValue = decodeSerializableValue(kSerializer);
        if (z) {
            int[] iArr2 = (int[]) statusLine.message;
            int i3 = statusLine.code;
            if (iArr2[i3] != -2) {
                int i4 = i3 + 1;
                statusLine.code = i4;
                Object[] objArr = (Object[]) statusLine.protocol;
                if (i4 == objArr.length) {
                    int i5 = i4 * 2;
                    statusLine.protocol = Arrays.copyOf(objArr, i5);
                    statusLine.message = Arrays.copyOf((int[]) statusLine.message, i5);
                }
            }
            Object[] objArr2 = (Object[]) statusLine.protocol;
            int i6 = statusLine.code;
            objArr2[i6] = objDecodeSerializableValue;
            ((int[]) statusLine.message)[i6] = -2;
        }
        return objDecodeSerializableValue;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0126  */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0127, please report this as an issue */
    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final Object decodeSerializableValue(KSerializer kSerializer) {
        Json json = this.json;
        RoomOpenHelper roomOpenHelper = this.lexer;
        StatusLine statusLine = (StatusLine) roomOpenHelper.configuration;
        try {
            if (!(kSerializer instanceof PolymorphicSerializer)) {
                return kSerializer.deserialize(this);
            }
            String strClassDiscriminator = WriteModeKt.classDiscriminator(((PolymorphicSerializer) kSerializer).getDescriptor(), json);
            String strPeekLeadingMatchingValue = roomOpenHelper.peekLeadingMatchingValue(strClassDiscriminator);
            String content = null;
            if (strPeekLeadingMatchingValue != null) {
                try {
                    KSerializer kSerializerFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((PolymorphicSerializer) kSerializer, this, strPeekLeadingMatchingValue);
                    Symbol symbol = new Symbol();
                    symbol.symbol = strClassDiscriminator;
                    this.discriminatorHolder = symbol;
                    return kSerializerFindPolymorphicSerializer.deserialize(this);
                } catch (SerializationException e) {
                    String strSubstringBefore$default = StringsKt.substringBefore$default(e.getMessage(), '\n');
                    if (StringsKt.endsWith$default(strSubstringBefore$default, ".")) {
                        strSubstringBefore$default = strSubstringBefore$default.substring(0, strSubstringBefore$default.length() - ".".length());
                    }
                    String message = e.getMessage();
                    String strSubstring = "";
                    int iIndexOf$default = StringsKt.indexOf$default(message, '\n', 0, 6);
                    if (iIndexOf$default != -1) {
                        strSubstring = message.substring(iIndexOf$default + 1, message.length());
                    }
                    RoomOpenHelper.fail$default(roomOpenHelper, strSubstringBefore$default, 0, strSubstring, 2);
                    throw null;
                }
            }
            String strClassDiscriminator2 = WriteModeKt.classDiscriminator(((PolymorphicSerializer) kSerializer).getDescriptor(), json);
            JsonElement jsonElementDecodeJsonElement = decodeJsonElement();
            String serialName = ((PolymorphicSerializer) kSerializer).getDescriptor().getSerialName();
            if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
                throw WriteModeKt.JsonDecodingException(-1, jsonElementDecodeJsonElement.toString(), "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + statusLine.getPath());
            }
            JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
            JsonElement jsonElement = (JsonElement) jsonObject.get(strClassDiscriminator2);
            if (jsonElement != null) {
                JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
                if (!(jsonPrimitive instanceof JsonNull)) {
                    content = jsonPrimitive.getContent();
                }
            }
            try {
                KSerializer kSerializerFindPolymorphicSerializer2 = PolymorphicSerializerKt.findPolymorphicSerializer((PolymorphicSerializer) kSerializer, this, content);
                return new JsonTreeDecoder(json, jsonObject, strClassDiscriminator2, kSerializerFindPolymorphicSerializer2.getDescriptor()).decodeSerializableValue(kSerializerFindPolymorphicSerializer2);
            } catch (SerializationException e2) {
                throw WriteModeKt.JsonDecodingException(-1, jsonObject.toString(), e2.getMessage());
            }
            if (StringsKt.contains(e.getMessage(), "at path", false)) {
                throw e;
            }
            throw new MissingFieldException(e.missingFields, e.getMessage() + " at path: " + statusLine.getPath(), e);
        } catch (MissingFieldException e3) {
            if (StringsKt.contains(e3.getMessage(), "at path", false)) {
                throw e3;
            }
            throw new MissingFieldException(e3.missingFields, e3.getMessage() + " at path: " + statusLine.getPath(), e3);
        }
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        long jConsumeNumericLiteral = roomOpenHelper.consumeNumericLiteral();
        short s = (short) jConsumeNumericLiteral;
        if (jConsumeNumericLiteral == s) {
            return s;
        }
        RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse short for input '" + jConsumeNumericLiteral + '\'', 0, null, 6);
        throw null;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return this.lexer.consumeString();
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.CompositeDecoder
    public final void endStructure(SerialDescriptor serialDescriptor) {
        if (this.json.configuration.ignoreUnknownKeys && serialDescriptor.getElementsCount() == 0) {
            while (decodeElementIndex(serialDescriptor) != -1) {
            }
        }
        RoomOpenHelper roomOpenHelper = this.lexer;
        if (roomOpenHelper.tryConsumeComma()) {
            WriteModeKt.invalidTrailingComma(roomOpenHelper, "");
            throw null;
        }
        roomOpenHelper.consumeNextToken(this.mode.end);
        StatusLine statusLine = (StatusLine) roomOpenHelper.configuration;
        int i = statusLine.code;
        int[] iArr = (int[]) statusLine.message;
        if (iArr[i] == -2) {
            iArr[i] = -1;
            statusLine.code = i - 1;
        }
        int i2 = statusLine.code;
        if (i2 != -1) {
            statusLine.code = i2 - 1;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Request getSerializersModule() {
        return this.serializersModule;
    }
}
