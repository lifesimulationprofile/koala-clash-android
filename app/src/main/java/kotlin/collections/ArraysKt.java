package kotlin.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.text.StringsKt__AppendableKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArraysKt extends ArraysKt__ArraysJVMKt {
    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) >= 0;
    }

    public static void copyInto(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static void copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        System.arraycopy(objArr, i, objArr2, 0, i2 - i);
    }

    public static ArrayList filterNotNull(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object getOrNull(int i, Object[] objArr) {
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int indexOf(Object[] objArr, Object obj) {
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String joinToString$default(int i, Object[] objArr) {
        String str = (i & 2) != 0 ? "" : "innermostOf(";
        String str2 = (i & 4) == 0 ? ")" : "";
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ", ");
            }
            StringsKt__AppendableKt.appendElement(sb, obj, null);
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }

    public static List toList(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? new ArrayList(new ArrayAsCollection(objArr, false)) : Collections.singletonList(objArr[0]);
        }
        return EmptyList.INSTANCE;
    }

    public static Set toSet(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return EmptySet.INSTANCE;
        }
        if (length == 1) {
            return Collections.singleton(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0010 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0012 A[RETURN] */
    public static boolean contains(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (i == iArr[i2]) {
                if (i2 >= 0) {
                    return true;
                }
                return false;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    public static void copyInto(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void copyInto(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
    }

    public static void copyInto$default(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = iArr.length;
        }
        System.arraycopy(iArr, 0, iArr2, i, i2);
    }
}
