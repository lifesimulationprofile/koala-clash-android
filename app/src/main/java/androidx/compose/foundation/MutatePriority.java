package androidx.compose.foundation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MutatePriority {
    public static final /* synthetic */ MutatePriority[] $VALUES;
    public static final MutatePriority Default;
    public static final MutatePriority PreventUserInput;
    public static final MutatePriority UserInput;

    static {
        MutatePriority mutatePriority = new MutatePriority("Default", 0);
        Default = mutatePriority;
        MutatePriority mutatePriority2 = new MutatePriority("UserInput", 1);
        UserInput = mutatePriority2;
        MutatePriority mutatePriority3 = new MutatePriority("PreventUserInput", 2);
        PreventUserInput = mutatePriority3;
        $VALUES = new MutatePriority[]{mutatePriority, mutatePriority2, mutatePriority3};
    }

    public static MutatePriority valueOf(String str) {
        return (MutatePriority) Enum.valueOf(MutatePriority.class, str);
    }

    public static MutatePriority[] values() {
        return (MutatePriority[]) $VALUES.clone();
    }
}
