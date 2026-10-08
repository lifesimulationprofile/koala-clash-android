package androidx.compose.foundation.text.input.internal;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import coil.memory.RealStrongMemoryCache;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoreTextFieldSemanticsModifierNode f$0;

    public /* synthetic */ CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode, int i) {
        this.$r8$classId = i;
        this.f$0 = coreTextFieldSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        boolean z = false;
        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f$0;
        switch (i) {
            case 0:
                AndroidFillableData androidFillableData = (AndroidFillableData) obj;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = coreTextFieldSemanticsModifierNode.state.justAutofilled$delegate;
                Boolean bool = Boolean.TRUE;
                parcelableSnapshotMutableState.setValue(bool);
                coreTextFieldSemanticsModifierNode.state.autofillHighlightOn$delegate.setValue(bool);
                CoreTextFieldSemanticsModifierNode.handleTextUpdateFromSemantics(coreTextFieldSemanticsModifierNode.state, (String) (androidFillableData.autofillValue.isText() ? androidFillableData.autofillValue.getTextValue() : null), coreTextFieldSemanticsModifierNode.enabled);
                return bool;
            case 1:
                List list = (List) obj;
                if (coreTextFieldSemanticsModifierNode.state.getLayoutResult() != null) {
                    list.add(coreTextFieldSemanticsModifierNode.state.getLayoutResult().value);
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                CoreTextFieldSemanticsModifierNode.handleTextUpdateFromSemantics(coreTextFieldSemanticsModifierNode.state, ((AnnotatedString) obj).text, coreTextFieldSemanticsModifierNode.enabled);
                return Boolean.TRUE;
            default:
                AnnotatedString annotatedString = (AnnotatedString) obj;
                if (coreTextFieldSemanticsModifierNode.enabled) {
                    TextInputSession textInputSession = coreTextFieldSemanticsModifierNode.state.inputSession;
                    if (textInputSession != null) {
                        List listListOf = MatrixExt.listOf(new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1));
                        LegacyTextFieldState legacyTextFieldState = coreTextFieldSemanticsModifierNode.state;
                        RealStrongMemoryCache realStrongMemoryCache = legacyTextFieldState.processor;
                        CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState.onValueChange;
                        TextFieldValue textFieldValueApply = realStrongMemoryCache.apply(listListOf);
                        textInputSession.updateState(null, textFieldValueApply);
                        coreTextFieldKt$$ExternalSyntheticLambda4.invoke(textFieldValueApply);
                    } else {
                        TextFieldValue textFieldValue = coreTextFieldSemanticsModifierNode.value;
                        String str = textFieldValue.annotatedString.text;
                        long j = textFieldValue.selection;
                        int i2 = TextRange.$r8$clinit;
                        String string = StringsKt.replaceRange(str, (int) (j >> 32), (int) (j & 4294967295L), annotatedString).toString();
                        int length = annotatedString.text.length() + ((int) (coreTextFieldSemanticsModifierNode.value.selection >> 32));
                        coreTextFieldSemanticsModifierNode.state.onValueChange.invoke(new TextFieldValue(4, ParagraphKt.TextRange(length, length), string));
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }

    public /* synthetic */ CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.$r8$classId = 3;
        this.f$0 = coreTextFieldSemanticsModifierNode;
    }
}
