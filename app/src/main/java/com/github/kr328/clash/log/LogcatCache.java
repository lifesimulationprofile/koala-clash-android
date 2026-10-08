package com.github.kr328.clash.log;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.CircularArray;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.emoji2.text.EmojiCompat;
import com.caverock.androidsvg.NumberParser;
import com.caverock.androidsvg.SVG;
import com.github.kr328.clash.core.model.LogMessage;
import com.google.android.gms.internal.mlkit_vision_barcode.zztu;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class LogcatCache implements SVG.PathInterface {
    public final /* synthetic */ int $r8$classId;
    public int appended;
    public Object array;
    public Object lock;
    public int removed;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Snapshot {
        public final int appended;
        public final ArrayList messages;
        public final int removed;

        public Snapshot(ArrayList arrayList, int i, int i2) {
            this.messages = arrayList;
            this.removed = i;
            this.appended = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) obj;
            return this.messages.equals(snapshot.messages) && this.removed == snapshot.removed && this.appended == snapshot.appended;
        }

        public final int hashCode() {
            return (((this.messages.hashCode() * 31) + this.removed) * 31) + this.appended;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Snapshot(messages=");
            sb.append(this.messages);
            sb.append(", removed=");
            sb.append(this.removed);
            sb.append(", appended=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.appended, ")");
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.log.LogcatCache$append$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public LogcatCache L$0;
        public LogMessage L$1;
        public MutexImpl L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogcatCache.this.append(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.log.LogcatCache$snapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00241 extends ContinuationImpl {
        public LogcatCache L$0;
        public MutexImpl L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00241(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogcatCache.this.snapshot(false, this);
        }
    }

    public /* synthetic */ LogcatCache(int i) {
        this.$r8$classId = i;
    }

    public static boolean isWhitespace(int i) {
        return i == 32 || i == 10 || i == 13 || i == 9;
    }

    public void addCommand(byte b) {
        int i = this.removed;
        byte[] bArr = (byte[]) this.array;
        if (i == bArr.length) {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.array = bArr2;
        }
        byte[] bArr3 = (byte[]) this.array;
        int i2 = this.removed;
        this.removed = i2 + 1;
        bArr3[i2] = b;
    }

    public int advanceChar() {
        int i = this.removed;
        int i2 = this.appended;
        if (i == i2) {
            return -1;
        }
        int i3 = i + 1;
        this.removed = i3;
        if (i3 < i2) {
            return ((String) this.array).charAt(i3);
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object append(LogMessage logMessage, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        LogcatCache logcatCache;
        LogMessage logMessage2;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = (MutexImpl) this.lock;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = logMessage;
            anonymousClass1.L$2 = mutexImpl2;
            anonymousClass1.label = 1;
            Object objLock = mutexImpl2.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            logcatCache = this;
            logMessage2 = logMessage;
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutexImpl = anonymousClass1.L$2;
            logMessage2 = anonymousClass1.L$1;
            logcatCache = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            CircularArray circularArray = (CircularArray) logcatCache.array;
            if (circularArray.size() >= 128) {
                circularArray.removeFromStart();
                logcatCache.removed++;
                logcatCache.appended--;
            }
            circularArray.addLast(logMessage2);
            logcatCache.appended++;
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        addCommand((byte) ((z ? 2 : 0) | 4 | (z2 ? 1 : 0)));
        coordsEnsure(5);
        float[] fArr = (float[]) this.lock;
        int i = this.appended;
        int i2 = i + 1;
        this.appended = i2;
        fArr[i] = f;
        int i3 = i + 2;
        this.appended = i3;
        fArr[i2] = f2;
        int i4 = i + 3;
        this.appended = i4;
        fArr[i3] = f3;
        int i5 = i + 4;
        this.appended = i5;
        fArr[i4] = f4;
        this.appended = i + 5;
        fArr[i5] = f5;
    }

    public void checkOffsetIsValid(int i) {
        int i2 = this.removed;
        int i3 = this.appended;
        boolean z = false;
        if (i <= i3 && i2 <= i) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Invalid offset: " + i + ". Valid range is [" + i2 + " , " + i3 + ']');
    }

    public Boolean checkedNextFlag(Object obj) {
        if (obj == null) {
            return null;
        }
        skipCommaWhitespace();
        int i = this.removed;
        if (i == this.appended) {
            return null;
        }
        char cCharAt = ((String) this.array).charAt(i);
        if (cCharAt != '0' && cCharAt != '1') {
            return null;
        }
        this.removed++;
        return Boolean.valueOf(cCharAt == '1');
    }

    public float checkedNextFloat(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        skipCommaWhitespace();
        return nextFloat();
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void close() {
        addCommand((byte) 8);
    }

    public boolean consume(char c) {
        int i = this.removed;
        boolean z = i < this.appended && ((String) this.array).charAt(i) == c;
        if (z) {
            this.removed++;
        }
        return z;
    }

    public void coordsEnsure(int i) {
        float[] fArr = (float[]) this.lock;
        if (fArr.length < this.appended + i) {
            float[] fArr2 = new float[fArr.length * 2];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.lock = fArr2;
        }
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        addCommand((byte) 2);
        coordsEnsure(6);
        float[] fArr = (float[]) this.lock;
        int i = this.appended;
        int i2 = i + 1;
        this.appended = i2;
        fArr[i] = f;
        int i3 = i + 2;
        this.appended = i3;
        fArr[i2] = f2;
        int i4 = i + 3;
        this.appended = i4;
        fArr[i3] = f3;
        int i5 = i + 4;
        this.appended = i5;
        fArr[i4] = f4;
        int i6 = i + 5;
        this.appended = i6;
        fArr[i5] = f5;
        this.appended = i + 6;
        fArr[i6] = f6;
    }

    public boolean empty() {
        return this.removed == this.appended;
    }

    public void enumeratePath(SVG.PathInterface pathInterface) {
        int i = 0;
        for (int i2 = 0; i2 < this.removed; i2++) {
            byte b = ((byte[]) this.array)[i2];
            if (b == 0) {
                float[] fArr = (float[]) this.lock;
                int i3 = i + 1;
                float f = fArr[i];
                i += 2;
                pathInterface.moveTo(f, fArr[i3]);
            } else if (b == 1) {
                float[] fArr2 = (float[]) this.lock;
                int i4 = i + 1;
                float f2 = fArr2[i];
                i += 2;
                pathInterface.lineTo(f2, fArr2[i4]);
            } else if (b == 2) {
                float[] fArr3 = (float[]) this.lock;
                pathInterface.cubicTo(fArr3[i], fArr3[i + 1], fArr3[i + 2], fArr3[i + 3], fArr3[i + 4], fArr3[i + 5]);
                i += 6;
            } else if (b == 3) {
                float[] fArr4 = (float[]) this.lock;
                float f3 = fArr4[i];
                float f4 = fArr4[i + 1];
                int i5 = i + 3;
                float f5 = fArr4[i + 2];
                i += 4;
                pathInterface.quadTo(f3, f4, f5, fArr4[i5]);
            } else if (b != 8) {
                boolean z = (b & 2) != 0;
                boolean z2 = (b & 1) != 0;
                float[] fArr5 = (float[]) this.lock;
                pathInterface.arcTo(fArr5[i], fArr5[i + 1], fArr5[i + 2], z, z2, fArr5[i + 3], fArr5[i + 4]);
                i += 5;
            } else {
                pathInterface.close();
            }
        }
    }

    public int getLength() {
        CircularArray circularArray = (CircularArray) this.lock;
        if (circularArray == null) {
            return ((String) this.array).length();
        }
        return (circularArray.head - circularArray.gapLength()) + (((String) this.array).length() - (this.appended - this.removed));
    }

    public boolean isAfterLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = this.removed + 1;
        if (i > this.appended || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointBefore(charSequence, i))) {
            int i3 = i - 1;
            if (!Character.isSurrogate(charSequence.charAt(i3))) {
                if (!EmojiCompat.isConfigured()) {
                    return false;
                }
                EmojiCompat emojiCompat = EmojiCompat.get();
                if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i3) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAfterPunctuation(int i) {
        int i2 = this.removed + 1;
        if (i > this.appended || i2 > i) {
            return false;
        }
        return zztu.isPunctuation$ui_text(Character.codePointBefore((CharSequence) this.array, i));
    }

    public boolean isBoundary(int i) {
        checkOffsetIsValid(i);
        if (!((BreakIterator) this.lock).isBoundary(i)) {
            return false;
        }
        if (isOnLetterOrDigitOrEmoji(i) && isOnLetterOrDigitOrEmoji(i - 1) && isOnLetterOrDigitOrEmoji(i + 1)) {
            return false;
        }
        return i <= 0 || i >= ((CharSequence) this.array).length() - 1 || !(isHiraganaKatakanaBoundary(i) || isHiraganaKatakanaBoundary(i + 1));
    }

    public boolean isHiraganaKatakanaBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = i - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(charSequence.charAt(i2));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (Intrinsics.areEqual(unicodeBlockOf, unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i2)), Character.UnicodeBlock.KATAKANA);
    }

    public boolean isOnLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = this.removed;
        if (i >= this.appended || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointAt(charSequence, i)) && !Character.isSurrogate(charSequence.charAt(i))) {
            if (!EmojiCompat.isConfigured()) {
                return false;
            }
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnPunctuation(int i) {
        int i2 = this.removed;
        if (i >= this.appended || i2 > i) {
            return false;
        }
        return zztu.isPunctuation$ui_text(Character.codePointAt((CharSequence) this.array, i));
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void lineTo(float f, float f2) {
        addCommand((byte) 1);
        coordsEnsure(2);
        float[] fArr = (float[]) this.lock;
        int i = this.appended;
        int i2 = i + 1;
        this.appended = i2;
        fArr[i] = f;
        this.appended = i + 2;
        fArr[i2] = f2;
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void moveTo(float f, float f2) {
        addCommand((byte) 0);
        coordsEnsure(2);
        float[] fArr = (float[]) this.lock;
        int i = this.appended;
        int i2 = i + 1;
        this.appended = i2;
        fArr[i] = f;
        this.appended = i + 2;
        fArr[i2] = f2;
    }

    public int nextBoundary(int i) {
        checkOffsetIsValid(i);
        int iFollowing = ((BreakIterator) this.lock).following(i);
        return (isOnLetterOrDigitOrEmoji(iFollowing + (-1)) && isOnLetterOrDigitOrEmoji(iFollowing) && !isHiraganaKatakanaBoundary(iFollowing)) ? nextBoundary(iFollowing) : iFollowing;
    }

    public Integer nextChar() {
        int i = this.removed;
        if (i == this.appended) {
            return null;
        }
        String str = (String) this.array;
        this.removed = i + 1;
        return Integer.valueOf(str.charAt(i));
    }

    public float nextFloat() {
        NumberParser numberParser = (NumberParser) this.lock;
        float number = numberParser.parseNumber(this.removed, this.appended, (String) this.array);
        if (!Float.isNaN(number)) {
            this.removed = numberParser.pos;
        }
        return number;
    }

    public SVG.Length nextLength() {
        float fNextFloat = nextFloat();
        if (Float.isNaN(fNextFloat)) {
            return null;
        }
        int iNextUnit = nextUnit();
        return iNextUnit == 0 ? new SVG.Length(1, fNextFloat) : new SVG.Length(iNextUnit, fNextFloat);
    }

    public String nextQuotedString() {
        String str = (String) this.array;
        if (empty()) {
            return null;
        }
        int i = this.removed;
        char cCharAt = str.charAt(i);
        if (cCharAt != '\'' && cCharAt != '\"') {
            return null;
        }
        int iAdvanceChar = advanceChar();
        while (iAdvanceChar != -1 && iAdvanceChar != cCharAt) {
            iAdvanceChar = advanceChar();
        }
        if (iAdvanceChar == -1) {
            this.removed = i;
            return null;
        }
        int i2 = this.removed;
        this.removed = i2 + 1;
        return str.substring(i + 1, i2);
    }

    public String nextToken() {
        return nextToken(' ', false);
    }

    public int nextUnit() {
        String str = (String) this.array;
        if (empty()) {
            return 0;
        }
        if (str.charAt(this.removed) == '%') {
            this.removed++;
            return 9;
        }
        int i = this.removed;
        if (i > this.appended - 2) {
            return 0;
        }
        try {
            int iValueOf$1 = Density.CC.valueOf$1(str.substring(i, i + 2).toLowerCase(Locale.US));
            this.removed += 2;
            return iValueOf$1;
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public float possibleNextFloat() {
        skipCommaWhitespace();
        NumberParser numberParser = (NumberParser) this.lock;
        float number = numberParser.parseNumber(this.removed, this.appended, (String) this.array);
        if (!Float.isNaN(number)) {
            this.removed = numberParser.pos;
        }
        return number;
    }

    public int prevBoundary(int i) {
        checkOffsetIsValid(i);
        int iPreceding = ((BreakIterator) this.lock).preceding(i);
        return (isOnLetterOrDigitOrEmoji(iPreceding) && isAfterLetterOrDigitOrEmoji(iPreceding) && !isHiraganaKatakanaBoundary(iPreceding)) ? prevBoundary(iPreceding) : iPreceding;
    }

    @Override // com.caverock.androidsvg.SVG.PathInterface
    public void quadTo(float f, float f2, float f3, float f4) {
        addCommand((byte) 3);
        coordsEnsure(4);
        float[] fArr = (float[]) this.lock;
        int i = this.appended;
        int i2 = i + 1;
        this.appended = i2;
        fArr[i] = f;
        int i3 = i + 2;
        this.appended = i3;
        fArr[i2] = f2;
        int i4 = i + 3;
        this.appended = i4;
        fArr[i3] = f3;
        this.appended = i + 4;
        fArr[i4] = f4;
    }

    public void replace(int i, int i2, String str) {
        if (i > i2) {
            InlineClassHelperKt.throwIllegalArgumentException("start index must be less than or equal to end index: " + i + " > " + i2);
        }
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + i);
        }
        CircularArray circularArray = (CircularArray) this.lock;
        if (circularArray == null) {
            int iMax = Math.max(255, str.length() + 128);
            char[] cArr = new char[iMax];
            int iMin = Math.min(i, 64);
            int iMin2 = Math.min(((String) this.array).length() - i2, 64);
            int i3 = i - iMin;
            ((String) this.array).getChars(i3, i, cArr, 0);
            int i4 = iMax - iMin2;
            int i5 = iMin2 + i2;
            ((String) this.array).getChars(i2, i5, cArr, i4);
            str.getChars(0, str.length(), cArr, iMin);
            int length = str.length() + iMin;
            CircularArray circularArray2 = new CircularArray(2);
            circularArray2.head = iMax;
            circularArray2.elements = cArr;
            circularArray2.tail = length;
            circularArray2.capacityBitmask = i4;
            this.lock = circularArray2;
            this.removed = i3;
            this.appended = i5;
            return;
        }
        int i6 = this.removed;
        int i7 = i - i6;
        int i8 = i2 - i6;
        if (i7 < 0 || i8 > circularArray.head - circularArray.gapLength()) {
            this.array = toString();
            this.lock = null;
            this.removed = -1;
            this.appended = -1;
            replace(i, i2, str);
            return;
        }
        int length2 = str.length() - (i8 - i7);
        if (length2 > circularArray.gapLength()) {
            int iGapLength = length2 - circularArray.gapLength();
            int i9 = circularArray.head;
            do {
                i9 *= 2;
            } while (i9 - circularArray.head < iGapLength);
            char[] cArr2 = new char[i9];
            System.arraycopy((char[]) circularArray.elements, 0, cArr2, 0, circularArray.tail);
            int i10 = circularArray.head;
            int i11 = circularArray.capacityBitmask;
            int i12 = i10 - i11;
            int i13 = i9 - i12;
            System.arraycopy((char[]) circularArray.elements, i11, cArr2, i13, (i12 + i11) - i11);
            circularArray.elements = cArr2;
            circularArray.head = i9;
            circularArray.capacityBitmask = i13;
        }
        int i14 = circularArray.tail;
        if (i7 < i14 && i8 <= i14) {
            int i15 = i14 - i8;
            char[] cArr3 = (char[]) circularArray.elements;
            System.arraycopy(cArr3, i8, cArr3, circularArray.capacityBitmask - i15, i15);
            circularArray.tail = i7;
            circularArray.capacityBitmask -= i15;
        } else if (i7 >= i14 || i8 < i14) {
            int iGapLength2 = circularArray.gapLength() + i7;
            int iGapLength3 = circularArray.gapLength() + i8;
            int i16 = circularArray.capacityBitmask;
            int i17 = iGapLength2 - i16;
            char[] cArr4 = (char[]) circularArray.elements;
            System.arraycopy(cArr4, i16, cArr4, circularArray.tail, i17);
            circularArray.tail += i17;
            circularArray.capacityBitmask = iGapLength3;
        } else {
            circularArray.capacityBitmask = circularArray.gapLength() + i8;
            circularArray.tail = i7;
        }
        str.getChars(0, str.length(), (char[]) circularArray.elements, circularArray.tail);
        circularArray.tail = str.length() + circularArray.tail;
    }

    public boolean skipCommaWhitespace() {
        skipWhitespace();
        int i = this.removed;
        if (i == this.appended || ((String) this.array).charAt(i) != ',') {
            return false;
        }
        this.removed++;
        skipWhitespace();
        return true;
    }

    public void skipWhitespace() {
        while (true) {
            int i = this.removed;
            if (i >= this.appended || !isWhitespace(((String) this.array).charAt(i))) {
                return;
            } else {
                this.removed++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005c A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x006f A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0075 A[Catch: all -> 0x005a, LOOP:0: B:28:0x006b->B:32:0x0075, LOOP_END, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0096 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009e A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object snapshot(boolean z, ContinuationImpl continuationImpl) {
        C00241 c00241;
        MutexImpl mutexImpl;
        LogcatCache logcatCache;
        Snapshot snapshot;
        CircularArray circularArray;
        int size;
        ArrayList arrayList;
        int i;
        int size2;
        if (continuationImpl instanceof C00241) {
            c00241 = (C00241) continuationImpl;
            int i2 = c00241.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c00241.label = i2 - Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuationImpl);
            }
        } else {
            c00241 = new C00241(continuationImpl);
        }
        Object obj = c00241.result;
        int i3 = c00241.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = (MutexImpl) this.lock;
            c00241.L$0 = this;
            c00241.L$1 = mutexImpl;
            c00241.Z$0 = z;
            c00241.label = 1;
            Object objLock = mutexImpl.lock(c00241);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            logcatCache = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c00241.Z$0;
            mutexImpl = c00241.L$1;
            logcatCache = c00241.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (z) {
            circularArray = (CircularArray) logcatCache.array;
            size = circularArray.size();
            arrayList = new ArrayList(size);
            for (i = 0; i < size; i++) {
                if (i >= 0) {
                    circularArray.getClass();
                } else if (i < circularArray.size()) {
                    arrayList.add((LogMessage) ((Object[]) circularArray.elements)[(circularArray.head + i) & circularArray.capacityBitmask]);
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = logcatCache.removed;
            if (z) {
                size2 = circularArray.size() + logcatCache.appended;
            } else {
                size2 = logcatCache.appended;
            }
            snapshot = new Snapshot(arrayList, i4, size2);
            logcatCache.removed = 0;
            logcatCache.appended = 0;
        } else {
            try {
                if (logcatCache.removed == 0 && logcatCache.appended == 0) {
                    snapshot = null;
                } else {
                    circularArray = (CircularArray) logcatCache.array;
                    size = circularArray.size();
                    arrayList = new ArrayList(size);
                    while (i < size) {
                        if (i >= 0) {
                            circularArray.getClass();
                        } else if (i < circularArray.size()) {
                            arrayList.add((LogMessage) ((Object[]) circularArray.elements)[(circularArray.head + i) & circularArray.capacityBitmask]);
                        }
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    int i5 = logcatCache.removed;
                    if (z) {
                        size2 = circularArray.size() + logcatCache.appended;
                    } else {
                        size2 = logcatCache.appended;
                    }
                    snapshot = new Snapshot(arrayList, i5, size2);
                    logcatCache.removed = 0;
                    logcatCache.appended = 0;
                }
            } catch (Throwable th) {
                mutexImpl.unlock(null);
                throw th;
            }
        }
        mutexImpl.unlock(null);
        return snapshot;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                CircularArray circularArray = (CircularArray) this.lock;
                if (circularArray == null) {
                    return (String) this.array;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) this.array, 0, this.removed);
                sb.append((char[]) circularArray.elements, 0, circularArray.tail);
                char[] cArr = (char[]) circularArray.elements;
                int i = circularArray.capacityBitmask;
                sb.append(cArr, i, circularArray.head - i);
                String str = (String) this.array;
                sb.append((CharSequence) str, this.appended, str.length());
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public LogcatCache() {
        this.$r8$classId = 0;
        CircularArray circularArray = new CircularArray(0);
        int iHighestOneBit = Integer.bitCount(128) != 1 ? Integer.highestOneBit(127) << 1 : 128;
        circularArray.capacityBitmask = iHighestOneBit - 1;
        circularArray.elements = new Object[iHighestOneBit];
        this.array = circularArray;
        this.lock = new MutexImpl();
    }

    public String nextToken(char c, boolean z) {
        String str = (String) this.array;
        if (empty()) {
            return null;
        }
        char cCharAt = str.charAt(this.removed);
        if ((!z && isWhitespace(cCharAt)) || cCharAt == c) {
            return null;
        }
        int i = this.removed;
        int iAdvanceChar = advanceChar();
        while (iAdvanceChar != -1 && iAdvanceChar != c && (z || !isWhitespace(iAdvanceChar))) {
            iAdvanceChar = advanceChar();
        }
        return str.substring(i, this.removed);
    }

    public boolean consume(String str) {
        int length = str.length();
        int i = this.removed;
        boolean z = i <= this.appended - length && ((String) this.array).substring(i, i + length).equals(str);
        if (z) {
            this.removed += length;
        }
        return z;
    }

    public LogcatCache(CharSequence charSequence, int i, Locale locale) {
        this.$r8$classId = 1;
        this.array = charSequence;
        if (charSequence.length() < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }
        if (i < 0 || i > charSequence.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.lock = wordInstance;
        this.removed = Math.max(0, -50);
        this.appended = Math.min(charSequence.length(), i + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i));
    }

    public LogcatCache(String str) {
        this.$r8$classId = 4;
        this.removed = 0;
        this.appended = 0;
        this.lock = new NumberParser();
        String strTrim = str.trim();
        this.array = strTrim;
        this.appended = strTrim.length();
    }
}
