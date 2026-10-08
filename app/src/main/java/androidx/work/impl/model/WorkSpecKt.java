package androidx.work.impl.model;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkSpecKt {
    public static final WorkGenerationalId generationalId(WorkSpec workSpec) {
        return new WorkGenerationalId(workSpec.id, workSpec.generation);
    }
}
