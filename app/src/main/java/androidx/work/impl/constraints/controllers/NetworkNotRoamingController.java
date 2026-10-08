package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkNotRoamingController extends ConstraintController {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("NetworkNotRoamingCtrlr");

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final int getReason() {
        return 7;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.requiredNetworkType == 4;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        NetworkState networkState = (NetworkState) obj;
        boolean z = networkState.isConnected;
        if (Build.VERSION.SDK_INT >= 24) {
            return (z && networkState.isNotRoaming) ? false : true;
        }
        Logger$LogcatLogger.get().debug(TAG, "Not-roaming network constraint is not supported before API 24, only checking for connected state.");
        return !z;
    }
}
