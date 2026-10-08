package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityThresholdsKt {
    public static final Object VisibilityThresholdMap;

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Pair pair = new Pair(ArcSplineKt.IntToVector, fValueOf);
        Pair pair2 = new Pair(ArcSplineKt.IntSizeToVector, fValueOf);
        Pair pair3 = new Pair(ArcSplineKt.IntOffsetToVector, fValueOf);
        Pair pair4 = new Pair(ArcSplineKt.FloatToVector, Float.valueOf(0.01f));
        Pair pair5 = new Pair(ArcSplineKt.RectToVector, fValueOf);
        Pair pair6 = new Pair(ArcSplineKt.SizeToVector, fValueOf);
        Pair pair7 = new Pair(ArcSplineKt.OffsetToVector, fValueOf);
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.DpToVector;
        Float fValueOf2 = Float.valueOf(0.4f);
        VisibilityThresholdMap = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, new Pair(twoWayConverterImpl, fValueOf2), new Pair(ArcSplineKt.DpOffsetToVector, fValueOf2));
    }
}
