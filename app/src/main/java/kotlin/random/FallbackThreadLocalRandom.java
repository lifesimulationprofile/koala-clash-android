package kotlin.random;

import com.google.android.gms.dynamite.zzd;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final zzd implStorage = new zzd(3);

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        return (java.util.Random) this.implStorage.get();
    }
}
