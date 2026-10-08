package androidx.compose.material3;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.material3.tokens.SegmentedMenuTokens;
import androidx.compose.runtime.ParcelableSnapshotMutableState;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuDefaults {
    public static final float TonalElevation = ElevationTokens.Level0;
    public static final float ShadowElevation = MenuTokens.ContainerElevation;

    static {
        int i = SegmentedMenuTokens.$r8$clinit;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        float f = 12;
        OffsetKt.m118PaddingValuesYgX7TsA(f, 2);
        OffsetKt.m121PaddingValuesa9UjIt4$default(f, 0.0f, 4, 0.0f, 10);
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            OffsetKt.m121PaddingValuesa9UjIt4$default(0, 0.0f, 6, 0.0f, 10);
        } else {
            float f2 = 0;
            new PaddingValuesImpl(f2, f2, f2, f2);
        }
        float f3 = MenuKt.DropdownMenuItemHorizontalPadding;
        float f4 = 0;
        OffsetKt.m118PaddingValuesYgX7TsA(f3, f4);
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            OffsetKt.m120PaddingValuesa9UjIt4(16, f, 10, f);
        } else {
            OffsetKt.m118PaddingValuesYgX7TsA(f3, f);
        }
        OffsetKt.m118PaddingValuesYgX7TsA(f4, MenuKt.DropdownMenuGroupVerticalPadding);
    }
}
