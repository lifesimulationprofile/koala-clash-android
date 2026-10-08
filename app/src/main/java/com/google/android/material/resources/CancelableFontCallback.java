package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.work.WorkManager;
import com.google.android.material.internal.CollapsingTextHelper;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CancelableFontCallback extends WorkManager {
    public final ConnectionPool applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    public CancelableFontCallback(ConnectionPool connectionPool, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = connectionPool;
    }

    @Override // androidx.work.WorkManager
    public final void onFontRetrievalFailed(int i) {
        if (this.cancelled) {
            return;
        }
        CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.delegate;
        if (collapsingTextHelper.setCollapsedTypefaceInternal(this.fallbackFont)) {
            collapsingTextHelper.recalculate(false);
        }
    }

    @Override // androidx.work.WorkManager
    public final void onFontRetrieved(Typeface typeface, boolean z) {
        if (this.cancelled) {
            return;
        }
        CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.delegate;
        if (collapsingTextHelper.setCollapsedTypefaceInternal(typeface)) {
            collapsingTextHelper.recalculate(false);
        }
    }
}
