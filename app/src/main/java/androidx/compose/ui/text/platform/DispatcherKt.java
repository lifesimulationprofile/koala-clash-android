package androidx.compose.ui.text.platform;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DispatcherKt {
    public static final MainCoroutineDispatcher FontCacheManagementDispatcher;

    static {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        FontCacheManagementDispatcher = MainDispatcherLoader.dispatcher;
    }
}
