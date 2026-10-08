package com.github.kr328.clash.service.data.migrations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.ResourcesFlusher;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyMigrationKt$migrationFromLegacy$1 extends ContinuationImpl {
    public Context L$0;
    public SQLiteDatabase L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ResourcesFlusher.migrationFromLegacy(null, this);
    }
}
