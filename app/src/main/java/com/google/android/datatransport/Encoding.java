package com.google.android.datatransport;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Encoding {
    public final String name;

    public Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public final String toString() {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Encoding{name=\""), this.name, "\"}");
    }
}
