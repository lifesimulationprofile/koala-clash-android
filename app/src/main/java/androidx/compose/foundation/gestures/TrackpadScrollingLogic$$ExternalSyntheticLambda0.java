package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TrackpadScrollingLogic$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Channel f$0;

    public /* synthetic */ TrackpadScrollingLogic$$ExternalSyntheticLambda0(Channel channel, int i) {
        this.$r8$classId = i;
        this.f$0 = channel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return (TrackpadScrollingLogic.TrackpadScrollDelta) ChannelResult.m852getOrNullimpl(this.f$0.mo850tryReceivePtdJZtk());
            default:
                return (MouseWheelScrollingLogic.MouseWheelScrollDelta) ChannelResult.m852getOrNullimpl(this.f$0.mo850tryReceivePtdJZtk());
        }
    }
}
