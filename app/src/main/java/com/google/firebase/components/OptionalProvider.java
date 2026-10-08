package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class OptionalProvider implements Provider {
    public volatile Provider delegate;
    public OptionalProvider$$Lambda$4 handler;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.delegate.get();
    }
}
