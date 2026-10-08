package coil.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import androidx.arch.core.executor.TaskExecutor;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.compose.AsyncImagePainter;
import coil.network.HttpException;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.SvgUtils;
import coil.util.Utils;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGAndroidRenderer;
import com.caverock.androidsvg.SVGParser;
import com.github.kr328.clash.ApkBrokenActivity;
import com.github.kr328.clash.AppCrashedActivity;
import com.github.kr328.clash.ConnectionsActivity;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.MainActivity;
import com.github.kr328.clash.MainApplication;
import com.github.kr328.clash.ProvidersActivity;
import com.github.kr328.clash.ShareToTvActivity;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.FilesProvider;
import com.github.kr328.clash.service.document.Picker;
import com.google.android.gms.dynamite.zzo;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNode$areaPreDrawListener$2$1;
import dev.chrisbanes.haze.HazeSourceNode;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import io.github.g00fy2.quickie.QRScannerActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.internal.Platform_commonKt;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.PeekSource;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SvgDecoder$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SvgDecoder$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0230  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        float fWidth;
        float fHeight;
        int i;
        int i2;
        float fMax;
        ExifData exifData;
        int i3;
        int i4;
        int iMin;
        double dMax;
        Bitmap bitmapCreateBitmap;
        ColorSpace colorSpace;
        int i5;
        zzo zzoVar;
        int i6 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i6) {
            case 0:
                SvgDecoder svgDecoder = (SvgDecoder) obj;
                ResponseBody responseBody = svgDecoder.source;
                Options options = svgDecoder.options;
                BufferedSource bufferedSourceSource = responseBody.source();
                try {
                    SVG fromInputStream = SVG.getFromInputStream(bufferedSourceSource.inputStream());
                    bufferedSourceSource.close();
                    SVG.Svg svg = (SVG.Svg) fromInputStream.rootElement;
                    if (svg == null) {
                        throw new IllegalArgumentException("SVG document is empty");
                    }
                    SVG.Box box = svg.viewBox;
                    RectF rectF = box == null ? null : new RectF(box.minX, box.minY, box.maxX(), box.maxY());
                    if (rectF != null) {
                        fWidth = rectF.width();
                        fHeight = rectF.height();
                    } else {
                        if (((SVG.Svg) fromInputStream.rootElement) == null) {
                            throw new IllegalArgumentException("SVG document is empty");
                        }
                        fWidth = fromInputStream.getDocumentDimensions().width;
                        if (((SVG.Svg) fromInputStream.rootElement) == null) {
                            throw new IllegalArgumentException("SVG document is empty");
                        }
                        fHeight = fromInputStream.getDocumentDimensions().height;
                    }
                    int i7 = options.scale;
                    Size size = options.size;
                    Pair pair = Intrinsics.areEqual(size, Size.ORIGINAL) ? new Pair(Float.valueOf(fWidth > 0.0f ? fWidth : 512.0f), Float.valueOf(fHeight > 0.0f ? fHeight : 512.0f)) : new Pair(Float.valueOf(SvgUtils.toPx(size.width, i7)), Float.valueOf(SvgUtils.toPx(size.height, i7)));
                    float fFloatValue = ((Number) pair.first).floatValue();
                    float fFloatValue2 = ((Number) pair.second).floatValue();
                    if (fWidth <= 0.0f || fHeight <= 0.0f) {
                        int iRoundToInt = MathKt.roundToInt(fFloatValue);
                        int iRoundToInt2 = MathKt.roundToInt(fFloatValue2);
                        i = iRoundToInt;
                        i2 = iRoundToInt2;
                    } else {
                        float f = fFloatValue / fWidth;
                        float f2 = fFloatValue2 / fHeight;
                        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(options.scale);
                        if (iOrdinal == 0) {
                            fMax = Math.max(f, f2);
                        } else {
                            if (iOrdinal != 1) {
                                throw new HttpException();
                            }
                            fMax = Math.min(f, f2);
                        }
                        i = (int) (fMax * fWidth);
                        i2 = (int) (fMax * fHeight);
                    }
                    if (rectF == null && fWidth > 0.0f && fHeight > 0.0f) {
                        SVG.Svg svg2 = (SVG.Svg) fromInputStream.rootElement;
                        if (svg2 == null) {
                            throw new IllegalArgumentException("SVG document is empty");
                        }
                        svg2.viewBox = new SVG.Box(0.0f, 0.0f, fWidth, fHeight);
                    }
                    SVG.Svg svg3 = (SVG.Svg) fromInputStream.rootElement;
                    if (svg3 == null) {
                        throw new IllegalArgumentException("SVG document is empty");
                    }
                    svg3.width = SVGParser.parseLength("100%");
                    SVG.Svg svg4 = (SVG.Svg) fromInputStream.rootElement;
                    if (svg4 == null) {
                        throw new IllegalArgumentException("SVG document is empty");
                    }
                    svg4.height = SVGParser.parseLength("100%");
                    Bitmap.Config config = options.config;
                    if (config == null || (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE)) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i2, config);
                    if (options.parameters.entries.get("coil#css") != null) {
                        throw new ClassCastException();
                    }
                    Canvas canvas = new Canvas(bitmapCreateBitmap2);
                    SVG.Box box2 = new SVG.Box(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
                    SVGAndroidRenderer sVGAndroidRenderer = new SVGAndroidRenderer();
                    sVGAndroidRenderer.canvas = canvas;
                    sVGAndroidRenderer.document = fromInputStream;
                    SVG.Svg svg5 = (SVG.Svg) fromInputStream.rootElement;
                    if (svg5 == null) {
                        Log.w("SVGAndroidRenderer", "Nothing to render. Document is empty.");
                    } else {
                        SVG.Box box3 = svg5.viewBox;
                        PreserveAspectRatio preserveAspectRatio = svg5.preserveAspectRatio;
                        sVGAndroidRenderer.state = new SVGAndroidRenderer.RendererState();
                        sVGAndroidRenderer.stateStack = new Stack();
                        sVGAndroidRenderer.updateStyle((SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state, SVG.Style.getDefaultStyle());
                        SVGAndroidRenderer.RendererState rendererState = (SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state;
                        rendererState.viewPort = null;
                        rendererState.spacePreserve = false;
                        ((Stack) sVGAndroidRenderer.stateStack).push(new SVGAndroidRenderer.RendererState(rendererState));
                        sVGAndroidRenderer.matrixStack = new Stack();
                        sVGAndroidRenderer.parentStack = new Stack();
                        Boolean bool = svg5.spacePreserve;
                        if (bool != null) {
                            ((SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state).spacePreserve = bool.booleanValue();
                        }
                        sVGAndroidRenderer.statePush();
                        SVG.Box box4 = new SVG.Box(box2);
                        SVG.Length length = svg5.width;
                        if (length != null) {
                            box4.width = length.floatValue(sVGAndroidRenderer, box4.width);
                        }
                        SVG.Length length2 = svg5.height;
                        if (length2 != null) {
                            box4.height = length2.floatValue(sVGAndroidRenderer, box4.height);
                        }
                        sVGAndroidRenderer.render(svg5, box4, box3, preserveAspectRatio);
                        sVGAndroidRenderer.statePop();
                    }
                    return new DecodeResult(new BitmapDrawable(options.context.getResources(), bitmapCreateBitmap2), true);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedSourceSource, th);
                        throw th2;
                    }
                }
            case 1:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) obj;
                savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(savedStateRegistryOwner, 0));
                return Unit.INSTANCE;
            case 2:
                return (ImageRequest) ((AsyncImagePainter) obj).request$delegate.getValue();
            case 3:
                BitmapFactoryDecoder bitmapFactoryDecoder = (BitmapFactoryDecoder) obj;
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                Options options3 = bitmapFactoryDecoder.options;
                ResponseBody responseBody2 = bitmapFactoryDecoder.source;
                BitmapFactoryDecoder.ExceptionCatchingSource exceptionCatchingSource = new BitmapFactoryDecoder.ExceptionCatchingSource(responseBody2.source());
                RealBufferedSource realBufferedSource = new RealBufferedSource(exceptionCatchingSource);
                options2.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new Buffer.AnonymousClass1(new RealBufferedSource(new PeekSource(realBufferedSource)), 1), null, options2);
                Exception exc = exceptionCatchingSource.exception;
                if (exc != null) {
                    throw exc;
                }
                options2.inJustDecodeBounds = false;
                Paint paint = ExifUtils.PAINT;
                String str = options2.outMimeType;
                Set set = ExifUtilsKt.RESPECT_PERFORMANCE_MIME_TYPES;
                int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
                if (iOrdinal2 == 0) {
                    exifData = ExifData.NONE;
                } else {
                    if (iOrdinal2 != 1) {
                        if (iOrdinal2 != 2) {
                            throw new HttpException();
                        }
                    } else if (str == null || !ExifUtilsKt.RESPECT_PERFORMANCE_MIME_TYPES.contains(str)) {
                        exifData = ExifData.NONE;
                    }
                    ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(new Buffer.AnonymousClass1(new RealBufferedSource(new PeekSource(realBufferedSource)), 1)));
                    int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                    boolean z = attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
                    switch (exifInterface.getAttributeInt("Orientation", 1)) {
                        case 3:
                        case 4:
                            i5 = 180;
                            break;
                        case 5:
                        case 8:
                            i5 = 270;
                            break;
                        case 6:
                        case 7:
                            i5 = 90;
                            break;
                        default:
                            i5 = 0;
                            break;
                    }
                    exifData = new ExifData(i5, z);
                }
                int i8 = exifData.rotationDegrees;
                boolean z2 = exifData.isFlipped;
                Exception exc2 = exceptionCatchingSource.exception;
                if (exc2 != null) {
                    throw exc2;
                }
                options2.inMutable = false;
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 26 && (colorSpace = options3.colorSpace) != null) {
                    options2.inPreferredColorSpace = colorSpace;
                }
                boolean z3 = options3.premultipliedAlpha;
                Context context = options3.context;
                Size size2 = options3.size;
                options2.inPremultiplied = z3;
                Bitmap.Config config2 = options3.config;
                if ((z2 || i8 > 0) && (config2 == null || Bitmaps.isHardware(config2))) {
                    config2 = Bitmap.Config.ARGB_8888;
                }
                if (options3.allowRgb565 && config2 == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options2.outMimeType, "image/jpeg")) {
                    config2 = Bitmap.Config.RGB_565;
                }
                if (i9 >= 26 && options2.outConfig == Bitmap.Config.RGBA_F16 && config2 != Bitmap.Config.HARDWARE) {
                    config2 = Bitmap.Config.RGBA_F16;
                }
                options2.inPreferredConfig = config2;
                ImageSource$Metadata metadata = responseBody2.getMetadata();
                if ((metadata instanceof ResourceMetadata) && Intrinsics.areEqual(size2, Size.ORIGINAL)) {
                    options2.inSampleSize = 1;
                    options2.inScaled = true;
                    options2.inDensity = ((ResourceMetadata) metadata).density;
                    options2.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                    i3 = 1;
                } else {
                    int i10 = options2.outWidth;
                    if (i10 <= 0 || (i4 = options2.outHeight) <= 0) {
                        i3 = 1;
                        options2.inSampleSize = 1;
                        options2.inScaled = false;
                    } else {
                        int i11 = (i8 == 90 || i8 == 270) ? i4 : i10;
                        if (i8 != 90 && i8 != 270) {
                            i10 = i4;
                        }
                        int i12 = options3.scale;
                        Size size3 = Size.ORIGINAL;
                        int px = Intrinsics.areEqual(size2, size3) ? i11 : Utils.toPx(size2.width, i12);
                        int px2 = Intrinsics.areEqual(size2, size3) ? i10 : Utils.toPx(size2.height, i12);
                        int iHighestOneBit = Integer.highestOneBit(i11 / px);
                        int iHighestOneBit2 = Integer.highestOneBit(i10 / px2);
                        int iOrdinal3 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i12);
                        if (iOrdinal3 == 0) {
                            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                        } else {
                            if (iOrdinal3 != 1) {
                                throw new HttpException();
                            }
                            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                        }
                        if (iMin < 1) {
                            iMin = 1;
                        }
                        options2.inSampleSize = iMin;
                        double d = iMin;
                        double d2 = ((double) i10) / d;
                        double d3 = ((double) px) / (((double) i11) / d);
                        double d4 = ((double) px2) / d2;
                        int iOrdinal4 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i12);
                        if (iOrdinal4 == 0) {
                            dMax = Math.max(d3, d4);
                        } else {
                            if (iOrdinal4 != 1) {
                                throw new HttpException();
                            }
                            dMax = Math.min(d3, d4);
                        }
                        if (options3.allowInexactSize && dMax > 1.0d) {
                            dMax = 1.0d;
                        }
                        boolean z4 = dMax == 1.0d;
                        options2.inScaled = !z4;
                        if (!z4) {
                            if (dMax > 1.0d) {
                                options2.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / dMax);
                                options2.inTargetDensity = Integer.MAX_VALUE;
                            } else {
                                options2.inDensity = Integer.MAX_VALUE;
                                options2.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * dMax);
                            }
                        }
                        i3 = 1;
                    }
                }
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new Buffer.AnonymousClass1(realBufferedSource, i3), null, options2);
                    realBufferedSource.close();
                    Exception exc3 = exceptionCatchingSource.exception;
                    if (exc3 != null) {
                        throw exc3;
                    }
                    if (bitmapDecodeStream == null) {
                        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    }
                    bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                    if (z2 != 0 || i8 > 0) {
                        Matrix matrix = new Matrix();
                        float width = bitmapDecodeStream.getWidth() / 2.0f;
                        float height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z2) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i8 > 0) {
                            matrix.postRotate(i8, width, height);
                        }
                        RectF rectF2 = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF2);
                        float f3 = rectF2.left;
                        if (f3 != 0.0f || rectF2.top != 0.0f) {
                            matrix.postTranslate(-f3, -rectF2.top);
                        }
                        if (i8 == 90 || i8 == 270) {
                            int height2 = bitmapDecodeStream.getHeight();
                            int width2 = bitmapDecodeStream.getWidth();
                            Bitmap.Config config3 = bitmapDecodeStream.getConfig();
                            if (config3 == null) {
                                config3 = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config3);
                        } else {
                            int width3 = bitmapDecodeStream.getWidth();
                            int height3 = bitmapDecodeStream.getHeight();
                            Bitmap.Config config4 = bitmapDecodeStream.getConfig();
                            if (config4 == null) {
                                config4 = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config4);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, ExifUtils.PAINT);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    }
                    return new DecodeResult(new BitmapDrawable(context.getResources(), bitmapDecodeStream), options2.inSampleSize > 1 || options2.inScaled);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(realBufferedSource, th3);
                        throw th4;
                    }
                }
            case 4:
                ((ApkBrokenActivity) obj).finish();
                return Unit.INSTANCE;
            case 5:
                ((AppCrashedActivity) obj).finish();
                return Unit.INSTANCE;
            case 6:
                ((ConnectionsActivity) obj).finish();
                return Unit.INSTANCE;
            case 7:
                int i13 = FilesActivity.$r8$clinit;
                return Boolean.valueOf(TvKt.isTvDevice((FilesActivity) obj));
            case 8:
                int i14 = FilesActivity.$r8$clinit;
                return Boolean.valueOf(((SnapshotStateList) obj).isEmpty());
            case 9:
                ((MainActivity) obj).pendingUpdate$delegate.setValue(null);
                return Unit.INSTANCE;
            case 10:
                int i15 = MainApplication.$r8$clinit;
                return new UiStore((MainApplication) obj);
            case 11:
                ((ProvidersActivity) obj).finish();
                return Unit.INSTANCE;
            case 12:
                ((ShareToTvActivity) obj).finish();
                return Unit.INSTANCE;
            case 13:
                ((ProfilesViewModel) obj)._hwidLimit.setValue(null);
                return Unit.INSTANCE;
            case 14:
                String[] strArr = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                return new Picker(((FilesProvider) obj).getContext());
            case 15:
                return new HazeEffectNode$areaPreDrawListener$2$1((HazeEffectNode) obj);
            case 16:
                HazeSourceNode hazeSourceNode = (HazeSourceNode) obj;
                if (hazeSourceNode.area.preDrawListeners.isEmpty()) {
                    StandaloneCoroutine standaloneCoroutine = hazeSourceNode.preDrawJob;
                    if (standaloneCoroutine != null) {
                        standaloneCoroutine.cancel((CancellationException) null);
                    }
                    hazeSourceNode.preDrawJob = null;
                } else {
                    StandaloneCoroutine standaloneCoroutine2 = hazeSourceNode.preDrawJob;
                    if (standaloneCoroutine2 == null || !standaloneCoroutine2.isActive()) {
                        hazeSourceNode.preDrawJob = hazeSourceNode.launchPreDraw();
                    }
                }
                return Unit.INSTANCE;
            case 17:
                QRCodeAnalyzer qRCodeAnalyzer = (QRCodeAnalyzer) obj;
                int[] iArr = qRCodeAnalyzer.barcodeFormats;
                if (iArr.length > 1) {
                    zzoVar = new zzo();
                    if (iArr.length == 0) {
                        throw new NoSuchElementException("Array is empty.");
                    }
                    int i16 = iArr[0];
                    int length3 = iArr.length - 1;
                    if (length3 < 0) {
                        length3 = 0;
                    }
                    if (length3 < 0) {
                        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(length3, "Requested element count ", " is less than zero.").toString());
                    }
                    ?? arrayList = EmptyList.INSTANCE;
                    if (length3 != 0) {
                        int length4 = iArr.length;
                        if (length3 >= length4) {
                            int length5 = iArr.length;
                            if (length5 != 0) {
                                if (length5 != 1) {
                                    arrayList = new ArrayList(iArr.length);
                                    for (int i17 : iArr) {
                                        arrayList.add(Integer.valueOf(i17));
                                    }
                                } else {
                                    arrayList = Collections.singletonList(Integer.valueOf(i16));
                                }
                            }
                        } else if (length3 == 1) {
                            arrayList = Collections.singletonList(Integer.valueOf(iArr[length4 - 1]));
                        } else {
                            arrayList = new ArrayList(length3);
                            for (int i18 = length4 - length3; i18 < length4; i18++) {
                                arrayList.add(Integer.valueOf(iArr[i18]));
                            }
                        }
                    }
                    int[] intArray = CollectionsKt.toIntArray(arrayList);
                    int[] iArrCopyOf = Arrays.copyOf(intArray, intArray.length);
                    zzoVar.zza = i16;
                    if (iArrCopyOf != null) {
                        for (int i19 : iArrCopyOf) {
                            zzoVar.zza = i19 | zzoVar.zza;
                        }
                    }
                } else {
                    zzoVar = new zzo();
                    Integer numValueOf = iArr.length == 0 ? null : Integer.valueOf(iArr[0]);
                    zzoVar.zza = numValueOf != null ? numValueOf.intValue() : -1;
                }
                try {
                    return TaskExecutor.getClient(new BarcodeScannerOptions(zzoVar.zza));
                } catch (Exception e) {
                    qRCodeAnalyzer.onFailure.invoke(e);
                    return null;
                }
            case 18:
                int i20 = QRScannerActivity.$r8$clinit;
                ((QRScannerActivity) obj).finish();
                return Unit.INSTANCE;
            case 19:
                return new UIntArray.Iterator(6, (Object[]) obj);
            case 20:
                return obj;
            default:
                SerialDescriptorImpl serialDescriptorImpl = (SerialDescriptorImpl) obj;
                return Integer.valueOf(Platform_commonKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
        }
    }
}
