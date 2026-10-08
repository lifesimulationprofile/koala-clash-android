package com.github.kr328.clash.service.data.migrations;

import android.content.Context;
import android.database.Cursor;
import androidx.appcompat.app.ResourcesFlusher;
import java.io.Closeable;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LegacyMigrationKt$migrationFromLegacy234$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public int I$2;
    public int I$3;
    public int I$4;
    public int I$5;
    public int I$6;
    public long J$0;
    public Context L$0;
    public Closeable L$1;
    public Cursor L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ResourcesFlusher.migrationFromLegacy234(null, null, 0, this);
    }
}
