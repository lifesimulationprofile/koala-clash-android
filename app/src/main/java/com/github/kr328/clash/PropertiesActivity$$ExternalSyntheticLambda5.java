package com.github.kr328.clash;

import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.MutableState;
import com.github.kr328.clash.common.util.ComponentsKt;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PropertiesActivity$$ExternalSyntheticLambda5 implements Function0 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ PropertiesActivity f$1;

    public /* synthetic */ PropertiesActivity$$ExternalSyntheticLambda5(MutableState mutableState, PropertiesActivity propertiesActivity) {
        this.f$0 = mutableState;
        this.f$1 = propertiesActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        MutableState mutableState = this.f$0;
        PropertiesActivity propertiesActivity = this.f$1;
        switch (i) {
            case 0:
                int i2 = PropertiesActivity.$r8$clinit;
                UUID uuid = (UUID) mutableState.getValue();
                if (uuid != null) {
                    Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(FilesActivity.class));
                    intent.setData(Uri.fromParts("uuid", String.valueOf(uuid), null));
                    propertiesActivity.startActivity(intent);
                }
                break;
            default:
                int i3 = PropertiesActivity.$r8$clinit;
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    if (((Boolean) propertiesActivity.hasUnsaved.invoke()).booleanValue()) {
                        propertiesActivity.pendingExit$delegate.setValue(Boolean.TRUE);
                    } else {
                        propertiesActivity.finish();
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ PropertiesActivity$$ExternalSyntheticLambda5(PropertiesActivity propertiesActivity, MutableState mutableState) {
        this.f$1 = propertiesActivity;
        this.f$0 = mutableState;
    }
}
