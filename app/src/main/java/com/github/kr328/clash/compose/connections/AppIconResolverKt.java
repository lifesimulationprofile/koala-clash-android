package com.github.kr328.clash.compose.connections;

import android.content.Context;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1$1;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppIconResolverKt {
    public static final ConcurrentHashMap appInfoCache = new ConcurrentHashMap();

    public static final ProcessAppInfo rememberProcessApp(String str, GapComposer gapComposer) {
        gapComposer.startReplaceGroup(-285206614);
        Object obj = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        Object obj2 = appInfoCache.get(str);
        gapComposer.startReplaceGroup(2124127227);
        boolean zChanged = gapComposer.changed(str) | gapComposer.changedInstance(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        Continuation continuation = null;
        Object obj3 = Composer$Companion.Empty;
        if (zChanged || objRememberedValue == obj3) {
            objRememberedValue = new NavHostKt$NavHost$28$1(str, obj, continuation, 29);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        gapComposer.end(false);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj3) {
            objRememberedValue2 = Stack.mutableStateOf$default(obj2);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean zChangedInstance = gapComposer.changedInstance(function2);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == obj3) {
            objRememberedValue3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, null, 1);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Stack.LaunchedEffect(gapComposer, str, (Function2) objRememberedValue3);
        ProcessAppInfo processAppInfo = (ProcessAppInfo) mutableState.getValue();
        gapComposer.end(false);
        return processAppInfo;
    }
}
