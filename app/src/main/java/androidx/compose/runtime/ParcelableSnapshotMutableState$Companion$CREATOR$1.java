package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableSnapshotMutableState$Companion$CREATOR$1 implements Parcelable.ClassLoaderCreator {
    @Override // android.os.Parcelable.ClassLoaderCreator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new ParcelableSnapshotMutableState[i];
    }

    public static ParcelableSnapshotMutableState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        NeverEqualPolicy neverEqualPolicy;
        if (classLoader == null) {
            classLoader = ParcelableSnapshotMutableState$Companion$CREATOR$1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i = parcel.readInt();
        if (i == 0) {
            neverEqualPolicy = NeverEqualPolicy.INSTANCE;
        } else if (i == 1) {
            neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        } else {
            if (i != 2) {
                throw new IllegalStateException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Unsupported MutableState policy ", " was restored"));
            }
            neverEqualPolicy = NeverEqualPolicy.INSTANCE$1;
        }
        return new ParcelableSnapshotMutableState(value, neverEqualPolicy);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
