package okhttp3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Cookie {
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static ImageVector _moreHoriz;

        public static int dateCharacterOffset(int i, int i2, String str, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0082  */
        public static long parseExpires(String str, int i) {
            int iDateCharacterOffset = dateCharacterOffset(0, i, str, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int iIndexOf$default = -1;
            int i5 = -1;
            int i6 = -1;
            while (iDateCharacterOffset < i) {
                int iDateCharacterOffset2 = dateCharacterOffset(iDateCharacterOffset + 1, i, str, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i3 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                    i5 = Integer.parseInt(matcher.group(2));
                    i6 = Integer.parseInt(matcher.group(3));
                } else if (i4 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                } else if (iIndexOf$default == -1) {
                    Pattern pattern = Cookie.MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        iIndexOf$default = StringsKt.indexOf$default(pattern.pattern(), matcher.group(1).toLowerCase(Locale.US), 0, false, 6) / 4;
                    } else if (i2 != -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                        i2 = Integer.parseInt(matcher.group(1));
                    }
                } else if (i2 != -1) {
                }
                iDateCharacterOffset = dateCharacterOffset(iDateCharacterOffset2 + 1, i, str, false);
            }
            if (70 <= i2 && i2 < 100) {
                i2 += 1900;
            }
            if (i2 >= 0 && i2 < 70) {
                i2 += 2000;
            }
            if (i2 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iIndexOf$default == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i4 || i4 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i3 < 0 || i3 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i5 < 0 || i5 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i2);
            gregorianCalendar.set(2, iIndexOf$default - 1);
            gregorianCalendar.set(5, i4);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i5);
            gregorianCalendar.set(13, i6);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public final int hashCode() {
        int iM = Modifier.CC.m(Modifier.CC.m(527, 31, this.name), 31, this.value);
        long j = this.expiresAt;
        return ((((((Modifier.CC.m(Modifier.CC.m((iM + ((int) (j ^ (j >>> 32)))) * 31, 31, this.domain), 31, this.path) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            long j = this.expiresAt;
            if (j == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(((DateFormat) DatesKt.STANDARD_DATE_FORMAT.get()).format(new Date(j)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
