package androidx.work;

import android.database.Cursor;
import android.util.Log;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Data {
    public static final Data EMPTY;
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("Data");
    public final HashMap mValues;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Builder implements SQLiteEventStore.Function {
        public final HashMap mValues;

        public Builder(HashMap map) {
            this.mValues = map;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
        public Object apply(Object obj) {
            Cursor cursor = (Cursor) obj;
            Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
            while (cursor.moveToNext()) {
                long j = cursor.getLong(0);
                Long lValueOf = Long.valueOf(j);
                HashMap map = this.mValues;
                Set hashSet = (Set) map.get(lValueOf);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new SQLiteEventStore.Metadata(cursor.getString(1), cursor.getString(2)));
            }
            return null;
        }

        public void put(Object obj, String str) {
            HashMap map = this.mValues;
            if (obj == null) {
                map.put(str, null);
                return;
            }
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                map.put(str, obj);
                return;
            }
            int i = 0;
            if (cls == boolean[].class) {
                boolean[] zArr = (boolean[]) obj;
                String str2 = Data.TAG;
                Boolean[] boolArr = new Boolean[zArr.length];
                while (i < zArr.length) {
                    boolArr[i] = Boolean.valueOf(zArr[i]);
                    i++;
                }
                map.put(str, boolArr);
                return;
            }
            if (cls == byte[].class) {
                byte[] bArr = (byte[]) obj;
                String str3 = Data.TAG;
                Byte[] bArr2 = new Byte[bArr.length];
                while (i < bArr.length) {
                    bArr2[i] = Byte.valueOf(bArr[i]);
                    i++;
                }
                map.put(str, bArr2);
                return;
            }
            if (cls == int[].class) {
                int[] iArr = (int[]) obj;
                String str4 = Data.TAG;
                Integer[] numArr = new Integer[iArr.length];
                while (i < iArr.length) {
                    numArr[i] = Integer.valueOf(iArr[i]);
                    i++;
                }
                map.put(str, numArr);
                return;
            }
            if (cls == long[].class) {
                long[] jArr = (long[]) obj;
                String str5 = Data.TAG;
                Long[] lArr = new Long[jArr.length];
                while (i < jArr.length) {
                    lArr[i] = Long.valueOf(jArr[i]);
                    i++;
                }
                map.put(str, lArr);
                return;
            }
            if (cls == float[].class) {
                float[] fArr = (float[]) obj;
                String str6 = Data.TAG;
                Float[] fArr2 = new Float[fArr.length];
                while (i < fArr.length) {
                    fArr2[i] = Float.valueOf(fArr[i]);
                    i++;
                }
                map.put(str, fArr2);
                return;
            }
            if (cls != double[].class) {
                throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
            }
            double[] dArr = (double[]) obj;
            String str7 = Data.TAG;
            Double[] dArr2 = new Double[dArr.length];
            while (i < dArr.length) {
                dArr2[i] = Double.valueOf(dArr[i]);
                i++;
            }
            map.put(str, dArr2);
        }

        public void putAll(HashMap map) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getValue(), (String) entry.getKey());
            }
        }

        public Builder() {
            this.mValues = new HashMap();
        }
    }

    static {
        Data data = new Data(new HashMap());
        toByteArrayInternal(data);
        EMPTY = data;
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0033 A[EXC_TOP_SPLITTER, PHI: r4
      0x0033: PHI (r4v7 java.io.ObjectInputStream) = (r4v6 java.io.ObjectInputStream), (r4v8 java.io.ObjectInputStream) binds: [B:31:0x0052, B:7:0x001d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Data fromByteArray(byte[] bArr) throws Throwable {
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable e;
        String str = TAG;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        try {
                            for (int i = objectInputStream.readInt(); i > 0; i--) {
                                map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                            }
                        } catch (IOException e2) {
                            e = e2;
                            Log.e(str, "Error in Data#fromByteArray: ", e);
                            if (objectInputStream != null) {
                            }
                            byteArrayInputStream.close();
                            return new Data(map);
                        } catch (ClassNotFoundException e3) {
                            e = e3;
                            Log.e(str, "Error in Data#fromByteArray: ", e);
                            if (objectInputStream != null) {
                            }
                            byteArrayInputStream.close();
                            return new Data(map);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e4) {
                                Log.e(str, "Error in Data#fromByteArray: ", e4);
                            }
                        }
                        try {
                            byteArrayInputStream.close();
                            throw th;
                        } catch (IOException e5) {
                            Log.e(str, "Error in Data#fromByteArray: ", e5);
                            throw th;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    Throwable th3 = e;
                    objectInputStream = null;
                    e = th3;
                    Log.e(str, "Error in Data#fromByteArray: ", e);
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (ClassNotFoundException e7) {
                    e = e7;
                    Throwable th4 = e;
                    objectInputStream = null;
                    e = th4;
                    Log.e(str, "Error in Data#fromByteArray: ", e);
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                    return new Data(map);
                } catch (Throwable th5) {
                    th = th5;
                    if (0 != 0) {
                        objectInputStream2.close();
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
                byteArrayInputStream.close();
            } catch (IOException e8) {
                Log.e(str, "Error in Data#fromByteArray: ", e8);
            }
            objectInputStream.close();
        } catch (IOException e9) {
            Log.e(str, "Error in Data#fromByteArray: ", e9);
        }
        return new Data(map);
    }

    public static byte[] toByteArrayInternal(Data data) throws Throwable {
        String str = TAG;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(data.mValues.size());
                    for (Map.Entry entry : data.mValues.entrySet()) {
                        objectOutputStream2.writeUTF((String) entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        Log.e(str, "Error in Data#toByteArray: ", e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        Log.e(str, "Error in Data#toByteArray: ", e2);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                    Log.e(str, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            Log.e(str, "Error in Data#toByteArray: ", e4);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        Log.e(str, "Error in Data#toByteArray: ", e5);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(str, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        Log.e(str, "Error in Data#toByteArray: ", e7);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e8) {
            e = e8;
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && Data.class == obj.getClass()) {
                HashMap map = ((Data) obj).mValues;
                HashMap map2 = this.mValues;
                Set<String> setKeySet = map2.keySet();
                if (setKeySet.equals(map.keySet())) {
                    for (String str : setKeySet) {
                        Object obj2 = map2.get(str);
                        Object obj3 = map.get(str);
                        if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        HashMap map = this.mValues;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(HashMap map) {
        this.mValues = new HashMap(map);
    }
}
