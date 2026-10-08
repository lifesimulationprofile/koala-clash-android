package androidx.compose.animation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitState {
    public static final /* synthetic */ EnterExitState[] $VALUES;
    public static final EnterExitState PostExit;
    public static final EnterExitState PreEnter;
    public static final EnterExitState Visible;

    static {
        EnterExitState enterExitState = new EnterExitState("PreEnter", 0);
        PreEnter = enterExitState;
        EnterExitState enterExitState2 = new EnterExitState("Visible", 1);
        Visible = enterExitState2;
        EnterExitState enterExitState3 = new EnterExitState("PostExit", 2);
        PostExit = enterExitState3;
        $VALUES = new EnterExitState[]{enterExitState, enterExitState2, enterExitState3};
    }

    public static EnterExitState valueOf(String str) {
        return (EnterExitState) Enum.valueOf(EnterExitState.class, str);
    }

    public static EnterExitState[] values() {
        return (EnterExitState[]) $VALUES.clone();
    }
}
