package com.github.kr328.clash.service.clash;

import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.service.clash.module.Module;
import java.util.ArrayList;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1 {
    public final /* synthetic */ CoroutineScope $$this$launch;
    public final /* synthetic */ ArrayList $modules;

    public ClashRuntimeKt$clashRuntime$1$launch$1$1$scope$1(CoroutineScope coroutineScope, ArrayList arrayList) {
        this.$$this$launch = coroutineScope;
        this.$modules = arrayList;
    }

    public final void install(Module module) {
        JobKt.launch$default(this.$$this$launch, null, new FilesActivity$showError$1(this.$modules, module, null, 19), 3);
    }
}
