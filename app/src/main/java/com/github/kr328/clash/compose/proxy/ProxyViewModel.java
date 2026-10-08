package com.github.kr328.clash.compose.proxy;

import android.app.Application;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import com.github.kr328.clash.ShareToTvActivity$onCreate$1$list$1$1;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.RemoteKt;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassReference;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyViewModel extends AndroidViewModel {
    public final StateFlowImpl _configMode;
    public final StateFlowImpl _currentMode;
    public final StateFlowImpl _error;
    public final StateFlowImpl _expandedGroups;
    public final StateFlowImpl _groupNames;
    public final StateFlowImpl _groups;
    public final StateFlowImpl _isLoading;
    public final StateFlowImpl _modeSwitchAllowed;
    public final StateFlowImpl _proxySort;
    public final StateFlowImpl _testedProxies;
    public final StateFlowImpl _testingGroups;
    public final StateFlowImpl _testingNodes;
    public final ReadonlyStateFlow configMode;
    public final ReadonlyStateFlow currentMode;
    public final ReadonlyStateFlow error;
    public final ReadonlyStateFlow expandedGroups;
    public final MutexImpl groupLoadLock;
    public final ReadonlyStateFlow groupNames;
    public final ReadonlyStateFlow groups;
    public final ReadonlyStateFlow isLoading;
    public final ReadonlyStateFlow modeSwitchAllowed;
    public final ReadonlyStateFlow proxySort;
    public final ReadonlyStateFlow testedProxies;
    public final ReadonlyStateFlow testingGroups;
    public final ReadonlyStateFlow testingNodes;
    public final UiStore uiStore;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Factory implements ViewModelProvider$Factory {
        public final /* synthetic */ int $r8$classId;
        public final Application application;

        public /* synthetic */ Factory(Application application, int i) {
            this.$r8$classId = i;
            this.application = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final /* synthetic */ ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
            int i = this.$r8$classId;
            return create(classReference.getJClass(), mutableCreationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 0:
                    break;
            }
            return create(cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider$Factory
        public final ViewModel create(Class cls) {
            switch (this.$r8$classId) {
                case 0:
                    return new ProxyViewModel(this.application);
                default:
                    return new NewProfileViewModel(this.application);
            }
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public ProxyViewModel L$0;
        public ProxySort L$1;
        public Map L$2;
        public Iterator L$3;
        public Map L$4;
        public Object L$5;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProxyViewModel.this.loadGroups(null, this);
        }
    }

    public ProxyViewModel(Application application) {
        super(application);
        UiStore uiStore = new UiStore(application);
        this.uiStore = uiStore;
        this.groupLoadLock = new MutexImpl();
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._groupNames = stateFlowImplMutableStateFlow;
        this.groupNames = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(EmptyMap.INSTANCE);
        this._groups = stateFlowImplMutableStateFlow2;
        this.groups = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        EmptySet emptySet = EmptySet.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(emptySet);
        this._expandedGroups = stateFlowImplMutableStateFlow3;
        this.expandedGroups = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(null);
        this._currentMode = stateFlowImplMutableStateFlow4;
        this.currentMode = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        StateFlowImpl stateFlowImplMutableStateFlow5 = FlowKt.MutableStateFlow(null);
        this._configMode = stateFlowImplMutableStateFlow5;
        this.configMode = FlowKt.asStateFlow(stateFlowImplMutableStateFlow5);
        Boolean bool = Boolean.TRUE;
        StateFlowImpl stateFlowImplMutableStateFlow6 = FlowKt.MutableStateFlow(bool);
        this._modeSwitchAllowed = stateFlowImplMutableStateFlow6;
        this.modeSwitchAllowed = FlowKt.asStateFlow(stateFlowImplMutableStateFlow6);
        KProperty kProperty = UiStore.$$delegatedProperties[6];
        StateFlowImpl stateFlowImplMutableStateFlow7 = FlowKt.MutableStateFlow((ProxySort) uiStore.proxySort$delegate.getValue());
        this._proxySort = stateFlowImplMutableStateFlow7;
        this.proxySort = FlowKt.asStateFlow(stateFlowImplMutableStateFlow7);
        StateFlowImpl stateFlowImplMutableStateFlow8 = FlowKt.MutableStateFlow(bool);
        this._isLoading = stateFlowImplMutableStateFlow8;
        this.isLoading = FlowKt.asStateFlow(stateFlowImplMutableStateFlow8);
        StateFlowImpl stateFlowImplMutableStateFlow9 = FlowKt.MutableStateFlow(emptySet);
        this._testingGroups = stateFlowImplMutableStateFlow9;
        this.testingGroups = FlowKt.asStateFlow(stateFlowImplMutableStateFlow9);
        StateFlowImpl stateFlowImplMutableStateFlow10 = FlowKt.MutableStateFlow(emptySet);
        this._testingNodes = stateFlowImplMutableStateFlow10;
        this.testingNodes = FlowKt.asStateFlow(stateFlowImplMutableStateFlow10);
        StateFlowImpl stateFlowImplMutableStateFlow11 = FlowKt.MutableStateFlow(emptySet);
        this._testedProxies = stateFlowImplMutableStateFlow11;
        this.testedProxies = FlowKt.asStateFlow(stateFlowImplMutableStateFlow11);
        StateFlowImpl stateFlowImplMutableStateFlow12 = FlowKt.MutableStateFlow(null);
        this._error = stateFlowImplMutableStateFlow12;
        this.error = FlowKt.asStateFlow(stateFlowImplMutableStateFlow12);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$queryModeSwitchAllowed(ProxyViewModel proxyViewModel, ContinuationImpl continuationImpl) {
        ProxyViewModel$queryModeSwitchAllowed$1 proxyViewModel$queryModeSwitchAllowed$1;
        Object failure;
        if (continuationImpl instanceof ProxyViewModel$queryModeSwitchAllowed$1) {
            proxyViewModel$queryModeSwitchAllowed$1 = (ProxyViewModel$queryModeSwitchAllowed$1) continuationImpl;
            int i = proxyViewModel$queryModeSwitchAllowed$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                proxyViewModel$queryModeSwitchAllowed$1.label = i - Integer.MIN_VALUE;
            } else {
                proxyViewModel$queryModeSwitchAllowed$1 = new ProxyViewModel$queryModeSwitchAllowed$1(proxyViewModel, continuationImpl);
            }
        } else {
            proxyViewModel$queryModeSwitchAllowed$1 = new ProxyViewModel$queryModeSwitchAllowed$1(proxyViewModel, continuationImpl);
        }
        Object objWithProfile$default = proxyViewModel$queryModeSwitchAllowed$1.result;
        int i2 = proxyViewModel$queryModeSwitchAllowed$1.label;
        boolean z = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithProfile$default);
                ShareToTvActivity$onCreate$1$list$1$1 shareToTvActivity$onCreate$1$list$1$1 = new ShareToTvActivity$onCreate$1$list$1$1(2, z ? 1 : 0, 6);
                proxyViewModel$queryModeSwitchAllowed$1.label = 1;
                objWithProfile$default = RemoteKt.withProfile$default(shareToTvActivity$onCreate$1$list$1$1, proxyViewModel$queryModeSwitchAllowed$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithProfile$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithProfile$default);
            }
            failure = (Profile) objWithProfile$default;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        Profile profile = (Profile) (failure instanceof Result.Failure ? null : failure);
        return Boolean.valueOf(profile != null ? profile.modeSwitchAllowed : true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object access$reloadAllGroups(ProxyViewModel proxyViewModel, ContinuationImpl continuationImpl) throws Throwable {
        ProxyViewModel$reloadAllGroups$1 proxyViewModel$reloadAllGroups$1;
        MutexImpl mutexImpl;
        Mutex mutex;
        Mutex mutex2;
        MutableStateFlow mutableStateFlow;
        proxyViewModel.getClass();
        if (continuationImpl instanceof ProxyViewModel$reloadAllGroups$1) {
            proxyViewModel$reloadAllGroups$1 = (ProxyViewModel$reloadAllGroups$1) continuationImpl;
            int i = proxyViewModel$reloadAllGroups$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                proxyViewModel$reloadAllGroups$1.label = i - Integer.MIN_VALUE;
            } else {
                proxyViewModel$reloadAllGroups$1 = new ProxyViewModel$reloadAllGroups$1(proxyViewModel, continuationImpl);
            }
        } else {
            proxyViewModel$reloadAllGroups$1 = new ProxyViewModel$reloadAllGroups$1(proxyViewModel, continuationImpl);
        }
        Object obj = proxyViewModel$reloadAllGroups$1.result;
        int i2 = proxyViewModel$reloadAllGroups$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutexImpl = proxyViewModel.groupLoadLock;
                proxyViewModel$reloadAllGroups$1.L$0 = proxyViewModel;
                proxyViewModel$reloadAllGroups$1.L$1 = mutexImpl;
                proxyViewModel$reloadAllGroups$1.label = 1;
                if (mutexImpl.lock(proxyViewModel$reloadAllGroups$1) != coroutineSingletons) {
                }
                mutex = mutexImpl;
                return coroutineSingletons;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) proxyViewModel$reloadAllGroups$1.L$1;
                mutex2 = (Mutex) proxyViewModel$reloadAllGroups$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2 = mutex2;
                    ((StateFlowImpl) mutableStateFlow).setValue(obj);
                    Unit unit = Unit.INSTANCE;
                    ((MutexImpl) mutex2).unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    ((MutexImpl) mutex2).unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) proxyViewModel$reloadAllGroups$1.L$1;
            ProxyViewModel proxyViewModel2 = (ProxyViewModel) proxyViewModel$reloadAllGroups$1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            proxyViewModel = proxyViewModel2;
            mutex = mutexImpl;
            StateFlowImpl stateFlowImpl = proxyViewModel._groups;
            List list = (List) proxyViewModel._groupNames.getValue();
            proxyViewModel$reloadAllGroups$1.L$0 = mutex;
            proxyViewModel$reloadAllGroups$1.L$1 = stateFlowImpl;
            proxyViewModel$reloadAllGroups$1.label = 2;
            Object objLoadGroups = proxyViewModel.loadGroups(list, proxyViewModel$reloadAllGroups$1);
            if (objLoadGroups != coroutineSingletons) {
                mutex2 = mutex;
                obj = objLoadGroups;
                mutableStateFlow = stateFlowImpl;
                ((StateFlowImpl) mutableStateFlow).setValue(obj);
                Unit unit2 = Unit.INSTANCE;
                ((MutexImpl) mutex2).unlock(null);
                return Unit.INSTANCE;
            }
            mutex = mutexImpl;
            return coroutineSingletons;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            ((MutexImpl) mutex2).unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object access$reloadGroup(ProxyViewModel proxyViewModel, String str, ContinuationImpl continuationImpl) {
        ProxyViewModel$reloadGroup$1 proxyViewModel$reloadGroup$1;
        Object failure;
        Object value;
        Map mapSingletonMap;
        proxyViewModel.getClass();
        if (continuationImpl instanceof ProxyViewModel$reloadGroup$1) {
            proxyViewModel$reloadGroup$1 = (ProxyViewModel$reloadGroup$1) continuationImpl;
            int i = proxyViewModel$reloadGroup$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                proxyViewModel$reloadGroup$1.label = i - Integer.MIN_VALUE;
            } else {
                proxyViewModel$reloadGroup$1 = new ProxyViewModel$reloadGroup$1(proxyViewModel, continuationImpl);
            }
        } else {
            proxyViewModel$reloadGroup$1 = new ProxyViewModel$reloadGroup$1(proxyViewModel, continuationImpl);
        }
        Object objWithClash$default = proxyViewModel$reloadGroup$1.result;
        int i2 = proxyViewModel$reloadGroup$1.label;
        boolean z = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithClash$default);
                ProxyViewModel$loadGroups$2$1$1 proxyViewModel$loadGroups$2$1$1 = new ProxyViewModel$loadGroups$2$1$1(str, (ProxySort) proxyViewModel._proxySort.getValue(), z ? 1 : 0, 1);
                proxyViewModel$reloadGroup$1.L$0 = proxyViewModel;
                proxyViewModel$reloadGroup$1.L$1 = str;
                proxyViewModel$reloadGroup$1.label = 1;
                objWithClash$default = RemoteKt.withClash$default(proxyViewModel$loadGroups$2$1$1, proxyViewModel$reloadGroup$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithClash$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = proxyViewModel$reloadGroup$1.L$1;
                proxyViewModel = proxyViewModel$reloadGroup$1.L$0;
                ResultKt.throwOnFailure(objWithClash$default);
            }
            failure = (ProxyGroup) objWithClash$default;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        ProxyGroup proxyGroup = (ProxyGroup) (failure instanceof Result.Failure ? null : failure);
        if (proxyGroup == null) {
            return Unit.INSTANCE;
        }
        StateFlowImpl stateFlowImpl = proxyViewModel._groups;
        do {
            value = stateFlowImpl.getValue();
            Map map = (Map) value;
            if (map.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(str, proxyGroup);
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap(map);
                linkedHashMap.put(str, proxyGroup);
                mapSingletonMap = linkedHashMap;
            }
        } while (!stateFlowImpl.compareAndSet(value, mapSingletonMap));
        return Unit.INSTANCE;
    }

    public static String nodeKey(String str, String str2) {
        return ImageAnalysis$$ExternalSyntheticLambda1.m(str, "\n", str2);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x008c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008c -> B:30:0x008d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object loadGroups(java.util.List r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.github.kr328.clash.compose.proxy.ProxyViewModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$1 r0 = (com.github.kr328.clash.compose.proxy.ProxyViewModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$1 r0 = new com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r10 = r0.L$5
            java.util.Map r1 = r0.L$4
            java.util.Iterator r3 = r0.L$3
            java.util.Map r4 = r0.L$2
            com.github.kr328.clash.core.model.ProxySort r5 = r0.L$1
            com.github.kr328.clash.compose.proxy.ProxyViewModel r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L31
            goto L8d
        L31:
            r11 = move-exception
            goto L92
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.flow.StateFlowImpl r11 = r9._proxySort
            java.lang.Object r11 = r11.getValue()
            com.github.kr328.clash.core.model.ProxySort r11 = (com.github.kr328.clash.core.model.ProxySort) r11
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r10, r3)
            int r3 = kotlin.collections.MapsKt__MapsKt.mapCapacity(r3)
            r4 = 16
            if (r3 >= r4) goto L57
            r3 = r4
        L57:
            r1.<init>(r3)
            java.util.Iterator r10 = r10.iterator()
            r6 = r9
            r3 = r10
            r5 = r11
        L61:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto Lab
            java.lang.Object r10 = r3.next()
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$2$1$1 r4 = new com.github.kr328.clash.compose.proxy.ProxyViewModel$loadGroups$2$1$1     // Catch: java.lang.Throwable -> L90
            r7 = 0
            r8 = 0
            r4.<init>(r11, r5, r8, r7)     // Catch: java.lang.Throwable -> L90
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L90
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L90
            r0.L$2 = r1     // Catch: java.lang.Throwable -> L90
            r0.L$3 = r3     // Catch: java.lang.Throwable -> L90
            r0.L$4 = r1     // Catch: java.lang.Throwable -> L90
            r0.L$5 = r10     // Catch: java.lang.Throwable -> L90
            r0.label = r2     // Catch: java.lang.Throwable -> L90
            java.lang.Object r11 = com.github.kr328.clash.util.RemoteKt.withClash$default(r4, r0)     // Catch: java.lang.Throwable -> L90
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r11 != r4) goto L8c
            return r4
        L8c:
            r4 = r1
        L8d:
            com.github.kr328.clash.core.model.ProxyGroup r11 = (com.github.kr328.clash.core.model.ProxyGroup) r11     // Catch: java.lang.Throwable -> L31
            goto L98
        L90:
            r11 = move-exception
            r4 = r1
        L92:
            kotlin.Result$Failure r7 = new kotlin.Result$Failure
            r7.<init>(r11)
            r11 = r7
        L98:
            java.lang.Throwable r7 = kotlin.Result.m835exceptionOrNullimpl(r11)
            if (r7 != 0) goto L9f
            goto La4
        L9f:
            com.github.kr328.clash.core.model.ProxyGroup r11 = new com.github.kr328.clash.core.model.ProxyGroup
            r11.<init>()
        La4:
            com.github.kr328.clash.core.model.ProxyGroup r11 = (com.github.kr328.clash.core.model.ProxyGroup) r11
            r1.put(r10, r11)
            r1 = r4
            goto L61
        Lab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.compose.proxy.ProxyViewModel.loadGroups(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
