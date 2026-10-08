package com.google.android.datatransport.runtime;

import androidx.compose.foundation.style.InteractionSet;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.io.Closeable;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DaggerTransportRuntimeComponent implements Closeable {
    public Provider executorProvider;
    public Provider metadataBackendRegistryProvider;
    public Provider sQLiteEventStoreProvider;
    public InteractionSet setApplicationContextProvider;
    public Provider transportRuntimeProvider;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((SQLiteEventStore) ((EventStore) this.sQLiteEventStoreProvider.get())).close();
    }
}
