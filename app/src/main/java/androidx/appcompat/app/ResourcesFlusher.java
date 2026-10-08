package androidx.appcompat.app;

import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResourcesFlusher {
    public static Field sDrawableCacheField;
    public static boolean sDrawableCacheFieldFetched;
    public static Field sResourcesImplField;
    public static boolean sResourcesImplFieldFetched;
    public static Class sThemedResourceCacheClazz;
    public static boolean sThemedResourceCacheClazzFetched;
    public static Field sThemedResourceCache_mUnthemedEntriesField;
    public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static AlertController.AnonymousClass2 createCornerTreatment(int i) {
        if (i != 0) {
            return i != 1 ? new RoundedCornerTreatment() : new CutCornerTreatment();
        }
        return new RoundedCornerTreatment();
    }

    public static void flushThemedResourcesCache(Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
    
        if (migrationFromLegacy1(r9, r10, r1) == r0) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object migrationFromLegacy(android.content.Context r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.migrationFromLegacy(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00c1 A[Catch: all -> 0x00d0, TRY_ENTER, TryCatch #0 {all -> 0x00d0, blocks: (B:59:0x01ae, B:32:0x00af, B:40:0x00ca, B:45:0x00d8, B:36:0x00c1, B:61:0x01b4), top: B:68:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b4 A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:59:0x01ae, B:32:0x00af, B:40:0x00ca, B:45:0x00d8, B:36:0x00c1, B:61:0x01b4), top: B:68:0x01ae }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ae A[EXC_TOP_SPLITTER, PHI: r0 r2 r3 r4 r7 r10 r11 r14
      0x01ae: PHI (r0v16 android.content.Context) = (r0v14 android.content.Context), (r0v24 android.content.Context) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r2v7 int) = (r2v5 int), (r2v9 int) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r3v7 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1) = 
      (r3v5 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1)
      (r3v9 com.github.kr328.clash.service.data.migrations.LegacyMigrationKt$migrationFromLegacy1$1)
     binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r4v6 boolean) = (r4v5 boolean), (r4v7 boolean) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r7v9 int) = (r7v8 int), (r7v11 int) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r10v6 int) = (r10v4 int), (r10v8 int) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r11v5 java.io.Closeable) = (r11v3 java.io.Closeable), (r11v7 java.io.Closeable) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE]
      0x01ae: PHI (r14v6 android.database.Cursor) = (r14v4 android.database.Cursor), (r14v9 android.database.Cursor) binds: [B:37:0x00c5, B:58:0x01a7] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c5 -> B:68:0x01ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0189 -> B:57:0x018c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object migrationFromLegacy1(android.content.Context r40, android.database.sqlite.SQLiteDatabase r41, kotlin.coroutines.jvm.internal.ContinuationImpl r42) {
        /*
            Method dump skipped, instruction units count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.migrationFromLegacy1(android.content.Context, android.database.sqlite.SQLiteDatabase, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:103:0x028c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x0101 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0250, B:78:0x0256, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x010a A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0250, B:78:0x0256, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x010d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0224  */
    /* JADX WARN: Code duplicated, block: B:78:0x0256 A[Catch: all -> 0x0105, TRY_LEAVE, TryCatch #1 {all -> 0x0105, blocks: (B:76:0x0250, B:78:0x0256, B:38:0x00ee, B:45:0x0101, B:51:0x010e, B:49:0x010a), top: B:96:0x0250 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x0279  */
    /* JADX WARN: Code duplicated, block: B:83:0x027d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0289  */
    /* JADX WARN: Code duplicated, block: B:89:0x0292  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00fb -> B:96:0x0250). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0224 -> B:74:0x022a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object migrationFromLegacy234(android.content.Context r39, android.database.sqlite.SQLiteDatabase r40, int r41, kotlin.coroutines.jvm.internal.ContinuationImpl r42) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ResourcesFlusher.migrationFromLegacy234(android.content.Context, android.database.sqlite.SQLiteDatabase, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.elevationOverlayEnabled) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            elevation += ViewCompat.Api21Impl.getElevation((View) parent);
        }
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.parentAbsoluteElevation != elevation) {
            materialShapeDrawableState.parentAbsoluteElevation = elevation;
            materialShapeDrawable.updateZ();
        }
    }
}
