package androidx.work.impl.constraints;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintsState {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ConstraintsNotMet extends ConstraintsState {
        public final int reason;

        public ConstraintsNotMet(int i) {
            this.reason = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int hashCode() {
            return this.reason;
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("ConstraintsNotMet(reason="), this.reason, ')');
        }
    }
}
