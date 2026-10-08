package androidx.compose.foundation.text.selection;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectedTextType {
    public static final /* synthetic */ SelectedTextType[] $VALUES;
    public static final SelectedTextType EditableText;
    public static final SelectedTextType StaticText;

    static {
        SelectedTextType selectedTextType = new SelectedTextType("EditableText", 0);
        EditableText = selectedTextType;
        SelectedTextType selectedTextType2 = new SelectedTextType("StaticText", 1);
        StaticText = selectedTextType2;
        $VALUES = new SelectedTextType[]{selectedTextType, selectedTextType2};
    }

    public static SelectedTextType valueOf(String str) {
        return (SelectedTextType) Enum.valueOf(SelectedTextType.class, str);
    }

    public static SelectedTextType[] values() {
        return (SelectedTextType[]) $VALUES.clone();
    }
}
