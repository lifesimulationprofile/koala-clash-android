package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_common.zzlh;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = zzlh.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        String strCreateString = null;
        boolean z = false;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                arrayListCreateTypedList = zzlh.createTypedList(i, parcel, Feature.CREATOR);
            } else if (c == 2) {
                z = zzlh.readBoolean(parcel, i);
            } else if (c == 3) {
                strCreateString2 = zzlh.createString(parcel, i);
            } else if (c != 4) {
                zzlh.skipUnknownField(parcel, i);
            } else {
                strCreateString = zzlh.createString(parcel, i);
            }
        }
        zzlh.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ApiFeatureRequest(arrayListCreateTypedList, z, strCreateString2, strCreateString);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ApiFeatureRequest[i];
    }
}
