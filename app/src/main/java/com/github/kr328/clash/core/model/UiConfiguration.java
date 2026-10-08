package com.github.kr328.clash.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import coil.memory.RealStrongMemoryCache;
import coil.request.RequestService;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class UiConfiguration implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR();

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CREATOR implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return (UiConfiguration) serializer().deserialize(new RealStrongMemoryCache(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new UiConfiguration[i];
        }

        public final KSerializer serializer() {
            return UiConfiguration$$serializer.INSTANCE;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        CREATOR.serializer().serialize(new RequestService(parcel), this);
    }
}
