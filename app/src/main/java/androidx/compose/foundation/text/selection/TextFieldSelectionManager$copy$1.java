package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.ui.platform.AndroidClipboard;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.work.impl.WorkLauncherImpl;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$copy$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $cancelSelection;
    public final /* synthetic */ int $r8$classId = 0;
    public int label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$copy$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
        this.$cancelSelection = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new TextFieldSelectionManager$copy$1((TextFieldSelectionManager) this.this$0, this.$cancelSelection, continuation);
            default:
                return new TextFieldSelectionManager$copy$1(this.$cancelSelection, (LazyListState) this.this$0, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((TextFieldSelectionManager$copy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AnnotatedString selectedText;
        int i = this.$r8$classId;
        Object obj2 = this.this$0;
        boolean z = this.$cancelSelection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i) {
            case 0:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (TextRange.m639getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                        selectedText = null;
                    } else {
                        selectedText = TextFieldValueKt.getSelectedText(textFieldSelectionManager.getValue$foundation());
                        if (z) {
                            int iM641getMaximpl = TextRange.m641getMaximpl(textFieldSelectionManager.getValue$foundation().selection);
                            textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m227createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().annotatedString, ParagraphKt.TextRange(iM641getMaximpl, iM641getMaximpl)));
                            textFieldSelectionManager.setHandleState(HandleState.None);
                        }
                    }
                    if (selectedText == null) {
                        return Unit.INSTANCE;
                    }
                    Clipboard clipboard = textFieldSelectionManager.clipboard;
                    if (clipboard != null) {
                        ClipEntry clipEntry = ClipboardUtils_androidKt.toClipEntry(selectedText);
                        this.label = 1;
                        if (((AndroidClipboard) clipboard).setClipEntry(clipEntry) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        this.label = 1;
                        WorkLauncherImpl workLauncherImpl = LazyListState.Saver;
                        if (((LazyListState) obj2).animateScrollToItem(0, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$copy$1(boolean z, LazyListState lazyListState, Continuation continuation) {
        super(2, continuation);
        this.$cancelSelection = z;
        this.this$0 = lazyListState;
    }
}
