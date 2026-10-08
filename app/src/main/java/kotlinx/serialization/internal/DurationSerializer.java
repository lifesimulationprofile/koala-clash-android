package kotlinx.serialization.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DurationSerializer implements KSerializer {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.INT.INSTANCE$8);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        int i = Duration.$r8$clinit;
        String strDecodeString = decoder.decodeString();
        try {
            return new Duration(DurationKt.access$parseDuration(strDecodeString));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid ISO duration string format: '", strDecodeString, "'."), e);
        }
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        long j = ((Duration) obj).rawValue;
        int i = Duration.$r8$clinit;
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append('-');
        }
        sb.append("PT");
        long jM846unaryMinusUwyO8pc = j < 0 ? Duration.m846unaryMinusUwyO8pc(j) : j;
        long jM845toLongimpl = Duration.m845toLongimpl(jM846unaryMinusUwyO8pc, DurationUnit.HOURS);
        boolean z = false;
        int iM845toLongimpl = Duration.m843isInfiniteimpl(jM846unaryMinusUwyO8pc) ? 0 : (int) (Duration.m845toLongimpl(jM846unaryMinusUwyO8pc, DurationUnit.MINUTES) % ((long) 60));
        int iM845toLongimpl2 = Duration.m843isInfiniteimpl(jM846unaryMinusUwyO8pc) ? 0 : (int) (Duration.m845toLongimpl(jM846unaryMinusUwyO8pc, DurationUnit.SECONDS) % ((long) 60));
        int iM842getNanosecondsComponentimpl = Duration.m842getNanosecondsComponentimpl(jM846unaryMinusUwyO8pc);
        if (Duration.m843isInfiniteimpl(j)) {
            jM845toLongimpl = 9999999999999L;
        }
        boolean z2 = jM845toLongimpl != 0;
        boolean z3 = (iM845toLongimpl2 == 0 && iM842getNanosecondsComponentimpl == 0) ? false : true;
        if (iM845toLongimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jM845toLongimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(iM845toLongimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            Duration.m841appendFractionalimpl(sb, iM845toLongimpl2, iM842getNanosecondsComponentimpl, 9, "S", true);
        }
        encoder.encodeString(sb.toString());
    }
}
