package androidx.fragment.app.strictmode;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStrictMode {
    public static final Policy defaultPolicy = Policy.LAX;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Policy {
        public static final Policy LAX;

        static {
            Policy policy = new Policy();
            new LinkedHashMap();
            LAX = policy;
        }
    }

    public static Policy getNearestPolicy(Fragment fragment) {
        while (fragment != null) {
            if (fragment.mHost != null && fragment.mAdded) {
                fragment.getParentFragmentManager();
            }
            fragment = fragment.mParentFragment;
        }
        return defaultPolicy;
    }

    public static void logIfDebuggingEnabled(FragmentReuseViolation fragmentReuseViolation) {
        if (FragmentManagerImpl.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(fragmentReuseViolation.fragment.getClass().getName()), fragmentReuseViolation);
        }
    }

    public static final void onFragmentReuse(Fragment fragment, String str) {
        logIfDebuggingEnabled(new FragmentReuseViolation(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str));
        getNearestPolicy(fragment).getClass();
    }
}
