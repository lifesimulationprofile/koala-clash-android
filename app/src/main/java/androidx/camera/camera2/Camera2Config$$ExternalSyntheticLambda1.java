package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.work.impl.WorkLauncherImpl;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Camera2Config$$ExternalSyntheticLambda1 {
    public static WorkLauncherImpl newInstance(Context context, Object obj, LinkedHashSet linkedHashSet) throws InitializationException {
        try {
            return new WorkLauncherImpl(context, obj, linkedHashSet);
        } catch (CameraUnavailableException e) {
            throw new InitializationException(e);
        }
    }
}
