package androidx.transition;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionListenerAdapter implements Transition.TransitionListener {
    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd$1(Transition transition) {
        onTransitionEnd(transition);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart$1(Transition transition) {
        onTransitionStart(transition);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionPause() {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionResume() {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
    }
}
