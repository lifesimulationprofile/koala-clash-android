package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import coil.memory.RealStrongMemoryCache;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput {
    public final boolean editable;
    public final int imeAction;
    public final DeadKeyCombiner keyCombiner;
    public final KeyMappingKt$commonKeyMapping$1 keyMapping;
    public final OffsetMapping offsetMapping;
    public final Function1 onValueChange;
    public final TextPreparedSelectionState preparedSelectionState;
    public final TextFieldSelectionManager selectionManager;
    public final boolean singleLine;
    public final LegacyTextFieldState state;
    public final UndoManager undoManager;
    public final TextFieldValue value;

    public TextFieldKeyInput(LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, Function1 function1, int i) {
        KeyMappingKt$commonKeyMapping$1 keyMappingKt$commonKeyMapping$1 = BasicTextKt.platformDefaultKeyMapping;
        this.state = legacyTextFieldState;
        this.selectionManager = textFieldSelectionManager;
        this.value = textFieldValue;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = textPreparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = deadKeyCombiner;
        this.keyMapping = keyMappingKt$commonKeyMapping$1;
        this.onValueChange = function1;
        this.imeAction = i;
    }

    public final void apply(List list) {
        RealStrongMemoryCache realStrongMemoryCache = this.state.processor;
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(realStrongMemoryCache.apply(arrayList));
    }
}
