package com.caverock.androidsvg;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PreserveAspectRatio {
    public final Alignment alignment;
    public final int scale;
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.none, 0);
    public static final PreserveAspectRatio LETTERBOX = new PreserveAspectRatio(Alignment.xMidYMid, 1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Alignment {
        public static final /* synthetic */ Alignment[] $VALUES;
        public static final Alignment none;
        public static final Alignment xMaxYMax;
        public static final Alignment xMaxYMid;
        public static final Alignment xMaxYMin;
        public static final Alignment xMidYMax;
        public static final Alignment xMidYMid;
        public static final Alignment xMidYMin;
        public static final Alignment xMinYMax;
        public static final Alignment xMinYMid;
        public static final Alignment xMinYMin;

        static {
            Alignment alignment = new Alignment("none", 0);
            none = alignment;
            Alignment alignment2 = new Alignment("xMinYMin", 1);
            xMinYMin = alignment2;
            Alignment alignment3 = new Alignment("xMidYMin", 2);
            xMidYMin = alignment3;
            Alignment alignment4 = new Alignment("xMaxYMin", 3);
            xMaxYMin = alignment4;
            Alignment alignment5 = new Alignment("xMinYMid", 4);
            xMinYMid = alignment5;
            Alignment alignment6 = new Alignment("xMidYMid", 5);
            xMidYMid = alignment6;
            Alignment alignment7 = new Alignment("xMaxYMid", 6);
            xMaxYMid = alignment7;
            Alignment alignment8 = new Alignment("xMinYMax", 7);
            xMinYMax = alignment8;
            Alignment alignment9 = new Alignment("xMidYMax", 8);
            xMidYMax = alignment9;
            Alignment alignment10 = new Alignment("xMaxYMax", 9);
            xMaxYMax = alignment10;
            $VALUES = new Alignment[]{alignment, alignment2, alignment3, alignment4, alignment5, alignment6, alignment7, alignment8, alignment9, alignment10};
        }

        public static Alignment valueOf(String str) {
            return (Alignment) Enum.valueOf(Alignment.class, str);
        }

        public static Alignment[] values() {
            return (Alignment[]) $VALUES.clone();
        }
    }

    public PreserveAspectRatio(Alignment alignment, int i) {
        this.alignment = alignment;
        this.scale = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreserveAspectRatio.class != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.alignment);
        sb.append(" ");
        int i = this.scale;
        if (i != 1) {
            str = i != 2 ? "null" : "slice";
        } else {
            str = "meet";
        }
        sb.append(str);
        return sb.toString();
    }
}
