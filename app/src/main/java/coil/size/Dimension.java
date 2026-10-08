package coil.size;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Dimension {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Pixels extends Dimension {
        public final int px;

        public Pixels(int i) {
            this.px = i;
            if (i <= 0) {
                throw new IllegalArgumentException("px must be > 0.");
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pixels) {
                return this.px == ((Pixels) obj).px;
            }
            return false;
        }

        public final int hashCode() {
            return this.px;
        }

        public final String toString() {
            return String.valueOf(this.px);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Undefined extends Dimension {
        public static final Undefined INSTANCE = new Undefined();

        public final String toString() {
            return "Dimension.Undefined";
        }
    }
}
