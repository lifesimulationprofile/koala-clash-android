package androidx.compose.foundation.text.input.internal;

import android.view.View;
import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.work.impl.StartStopTokens;
import coil.RealImageLoader$execute$3;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidLegacyPlatformTextInputServiceAdapter implements PlatformTextInputService {
    public SharedFlowImpl backingStylusHandwritingTrigger;
    public LegacyTextInputMethodRequest currentRequest;
    public StandaloneCoroutine job;
    public LegacyAdaptingPlatformTextInputModifierNode textInputModifierNode;

    public final MutableSharedFlow getStylusHandwritingTrigger() {
        SharedFlowImpl sharedFlowImpl = this.backingStylusHandwritingTrigger;
        if (sharedFlowImpl != null) {
            return sharedFlowImpl;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported) {
            return null;
        }
        SharedFlowImpl sharedFlowImplMutableSharedFlow$default = FlowKt.MutableSharedFlow$default(3, 2);
        this.backingStylusHandwritingTrigger = sharedFlowImplMutableSharedFlow$default;
        return sharedFlowImplMutableSharedFlow$default;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void hideSoftwareKeyboard() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null || (softwareKeyboardController = (SoftwareKeyboardController) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalSoftwareKeyboardController)) == null) {
            return;
        }
        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void notifyFocusedRect(Rect rect) {
        android.graphics.Rect rect2;
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.focusedRect = new android.graphics.Rect(MathKt.roundToInt(rect.left), MathKt.roundToInt(rect.top), MathKt.roundToInt(rect.right), MathKt.roundToInt(rect.bottom));
            if (!legacyTextInputMethodRequest.ics.isEmpty() || (rect2 = legacyTextInputMethodRequest.focusedRect) == null) {
                return;
            }
            legacyTextInputMethodRequest.view.requestRectangleOnScreen(new android.graphics.Rect(rect2));
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void showSoftwareKeyboard() {
        SoftwareKeyboardController softwareKeyboardController;
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null || (softwareKeyboardController = (SoftwareKeyboardController) HitTestResultKt.currentValueOf(legacyAdaptingPlatformTextInputModifierNode, CompositionLocalsKt.LocalSoftwareKeyboardController)) == null) {
            return;
        }
        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
    }

    public final void startInput(ActivityResultRegistryKt$$ExternalSyntheticLambda1 activityResultRegistryKt$$ExternalSyntheticLambda1) {
        LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode = this.textInputModifierNode;
        if (legacyAdaptingPlatformTextInputModifierNode == null) {
            return;
        }
        StandaloneCoroutine standaloneCoroutine = null;
        this.job = legacyAdaptingPlatformTextInputModifierNode.isAttached ? JobKt.launch$default(legacyAdaptingPlatformTextInputModifierNode.getCoroutineScope(), null, new RealImageLoader$execute$3(legacyAdaptingPlatformTextInputModifierNode, new NavHostKt$NavHost$29$1(activityResultRegistryKt$$ExternalSyntheticLambda1, this, legacyAdaptingPlatformTextInputModifierNode, standaloneCoroutine, 4), standaloneCoroutine, 15), 1) : null;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void stopInput() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.job = null;
        MutableSharedFlow stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            SharedFlowImpl sharedFlowImpl = (SharedFlowImpl) stylusHandwritingTrigger;
            synchronized (sharedFlowImpl) {
                sharedFlowImpl.updateBufferLocked(sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize), sharedFlowImpl.minCollectorIndex, sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize), sharedFlowImpl.getHead() + ((long) sharedFlowImpl.bufferSize) + ((long) sharedFlowImpl.queueSize));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void unregisterModifier(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode) {
        if (this.textInputModifierNode != legacyAdaptingPlatformTextInputModifierNode) {
            InlineClassHelperKt.throwIllegalStateException("Expected textInputModifierNode to be " + legacyAdaptingPlatformTextInputModifierNode + " but was " + this.textInputModifierNode);
        }
        this.textInputModifierNode = null;
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            boolean z = (TextRange.m638equalsimpl0(legacyTextInputMethodRequest.state.selection, textFieldValue2.selection) && Intrinsics.areEqual(legacyTextInputMethodRequest.state.composition, textFieldValue2.composition)) ? false : true;
            legacyTextInputMethodRequest.state = textFieldValue2;
            int size = legacyTextInputMethodRequest.ics.size();
            for (int i = 0; i < size; i++) {
                RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) legacyTextInputMethodRequest.ics.get(i)).get();
                if (recordingInputConnection != null) {
                    recordingInputConnection.textFieldValue = textFieldValue2;
                }
            }
            LegacyCursorAnchorInfoController legacyCursorAnchorInfoController = legacyTextInputMethodRequest.cursorAnchorInfoController;
            synchronized (legacyCursorAnchorInfoController.lock) {
                legacyCursorAnchorInfoController.textFieldValue = null;
                legacyCursorAnchorInfoController.offsetMapping = null;
                legacyCursorAnchorInfoController.textLayoutResult = null;
                legacyCursorAnchorInfoController.innerTextFieldBounds = null;
                legacyCursorAnchorInfoController.decorationBoxBounds = null;
                Unit unit = Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
                if (z) {
                    StartStopTokens startStopTokens = legacyTextInputMethodRequest.inputMethodManager;
                    int iM642getMinimpl = TextRange.m642getMinimpl(textFieldValue2.selection);
                    int iM641getMaximpl = TextRange.m641getMaximpl(textFieldValue2.selection);
                    TextRange textRange = legacyTextInputMethodRequest.state.composition;
                    int iM642getMinimpl2 = textRange != null ? TextRange.m642getMinimpl(textRange.packedValue) : -1;
                    TextRange textRange2 = legacyTextInputMethodRequest.state.composition;
                    startStopTokens.getImm().updateSelection((View) startStopTokens.runs, iM642getMinimpl, iM641getMaximpl, iM642getMinimpl2, textRange2 != null ? TextRange.m641getMaximpl(textRange2.packedValue) : -1);
                    return;
                }
                return;
            }
            if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.annotatedString.text, textFieldValue2.annotatedString.text) || (TextRange.m638equalsimpl0(textFieldValue.selection, textFieldValue2.selection) && !Intrinsics.areEqual(textFieldValue.composition, textFieldValue2.composition)))) {
                StartStopTokens startStopTokens2 = legacyTextInputMethodRequest.inputMethodManager;
                startStopTokens2.getImm().restartInput((View) startStopTokens2.runs);
                return;
            }
            int size2 = legacyTextInputMethodRequest.ics.size();
            for (int i2 = 0; i2 < size2; i2++) {
                RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) legacyTextInputMethodRequest.ics.get(i2)).get();
                if (recordingInputConnection2 != null) {
                    TextFieldValue textFieldValue3 = legacyTextInputMethodRequest.state;
                    StartStopTokens startStopTokens3 = legacyTextInputMethodRequest.inputMethodManager;
                    if (recordingInputConnection2.isActive) {
                        recordingInputConnection2.textFieldValue = textFieldValue3;
                        if (recordingInputConnection2.extractedTextMonitorMode) {
                            startStopTokens3.getImm().updateExtractedText((View) startStopTokens3.runs, recordingInputConnection2.currentExtractedTextRequestToken, HandwritingGestureApi34.access$toExtractedText(textFieldValue3));
                        }
                        TextRange textRange3 = textFieldValue3.composition;
                        long j = textFieldValue3.selection;
                        int iM642getMinimpl3 = textRange3 != null ? TextRange.m642getMinimpl(textRange3.packedValue) : -1;
                        TextRange textRange4 = textFieldValue3.composition;
                        startStopTokens3.getImm().updateSelection((View) startStopTokens3.runs, TextRange.m642getMinimpl(j), TextRange.m641getMaximpl(j), iM642getMinimpl3, textRange4 != null ? TextRange.m641getMaximpl(textRange4.packedValue) : -1);
                    }
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, ProduceKt$awaitClose$4$1 produceKt$awaitClose$4$1, Rect rect, Rect rect2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.currentRequest;
        if (legacyTextInputMethodRequest != null) {
            LegacyCursorAnchorInfoController legacyCursorAnchorInfoController = legacyTextInputMethodRequest.cursorAnchorInfoController;
            synchronized (legacyCursorAnchorInfoController.lock) {
                try {
                    legacyCursorAnchorInfoController.textFieldValue = textFieldValue;
                    legacyCursorAnchorInfoController.offsetMapping = offsetMapping;
                    legacyCursorAnchorInfoController.textLayoutResult = textLayoutResult;
                    legacyCursorAnchorInfoController.innerTextFieldBounds = rect;
                    legacyCursorAnchorInfoController.decorationBoxBounds = rect2;
                    if (legacyCursorAnchorInfoController.hasPendingImmediateRequest || legacyCursorAnchorInfoController.monitorEnabled) {
                        legacyCursorAnchorInfoController.updateCursorAnchorInfo();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions, LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1, CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4) {
        startInput(new ActivityResultRegistryKt$$ExternalSyntheticLambda1(textFieldValue, this, imeOptions, lifecycleEffectKt$$ExternalSyntheticLambda1, coreTextFieldKt$$ExternalSyntheticLambda4, 3));
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public final void startInput() {
        startInput(null);
    }
}
