package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import coil.ImageLoader$Builder;
import coil.memory.RealStrongMemoryCache;
import coil.request.RequestService;
import com.caverock.androidsvg.SVG;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public abstract WorkLauncherImpl dependencyDao();

    public abstract RealStrongMemoryCache preferenceDao();

    public abstract Request.Builder systemIdInfoDao();

    public abstract RequestService workNameDao();

    public abstract SVG workProgressDao();

    public abstract WorkSpecDao_Impl workSpecDao();

    public abstract ImageLoader$Builder workTagDao();
}
