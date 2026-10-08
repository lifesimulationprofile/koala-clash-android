package okhttp3.internal.http;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.layout.DefaultLazyKey;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.CalculateMatrixToWindowApi21;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.R$styleable;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.view.ViewCompat;
import coil.ImageLoader$Builder;
import com.caverock.androidsvg.SVG;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zzff;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxb;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.material.textfield.IconHelper;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.internal.JsonPath$Tombstone;
import okhttp3.ConnectionSpec;
import okhttp3.Protocol;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class StatusLine implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int $r8$classId;
    public int code;
    public Object message;
    public Object protocol;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class Companion {
        public static ImageVector _shield;

        public static StatusLine parse(String str) throws ProtocolException {
            int i;
            String strSubstring;
            boolean zStartsWith = StringsKt__StringsJVMKt.startsWith(str, "HTTP/1.", false);
            Protocol protocol = Protocol.HTTP_1_0;
            if (zStartsWith) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt != 0) {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!StringsKt__StringsJVMKt.startsWith(str, "ICY ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            try {
                int i3 = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    strSubstring = str.substring(i + 4);
                }
                return new StatusLine(protocol, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        }
    }

    public StatusLine(int i, String str, String str2) {
        this.$r8$classId = 12;
        this.message = str;
        this.protocol = str2;
        this.code = i;
    }

    public static StatusLine createFromXml(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f;
        float f2;
        int i2;
        Shader.TileMode tileMode;
        Object radialGradient;
        Shader.TileMode tileMode2;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        int i3 = 8;
        Object obj = null;
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListCreateFromXmlInner = ColorStateListInflaterCompat.createFromXmlInner(resources, xml, attributeSetAsAttributeSet, theme);
                return new StatusLine(obj, colorStateListCreateFromXmlInner, colorStateListCreateFromXmlInner.getDefaultColor(), i3);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, R$styleable.GradientColor);
        float f3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null ? typedArrayObtainAttributes.getFloat(8, 0.0f) : 0.0f;
        float f4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null ? typedArrayObtainAttributes.getFloat(9, 0.0f) : 0.0f;
        float f5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null ? typedArrayObtainAttributes.getFloat(10, 0.0f) : 0.0f;
        float f6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null ? typedArrayObtainAttributes.getFloat(11, 0.0f) : 0.0f;
        float f7 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null ? typedArrayObtainAttributes.getFloat(3, 0.0f) : 0.0f;
        float f8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null ? typedArrayObtainAttributes.getFloat(4, 0.0f) : 0.0f;
        int i4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "type") != null ? typedArrayObtainAttributes.getInt(2, 0) : 0;
        int color = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null ? typedArrayObtainAttributes.getColor(0, 0) : 0;
        boolean z = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null ? typedArrayObtainAttributes.getColor(7, 0) : 0;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null ? typedArrayObtainAttributes.getColor(1, 0) : 0;
        int i5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null ? typedArrayObtainAttributes.getInt(6, 0) : 0;
        float f9 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null ? typedArrayObtainAttributes.getFloat(5, 0.0f) : 0.0f;
        typedArrayObtainAttributes.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f10 = f9;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f = f4;
            if (next2 == 1) {
                f2 = f5;
                break;
            }
            int depth2 = xml.getDepth();
            f2 = f5;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, R$styleable.GradientColorItem);
                boolean zHasValue = typedArrayObtainAttributes2.hasValue(0);
                boolean zHasValue2 = typedArrayObtainAttributes2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayObtainAttributes2.getColor(0, 0);
                float f11 = typedArrayObtainAttributes2.getFloat(1, 0.0f);
                typedArrayObtainAttributes2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f11));
            }
            f4 = f;
            f5 = f2;
        }
        CalculateMatrixToWindowApi21 calculateMatrixToWindowApi21 = arrayList2.size() > 0 ? new CalculateMatrixToWindowApi21(arrayList2, arrayList) : null;
        if (calculateMatrixToWindowApi21 == null) {
            calculateMatrixToWindowApi21 = z ? new CalculateMatrixToWindowApi21(color, color2, color3) : new CalculateMatrixToWindowApi21(color, color3);
        }
        if (i4 == 1) {
            i2 = 0;
            if (f10 <= 0.0f) {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            int[] iArr = calculateMatrixToWindowApi21.tmpLocation;
            float[] fArr = calculateMatrixToWindowApi21.tmpMatrix;
            if (i5 != 1) {
                tileMode = i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode = Shader.TileMode.REPEAT;
            }
            radialGradient = new RadialGradient(f7, f8, f10, iArr, fArr, tileMode);
        } else if (i4 != 2) {
            int[] iArr2 = calculateMatrixToWindowApi21.tmpLocation;
            float[] fArr2 = calculateMatrixToWindowApi21.tmpMatrix;
            if (i5 != 1) {
                tileMode2 = i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode2 = Shader.TileMode.REPEAT;
            }
            i2 = 0;
            radialGradient = new LinearGradient(f3, f, f2, f6, iArr2, fArr2, tileMode2);
        } else {
            i2 = 0;
            radialGradient = new SweepGradient(f7, f8, calculateMatrixToWindowApi21.tmpLocation, calculateMatrixToWindowApi21.tmpMatrix);
        }
        return new StatusLine(radialGradient, null, i2, 8);
    }

    public void addInterval(int i, ImageLoader$Builder imageLoader$Builder) {
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("size should be >=0");
        }
        if (i == 0) {
            return;
        }
        IntervalList$Interval intervalList$Interval = new IntervalList$Interval(this.code, i, imageLoader$Builder);
        this.code += i;
        ((MutableVector) this.protocol).add(intervalList$Interval);
    }

    public void applySupportImageTint() {
        ConnectionSpec.Builder builder;
        ImageView imageView = (ImageView) this.protocol;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable == null || (builder = (ConnectionSpec.Builder) this.message) == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, builder, imageView.getDrawableState());
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        TooltipPopup tooltipPopup = (TooltipPopup) this.protocol;
        ((SVG) tooltipPopup.mLayoutParams).schedule((AutoValue_TransportContext) this.message, this.code + 1, false);
        return null;
    }

    public IntervalList$Interval get(int i) {
        if (i < 0 || i >= this.code) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Index ", ", size ");
            sbM.append(this.code);
            InlineClassHelperKt.throwIndexOutOfBoundsException(sbM.toString());
        }
        IntervalList$Interval intervalList$Interval = (IntervalList$Interval) this.message;
        if (intervalList$Interval != null) {
            int i2 = intervalList$Interval.startIndex;
            if (i < intervalList$Interval.size + i2 && i2 <= i) {
                return intervalList$Interval;
            }
        }
        MutableVector mutableVector = (MutableVector) this.protocol;
        IntervalList$Interval intervalList$Interval2 = (IntervalList$Interval) mutableVector.content[LazyLayoutKt.access$binarySearch(i, mutableVector)];
        this.message = intervalList$Interval2;
        return intervalList$Interval2;
    }

    public int getIndex(Object obj) {
        MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.protocol;
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(obj);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        return -1;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.code + 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = ((Object[]) this.protocol)[i2];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.MAP.INSTANCE$2)) {
                    int i3 = ((int[]) this.message)[i2];
                    if (i3 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.getElementName(i3));
                    }
                } else if (((int[]) this.message)[i2] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.message)[i2]);
                    sb.append("]");
                }
            } else if (obj != JsonPath$Tombstone.INSTANCE) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public void insert(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, int i7) {
        long[] jArr = (long[]) this.protocol;
        int i8 = this.code;
        int i9 = i8 + 3;
        this.code = i9;
        int length = jArr.length;
        if (length <= i9) {
            int iMax = Math.max(length * 2, i9);
            this.protocol = Arrays.copyOf(jArr, iMax);
            this.message = Arrays.copyOf((long[]) this.message, iMax);
        }
        long[] jArr2 = (long[]) this.protocol;
        jArr2[i8] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
        jArr2[i8 + 1] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
        int i10 = i6 & 33554431;
        jArr2[i8 + 2] = ((z3 ? 1L : 0L) << 63) | ((z2 ? 1L : 0L) << 62) | ((z ? 1L : 0L) << 61) | (((long) 1) << 60) | (((long) Math.min(0, 1023)) << 50) | (((long) i10) << 25) | ((long) (i & 33554431));
        if (i6 < 0) {
            return;
        }
        for (int i11 = i7 != -1 ? i7 : i8 - 3; i11 >= 0; i11 -= 3) {
            int i12 = i11 + 2;
            long j = jArr2[i12];
            if ((((int) j) & 33554431) == i10) {
                jArr2[i12] = (j & RectListKt.EverythingButLastChildOffset) | (((long) Math.min((i8 - i11) / 3, 1023)) << 50);
                return;
            }
        }
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return ((Shader) this.protocol) == null && (colorStateList = (ColorStateList) this.message) != null && colorStateList.isStateful();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.protocol;
        Context context = imageView.getContext();
        int[] iArr = androidx.appcompat.R$styleable.AppCompatImageView;
        ImageLoader$Builder imageLoader$BuilderObtainStyledAttributes = ImageLoader$Builder.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) imageLoader$BuilderObtainStyledAttributes.defaults;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) imageLoader$BuilderObtainStyledAttributes.defaults, i, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = IconHelper.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(imageLoader$BuilderObtainStyledAttributes.getColorStateList(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
            }
        } finally {
            imageLoader$BuilderObtainStyledAttributes.recycle();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder();
                if (((Protocol) this.protocol) == Protocol.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.code);
                sb.append(' ');
                sb.append((String) this.message);
                return sb.toString();
            case 13:
                return getPath();
            default:
                return super.toString();
        }
    }

    public void updateHasCallbacks(int i, boolean z) {
        int i2 = i & 33554431;
        long[] jArr = (long[]) this.protocol;
        int i3 = this.code;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            int i5 = i4 + 2;
            long j = jArr[i5];
            if ((((int) j) & 33554431) == i2) {
                long j2 = z ? 1L : 0L;
                jArr[i5] = (j2 * Long.MIN_VALUE) | (8070450532247928831L & j) | (1152921504606846976L * j2);
                return;
            }
        }
    }

    public void updateSubhierarchy(int i, int i2, long j) {
        int i3;
        char c;
        char c2;
        long[] jArr = (long[]) this.protocol;
        long[] jArr2 = (long[]) this.message;
        jArr2[0] = j;
        int i4 = 1;
        while (i4 > 0) {
            i4--;
            long j2 = jArr2[i4];
            int i5 = 33554431;
            int i6 = ((int) j2) & 33554431;
            char c3 = 25;
            int i7 = ((int) (j2 >> 25)) & 33554431;
            char c4 = '2';
            int i8 = ((int) (j2 >> 50)) & 1023;
            int i9 = i8 == 1023 ? this.code : (i8 * 3) + i7;
            if (i7 < 0) {
                return;
            }
            while (i7 < jArr.length - 2 && i7 < i9) {
                int i10 = i7 + 2;
                long j3 = jArr[i10];
                if ((((int) (j3 >> c3)) & i5) == i6) {
                    long j4 = jArr[i7];
                    int i11 = i7 + 1;
                    i3 = i5;
                    c = c3;
                    long j5 = jArr[i11];
                    c2 = c4;
                    jArr[i7] = (((long) (((int) j4) + i2)) & 4294967295L) | (((long) (((int) (j4 >> 32)) + i)) << 32);
                    jArr[i11] = (((long) (((int) j5) + i2)) & 4294967295L) | (((long) (((int) (j5 >> 32)) + i)) << 32);
                    jArr[i10] = (((j3 >> 63) & 1) << 60) | j3;
                    if ((((int) (j3 >> c2)) & 1023) > 0) {
                        jArr2[i4] = (RectListKt.EverythingButParentId & j3) | (((long) ((i7 + 3) & i3)) << c);
                        i4++;
                    }
                } else {
                    i3 = i5;
                    c = c3;
                    c2 = c4;
                }
                i7 += 3;
                i5 = i3;
                c3 = c;
                c4 = c2;
            }
        }
    }

    public void withRect(int i, Function4 function4) {
        int i2 = i & 33554431;
        long[] jArr = (long[]) this.protocol;
        int i3 = this.code;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & 33554431) == i2) {
                long j = jArr[i4];
                long j2 = jArr[i4 + 1];
                function4.invoke(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return;
            }
        }
    }

    public void zza(String str, Feature feature) {
        int i = this.code + 1;
        Object[] objArr = (Object[]) this.protocol;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.protocol = Arrays.copyOf(objArr, i3);
        }
        Object[] objArr2 = (Object[]) this.protocol;
        int i4 = this.code;
        int i5 = i4 + i4;
        objArr2[i5] = str;
        objArr2[i5 + 1] = feature;
        this.code = i4 + 1;
    }

    public byte[] zze(int i) {
        AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = (AppCompatDrawableManager.AnonymousClass1) this.protocol;
        ((zzky) this.message).zzi = Boolean.valueOf(1 == (i ^ 1));
        zzky zzkyVar = (zzky) this.message;
        zzkyVar.zzg = Boolean.FALSE;
        anonymousClass1.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new zzvd(zzkyVar);
        try {
            zzxb.zza();
            zzxb zzxbVar = zzxb.zza$1;
            if (i == 0) {
                zzrf zzrfVar = new zzrf(anonymousClass1);
                JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
                zzxbVar.configure(jsonDataEncoderBuilder);
                jsonDataEncoderBuilder.ignoreNullValues = true;
                StringWriter stringWriter = new StringWriter();
                try {
                    JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(stringWriter, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                    jsonValueObjectEncoderContext.add(zzrfVar);
                    jsonValueObjectEncoderContext.maybeUnNest();
                    jsonValueObjectEncoderContext.jsonWriter.flush();
                } catch (IOException unused) {
                }
                return stringWriter.toString().getBytes("utf-8");
            }
            zzrf zzrfVar2 = new zzrf(anonymousClass1);
            zzfi zzfiVar = new zzfi();
            zzfiVar.zzc = new HashMap();
            zzfiVar.zzd = new HashMap();
            zzfiVar.zze = zzfi.zzb;
            zzxbVar.configure(zzfiVar);
            HashMap map = new HashMap((HashMap) zzfiVar.zzc);
            HashMap map2 = new HashMap((HashMap) zzfiVar.zzd);
            zzff zzffVar = (zzff) zzfiVar.zze;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                zzfg zzfgVar = new zzfg(byteArrayOutputStream, map, map2, zzffVar);
                ObjectEncoder objectEncoder = (ObjectEncoder) map.get(zzrf.class);
                if (objectEncoder == null) {
                    throw new EncodingException("No encoder for ".concat(String.valueOf(zzrf.class)));
                }
                objectEncoder.encode(zzrfVar2, zzfgVar);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused2) {
            }
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public /* synthetic */ StatusLine(int i, boolean z) {
        this.$r8$classId = i;
    }

    public /* synthetic */ StatusLine(Object obj, Object obj2, int i, int i2) {
        this.$r8$classId = i2;
        this.protocol = obj;
        this.message = obj2;
        this.code = i;
    }

    public StatusLine(AppCompatDrawableManager.AnonymousClass1 anonymousClass1, int i) {
        this.$r8$classId = 11;
        this.message = new zzky();
        this.protocol = anonymousClass1;
        zzxb.zza();
        this.code = i;
    }

    public StatusLine(Protocol protocol, int i, String str) {
        this.$r8$classId = 0;
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public StatusLine(ArrayList arrayList, int i, MotionEvent motionEvent) {
        this.$r8$classId = 6;
        this.protocol = arrayList;
        this.code = i;
        this.message = motionEvent;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("changes cannot be empty");
        }
    }

    public StatusLine(ImageView imageView) {
        this.$r8$classId = 1;
        this.code = 0;
        this.protocol = imageView;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ca  */
    public StatusLine(IntRange intRange, LazyListIntervalContent lazyListIntervalContent) {
        Object defaultLazyKey;
        this.$r8$classId = 3;
        StatusLine statusLine = lazyListIntervalContent.intervals;
        int i = intRange.first;
        if (i < 0) {
            InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
        }
        int iMin = Math.min(intRange.last, statusLine.code - 1);
        if (iMin < i) {
            this.protocol = ObjectIntMapKt.EmptyObjectIntMap;
            this.message = new Object[0];
            this.code = 0;
            return;
        }
        int i2 = (iMin - i) + 1;
        this.message = new Object[i2];
        this.code = i;
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i2);
        MutableVector mutableVector = (MutableVector) statusLine.protocol;
        if (i < 0 || i >= statusLine.code) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Index ", ", size ");
            sbM.append(statusLine.code);
            InlineClassHelperKt.throwIndexOutOfBoundsException(sbM.toString());
        }
        if (iMin < 0 || iMin >= statusLine.code) {
            StringBuilder sbM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(iMin, "Index ", ", size ");
            sbM2.append(statusLine.code);
            InlineClassHelperKt.throwIndexOutOfBoundsException(sbM2.toString());
        }
        if (iMin < i) {
            InlineClassHelperKt.throwIllegalArgumentException("toIndex (" + iMin + ") should be not smaller than fromIndex (" + i + ')');
        }
        int iAccess$binarySearch = LazyLayoutKt.access$binarySearch(i, mutableVector);
        int i3 = ((IntervalList$Interval) mutableVector.content[iAccess$binarySearch]).startIndex;
        while (i3 <= iMin) {
            IntervalList$Interval intervalList$Interval = (IntervalList$Interval) mutableVector.content[iAccess$binarySearch];
            Function1 function1 = (Function1) intervalList$Interval.value.applicationContext;
            int i4 = intervalList$Interval.startIndex;
            int iMax = Math.max(i, i4);
            int iMin2 = Math.min(iMin, (intervalList$Interval.size + i4) - 1);
            if (iMax <= iMin2) {
                while (true) {
                    if (function1 != null) {
                        defaultLazyKey = function1.invoke(Integer.valueOf(iMax - i4));
                        defaultLazyKey = defaultLazyKey == null ? new DefaultLazyKey(iMax) : defaultLazyKey;
                    }
                    mutableObjectIntMap.set(iMax, defaultLazyKey);
                    ((Object[]) this.message)[iMax - this.code] = defaultLazyKey;
                    iMax = iMax != iMin2 ? iMax + 1 : iMax;
                }
            }
            Unit unit = Unit.INSTANCE;
            i3 += intervalList$Interval.size;
            iAccess$binarySearch++;
        }
        this.protocol = mutableObjectIntMap;
    }

    public StatusLine(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 10:
                this.protocol = new Object[8];
                this.code = 0;
                break;
            default:
                this.protocol = new MutableVector(new IntervalList$Interval[16]);
                break;
        }
    }

    public StatusLine(ViewConfiguration viewConfiguration) {
        this.$r8$classId = 4;
        this.protocol = viewConfiguration;
    }
}
