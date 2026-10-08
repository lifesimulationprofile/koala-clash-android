package coil;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.StatFs;
import coil.disk.RealDiskCache;
import coil.memory.EmptyStrongMemoryCache;
import coil.memory.RealMemoryCache;
import coil.memory.RealStrongMemoryCache;
import coil.memory.RealWeakMemoryCache;
import coil.request.DefaultRequestOptions;
import coil.util.SingletonDiskCache;
import coil.util.Utils;
import java.io.File;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.EmptyList;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.FileSystem;
import okio.JvmSystemFileSystem;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageLoaders {
    public static final RealImageLoader create(Context context) {
        final ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(context);
        Context context2 = (Context) imageLoader$Builder.applicationContext;
        DefaultRequestOptions defaultRequestOptions = (DefaultRequestOptions) imageLoader$Builder.defaults;
        final int i = 0;
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new Function0() { // from class: coil.ImageLoader$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2;
                int largeMemoryClass;
                RealDiskCache realDiskCache;
                switch (i) {
                    case 0:
                        Context context3 = (Context) imageLoader$Builder.applicationContext;
                        Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                        double d = 0.2d;
                        try {
                            if (((ActivityManager) context3.getSystemService(ActivityManager.class)).isLowRamDevice()) {
                                d = 0.15d;
                            }
                        } catch (Exception unused) {
                        }
                        RealWeakMemoryCache realWeakMemoryCache = new RealWeakMemoryCache(0);
                        if (d > 0.0d) {
                            Bitmap.Config[] configArr2 = Utils.VALID_TRANSFORMATION_CONFIGS;
                            try {
                                ActivityManager activityManager = (ActivityManager) context3.getSystemService(ActivityManager.class);
                                largeMemoryClass = (context3.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                            } catch (Exception unused2) {
                                largeMemoryClass = 256;
                            }
                            double d2 = d * ((double) largeMemoryClass);
                            double d3 = 1024;
                            i2 = (int) (d2 * d3 * d3);
                            break;
                        } else {
                            i2 = 0;
                        }
                        return new RealMemoryCache(i2 > 0 ? new RealStrongMemoryCache(i2, realWeakMemoryCache) : new EmptyStrongMemoryCache(0, realWeakMemoryCache), realWeakMemoryCache);
                    default:
                        ImageLoader$Builder imageLoader$Builder2 = imageLoader$Builder;
                        SingletonDiskCache singletonDiskCache = SingletonDiskCache.INSTANCE;
                        Context context4 = (Context) imageLoader$Builder2.applicationContext;
                        synchronized (singletonDiskCache) {
                            try {
                                realDiskCache = SingletonDiskCache.instance;
                                if (realDiskCache == null) {
                                    JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                    Bitmap.Config[] configArr3 = Utils.VALID_TRANSFORMATION_CONFIGS;
                                    File cacheDir = context4.getCacheDir();
                                    if (cacheDir == null) {
                                        throw new IllegalStateException("cacheDir == null");
                                    }
                                    cacheDir.mkdirs();
                                    File fileResolve = FilesKt.resolve(cacheDir, "image_cache");
                                    String str = Path.DIRECTORY_SEPARATOR;
                                    Path path = Path.Companion.get$default(fileResolve);
                                    long jCoerceIn = 10485760;
                                    try {
                                        File file = path.toFile();
                                        file.mkdir();
                                        StatFs statFs = new StatFs(file.getAbsolutePath());
                                        jCoerceIn = RangesKt.coerceIn((long) (0.02d * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), 10485760L, 262144000L);
                                        break;
                                    } catch (Exception unused3) {
                                    }
                                    RealDiskCache realDiskCache2 = new RealDiskCache(jCoerceIn, jvmSystemFileSystem, path);
                                    SingletonDiskCache.instance = realDiskCache2;
                                    realDiskCache = realDiskCache2;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return realDiskCache;
                }
            }
        });
        final int i2 = 1;
        SynchronizedLazyImpl synchronizedLazyImpl2 = new SynchronizedLazyImpl(new Function0() { // from class: coil.ImageLoader$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3;
                int largeMemoryClass;
                RealDiskCache realDiskCache;
                switch (i2) {
                    case 0:
                        Context context3 = (Context) imageLoader$Builder.applicationContext;
                        Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                        double d = 0.2d;
                        try {
                            if (((ActivityManager) context3.getSystemService(ActivityManager.class)).isLowRamDevice()) {
                                d = 0.15d;
                            }
                        } catch (Exception unused) {
                        }
                        RealWeakMemoryCache realWeakMemoryCache = new RealWeakMemoryCache(0);
                        if (d > 0.0d) {
                            Bitmap.Config[] configArr2 = Utils.VALID_TRANSFORMATION_CONFIGS;
                            try {
                                ActivityManager activityManager = (ActivityManager) context3.getSystemService(ActivityManager.class);
                                largeMemoryClass = (context3.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
                            } catch (Exception unused2) {
                                largeMemoryClass = 256;
                            }
                            double d2 = d * ((double) largeMemoryClass);
                            double d3 = 1024;
                            i3 = (int) (d2 * d3 * d3);
                            break;
                        } else {
                            i3 = 0;
                        }
                        return new RealMemoryCache(i3 > 0 ? new RealStrongMemoryCache(i3, realWeakMemoryCache) : new EmptyStrongMemoryCache(0, realWeakMemoryCache), realWeakMemoryCache);
                    default:
                        ImageLoader$Builder imageLoader$Builder2 = imageLoader$Builder;
                        SingletonDiskCache singletonDiskCache = SingletonDiskCache.INSTANCE;
                        Context context4 = (Context) imageLoader$Builder2.applicationContext;
                        synchronized (singletonDiskCache) {
                            try {
                                realDiskCache = SingletonDiskCache.instance;
                                if (realDiskCache == null) {
                                    JvmSystemFileSystem jvmSystemFileSystem = FileSystem.SYSTEM;
                                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                    Bitmap.Config[] configArr3 = Utils.VALID_TRANSFORMATION_CONFIGS;
                                    File cacheDir = context4.getCacheDir();
                                    if (cacheDir == null) {
                                        throw new IllegalStateException("cacheDir == null");
                                    }
                                    cacheDir.mkdirs();
                                    File fileResolve = FilesKt.resolve(cacheDir, "image_cache");
                                    String str = Path.DIRECTORY_SEPARATOR;
                                    Path path = Path.Companion.get$default(fileResolve);
                                    long jCoerceIn = 10485760;
                                    try {
                                        File file = path.toFile();
                                        file.mkdir();
                                        StatFs statFs = new StatFs(file.getAbsolutePath());
                                        jCoerceIn = RangesKt.coerceIn((long) (0.02d * statFs.getBlockCountLong() * statFs.getBlockSizeLong()), 10485760L, 262144000L);
                                        break;
                                    } catch (Exception unused3) {
                                    }
                                    RealDiskCache realDiskCache2 = new RealDiskCache(jCoerceIn, jvmSystemFileSystem, path);
                                    SingletonDiskCache.instance = realDiskCache2;
                                    realDiskCache = realDiskCache2;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return realDiskCache;
                }
            }
        });
        SynchronizedLazyImpl synchronizedLazyImpl3 = new SynchronizedLazyImpl(new ImageLoader$Builder$$ExternalSyntheticLambda2(0));
        EmptyList emptyList = EmptyList.INSTANCE;
        return new RealImageLoader(context2, defaultRequestOptions, synchronizedLazyImpl, synchronizedLazyImpl2, synchronizedLazyImpl3, new ComponentRegistry(emptyList, emptyList, emptyList, emptyList, emptyList), (SingletonDiskCache) imageLoader$Builder.options);
    }
}
