package com.github.kr328.clash.service.remote;

import com.github.kr328.clash.service.model.Profile;
import java.util.UUID;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface IProfileManager {
    Object clone(UUID uuid, Continuation continuation);

    Object delete(UUID uuid, Continuation continuation);

    /* JADX INFO: renamed from: import */
    Object mo816import(Profile.Type type, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation);

    Object patch(UUID uuid, String str, String str2, long j, IFetchObserver iFetchObserver, Continuation continuation);

    Object queryActive(Continuation continuation);

    Object queryAll(Continuation continuation);

    Object queryByUUID(UUID uuid, Continuation continuation);

    Object setActive(Profile profile, Continuation continuation);

    Object update(UUID uuid, Continuation continuation);
}
