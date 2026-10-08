package com.github.kr328.clash.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.github.kr328.clash.common.Global;
import java.io.File;
import kotlin.io.FilesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StatusProvider extends ContentProvider {
    public static String currentProfile;
    public static boolean serviceRunning;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static void setServiceRunning(boolean z) {
            StatusProvider.serviceRunning = z;
            Global.INSTANCE.getClass();
            File fileResolve = FilesKt.resolve(Global.getApplication$1().getFilesDir(), "service_running.lock");
            if (z) {
                fileResolve.createNewFile();
            } else {
                fileResolve.delete();
            }
        }
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        if (!str.equals("currentProfile")) {
            return super.call(str, str2, bundle);
        }
        if (!serviceRunning) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", currentProfile);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalArgumentException("Stub!");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalArgumentException("Stub!");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalArgumentException("Stub!");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalArgumentException("Stub!");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalArgumentException("Stub!");
    }
}
