package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransaction$Op {
    public int mCmd;
    public Lifecycle.State mCurrentMaxState;
    public int mEnterAnim;
    public int mExitAnim;
    public Fragment mFragment;
    public boolean mFromExpandedOp = false;
    public Lifecycle.State mOldMaxState;
    public int mPopEnterAnim;
    public int mPopExitAnim;

    public FragmentTransaction$Op(int i, Fragment fragment) {
        this.mCmd = i;
        this.mFragment = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }

    public FragmentTransaction$Op(int i, Fragment fragment, int i2) {
        this.mCmd = i;
        this.mFragment = fragment;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }
}
