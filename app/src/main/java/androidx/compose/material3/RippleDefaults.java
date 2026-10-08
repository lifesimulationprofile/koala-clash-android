package androidx.compose.material3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RippleDefaults {
    public static final RippleThemeConfiguration InsetFocusRingRippleThemeConfiguration;
    public static final RippleThemeConfiguration OpacityFocusRippleThemeConfiguration;
    public static final RippleThemeConfiguration ThemeConfiguration;

    static {
        RippleThemeConfiguration rippleThemeConfiguration = new RippleThemeConfiguration(new RippleThemeConfiguration$Focus$Opacity());
        OpacityFocusRippleThemeConfiguration = rippleThemeConfiguration;
        InsetFocusRingRippleThemeConfiguration = new RippleThemeConfiguration(new RippleThemeConfiguration$Focus$InsetRing(0, 2, 1, 3));
        ThemeConfiguration = rippleThemeConfiguration;
    }
}
