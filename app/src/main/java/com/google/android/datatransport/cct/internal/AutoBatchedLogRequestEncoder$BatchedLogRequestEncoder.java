package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder INSTANCE = new AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder();
    public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }
}
