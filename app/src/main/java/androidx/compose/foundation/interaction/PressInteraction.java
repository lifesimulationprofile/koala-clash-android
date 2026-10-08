package androidx.compose.foundation.interaction;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Cancel implements PressInteraction {
        public final Press press;

        public Cancel(Press press) {
            this.press = press;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Press implements PressInteraction {
        public final long pressPosition;

        public Press(long j) {
            this.pressPosition = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Release implements PressInteraction {
        public final Press press;

        public Release(Press press) {
            this.press = press;
        }
    }
}
