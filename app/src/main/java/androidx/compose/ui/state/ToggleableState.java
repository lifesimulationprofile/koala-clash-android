package androidx.compose.ui.state;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleableState {
    public static final /* synthetic */ ToggleableState[] $VALUES;
    public static final ToggleableState Indeterminate;
    public static final ToggleableState Off;
    public static final ToggleableState On;

    static {
        ToggleableState toggleableState = new ToggleableState("On", 0);
        On = toggleableState;
        ToggleableState toggleableState2 = new ToggleableState("Off", 1);
        Off = toggleableState2;
        ToggleableState toggleableState3 = new ToggleableState("Indeterminate", 2);
        Indeterminate = toggleableState3;
        $VALUES = new ToggleableState[]{toggleableState, toggleableState2, toggleableState3};
    }

    public static ToggleableState valueOf(String str) {
        return (ToggleableState) Enum.valueOf(ToggleableState.class, str);
    }

    public static ToggleableState[] values() {
        return (ToggleableState[]) $VALUES.clone();
    }
}
