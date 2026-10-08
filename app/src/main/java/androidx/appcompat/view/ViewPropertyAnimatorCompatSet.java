package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompatSet {
    public Interpolator mInterpolator;
    public boolean mIsStarted;
    public ViewPropertyAnimatorListener mListener;
    public long mDuration = -1;
    public final ToolbarWidgetWrapper.AnonymousClass2 mProxyListener = new ToolbarWidgetWrapper.AnonymousClass2(this);
    public final ArrayList mAnimators = new ArrayList();

    public final void cancel() {
        if (this.mIsStarted) {
            ArrayList arrayList = this.mAnimators;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((ViewPropertyAnimatorCompat) obj).cancel();
            }
            this.mIsStarted = false;
        }
    }

    public final void start() {
        View view;
        if (this.mIsStarted) {
            return;
        }
        ArrayList arrayList = this.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) obj;
            long j = this.mDuration;
            if (j >= 0) {
                viewPropertyAnimatorCompat.setDuration(j);
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null && (view = (View) viewPropertyAnimatorCompat.mView.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener(this.mProxyListener);
            }
            View view2 = (View) viewPropertyAnimatorCompat.mView.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.mIsStarted = true;
    }
}
