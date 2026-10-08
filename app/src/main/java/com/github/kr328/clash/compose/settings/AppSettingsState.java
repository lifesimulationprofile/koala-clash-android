package com.github.kr328.clash.compose.settings;

import com.github.kr328.clash.design.model.DarkMode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppSettingsState {
    public final boolean autoCheckUpdate;
    public final boolean autoRestart;
    public final DarkMode darkMode;
    public final boolean dynamicNotification;
    public final boolean dynamicNotificationEnabled;
    public final boolean hideAppIcon;
    public final boolean hideFromRecents;

    public AppSettingsState(boolean z, DarkMode darkMode, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.autoRestart = z;
        this.darkMode = darkMode;
        this.hideAppIcon = z2;
        this.hideFromRecents = z3;
        this.dynamicNotification = z4;
        this.dynamicNotificationEnabled = z5;
        this.autoCheckUpdate = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSettingsState)) {
            return false;
        }
        AppSettingsState appSettingsState = (AppSettingsState) obj;
        return this.autoRestart == appSettingsState.autoRestart && this.darkMode == appSettingsState.darkMode && this.hideAppIcon == appSettingsState.hideAppIcon && this.hideFromRecents == appSettingsState.hideFromRecents && this.dynamicNotification == appSettingsState.dynamicNotification && this.dynamicNotificationEnabled == appSettingsState.dynamicNotificationEnabled && this.autoCheckUpdate == appSettingsState.autoCheckUpdate;
    }

    public final int hashCode() {
        return ((((((((((this.darkMode.hashCode() + ((this.autoRestart ? 1231 : 1237) * 31)) * 31) + (this.hideAppIcon ? 1231 : 1237)) * 31) + (this.hideFromRecents ? 1231 : 1237)) * 31) + (this.dynamicNotification ? 1231 : 1237)) * 31) + (this.dynamicNotificationEnabled ? 1231 : 1237)) * 31) + (this.autoCheckUpdate ? 1231 : 1237);
    }

    public final String toString() {
        return "AppSettingsState(autoRestart=" + this.autoRestart + ", darkMode=" + this.darkMode + ", hideAppIcon=" + this.hideAppIcon + ", hideFromRecents=" + this.hideFromRecents + ", dynamicNotification=" + this.dynamicNotification + ", dynamicNotificationEnabled=" + this.dynamicNotificationEnabled + ", autoCheckUpdate=" + this.autoCheckUpdate + ")";
    }
}
