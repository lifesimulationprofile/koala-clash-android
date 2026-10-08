package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import coil.memory.RealStrongMemoryCache;
import com.caverock.androidsvg.SVG;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataBackendRegistry {
    public final RealStrongMemoryCache backendFactoryProvider;
    public final HashMap backends;
    public final SVG creationContextFactory;

    public MetadataBackendRegistry(Context context, SVG svg) {
        RealStrongMemoryCache realStrongMemoryCache = new RealStrongMemoryCache(context, 19);
        this.backends = new HashMap();
        this.backendFactoryProvider = realStrongMemoryCache;
        this.creationContextFactory = svg;
    }

    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        CctBackendFactory cctBackendFactory = this.backendFactoryProvider.get(str);
        if (cctBackendFactory == null) {
            return null;
        }
        SVG svg = this.creationContextFactory;
        TransportBackend transportBackendCreate = cctBackendFactory.create(new AutoValue_CreationContext((Context) svg.rootElement, (Clock) svg.cssRules, (Clock) svg.idToElementMap, str));
        this.backends.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
