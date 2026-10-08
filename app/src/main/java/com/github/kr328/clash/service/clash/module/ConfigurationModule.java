package com.github.kr328.clash.service.clash.module;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import com.github.kr328.clash.common.compat.IntentsKt;
import com.github.kr328.clash.common.constants.Components;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.store.ServiceStore;
import com.koala.clash.R;
import java.util.UUID;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationModule extends Module {
    public final /* synthetic */ int $r8$classId;
    public final Object reload;
    public final Object store;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class LoadException {
        public final String message;

        public LoadException(String str) {
            this.message = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadException) && Intrinsics.areEqual(this.message, ((LoadException) obj).message);
        }

        public final int hashCode() {
            return this.message.hashCode();
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m$1("LoadException(message=", this.message, ")");
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.clash.module.ConfigurationModule$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ConfigurationModule L$0;
        public ReceiveChannel L$1;
        public UUID L$2;
        public UUID L$3;
        public Imported L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigurationModule.this.run(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigurationModule(Service service, int i) {
        super(service);
        this.$r8$classId = i;
        switch (i) {
            case 1:
                super(service);
                NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(service, "clash_status_channel");
                notificationCompat$Builder.mNotification.icon = R.drawable.ic_logo_service;
                notificationCompat$Builder.setFlag(2);
                notificationCompat$Builder.mColor = service.getColor(R.color.color_clash);
                notificationCompat$Builder.setFlag(8);
                notificationCompat$Builder.mShowWhen = false;
                notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength("Not Selected");
                notificationCompat$Builder.mFgsDeferBehavior = 1;
                notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(service, R.id.nf_clash_status, new Intent().setComponent(Components.MAIN_ACTIVITY).setFlags(872415232), IntentsKt.pendingIntentFlags$default());
                this.store = notificationCompat$Builder;
                this.reload = new NotificationManagerCompat(service);
                break;
            default:
                this.store = new ServiceStore(service);
                this.reload = ChannelKt.Channel$default(-1, 0, 6);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fc A[Catch: Exception -> 0x010d, TryCatch #0 {Exception -> 0x010d, blocks: (B:41:0x00f2, B:43:0x00fc, B:46:0x0104, B:51:0x0111, B:79:0x0258, B:80:0x025d), top: B:92:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x0127  */
    /* JADX WARN: Code duplicated, block: B:57:0x0130 A[Catch: Exception -> 0x0062, TryCatch #1 {Exception -> 0x0062, blocks: (B:21:0x005d, B:76:0x0211, B:55:0x012b, B:57:0x0130, B:60:0x0161, B:63:0x01a0, B:64:0x01ab, B:66:0x01b1, B:68:0x01c4, B:70:0x01c9, B:72:0x01d9, B:73:0x01e7, B:77:0x0252, B:78:0x0257, B:26:0x006f, B:29:0x007e, B:32:0x008b), top: B:94:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x015f  */
    /* JADX WARN: Code duplicated, block: B:62:0x019e  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b1 A[Catch: Exception -> 0x0062, TryCatch #1 {Exception -> 0x0062, blocks: (B:21:0x005d, B:76:0x0211, B:55:0x012b, B:57:0x0130, B:60:0x0161, B:63:0x01a0, B:64:0x01ab, B:66:0x01b1, B:68:0x01c4, B:70:0x01c9, B:72:0x01d9, B:73:0x01e7, B:77:0x0252, B:78:0x0257, B:26:0x006f, B:29:0x007e, B:32:0x008b), top: B:94:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01c4 A[Catch: Exception -> 0x0062, TryCatch #1 {Exception -> 0x0062, blocks: (B:21:0x005d, B:76:0x0211, B:55:0x012b, B:57:0x0130, B:60:0x0161, B:63:0x01a0, B:64:0x01ab, B:66:0x01b1, B:68:0x01c4, B:70:0x01c9, B:72:0x01d9, B:73:0x01e7, B:77:0x0252, B:78:0x0257, B:26:0x006f, B:29:0x007e, B:32:0x008b), top: B:94:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01d9 A[Catch: Exception -> 0x0062, LOOP:1: B:71:0x01d7->B:72:0x01d9, LOOP_END, TryCatch #1 {Exception -> 0x0062, blocks: (B:21:0x005d, B:76:0x0211, B:55:0x012b, B:57:0x0130, B:60:0x0161, B:63:0x01a0, B:64:0x01ab, B:66:0x01b1, B:68:0x01c4, B:70:0x01c9, B:72:0x01d9, B:73:0x01e7, B:77:0x0252, B:78:0x0257, B:26:0x006f, B:29:0x007e, B:32:0x008b), top: B:94:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x020f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0258 A[Catch: Exception -> 0x010d, TRY_ENTER, TryCatch #0 {Exception -> 0x010d, blocks: (B:41:0x00f2, B:43:0x00fc, B:46:0x0104, B:51:0x0111, B:79:0x0258, B:80:0x025d), top: B:92:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.github.kr328.clash.service.data.Imported, java.util.UUID, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x010a -> B:36:0x00b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x020d -> B:76:0x0211). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.github.kr328.clash.service.clash.module.Module
    public final java.lang.Object run(kotlin.coroutines.Continuation r17) {
        /*
            Method dump skipped, instruction units count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.clash.module.ConfigurationModule.run(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
