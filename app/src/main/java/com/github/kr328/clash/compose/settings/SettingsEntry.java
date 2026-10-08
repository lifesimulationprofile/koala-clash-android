package com.github.kr328.clash.compose.settings;

import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsEntry {
    public final ImageVector icon;
    public final int labelRes;
    public final Function0 onClick;

    public SettingsEntry(ImageVector imageVector, int i, Function0 function0) {
        this.icon = imageVector;
        this.labelRes = i;
        this.onClick = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsEntry)) {
            return false;
        }
        SettingsEntry settingsEntry = (SettingsEntry) obj;
        return this.icon.equals(settingsEntry.icon) && this.labelRes == settingsEntry.labelRes && Intrinsics.areEqual(this.onClick, settingsEntry.onClick);
    }

    public final int hashCode() {
        return this.onClick.hashCode() + (((this.icon.hashCode() * 31) + this.labelRes) * 31);
    }

    public final String toString() {
        return "SettingsEntry(icon=" + this.icon + ", labelRes=" + this.labelRes + ", onClick=" + this.onClick + ")";
    }
}
