package kotlinx.serialization.internal;

import kotlin.Unit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UnitSerializer implements KSerializer {
    public static final UnitSerializer INSTANCE = new UnitSerializer();
    public final /* synthetic */ EnumSerializer $$delegate_0 = new EnumSerializer(Unit.INSTANCE);

    @Override // kotlinx.serialization.KSerializer
    public final Object deserialize(Decoder decoder) {
        this.$$delegate_0.deserialize(decoder);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.KSerializer
    public final SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.KSerializer
    public final void serialize(Encoder encoder, Object obj) {
        this.$$delegate_0.serialize(encoder, (Unit) obj);
    }
}
