package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$ClientInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$ClientInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$ClientInfoEncoder();
    public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
    public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_ClientInfo autoValue_ClientInfo = (AutoValue_ClientInfo) ((ClientInfo) obj);
        autoValue_ClientInfo.getClass();
        objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, ClientInfo.ClientType.ANDROID_FIREBASE);
        objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, autoValue_ClientInfo.androidClientInfo);
    }
}
