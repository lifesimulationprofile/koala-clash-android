package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.text.platform.DispatcherKt;
import androidx.work.impl.WorkLauncherImpl;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.disk.RealDiskCache;
import com.google.mlkit.common.internal.zzd;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorJobImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl implements FontFamily$Resolver {
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    public final RealDiskCache.RealEditor platformFamilyTypefaceAdapter;
    public final AndroidUriHandler platformFontLoader;
    public final AndroidFontResolveInterceptor platformResolveInterceptor;
    public final WorkLauncherImpl typefaceRequestCache;

    public FontFamilyResolverImpl(AndroidUriHandler androidUriHandler, AndroidFontResolveInterceptor androidFontResolveInterceptor) {
        WorkLauncherImpl workLauncherImpl = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        WorkLauncherImpl workLauncherImpl2 = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter();
        FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1 fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1 = FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        MainCoroutineDispatcher mainCoroutineDispatcher = DispatcherKt.FontCacheManagementDispatcher;
        fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1.getClass();
        JobKt.CoroutineScope(CoroutineContext.DefaultImpls.plus(fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1, mainCoroutineDispatcher).plus(EmptyCoroutineContext.INSTANCE).plus(new SupervisorJobImpl(null)));
        RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(12);
        this.platformFontLoader = androidUriHandler;
        this.platformResolveInterceptor = androidFontResolveInterceptor;
        this.typefaceRequestCache = workLauncherImpl;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = realEditor;
        new DiskLruCache$$ExternalSyntheticLambda0(3, this);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b A[Catch: Exception -> 0x0083, TRY_ENTER, TryCatch #2 {Exception -> 0x0083, blocks: (B:15:0x0027, B:17:0x003a, B:20:0x003f, B:22:0x0043, B:25:0x0050, B:42:0x007b, B:43:0x0082, B:24:0x004c), top: B:53:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final TypefaceResult$Immutable resolve(TypefaceRequest typefaceRequest) {
        Typeface typefaceMo655createDefaultFO1MlWM;
        TypefaceResult$Immutable typefaceResult$Immutable;
        WorkLauncherImpl workLauncherImpl = this.typefaceRequestCache;
        synchronized (((zzd) workLauncherImpl.processor)) {
            TypefaceResult$Immutable typefaceResult$Immutable2 = (TypefaceResult$Immutable) ((LruCache) workLauncherImpl.workTaskExecutor).get(typefaceRequest);
            if (typefaceResult$Immutable2 != null) {
                if (typefaceResult$Immutable2.cacheable) {
                    return typefaceResult$Immutable2;
                }
            }
            try {
                this.fontListFontFamilyTypefaceAdapter.getClass();
                SystemFontFamily systemFontFamily = typefaceRequest.fontFamily;
                PlatformTypefaces platformTypefaces = (PlatformTypefaces) this.platformFamilyTypefaceAdapter.editor;
                int i = typefaceRequest.fontStyle;
                FontWeight fontWeight = typefaceRequest.fontWeight;
                if (systemFontFamily != null && !(systemFontFamily instanceof DefaultFontFamily)) {
                    if (systemFontFamily instanceof GenericFontFamily) {
                        typefaceMo655createDefaultFO1MlWM = platformTypefaces.mo656createNamedRetOiIg((GenericFontFamily) systemFontFamily, fontWeight, i);
                    } else {
                        typefaceResult$Immutable = null;
                    }
                    if (typefaceResult$Immutable != null) {
                        throw new IllegalStateException("Could not load font");
                    }
                    synchronized (((zzd) workLauncherImpl.processor)) {
                        try {
                            if (((LruCache) workLauncherImpl.workTaskExecutor).get(typefaceRequest) == null && typefaceResult$Immutable.cacheable) {
                                ((LruCache) workLauncherImpl.workTaskExecutor).put(typefaceRequest, typefaceResult$Immutable);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return typefaceResult$Immutable;
                }
                typefaceMo655createDefaultFO1MlWM = platformTypefaces.mo655createDefaultFO1MlWM(fontWeight, i);
                typefaceResult$Immutable = new TypefaceResult$Immutable(typefaceMo655createDefaultFO1MlWM);
                if (typefaceResult$Immutable != null) {
                    throw new IllegalStateException("Could not load font");
                }
                synchronized (((zzd) workLauncherImpl.processor)) {
                    if (((LruCache) workLauncherImpl.workTaskExecutor).get(typefaceRequest) == null) {
                        ((LruCache) workLauncherImpl.workTaskExecutor).put(typefaceRequest, typefaceResult$Immutable);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return typefaceResult$Immutable;
                }
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }

    /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
    public final TypefaceResult$Immutable m654resolveDPcqOEQ(SystemFontFamily systemFontFamily, FontWeight fontWeight, int i, int i2) {
        AndroidFontResolveInterceptor androidFontResolveInterceptor = this.platformResolveInterceptor;
        androidFontResolveInterceptor.getClass();
        int i3 = androidFontResolveInterceptor.fontWeightAdjustment;
        FontWeight fontWeight2 = (i3 == 0 || i3 == Integer.MAX_VALUE) ? fontWeight : new FontWeight(RangesKt.coerceIn(fontWeight.weight + i3, 1, 1000));
        this.platformFontLoader.getClass();
        return resolve(new TypefaceRequest(systemFontFamily, fontWeight2, i, i2, null));
    }
}
