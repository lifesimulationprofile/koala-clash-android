package androidx.compose.runtime.composer.gapbuffer;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GapGroupSourceInformation {
    public ArrayList groups;

    public abstract boolean getClosed();

    public abstract int getDataEndOffset();

    public abstract int getDataStartOffset();

    public abstract ArrayList getGroups();

    public abstract int getKey();

    public abstract String getSourceInformation();

    public abstract boolean hasAnchor(GapAnchor gapAnchor);

    public abstract GapGroupSourceInformation openInformation();

    public abstract boolean removeAnchor(GapAnchor gapAnchor);
}
