package androidx.compose.runtime.composer.gapbuffer.changelist;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface OperationErrorContext {
    List buildStackTrace(Integer num);

    boolean getSourceInformationEnabled();
}
