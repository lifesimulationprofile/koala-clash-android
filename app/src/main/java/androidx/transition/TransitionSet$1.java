package androidx.transition;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionSet$1 extends TransitionListenerAdapter {
    public final /* synthetic */ int $r8$classId = 1;
    public Transition val$nextTransition;

    public /* synthetic */ TransitionSet$1() {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        switch (this.$r8$classId) {
            case 0:
                this.val$nextTransition.runAnimators();
                transition.removeListener(this);
                break;
            default:
                AutoTransition autoTransition = (AutoTransition) this.val$nextTransition;
                int i = autoTransition.mCurrentListeners - 1;
                autoTransition.mCurrentListeners = i;
                if (i == 0) {
                    autoTransition.mStarted = false;
                    autoTransition.end();
                }
                transition.removeListener(this);
                break;
        }
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        switch (this.$r8$classId) {
            case 1:
                AutoTransition autoTransition = (AutoTransition) this.val$nextTransition;
                if (!autoTransition.mStarted) {
                    autoTransition.start();
                    autoTransition.mStarted = true;
                }
                break;
        }
    }

    public TransitionSet$1(Transition transition) {
        this.val$nextTransition = transition;
    }
}
