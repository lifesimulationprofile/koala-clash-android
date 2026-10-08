package androidx.camera.core.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class QuirkSettings {
    public final boolean mEnabledWhenDeviceHasQuirk;
    public final Set mForceDisabledQuirks;
    public final Set mForceEnabledQuirks;

    public QuirkSettings(boolean z, HashSet hashSet, HashSet hashSet2) {
        this.mEnabledWhenDeviceHasQuirk = z;
        this.mForceEnabledQuirks = hashSet == null ? Collections.EMPTY_SET : new HashSet(hashSet);
        this.mForceDisabledQuirks = hashSet2 == null ? Collections.EMPTY_SET : new HashSet(hashSet2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof QuirkSettings)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        QuirkSettings quirkSettings = (QuirkSettings) obj;
        return this.mEnabledWhenDeviceHasQuirk == quirkSettings.mEnabledWhenDeviceHasQuirk && Objects.equals(this.mForceEnabledQuirks, quirkSettings.mForceEnabledQuirks) && Objects.equals(this.mForceDisabledQuirks, quirkSettings.mForceDisabledQuirks);
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.mEnabledWhenDeviceHasQuirk), this.mForceEnabledQuirks, this.mForceDisabledQuirks);
    }

    public final boolean shouldEnableQuirk(Class cls, boolean z) {
        if (this.mForceEnabledQuirks.contains(cls)) {
            return true;
        }
        return !this.mForceDisabledQuirks.contains(cls) && this.mEnabledWhenDeviceHasQuirk && z;
    }

    public final String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.mEnabledWhenDeviceHasQuirk + ", forceEnabledQuirks=" + this.mForceEnabledQuirks + ", forceDisabledQuirks=" + this.mForceDisabledQuirks + '}';
    }
}
