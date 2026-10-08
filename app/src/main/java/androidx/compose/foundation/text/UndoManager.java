package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TextFieldValue;
import coil.request.RequestService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UndoManager {
    public boolean forceNextSnapshot;
    public Long lastSnapshot;
    public RequestService redoStack;
    public int storedCharacters;
    public RequestService undoStack;

    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    public final void makeSnapshot(TextFieldValue textFieldValue) {
        RequestService requestService;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        this.forceNextSnapshot = false;
        RequestService requestService2 = this.undoStack;
        if (textFieldValue.equals(requestService2 != null ? (TextFieldValue) requestService2.hardwareBitmapService : null)) {
            return;
        }
        String str = annotatedString.text;
        RequestService requestService3 = this.undoStack;
        if (Intrinsics.areEqual(str, requestService3 != null ? ((TextFieldValue) requestService3.hardwareBitmapService).annotatedString.text : null)) {
            RequestService requestService4 = this.undoStack;
            if (requestService4 != null) {
                requestService4.hardwareBitmapService = textFieldValue;
                return;
            }
            return;
        }
        this.undoStack = new RequestService(8, this.undoStack, textFieldValue, false);
        this.redoStack = null;
        int length = annotatedString.text.length() + this.storedCharacters;
        this.storedCharacters = length;
        if (length > 100000) {
            RequestService requestService5 = this.undoStack;
            if ((requestService5 != null ? (RequestService) requestService5.systemCallbacks : null) == null) {
                return;
            }
            while (true) {
                if (requestService5 == null) {
                    requestService = null;
                } else {
                    RequestService requestService6 = (RequestService) requestService5.systemCallbacks;
                    if (requestService6 != null) {
                        requestService = (RequestService) requestService6.systemCallbacks;
                    } else {
                        requestService = null;
                    }
                }
                if (requestService == null) {
                    break;
                } else {
                    requestService5 = (RequestService) requestService5.systemCallbacks;
                }
            }
            if (requestService5 != null) {
                requestService5.systemCallbacks = null;
            }
        }
    }
}
