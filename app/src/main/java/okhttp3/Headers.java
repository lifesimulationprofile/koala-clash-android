package okhttp3;

import androidx.camera.core.impl.Quirk;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import com.google.android.gms.dynamite.zzd;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Headers implements Iterable, KMappedMarker {
    public final String[] namesAndValues;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static ImageVector _openInBrowser;

        public static void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public static void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public static Headers of(String... strArr) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i2] = StringsKt.trim(str).toString();
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr2);
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
        }
        return false;
    }

    public final String get(String str) {
        String[] strArr = this.namesAndValues;
        int length = strArr.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (!StringsKt__StringsJVMKt.equals(str, strArr[length], true)) {
            if (length == progressionLastElement) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final Date getDate(String str) {
        String str2 = get(str);
        if (str2 == null) {
            return null;
        }
        zzd zzdVar = DatesKt.STANDARD_DATE_FORMAT;
        if (str2.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) DatesKt.STANDARD_DATE_FORMAT.get()).parse(str2, parsePosition);
        if (parsePosition.getIndex() == str2.length()) {
            return date;
        }
        String[] strArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS;
                    DateFormat simpleDateFormat = dateFormatArr[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                        simpleDateFormat.setTimeZone(Util.UTC);
                        dateFormatArr[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str2, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(name(i), value(i));
        }
        return new UIntArray.Iterator(6, pairArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Builder newBuilder() {
        Builder builder = new Builder(0);
        builder.namesAndValues.addAll(Arrays.asList(this.namesAndValues));
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            String strValue = value(i);
            sb.append(strName);
            sb.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb.append(strValue);
            sb.append("\n");
        }
        return sb.toString();
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Builder {
        public final ArrayList namesAndValues;

        public Builder(List list) {
            this.namesAndValues = new ArrayList(list);
        }

        public static String toString(Builder builder) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = builder.namesAndValues;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                arrayList.add(((Quirk) obj).getClass().getSimpleName());
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append((CharSequence) " | ");
                }
            }
            return sb.toString();
        }

        public void addLenient$okhttp(String str, String str2) {
            ArrayList arrayList = this.namesAndValues;
            arrayList.add(str);
            arrayList.add(StringsKt.trim(str2).toString());
        }

        public void addUnsafeNonAscii(String str, String str2) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
            addLenient$okhttp(str, str2);
        }

        public void arcToRelative(float f, float f2, float f3, float f4, boolean z) {
            this.namesAndValues.add(new PathNode.RelativeArcTo(f, f2, 0.0f, false, z, f3, f4));
        }

        public Headers build() {
            return new Headers((String[]) this.namesAndValues.toArray(new String[0]));
        }

        public void close() {
            this.namesAndValues.add(PathNode.Close.INSTANCE);
        }

        public boolean contains(Class cls) {
            ArrayList arrayList = this.namesAndValues;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (cls.isAssignableFrom(((Quirk) obj).getClass())) {
                    return true;
                }
            }
            return false;
        }

        public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.namesAndValues.add(new PathNode.CurveTo(f, f2, f3, f4, f5, f6));
        }

        public void curveToRelative(float f, float f2, float f3, float f4, float f5, float f6) {
            this.namesAndValues.add(new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6));
        }

        public Quirk get(Class cls) {
            ArrayList arrayList = this.namesAndValues;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Quirk quirk = (Quirk) obj;
                if (quirk.getClass() == cls) {
                    return quirk;
                }
            }
            return null;
        }

        public void horizontalLineTo(float f) {
            this.namesAndValues.add(new PathNode.HorizontalTo(f));
        }

        public void horizontalLineToRelative(float f) {
            this.namesAndValues.add(new PathNode.RelativeHorizontalTo(f));
        }

        public void lineTo(float f, float f2) {
            this.namesAndValues.add(new PathNode.LineTo(f, f2));
        }

        public void lineToRelative(float f, float f2) {
            this.namesAndValues.add(new PathNode.RelativeLineTo(f, f2));
        }

        public void moveTo(float f, float f2) {
            this.namesAndValues.add(new PathNode.MoveTo(f, f2));
        }

        public void reflectiveCurveTo(float f, float f2, float f3, float f4) {
            this.namesAndValues.add(new PathNode.ReflectiveCurveTo(f, f2, f3, f4));
        }

        public void reflectiveCurveToRelative(float f, float f2, float f3, float f4) {
            this.namesAndValues.add(new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4));
        }

        public void removeAll(String str) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.namesAndValues;
                if (i >= arrayList.size()) {
                    return;
                }
                if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                    arrayList.remove(i);
                    arrayList.remove(i);
                    i -= 2;
                }
                i += 2;
            }
        }

        public void set(String str, String str2) {
            Companion.checkName(str);
            Companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
        }

        public void verticalLineTo(float f) {
            this.namesAndValues.add(new PathNode.VerticalTo(f));
        }

        public void verticalLineToRelative(float f) {
            this.namesAndValues.add(new PathNode.RelativeVerticalTo(f));
        }

        public Builder(int i) {
            switch (i) {
                case 2:
                    this.namesAndValues = new ArrayList(32);
                    break;
                default:
                    this.namesAndValues = new ArrayList(20);
                    break;
            }
        }
    }
}
