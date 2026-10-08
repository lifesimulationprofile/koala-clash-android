package androidx.compose.material3;

import android.os.Build;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.BackHandlerKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.MotionDurationScaleImpl;
import androidx.lifecycle.Lifecycle;
import androidx.work.impl.StartStopTokens;
import dev.chrisbanes.haze.HazeArea;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetKt$BottomSheet$4$1$1 implements FlowCollector {
    public final /* synthetic */ Object $predictiveBackProgress;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BottomSheetKt$BottomSheet$4$1$1(int i, Object obj) {
        this.$r8$classId = i;
        this.$predictiveBackProgress = obj;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                Object objSnapTo = ((Animatable) this.$predictiveBackProgress).snapTo(new Float(BackHandlerKt.PredictiveBackEasing.transform(((BackEventCompat) obj).progress)), continuation);
                return objSnapTo == CoroutineSingletons.COROUTINE_SUSPENDED ? objSnapTo : Unit.INSTANCE;
            case 1:
                StartStopTokens startStopTokens = (StartStopTokens) this.$predictiveBackProgress;
                if (Build.VERSION.SDK_INT >= 34) {
                    startStopTokens.getImm().startStylusHandwriting((View) startStopTokens.runs);
                }
                return Unit.INSTANCE;
            case 2:
                Interaction interaction = (Interaction) obj;
                SnapshotStateList snapshotStateList = (SnapshotStateList) this.$predictiveBackProgress;
                if (interaction instanceof HoverInteraction$Enter) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof HoverInteraction$Exit) {
                    snapshotStateList.remove(((HoverInteraction$Exit) interaction).enter);
                } else if (interaction instanceof FocusInteraction$Focus) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof FocusInteraction$Unfocus) {
                    snapshotStateList.remove(((FocusInteraction$Unfocus) interaction).focus);
                } else if (interaction instanceof PressInteraction.Press) {
                    snapshotStateList.add(interaction);
                } else if (interaction instanceof PressInteraction.Release) {
                    snapshotStateList.remove(((PressInteraction.Release) interaction).press);
                } else if (interaction instanceof PressInteraction.Cancel) {
                    snapshotStateList.remove(((PressInteraction.Cancel) interaction).press);
                }
                return Unit.INSTANCE;
            case 3:
                ((MotionDurationScaleImpl) this.$predictiveBackProgress)._scaleFactor$delegate.setFloatValue(((Number) obj).floatValue());
                return Unit.INSTANCE;
            case 4:
                if (((Lifecycle.State) obj).compareTo(Lifecycle.State.CREATED) <= 0) {
                    HazeSourceNode hazeSourceNode = (HazeSourceNode) this.$predictiveBackProgress;
                    HazeArea hazeArea = hazeSourceNode.area;
                    GraphicsLayer contentLayer = hazeArea.getContentLayer();
                    if (contentLayer != null) {
                        ((GraphicsContext) HitTestResultKt.currentValueOf(hazeSourceNode, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(contentLayer);
                    }
                    hazeArea.contentLayer$delegate.setValue(null);
                }
                return Unit.INSTANCE;
            default:
                ((Ref$ObjectRef) this.$predictiveBackProgress).element = obj;
                throw new AbortFlowException(this);
        }
    }
}
