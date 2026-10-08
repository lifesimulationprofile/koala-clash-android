package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.unit.Density;
import androidx.work.Constraints;
import coil.network.HttpException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkTypeConverters {
    public static final LinkedHashSet byteArrayToSetOfTriggers(byte[] bArr) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int i = objectInputStream.readInt();
                    for (int i2 = 0; i2 < i; i2++) {
                        linkedHashSet.add(new Constraints.ContentUriTrigger(objectInputStream.readBoolean(), Uri.parse(objectInputStream.readUTF())));
                    }
                    Unit unit = Unit.INSTANCE;
                    objectInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(objectInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayInputStream, th3);
                    throw th4;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Unit unit2 = Unit.INSTANCE;
        byteArrayInputStream.close();
        return linkedHashSet;
    }

    public static final int intToBackoffPolicy(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Could not convert ", " to BackoffPolicy"));
    }

    public static final int intToNetworkType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (Build.VERSION.SDK_INT < 30 || i != 5) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Could not convert ", " to NetworkType"));
        }
        return 6;
    }

    public static final int intToOutOfQuotaPolicy(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static final int intToState(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 5;
        }
        if (i == 5) {
            return 6;
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i, "Could not convert ", " to State"));
    }

    public static final int networkTypeToInt(int i) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        if (Build.VERSION.SDK_INT >= 30 && i == 6) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + Density.CC.stringValueOf$4(i) + " to int");
                    }
                }
            }
        }
        return i2;
    }

    public static final byte[] setOfTriggersToByteArray(Set set) throws IOException {
        if (set.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    Constraints.ContentUriTrigger contentUriTrigger = (Constraints.ContentUriTrigger) it.next();
                    objectOutputStream.writeUTF(contentUriTrigger.uri.toString());
                    objectOutputStream.writeBoolean(contentUriTrigger.isTriggeredForDescendants);
                }
                Unit unit = Unit.INSTANCE;
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(objectOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(byteArrayOutputStream, th3);
                throw th4;
            }
        }
    }

    public static final int stateToInt(int i) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (iOrdinal != 1) {
            i2 = 2;
            if (iOrdinal != 2) {
                i2 = 3;
                if (iOrdinal != 3) {
                    i2 = 4;
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return 5;
                        }
                        throw new HttpException();
                    }
                }
            }
        }
        return i2;
    }
}
