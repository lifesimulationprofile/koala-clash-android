package androidx.camera.core.impl;

import androidx.compose.ui.node.NodeChain;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class QuirkSettingsHolder {
    public static final QuirkSettings DEFAULT = new QuirkSettings(true, null, null);
    public static final QuirkSettingsHolder sInstance = new QuirkSettingsHolder();
    public final NodeChain.Differ mObservable = new NodeChain.Differ(DEFAULT);
}
