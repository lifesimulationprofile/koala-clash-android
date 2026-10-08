package com.github.kr328.clash.service;

import android.content.Context;
import android.util.Log;
import androidx.room.CoroutinesRoom;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.data.ImportedDao_Impl$4;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import com.github.kr328.clash.service.util.BroadcastKt;
import com.github.kr328.clash.service.util.DatabaseKt;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileProcessor$patch$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ IFetchObserver $callback;
    public Context $context;
    public final /* synthetic */ long $interval;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ String $source;
    public Object $uuid;
    public long J$0;
    public Mutex L$0;
    public UUID L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public MutexImpl L$8;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProcessor$patch$2(Context context, UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uuid = uuid;
        this.$name = str;
        this.$source = str2;
        this.$interval = j;
        this.$callback = iFetchObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ProfileProcessor$patch$2(this.$context, (UUID) this.$uuid, this.$name, this.$source, this.$interval, this.$callback, continuation);
            default:
                return new ProfileProcessor$patch$2(this.$name, (Profile.Type) this.L$6, this.$source, this.$interval, (Context) this.L$7, this.$callback, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((ProfileProcessor$patch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0395 A[Catch: all -> 0x0326, TRY_LEAVE, TryCatch #5 {all -> 0x0326, blocks: (B:115:0x0314, B:129:0x0390, B:131:0x0395, B:181:0x0522, B:182:0x053a, B:125:0x036a), top: B:186:0x0261 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:143:0x0423  */
    /* JADX WARN: Code duplicated, block: B:147:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:173:0x0514 A[Catch: all -> 0x02cb, TryCatch #10 {all -> 0x02cb, blocks: (B:103:0x02b8, B:171:0x050e, B:173:0x0514, B:174:0x0516, B:175:0x0519), top: B:186:0x0261 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0521  */
    /* JADX WARN: Code duplicated, block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0151  */
    /* JADX WARN: Code duplicated, block: B:43:0x0153  */
    /* JADX WARN: Code duplicated, block: B:47:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x019c A[Catch: all -> 0x01aa, TryCatch #9 {all -> 0x01aa, blocks: (B:48:0x0183, B:50:0x019c, B:62:0x01b7, B:64:0x01bb, B:65:0x01c5), top: B:193:0x0183 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x01af  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b7 A[Catch: all -> 0x01aa, TryCatch #9 {all -> 0x01aa, blocks: (B:48:0x0183, B:50:0x019c, B:62:0x01b7, B:64:0x01bb, B:65:0x01c5), top: B:193:0x0183 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x021b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v20, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v24, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r41v0 */
    /* JADX WARN: Type inference failed for: r4v36, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v47 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        UUID uuid;
        UUID uuid2;
        Mutex mutex;
        Context context;
        ?? r12;
        ?? r11;
        Object objQueryByUUID;
        ?? r2;
        ?? r13;
        Context context2;
        UUID uuid3;
        IFetchObserver iFetchObserver;
        Imported imported;
        File fileResolve;
        File file;
        Imported imported2;
        Imported imported3;
        UUID uuid4;
        Context context3;
        UUID uuid5;
        Object objAccess$resolve;
        Context context4;
        ?? r0;
        Imported imported4;
        ?? r14;
        long j;
        Mutex mutex2;
        UUID uuid6;
        ?? r15;
        String str;
        ProfileProcessor.ProfileMeta profileMeta;
        MutexImpl mutexImpl;
        ?? r18;
        long j2;
        ?? r3;
        ?? r21;
        ?? r22;
        ProfileProcessor.ProfileMeta profileMeta2;
        Mutex mutex3;
        UUID uuid7;
        Dispatcher dispatcherImportedDao;
        Imported importedCopy$default;
        Mutex mutex4;
        UUID uuid8;
        Object objGenerateProfileUUID;
        UUID uuid9;
        IFetchObserver iFetchObserver2;
        ?? r4;
        Context context5;
        ?? r16;
        File fileResolve2;
        Profile.Type type;
        Context context6;
        File file2;
        Object objAccess$resolve2;
        ?? r8;
        Profile.Type type2;
        Context context7;
        long j3;
        UUID uuid10;
        ?? r17;
        ?? r5;
        ProfileProcessor.ProfileMeta profileMeta3;
        MutexImpl mutexImpl2;
        ?? r20;
        Profile.Type type3;
        ?? r19;
        ?? r9;
        UUID uuid11;
        long millis;
        ProfileProcessor.ProfileMeta profileMeta4;
        ?? r6;
        Mutex mutex5;
        String str2;
        ?? r110;
        Dispatcher dispatcherImportedDao2;
        Imported imported5;
        Context context8;
        UUID uuid12;
        Long l;
        Object obj2;
        ?? r7;
        int i = this.$r8$classId;
        Object obj3 = "processing";
        IFetchObserver iFetchObserver3 = this.$callback;
        ?? r10 = "call to 'resume' before 'invoke' with coroutine";
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r111 = this.$name;
        ?? r112 = this.$source;
        long j4 = this.$interval;
        ?? r113 = 1;
        switch (i) {
            case 0:
                Context context9 = this.$context;
                UUID uuid13 = (UUID) this.$uuid;
                int i2 = this.label;
                try {
                    try {
                        try {
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj);
                                MutexImpl mutexImpl3 = ProfileProcessor.processLock;
                                this.L$0 = mutexImpl3;
                                this.L$1 = uuid13;
                                this.L$2 = r111;
                                this.L$3 = r112;
                                this.L$4 = context9;
                                this.L$5 = iFetchObserver3;
                                this.J$0 = j4;
                                this.label = 1;
                                if (mutexImpl3.lock(this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                uuid = uuid13;
                                uuid2 = uuid;
                                mutex = mutexImpl3;
                                context = context9;
                                r11 = r111;
                                r12 = r112;
                            } else if (i2 == 1) {
                                j4 = this.J$0;
                                iFetchObserver3 = (IFetchObserver) this.L$5;
                                context = (Context) this.L$4;
                                String str3 = (String) this.L$3;
                                String str4 = (String) this.L$2;
                                uuid = this.L$1;
                                mutex = this.L$0;
                                ResultKt.throwOnFailure(obj);
                                uuid2 = uuid13;
                                r11 = str4;
                                r12 = str3;
                            } else {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        if (i2 != 4) {
                                            if (i2 != 5) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            mutex3 = (Mutex) this.L$5;
                                            profileMeta2 = (ProfileProcessor.ProfileMeta) this.L$4;
                                            context4 = (Context) this.L$2;
                                            uuid8 = this.L$1;
                                            mutex4 = this.L$0;
                                            try {
                                                ResultKt.throwOnFailure(obj);
                                                uuid5 = uuid13;
                                                context9 = context9;
                                                BroadcastKt.sendProfileChanged(context4, uuid8);
                                                Unit unit = Unit.INSTANCE;
                                                ((MutexImpl) mutex3).unlock(null);
                                                ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$rememberPendingLogo(uuid8, profileMeta2.profileLogoUrl);
                                                ((MutexImpl) mutex4).unlock(null);
                                                ProfileProcessor.scheduleLogoFetch(context9, uuid5);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th) {
                                                th = th;
                                                ((MutexImpl) mutex3).unlock(null);
                                                throw th;
                                            }
                                        }
                                        long j5 = this.J$0;
                                        MutexImpl mutexImpl4 = this.L$8;
                                        ProfileProcessor.ProfileMeta profileMeta5 = (ProfileProcessor.ProfileMeta) this.L$7;
                                        imported4 = (Imported) this.L$6;
                                        File file3 = (File) this.L$5;
                                        Context context10 = (Context) this.L$4;
                                        String str5 = (String) this.L$3;
                                        String str6 = (String) this.L$2;
                                        uuid7 = this.L$1;
                                        Mutex mutex6 = this.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        profileMeta2 = profileMeta5;
                                        context4 = context10;
                                        r22 = str5;
                                        r21 = str6;
                                        j2 = j5;
                                        mutex2 = mutex6;
                                        mutex3 = mutexImpl4;
                                        r3 = file3;
                                        uuid5 = uuid13;
                                        try {
                                            ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
                                            ProfileProcessor.access$commitFiles(r3, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context4), uuid7.toString()));
                                            Log.d("KoalaClash", "Profile patch: announce '" + imported4.announce + "' -> '" + profileMeta2.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta2.supportURL + "'", null);
                                            dispatcherImportedDao = DaosKt.ImportedDao();
                                            importedCopy$default = Imported.copy$default(imported4, r21, r22, j2, profileMeta2.upload, profileMeta2.download, profileMeta2.total, profileMeta2.expire, System.currentTimeMillis(), profileMeta2.announce, profileMeta2.supportURL, null, profileMeta2.modeSwitchAllowed, 8709);
                                            this.L$0 = mutex2;
                                            this.L$1 = uuid7;
                                            this.L$2 = context4;
                                            this.L$3 = r3;
                                            this.L$4 = profileMeta2;
                                            this.L$5 = mutex3;
                                            this.L$6 = null;
                                            this.L$7 = null;
                                            this.L$8 = null;
                                            this.label = 5;
                                            if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                            mutex4 = mutex2;
                                            uuid8 = uuid7;
                                            BroadcastKt.sendProfileChanged(context4, uuid8);
                                            Unit unit2 = Unit.INSTANCE;
                                            ((MutexImpl) mutex3).unlock(null);
                                            ProfileProcessor profileProcessor3 = ProfileProcessor.INSTANCE;
                                            ProfileProcessor.access$rememberPendingLogo(uuid8, profileMeta2.profileLogoUrl);
                                            ((MutexImpl) mutex4).unlock(null);
                                            ProfileProcessor.scheduleLogoFetch(context9, uuid5);
                                            return Unit.INSTANCE;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            ((MutexImpl) mutex3).unlock(null);
                                            throw th;
                                        }
                                    }
                                    long j6 = this.J$0;
                                    imported3 = (Imported) this.L$6;
                                    r111 = (File) this.L$5;
                                    context4 = (Context) this.L$4;
                                    String str7 = (String) this.L$3;
                                    String str8 = (String) this.L$2;
                                    uuid6 = this.L$1;
                                    mutex2 = this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        r15 = str8;
                                        r14 = r111;
                                        uuid5 = uuid13;
                                        r0 = str7;
                                        imported4 = imported3;
                                        j = j6;
                                        objAccess$resolve = obj;
                                        try {
                                            try {
                                                profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                                                mutexImpl = ProfileProcessor.profileLock;
                                                this.L$0 = mutex2;
                                                this.L$1 = uuid6;
                                                this.L$2 = r15;
                                                this.L$3 = r0;
                                                this.L$4 = context4;
                                                this.L$5 = r14;
                                                this.L$6 = imported4;
                                                this.L$7 = profileMeta;
                                                this.L$8 = mutexImpl;
                                                this.J$0 = j;
                                                r18 = r0;
                                                this.label = 4;
                                                if (mutexImpl.lock(this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                j2 = j;
                                                r3 = r14;
                                                r21 = r15;
                                                r22 = r18;
                                                profileMeta2 = profileMeta;
                                                mutex3 = mutexImpl;
                                                uuid7 = uuid6;
                                                ProfileProcessor profileProcessor4 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$commitFiles(r3, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context4), uuid7.toString()));
                                                Log.d("KoalaClash", "Profile patch: announce '" + imported4.announce + "' -> '" + profileMeta2.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta2.supportURL + "'", null);
                                                dispatcherImportedDao = DaosKt.ImportedDao();
                                                importedCopy$default = Imported.copy$default(imported4, r21, r22, j2, profileMeta2.upload, profileMeta2.download, profileMeta2.total, profileMeta2.expire, System.currentTimeMillis(), profileMeta2.announce, profileMeta2.supportURL, null, profileMeta2.modeSwitchAllowed, 8709);
                                                this.L$0 = mutex2;
                                                this.L$1 = uuid7;
                                                this.L$2 = context4;
                                                this.L$3 = r3;
                                                this.L$4 = profileMeta2;
                                                this.L$5 = mutex3;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.L$8 = null;
                                                this.label = 5;
                                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                                mutex4 = mutex2;
                                                uuid8 = uuid7;
                                                BroadcastKt.sendProfileChanged(context4, uuid8);
                                                Unit unit3 = Unit.INSTANCE;
                                                ((MutexImpl) mutex3).unlock(null);
                                                ProfileProcessor profileProcessor5 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$rememberPendingLogo(uuid8, profileMeta2.profileLogoUrl);
                                                ((MutexImpl) mutex4).unlock(null);
                                                ProfileProcessor.scheduleLogoFetch(context9, uuid5);
                                                return Unit.INSTANCE;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                r111 = r14;
                                                obj3 = mutex2;
                                                try {
                                                    FilesKt.deleteRecursively(r111);
                                                    throw th;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    r113 = obj3;
                                                    ((MutexImpl) r113).unlock(null);
                                                    throw th;
                                                }
                                            }
                                        } catch (HwidLimitException e) {
                                            e = e;
                                            imported3 = imported4;
                                            str = e.supportURL;
                                            if (str == null) {
                                                str = imported3.supportURL;
                                            }
                                            throw new HwidLimitException(str);
                                        }
                                    } catch (HwidLimitException e2) {
                                        e = e2;
                                        str = e.supportURL;
                                        if (str == null) {
                                            str = imported3.supportURL;
                                        }
                                        throw new HwidLimitException(str);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        obj3 = mutex2;
                                        FilesKt.deleteRecursively(r111);
                                        throw th;
                                    }
                                }
                                long j7 = this.J$0;
                                iFetchObserver = (IFetchObserver) this.L$5;
                                context2 = (Context) this.L$4;
                                String str9 = (String) this.L$3;
                                String str10 = (String) this.L$2;
                                UUID uuid14 = this.L$1;
                                mutex = this.L$0;
                                ResultKt.throwOnFailure(obj);
                                uuid2 = uuid13;
                                objQueryByUUID = obj;
                                r2 = str9;
                                r13 = str10;
                                uuid3 = uuid14;
                                j4 = j7;
                                imported = (Imported) objQueryByUUID;
                                if (imported != null) {
                                    throw new IllegalArgumentException("profile " + uuid3 + " not found");
                                }
                                ProfileProcessor profileProcessor6 = ProfileProcessor.INSTANCE;
                                ProfileProcessor.access$enforceFieldsValid(r13, imported.type, r2, j4);
                                byte[] bArr = com.github.kr328.clash.service.util.FilesKt.UTF8_BOM;
                                fileResolve = FilesKt.resolve(FilesKt.resolve(context2.getFilesDir(), "processing"), uuid3.toString());
                                FilesKt.deleteRecursively(fileResolve);
                                fileResolve.mkdirs();
                                IFetchObserver iFetchObserver4 = iFetchObserver;
                                FilesKt.copyRecursively$default(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context2), uuid3.toString()), fileResolve, 4);
                                try {
                                    Profile.Type type4 = imported.type;
                                    this.L$0 = mutex;
                                    this.L$1 = uuid3;
                                    this.L$2 = r13;
                                    this.L$3 = r2;
                                    this.L$4 = context2;
                                    this.L$5 = fileResolve;
                                    this.L$6 = imported;
                                    this.J$0 = j4;
                                    this.label = 3;
                                    imported2 = imported;
                                    uuid4 = uuid3;
                                    file = fileResolve;
                                    context3 = context2;
                                    uuid5 = uuid2;
                                    try {
                                        objAccess$resolve = ProfileProcessor.access$resolve(context3, type4, r2, file, iFetchObserver4, this);
                                        if (objAccess$resolve == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        context4 = context3;
                                        r0 = r2;
                                        imported4 = imported2;
                                        ?? r41 = r13;
                                        r14 = file;
                                        j = j4;
                                        mutex2 = mutex;
                                        uuid6 = uuid4;
                                        r15 = r41;
                                        profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                                        mutexImpl = ProfileProcessor.profileLock;
                                        this.L$0 = mutex2;
                                        this.L$1 = uuid6;
                                        this.L$2 = r15;
                                        this.L$3 = r0;
                                        this.L$4 = context4;
                                        this.L$5 = r14;
                                        this.L$6 = imported4;
                                        this.L$7 = profileMeta;
                                        this.L$8 = mutexImpl;
                                        this.J$0 = j;
                                        r18 = r0;
                                        this.label = 4;
                                        if (mutexImpl.lock(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        j2 = j;
                                        r3 = r14;
                                        r21 = r15;
                                        r22 = r18;
                                        profileMeta2 = profileMeta;
                                        mutex3 = mutexImpl;
                                        uuid7 = uuid6;
                                        ProfileProcessor profileProcessor7 = ProfileProcessor.INSTANCE;
                                        ProfileProcessor.access$commitFiles(r3, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context4), uuid7.toString()));
                                        Log.d("KoalaClash", "Profile patch: announce '" + imported4.announce + "' -> '" + profileMeta2.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta2.supportURL + "'", null);
                                        dispatcherImportedDao = DaosKt.ImportedDao();
                                        importedCopy$default = Imported.copy$default(imported4, r21, r22, j2, profileMeta2.upload, profileMeta2.download, profileMeta2.total, profileMeta2.expire, System.currentTimeMillis(), profileMeta2.announce, profileMeta2.supportURL, null, profileMeta2.modeSwitchAllowed, 8709);
                                        this.L$0 = mutex2;
                                        this.L$1 = uuid7;
                                        this.L$2 = context4;
                                        this.L$3 = r3;
                                        this.L$4 = profileMeta2;
                                        this.L$5 = mutex3;
                                        this.L$6 = null;
                                        this.L$7 = null;
                                        this.L$8 = null;
                                        this.label = 5;
                                        if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        mutex4 = mutex2;
                                        uuid8 = uuid7;
                                        BroadcastKt.sendProfileChanged(context4, uuid8);
                                        Unit unit4 = Unit.INSTANCE;
                                        ((MutexImpl) mutex3).unlock(null);
                                        ProfileProcessor profileProcessor8 = ProfileProcessor.INSTANCE;
                                        ProfileProcessor.access$rememberPendingLogo(uuid8, profileMeta2.profileLogoUrl);
                                        ((MutexImpl) mutex4).unlock(null);
                                        ProfileProcessor.scheduleLogoFetch(context9, uuid5);
                                        return Unit.INSTANCE;
                                    } catch (HwidLimitException e3) {
                                        e = e3;
                                        imported3 = imported2;
                                        str = e.supportURL;
                                        if (str == null) {
                                            str = imported3.supportURL;
                                        }
                                        throw new HwidLimitException(str);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        r111 = file;
                                        obj3 = mutex;
                                        FilesKt.deleteRecursively(r111);
                                        throw th;
                                    }
                                } catch (HwidLimitException e4) {
                                    e = e4;
                                    file = fileResolve;
                                    imported2 = imported;
                                } catch (Throwable th7) {
                                    th = th7;
                                    file = fileResolve;
                                }
                            }
                            Dispatcher dispatcherImportedDao3 = DaosKt.ImportedDao();
                            this.L$0 = mutex;
                            this.L$1 = uuid;
                            this.L$2 = r11;
                            this.L$3 = r12;
                            this.L$4 = context;
                            this.L$5 = iFetchObserver3;
                            this.J$0 = j4;
                            IFetchObserver iFetchObserver5 = iFetchObserver3;
                            this.label = 2;
                            objQueryByUUID = dispatcherImportedDao3.queryByUUID(uuid, this);
                            if (objQueryByUUID == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            r2 = r12;
                            r13 = r11;
                            context2 = context;
                            uuid3 = uuid;
                            iFetchObserver = iFetchObserver5;
                            imported = (Imported) objQueryByUUID;
                            if (imported != null) {
                                throw new IllegalArgumentException("profile " + uuid3 + " not found");
                            }
                            ProfileProcessor profileProcessor9 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$enforceFieldsValid(r13, imported.type, r2, j4);
                            byte[] bArr2 = com.github.kr328.clash.service.util.FilesKt.UTF8_BOM;
                            fileResolve = FilesKt.resolve(FilesKt.resolve(context2.getFilesDir(), "processing"), uuid3.toString());
                            FilesKt.deleteRecursively(fileResolve);
                            fileResolve.mkdirs();
                            IFetchObserver iFetchObserver6 = iFetchObserver;
                            FilesKt.copyRecursively$default(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context2), uuid3.toString()), fileResolve, 4);
                            Profile.Type type5 = imported.type;
                            this.L$0 = mutex;
                            this.L$1 = uuid3;
                            this.L$2 = r13;
                            this.L$3 = r2;
                            this.L$4 = context2;
                            this.L$5 = fileResolve;
                            this.L$6 = imported;
                            this.J$0 = j4;
                            this.label = 3;
                            imported2 = imported;
                            uuid4 = uuid3;
                            file = fileResolve;
                            context3 = context2;
                            uuid5 = uuid2;
                            objAccess$resolve = ProfileProcessor.access$resolve(context3, type5, r2, file, iFetchObserver6, this);
                            if (objAccess$resolve == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            context4 = context3;
                            r0 = r2;
                            imported4 = imported2;
                            ?? r42 = r13;
                            r14 = file;
                            j = j4;
                            mutex2 = mutex;
                            uuid6 = uuid4;
                            r15 = r42;
                            profileMeta = (ProfileProcessor.ProfileMeta) objAccess$resolve;
                            mutexImpl = ProfileProcessor.profileLock;
                            this.L$0 = mutex2;
                            this.L$1 = uuid6;
                            this.L$2 = r15;
                            this.L$3 = r0;
                            this.L$4 = context4;
                            this.L$5 = r14;
                            this.L$6 = imported4;
                            this.L$7 = profileMeta;
                            this.L$8 = mutexImpl;
                            this.J$0 = j;
                            r18 = r0;
                            this.label = 4;
                            if (mutexImpl.lock(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            j2 = j;
                            r3 = r14;
                            r21 = r15;
                            r22 = r18;
                            profileMeta2 = profileMeta;
                            mutex3 = mutexImpl;
                            uuid7 = uuid6;
                            ProfileProcessor profileProcessor10 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$commitFiles(r3, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context4), uuid7.toString()));
                            Log.d("KoalaClash", "Profile patch: announce '" + imported4.announce + "' -> '" + profileMeta2.announce + "', supportURL '" + imported4.supportURL + "' -> '" + profileMeta2.supportURL + "'", null);
                            dispatcherImportedDao = DaosKt.ImportedDao();
                            importedCopy$default = Imported.copy$default(imported4, r21, r22, j2, profileMeta2.upload, profileMeta2.download, profileMeta2.total, profileMeta2.expire, System.currentTimeMillis(), profileMeta2.announce, profileMeta2.supportURL, null, profileMeta2.modeSwitchAllowed, 8709);
                            this.L$0 = mutex2;
                            this.L$1 = uuid7;
                            this.L$2 = context4;
                            this.L$3 = r3;
                            this.L$4 = profileMeta2;
                            this.L$5 = mutex3;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.label = 5;
                            if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao, importedCopy$default, 1), this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            mutex4 = mutex2;
                            uuid8 = uuid7;
                            BroadcastKt.sendProfileChanged(context4, uuid8);
                            Unit unit5 = Unit.INSTANCE;
                            ((MutexImpl) mutex3).unlock(null);
                            ProfileProcessor profileProcessor11 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$rememberPendingLogo(uuid8, profileMeta2.profileLogoUrl);
                            ((MutexImpl) mutex4).unlock(null);
                            ProfileProcessor.scheduleLogoFetch(context9, uuid5);
                            return Unit.INSTANCE;
                        } catch (Throwable th8) {
                            th = th8;
                            r111 = "call to 'resume' before 'invoke' with coroutine";
                            obj3 = "' -> '";
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        ((MutexImpl) r113).unlock(null);
                        throw th;
                    }
                } catch (Throwable th10) {
                    th = th10;
                }
                break;
            default:
                Profile.Type type6 = (Profile.Type) this.L$6;
                Context context11 = (Context) this.L$7;
                int i3 = this.label;
                try {
                    try {
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            ProfileProcessor profileProcessor12 = ProfileProcessor.INSTANCE;
                            ProfileProcessor.access$enforceFieldsValid(r111, type6, r112, j4);
                            this.label = 1;
                            objGenerateProfileUUID = DatabaseKt.generateProfileUUID(this);
                            if (objGenerateProfileUUID != coroutineSingletons) {
                            }
                            obj2 = coroutineSingletons;
                            return obj2;
                        }
                        if (i3 != 1) {
                            if (i3 == 2) {
                                j4 = this.J$0;
                                String str11 = (String) this.L$5;
                                IFetchObserver iFetchObserver7 = (IFetchObserver) this.L$4;
                                String str12 = (String) this.L$3;
                                type6 = (Profile.Type) this.L$2;
                                context5 = this.$context;
                                Mutex mutex7 = this.L$0;
                                uuid9 = this.L$1;
                                ResultKt.throwOnFailure(obj);
                                iFetchObserver2 = iFetchObserver7;
                                r4 = str12;
                                r112 = mutex7;
                                r16 = str11;
                                try {
                                    byte[] bArr3 = com.github.kr328.clash.service.util.FilesKt.UTF8_BOM;
                                    fileResolve2 = FilesKt.resolve(FilesKt.resolve(context5.getFilesDir(), "processing"), uuid9.toString());
                                    FilesKt.deleteRecursively(fileResolve2);
                                    fileResolve2.mkdirs();
                                    FilesKt.resolve(fileResolve2, "config.yaml").createNewFile();
                                    FilesKt.resolve(fileResolve2, "providers").mkdir();
                                    try {
                                        ProfileProcessor profileProcessor13 = ProfileProcessor.INSTANCE;
                                        this.L$1 = uuid9;
                                        this.L$0 = r112;
                                        this.$context = context5;
                                        this.L$2 = type6;
                                        this.L$3 = r4;
                                        this.L$4 = r16;
                                        this.L$5 = fileResolve2;
                                        this.J$0 = j4;
                                        this.label = 3;
                                        type = type6;
                                        context6 = context5;
                                        file2 = fileResolve2;
                                        objAccess$resolve2 = ProfileProcessor.access$resolve(context6, type, r4, file2, iFetchObserver2, this);
                                        if (objAccess$resolve2 == coroutineSingletons) {
                                            obj2 = coroutineSingletons;
                                        } else {
                                            r8 = r16;
                                            type2 = type;
                                            UUID uuid15 = uuid9;
                                            context7 = context6;
                                            j3 = j4;
                                            uuid10 = uuid15;
                                            r5 = r4;
                                            r17 = r112;
                                            profileMeta3 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                            mutexImpl2 = ProfileProcessor.profileLock;
                                            this.L$1 = uuid10;
                                            this.L$0 = r17;
                                            this.$context = context7;
                                            this.L$2 = type2;
                                            this.L$3 = r5;
                                            this.L$4 = r8;
                                            this.L$5 = profileMeta3;
                                            this.$uuid = file2;
                                            this.L$8 = mutexImpl2;
                                            this.J$0 = j3;
                                            this.label = 4;
                                            obj2 = coroutineSingletons;
                                            if (mutexImpl2.lock(this) != coroutineSingletons) {
                                                r20 = r5;
                                                type3 = type2;
                                                r9 = r8;
                                                r19 = r17;
                                                uuid11 = uuid10;
                                                millis = j3;
                                                profileMeta4 = profileMeta3;
                                                r6 = r19;
                                                ProfileProcessor profileProcessor14 = ProfileProcessor.INSTANCE;
                                                ProfileProcessor.access$commitFiles(file2, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context7), uuid11.toString()));
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                str2 = profileMeta4.title;
                                                if (str2 == null) {
                                                    r110 = r9;
                                                } else {
                                                    if (!StringsKt.isBlank(str2)) {
                                                        str2 = null;
                                                    }
                                                    if (str2 == null) {
                                                        r110 = r9;
                                                    } else {
                                                        r110 = str2;
                                                    }
                                                }
                                                if (millis == 0) {
                                                    millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                                }
                                                long j8 = millis;
                                                dispatcherImportedDao2 = DaosKt.ImportedDao();
                                                imported5 = new Imported(uuid11, (String) r110, type3, (String) r20, j8, profileMeta4.upload, profileMeta4.download, profileMeta4.total, profileMeta4.expire, jCurrentTimeMillis, jCurrentTimeMillis, profileMeta4.announce, profileMeta4.supportURL, profileMeta4.modeSwitchAllowed, 8192);
                                                this.L$1 = uuid11;
                                                this.L$0 = r6;
                                                this.$context = context7;
                                                this.L$2 = profileMeta4;
                                                this.L$3 = file2;
                                                this.L$4 = mutexImpl2;
                                                this.L$5 = null;
                                                this.$uuid = null;
                                                this.L$8 = null;
                                                this.label = 5;
                                                obj2 = coroutineSingletons;
                                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                                    context8 = context7;
                                                    uuid12 = uuid11;
                                                    mutex5 = mutexImpl2;
                                                    r7 = r6;
                                                    BroadcastKt.sendProfileChanged(context8, uuid12);
                                                    Unit unit6 = Unit.INSTANCE;
                                                    ((MutexImpl) mutex5).unlock(null);
                                                    ProfileProcessor profileProcessor15 = ProfileProcessor.INSTANCE;
                                                    ProfileProcessor.access$rememberPendingLogo(uuid12, profileMeta4.profileLogoUrl);
                                                    ((MutexImpl) r7).unlock(null);
                                                    ProfileProcessor.scheduleLogoFetch(context11, uuid12);
                                                    obj2 = uuid12;
                                                }
                                            }
                                        }
                                        obj2 = coroutineSingletons;
                                        return obj2;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        r10 = fileResolve2;
                                        FilesKt.deleteRecursively(r10);
                                        throw th;
                                    }
                                } catch (Throwable th12) {
                                    ((MutexImpl) r112).unlock(null);
                                    throw th12;
                                }
                            }
                            if (i3 == 3) {
                                j3 = this.J$0;
                                file2 = (File) this.L$5;
                                String str13 = (String) this.L$4;
                                String str14 = (String) this.L$3;
                                Profile.Type type7 = (Profile.Type) this.L$2;
                                context7 = this.$context;
                                Mutex mutex8 = this.L$0;
                                UUID uuid16 = this.L$1;
                                ResultKt.throwOnFailure(obj);
                                uuid10 = uuid16;
                                type2 = type7;
                                r8 = str13;
                                r5 = str14;
                                objAccess$resolve2 = obj;
                                r17 = mutex8;
                                profileMeta3 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                mutexImpl2 = ProfileProcessor.profileLock;
                                this.L$1 = uuid10;
                                this.L$0 = r17;
                                this.$context = context7;
                                this.L$2 = type2;
                                this.L$3 = r5;
                                this.L$4 = r8;
                                this.L$5 = profileMeta3;
                                this.$uuid = file2;
                                this.L$8 = mutexImpl2;
                                this.J$0 = j3;
                                this.label = 4;
                                obj2 = coroutineSingletons;
                                if (mutexImpl2.lock(this) != coroutineSingletons) {
                                    r20 = r5;
                                    type3 = type2;
                                    r9 = r8;
                                    r19 = r17;
                                    uuid11 = uuid10;
                                    millis = j3;
                                    profileMeta4 = profileMeta3;
                                    r6 = r19;
                                    ProfileProcessor profileProcessor16 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$commitFiles(file2, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context7), uuid11.toString()));
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    str2 = profileMeta4.title;
                                    if (str2 == null) {
                                        r110 = r9;
                                    } else {
                                        if (!StringsKt.isBlank(str2)) {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            r110 = r9;
                                        } else {
                                            r110 = str2;
                                        }
                                    }
                                    if (millis == 0) {
                                        millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                    }
                                    long j9 = millis;
                                    dispatcherImportedDao2 = DaosKt.ImportedDao();
                                    imported5 = new Imported(uuid11, (String) r110, type3, (String) r20, j9, profileMeta4.upload, profileMeta4.download, profileMeta4.total, profileMeta4.expire, jCurrentTimeMillis2, jCurrentTimeMillis2, profileMeta4.announce, profileMeta4.supportURL, profileMeta4.modeSwitchAllowed, 8192);
                                    this.L$1 = uuid11;
                                    this.L$0 = r6;
                                    this.$context = context7;
                                    this.L$2 = profileMeta4;
                                    this.L$3 = file2;
                                    this.L$4 = mutexImpl2;
                                    this.L$5 = null;
                                    this.$uuid = null;
                                    this.L$8 = null;
                                    this.label = 5;
                                    obj2 = coroutineSingletons;
                                    if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                        context8 = context7;
                                        uuid12 = uuid11;
                                        mutex5 = mutexImpl2;
                                        r7 = r6;
                                        BroadcastKt.sendProfileChanged(context8, uuid12);
                                        Unit unit7 = Unit.INSTANCE;
                                        ((MutexImpl) mutex5).unlock(null);
                                        ProfileProcessor profileProcessor17 = ProfileProcessor.INSTANCE;
                                        ProfileProcessor.access$rememberPendingLogo(uuid12, profileMeta4.profileLogoUrl);
                                        ((MutexImpl) r7).unlock(null);
                                        ProfileProcessor.scheduleLogoFetch(context11, uuid12);
                                        obj2 = uuid12;
                                    }
                                }
                                obj2 = coroutineSingletons;
                                return obj2;
                            }
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex5 = (Mutex) this.L$4;
                                profileMeta4 = (ProfileProcessor.ProfileMeta) this.L$2;
                                context8 = this.$context;
                                Mutex mutex9 = this.L$0;
                                UUID uuid17 = this.L$1;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r7 = mutex9;
                                    uuid12 = uuid17;
                                    BroadcastKt.sendProfileChanged(context8, uuid12);
                                    Unit unit8 = Unit.INSTANCE;
                                    ((MutexImpl) mutex5).unlock(null);
                                    ProfileProcessor profileProcessor18 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$rememberPendingLogo(uuid12, profileMeta4.profileLogoUrl);
                                    ((MutexImpl) r7).unlock(null);
                                    ProfileProcessor.scheduleLogoFetch(context11, uuid12);
                                    obj2 = uuid12;
                                    obj2 = coroutineSingletons;
                                    return obj2;
                                } catch (Throwable th13) {
                                    th = th13;
                                    ((MutexImpl) mutex5).unlock(null);
                                    throw th;
                                }
                            }
                            j3 = this.J$0;
                            MutexImpl mutexImpl5 = this.L$8;
                            file2 = (File) this.$uuid;
                            profileMeta3 = (ProfileProcessor.ProfileMeta) this.L$5;
                            String str15 = (String) this.L$4;
                            String str16 = (String) this.L$3;
                            Profile.Type type8 = (Profile.Type) this.L$2;
                            Context context12 = this.$context;
                            Mutex mutex10 = this.L$0;
                            uuid10 = this.L$1;
                            ResultKt.throwOnFailure(obj);
                            mutexImpl2 = mutexImpl5;
                            r20 = str16;
                            type3 = type8;
                            context7 = context12;
                            r9 = str15;
                            r19 = mutex10;
                            uuid11 = uuid10;
                            millis = j3;
                            profileMeta4 = profileMeta3;
                            r6 = r19;
                            try {
                                ProfileProcessor profileProcessor19 = ProfileProcessor.INSTANCE;
                                ProfileProcessor.access$commitFiles(file2, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context7), uuid11.toString()));
                                long jCurrentTimeMillis3 = System.currentTimeMillis();
                                str2 = profileMeta4.title;
                                if (str2 == null) {
                                    r110 = r9;
                                } else {
                                    if (!StringsKt.isBlank(str2)) {
                                        str2 = null;
                                    }
                                    if (str2 == null) {
                                        r110 = r9;
                                    } else {
                                        r110 = str2;
                                    }
                                }
                                if (millis == 0 && (l = profileMeta4.intervalSeconds) != null) {
                                    millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                }
                                long j10 = millis;
                                dispatcherImportedDao2 = DaosKt.ImportedDao();
                                imported5 = new Imported(uuid11, (String) r110, type3, (String) r20, j10, profileMeta4.upload, profileMeta4.download, profileMeta4.total, profileMeta4.expire, jCurrentTimeMillis3, jCurrentTimeMillis3, profileMeta4.announce, profileMeta4.supportURL, profileMeta4.modeSwitchAllowed, 8192);
                                this.L$1 = uuid11;
                                this.L$0 = r6;
                                this.$context = context7;
                                this.L$2 = profileMeta4;
                                this.L$3 = file2;
                                this.L$4 = mutexImpl2;
                                this.L$5 = null;
                                this.$uuid = null;
                                this.L$8 = null;
                                this.label = 5;
                                obj2 = coroutineSingletons;
                                if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                    context8 = context7;
                                    uuid12 = uuid11;
                                    mutex5 = mutexImpl2;
                                    r7 = r6;
                                    BroadcastKt.sendProfileChanged(context8, uuid12);
                                    Unit unit9 = Unit.INSTANCE;
                                    ((MutexImpl) mutex5).unlock(null);
                                    ProfileProcessor profileProcessor110 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$rememberPendingLogo(uuid12, profileMeta4.profileLogoUrl);
                                    ((MutexImpl) r7).unlock(null);
                                    ProfileProcessor.scheduleLogoFetch(context11, uuid12);
                                    obj2 = uuid12;
                                }
                                obj2 = coroutineSingletons;
                                return obj2;
                            } catch (Throwable th14) {
                                th = th14;
                                mutex5 = mutexImpl2;
                                ((MutexImpl) mutex5).unlock(null);
                                throw th;
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                        objGenerateProfileUUID = obj;
                        obj2 = coroutineSingletons;
                        uuid9 = (UUID) objGenerateProfileUUID;
                        MutexImpl mutexImpl6 = ProfileProcessor.processLock;
                        this.L$1 = uuid9;
                        this.L$0 = mutexImpl6;
                        this.$context = context11;
                        this.L$2 = type6;
                        this.L$3 = r112;
                        this.L$4 = iFetchObserver3;
                        this.L$5 = r111;
                        this.J$0 = j4;
                        this.label = 2;
                        obj2 = coroutineSingletons;
                        if (mutexImpl6.lock(this) != coroutineSingletons) {
                            iFetchObserver2 = iFetchObserver3;
                            r4 = r112;
                            r112 = mutexImpl6;
                            context5 = context11;
                            r16 = r111;
                            byte[] bArr4 = com.github.kr328.clash.service.util.FilesKt.UTF8_BOM;
                            fileResolve2 = FilesKt.resolve(FilesKt.resolve(context5.getFilesDir(), "processing"), uuid9.toString());
                            FilesKt.deleteRecursively(fileResolve2);
                            fileResolve2.mkdirs();
                            FilesKt.resolve(fileResolve2, "config.yaml").createNewFile();
                            FilesKt.resolve(fileResolve2, "providers").mkdir();
                            ProfileProcessor profileProcessor111 = ProfileProcessor.INSTANCE;
                            this.L$1 = uuid9;
                            this.L$0 = r112;
                            this.$context = context5;
                            this.L$2 = type6;
                            this.L$3 = r4;
                            this.L$4 = r16;
                            this.L$5 = fileResolve2;
                            this.J$0 = j4;
                            this.label = 3;
                            type = type6;
                            context6 = context5;
                            file2 = fileResolve2;
                            objAccess$resolve2 = ProfileProcessor.access$resolve(context6, type, r4, file2, iFetchObserver2, this);
                            if (objAccess$resolve2 == coroutineSingletons) {
                                obj2 = coroutineSingletons;
                            } else {
                                r8 = r16;
                                type2 = type;
                                UUID uuid18 = uuid9;
                                context7 = context6;
                                j3 = j4;
                                uuid10 = uuid18;
                                r5 = r4;
                                r17 = r112;
                                profileMeta3 = (ProfileProcessor.ProfileMeta) objAccess$resolve2;
                                mutexImpl2 = ProfileProcessor.profileLock;
                                this.L$1 = uuid10;
                                this.L$0 = r17;
                                this.$context = context7;
                                this.L$2 = type2;
                                this.L$3 = r5;
                                this.L$4 = r8;
                                this.L$5 = profileMeta3;
                                this.$uuid = file2;
                                this.L$8 = mutexImpl2;
                                this.J$0 = j3;
                                this.label = 4;
                                obj2 = coroutineSingletons;
                                if (mutexImpl2.lock(this) != coroutineSingletons) {
                                    r20 = r5;
                                    type3 = type2;
                                    r9 = r8;
                                    r19 = r17;
                                    uuid11 = uuid10;
                                    millis = j3;
                                    profileMeta4 = profileMeta3;
                                    r6 = r19;
                                    ProfileProcessor profileProcessor112 = ProfileProcessor.INSTANCE;
                                    ProfileProcessor.access$commitFiles(file2, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(context7), uuid11.toString()));
                                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                                    str2 = profileMeta4.title;
                                    if (str2 == null) {
                                        r110 = r9;
                                    } else {
                                        if (!StringsKt.isBlank(str2)) {
                                            str2 = null;
                                        }
                                        if (str2 == null) {
                                            r110 = r9;
                                        } else {
                                            r110 = str2;
                                        }
                                    }
                                    if (millis == 0) {
                                        millis = TimeUnit.SECONDS.toMillis(l.longValue());
                                    }
                                    long j11 = millis;
                                    dispatcherImportedDao2 = DaosKt.ImportedDao();
                                    imported5 = new Imported(uuid11, (String) r110, type3, (String) r20, j11, profileMeta4.upload, profileMeta4.download, profileMeta4.total, profileMeta4.expire, jCurrentTimeMillis4, jCurrentTimeMillis4, profileMeta4.announce, profileMeta4.supportURL, profileMeta4.modeSwitchAllowed, 8192);
                                    this.L$1 = uuid11;
                                    this.L$0 = r6;
                                    this.$context = context7;
                                    this.L$2 = profileMeta4;
                                    this.L$3 = file2;
                                    this.L$4 = mutexImpl2;
                                    this.L$5 = null;
                                    this.$uuid = null;
                                    this.L$8 = null;
                                    this.label = 5;
                                    obj2 = coroutineSingletons;
                                    if (CoroutinesRoom.execute((Database_Impl) dispatcherImportedDao2.executorServiceOrNull, new ImportedDao_Impl$4(dispatcherImportedDao2, imported5, 0), this) != coroutineSingletons) {
                                        context8 = context7;
                                        uuid12 = uuid11;
                                        mutex5 = mutexImpl2;
                                        r7 = r6;
                                        BroadcastKt.sendProfileChanged(context8, uuid12);
                                        Unit unit10 = Unit.INSTANCE;
                                        ((MutexImpl) mutex5).unlock(null);
                                        ProfileProcessor profileProcessor113 = ProfileProcessor.INSTANCE;
                                        ProfileProcessor.access$rememberPendingLogo(uuid12, profileMeta4.profileLogoUrl);
                                        ((MutexImpl) r7).unlock(null);
                                        ProfileProcessor.scheduleLogoFetch(context11, uuid12);
                                        obj2 = uuid12;
                                    }
                                }
                            }
                        }
                        obj2 = coroutineSingletons;
                        return obj2;
                    } catch (Throwable th15) {
                        th = th15;
                    }
                } catch (Throwable th16) {
                    th = th16;
                    r10 = iFetchObserver3;
                    r112 = 2;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileProcessor$patch$2(String str, Profile.Type type, String str2, long j, Context context, IFetchObserver iFetchObserver, Continuation continuation) {
        super(2, continuation);
        this.$name = str;
        this.L$6 = type;
        this.$source = str2;
        this.$interval = j;
        this.L$7 = context;
        this.$callback = iFetchObserver;
    }
}
