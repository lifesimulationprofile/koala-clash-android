package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder();
    public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");
    public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = (AutoValue_NetworkConnectionInfo) ((NetworkConnectionInfo) obj);
        objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.networkType);
        objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.mobileSubtype);
    }
}
