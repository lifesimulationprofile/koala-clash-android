package androidx.work;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkManager {
    public abstract Intent createIntent(AppCompatActivity appCompatActivity, Object obj);

    public PreviewView.AnonymousClass1 getSynchronousResult(AppCompatActivity appCompatActivity, Object obj) {
        return null;
    }

    public abstract void onFontRetrievalFailed(int i);

    public abstract void onFontRetrieved(Typeface typeface, boolean z);

    public abstract Object parseResult(Intent intent, int i);
}
