package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarResult {
    public static final /* synthetic */ SnackbarResult[] $VALUES;
    public static final SnackbarResult Dismissed;

    static {
        SnackbarResult snackbarResult = new SnackbarResult("Dismissed", 0);
        Dismissed = snackbarResult;
        $VALUES = new SnackbarResult[]{snackbarResult, new SnackbarResult("ActionPerformed", 1)};
    }

    public static SnackbarResult valueOf(String str) {
        return (SnackbarResult) Enum.valueOf(SnackbarResult.class, str);
    }

    public static SnackbarResult[] values() {
        return (SnackbarResult[]) $VALUES.clone();
    }
}
