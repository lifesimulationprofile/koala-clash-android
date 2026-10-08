package com.github.kr328.clash.service.data.migrations;

import android.content.Context;
import androidx.appcompat.app.ResourcesFlusher;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MigrationsKt$LEGACY_MIGRATION$1 extends FunctionReferenceImpl implements Function2 {
    public static final MigrationsKt$LEGACY_MIGRATION$1 INSTANCE = new MigrationsKt$LEGACY_MIGRATION$1(2, ResourcesFlusher.class, "migrationFromLegacy", "migrationFromLegacy(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ResourcesFlusher.migrationFromLegacy((Context) obj, (Continuation) obj2);
    }
}
