package com.github.kr328.clash.remote;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface Broadcasts$Observer {
    void onProfileChanged();

    void onProfileLoaded();

    void onProfileUpdateCompleted(UUID uuid);

    void onProfileUpdateFailed(UUID uuid, String str);

    void onServiceRecreated();

    void onStarted();

    void onStopped();
}
