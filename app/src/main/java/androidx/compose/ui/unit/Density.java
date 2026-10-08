package androidx.compose.ui.unit;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.work.impl.WorkLauncherImpl;
import com.caverock.androidsvg.SVGParser;
import com.google.android.gms.internal.mlkit_vision_barcode.zzez;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfe;
import com.google.firebase.encoders.FieldDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.xml.sax.Attributes;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo83roundToPx0680j_4(float f);

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo84toDpGaN1DYA(long j);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo85toDpu2uoSUM(float f);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo86toDpu2uoSUM(int i);

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo87toDpSizekrfVVM(long j);

    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo88toPxR2X_6o(long j);

    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo89toPx0680j_4(float f);

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo90toSizeXkaWNTQ(long j);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo91toSpkPz2Gy4(float f);

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract /* synthetic */ class CC {
        public static TextForegroundStyle $default$merge(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2) {
            boolean z = textForegroundStyle2 instanceof BrushStyle;
            if (!z || !(textForegroundStyle instanceof BrushStyle)) {
                if (!z || (textForegroundStyle instanceof BrushStyle)) {
                    return (z || !(textForegroundStyle instanceof BrushStyle)) ? textForegroundStyle2.takeOrElse(new BasicTextKt$$ExternalSyntheticLambda0(28, textForegroundStyle)) : textForegroundStyle;
                }
                return textForegroundStyle2;
            }
            BrushStyle brushStyle = (BrushStyle) textForegroundStyle2;
            ShaderBrush shaderBrush = brushStyle.value;
            float f = brushStyle.alpha;
            if (Float.isNaN(f)) {
                f = ((BrushStyle) textForegroundStyle).alpha;
            }
            return new BrushStyle(shaderBrush, f);
        }

        /* JADX INFO: renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m693$default$roundToPx0680j_4(Density density, float f) {
            float fMo89toPx0680j_4 = density.mo89toPx0680j_4(f);
            if (Float.isInfinite(fMo89toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return Math.round(fMo89toPx0680j_4);
        }

        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m694$default$toDpGaN1DYA(long j, Density density) {
            float fM724getValueimpl;
            float fontScale;
            if (!TextUnitType.m728equalsimpl0(TextUnit.m723getTypeUIouoOA(j), 4294967296L)) {
                InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
            }
            float[] fArr = FontScaleConverterFactory.CommonFontSizes;
            if (density.getFontScale() >= 1.03f) {
                FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(density.getFontScale());
                fM724getValueimpl = TextUnit.m724getValueimpl(j);
                if (fontScaleConverterForScale != null) {
                    return fontScaleConverterForScale.convertSpToDp(fM724getValueimpl);
                }
                fontScale = density.getFontScale();
            } else {
                fM724getValueimpl = TextUnit.m724getValueimpl(j);
                fontScale = density.getFontScale();
            }
            return fontScale * fM724getValueimpl;
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m695$default$toDpSizekrfVVM(long j, Density density) {
            if (j != 9205357640488583168L) {
                return DpKt.m703DpSizeYgX7TsA(density.mo85toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), density.mo85toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
            }
            return 9205357640488583168L;
        }

        /* JADX INFO: renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m696$default$toPxR2X_6o(long j, Density density) {
            if (!TextUnitType.m728equalsimpl0(TextUnit.m723getTypeUIouoOA(j), 4294967296L)) {
                InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
            }
            return density.mo89toPx0680j_4(density.mo84toDpGaN1DYA(j));
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m697$default$toSizeXkaWNTQ(long j, Density density) {
            if (j == 9205357640488583168L) {
                return 9205357640488583168L;
            }
            float fMo89toPx0680j_4 = density.mo89toPx0680j_4(DpSize.m708getWidthD9Ej5fM(j));
            float fMo89toPx0680j_5 = density.mo89toPx0680j_4(DpSize.m707getHeightD9Ej5fM(j));
            return (((long) Float.floatToRawIntBits(fMo89toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo89toPx0680j_5)) & 4294967295L);
        }

        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m698$default$toSp0xMU5do(Density density, float f) {
            float[] fArr = FontScaleConverterFactory.CommonFontSizes;
            if (density.getFontScale() < 1.03f) {
                return TextUnitKt.pack(f / density.getFontScale(), 4294967296L);
            }
            FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(density.getFontScale());
            return TextUnitKt.pack(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / density.getFontScale(), 4294967296L);
        }

        public static final void _applyState(View view, int i) {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal == 0) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                }
                view.setVisibility(0);
                return;
            }
            if (iOrdinal == 2) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                }
                view.setVisibility(8);
                return;
            }
            if (iOrdinal != 3) {
                return;
            }
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
            }
            view.setVisibility(4);
        }

        public static int _from(View view) {
            if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                return 4;
            }
            return _from(view.getVisibility());
        }

        public static final boolean _isFinished(int i) {
            return i == 3 || i == 4 || i == 6;
        }

        public static /* synthetic */ boolean getReadEnabled(int i) {
            if (i == 1 || i == 2) {
                return true;
            }
            if (i == 3 || i == 4) {
                return false;
            }
            throw null;
        }

        public static /* synthetic */ boolean getWriteEnabled(int i) {
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            if (i == 3) {
                return true;
            }
            if (i == 4) {
                return false;
            }
            throw null;
        }

        public static int m(Attributes attributes, int i) {
            return SVGParser.SVGAttr.fromString(attributes.getLocalName(i)).ordinal();
        }

        public static /* synthetic */ String name(int i) {
            switch (i) {
                case 1:
                    return "NONE";
                case 2:
                    return "LEFT";
                case 3:
                    return "TOP";
                case 4:
                    return "RIGHT";
                case 5:
                    return "BOTTOM";
                case 6:
                    return "BASELINE";
                case 7:
                    return "CENTER";
                case 8:
                    return "CENTER_X";
                case 9:
                    return "CENTER_Y";
                default:
                    throw null;
            }
        }

        public static /* synthetic */ String stringValueOf(int i) {
            if (i != 1) {
                return i != 2 ? "null" : "Rtl";
            }
            return "Ltr";
        }

        public static /* synthetic */ String stringValueOf$2(int i) {
            if (i == 1) {
                return "NONE";
            }
            if (i != 2) {
                return i != 3 ? "null" : "REMOVING";
            }
            return "ADDING";
        }

        public static /* synthetic */ String stringValueOf$3(int i) {
            if (i == 1) {
                return "REMOVED";
            }
            if (i == 2) {
                return "VISIBLE";
            }
            if (i != 3) {
                return i != 4 ? "null" : "INVISIBLE";
            }
            return "GONE";
        }

        public static /* synthetic */ String stringValueOf$4(int i) {
            switch (i) {
                case 1:
                    return "NOT_REQUIRED";
                case 2:
                    return "CONNECTED";
                case 3:
                    return "UNMETERED";
                case 4:
                    return "NOT_ROAMING";
                case 5:
                    return "METERED";
                case 6:
                    return "TEMPORARILY_UNMETERED";
                default:
                    return "null";
            }
        }

        public static /* synthetic */ String stringValueOf$5(int i) {
            switch (i) {
                case 1:
                    return "ENQUEUED";
                case 2:
                    return "RUNNING";
                case 3:
                    return "SUCCEEDED";
                case 4:
                    return "FAILED";
                case 5:
                    return "BLOCKED";
                case 6:
                    return "CANCELLED";
                default:
                    return "null";
            }
        }

        public static /* synthetic */ int valueOf(String str) {
            if (str == null) {
                throw new NullPointerException("Name is null");
            }
            if (str.equals("pad")) {
                return 1;
            }
            if (str.equals("reflect")) {
                return 2;
            }
            if (str.equals("repeat")) {
                return 3;
            }
            throw new IllegalArgumentException("No enum constant com.caverock.androidsvg.SVG.GradientSpread.".concat(str));
        }

        public static /* synthetic */ int valueOf$1(String str) {
            if (str == null) {
                throw new NullPointerException("Name is null");
            }
            if (str.equals("px")) {
                return 1;
            }
            if (str.equals("em")) {
                return 2;
            }
            if (str.equals("ex")) {
                return 3;
            }
            if (str.equals("in")) {
                return 4;
            }
            if (str.equals("cm")) {
                return 5;
            }
            if (str.equals("mm")) {
                return 6;
            }
            if (str.equals("pt")) {
                return 7;
            }
            if (str.equals("pc")) {
                return 8;
            }
            if (str.equals("percent")) {
                return 9;
            }
            throw new IllegalArgumentException("No enum constant com.caverock.androidsvg.SVG.Unit.".concat(str));
        }

        public static int _from(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == 4) {
                return 4;
            }
            if (i == 8) {
                return 3;
            }
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown visibility ", i));
        }

        public static zzez m(HashMap map, int i) {
            Collections.unmodifiableMap(new HashMap(map));
            return new zzez(i);
        }

        public static FieldDescriptor m(int i, WorkLauncherImpl workLauncherImpl) {
            Map mapUnmodifiableMap;
            zzez zzezVar = new zzez(i);
            if (((HashMap) workLauncherImpl.workTaskExecutor) == null) {
                workLauncherImpl.workTaskExecutor = new HashMap();
            }
            ((HashMap) workLauncherImpl.workTaskExecutor).put(zzfe.class, zzezVar);
            String str = (String) workLauncherImpl.processor;
            if (((HashMap) workLauncherImpl.workTaskExecutor) == null) {
                mapUnmodifiableMap = Collections.EMPTY_MAP;
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap((HashMap) workLauncherImpl.workTaskExecutor));
            }
            return new FieldDescriptor(str, mapUnmodifiableMap);
        }

        public static Object m(int i, GapComposer gapComposer, boolean z) {
            gapComposer.end(z);
            gapComposer.startReplaceGroup(i);
            return gapComposer.rememberedValue();
        }

        public static HashMap m(Class cls, zzez zzezVar) {
            HashMap map = new HashMap();
            map.put(cls, zzezVar);
            return map;
        }

        public static Map m(HashMap map) {
            return Collections.unmodifiableMap(new HashMap(map));
        }

        public static void m(int i, HashMap map, String str, int i2, String str2) {
            map.put(str, Integer.valueOf(i));
            map.put(str2, Integer.valueOf(i2));
        }

        public static /* synthetic */ void m(AutoCloseable autoCloseable) throws Exception {
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (autoCloseable instanceof ExecutorService) {
                LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) autoCloseable);
                return;
            }
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            }
            if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }

        public static void m(StringBuilder sb, String str, String str2, String str3, String str4) {
            sb.append(str);
            sb.append(str2);
            sb.append(str3);
            sb.append(str4);
        }

        /* JADX INFO: renamed from: m, reason: collision with other method in class */
        public static void m699m(HashMap map) {
            Collections.unmodifiableMap(new HashMap(map));
        }
    }
}
