package androidx.navigationevent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventTransitionState {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Idle extends NavigationEventTransitionState {
        public static final Idle INSTANCE = new Idle();

        public final String toString() {
            return "Idle()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class InProgress extends NavigationEventTransitionState {
        public final NavigationEvent latestEvent;

        public InProgress(NavigationEvent navigationEvent) {
            this.latestEvent = navigationEvent;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && InProgress.class == obj.getClass() && Intrinsics.areEqual(this.latestEvent, ((InProgress) obj).latestEvent);
        }

        public final int hashCode() {
            return this.latestEvent.hashCode() - 31;
        }

        public final String toString() {
            return "InProgress(latestEvent=" + this.latestEvent + ", direction=-1)";
        }
    }
}
