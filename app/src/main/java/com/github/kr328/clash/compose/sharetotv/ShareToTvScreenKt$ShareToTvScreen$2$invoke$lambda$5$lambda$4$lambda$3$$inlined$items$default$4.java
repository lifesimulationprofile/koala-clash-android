package com.github.kr328.clash.compose.sharetotv;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjw;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ShareToTvScreenKt$ShareToTvScreen$2$invoke$lambda$5$lambda$4$lambda$3$$inlined$items$default$4 implements Function4 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ Function1 $onSelect$inlined;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ShareToTvScreenKt$ShareToTvScreen$2$invoke$lambda$5$lambda$4$lambda$3$$inlined$items$default$4(int i, List list, Function1 function1) {
        this.$r8$classId = i;
        this.$items = list;
        this.$onSelect$inlined = function1;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                GapComposer gapComposer = (GapComposer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= gapComposer.changed(iIntValue) ? 32 : 16;
                }
                if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                    Profile profile = (Profile) this.$items.get(iIntValue);
                    gapComposer.startReplaceGroup(906780171);
                    gapComposer.startReplaceGroup(-1217671761);
                    Function1 function1 = this.$onSelect$inlined;
                    boolean zChanged = gapComposer.changed(function1) | gapComposer.changedInstance(profile);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1(function1, profile, 1);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    gapComposer.end(false);
                    zzjw.ProfileItem(profile, (Function0) objRememberedValue, gapComposer, 0);
                    gapComposer.end(false);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                if ((iIntValue4 & 6) == 0) {
                    i2 = (gapComposer2.changed(lazyItemScopeImpl2) ? 4 : 2) | iIntValue4;
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= gapComposer2.changed(iIntValue3) ? 32 : 16;
                }
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    ProcessGroup processGroup = (ProcessGroup) this.$items.get(iIntValue3);
                    gapComposer2.startReplaceGroup(-1370736733);
                    gapComposer2.startReplaceGroup(-2122426150);
                    Function1 function2 = this.$onSelect$inlined;
                    boolean zChanged2 = gapComposer2.changed(function2) | gapComposer2.changedInstance(processGroup);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer$Companion.Empty) {
                        objRememberedValue2 = new Http2Connection.ReaderRunnable(5, function2, processGroup);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.end(false);
                    ConnectionsScreenKt.ProcessCard(processGroup, (Function0) objRememberedValue2, gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
