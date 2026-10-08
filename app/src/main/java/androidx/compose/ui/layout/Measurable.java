package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Measurable {
    Object getParentData();

    int maxIntrinsicHeight(int i);

    int maxIntrinsicWidth(int i);

    /* JADX INFO: renamed from: measure-BRTryo0 */
    Placeable mo515measureBRTryo0(long j);

    int minIntrinsicHeight(int i);

    int minIntrinsicWidth(int i);
}
