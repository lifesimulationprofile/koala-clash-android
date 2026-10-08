package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Storage {
    public static final ReentrantLock zaa = new ReentrantLock();
    public static Storage zab;
    public final ReentrantLock zac = new ReentrantLock();
    public final SharedPreferences zad;

    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String zaa(String str) {
        ReentrantLock reentrantLock = this.zac;
        reentrantLock.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
