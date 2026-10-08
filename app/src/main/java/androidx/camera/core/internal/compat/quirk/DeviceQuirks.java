package androidx.camera.core.internal.compat.quirk;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.QuirkSettingsHolder;
import kotlin.collections.SetsKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceQuirks {
    public static volatile Headers.Builder sQuirks;

    static {
        QuirkSettingsHolder quirkSettingsHolder = QuirkSettingsHolder.sInstance;
        quirkSettingsHolder.mObservable.addObserver(SetsKt.directExecutor(), new Toolbar.AnonymousClass1(19, new CaptureNode$$ExternalSyntheticLambda0(3)));
    }
}
