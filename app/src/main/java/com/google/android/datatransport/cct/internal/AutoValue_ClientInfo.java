package com.google.android.datatransport.cct.internal;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_ClientInfo extends ClientInfo {
    public final AutoValue_AndroidClientInfo androidClientInfo;

    public AutoValue_ClientInfo(AutoValue_AndroidClientInfo autoValue_AndroidClientInfo) {
        this.androidClientInfo = autoValue_AndroidClientInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        Object obj2 = ClientInfo.ClientType.ANDROID_FIREBASE;
        if (obj2.equals(obj2)) {
            return this.androidClientInfo.equals(((AutoValue_ClientInfo) clientInfo).androidClientInfo);
        }
        return false;
    }

    public final int hashCode() {
        return ((ClientInfo.ClientType.ANDROID_FIREBASE.hashCode() ^ 1000003) * 1000003) ^ this.androidClientInfo.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + ClientInfo.ClientType.ANDROID_FIREBASE + ", androidClientInfo=" + this.androidClientInfo + "}";
    }
}
