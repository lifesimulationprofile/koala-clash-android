package okhttp3;

import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Parcel;
import android.view.View;
import androidx.appcompat.widget.TooltipPopup;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.unit.Density;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import coil.EventListener$Companion$NONE$1;
import coil.RealImageLoader;
import coil.decode.DecodeUtils;
import coil.intercept.RealInterceptorChain;
import coil.key.UriKeyer;
import coil.memory.EmptyStrongMemoryCache;
import coil.memory.MemoryCache$Key;
import coil.memory.MemoryCache$Value;
import coil.memory.RealMemoryCache;
import coil.memory.RealWeakMemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.Requests;
import coil.util.Utils;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$Lambda$20;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zaf;
import com.google.android.gms.common.moduleinstall.internal.zar;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.common.moduleinstall.internal.zaz;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.internal.mlkit_vision_barcode.zzi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.http.StatusLine;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool implements SynchronizationGuard.CriticalSection, Factory, RemoteCall, OnSuccessListener, AccessibilityViewCommand, BarcodeSource {
    public final /* synthetic */ int $r8$classId;
    public Object delegate;

    public /* synthetic */ ConnectionPool(int i, Object obj) {
        this.$r8$classId = i;
        this.delegate = obj;
    }

    public static SuccessResult newResult(RealInterceptorChain realInterceptorChain, ImageRequest imageRequest, MemoryCache$Key memoryCache$Key, MemoryCache$Value memoryCache$Value) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(imageRequest.context.getResources(), memoryCache$Value.bitmap);
        Map map = memoryCache$Value.extras;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean z = false;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
        if (realInterceptorChain != null && realInterceptorChain.isPlaceholderCached) {
            z = true;
        }
        return new SuccessResult(bitmapDrawable, imageRequest, 1, memoryCache$Key, str, zBooleanValue, z);
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public void accept(Object obj, Object obj2) {
        zar zarVar = new zar((TaskCompletionSource) obj2, 0);
        zaf zafVar = (zaf) ((zaz) obj).getService();
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) this.delegate;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(zafVar.zab);
        int i = zac.$r8$clinit;
        parcelObtain.writeStrongBinder(zarVar);
        zac.zac(parcelObtain, apiFeatureRequest);
        zafVar.zac(parcelObtain, 1);
    }

    public void add(CSSParser.Rule rule) {
        if (((ArrayList) this.delegate) == null) {
            this.delegate = new ArrayList();
        }
        for (int i = 0; i < ((ArrayList) this.delegate).size(); i++) {
            if (((CSSParser.Rule) ((ArrayList) this.delegate).get(i)).selector.specificity > rule.selector.specificity) {
                ((ArrayList) this.delegate).add(i, rule);
                return;
            }
        }
        ((ArrayList) this.delegate).add(rule);
    }

    public void addAll(ConnectionPool connectionPool) {
        if (((ArrayList) connectionPool.delegate) == null) {
            return;
        }
        if (((ArrayList) this.delegate) == null) {
            this.delegate = new ArrayList(((ArrayList) connectionPool.delegate).size());
        }
        ArrayList arrayList = (ArrayList) connectionPool.delegate;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            add((CSSParser.Rule) obj);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Dispatcher dispatcher = (Dispatcher) this.delegate;
        SQLiteDatabase db = ((SQLiteEventStore) ((EventStore) dispatcher.readyAsyncCalls)).getDb();
        db.beginTransaction();
        try {
            List list = (List) SQLiteEventStore.tryWithCursor(db.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), SQLiteEventStore$$Lambda$20.instance);
            db.setTransactionSuccessful();
            db.endTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((SVG) dispatcher.runningAsyncCalls).schedule((AutoValue_TransportContext) it.next(), 1, false);
            }
            return null;
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new SQLiteEventStore(new Path.Companion(16), new ByteString.Companion(15), AutoValue_EventStoreConfig.DEFAULT, (SchemaManager) ((EmptyStrongMemoryCache) this.delegate).get());
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Rect getBoundingBox() {
        zzu zzuVar = (zzu) this.delegate;
        if (zzuVar.zze == null) {
            return null;
        }
        int i = 0;
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.zze;
            if (i >= pointArr.length) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
            Point point = pointArr[i];
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public MemoryCache$Value getCacheValue(ImageRequest imageRequest, MemoryCache$Key memoryCache$Key, Size size, int i) {
        MemoryCache$Value memoryCache$Value;
        int i2;
        boolean zEquals;
        ?? r8;
        MemoryCache$Value memoryCache$Value2;
        if (Density.CC.getReadEnabled(imageRequest.memoryCachePolicy)) {
            RealMemoryCache realMemoryCache = (RealMemoryCache) ((RealImageLoader) this.delegate).memoryCacheLazy.getValue();
            if (realMemoryCache != null) {
                memoryCache$Value = realMemoryCache.strongMemoryCache.get(memoryCache$Key);
                if (memoryCache$Value == null) {
                    RealWeakMemoryCache realWeakMemoryCache = realMemoryCache.weakMemoryCache;
                    synchronized (realWeakMemoryCache) {
                        try {
                            ArrayList arrayList = (ArrayList) ((LinkedHashMap) realWeakMemoryCache.cache).get(memoryCache$Key);
                            memoryCache$Value2 = null;
                            if (arrayList != null) {
                                int size2 = arrayList.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    RealWeakMemoryCache.InternalValue internalValue = (RealWeakMemoryCache.InternalValue) arrayList.get(i3);
                                    Bitmap bitmap = (Bitmap) internalValue.bitmap.get();
                                    MemoryCache$Value memoryCache$Value3 = bitmap != null ? new MemoryCache$Value(bitmap, internalValue.extras) : null;
                                    if (memoryCache$Value3 != null) {
                                        memoryCache$Value2 = memoryCache$Value3;
                                        break;
                                    }
                                }
                                int i4 = realWeakMemoryCache.operationsSinceCleanUp;
                                realWeakMemoryCache.operationsSinceCleanUp = i4 + 1;
                                if (i4 >= 10) {
                                    realWeakMemoryCache.cleanUp$coil_base_release();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    memoryCache$Value = memoryCache$Value2;
                }
            } else {
                memoryCache$Value = null;
            }
            if (memoryCache$Value != null) {
                Bitmap bitmap2 = memoryCache$Value.bitmap;
                Bitmap.Config config = bitmap2.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (Bitmaps.isHardware(config) && !imageRequest.allowHardware) {
                    r8 = 0;
                } else {
                    Object obj = memoryCache$Value.extras.get("coil#is_sampled");
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                    if (!Intrinsics.areEqual(size, Size.ORIGINAL)) {
                        String str = (String) memoryCache$Key.extras.get("coil#transformation_size");
                        if (str != null) {
                            zEquals = str.equals(size.toString());
                        } else {
                            int width = bitmap2.getWidth();
                            int height = bitmap2.getHeight();
                            Dimension dimension = size.width;
                            int i5 = dimension instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension).px : Integer.MAX_VALUE;
                            Dimension dimension2 = size.height;
                            int i6 = dimension2 instanceof Dimension.Pixels ? ((Dimension.Pixels) dimension2).px : Integer.MAX_VALUE;
                            double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i5, i6, i);
                            boolean allowInexactSize = Requests.getAllowInexactSize(imageRequest);
                            if (allowInexactSize) {
                                double d = dComputeSizeMultiplier > 1.0d ? 1.0d : dComputeSizeMultiplier;
                                if (Math.abs(((double) i5) - (d * ((double) width))) <= 1.0d || Math.abs(((double) i6) - (d * ((double) height))) <= 1.0d) {
                                    i2 = 1;
                                } else {
                                    i2 = 1;
                                }
                                r8 = i2;
                            } else {
                                if (i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE) {
                                    i2 = 1;
                                } else {
                                    int iAbs = Math.abs(i5 - width);
                                    i2 = 1;
                                    if (iAbs <= 1) {
                                    }
                                }
                                if (i6 != Integer.MIN_VALUE && i6 != Integer.MAX_VALUE && Math.abs(i6 - height) > i2) {
                                }
                                r8 = i2;
                            }
                            if (!(dComputeSizeMultiplier == 1.0d || allowInexactSize) || (dComputeSizeMultiplier > 1.0d && zBooleanValue)) {
                                r8 = 0;
                            } else {
                                r8 = i2;
                            }
                        }
                    } else if (zBooleanValue) {
                        r8 = 0;
                    } else {
                        i2 = 1;
                        r8 = i2;
                    }
                }
                if (r8 != 0) {
                    r8 = zEquals;
                    return memoryCache$Value;
                }
            }
        }
        r8 = zEquals;
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getCalendarEvent() {
        zzk zzkVar = ((zzu) this.delegate).zzl;
        if (zzkVar == null) {
            return null;
        }
        String str = zzkVar.zza;
        String str2 = zzkVar.zzb;
        String str3 = zzkVar.zzc;
        String str4 = zzkVar.zzd;
        String str5 = zzkVar.zze;
        zzj zzjVar = zzkVar.zzf;
        Barcode.CalendarDateTime calendarDateTime = zzjVar == null ? null : new Barcode.CalendarDateTime(zzjVar.zza, zzjVar.zzb, zzjVar.zzc, zzjVar.zzd, zzjVar.zze, zzjVar.zzf, zzjVar.zzg);
        zzj zzjVar2 = zzkVar.zzg;
        return new TooltipPopup(str, str2, str3, str4, str5, calendarDateTime, zzjVar2 == null ? null : new Barcode.CalendarDateTime(zzjVar2.zza, zzjVar2.zzb, zzjVar2.zzc, zzjVar2.zzd, zzjVar2.zze, zzjVar2.zzf, zzjVar2.zzg));
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getContactInfo() {
        zzl zzlVar = ((zzu) this.delegate).zzm;
        if (zzlVar == null) {
            return null;
        }
        zzp zzpVar = zzlVar.zza;
        TooltipPopup tooltipPopup = zzpVar == null ? null : new TooltipPopup(zzpVar.zza, zzpVar.zzb, zzpVar.zzc, zzpVar.zzd, zzpVar.zze, zzpVar.zzf, zzpVar.zzg);
        String str = zzlVar.zzb;
        String str2 = zzlVar.zzc;
        zzq[] zzqVarArr = zzlVar.zzd;
        ArrayList arrayList = new ArrayList();
        if (zzqVarArr != null) {
            for (zzq zzqVar : zzqVarArr) {
                if (zzqVar != null) {
                    arrayList.add(new Barcode.Phone(zzqVar.zzb, zzqVar.zza));
                }
            }
        }
        zzn[] zznVarArr = zzlVar.zze;
        ArrayList arrayList2 = new ArrayList();
        if (zznVarArr != null) {
            for (zzn zznVar : zznVarArr) {
                if (zznVar != null) {
                    arrayList2.add(new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd));
                }
            }
        }
        String[] strArr = zzlVar.zzf;
        Object objAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        zzi[] zziVarArr = zzlVar.zzg;
        ArrayList arrayList3 = new ArrayList();
        if (zziVarArr != null) {
            for (zzi zziVar : zziVarArr) {
                if (zziVar != null) {
                    arrayList3.add(new Barcode.Address(zziVar.zza, zziVar.zzb));
                }
            }
        }
        return new TooltipPopup(tooltipPopup, str, str2, arrayList, arrayList2, objAsList, arrayList3);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Point[] getCornerPoints() {
        return ((zzu) this.delegate).zze;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Email getEmail() {
        zzn zznVar = ((zzu) this.delegate).zzf;
        if (zznVar != null) {
            return new Barcode.Email(zznVar.zza, zznVar.zzb, zznVar.zzc, zznVar.zzd);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getFormat() {
        return ((zzu) this.delegate).zza;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.GeoPoint getGeoPoint() {
        zzo zzoVar = ((zzu) this.delegate).zzk;
        if (zzoVar != null) {
            return new Barcode.GeoPoint(zzoVar.zza, zzoVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Phone getPhone() {
        zzq zzqVar = ((zzu) this.delegate).zzg;
        if (zzqVar != null) {
            return new Barcode.Phone(zzqVar.zzb, zzqVar.zza);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public byte[] getRawBytes() {
        return ((zzu) this.delegate).zzo;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public String getRawValue() {
        return ((zzu) this.delegate).zzb;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public GmsLogger getSms() {
        zzr zzrVar = ((zzu) this.delegate).zzh;
        if (zzrVar != null) {
            return new GmsLogger(1, zzrVar.zza, zzrVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public RequestService getUrl() {
        zzs zzsVar = ((zzu) this.delegate).zzj;
        if (zzsVar == null) {
            return null;
        }
        return new RequestService(23, zzsVar.zza, zzsVar.zzb, false);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getValueType() {
        return ((zzu) this.delegate).zzd;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public StatusLine getWifi() {
        zzt zztVar = ((zzu) this.delegate).zzi;
        if (zztVar == null) {
            return null;
        }
        return new StatusLine(zztVar.zzc, zztVar.zza, zztVar.zzb);
    }

    public MemoryCache$Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        String string;
        Map map;
        MemoryCache$Key memoryCache$Key = imageRequest.memoryCacheKey;
        List list = imageRequest.transformations;
        if (memoryCache$Key != null) {
            return memoryCache$Key;
        }
        List list2 = ((RealImageLoader) this.delegate).components.keyers;
        int size = list2.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Pair pair = (Pair) list2.get(i);
                UriKeyer uriKeyer = (UriKeyer) pair.first;
                if (((Class) pair.second).isAssignableFrom(obj.getClass())) {
                    switch (uriKeyer.$r8$classId) {
                        case 0:
                            Uri uri = (Uri) obj;
                            if (!Intrinsics.areEqual(uri.getScheme(), "android.resource")) {
                                string = uri.toString();
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(uri);
                                sb.append('-');
                                Configuration configuration = options.context.getResources().getConfiguration();
                                Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                                sb.append(configuration.uiMode & 48);
                                string = sb.toString();
                            }
                            break;
                        default:
                            File file = (File) obj;
                            string = file.getPath() + ':' + file.lastModified();
                            break;
                    }
                    if (string != null) {
                    }
                }
                i++;
            } else {
                string = null;
            }
        }
        if (string == null) {
            return null;
        }
        Map map2 = imageRequest.parameters.entries;
        if (map2.isEmpty()) {
            map = EmptyMap.INSTANCE;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = map2.entrySet().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getValue().getClass();
                throw new ClassCastException();
            }
            map = linkedHashMap;
        }
        if (list.isEmpty() && map.isEmpty()) {
            return new MemoryCache$Key(string);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        if (!list.isEmpty()) {
            if (list.size() > 0) {
                list.get(0).getClass();
                throw new ClassCastException();
            }
            linkedHashMap2.put("coil#transformation_size", options.size.toString());
        }
        return new MemoryCache$Key(string, linkedHashMap2);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((TaskCompletionSource) ((com.google.android.gms.tasks.zzs) this.delegate).zza).zza.zzc();
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.delegate;
        if (!swipeDismissBehavior.canSwipeDismissView(view)) {
            return false;
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.swipeDirection;
        view.offsetLeftAndRight((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                if (((ArrayList) this.delegate) == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = (ArrayList) this.delegate;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    sb.append(((CSSParser.Rule) obj).toString());
                    sb.append('\n');
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ ConnectionPool(zay zayVar, ApiFeatureRequest apiFeatureRequest) {
        this.$r8$classId = 8;
        this.delegate = apiFeatureRequest;
    }

    public ConnectionPool(RealImageLoader realImageLoader, RequestService requestService) {
        this.$r8$classId = 1;
        this.delegate = realImageLoader;
    }

    public ConnectionPool(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 2:
                this.delegate = null;
                break;
            case 9:
                break;
            case 11:
                this.delegate = new zzw();
                break;
            case 19:
                MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
                this.delegate = new MutableScatterSet();
                break;
            case 20:
                this.delegate = new ConcurrentHashMap(16);
                break;
            default:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                this.delegate = new RealConnectionPool(TaskRunner.INSTANCE);
                break;
        }
    }

    public ConnectionPool(Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1) {
        this.$r8$classId = 21;
        this.delegate = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), util$$ExternalSyntheticLambda1);
    }
}
