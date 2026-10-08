package com.github.kr328.clash.compose.settings;

import androidx.compose.ui.Modifier;
import com.github.kr328.clash.service.model.AccessControlMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkSettingsState {
    public final AccessControlMode accessControlMode;
    public final boolean allowBypass;
    public final boolean allowIpv6;
    public final boolean bypassPrivateNetwork;
    public final boolean clashRunning;
    public final boolean dnsHijacking;
    public final boolean enableVpn;
    public final boolean systemProxy;
    public final String tunStackMode;

    public NetworkSettingsState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, AccessControlMode accessControlMode, boolean z7) {
        this.enableVpn = z;
        this.bypassPrivateNetwork = z2;
        this.dnsHijacking = z3;
        this.allowBypass = z4;
        this.allowIpv6 = z5;
        this.systemProxy = z6;
        this.tunStackMode = str;
        this.accessControlMode = accessControlMode;
        this.clashRunning = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkSettingsState)) {
            return false;
        }
        NetworkSettingsState networkSettingsState = (NetworkSettingsState) obj;
        return this.enableVpn == networkSettingsState.enableVpn && this.bypassPrivateNetwork == networkSettingsState.bypassPrivateNetwork && this.dnsHijacking == networkSettingsState.dnsHijacking && this.allowBypass == networkSettingsState.allowBypass && this.allowIpv6 == networkSettingsState.allowIpv6 && this.systemProxy == networkSettingsState.systemProxy && Intrinsics.areEqual(this.tunStackMode, networkSettingsState.tunStackMode) && this.accessControlMode == networkSettingsState.accessControlMode && this.clashRunning == networkSettingsState.clashRunning;
    }

    public final int hashCode() {
        return ((this.accessControlMode.hashCode() + Modifier.CC.m((((((((((((this.enableVpn ? 1231 : 1237) * 31) + (this.bypassPrivateNetwork ? 1231 : 1237)) * 31) + (this.dnsHijacking ? 1231 : 1237)) * 31) + (this.allowBypass ? 1231 : 1237)) * 31) + (this.allowIpv6 ? 1231 : 1237)) * 31) + (this.systemProxy ? 1231 : 1237)) * 31, 31, this.tunStackMode)) * 31) + (this.clashRunning ? 1231 : 1237);
    }

    public final String toString() {
        return "NetworkSettingsState(enableVpn=" + this.enableVpn + ", bypassPrivateNetwork=" + this.bypassPrivateNetwork + ", dnsHijacking=" + this.dnsHijacking + ", allowBypass=" + this.allowBypass + ", allowIpv6=" + this.allowIpv6 + ", systemProxy=" + this.systemProxy + ", tunStackMode=" + this.tunStackMode + ", accessControlMode=" + this.accessControlMode + ", clashRunning=" + this.clashRunning + ")";
    }
}
