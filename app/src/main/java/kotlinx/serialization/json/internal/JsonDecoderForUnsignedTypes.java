package kotlinx.serialization.json.internal;

import androidx.compose.material.icons.filled.EditKt;
import androidx.room.RoomOpenHelper;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class JsonDecoderForUnsignedTypes extends EditKt {
    public final RoomOpenHelper lexer;
    public final Request serializersModule;

    public JsonDecoderForUnsignedTypes(RoomOpenHelper roomOpenHelper, Json json) {
        this.lexer = roomOpenHelper;
        this.serializersModule = json.serializersModule;
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        UByte uByte;
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                int i = uIntOrNull.data;
                uByte = Integer.compare(Integer.MIN_VALUE ^ i, -2147483393) > 0 ? null : new UByte((byte) i);
            }
            if (uByte != null) {
                return uByte.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'UByte' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor serialDescriptor) {
        throw new IllegalStateException("unsupported");
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                return uIntOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'UInt' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            ULong uLongOrNull = UStringsKt.toULongOrNull(strConsumeStringLenient);
            if (uLongOrNull != null) {
                return uLongOrNull.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'ULong' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // androidx.compose.material.icons.filled.EditKt, kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        UShort uShort;
        RoomOpenHelper roomOpenHelper = this.lexer;
        String strConsumeStringLenient = roomOpenHelper.consumeStringLenient();
        try {
            UInt uIntOrNull = UStringsKt.toUIntOrNull(strConsumeStringLenient);
            if (uIntOrNull != null) {
                int i = uIntOrNull.data;
                uShort = Integer.compare(Integer.MIN_VALUE ^ i, -2147418113) > 0 ? null : new UShort((short) i);
            }
            if (uShort != null) {
                return uShort.data;
            }
            StringsKt__StringsJVMKt.numberFormatError(strConsumeStringLenient);
            throw null;
        } catch (IllegalArgumentException unused) {
            RoomOpenHelper.fail$default(roomOpenHelper, "Failed to parse type 'UShort' for input '" + strConsumeStringLenient + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Request getSerializersModule() {
        return this.serializersModule;
    }
}
