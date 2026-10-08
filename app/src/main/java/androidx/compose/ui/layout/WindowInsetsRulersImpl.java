package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsRulersImpl implements WindowInsetsRulers {
    public final RectRulersImpl current;
    public final RectRulersImpl maximum;
    public final String name;

    public WindowInsetsRulersImpl(String str) {
        this.name = str;
        this.current = new RectRulersImpl(str);
        this.maximum = new RectRulersImpl(str.concat(" maximum"));
    }

    public final String toString() {
        return this.name;
    }
}
