package androidx.compose.ui.unit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutDirection {
    public static final /* synthetic */ LayoutDirection[] $VALUES;
    public static final LayoutDirection Ltr;
    public static final LayoutDirection Rtl;

    static {
        LayoutDirection layoutDirection = new LayoutDirection("Ltr", 0);
        Ltr = layoutDirection;
        LayoutDirection layoutDirection2 = new LayoutDirection("Rtl", 1);
        Rtl = layoutDirection2;
        $VALUES = new LayoutDirection[]{layoutDirection, layoutDirection2};
    }

    public static LayoutDirection valueOf(String str) {
        return (LayoutDirection) Enum.valueOf(LayoutDirection.class, str);
    }

    public static LayoutDirection[] values() {
        return (LayoutDirection[]) $VALUES.clone();
    }
}
