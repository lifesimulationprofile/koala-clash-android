package kotlin.text;

import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class HexFormat {
    public static final HexFormat Default = new HexFormat(BytesHexFormat.Default, NumberHexFormat.Default);
    public final BytesHexFormat bytes;
    public final NumberHexFormat number;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class BytesHexFormat {
        public static final BytesHexFormat Default;

        static {
            BytesHexFormat bytesHexFormat = new BytesHexFormat();
            if (!HexFormatKt.access$isCaseSensitive("  ") && !HexFormatKt.access$isCaseSensitive("") && !HexFormatKt.access$isCaseSensitive("")) {
                HexFormatKt.access$isCaseSensitive("");
            }
            Default = bytesHexFormat;
        }

        public final void appendOptionsTo$kotlin_stdlib(StringBuilder sb, String str) {
            sb.append(str);
            sb.append("bytesPerLine = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append('\n');
            sb.append(str);
            sb.append("bytesPerGroup = ");
            sb.append(Integer.MAX_VALUE);
            sb.append(",");
            sb.append('\n');
            sb.append(str);
            sb.append("groupSeparator = \"");
            sb.append("  ");
            sb.append("\",");
            sb.append('\n');
            sb.append(str);
            sb.append("byteSeparator = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            Density.CC.m(sb, str, "bytePrefix = \"", "", "\",");
            sb.append('\n');
            sb.append(str);
            sb.append("byteSuffix = \"");
            sb.append("");
            sb.append("\"");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class NumberHexFormat {
        public static final NumberHexFormat Default = new NumberHexFormat();
        public final boolean isDigitsOnly = true;

        public NumberHexFormat() {
            if (HexFormatKt.access$isCaseSensitive("")) {
                return;
            }
            HexFormatKt.access$isCaseSensitive("");
        }

        public final void appendOptionsTo$kotlin_stdlib(StringBuilder sb, String str) {
            Density.CC.m(sb, str, "prefix = \"", "", "\",");
            sb.append('\n');
            sb.append(str);
            sb.append("suffix = \"");
            sb.append("");
            sb.append("\",");
            sb.append('\n');
            sb.append(str);
            sb.append("removeLeadingZeros = ");
            sb.append(false);
            sb.append(',');
            sb.append('\n');
            sb.append(str);
            sb.append("minLength = ");
            sb.append(1);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sb, "    ");
            sb.append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    public HexFormat(BytesHexFormat bytesHexFormat, NumberHexFormat numberHexFormat) {
        this.bytes = bytesHexFormat;
        this.number = numberHexFormat;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(\n    upperCase = false,\n    bytes = BytesHexFormat(\n");
        this.bytes.appendOptionsTo$kotlin_stdlib(sb, "        ");
        sb.append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(sb, "        ");
        sb.append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
