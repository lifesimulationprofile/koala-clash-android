package kotlinx.coroutines.selects;

import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectKt {
    public static final Symbol NO_RESULT;
    public static final Symbol STATE_CANCELLED;
    public static final Symbol STATE_COMPLETED;
    public static final Symbol STATE_REG;

    static {
        int i = 0;
        STATE_REG = new Symbol("STATE_REG", i);
        STATE_COMPLETED = new Symbol("STATE_COMPLETED", i);
        STATE_CANCELLED = new Symbol("STATE_CANCELLED", i);
        NO_RESULT = new Symbol("NO_RESULT", i);
        new Symbol("PARAM_CLAUSE_0", i);
    }
}
