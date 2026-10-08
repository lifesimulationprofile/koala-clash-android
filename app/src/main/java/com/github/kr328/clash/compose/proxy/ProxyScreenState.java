package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyScreenState {
    public final TunnelState.Mode configMode;
    public final TunnelState.Mode currentMode;
    public final String error;
    public final Set expandedGroups;
    public final List groupNames;
    public final Map groups;
    public final boolean isLoading;
    public final boolean modeSwitchAllowed;
    public final ProxySort sort;
    public final Set testedProxies;
    public final Set testingGroups;
    public final Set testingNodes;

    public ProxyScreenState(List list, Map map, Set set, TunnelState.Mode mode, TunnelState.Mode mode2, boolean z, ProxySort proxySort, boolean z2, Set set2, Set set3, Set set4, String str) {
        this.groupNames = list;
        this.groups = map;
        this.expandedGroups = set;
        this.currentMode = mode;
        this.configMode = mode2;
        this.modeSwitchAllowed = z;
        this.sort = proxySort;
        this.isLoading = z2;
        this.testingGroups = set2;
        this.testingNodes = set3;
        this.testedProxies = set4;
        this.error = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProxyScreenState)) {
            return false;
        }
        ProxyScreenState proxyScreenState = (ProxyScreenState) obj;
        return Intrinsics.areEqual(this.groupNames, proxyScreenState.groupNames) && Intrinsics.areEqual(this.groups, proxyScreenState.groups) && Intrinsics.areEqual(this.expandedGroups, proxyScreenState.expandedGroups) && this.currentMode == proxyScreenState.currentMode && this.configMode == proxyScreenState.configMode && this.modeSwitchAllowed == proxyScreenState.modeSwitchAllowed && this.sort == proxyScreenState.sort && this.isLoading == proxyScreenState.isLoading && Intrinsics.areEqual(this.testingGroups, proxyScreenState.testingGroups) && Intrinsics.areEqual(this.testingNodes, proxyScreenState.testingNodes) && Intrinsics.areEqual(this.testedProxies, proxyScreenState.testedProxies) && Intrinsics.areEqual(this.error, proxyScreenState.error);
    }

    public final int hashCode() {
        int iHashCode = (this.expandedGroups.hashCode() + ((this.groups.hashCode() + (this.groupNames.hashCode() * 31)) * 31)) * 31;
        TunnelState.Mode mode = this.currentMode;
        int iHashCode2 = (iHashCode + (mode == null ? 0 : mode.hashCode())) * 31;
        TunnelState.Mode mode2 = this.configMode;
        int iHashCode3 = (this.testedProxies.hashCode() + ((this.testingNodes.hashCode() + ((this.testingGroups.hashCode() + ((((this.sort.hashCode() + ((((iHashCode2 + (mode2 == null ? 0 : mode2.hashCode())) * 31) + (this.modeSwitchAllowed ? 1231 : 1237)) * 31)) * 31) + (this.isLoading ? 1231 : 1237)) * 31)) * 31)) * 31)) * 31;
        String str = this.error;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "ProxyScreenState(groupNames=" + this.groupNames + ", groups=" + this.groups + ", expandedGroups=" + this.expandedGroups + ", currentMode=" + this.currentMode + ", configMode=" + this.configMode + ", modeSwitchAllowed=" + this.modeSwitchAllowed + ", sort=" + this.sort + ", isLoading=" + this.isLoading + ", testingGroups=" + this.testingGroups + ", testingNodes=" + this.testingNodes + ", testedProxies=" + this.testedProxies + ", error=" + this.error + ")";
    }
}
