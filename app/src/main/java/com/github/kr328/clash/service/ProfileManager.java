package com.github.kr328.clash.service;

import coil.RealImageLoader$executeMain$result$1;
import com.github.kr328.clash.FilesActivity$Content$1$1;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.UpdateChecker$check$2;
import com.github.kr328.clash.service.data.DaosKt;
import com.github.kr328.clash.service.data.Imported;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import com.github.kr328.clash.service.remote.IProfileManager;
import com.github.kr328.clash.service.store.ServiceStore;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileManager implements IProfileManager, CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0;
    public final RemoteService context;
    public final ServiceStore store;

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$import$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.mo816import(null, null, null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$queryActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00261 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00261(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.queryActive(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$queryAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00271 extends ContinuationImpl {
        public ProfileManager L$0;
        public Collection L$1;
        public Iterator L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00271(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.queryAll(this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.ProfileManager$resolveProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class C00281 extends ContinuationImpl {
        public ProfileManager L$0;
        public UUID L$1;
        public int label;
        public /* synthetic */ Object result;

        public C00281(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProfileManager.this.resolveProfile(null, this);
        }
    }

    public ProfileManager(RemoteService remoteService) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.$$delegate_0 = JobKt.CoroutineScope(DefaultIoScheduler.INSTANCE);
        this.context = remoteService;
        this.store = new ServiceStore(remoteService);
        JobKt.launch$default(this, null, new UpdateChecker$check$2(2, null, 7), 3);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object clone(UUID uuid, Continuation continuation) {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        return JobKt.withContext(NonCancellable.INSTANCE, new FilesActivity$Content$1$1(this.context, uuid, (Continuation) null), continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object delete(UUID uuid, Continuation continuation) throws Throwable {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new ProfileProcessor$delete$2(this.context, uuid, null), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objWithContext != coroutineSingletons) {
            objWithContext = Unit.INSTANCE;
        }
        return objWithContext == coroutineSingletons ? objWithContext : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /* JADX INFO: renamed from: import, reason: not valid java name */
    public final Object mo816import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ProfileManager profileManager;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1((ContinuationImpl) continuation);
        }
        Object objWithContext = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new ProfileProcessor$patch$2(str, type, str2, j, this.context, iFetchObserver, (Continuation) null), anonymousClass1);
            if (objWithContext != coroutineSingletons) {
                profileManager = this;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            UUID uuid = (UUID) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
            return uuid;
        }
        profileManager = (ProfileManager) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objWithContext);
        UUID uuid2 = (UUID) objWithContext;
        ProfileProcessor profileProcessor2 = ProfileProcessor.INSTANCE;
        RemoteService remoteService = profileManager.context;
        anonymousClass1.L$0 = uuid2;
        anonymousClass1.label = 2;
        Object objWithContext2 = JobKt.withContext(NonCancellable.INSTANCE, new RealImageLoader$executeMain$result$1(remoteService, uuid2, (Continuation) null), anonymousClass1);
        if (objWithContext2 != coroutineSingletons) {
            objWithContext2 = Unit.INSTANCE;
        }
        return objWithContext2 == coroutineSingletons ? coroutineSingletons : uuid2;
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation) throws Throwable {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new ProfileProcessor$patch$2(this.context, uuid, str, str2, j, iFetchObserver, (Continuation) null), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objWithContext != coroutineSingletons) {
            objWithContext = Unit.INSTANCE;
        }
        return objWithContext == coroutineSingletons ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryActive(Continuation continuation) throws IOException {
        C00261 c00261;
        UUID activeProfile;
        ProfileManager profileManager;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            int i = c00261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00261.label = i - Integer.MIN_VALUE;
            } else {
                c00261 = new C00261((ContinuationImpl) continuation);
            }
        } else {
            c00261 = new C00261((ContinuationImpl) continuation);
        }
        Object objExists = c00261.result;
        int i2 = c00261.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExists);
            activeProfile = this.store.getActiveProfile();
            if (activeProfile != null) {
                Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
                c00261.L$0 = this;
                c00261.L$1 = activeProfile;
                c00261.label = 1;
                objExists = dispatcherImportedDao.exists(activeProfile, c00261);
                if (objExists != coroutineSingletons) {
                    profileManager = this;
                }
            }
            return null;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objExists);
            return objExists;
        }
        activeProfile = c00261.L$1;
        profileManager = c00261.L$0;
        ResultKt.throwOnFailure(objExists);
        if (((Boolean) objExists).booleanValue()) {
            c00261.L$0 = null;
            c00261.L$1 = null;
            c00261.label = 2;
            Object objResolveProfile = profileManager.resolveProfile(activeProfile, c00261);
            return objResolveProfile == coroutineSingletons ? coroutineSingletons : objResolveProfile;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        if (r8 == r4) goto L25;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:26:0x0080). Please report as a decompilation issue!!! */
    @Override // com.github.kr328.clash.service.remote.IProfileManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryAll(kotlin.coroutines.Continuation r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.github.kr328.clash.service.ProfileManager.C00271
            if (r0 == 0) goto L13
            r0 = r8
            com.github.kr328.clash.service.ProfileManager$queryAll$1 r0 = (com.github.kr328.clash.service.ProfileManager.C00271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L13:
            com.github.kr328.clash.service.ProfileManager$queryAll$1 r0 = new com.github.kr328.clash.service.ProfileManager$queryAll$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r8 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r8
            r0.<init>(r8)
        L1a:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            java.util.Iterator r1 = r0.L$2
            java.util.Collection r3 = r0.L$1
            java.util.Collection r3 = (java.util.Collection) r3
            com.github.kr328.clash.service.ProfileManager r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L80
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3c:
            com.github.kr328.clash.service.ProfileManager r1 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            okhttp3.Dispatcher r8 = com.github.kr328.clash.service.data.DaosKt.ImportedDao()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.queryAllUUIDs(r0)
            if (r8 != r4) goto L54
            goto L7f
        L54:
            r1 = r7
        L55:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r8 = r8.iterator()
            r5 = r1
            r1 = r8
        L62:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L88
            java.lang.Object r8 = r1.next()
            java.util.UUID r8 = (java.util.UUID) r8
            r0.L$0 = r5
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            r0.L$1 = r6
            r0.L$2 = r1
            r0.label = r2
            java.lang.Object r8 = r5.resolveProfile(r8, r0)
            if (r8 != r4) goto L80
        L7f:
            return r4
        L80:
            com.github.kr328.clash.service.model.Profile r8 = (com.github.kr328.clash.service.model.Profile) r8
            if (r8 == 0) goto L62
            r3.add(r8)
            goto L62
        L88:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.service.ProfileManager.queryAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object queryByUUID(UUID uuid, Continuation continuation) {
        return resolveProfile(uuid, (ContinuationImpl) continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object resolveProfile(UUID uuid, ContinuationImpl continuationImpl) throws IOException {
        C00281 c00281;
        ProfileManager profileManager;
        Long lValueOf;
        long jLongValue;
        byte[] bArr;
        UUID uuid2 = uuid;
        if (continuationImpl instanceof C00281) {
            c00281 = (C00281) continuationImpl;
            int i = c00281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00281.label = i - Integer.MIN_VALUE;
            } else {
                c00281 = new C00281(continuationImpl);
            }
        } else {
            c00281 = new C00281(continuationImpl);
        }
        Object objQueryByUUID = c00281.result;
        int i2 = c00281.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objQueryByUUID);
            Dispatcher dispatcherImportedDao = DaosKt.ImportedDao();
            c00281.L$0 = this;
            c00281.L$1 = uuid2;
            c00281.label = 1;
            objQueryByUUID = dispatcherImportedDao.queryByUUID(uuid2, c00281);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objQueryByUUID == coroutineSingletons) {
                return coroutineSingletons;
            }
            profileManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uuid2 = c00281.L$1;
            profileManager = c00281.L$0;
            ResultKt.throwOnFailure(objQueryByUUID);
        }
        Imported imported = (Imported) objQueryByUUID;
        if (imported == null) {
            return null;
        }
        ServiceStore serviceStore = profileManager.store;
        RemoteService remoteService = profileManager.context;
        UUID activeProfile = serviceStore.getActiveProfile();
        Long l = new Long(imported.updatedAt);
        if (l.longValue() <= 0) {
            l = null;
        }
        if (l != null) {
            jLongValue = l.longValue();
        } else {
            Iterator it = new FileTreeWalk(1, 0, FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(remoteService), uuid2.toString()), null).iterator();
            if (it.hasNext()) {
                lValueOf = Long.valueOf(((File) it.next()).lastModified());
                while (it.hasNext()) {
                    Long lValueOf2 = Long.valueOf(((File) it.next()).lastModified());
                    if (lValueOf.compareTo(lValueOf2) < 0) {
                        lValueOf = lValueOf2;
                    }
                }
            } else {
                lValueOf = null;
            }
            jLongValue = lValueOf != null ? lValueOf.longValue() : -1L;
        }
        long j = jLongValue;
        File fileResolve = FilesKt.resolve(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir(remoteService), uuid2.toString()), "profile-logo");
        if (!fileResolve.isFile() && (bArr = imported.profileImage) != null) {
            com.github.kr328.clash.service.util.FilesKt.writeProfileLogo(remoteService, uuid2, bArr);
        }
        if (!fileResolve.isFile()) {
            fileResolve = null;
        }
        String absolutePath = fileResolve != null ? fileResolve.getAbsolutePath() : null;
        UUID uuid3 = imported.uuid;
        return new Profile(uuid3, imported.name, imported.type, imported.source, activeProfile != null && Intrinsics.areEqual(uuid3, activeProfile), imported.interval, imported.upload, imported.download, imported.total, imported.expire, j, absolutePath, imported.announce, imported.supportURL, imported.modeSwitchAllowed);
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object setActive(Profile profile, Continuation continuation) throws Throwable {
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        Object objWithContext = JobKt.withContext(NonCancellable.INSTANCE, new RealImageLoader$executeMain$result$1(this.context, profile.uuid, (Continuation) null), (ContinuationImpl) continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (objWithContext != coroutineSingletons) {
            objWithContext = Unit.INSTANCE;
        }
        return objWithContext == coroutineSingletons ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.github.kr328.clash.service.remote.IProfileManager
    public final Object update(UUID uuid, Continuation continuation) {
        JobKt.launch$default(this, null, new FilesActivity$showError$1(this, uuid, null, 16), 3);
        return Unit.INSTANCE;
    }
}
