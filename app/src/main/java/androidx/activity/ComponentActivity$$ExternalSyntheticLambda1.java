package androidx.activity;

import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppCompatActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda1(AppCompatActivity appCompatActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = appCompatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.invalidateOptionsMenu();
                break;
            default:
                ComponentActivity.$r8$lambda$vCwjfXDiSGcirCy4I008VOiJ_lw(this.f$0);
                break;
        }
    }
}
