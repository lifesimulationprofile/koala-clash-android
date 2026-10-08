package androidx.core.provider;

import android.util.Log;
import androidx.core.content.res.CamUtils;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.foreground.SystemForegroundService;
import coil.disk.RealDiskCache;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CallbackWrapper$2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object val$callback;
    public final int val$reason;

    public /* synthetic */ CallbackWrapper$2(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.val$callback = obj;
        this.val$reason = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                CamUtils camUtils = (CamUtils) ((RealDiskCache.RealEditor) this.val$callback).editor;
                if (camUtils != null) {
                    camUtils.onFontRetrievalFailed(this.val$reason);
                }
                break;
            case 1:
                ArrayList arrayList = (ArrayList) this.val$callback;
                int size = arrayList.size();
                int i = 0;
                if (this.val$reason == 1) {
                    while (i < size) {
                        ((EmojiCompat.InitCallback) arrayList.get(i)).onInitialized();
                        i++;
                    }
                } else {
                    while (i < size) {
                        ((EmojiCompat.InitCallback) arrayList.get(i)).onFailed();
                        i++;
                    }
                }
                break;
            case 2:
                ((SystemForegroundService) this.val$callback).mNotificationManager.cancel(this.val$reason);
                break;
            case 3:
                ((zabq) this.val$callback).zaI(this.val$reason);
                break;
            default:
                RecyclerView recyclerView = ((MaterialCalendar) this.val$callback).recyclerView;
                if (!recyclerView.mLayoutSuppressed) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
                    if (layoutManager != null) {
                        layoutManager.smoothScrollToPosition(recyclerView, this.val$reason);
                    } else {
                        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    }
                    break;
                }
                break;
        }
    }

    public CallbackWrapper$2(List list, int i, Throwable th) {
        this.$r8$classId = 1;
        Preconditions.checkNotNull(list, "initCallbacks cannot be null");
        this.val$callback = new ArrayList(list);
        this.val$reason = i;
    }
}
