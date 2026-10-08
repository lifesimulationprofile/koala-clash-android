package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.processing.Edge;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.provider.CallbackWrapper$2;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.tracing.Trace;
import androidx.work.Worker;
import androidx.work.impl.utils.StartWorkRunnable;
import coil.disk.RealDiskCache;
import coil.memory.RealStrongMemoryCache;
import com.google.android.gms.tasks.zzu;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypefaceCompat {
    public static final LruCache sTypefaceCache;
    public static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    static {
        Trace.beginSection("TypefaceCompat static init");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i < 24) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            Method method = TypefaceCompatApi24Impl.sAddFontWeightStyle;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
            } else {
                sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
            }
        }
        sTypefaceCache = new LruCache(16);
        android.os.Trace.endSection();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int i, String str, int i2, int i3, CamUtils camUtils, boolean z) {
        Typeface typefaceCreateFromFontFamilyFilesResourceEntry;
        Typeface typefaceCreate;
        List listUnmodifiableList;
        Typeface typeface;
        int i4 = 25;
        int i5 = -3;
        if (fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry) {
            FontResourcesParserCompat$ProviderResourceEntry fontResourcesParserCompat$ProviderResourceEntry = (FontResourcesParserCompat$ProviderResourceEntry) fontResourcesParserCompat$FamilyResourceEntry;
            String str2 = fontResourcesParserCompat$ProviderResourceEntry.mSystemFontFamilyName;
            boolean z2 = false;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (str2 == null || str2.isEmpty()) {
                typefaceCreate = null;
            } else {
                typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                    typefaceCreate = null;
                }
            }
            if (typefaceCreate != null) {
                if (camUtils != null) {
                    new Handler(Looper.getMainLooper()).post(new Preview$$ExternalSyntheticLambda1(i4, camUtils, typefaceCreate));
                }
                return typefaceCreate;
            }
            int i6 = 1;
            Object[] objArr3 = !z ? camUtils != null : fontResourcesParserCompat$ProviderResourceEntry.mStrategy != 0;
            int i7 = z ? fontResourcesParserCompat$ProviderResourceEntry.mTimeoutMs : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            int i8 = 14;
            RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(i8, z2);
            realEditor.editor = camUtils;
            FontRequest fontRequest = fontResourcesParserCompat$ProviderResourceEntry.mFallbackRequest;
            int i9 = 2;
            if (fontRequest != null) {
                Object[] objArr4 = {fontResourcesParserCompat$ProviderResourceEntry.mRequest, fontRequest};
                ArrayList arrayList = new ArrayList(2);
                for (int i10 = 0; i10 < 2; i10++) {
                    Object obj = objArr4[i10];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
            } else {
                Object[] objArr5 = {fontResourcesParserCompat$ProviderResourceEntry.mRequest};
                ArrayList arrayList2 = new ArrayList(1);
                Object obj2 = objArr5[0];
                Objects.requireNonNull(obj2);
                arrayList2.add(obj2);
                listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            }
            zzu zzuVar = new zzu(2, handler);
            RealStrongMemoryCache realStrongMemoryCache = new RealStrongMemoryCache(i8, realEditor, zzuVar, objArr2 == true ? 1 : 0);
            int i11 = 6;
            if (objArr3 != true) {
                String strCreateCacheId = FontRequestWorker.createCacheId(i3, listUnmodifiableList);
                Typeface typeface2 = (Typeface) FontRequestWorker.sTypefaceCache.get(strCreateCacheId);
                if (typeface2 != null) {
                    zzuVar.execute(new Worker.AnonymousClass2(i11, realEditor, typeface2));
                    typeface = typeface2;
                } else {
                    Edge edge = new Edge(i6, realStrongMemoryCache);
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList3 = (ArrayList) simpleArrayMap.get(strCreateCacheId);
                            if (arrayList3 != null) {
                                arrayList3.add(edge);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(edge);
                                simpleArrayMap.put(strCreateCacheId, arrayList4);
                                FontRequestWorker.AnonymousClass1 anonymousClass1 = new FontRequestWorker.AnonymousClass1(strCreateCacheId, context, listUnmodifiableList, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
                                Edge edge2 = new Edge(i9, strCreateCacheId);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                StartWorkRunnable startWorkRunnable = new StartWorkRunnable();
                                startWorkRunnable.processor = anonymousClass1;
                                startWorkRunnable.startStopToken = edge2;
                                startWorkRunnable.runtimeExtras = handler2;
                                threadPoolExecutor.execute(startWorkRunnable);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    typeface = null;
                }
            } else {
                if (listUnmodifiableList.size() > 1) {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
                FontRequest fontRequest2 = (FontRequest) listUnmodifiableList.get(0);
                LruCache lruCache = FontRequestWorker.sTypefaceCache;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj3 = new Object[]{fontRequest2}[0];
                Objects.requireNonNull(obj3);
                arrayList5.add(obj3);
                String strCreateCacheId2 = FontRequestWorker.createCacheId(i3, Collections.unmodifiableList(arrayList5));
                Typeface typeface3 = (Typeface) FontRequestWorker.sTypefaceCache.get(strCreateCacheId2);
                if (typeface3 != null) {
                    zzuVar.execute(new Worker.AnonymousClass2(i11, realEditor, typeface3));
                    typeface = typeface3;
                } else if (i7 == -1) {
                    Object[] objArr6 = {fontRequest2};
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj4 = objArr6[0];
                    Objects.requireNonNull(obj4);
                    arrayList6.add(obj4);
                    FontRequestWorker.TypefaceResult fontSync = FontRequestWorker.getFontSync(strCreateCacheId2, context, Collections.unmodifiableList(arrayList6), i3);
                    realStrongMemoryCache.onTypefaceResult(fontSync);
                    typeface = fontSync.mTypeface;
                } else {
                    try {
                        try {
                            try {
                                FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) FontRequestWorker.DEFAULT_EXECUTOR_SERVICE.submit(new FontRequestWorker.AnonymousClass1(strCreateCacheId2, context, fontRequest2, i3, 0)).get(i7, TimeUnit.MILLISECONDS);
                                realStrongMemoryCache.onTypefaceResult(typefaceResult);
                                typeface = typefaceResult.mTypeface;
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (TimeoutException unused) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused2) {
                        ((zzu) realStrongMemoryCache.cache).execute(new CallbackWrapper$2(i5, (int) (objArr == true ? 1 : 0), realStrongMemoryCache.weakMemoryCache));
                        typeface = null;
                    }
                }
            }
            typefaceCreateFromFontFamilyFilesResourceEntry = typeface;
        } else {
            typefaceCreateFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry) fontResourcesParserCompat$FamilyResourceEntry, resources, i3);
            if (camUtils != null) {
                if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
                    new Handler(Looper.getMainLooper()).post(new Preview$$ExternalSyntheticLambda1(i4, camUtils, typefaceCreateFromFontFamilyFilesResourceEntry));
                } else {
                    camUtils.callbackFailAsync(-3);
                }
            }
        }
        if (typefaceCreateFromFontFamilyFilesResourceEntry != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typefaceCreateFromFontFamilyFilesResourceEntry);
        }
        return typefaceCreateFromFontFamilyFilesResourceEntry;
    }

    public static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
