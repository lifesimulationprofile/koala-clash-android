package com.google.android.material.internal;

import android.widget.Checkable;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface MaterialCheckable extends Checkable {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface OnCheckedChangeListener {
    }

    int getId();

    void setInternalOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener);
}
