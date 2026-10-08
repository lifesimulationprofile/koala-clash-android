package com.github.kr328.clash.design.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class DarkMode {
    public static final /* synthetic */ DarkMode[] $VALUES;
    public static final DarkMode Auto;
    public static final DarkMode ForceDark;
    public static final DarkMode ForceLight;

    static {
        DarkMode darkMode = new DarkMode("Auto", 0);
        Auto = darkMode;
        DarkMode darkMode2 = new DarkMode("ForceLight", 1);
        ForceLight = darkMode2;
        DarkMode darkMode3 = new DarkMode("ForceDark", 2);
        ForceDark = darkMode3;
        $VALUES = new DarkMode[]{darkMode, darkMode2, darkMode3};
    }

    public static DarkMode valueOf(String str) {
        return (DarkMode) Enum.valueOf(DarkMode.class, str);
    }

    public static DarkMode[] values() {
        return (DarkMode[]) $VALUES.clone();
    }
}
