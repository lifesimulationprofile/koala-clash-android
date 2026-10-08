package com.github.kr328.clash.compose.profiles;

import com.github.kr328.clash.service.model.Profile;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesViewModel$refreshProfiles$1$invokeSuspend$$inlined$sortedBy$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((Profile) obj).updatedAt), Long.valueOf(((Profile) obj2).updatedAt));
    }
}
