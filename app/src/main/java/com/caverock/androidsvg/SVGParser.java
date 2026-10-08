package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import com.github.kr328.clash.log.LogcatCache;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SVGParser {
    public SVG.SvgContainer currentElement;
    public int ignoreDepth;
    public boolean ignoring;
    public boolean inMetadataElement;
    public boolean inStyleElement;
    public StringBuilder metadataElementContents;
    public SVGElem metadataTag;
    public StringBuilder styleElementContents;
    public SVG svgDocument;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class AspectRatioKeywords {
        public static final HashMap aspectRatioKeywords;

        static {
            HashMap map = new HashMap(10);
            aspectRatioKeywords = map;
            map.put("none", PreserveAspectRatio.Alignment.none);
            map.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            map.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            map.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            map.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            map.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            map.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            map.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            map.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            map.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class ColourKeywords {
        public static final HashMap colourKeywords;

        static {
            HashMap map = new HashMap(47);
            colourKeywords = map;
            Density.CC.m(-984833, map, "aliceblue", -332841, "antiquewhite");
            map.put("aqua", -16711681);
            map.put("aquamarine", -8388652);
            Density.CC.m(-983041, map, "azure", -657956, "beige");
            Density.CC.m(-6972, map, "bisque", -16777216, "black");
            Density.CC.m(-5171, map, "blanchedalmond", -16776961, "blue");
            Density.CC.m(-7722014, map, "blueviolet", -5952982, "brown");
            Density.CC.m(-2180985, map, "burlywood", -10510688, "cadetblue");
            Density.CC.m(-8388864, map, "chartreuse", -2987746, "chocolate");
            Density.CC.m(-32944, map, "coral", -10185235, "cornflowerblue");
            Density.CC.m(-1828, map, "cornsilk", -2354116, "crimson");
            map.put("cyan", -16711681);
            map.put("darkblue", -16777077);
            Density.CC.m(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
            map.put("darkgray", -5658199);
            map.put("darkgreen", -16751616);
            map.put("darkgrey", -5658199);
            map.put("darkkhaki", -4343957);
            Density.CC.m(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
            Density.CC.m(-29696, map, "darkorange", -6737204, "darkorchid");
            Density.CC.m(-7667712, map, "darkred", -1468806, "darksalmon");
            Density.CC.m(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
            map.put("darkslategray", -13676721);
            map.put("darkslategrey", -13676721);
            map.put("darkturquoise", -16724271);
            map.put("darkviolet", -7077677);
            Density.CC.m(-60269, map, "deeppink", -16728065, "deepskyblue");
            map.put("dimgray", -9868951);
            map.put("dimgrey", -9868951);
            map.put("dodgerblue", -14774017);
            map.put("firebrick", -5103070);
            Density.CC.m(-1296, map, "floralwhite", -14513374, "forestgreen");
            map.put("fuchsia", -65281);
            map.put("gainsboro", -2302756);
            Density.CC.m(-460545, map, "ghostwhite", -10496, "gold");
            map.put("goldenrod", -2448096);
            map.put("gray", -8355712);
            Density.CC.m(-16744448, map, "green", -5374161, "greenyellow");
            map.put("grey", -8355712);
            map.put("honeydew", -983056);
            Density.CC.m(-38476, map, "hotpink", -3318692, "indianred");
            Density.CC.m(-11861886, map, "indigo", -16, "ivory");
            Density.CC.m(-989556, map, "khaki", -1644806, "lavender");
            Density.CC.m(-3851, map, "lavenderblush", -8586240, "lawngreen");
            Density.CC.m(-1331, map, "lemonchiffon", -5383962, "lightblue");
            Density.CC.m(-1015680, map, "lightcoral", -2031617, "lightcyan");
            map.put("lightgoldenrodyellow", -329006);
            map.put("lightgray", -2894893);
            map.put("lightgreen", -7278960);
            map.put("lightgrey", -2894893);
            Density.CC.m(-18751, map, "lightpink", -24454, "lightsalmon");
            Density.CC.m(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
            map.put("lightslategray", -8943463);
            map.put("lightslategrey", -8943463);
            map.put("lightsteelblue", -5192482);
            map.put("lightyellow", -32);
            Density.CC.m(-16711936, map, "lime", -13447886, "limegreen");
            map.put("linen", -331546);
            map.put("magenta", -65281);
            Density.CC.m(-8388608, map, "maroon", -10039894, "mediumaquamarine");
            Density.CC.m(-16777011, map, "mediumblue", -4565549, "mediumorchid");
            Density.CC.m(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
            Density.CC.m(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
            Density.CC.m(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
            Density.CC.m(-15132304, map, "midnightblue", -655366, "mintcream");
            Density.CC.m(-6943, map, "mistyrose", -6987, "moccasin");
            Density.CC.m(-8531, map, "navajowhite", -16777088, "navy");
            Density.CC.m(-133658, map, "oldlace", -8355840, "olive");
            Density.CC.m(-9728477, map, "olivedrab", -23296, "orange");
            Density.CC.m(-47872, map, "orangered", -2461482, "orchid");
            Density.CC.m(-1120086, map, "palegoldenrod", -6751336, "palegreen");
            Density.CC.m(-5247250, map, "paleturquoise", -2396013, "palevioletred");
            Density.CC.m(-4139, map, "papayawhip", -9543, "peachpuff");
            Density.CC.m(-3308225, map, "peru", -16181, "pink");
            Density.CC.m(-2252579, map, "plum", -5185306, "powderblue");
            Density.CC.m(-8388480, map, "purple", -10079335, "rebeccapurple");
            Density.CC.m(-65536, map, "red", -4419697, "rosybrown");
            Density.CC.m(-12490271, map, "royalblue", -7650029, "saddlebrown");
            Density.CC.m(-360334, map, "salmon", -744352, "sandybrown");
            Density.CC.m(-13726889, map, "seagreen", -2578, "seashell");
            Density.CC.m(-6270419, map, "sienna", -4144960, "silver");
            Density.CC.m(-7876885, map, "skyblue", -9807155, "slateblue");
            map.put("slategray", -9404272);
            map.put("slategrey", -9404272);
            map.put("snow", -1286);
            map.put("springgreen", -16711809);
            Density.CC.m(-12156236, map, "steelblue", -2968436, "tan");
            Density.CC.m(-16744320, map, "teal", -2572328, "thistle");
            Density.CC.m(-40121, map, "tomato", -12525360, "turquoise");
            Density.CC.m(-1146130, map, "violet", -663885, "wheat");
            Density.CC.m(-1, map, "white", -657931, "whitesmoke");
            Density.CC.m(-256, map, "yellow", -6632142, "yellowgreen");
            map.put("transparent", 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class FontSizeKeywords {
        public static final HashMap fontSizeKeywords;

        static {
            HashMap map = new HashMap(9);
            fontSizeKeywords = map;
            map.put("xx-small", new SVG.Length(7, 0.694f));
            map.put("x-small", new SVG.Length(7, 0.833f));
            map.put("small", new SVG.Length(7, 10.0f));
            map.put("medium", new SVG.Length(7, 12.0f));
            map.put("large", new SVG.Length(7, 14.4f));
            map.put("x-large", new SVG.Length(7, 17.3f));
            map.put("xx-large", new SVG.Length(7, 20.7f));
            map.put("smaller", new SVG.Length(9, 83.33f));
            map.put("larger", new SVG.Length(9, 120.0f));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class FontWeightKeywords {
        public static final HashMap fontWeightKeywords;

        static {
            HashMap map = new HashMap(13);
            fontWeightKeywords = map;
            map.put("normal", 400);
            map.put("bold", 700);
            Density.CC.m(1, map, "bolder", -1, "lighter");
            Density.CC.m(100, map, "100", 200, "200");
            map.put("300", 300);
            map.put("400", 400);
            Density.CC.m(500, map, "500", 600, "600");
            map.put("700", 700);
            map.put("800", 800);
            map.put("900", 900);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SAXHandler extends DefaultHandler2 {
        public SAXHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void characters(char[] cArr, int i, int i2) {
            SVGParser.this.text(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endDocument() {
            SVGParser.this.getClass();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void endElement(String str, String str2, String str3) {
            SVGParser.this.endElement(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void processingInstruction(String str, String str2) {
            SVGParser.parseProcessingInstructionAttributes(new LogcatCache(str2));
            str.equals("xml-stylesheet");
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startDocument() {
            SVGParser.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public final void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
            SVGParser.this.startElement(str, str2, str3, attributes);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SVGAttr {
        public static final /* synthetic */ SVGAttr[] $VALUES;
        public static final SVGAttr CLASS;
        public static final SVGAttr UNSUPPORTED;
        public static final HashMap cache;
        public static final SVGAttr points;
        public static final SVGAttr transform;

        static {
            SVGAttr sVGAttr = new SVGAttr("CLASS", 0);
            CLASS = sVGAttr;
            SVGAttr sVGAttr2 = new SVGAttr("clip", 1);
            SVGAttr sVGAttr3 = new SVGAttr("clip_path", 2);
            SVGAttr sVGAttr4 = new SVGAttr("clipPathUnits", 3);
            SVGAttr sVGAttr5 = new SVGAttr("clip_rule", 4);
            SVGAttr sVGAttr6 = new SVGAttr("color", 5);
            SVGAttr sVGAttr7 = new SVGAttr("cx", 6);
            SVGAttr sVGAttr8 = new SVGAttr("cy", 7);
            SVGAttr sVGAttr9 = new SVGAttr("direction", 8);
            SVGAttr sVGAttr10 = new SVGAttr("dx", 9);
            SVGAttr sVGAttr11 = new SVGAttr("dy", 10);
            SVGAttr sVGAttr12 = new SVGAttr("fx", 11);
            SVGAttr sVGAttr13 = new SVGAttr("fy", 12);
            SVGAttr sVGAttr14 = new SVGAttr("d", 13);
            SVGAttr sVGAttr15 = new SVGAttr("display", 14);
            SVGAttr sVGAttr16 = new SVGAttr("fill", 15);
            SVGAttr sVGAttr17 = new SVGAttr("fill_rule", 16);
            SVGAttr sVGAttr18 = new SVGAttr("fill_opacity", 17);
            SVGAttr sVGAttr19 = new SVGAttr("font", 18);
            SVGAttr sVGAttr20 = new SVGAttr("font_family", 19);
            SVGAttr sVGAttr21 = new SVGAttr("font_size", 20);
            SVGAttr sVGAttr22 = new SVGAttr("font_weight", 21);
            SVGAttr sVGAttr23 = new SVGAttr("font_style", 22);
            SVGAttr sVGAttr24 = new SVGAttr("gradientTransform", 23);
            SVGAttr sVGAttr25 = new SVGAttr("gradientUnits", 24);
            SVGAttr sVGAttr26 = new SVGAttr("height", 25);
            SVGAttr sVGAttr27 = new SVGAttr("href", 26);
            SVGAttr sVGAttr28 = new SVGAttr("image_rendering", 27);
            SVGAttr sVGAttr29 = new SVGAttr("marker", 28);
            SVGAttr sVGAttr30 = new SVGAttr("marker_start", 29);
            SVGAttr sVGAttr31 = new SVGAttr("marker_mid", 30);
            SVGAttr sVGAttr32 = new SVGAttr("marker_end", 31);
            SVGAttr sVGAttr33 = new SVGAttr("markerHeight", 32);
            SVGAttr sVGAttr34 = new SVGAttr("markerUnits", 33);
            SVGAttr sVGAttr35 = new SVGAttr("markerWidth", 34);
            SVGAttr sVGAttr36 = new SVGAttr("mask", 35);
            SVGAttr sVGAttr37 = new SVGAttr("maskContentUnits", 36);
            SVGAttr sVGAttr38 = new SVGAttr("maskUnits", 37);
            SVGAttr sVGAttr39 = new SVGAttr("media", 38);
            SVGAttr sVGAttr40 = new SVGAttr("offset", 39);
            SVGAttr sVGAttr41 = new SVGAttr("opacity", 40);
            SVGAttr sVGAttr42 = new SVGAttr("orient", 41);
            SVGAttr sVGAttr43 = new SVGAttr("overflow", 42);
            SVGAttr sVGAttr44 = new SVGAttr("pathLength", 43);
            SVGAttr sVGAttr45 = new SVGAttr("patternContentUnits", 44);
            SVGAttr sVGAttr46 = new SVGAttr("patternTransform", 45);
            SVGAttr sVGAttr47 = new SVGAttr("patternUnits", 46);
            SVGAttr sVGAttr48 = new SVGAttr("points", 47);
            points = sVGAttr48;
            SVGAttr sVGAttr49 = new SVGAttr("preserveAspectRatio", 48);
            SVGAttr sVGAttr50 = new SVGAttr("r", 49);
            SVGAttr sVGAttr51 = new SVGAttr("refX", 50);
            SVGAttr sVGAttr52 = new SVGAttr("refY", 51);
            SVGAttr sVGAttr53 = new SVGAttr("requiredFeatures", 52);
            SVGAttr sVGAttr54 = new SVGAttr("requiredExtensions", 53);
            SVGAttr sVGAttr55 = new SVGAttr("requiredFormats", 54);
            SVGAttr sVGAttr56 = new SVGAttr("requiredFonts", 55);
            SVGAttr sVGAttr57 = new SVGAttr("rx", 56);
            SVGAttr sVGAttr58 = new SVGAttr("ry", 57);
            SVGAttr sVGAttr59 = new SVGAttr("solid_color", 58);
            SVGAttr sVGAttr60 = new SVGAttr("solid_opacity", 59);
            SVGAttr sVGAttr61 = new SVGAttr("spreadMethod", 60);
            SVGAttr sVGAttr62 = new SVGAttr("startOffset", 61);
            SVGAttr sVGAttr63 = new SVGAttr("stop_color", 62);
            SVGAttr sVGAttr64 = new SVGAttr("stop_opacity", 63);
            SVGAttr sVGAttr65 = new SVGAttr("stroke", 64);
            SVGAttr sVGAttr66 = new SVGAttr("stroke_dasharray", 65);
            SVGAttr sVGAttr67 = new SVGAttr("stroke_dashoffset", 66);
            SVGAttr sVGAttr68 = new SVGAttr("stroke_linecap", 67);
            SVGAttr sVGAttr69 = new SVGAttr("stroke_linejoin", 68);
            SVGAttr sVGAttr70 = new SVGAttr("stroke_miterlimit", 69);
            SVGAttr sVGAttr71 = new SVGAttr("stroke_opacity", 70);
            SVGAttr sVGAttr72 = new SVGAttr("stroke_width", 71);
            SVGAttr sVGAttr73 = new SVGAttr("style", 72);
            SVGAttr sVGAttr74 = new SVGAttr("systemLanguage", 73);
            SVGAttr sVGAttr75 = new SVGAttr("text_anchor", 74);
            SVGAttr sVGAttr76 = new SVGAttr("text_decoration", 75);
            SVGAttr sVGAttr77 = new SVGAttr("transform", 76);
            transform = sVGAttr77;
            SVGAttr sVGAttr78 = new SVGAttr("type", 77);
            SVGAttr sVGAttr79 = new SVGAttr("vector_effect", 78);
            SVGAttr sVGAttr80 = new SVGAttr("version", 79);
            SVGAttr sVGAttr81 = new SVGAttr("viewBox", 80);
            SVGAttr sVGAttr82 = new SVGAttr("width", 81);
            SVGAttr sVGAttr83 = new SVGAttr("x", 82);
            SVGAttr sVGAttr84 = new SVGAttr("y", 83);
            SVGAttr sVGAttr85 = new SVGAttr("x1", 84);
            SVGAttr sVGAttr86 = new SVGAttr("y1", 85);
            SVGAttr sVGAttr87 = new SVGAttr("x2", 86);
            SVGAttr sVGAttr88 = new SVGAttr("y2", 87);
            SVGAttr sVGAttr89 = new SVGAttr("viewport_fill", 88);
            SVGAttr sVGAttr90 = new SVGAttr("viewport_fill_opacity", 89);
            SVGAttr sVGAttr91 = new SVGAttr("visibility", 90);
            SVGAttr sVGAttr92 = new SVGAttr("UNSUPPORTED", 91);
            UNSUPPORTED = sVGAttr92;
            $VALUES = new SVGAttr[]{sVGAttr, sVGAttr2, sVGAttr3, sVGAttr4, sVGAttr5, sVGAttr6, sVGAttr7, sVGAttr8, sVGAttr9, sVGAttr10, sVGAttr11, sVGAttr12, sVGAttr13, sVGAttr14, sVGAttr15, sVGAttr16, sVGAttr17, sVGAttr18, sVGAttr19, sVGAttr20, sVGAttr21, sVGAttr22, sVGAttr23, sVGAttr24, sVGAttr25, sVGAttr26, sVGAttr27, sVGAttr28, sVGAttr29, sVGAttr30, sVGAttr31, sVGAttr32, sVGAttr33, sVGAttr34, sVGAttr35, sVGAttr36, sVGAttr37, sVGAttr38, sVGAttr39, sVGAttr40, sVGAttr41, sVGAttr42, sVGAttr43, sVGAttr44, sVGAttr45, sVGAttr46, sVGAttr47, sVGAttr48, sVGAttr49, sVGAttr50, sVGAttr51, sVGAttr52, sVGAttr53, sVGAttr54, sVGAttr55, sVGAttr56, sVGAttr57, sVGAttr58, sVGAttr59, sVGAttr60, sVGAttr61, sVGAttr62, sVGAttr63, sVGAttr64, sVGAttr65, sVGAttr66, sVGAttr67, sVGAttr68, sVGAttr69, sVGAttr70, sVGAttr71, sVGAttr72, sVGAttr73, sVGAttr74, sVGAttr75, sVGAttr76, sVGAttr77, sVGAttr78, sVGAttr79, sVGAttr80, sVGAttr81, sVGAttr82, sVGAttr83, sVGAttr84, sVGAttr85, sVGAttr86, sVGAttr87, sVGAttr88, sVGAttr89, sVGAttr90, sVGAttr91, sVGAttr92};
            cache = new HashMap();
            for (SVGAttr sVGAttr93 : values()) {
                if (sVGAttr93 == CLASS) {
                    cache.put("class", sVGAttr93);
                } else {
                    if (sVGAttr93 != UNSUPPORTED) {
                        cache.put(sVGAttr93.name().replace('_', '-'), sVGAttr93);
                    }
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = (SVGAttr) cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }

        public static SVGAttr valueOf(String str) {
            return (SVGAttr) Enum.valueOf(SVGAttr.class, str);
        }

        public static SVGAttr[] values() {
            return (SVGAttr[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SVGElem {
        public static final /* synthetic */ SVGElem[] $VALUES;
        public static final SVGElem SWITCH;
        public static final SVGElem UNSUPPORTED;
        public static final HashMap cache;
        public static final SVGElem desc;
        public static final SVGElem title;

        /* JADX INFO: Fake field, exist only in values array */
        SVGElem EF0;

        static {
            SVGElem sVGElem = new SVGElem("svg", 0);
            SVGElem sVGElem2 = new SVGElem("a", 1);
            SVGElem sVGElem3 = new SVGElem("circle", 2);
            SVGElem sVGElem4 = new SVGElem("clipPath", 3);
            SVGElem sVGElem5 = new SVGElem("defs", 4);
            SVGElem sVGElem6 = new SVGElem("desc", 5);
            desc = sVGElem6;
            SVGElem sVGElem7 = new SVGElem("ellipse", 6);
            SVGElem sVGElem8 = new SVGElem("g", 7);
            SVGElem sVGElem9 = new SVGElem("image", 8);
            SVGElem sVGElem10 = new SVGElem("line", 9);
            SVGElem sVGElem11 = new SVGElem("linearGradient", 10);
            SVGElem sVGElem12 = new SVGElem("marker", 11);
            SVGElem sVGElem13 = new SVGElem("mask", 12);
            SVGElem sVGElem14 = new SVGElem("path", 13);
            SVGElem sVGElem15 = new SVGElem("pattern", 14);
            SVGElem sVGElem16 = new SVGElem("polygon", 15);
            SVGElem sVGElem17 = new SVGElem("polyline", 16);
            SVGElem sVGElem18 = new SVGElem("radialGradient", 17);
            SVGElem sVGElem19 = new SVGElem("rect", 18);
            SVGElem sVGElem20 = new SVGElem("solidColor", 19);
            SVGElem sVGElem21 = new SVGElem("stop", 20);
            SVGElem sVGElem22 = new SVGElem("style", 21);
            SVGElem sVGElem23 = new SVGElem("SWITCH", 22);
            SWITCH = sVGElem23;
            SVGElem sVGElem24 = new SVGElem("symbol", 23);
            SVGElem sVGElem25 = new SVGElem("text", 24);
            SVGElem sVGElem26 = new SVGElem("textPath", 25);
            SVGElem sVGElem27 = new SVGElem("title", 26);
            title = sVGElem27;
            SVGElem sVGElem28 = new SVGElem("tref", 27);
            SVGElem sVGElem29 = new SVGElem("tspan", 28);
            SVGElem sVGElem30 = new SVGElem("use", 29);
            SVGElem sVGElem31 = new SVGElem("view", 30);
            SVGElem sVGElem32 = new SVGElem("UNSUPPORTED", 31);
            UNSUPPORTED = sVGElem32;
            $VALUES = new SVGElem[]{sVGElem, sVGElem2, sVGElem3, sVGElem4, sVGElem5, sVGElem6, sVGElem7, sVGElem8, sVGElem9, sVGElem10, sVGElem11, sVGElem12, sVGElem13, sVGElem14, sVGElem15, sVGElem16, sVGElem17, sVGElem18, sVGElem19, sVGElem20, sVGElem21, sVGElem22, sVGElem23, sVGElem24, sVGElem25, sVGElem26, sVGElem27, sVGElem28, sVGElem29, sVGElem30, sVGElem31, sVGElem32};
            cache = new HashMap();
            for (SVGElem sVGElem33 : values()) {
                if (sVGElem33 == SWITCH) {
                    cache.put("switch", sVGElem33);
                } else if (sVGElem33 != UNSUPPORTED) {
                    cache.put(sVGElem33.name(), sVGElem33);
                }
            }
        }

        public static SVGElem valueOf(String str) {
            return (SVGElem) Enum.valueOf(SVGElem.class, str);
        }

        public static SVGElem[] values() {
            return (SVGElem[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class XPPAttributesWrapper implements Attributes {
        public XmlPullParser parser;

        @Override // org.xml.sax.Attributes
        public final int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public final int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public final String getLocalName(int i) {
            return this.parser.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public final String getQName(int i) {
            XmlPullParser xmlPullParser = this.parser;
            String attributeName = xmlPullParser.getAttributeName(i);
            if (xmlPullParser.getAttributePrefix(i) == null) {
                return attributeName;
            }
            return xmlPullParser.getAttributePrefix(i) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public final String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getURI(int i) {
            return this.parser.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public final String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(int i) {
            return this.parser.getAttributeValue(i);
        }
    }

    public static int clamp255(float f) {
        if (f < 0.0f) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    public static int hslToRgb(float f, float f2, float f3) {
        float f4 = 0.0f;
        float f5 = f % 360.0f;
        if (f < 0.0f) {
            f5 += 360.0f;
        }
        float f6 = f5 / 60.0f;
        float f7 = f2 / 100.0f;
        float f8 = f3 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f8 >= 0.0f) {
            f4 = f8 > 1.0f ? 1.0f : f8;
        }
        float f9 = f4 <= 0.5f ? (f7 + 1.0f) * f4 : (f4 + f7) - (f7 * f4);
        float f10 = (f4 * 2.0f) - f9;
        return clamp255(hueToRgb(f10, f9, f6 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f10, f9, f6 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f10, f9, f6) * 256.0f) << 8);
    }

    public static float hueToRgb(float f, float f2, float f3) {
        if (f3 < 0.0f) {
            f3 += 6.0f;
        }
        if (f3 >= 6.0f) {
            f3 -= 6.0f;
        }
        if (f3 < 1.0f) {
            return ImageAnalysis$$ExternalSyntheticLambda1.m(f2, f, f3, f);
        }
        if (f3 < 3.0f) {
            return f2;
        }
        return f3 < 4.0f ? ImageAnalysis$$ExternalSyntheticLambda1.m(4.0f, f3, f2 - f, f) : f;
    }

    public static void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int iM = Density.CC.m(attributes, i);
            if (iM != 73) {
                switch (iM) {
                    case 52:
                        LogcatCache logcatCache = new LogcatCache(strTrim);
                        HashSet hashSet = new HashSet();
                        while (!logcatCache.empty()) {
                            String strNextToken = logcatCache.nextToken();
                            if (strNextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                                hashSet.add(strNextToken.substring(35));
                            } else {
                                hashSet.add("UNSUPPORTED");
                            }
                            logcatCache.skipWhitespace();
                        }
                        svgConditional.setRequiredFeatures(hashSet);
                        break;
                    case 53:
                        svgConditional.setRequiredExtensions(strTrim);
                        break;
                    case 54:
                        LogcatCache logcatCache2 = new LogcatCache(strTrim);
                        HashSet hashSet2 = new HashSet();
                        while (!logcatCache2.empty()) {
                            hashSet2.add(logcatCache2.nextToken());
                            logcatCache2.skipWhitespace();
                        }
                        svgConditional.setRequiredFormats(hashSet2);
                        break;
                    case 55:
                        ArrayList fontFamily = parseFontFamily(strTrim);
                        svgConditional.setRequiredFonts(fontFamily != null ? new HashSet(fontFamily) : new HashSet(0));
                        break;
                }
            } else {
                LogcatCache logcatCache3 = new LogcatCache(strTrim);
                HashSet hashSet3 = new HashSet();
                while (!logcatCache3.empty()) {
                    String strNextToken2 = logcatCache3.nextToken();
                    int iIndexOf = strNextToken2.indexOf(45);
                    if (iIndexOf != -1) {
                        strNextToken2 = strNextToken2.substring(0, iIndexOf);
                    }
                    hashSet3.add(new Locale(strNextToken2, "", "").getLanguage());
                    logcatCache3.skipWhitespace();
                }
                svgConditional.setSystemLanguage(hashSet3);
            }
        }
    }

    public static void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.id = attributes.getValue(i).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String strTrim = attributes.getValue(i).trim();
                if ("default".equals(strTrim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if (!"preserve".equals(strTrim)) {
                        throw new SVGParseException(CaptureSession$State$EnumUnboxingLocalUtility.m("Invalid value for \"xml:space\" attribute: ", strTrim));
                    }
                    svgElementBase.spacePreserve = Boolean.TRUE;
                    return;
                }
            }
        }
    }

    public static void parseAttributesGradient(SVG.GradientElement gradientElement, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int iM = Density.CC.m(attributes, i);
            if (iM == 23) {
                gradientElement.gradientTransform = parseTransformList(strTrim);
            } else if (iM != 24) {
                if (iM != 26) {
                    if (iM != 60) {
                        continue;
                    } else {
                        try {
                            gradientElement.spreadMethod = Density.CC.valueOf(strTrim);
                        } catch (IllegalArgumentException unused) {
                            throw new SVGParseException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid spreadMethod attribute. \"", strTrim, "\" is not a valid value."));
                        }
                    }
                } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                    gradientElement.href = strTrim;
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                gradientElement.gradientUnitsAreUser = Boolean.FALSE;
            } else {
                if (!"userSpaceOnUse".equals(strTrim)) {
                    throw new SVGParseException("Invalid value for attribute gradientUnits");
                }
                gradientElement.gradientUnitsAreUser = Boolean.TRUE;
            }
        }
    }

    public static void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                LogcatCache logcatCache = new LogcatCache(attributes.getValue(i));
                ArrayList arrayList = new ArrayList();
                logcatCache.skipWhitespace();
                while (!logcatCache.empty()) {
                    float fNextFloat = logcatCache.nextFloat();
                    if (Float.isNaN(fNextFloat)) {
                        throw new SVGParseException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid <", str, "> points attribute. Non-coordinate content found in list."));
                    }
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat2 = logcatCache.nextFloat();
                    if (Float.isNaN(fNextFloat2)) {
                        throw new SVGParseException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid <", str, "> points attribute. There should be an even number of coordinates."));
                    }
                    logcatCache.skipCommaWhitespace();
                    arrayList.add(Float.valueOf(fNextFloat));
                    arrayList.add(Float.valueOf(fNextFloat2));
                }
                polyLine.points = new float[arrayList.size()];
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    polyLine.points[i2] = ((Float) obj).floatValue();
                    i2++;
                }
            }
        }
    }

    public static void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (strTrim.length() != 0) {
                int iM = Density.CC.m(attributes, i);
                if (iM == 0) {
                    CSSParser.CSSTextScanner cSSTextScanner = new CSSParser.CSSTextScanner(strTrim);
                    ArrayList arrayList = null;
                    while (!cSSTextScanner.empty()) {
                        String strNextToken = cSSTextScanner.nextToken();
                        if (strNextToken != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(strNextToken);
                            cSSTextScanner.skipWhitespace();
                        }
                    }
                    svgElementBase.classNames = arrayList;
                } else if (iM != 72) {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim());
                } else {
                    LogcatCache logcatCache = new LogcatCache(strTrim.replaceAll("/\\*.*?\\*/", ""));
                    while (true) {
                        String strNextToken2 = logcatCache.nextToken(':', false);
                        logcatCache.skipWhitespace();
                        if (!logcatCache.consume(':')) {
                            break;
                        }
                        logcatCache.skipWhitespace();
                        String strNextToken3 = logcatCache.nextToken(';', true);
                        if (strNextToken3 == null) {
                            break;
                        }
                        logcatCache.skipWhitespace();
                        if (logcatCache.empty() || logcatCache.consume(';')) {
                            if (svgElementBase.style == null) {
                                svgElementBase.style = new SVG.Style();
                            }
                            processStyleProperty(svgElementBase.style, strNextToken2, strNextToken3);
                            logcatCache.skipWhitespace();
                        }
                    }
                }
            }
        }
    }

    public static void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int iM = Density.CC.m(attributes, i);
            if (iM == 9) {
                textPositionedContainer.dx = parseLengthList(strTrim);
            } else if (iM == 10) {
                textPositionedContainer.dy = parseLengthList(strTrim);
            } else if (iM == 82) {
                textPositionedContainer.x = parseLengthList(strTrim);
            } else if (iM == 83) {
                textPositionedContainer.y = parseLengthList(strTrim);
            }
        }
    }

    public static void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    public static void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int iM = Density.CC.m(attributes, i);
            if (iM == 48) {
                parsePreserveAspectRatio(svgViewBoxContainer, strTrim);
            } else if (iM != 80) {
                continue;
            } else {
                LogcatCache logcatCache = new LogcatCache(strTrim);
                logcatCache.skipWhitespace();
                float fNextFloat = logcatCache.nextFloat();
                logcatCache.skipCommaWhitespace();
                float fNextFloat2 = logcatCache.nextFloat();
                logcatCache.skipCommaWhitespace();
                float fNextFloat3 = logcatCache.nextFloat();
                logcatCache.skipCommaWhitespace();
                float fNextFloat4 = logcatCache.nextFloat();
                if (Float.isNaN(fNextFloat) || Float.isNaN(fNextFloat2) || Float.isNaN(fNextFloat3) || Float.isNaN(fNextFloat4)) {
                    throw new SVGParseException("Invalid viewBox definition - should have four numbers");
                }
                if (fNextFloat3 < 0.0f) {
                    throw new SVGParseException("Invalid viewBox. width cannot be negative");
                }
                if (fNextFloat4 < 0.0f) {
                    throw new SVGParseException("Invalid viewBox. height cannot be negative");
                }
                svgViewBoxContainer.viewBox = new SVG.Box(fNextFloat, fNextFloat2, fNextFloat3, fNextFloat4);
            }
        }
    }

    public static SVG.Colour parseColour(String str) throws SVGParseException {
        long j;
        int i;
        if (str.charAt(0) == '#') {
            int length = str.length();
            IntegerParser integerParser = null;
            if (1 < length) {
                long j2 = 0;
                int i2 = 1;
                while (true) {
                    if (i2 < length) {
                        char cCharAt = str.charAt(i2);
                        if (cCharAt < '0' || cCharAt > '9') {
                            if (cCharAt >= 'A' && cCharAt <= 'F') {
                                j = j2 * 16;
                                i = cCharAt - 'A';
                            } else if (cCharAt >= 'a' && cCharAt <= 'f') {
                                j = j2 * 16;
                                i = cCharAt - 'a';
                            }
                            j2 = j + ((long) i) + 10;
                        } else {
                            j2 = (j2 * 16) + ((long) (cCharAt - '0'));
                        }
                        if (j2 <= 4294967295L) {
                            i2++;
                        }
                    }
                    if (i2 != 1) {
                        integerParser = new IntegerParser(i2, j2);
                    }
                }
            }
            if (integerParser == null) {
                throw new SVGParseException("Bad hex colour value: ".concat(str));
            }
            long j3 = integerParser.value;
            int i3 = integerParser.pos;
            if (i3 == 4) {
                int i4 = (int) j3;
                int i5 = i4 & 3840;
                int i6 = i4 & 240;
                int i7 = i4 & 15;
                return new SVG.Colour(i7 | (i5 << 8) | (-16777216) | (i5 << 12) | (i6 << 8) | (i6 << 4) | (i7 << 4));
            }
            if (i3 != 5) {
                if (i3 == 7) {
                    return new SVG.Colour(((int) j3) | (-16777216));
                }
                if (i3 != 9) {
                    throw new SVGParseException("Bad hex colour value: ".concat(str));
                }
                int i8 = (int) j3;
                return new SVG.Colour((i8 >>> 8) | (i8 << 24));
            }
            int i9 = (int) j3;
            int i10 = 61440 & i9;
            int i11 = i9 & 3840;
            int i12 = i9 & 240;
            int i13 = i9 & 15;
            return new SVG.Colour((i13 << 24) | (i13 << 28) | (i10 << 8) | (i10 << 4) | (i11 << 4) | i11 | i12 | (i12 >> 4));
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean zStartsWith = lowerCase.startsWith("rgba(");
        if (zStartsWith || lowerCase.startsWith("rgb(")) {
            LogcatCache logcatCache = new LogcatCache(str.substring(zStartsWith ? 5 : 4));
            logcatCache.skipWhitespace();
            float fNextFloat = logcatCache.nextFloat();
            if (!Float.isNaN(fNextFloat) && logcatCache.consume('%')) {
                fNextFloat = (fNextFloat * 256.0f) / 100.0f;
            }
            float fCheckedNextFloat = logcatCache.checkedNextFloat(fNextFloat);
            if (!Float.isNaN(fCheckedNextFloat) && logcatCache.consume('%')) {
                fCheckedNextFloat = (fCheckedNextFloat * 256.0f) / 100.0f;
            }
            float fCheckedNextFloat2 = logcatCache.checkedNextFloat(fCheckedNextFloat);
            if (!Float.isNaN(fCheckedNextFloat2) && logcatCache.consume('%')) {
                fCheckedNextFloat2 = (fCheckedNextFloat2 * 256.0f) / 100.0f;
            }
            if (!zStartsWith) {
                logcatCache.skipWhitespace();
                if (Float.isNaN(fCheckedNextFloat2) || !logcatCache.consume(')')) {
                    throw new SVGParseException("Bad rgb() colour value: ".concat(str));
                }
                return new SVG.Colour((clamp255(fNextFloat) << 16) | (-16777216) | (clamp255(fCheckedNextFloat) << 8) | clamp255(fCheckedNextFloat2));
            }
            float fCheckedNextFloat3 = logcatCache.checkedNextFloat(fCheckedNextFloat2);
            logcatCache.skipWhitespace();
            if (Float.isNaN(fCheckedNextFloat3) || !logcatCache.consume(')')) {
                throw new SVGParseException("Bad rgba() colour value: ".concat(str));
            }
            return new SVG.Colour((clamp255(fCheckedNextFloat3 * 256.0f) << 24) | (clamp255(fNextFloat) << 16) | (clamp255(fCheckedNextFloat) << 8) | clamp255(fCheckedNextFloat2));
        }
        boolean zStartsWith2 = lowerCase.startsWith("hsla(");
        if (!zStartsWith2 && !lowerCase.startsWith("hsl(")) {
            Integer num = (Integer) ColourKeywords.colourKeywords.get(lowerCase);
            if (num != null) {
                return new SVG.Colour(num.intValue());
            }
            throw new SVGParseException("Invalid colour keyword: ".concat(lowerCase));
        }
        LogcatCache logcatCache2 = new LogcatCache(str.substring(zStartsWith2 ? 5 : 4));
        logcatCache2.skipWhitespace();
        float fNextFloat2 = logcatCache2.nextFloat();
        float fCheckedNextFloat4 = logcatCache2.checkedNextFloat(fNextFloat2);
        if (!Float.isNaN(fCheckedNextFloat4)) {
            logcatCache2.consume('%');
        }
        float fCheckedNextFloat5 = logcatCache2.checkedNextFloat(fCheckedNextFloat4);
        if (!Float.isNaN(fCheckedNextFloat5)) {
            logcatCache2.consume('%');
        }
        if (!zStartsWith2) {
            logcatCache2.skipWhitespace();
            if (Float.isNaN(fCheckedNextFloat5) || !logcatCache2.consume(')')) {
                throw new SVGParseException("Bad hsl() colour value: ".concat(str));
            }
            return new SVG.Colour(hslToRgb(fNextFloat2, fCheckedNextFloat4, fCheckedNextFloat5) | (-16777216));
        }
        float fCheckedNextFloat6 = logcatCache2.checkedNextFloat(fCheckedNextFloat5);
        logcatCache2.skipWhitespace();
        if (Float.isNaN(fCheckedNextFloat6) || !logcatCache2.consume(')')) {
            throw new SVGParseException("Bad hsla() colour value: ".concat(str));
        }
        return new SVG.Colour((clamp255(fCheckedNextFloat6 * 256.0f) << 24) | hslToRgb(fNextFloat2, fCheckedNextFloat4, fCheckedNextFloat5));
    }

    public static float parseFloat(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return parseFloat(str, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    public static ArrayList parseFontFamily(String str) {
        LogcatCache logcatCache = new LogcatCache(str);
        ArrayList arrayList = null;
        do {
            String strNextQuotedString = logcatCache.nextQuotedString();
            if (strNextQuotedString == null) {
                strNextQuotedString = logcatCache.nextToken(',', true);
            }
            if (strNextQuotedString == null) {
                return arrayList;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextQuotedString);
            logcatCache.skipCommaWhitespace();
        } while (!logcatCache.empty());
        return arrayList;
    }

    public static String parseFunctionalIRI(String str) {
        if (!str.equals("none") && str.startsWith("url(")) {
            return str.endsWith(")") ? str.substring(4, str.length() - 1).trim() : str.substring(4).trim();
        }
        return null;
    }

    public static SVG.Length parseLength(String str) throws SVGParseException {
        int iValueOf$1;
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int length = str.length();
        char cCharAt = str.charAt(length - 1);
        if (cCharAt == '%') {
            length--;
            iValueOf$1 = 9;
        } else if (length > 2 && Character.isLetter(cCharAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                iValueOf$1 = Density.CC.valueOf$1(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SVGParseException("Invalid length unit specifier: ".concat(str));
            }
        } else {
            iValueOf$1 = 1;
        }
        try {
            return new SVG.Length(iValueOf$1, parseFloat(str, length));
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid length value: ".concat(str), e);
        }
    }

    public static ArrayList parseLengthList(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        LogcatCache logcatCache = new LogcatCache(str);
        logcatCache.skipWhitespace();
        while (!logcatCache.empty()) {
            float fNextFloat = logcatCache.nextFloat();
            if (Float.isNaN(fNextFloat)) {
                StringBuilder sb = new StringBuilder("Invalid length list value: ");
                String str2 = (String) logcatCache.array;
                int i = logcatCache.removed;
                while (!logcatCache.empty() && !LogcatCache.isWhitespace(str2.charAt(logcatCache.removed))) {
                    logcatCache.removed++;
                }
                String strSubstring = str2.substring(i, logcatCache.removed);
                logcatCache.removed = i;
                sb.append(strSubstring);
                throw new SVGParseException(sb.toString());
            }
            int iNextUnit = logcatCache.nextUnit();
            if (iNextUnit == 0) {
                iNextUnit = 1;
            }
            arrayList.add(new SVG.Length(iNextUnit, fNextFloat));
            logcatCache.skipCommaWhitespace();
        }
        return arrayList;
    }

    public static SVG.Length parseLengthOrAuto(LogcatCache logcatCache) {
        return logcatCache.consume("auto") ? new SVG.Length(0.0f) : logcatCache.nextLength();
    }

    public static Float parseOpacity(String str) {
        try {
            float f = parseFloat(str);
            float f2 = 0.0f;
            if (f < 0.0f) {
                f = f2;
            } else {
                f2 = 1.0f;
                if (f > 1.0f) {
                    f = f2;
                }
            }
            return Float.valueOf(f);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    public static SVG.SvgPaint parsePaintSpecifier(String str) {
        boolean zStartsWith = str.startsWith("url(");
        SVG.SvgPaint colour = SVG.Colour.TRANSPARENT;
        SVG.CurrentColor currentColor = SVG.CurrentColor.instance;
        SVG.SvgPaint svgPaint = null;
        if (!zStartsWith) {
            if (str.equals("none")) {
                return colour;
            }
            if (str.equals("currentColor")) {
                return currentColor;
            }
            try {
                return parseColour(str);
            } catch (SVGParseException unused) {
                return null;
            }
        }
        int iIndexOf = str.indexOf(")");
        if (iIndexOf == -1) {
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        String strTrim = str.substring(4, iIndexOf).trim();
        String strTrim2 = str.substring(iIndexOf + 1).trim();
        if (strTrim2.length() > 0) {
            if (!strTrim2.equals("none")) {
                if (strTrim2.equals("currentColor")) {
                    colour = currentColor;
                } else {
                    try {
                        colour = parseColour(strTrim2);
                    } catch (SVGParseException unused2) {
                        colour = null;
                    }
                }
            }
            svgPaint = colour;
        }
        return new SVG.PaintReference(strTrim, svgPaint);
    }

    public static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SVGParseException {
        int i;
        LogcatCache logcatCache = new LogcatCache(str);
        logcatCache.skipWhitespace();
        String strNextToken = logcatCache.nextToken();
        if ("defer".equals(strNextToken)) {
            logcatCache.skipWhitespace();
            strNextToken = logcatCache.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = (PreserveAspectRatio.Alignment) AspectRatioKeywords.aspectRatioKeywords.get(strNextToken);
        logcatCache.skipWhitespace();
        if (logcatCache.empty()) {
            i = 0;
        } else {
            String strNextToken2 = logcatCache.nextToken();
            strNextToken2.getClass();
            if (strNextToken2.equals("meet")) {
                i = 1;
            } else {
                if (!strNextToken2.equals("slice")) {
                    throw new SVGParseException("Invalid preserveAspectRatio definition: ".concat(str));
                }
                i = 2;
            }
        }
        svgPreserveAspectRatioContainer.preserveAspectRatio = new PreserveAspectRatio(alignment, i);
    }

    public static HashMap parseProcessingInstructionAttributes(LogcatCache logcatCache) {
        HashMap map = new HashMap();
        logcatCache.skipWhitespace();
        String strNextToken = logcatCache.nextToken('=', false);
        while (strNextToken != null) {
            logcatCache.consume('=');
            map.put(strNextToken, logcatCache.nextQuotedString());
            logcatCache.skipWhitespace();
            strNextToken = logcatCache.nextToken('=', false);
        }
        return map;
    }

    public static Matrix parseTransformList(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        LogcatCache logcatCache = new LogcatCache(str);
        logcatCache.skipWhitespace();
        while (!logcatCache.empty()) {
            String str2 = (String) logcatCache.array;
            String strSubstring = null;
            if (!logcatCache.empty()) {
                int i = logcatCache.removed;
                int iCharAt = str2.charAt(i);
                while (true) {
                    if ((iCharAt >= 97 && iCharAt <= 122) || (iCharAt >= 65 && iCharAt <= 90)) {
                        iCharAt = logcatCache.advanceChar();
                    }
                }
                int i2 = logcatCache.removed;
                while (LogcatCache.isWhitespace(iCharAt)) {
                    iCharAt = logcatCache.advanceChar();
                }
                if (iCharAt == 40) {
                    logcatCache.removed++;
                    strSubstring = str2.substring(i, i2);
                } else {
                    logcatCache.removed = i;
                }
            }
            if (strSubstring == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: ".concat(str));
            }
            switch (strSubstring) {
                case "matrix":
                    logcatCache.skipWhitespace();
                    float fNextFloat = logcatCache.nextFloat();
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat2 = logcatCache.nextFloat();
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat3 = logcatCache.nextFloat();
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat4 = logcatCache.nextFloat();
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat5 = logcatCache.nextFloat();
                    logcatCache.skipCommaWhitespace();
                    float fNextFloat6 = logcatCache.nextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat6) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{fNextFloat, fNextFloat3, fNextFloat5, fNextFloat2, fNextFloat4, fNextFloat6, 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                    break;
                    break;
                case "rotate":
                    logcatCache.skipWhitespace();
                    float fNextFloat7 = logcatCache.nextFloat();
                    float fPossibleNextFloat = logcatCache.possibleNextFloat();
                    float fPossibleNextFloat2 = logcatCache.possibleNextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat7) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    if (Float.isNaN(fPossibleNextFloat)) {
                        matrix.preRotate(fNextFloat7);
                    } else {
                        if (Float.isNaN(fPossibleNextFloat2)) {
                            throw new SVGParseException("Invalid transform list: ".concat(str));
                        }
                        matrix.preRotate(fNextFloat7, fPossibleNextFloat, fPossibleNextFloat2);
                    }
                    break;
                    break;
                case "scale":
                    logcatCache.skipWhitespace();
                    float fNextFloat8 = logcatCache.nextFloat();
                    float fPossibleNextFloat3 = logcatCache.possibleNextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat8) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    if (!Float.isNaN(fPossibleNextFloat3)) {
                        matrix.preScale(fNextFloat8, fPossibleNextFloat3);
                    } else {
                        matrix.preScale(fNextFloat8, fNextFloat8);
                    }
                    break;
                    break;
                case "skewX":
                    logcatCache.skipWhitespace();
                    float fNextFloat9 = logcatCache.nextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat9) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(fNextFloat9)), 0.0f);
                    break;
                    break;
                case "skewY":
                    logcatCache.skipWhitespace();
                    float fNextFloat10 = logcatCache.nextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat10) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(fNextFloat10)));
                    break;
                    break;
                case "translate":
                    logcatCache.skipWhitespace();
                    float fNextFloat11 = logcatCache.nextFloat();
                    float fPossibleNextFloat4 = logcatCache.possibleNextFloat();
                    logcatCache.skipWhitespace();
                    if (Float.isNaN(fNextFloat11) || !logcatCache.consume(')')) {
                        throw new SVGParseException("Invalid transform list: ".concat(str));
                    }
                    if (!Float.isNaN(fPossibleNextFloat4)) {
                        matrix.preTranslate(fNextFloat11, fPossibleNextFloat4);
                    } else {
                        matrix.preTranslate(fNextFloat11, 0.0f);
                    }
                    break;
                    break;
                default:
                    throw new SVGParseException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Invalid transform list fn: ", strSubstring, ")"));
            }
            if (logcatCache.empty()) {
                return matrix;
            }
            logcatCache.skipCommaWhitespace();
        }
        return matrix;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:150:0x0270  */
    /* JADX WARN: Code duplicated, block: B:174:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:235:0x037e  */
    /* JADX WARN: Code duplicated, block: B:310:0x0492  */
    /* JADX WARN: Code duplicated, block: B:343:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:388:0x058a  */
    public static void processStyleProperty(SVG.Style style, String str, String str2) {
        Boolean bool;
        int i;
        String strNextToken;
        SVG.Length length;
        String strSubstring;
        SVG.Length length2;
        int i2;
        int i3;
        SVG.Length lengthNextLength;
        SVG.Length[] lengthArr;
        int i4;
        int i5;
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        int iOrdinal = SVGAttr.fromString(str).ordinal();
        int i6 = 5;
        if (iOrdinal == 1) {
            Dispatcher dispatcher = null;
            if (!"auto".equals(str2) && str2.startsWith("rect(")) {
                LogcatCache logcatCache = new LogcatCache(str2.substring(5));
                logcatCache.skipWhitespace();
                SVG.Length lengthOrAuto = parseLengthOrAuto(logcatCache);
                logcatCache.skipCommaWhitespace();
                SVG.Length lengthOrAuto2 = parseLengthOrAuto(logcatCache);
                logcatCache.skipCommaWhitespace();
                SVG.Length lengthOrAuto3 = parseLengthOrAuto(logcatCache);
                logcatCache.skipCommaWhitespace();
                SVG.Length lengthOrAuto4 = parseLengthOrAuto(logcatCache);
                logcatCache.skipWhitespace();
                if (logcatCache.consume(')') || logcatCache.empty()) {
                    dispatcher = new Dispatcher();
                    dispatcher.executorServiceOrNull = lengthOrAuto;
                    dispatcher.readyAsyncCalls = lengthOrAuto2;
                    dispatcher.runningAsyncCalls = lengthOrAuto3;
                    dispatcher.runningSyncCalls = lengthOrAuto4;
                }
            }
            Dispatcher dispatcher2 = dispatcher;
            style.clip = dispatcher2;
            if (dispatcher2 != null) {
                style.specifiedFlags |= 1048576;
                return;
            }
            return;
        }
        if (iOrdinal == 2) {
            style.clipPath = parseFunctionalIRI(str2);
            style.specifiedFlags |= 268435456;
            return;
        }
        if (iOrdinal == 4) {
            style.clipRule = "nonzero".equals(str2) ? 1 : "evenodd".equals(str2) ? 2 : 0;
            style.specifiedFlags |= 536870912;
        }
        try {
            if (iOrdinal == 5) {
                style.color = parseColour(str2);
                style.specifiedFlags |= 4096;
                return;
            }
            if (iOrdinal == 8) {
                int i7 = str2.equals("ltr") ? 1 : !str2.equals("rtl") ? 0 : 2;
                style.direction = i7;
                if (i7 != 0) {
                    style.specifiedFlags |= 68719476736L;
                    return;
                }
                return;
            }
            if (iOrdinal == 35) {
                style.mask = parseFunctionalIRI(str2);
                style.specifiedFlags |= 1073741824;
                return;
            }
            if (iOrdinal == 40) {
                style.opacity = parseOpacity(str2);
                style.specifiedFlags |= 2048;
                return;
            }
            if (iOrdinal == 42) {
                switch (str2) {
                    case "hidden":
                    case "scroll":
                        bool = Boolean.FALSE;
                        break;
                    case "auto":
                    case "visible":
                        bool = Boolean.TRUE;
                        break;
                    default:
                        bool = null;
                        break;
                }
                style.overflow = bool;
                if (bool != null) {
                    style.specifiedFlags |= 524288;
                    return;
                }
                return;
            }
            if (iOrdinal == 78) {
                int i8 = str2.equals("none") ? 1 : !str2.equals("non-scaling-stroke") ? 0 : 2;
                style.vectorEffect = i8;
                if (i8 != 0) {
                    style.specifiedFlags |= 34359738368L;
                    return;
                }
                return;
            }
            SVG.CurrentColor currentColor = SVG.CurrentColor.instance;
            if (iOrdinal == 58) {
                if (str2.equals("currentColor")) {
                    style.solidColor = currentColor;
                } else {
                    try {
                        style.solidColor = parseColour(str2);
                    } catch (SVGParseException e) {
                        Log.w("SVGParser", e.getMessage());
                        return;
                    }
                }
                style.specifiedFlags |= 2147483648L;
                return;
            }
            if (iOrdinal == 59) {
                style.solidOpacity = parseOpacity(str2);
                style.specifiedFlags |= 4294967296L;
                return;
            }
            if (iOrdinal == 74) {
                switch (str2) {
                    case "middle":
                        i = 2;
                        break;
                    case "end":
                        i = 3;
                        break;
                    case "start":
                        i = 1;
                        break;
                    default:
                        i = 0;
                        break;
                }
                style.textAnchor = i;
                if (i != 0) {
                    style.specifiedFlags |= 262144;
                    return;
                }
                return;
            }
            if (iOrdinal == 75) {
                switch (str2) {
                    case "line-through":
                        i6 = 4;
                        break;
                    case "underline":
                        i6 = 2;
                        break;
                    case "none":
                        i6 = 1;
                        break;
                    case "blink":
                        break;
                    case "overline":
                        i6 = 3;
                        break;
                    default:
                        i6 = 0;
                        break;
                }
                style.textDecoration = i6;
                if (i6 != 0) {
                    style.specifiedFlags |= 131072;
                    return;
                }
                return;
            }
            switch (iOrdinal) {
                case 14:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + str2 + '|')) {
                            style.display = Boolean.valueOf(!str2.equals("none"));
                            style.specifiedFlags |= 16777216;
                            break;
                        }
                    }
                    break;
                case 15:
                    SVG.SvgPaint paintSpecifier = parsePaintSpecifier(str2);
                    style.fill = paintSpecifier;
                    if (paintSpecifier != null) {
                        style.specifiedFlags |= 1;
                    }
                    break;
                case 16:
                    int i9 = "nonzero".equals(str2) ? 1 : "evenodd".equals(str2) ? 2 : 0;
                    style.fillRule = i9;
                    if (i9 != 0) {
                        style.specifiedFlags |= 2;
                    }
                    break;
                case 17:
                    Float opacity = parseOpacity(str2);
                    style.fillOpacity = opacity;
                    if (opacity != null) {
                        style.specifiedFlags |= 4;
                    }
                    break;
                case 18:
                    if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains("|" + str2 + '|')) {
                        LogcatCache logcatCache2 = new LogcatCache(str2);
                        Integer num = null;
                        String str3 = null;
                        int i10 = 0;
                        while (true) {
                            strNextToken = logcatCache2.nextToken('/', false);
                            logcatCache2.skipWhitespace();
                            if (strNextToken == null) {
                                break;
                            } else if (num == null || i10 == 0) {
                                if (!strNextToken.equals("normal") && (num != null || (num = (Integer) FontWeightKeywords.fontWeightKeywords.get(strNextToken)) == null)) {
                                    if (i10 == 0) {
                                        switch (strNextToken) {
                                            case "oblique":
                                                i10 = 3;
                                                break;
                                            case "italic":
                                                i10 = 2;
                                                break;
                                            case "normal":
                                                i10 = 1;
                                                break;
                                            default:
                                                i10 = 0;
                                                break;
                                        }
                                        if (i10 != 0) {
                                            continue;
                                        }
                                    }
                                    if (str3 == null && strNextToken.equals("small-caps")) {
                                        str3 = strNextToken;
                                    }
                                }
                            }
                        }
                        try {
                            length = (SVG.Length) FontSizeKeywords.fontSizeKeywords.get(strNextToken);
                            if (length == null) {
                                length = parseLength(strNextToken);
                            }
                        } catch (SVGParseException unused) {
                            length = null;
                        }
                        if (logcatCache2.consume('/')) {
                            logcatCache2.skipWhitespace();
                            String strNextToken2 = logcatCache2.nextToken();
                            if (strNextToken2 != null) {
                                parseLength(strNextToken2);
                            }
                            logcatCache2.skipWhitespace();
                        }
                        if (logcatCache2.empty()) {
                            strSubstring = null;
                        } else {
                            int i11 = logcatCache2.removed;
                            logcatCache2.removed = logcatCache2.appended;
                            strSubstring = ((String) logcatCache2.array).substring(i11);
                        }
                        style.fontFamily = parseFontFamily(strSubstring);
                        style.fontSize = length;
                        style.fontWeight = Integer.valueOf(num == null ? 400 : num.intValue());
                        if (i10 == 0) {
                            i10 = 1;
                        }
                        style.fontStyle = i10;
                        style.specifiedFlags |= 122880;
                        break;
                    }
                    break;
                case 19:
                    ArrayList fontFamily = parseFontFamily(str2);
                    style.fontFamily = fontFamily;
                    if (fontFamily != null) {
                        style.specifiedFlags |= 8192;
                    }
                    break;
                case 20:
                    try {
                        SVG.Length length3 = (SVG.Length) FontSizeKeywords.fontSizeKeywords.get(str2);
                        length2 = length3 == null ? parseLength(str2) : length3;
                    } catch (SVGParseException unused2) {
                        length2 = null;
                    }
                    style.fontSize = length2;
                    if (length2 != null) {
                        style.specifiedFlags |= 16384;
                    }
                    break;
                case 21:
                    Integer num2 = (Integer) FontWeightKeywords.fontWeightKeywords.get(str2);
                    style.fontWeight = num2;
                    if (num2 != null) {
                        style.specifiedFlags |= 32768;
                    }
                    break;
                case 22:
                    switch (str2) {
                        case "oblique":
                            i2 = 3;
                            break;
                        case "italic":
                            i2 = 2;
                            break;
                        case "normal":
                            i2 = 1;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    style.fontStyle = i2;
                    if (i2 != 0) {
                        style.specifiedFlags |= 65536;
                    }
                    break;
                default:
                    switch (iOrdinal) {
                        case 27:
                            switch (str2) {
                                case "optimizeQuality":
                                    i3 = 2;
                                    break;
                                case "auto":
                                    i3 = 1;
                                    break;
                                case "optimizeSpeed":
                                    i3 = 3;
                                    break;
                                default:
                                    i3 = 0;
                                    break;
                            }
                            style.imageRendering = i3;
                            if (i3 != 0) {
                                style.specifiedFlags |= 137438953472L;
                            }
                            break;
                        case 28:
                            String functionalIRI = parseFunctionalIRI(str2);
                            style.markerStart = functionalIRI;
                            style.markerMid = functionalIRI;
                            style.markerEnd = functionalIRI;
                            style.specifiedFlags |= 14680064;
                            break;
                        case 29:
                            style.markerStart = parseFunctionalIRI(str2);
                            style.specifiedFlags |= 2097152;
                            break;
                        case 30:
                            style.markerMid = parseFunctionalIRI(str2);
                            style.specifiedFlags |= 4194304;
                            break;
                        case 31:
                            style.markerEnd = parseFunctionalIRI(str2);
                            style.specifiedFlags |= 8388608;
                            break;
                        default:
                            switch (iOrdinal) {
                                case 62:
                                    if (str2.equals("currentColor")) {
                                        style.stopColor = currentColor;
                                    } else {
                                        try {
                                            style.stopColor = parseColour(str2);
                                        } catch (SVGParseException e2) {
                                            Log.w("SVGParser", e2.getMessage());
                                            return;
                                        }
                                    }
                                    style.specifiedFlags |= 67108864;
                                    break;
                                case 63:
                                    style.stopOpacity = parseOpacity(str2);
                                    style.specifiedFlags |= 134217728;
                                    break;
                                case 64:
                                    SVG.SvgPaint paintSpecifier2 = parsePaintSpecifier(str2);
                                    style.stroke = paintSpecifier2;
                                    if (paintSpecifier2 != null) {
                                        style.specifiedFlags |= 8;
                                    }
                                    break;
                                case 65:
                                    if (!"none".equals(str2)) {
                                        LogcatCache logcatCache3 = new LogcatCache(str2);
                                        logcatCache3.skipWhitespace();
                                        if (logcatCache3.empty() || (lengthNextLength = logcatCache3.nextLength()) == null || lengthNextLength.isNegative()) {
                                            lengthArr = null;
                                        } else {
                                            float f = lengthNextLength.value;
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(lengthNextLength);
                                            while (true) {
                                                if (!logcatCache3.empty()) {
                                                    logcatCache3.skipCommaWhitespace();
                                                    SVG.Length lengthNextLength2 = logcatCache3.nextLength();
                                                    if (lengthNextLength2 != null && !lengthNextLength2.isNegative()) {
                                                        arrayList.add(lengthNextLength2);
                                                        f += lengthNextLength2.value;
                                                    }
                                                } else if (f != 0.0f) {
                                                    lengthArr = (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
                                                }
                                                lengthArr = null;
                                            }
                                        }
                                        style.strokeDashArray = lengthArr;
                                        if (lengthArr != null) {
                                            style.specifiedFlags |= 512;
                                        }
                                    } else {
                                        style.strokeDashArray = null;
                                        style.specifiedFlags |= 512;
                                    }
                                    break;
                                case 66:
                                    style.strokeDashOffset = parseLength(str2);
                                    style.specifiedFlags |= 1024;
                                    break;
                                case 67:
                                    if ("butt".equals(str2)) {
                                        i4 = 1;
                                    } else if ("round".equals(str2)) {
                                        i4 = 2;
                                    } else {
                                        i4 = "square".equals(str2) ? 3 : 0;
                                    }
                                    style.strokeLineCap = i4;
                                    if (i4 != 0) {
                                        style.specifiedFlags |= 64;
                                    }
                                    break;
                                case 68:
                                    if ("miter".equals(str2)) {
                                        i5 = 1;
                                    } else if ("round".equals(str2)) {
                                        i5 = 2;
                                    } else {
                                        i5 = "bevel".equals(str2) ? 3 : 0;
                                    }
                                    style.strokeLineJoin = i5;
                                    if (i5 != 0) {
                                        style.specifiedFlags |= 128;
                                    }
                                    break;
                                case 69:
                                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                                    style.specifiedFlags |= 256;
                                    break;
                                case 70:
                                    Float opacity2 = parseOpacity(str2);
                                    style.strokeOpacity = opacity2;
                                    if (opacity2 != null) {
                                        style.specifiedFlags |= 16;
                                    }
                                    break;
                                case 71:
                                    style.strokeWidth = parseLength(str2);
                                    style.specifiedFlags |= 32;
                                    break;
                                default:
                                    switch (iOrdinal) {
                                        case 88:
                                            if (str2.equals("currentColor")) {
                                                style.viewportFill = currentColor;
                                            } else {
                                                try {
                                                    style.viewportFill = parseColour(str2);
                                                } catch (SVGParseException e3) {
                                                    Log.w("SVGParser", e3.getMessage());
                                                    return;
                                                }
                                            }
                                            style.specifiedFlags |= 8589934592L;
                                            break;
                                        case 89:
                                            style.viewportFillOpacity = parseOpacity(str2);
                                            style.specifiedFlags |= 17179869184L;
                                            break;
                                        case 90:
                                            if (str2.indexOf(124) < 0) {
                                                if ("|visible|hidden|collapse|".contains("|" + str2 + '|')) {
                                                    style.visibility = Boolean.valueOf(str2.equals("visible"));
                                                    style.specifiedFlags |= 33554432;
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } catch (SVGParseException unused3) {
        }
    }

    public final void appendToTextContainer(String str) {
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.children.size();
        SVG.SvgObject svgObject = size == 0 ? null : (SVG.SvgObject) svgConditionalContainer.children.get(size - 1);
        if (svgObject instanceof SVG.TextSequence) {
            SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
            textSequence.text = ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), textSequence.text, str);
        } else {
            SVG.SvgContainer svgContainer = this.currentElement;
            SVG.TextSequence textSequence2 = new SVG.TextSequence();
            textSequence2.text = str;
            svgContainer.addChild(textSequence2);
        }
    }

    public final void endElement(String str, String str2, String str3) {
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem sVGElem = (SVGElem) SVGElem.cache.get(str2);
            if (sVGElem == null) {
                sVGElem = SVGElem.UNSUPPORTED;
            }
            switch (sVGElem.ordinal()) {
                case 0:
                case 3:
                case 4:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 14:
                case 17:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                    this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
                    break;
                case 5:
                case 26:
                    this.inMetadataElement = false;
                    if (this.metadataElementContents != null) {
                        SVGElem sVGElem2 = this.metadataTag;
                        if (sVGElem2 == SVGElem.title || sVGElem2 == SVGElem.desc) {
                            this.svgDocument.getClass();
                        }
                        this.metadataElementContents.setLength(0);
                    }
                    break;
                case 21:
                    StringBuilder sb = this.styleElementContents;
                    if (sb != null) {
                        this.inStyleElement = false;
                        String string = sb.toString();
                        CSSParser cSSParser = new CSSParser();
                        cSSParser.inMediaRule = false;
                        cSSParser.deviceMediaType = CSSParser.MediaType.screen;
                        cSSParser.source = 1;
                        SVG svg = this.svgDocument;
                        CSSParser.CSSTextScanner cSSTextScanner = new CSSParser.CSSTextScanner(string);
                        cSSTextScanner.skipWhitespace();
                        ((ConnectionPool) svg.cssRules).addAll(cSSParser.parseRuleset(cSSTextScanner));
                        this.styleElementContents.setLength(0);
                    }
                    break;
            }
        }
    }

    public final void parseUsingSAX(InputStream inputStream) throws SVGParseException {
        Log.d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler();
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        }
    }

    public final void parseUsingXmlPullParser(InputStream inputStream) throws SVGParseException {
        try {
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper();
                xPPAttributesWrapper.parser = xmlPullParserNewPullParser;
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                xmlPullParserNewPullParser.setInput(inputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.nextToken()) {
                    if (eventType == 0) {
                        startDocument();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + xmlPullParserNewPullParser.getText());
                        LogcatCache logcatCache = new LogcatCache(xmlPullParserNewPullParser.getText());
                        String strNextToken = logcatCache.nextToken();
                        parseProcessingInstructionAttributes(logcatCache);
                        strNextToken.equals("xml-stylesheet");
                    } else if (eventType == 10) {
                        if (((SVG.Svg) this.svgDocument.rootElement) == null && xmlPullParserNewPullParser.getText().contains("<!ENTITY ")) {
                            try {
                                Log.d("SVGParser", "Switching to SAX parser to process entities");
                                inputStream.reset();
                                parseUsingSAX(inputStream);
                                return;
                            } catch (IOException unused) {
                                Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                return;
                            }
                        }
                    } else if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name = xmlPullParserNewPullParser.getPrefix() + ':' + name;
                        }
                        startElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name, xPPAttributesWrapper);
                    } else if (eventType == 3) {
                        String name2 = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name2 = xmlPullParserNewPullParser.getPrefix() + ':' + name2;
                        }
                        endElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name2);
                    } else if (eventType == 4) {
                        int[] iArr = new int[2];
                        text(xmlPullParserNewPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                    } else if (eventType == 5) {
                        text(xmlPullParserNewPullParser.getText());
                    }
                }
            } catch (XmlPullParserException e) {
                throw new SVGParseException("XML parser problem", e);
            }
        } catch (IOException e2) {
            throw new SVGParseException("Stream error", e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0312  */
    /* JADX WARN: Code duplicated, block: B:118:0x0319  */
    /* JADX WARN: Code duplicated, block: B:151:0x0357 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0339 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public final void path(Attributes attributes) throws SVGParseException {
        int iIntValue;
        char c;
        float fNextFloat;
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        char cCharAt;
        Attributes attributes2 = attributes;
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Path path = new SVG.Path();
        path.document = this.svgDocument;
        path.parent = svgContainer;
        parseAttributesCore(path, attributes2);
        parseAttributesStyle(path, attributes2);
        parseAttributesTransform(path, attributes2);
        parseAttributesConditional(path, attributes2);
        int i2 = 0;
        int i3 = 0;
        while (i3 < attributes2.getLength()) {
            String strTrim = attributes2.getValue(i3).trim();
            int iM = Density.CC.m(attributes2, i3);
            float f5 = 0.0f;
            if (iM == 13) {
                LogcatCache logcatCache = new LogcatCache(strTrim);
                LogcatCache logcatCache2 = new LogcatCache(3);
                logcatCache2.removed = i2;
                logcatCache2.appended = i2;
                logcatCache2.array = new byte[8];
                logcatCache2.lock = new float[16];
                if (!logcatCache.empty() && ((iIntValue = logcatCache.nextChar().intValue()) == 77 || iIntValue == 109)) {
                    float f6 = 0.0f;
                    float f7 = 0.0f;
                    float f8 = 0.0f;
                    float f9 = 0.0f;
                    float f10 = 0.0f;
                    float f11 = 0.0f;
                    while (true) {
                        logcatCache.skipWhitespace();
                        float f12 = f5;
                        switch (iIntValue) {
                            case 65:
                            case 97:
                                c = 'm';
                                float fNextFloat2 = logcatCache.nextFloat();
                                float fCheckedNextFloat = logcatCache.checkedNextFloat(fNextFloat2);
                                float f13 = f8;
                                float fCheckedNextFloat2 = logcatCache.checkedNextFloat(fCheckedNextFloat);
                                Boolean boolCheckedNextFlag = logcatCache.checkedNextFlag(Float.valueOf(fCheckedNextFloat2));
                                Boolean boolCheckedNextFlag2 = logcatCache.checkedNextFlag(boolCheckedNextFlag);
                                if (boolCheckedNextFlag2 == null) {
                                    fNextFloat = Float.NaN;
                                } else {
                                    logcatCache.skipCommaWhitespace();
                                    fNextFloat = logcatCache.nextFloat();
                                }
                                i3 = i3;
                                float f14 = fNextFloat;
                                float fCheckedNextFloat3 = logcatCache.checkedNextFloat(f14);
                                if (!Float.isNaN(fCheckedNextFloat3) && fNextFloat2 >= f12 && fCheckedNextFloat >= f12) {
                                    if (iIntValue == 97) {
                                        f = f14 + f6;
                                        fCheckedNextFloat3 += f13;
                                    } else {
                                        f = f14;
                                    }
                                    boolean zBooleanValue = boolCheckedNextFlag.booleanValue();
                                    boolean zBooleanValue2 = boolCheckedNextFlag2.booleanValue();
                                    float f15 = f;
                                    logcatCache2.arcTo(fNextFloat2, fCheckedNextFloat, fCheckedNextFloat2, zBooleanValue, zBooleanValue2, f15, fCheckedNextFloat3);
                                    f6 = f15;
                                    f7 = f6;
                                    f8 = fCheckedNextFloat3;
                                    f9 = f8;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended && (((cCharAt = ((String) logcatCache.array).charAt(i)) >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                }
                                break;
                            case 67:
                            case 99:
                                float fNextFloat3 = logcatCache.nextFloat();
                                float fCheckedNextFloat4 = logcatCache.checkedNextFloat(fNextFloat3);
                                float fCheckedNextFloat5 = logcatCache.checkedNextFloat(fCheckedNextFloat4);
                                float fCheckedNextFloat6 = logcatCache.checkedNextFloat(fCheckedNextFloat5);
                                float fCheckedNextFloat7 = logcatCache.checkedNextFloat(fCheckedNextFloat6);
                                float fCheckedNextFloat8 = logcatCache.checkedNextFloat(fCheckedNextFloat7);
                                if (!Float.isNaN(fCheckedNextFloat8)) {
                                    if (iIntValue == 99) {
                                        fCheckedNextFloat7 += f6;
                                        fCheckedNextFloat8 += f8;
                                        fNextFloat3 += f6;
                                        fCheckedNextFloat4 += f8;
                                        fCheckedNextFloat5 += f6;
                                        fCheckedNextFloat6 += f8;
                                    }
                                    float f16 = fNextFloat3;
                                    f2 = fCheckedNextFloat5;
                                    f3 = fCheckedNextFloat8;
                                    c = 'm';
                                    f9 = fCheckedNextFloat6;
                                    float f17 = fCheckedNextFloat4;
                                    f4 = fCheckedNextFloat7;
                                    logcatCache2.cubicTo(f16, f17, f2, f9, f4, f3);
                                    f7 = f2;
                                    f6 = f4;
                                    f8 = f3;
                                    i3 = i3;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 72:
                            case 104:
                                float fNextFloat4 = logcatCache.nextFloat();
                                if (!Float.isNaN(fNextFloat4)) {
                                    if (iIntValue == 104) {
                                        fNextFloat4 += f6;
                                    }
                                    f6 = fNextFloat4;
                                    logcatCache2.lineTo(f6, f8);
                                    c = 'm';
                                    f7 = f6;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 76:
                            case 108:
                                float fNextFloat5 = logcatCache.nextFloat();
                                float fCheckedNextFloat9 = logcatCache.checkedNextFloat(fNextFloat5);
                                if (!Float.isNaN(fCheckedNextFloat9)) {
                                    if (iIntValue == 108) {
                                        fNextFloat5 += f6;
                                        fCheckedNextFloat9 += f8;
                                    }
                                    f6 = fNextFloat5;
                                    f8 = fCheckedNextFloat9;
                                    logcatCache2.lineTo(f6, f8);
                                    c = 'm';
                                    f9 = f8;
                                    f7 = f6;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 77:
                            case 109:
                                float fNextFloat6 = logcatCache.nextFloat();
                                float fCheckedNextFloat10 = logcatCache.checkedNextFloat(fNextFloat6);
                                if (!Float.isNaN(fCheckedNextFloat10)) {
                                    if (iIntValue == 109 && logcatCache2.removed != 0) {
                                        fNextFloat6 += f6;
                                        fCheckedNextFloat10 += f8;
                                    }
                                    f6 = fNextFloat6;
                                    f8 = fCheckedNextFloat10;
                                    logcatCache2.moveTo(f6, f8);
                                    i3 = i3;
                                    f10 = f6;
                                    c = 'm';
                                    f9 = f8;
                                    f11 = f9;
                                    iIntValue = iIntValue != 109 ? 76 : 108;
                                    f7 = f10;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 81:
                            case 113:
                                float fNextFloat7 = logcatCache.nextFloat();
                                float fCheckedNextFloat11 = logcatCache.checkedNextFloat(fNextFloat7);
                                float fCheckedNextFloat12 = logcatCache.checkedNextFloat(fCheckedNextFloat11);
                                float fCheckedNextFloat13 = logcatCache.checkedNextFloat(fCheckedNextFloat12);
                                if (!Float.isNaN(fCheckedNextFloat13)) {
                                    if (iIntValue == 113) {
                                        fCheckedNextFloat12 += f6;
                                        fCheckedNextFloat13 += f8;
                                        fNextFloat7 += f6;
                                        fCheckedNextFloat11 += f8;
                                    }
                                    f6 = fCheckedNextFloat12;
                                    f8 = fCheckedNextFloat13;
                                    logcatCache2.quadTo(fNextFloat7, fCheckedNextFloat11, f6, f8);
                                    i3 = i3;
                                    c = 'm';
                                    f7 = fNextFloat7;
                                    f9 = fCheckedNextFloat11;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 83:
                            case 115:
                                float f18 = (f6 * 2.0f) - f7;
                                float f19 = (2.0f * f8) - f9;
                                float fNextFloat8 = logcatCache.nextFloat();
                                float fCheckedNextFloat14 = logcatCache.checkedNextFloat(fNextFloat8);
                                float fCheckedNextFloat15 = logcatCache.checkedNextFloat(fCheckedNextFloat14);
                                float fCheckedNextFloat16 = logcatCache.checkedNextFloat(fCheckedNextFloat15);
                                if (!Float.isNaN(fCheckedNextFloat16)) {
                                    if (iIntValue == 115) {
                                        fCheckedNextFloat15 += f6;
                                        fCheckedNextFloat16 += f8;
                                        fNextFloat8 += f6;
                                        fCheckedNextFloat14 += f8;
                                    }
                                    f2 = fNextFloat8;
                                    f9 = fCheckedNextFloat14;
                                    f3 = fCheckedNextFloat16;
                                    c = 'm';
                                    f4 = fCheckedNextFloat15;
                                    logcatCache2.cubicTo(f18, f19, f2, f9, f4, f3);
                                    f7 = f2;
                                    f6 = f4;
                                    f8 = f3;
                                    i3 = i3;
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 84:
                            case 116:
                                f7 = (f6 * 2.0f) - f7;
                                f9 = (2.0f * f8) - f9;
                                float fNextFloat9 = logcatCache.nextFloat();
                                float fCheckedNextFloat17 = logcatCache.checkedNextFloat(fNextFloat9);
                                if (!Float.isNaN(fCheckedNextFloat17)) {
                                    if (iIntValue == 116) {
                                        fNextFloat9 += f6;
                                        fCheckedNextFloat17 += f8;
                                    }
                                    f6 = fNextFloat9;
                                    f8 = fCheckedNextFloat17;
                                    logcatCache2.quadTo(f7, f9, f6, f8);
                                    i3 = i3;
                                    c = 'm';
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 86:
                            case 118:
                                float fNextFloat10 = logcatCache.nextFloat();
                                if (!Float.isNaN(fNextFloat10)) {
                                    if (iIntValue == 118) {
                                        fNextFloat10 += f8;
                                    }
                                    f8 = fNextFloat10;
                                    logcatCache2.lineTo(f6, f8);
                                    f9 = f8;
                                    c = 'm';
                                    logcatCache.skipCommaWhitespace();
                                    if (logcatCache.empty()) {
                                        i = logcatCache.removed;
                                        if (i != logcatCache.appended) {
                                            iIntValue = logcatCache.nextChar().intValue();
                                        }
                                        f5 = f12;
                                        i3 = i3;
                                    }
                                } else {
                                    Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue) + " path segment");
                                    i3 = i3;
                                }
                                break;
                            case 90:
                            case 122:
                                logcatCache2.close();
                                f6 = f10;
                                f7 = f6;
                                f8 = f11;
                                f9 = f8;
                                c = 'm';
                                logcatCache.skipCommaWhitespace();
                                if (logcatCache.empty()) {
                                    i = logcatCache.removed;
                                    if (i != logcatCache.appended) {
                                        iIntValue = logcatCache.nextChar().intValue();
                                    }
                                    f5 = f12;
                                    i3 = i3;
                                }
                                break;
                            default:
                                i3 = i3;
                                break;
                        }
                    }
                } else {
                    i3 = i3;
                }
                path.d = logcatCache2;
            } else {
                if (iM == 43 && parseFloat(strTrim) < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
                i3 = i3;
            }
            i3++;
            attributes2 = attributes;
            i2 = 0;
        }
        this.currentElement.addChild(path);
    }

    public final void startDocument() {
        SVG svg = new SVG(0);
        svg.rootElement = null;
        svg.cssRules = new ConnectionPool(2);
        svg.idToElementMap = new HashMap();
        this.svgDocument = svg;
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        boolean z;
        if (this.ignoring) {
            this.ignoreDepth++;
            return;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            SVGElem sVGElem = (SVGElem) SVGElem.cache.get(str2.length() > 0 ? str2 : str3);
            if (sVGElem == null) {
                sVGElem = SVGElem.UNSUPPORTED;
            }
            switch (sVGElem.ordinal()) {
                case 0:
                    SVG.Svg svg = new SVG.Svg();
                    svg.document = this.svgDocument;
                    svg.parent = this.currentElement;
                    parseAttributesCore(svg, attributes);
                    parseAttributesStyle(svg, attributes);
                    parseAttributesConditional(svg, attributes);
                    parseAttributesViewBox(svg, attributes);
                    for (int i = 0; i < attributes.getLength(); i++) {
                        String strTrim = attributes.getValue(i).trim();
                        int iM = Density.CC.m(attributes, i);
                        if (iM == 25) {
                            SVG.Length length = parseLength(strTrim);
                            svg.height = length;
                            if (length.isNegative()) {
                                throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                            }
                        } else if (iM != 79) {
                            switch (iM) {
                                case 81:
                                    SVG.Length length2 = parseLength(strTrim);
                                    svg.width = length2;
                                    if (length2.isNegative()) {
                                        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                                    }
                                    break;
                                    break;
                                case 82:
                                    svg.x = parseLength(strTrim);
                                    break;
                                case 83:
                                    svg.y = parseLength(strTrim);
                                    break;
                            }
                        } else {
                            continue;
                        }
                    }
                    SVG.SvgContainer svgContainer = this.currentElement;
                    if (svgContainer == null) {
                        this.svgDocument.rootElement = svg;
                    } else {
                        svgContainer.addChild(svg);
                    }
                    this.currentElement = svg;
                    return;
                case 1:
                case 7:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Group group = new SVG.Group();
                    group.document = this.svgDocument;
                    group.parent = this.currentElement;
                    parseAttributesCore(group, attributes);
                    parseAttributesStyle(group, attributes);
                    parseAttributesTransform(group, attributes);
                    parseAttributesConditional(group, attributes);
                    this.currentElement.addChild(group);
                    this.currentElement = group;
                    return;
                case 2:
                    SVG.SvgContainer svgContainer2 = this.currentElement;
                    if (svgContainer2 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Circle circle = new SVG.Circle();
                    circle.document = this.svgDocument;
                    circle.parent = svgContainer2;
                    parseAttributesCore(circle, attributes);
                    parseAttributesStyle(circle, attributes);
                    parseAttributesTransform(circle, attributes);
                    parseAttributesConditional(circle, attributes);
                    for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                        String strTrim2 = attributes.getValue(i2).trim();
                        int iM2 = Density.CC.m(attributes, i2);
                        if (iM2 == 6) {
                            circle.cx = parseLength(strTrim2);
                        } else if (iM2 == 7) {
                            circle.cy = parseLength(strTrim2);
                        } else if (iM2 != 49) {
                            continue;
                        } else {
                            SVG.Length length3 = parseLength(strTrim2);
                            circle.r = length3;
                            if (length3.isNegative()) {
                                throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                            }
                        }
                    }
                    this.currentElement.addChild(circle);
                    return;
                case 3:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.ClipPath clipPath = new SVG.ClipPath();
                    clipPath.document = this.svgDocument;
                    clipPath.parent = this.currentElement;
                    parseAttributesCore(clipPath, attributes);
                    parseAttributesStyle(clipPath, attributes);
                    parseAttributesTransform(clipPath, attributes);
                    parseAttributesConditional(clipPath, attributes);
                    for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                        String strTrim3 = attributes.getValue(i3).trim();
                        if (Density.CC.m(attributes, i3) == 3) {
                            if ("objectBoundingBox".equals(strTrim3)) {
                                clipPath.clipPathUnitsAreUser = Boolean.FALSE;
                            } else {
                                if (!"userSpaceOnUse".equals(strTrim3)) {
                                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                                }
                                clipPath.clipPathUnitsAreUser = Boolean.TRUE;
                            }
                        }
                    }
                    this.currentElement.addChild(clipPath);
                    this.currentElement = clipPath;
                    return;
                case 4:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Defs defs = new SVG.Defs();
                    defs.document = this.svgDocument;
                    defs.parent = this.currentElement;
                    parseAttributesCore(defs, attributes);
                    parseAttributesStyle(defs, attributes);
                    parseAttributesTransform(defs, attributes);
                    this.currentElement.addChild(defs);
                    this.currentElement = defs;
                    return;
                case 5:
                case 26:
                    this.inMetadataElement = true;
                    this.metadataTag = sVGElem;
                    return;
                case 6:
                    SVG.SvgContainer svgContainer3 = this.currentElement;
                    if (svgContainer3 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Ellipse ellipse = new SVG.Ellipse();
                    ellipse.document = this.svgDocument;
                    ellipse.parent = svgContainer3;
                    parseAttributesCore(ellipse, attributes);
                    parseAttributesStyle(ellipse, attributes);
                    parseAttributesTransform(ellipse, attributes);
                    parseAttributesConditional(ellipse, attributes);
                    for (int i4 = 0; i4 < attributes.getLength(); i4++) {
                        String strTrim4 = attributes.getValue(i4).trim();
                        int iM3 = Density.CC.m(attributes, i4);
                        if (iM3 == 6) {
                            ellipse.cx = parseLength(strTrim4);
                        } else if (iM3 == 7) {
                            ellipse.cy = parseLength(strTrim4);
                        } else if (iM3 == 56) {
                            SVG.Length length4 = parseLength(strTrim4);
                            ellipse.rx = length4;
                            if (length4.isNegative()) {
                                throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                            }
                        } else if (iM3 != 57) {
                            continue;
                        } else {
                            SVG.Length length5 = parseLength(strTrim4);
                            ellipse.ry = length5;
                            if (length5.isNegative()) {
                                throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                            }
                        }
                    }
                    this.currentElement.addChild(ellipse);
                    return;
                case 8:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Image image = new SVG.Image();
                    image.document = this.svgDocument;
                    image.parent = this.currentElement;
                    parseAttributesCore(image, attributes);
                    parseAttributesStyle(image, attributes);
                    parseAttributesTransform(image, attributes);
                    parseAttributesConditional(image, attributes);
                    for (int i5 = 0; i5 < attributes.getLength(); i5++) {
                        String strTrim5 = attributes.getValue(i5).trim();
                        int iM4 = Density.CC.m(attributes, i5);
                        if (iM4 == 25) {
                            SVG.Length length6 = parseLength(strTrim5);
                            image.height = length6;
                            if (length6.isNegative()) {
                                throw new SVGParseException("Invalid <use> element. height cannot be negative");
                            }
                        } else if (iM4 != 26) {
                            if (iM4 != 48) {
                                switch (iM4) {
                                    case 81:
                                        SVG.Length length7 = parseLength(strTrim5);
                                        image.width = length7;
                                        if (length7.isNegative()) {
                                            throw new SVGParseException("Invalid <use> element. width cannot be negative");
                                        }
                                        break;
                                        break;
                                    case 82:
                                        image.x = parseLength(strTrim5);
                                        break;
                                    case 83:
                                        image.y = parseLength(strTrim5);
                                        break;
                                }
                            } else {
                                parsePreserveAspectRatio(image, strTrim5);
                            }
                        } else if ("".equals(attributes.getURI(i5)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i5))) {
                            image.href = strTrim5;
                        }
                    }
                    this.currentElement.addChild(image);
                    this.currentElement = image;
                    return;
                case 9:
                    SVG.SvgContainer svgContainer4 = this.currentElement;
                    if (svgContainer4 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Line line = new SVG.Line();
                    line.document = this.svgDocument;
                    line.parent = svgContainer4;
                    parseAttributesCore(line, attributes);
                    parseAttributesStyle(line, attributes);
                    parseAttributesTransform(line, attributes);
                    parseAttributesConditional(line, attributes);
                    for (int i6 = 0; i6 < attributes.getLength(); i6++) {
                        String strTrim6 = attributes.getValue(i6).trim();
                        switch (Density.CC.m(attributes, i6)) {
                            case 84:
                                line.x1 = parseLength(strTrim6);
                                break;
                            case 85:
                                line.y1 = parseLength(strTrim6);
                                break;
                            case 86:
                                line.x2 = parseLength(strTrim6);
                                break;
                            case 87:
                                line.y2 = parseLength(strTrim6);
                                break;
                        }
                    }
                    this.currentElement.addChild(line);
                    return;
                case 10:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
                    svgLinearGradient.document = this.svgDocument;
                    svgLinearGradient.parent = this.currentElement;
                    parseAttributesCore(svgLinearGradient, attributes);
                    parseAttributesStyle(svgLinearGradient, attributes);
                    parseAttributesGradient(svgLinearGradient, attributes);
                    for (int i7 = 0; i7 < attributes.getLength(); i7++) {
                        String strTrim7 = attributes.getValue(i7).trim();
                        switch (Density.CC.m(attributes, i7)) {
                            case 84:
                                svgLinearGradient.x1 = parseLength(strTrim7);
                                break;
                            case 85:
                                svgLinearGradient.y1 = parseLength(strTrim7);
                                break;
                            case 86:
                                svgLinearGradient.x2 = parseLength(strTrim7);
                                break;
                            case 87:
                                svgLinearGradient.y2 = parseLength(strTrim7);
                                break;
                        }
                    }
                    this.currentElement.addChild(svgLinearGradient);
                    this.currentElement = svgLinearGradient;
                    return;
                case 11:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Marker marker = new SVG.Marker();
                    marker.document = this.svgDocument;
                    marker.parent = this.currentElement;
                    parseAttributesCore(marker, attributes);
                    parseAttributesStyle(marker, attributes);
                    parseAttributesConditional(marker, attributes);
                    parseAttributesViewBox(marker, attributes);
                    for (int i8 = 0; i8 < attributes.getLength(); i8++) {
                        String strTrim8 = attributes.getValue(i8).trim();
                        int iM5 = Density.CC.m(attributes, i8);
                        if (iM5 != 41) {
                            if (iM5 == 50) {
                                marker.refX = parseLength(strTrim8);
                            } else if (iM5 != 51) {
                                switch (iM5) {
                                    case 32:
                                        SVG.Length length8 = parseLength(strTrim8);
                                        marker.markerHeight = length8;
                                        if (length8.isNegative()) {
                                            throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                                        }
                                        continue;
                                        break;
                                    case 33:
                                        if (!"strokeWidth".equals(strTrim8)) {
                                            if (!"userSpaceOnUse".equals(strTrim8)) {
                                                throw new SVGParseException("Invalid value for attribute markerUnits");
                                            }
                                            marker.markerUnitsAreUser = true;
                                        } else {
                                            marker.markerUnitsAreUser = false;
                                            continue;
                                        }
                                        break;
                                    case 34:
                                        SVG.Length length9 = parseLength(strTrim8);
                                        marker.markerWidth = length9;
                                        if (length9.isNegative()) {
                                            throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                                        }
                                        break;
                                }
                            } else {
                                marker.refY = parseLength(strTrim8);
                            }
                        } else if ("auto".equals(strTrim8)) {
                            marker.orient = Float.valueOf(Float.NaN);
                        } else {
                            marker.orient = Float.valueOf(parseFloat(strTrim8));
                        }
                    }
                    this.currentElement.addChild(marker);
                    this.currentElement = marker;
                    return;
                case 12:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Mask mask = new SVG.Mask();
                    mask.document = this.svgDocument;
                    mask.parent = this.currentElement;
                    parseAttributesCore(mask, attributes);
                    parseAttributesStyle(mask, attributes);
                    parseAttributesConditional(mask, attributes);
                    for (int i9 = 0; i9 < attributes.getLength(); i9++) {
                        String strTrim9 = attributes.getValue(i9).trim();
                        int iM6 = Density.CC.m(attributes, i9);
                        if (iM6 == 25) {
                            SVG.Length length10 = parseLength(strTrim9);
                            mask.height = length10;
                            if (length10.isNegative()) {
                                throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                            }
                        } else if (iM6 != 36) {
                            if (iM6 != 37) {
                                switch (iM6) {
                                    case 81:
                                        SVG.Length length11 = parseLength(strTrim9);
                                        mask.width = length11;
                                        if (length11.isNegative()) {
                                            throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                                        }
                                        break;
                                        break;
                                    case 82:
                                        parseLength(strTrim9);
                                        break;
                                    case 83:
                                        parseLength(strTrim9);
                                        break;
                                }
                            } else if ("objectBoundingBox".equals(strTrim9)) {
                                mask.maskUnitsAreUser = Boolean.FALSE;
                            } else {
                                if (!"userSpaceOnUse".equals(strTrim9)) {
                                    throw new SVGParseException("Invalid value for attribute maskUnits");
                                }
                                mask.maskUnitsAreUser = Boolean.TRUE;
                            }
                        } else if ("objectBoundingBox".equals(strTrim9)) {
                            mask.maskContentUnitsAreUser = Boolean.FALSE;
                        } else {
                            if (!"userSpaceOnUse".equals(strTrim9)) {
                                throw new SVGParseException("Invalid value for attribute maskContentUnits");
                            }
                            mask.maskContentUnitsAreUser = Boolean.TRUE;
                        }
                    }
                    this.currentElement.addChild(mask);
                    this.currentElement = mask;
                    return;
                case 13:
                    path(attributes);
                    return;
                case 14:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Pattern pattern = new SVG.Pattern();
                    pattern.document = this.svgDocument;
                    pattern.parent = this.currentElement;
                    parseAttributesCore(pattern, attributes);
                    parseAttributesStyle(pattern, attributes);
                    parseAttributesConditional(pattern, attributes);
                    parseAttributesViewBox(pattern, attributes);
                    for (int i10 = 0; i10 < attributes.getLength(); i10++) {
                        String strTrim10 = attributes.getValue(i10).trim();
                        int iM7 = Density.CC.m(attributes, i10);
                        if (iM7 == 25) {
                            SVG.Length length12 = parseLength(strTrim10);
                            pattern.height = length12;
                            if (length12.isNegative()) {
                                throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                            }
                        } else if (iM7 != 26) {
                            switch (iM7) {
                                case 44:
                                    if (!"objectBoundingBox".equals(strTrim10)) {
                                        if (!"userSpaceOnUse".equals(strTrim10)) {
                                            throw new SVGParseException("Invalid value for attribute patternContentUnits");
                                        }
                                        pattern.patternContentUnitsAreUser = Boolean.TRUE;
                                    } else {
                                        pattern.patternContentUnitsAreUser = Boolean.FALSE;
                                    }
                                    break;
                                case 45:
                                    pattern.patternTransform = parseTransformList(strTrim10);
                                    break;
                                case 46:
                                    if (!"objectBoundingBox".equals(strTrim10)) {
                                        if (!"userSpaceOnUse".equals(strTrim10)) {
                                            throw new SVGParseException("Invalid value for attribute patternUnits");
                                        }
                                        pattern.patternUnitsAreUser = Boolean.TRUE;
                                    } else {
                                        pattern.patternUnitsAreUser = Boolean.FALSE;
                                    }
                                    break;
                                default:
                                    switch (iM7) {
                                        case 81:
                                            SVG.Length length13 = parseLength(strTrim10);
                                            pattern.width = length13;
                                            if (length13.isNegative()) {
                                                throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                                            }
                                            break;
                                            break;
                                        case 82:
                                            pattern.x = parseLength(strTrim10);
                                            break;
                                        case 83:
                                            pattern.y = parseLength(strTrim10);
                                            break;
                                    }
                                    break;
                            }
                        } else if ("".equals(attributes.getURI(i10)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i10))) {
                            pattern.href = strTrim10;
                        }
                    }
                    this.currentElement.addChild(pattern);
                    this.currentElement = pattern;
                    return;
                case 15:
                    SVG.SvgContainer svgContainer5 = this.currentElement;
                    if (svgContainer5 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Polygon polygon = new SVG.Polygon();
                    polygon.document = this.svgDocument;
                    polygon.parent = svgContainer5;
                    parseAttributesCore(polygon, attributes);
                    parseAttributesStyle(polygon, attributes);
                    parseAttributesTransform(polygon, attributes);
                    parseAttributesConditional(polygon, attributes);
                    parseAttributesPolyLine(polygon, attributes, "polygon");
                    this.currentElement.addChild(polygon);
                    return;
                case 16:
                    SVG.SvgContainer svgContainer6 = this.currentElement;
                    if (svgContainer6 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.PolyLine polyLine = new SVG.PolyLine();
                    polyLine.document = this.svgDocument;
                    polyLine.parent = svgContainer6;
                    parseAttributesCore(polyLine, attributes);
                    parseAttributesStyle(polyLine, attributes);
                    parseAttributesTransform(polyLine, attributes);
                    parseAttributesConditional(polyLine, attributes);
                    parseAttributesPolyLine(polyLine, attributes, "polyline");
                    this.currentElement.addChild(polyLine);
                    return;
                case 17:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
                    svgRadialGradient.document = this.svgDocument;
                    svgRadialGradient.parent = this.currentElement;
                    parseAttributesCore(svgRadialGradient, attributes);
                    parseAttributesStyle(svgRadialGradient, attributes);
                    parseAttributesGradient(svgRadialGradient, attributes);
                    for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                        String strTrim11 = attributes.getValue(i11).trim();
                        int iM8 = Density.CC.m(attributes, i11);
                        if (iM8 == 6) {
                            svgRadialGradient.cx = parseLength(strTrim11);
                        } else if (iM8 == 7) {
                            svgRadialGradient.cy = parseLength(strTrim11);
                        } else if (iM8 == 11) {
                            svgRadialGradient.fx = parseLength(strTrim11);
                        } else if (iM8 == 12) {
                            svgRadialGradient.fy = parseLength(strTrim11);
                        } else if (iM8 != 49) {
                            continue;
                        } else {
                            SVG.Length length14 = parseLength(strTrim11);
                            svgRadialGradient.r = length14;
                            if (length14.isNegative()) {
                                throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                            }
                        }
                    }
                    this.currentElement.addChild(svgRadialGradient);
                    this.currentElement = svgRadialGradient;
                    return;
                case 18:
                    SVG.SvgContainer svgContainer7 = this.currentElement;
                    if (svgContainer7 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Rect rect = new SVG.Rect();
                    rect.document = this.svgDocument;
                    rect.parent = svgContainer7;
                    parseAttributesCore(rect, attributes);
                    parseAttributesStyle(rect, attributes);
                    parseAttributesTransform(rect, attributes);
                    parseAttributesConditional(rect, attributes);
                    for (int i12 = 0; i12 < attributes.getLength(); i12++) {
                        String strTrim12 = attributes.getValue(i12).trim();
                        int iM9 = Density.CC.m(attributes, i12);
                        if (iM9 == 25) {
                            SVG.Length length15 = parseLength(strTrim12);
                            rect.height = length15;
                            if (length15.isNegative()) {
                                throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                            }
                        } else if (iM9 == 56) {
                            SVG.Length length16 = parseLength(strTrim12);
                            rect.rx = length16;
                            if (length16.isNegative()) {
                                throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                            }
                        } else if (iM9 != 57) {
                            switch (iM9) {
                                case 81:
                                    SVG.Length length17 = parseLength(strTrim12);
                                    rect.width = length17;
                                    if (length17.isNegative()) {
                                        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                                    }
                                    break;
                                    break;
                                case 82:
                                    rect.x = parseLength(strTrim12);
                                    break;
                                case 83:
                                    rect.y = parseLength(strTrim12);
                                    break;
                            }
                        } else {
                            SVG.Length length18 = parseLength(strTrim12);
                            rect.ry = length18;
                            if (length18.isNegative()) {
                                throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                            }
                        }
                    }
                    this.currentElement.addChild(rect);
                    return;
                case 19:
                    SVG.SvgContainer svgContainer8 = this.currentElement;
                    if (svgContainer8 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.SolidColor solidColor = new SVG.SolidColor();
                    solidColor.document = this.svgDocument;
                    solidColor.parent = svgContainer8;
                    parseAttributesCore(solidColor, attributes);
                    parseAttributesStyle(solidColor, attributes);
                    this.currentElement.addChild(solidColor);
                    this.currentElement = solidColor;
                    return;
                case 20:
                    SVG.SvgContainer svgContainer9 = this.currentElement;
                    if (svgContainer9 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    if (!(svgContainer9 instanceof SVG.GradientElement)) {
                        throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
                    }
                    SVG.Stop stop = new SVG.Stop();
                    stop.document = this.svgDocument;
                    stop.parent = svgContainer9;
                    parseAttributesCore(stop, attributes);
                    parseAttributesStyle(stop, attributes);
                    for (int i13 = 0; i13 < attributes.getLength(); i13++) {
                        String strTrim13 = attributes.getValue(i13).trim();
                        if (Density.CC.m(attributes, i13) == 39) {
                            if (strTrim13.length() == 0) {
                                throw new SVGParseException("Invalid offset value in <stop> (empty string)");
                            }
                            int length19 = strTrim13.length();
                            if (strTrim13.charAt(strTrim13.length() - 1) == '%') {
                                length19--;
                                z = true;
                            } else {
                                z = false;
                            }
                            try {
                                float f = parseFloat(strTrim13, length19);
                                float f2 = 100.0f;
                                if (z) {
                                    f /= 100.0f;
                                }
                                if (f < 0.0f) {
                                    f2 = 0.0f;
                                } else if (f <= 100.0f) {
                                    f2 = f;
                                }
                                stop.offset = Float.valueOf(f2);
                            } catch (NumberFormatException e) {
                                throw new SVGParseException("Invalid offset value in <stop>: ".concat(strTrim13), e);
                            }
                        }
                    }
                    this.currentElement.addChild(stop);
                    this.currentElement = stop;
                    return;
                case 21:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    String str4 = "all";
                    boolean zEquals = true;
                    for (int i14 = 0; i14 < attributes.getLength(); i14++) {
                        String strTrim14 = attributes.getValue(i14).trim();
                        int iM10 = Density.CC.m(attributes, i14);
                        if (iM10 == 38) {
                            str4 = strTrim14;
                        } else if (iM10 == 77) {
                            zEquals = strTrim14.equals("text/css");
                        }
                    }
                    if (zEquals) {
                        CSSParser.CSSTextScanner cSSTextScanner = new CSSParser.CSSTextScanner(str4);
                        cSSTextScanner.skipWhitespace();
                        ArrayList mediaList = CSSParser.parseMediaList(cSSTextScanner);
                        int size = mediaList.size();
                        int i15 = 0;
                        while (i15 < size) {
                            Object obj = mediaList.get(i15);
                            i15++;
                            CSSParser.MediaType mediaType = (CSSParser.MediaType) obj;
                            if (mediaType == CSSParser.MediaType.all || mediaType == CSSParser.MediaType.screen) {
                                this.inStyleElement = true;
                                return;
                            }
                        }
                    }
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    return;
                case 22:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Switch r0 = new SVG.Switch();
                    r0.document = this.svgDocument;
                    r0.parent = this.currentElement;
                    parseAttributesCore(r0, attributes);
                    parseAttributesStyle(r0, attributes);
                    parseAttributesTransform(r0, attributes);
                    parseAttributesConditional(r0, attributes);
                    this.currentElement.addChild(r0);
                    this.currentElement = r0;
                    return;
                case 23:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Symbol symbol = new SVG.Symbol();
                    symbol.document = this.svgDocument;
                    symbol.parent = this.currentElement;
                    parseAttributesCore(symbol, attributes);
                    parseAttributesStyle(symbol, attributes);
                    parseAttributesConditional(symbol, attributes);
                    parseAttributesViewBox(symbol, attributes);
                    this.currentElement.addChild(symbol);
                    this.currentElement = symbol;
                    return;
                case 24:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Text text = new SVG.Text();
                    text.document = this.svgDocument;
                    text.parent = this.currentElement;
                    parseAttributesCore(text, attributes);
                    parseAttributesStyle(text, attributes);
                    parseAttributesTransform(text, attributes);
                    parseAttributesConditional(text, attributes);
                    parseAttributesTextPosition(text, attributes);
                    this.currentElement.addChild(text);
                    this.currentElement = text;
                    return;
                case 25:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.TextPath textPath = new SVG.TextPath();
                    textPath.document = this.svgDocument;
                    textPath.parent = this.currentElement;
                    parseAttributesCore(textPath, attributes);
                    parseAttributesStyle(textPath, attributes);
                    parseAttributesConditional(textPath, attributes);
                    for (int i16 = 0; i16 < attributes.getLength(); i16++) {
                        String strTrim15 = attributes.getValue(i16).trim();
                        int iM11 = Density.CC.m(attributes, i16);
                        if (iM11 != 26) {
                            if (iM11 == 61) {
                                textPath.startOffset = parseLength(strTrim15);
                            }
                        } else if ("".equals(attributes.getURI(i16)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i16))) {
                            textPath.href = strTrim15;
                        }
                    }
                    this.currentElement.addChild(textPath);
                    this.currentElement = textPath;
                    SVG.SvgContainer svgContainer10 = textPath.parent;
                    if (svgContainer10 instanceof SVG.Text) {
                        textPath.textRoot = (SVG.Text) svgContainer10;
                        return;
                    } else {
                        textPath.textRoot = ((SVG.TextChild) svgContainer10).getTextRoot();
                        return;
                    }
                case 27:
                    SVG.SvgContainer svgContainer11 = this.currentElement;
                    if (svgContainer11 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    if (!(svgContainer11 instanceof SVG.TextContainer)) {
                        throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
                    }
                    SVG.TRef tRef = new SVG.TRef();
                    tRef.document = this.svgDocument;
                    tRef.parent = this.currentElement;
                    parseAttributesCore(tRef, attributes);
                    parseAttributesStyle(tRef, attributes);
                    parseAttributesConditional(tRef, attributes);
                    for (int i17 = 0; i17 < attributes.getLength(); i17++) {
                        String strTrim16 = attributes.getValue(i17).trim();
                        if (Density.CC.m(attributes, i17) == 26 && ("".equals(attributes.getURI(i17)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i17)))) {
                            tRef.href = strTrim16;
                        }
                    }
                    this.currentElement.addChild(tRef);
                    SVG.SvgContainer svgContainer12 = tRef.parent;
                    if (svgContainer12 instanceof SVG.Text) {
                        tRef.textRoot = (SVG.Text) svgContainer12;
                        return;
                    } else {
                        tRef.textRoot = ((SVG.TextChild) svgContainer12).getTextRoot();
                        return;
                    }
                case 28:
                    SVG.SvgContainer svgContainer13 = this.currentElement;
                    if (svgContainer13 == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    if (!(svgContainer13 instanceof SVG.TextContainer)) {
                        throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
                    }
                    SVG.TSpan tSpan = new SVG.TSpan();
                    tSpan.document = this.svgDocument;
                    tSpan.parent = this.currentElement;
                    parseAttributesCore(tSpan, attributes);
                    parseAttributesStyle(tSpan, attributes);
                    parseAttributesConditional(tSpan, attributes);
                    parseAttributesTextPosition(tSpan, attributes);
                    this.currentElement.addChild(tSpan);
                    this.currentElement = tSpan;
                    SVG.SvgContainer svgContainer14 = tSpan.parent;
                    if (svgContainer14 instanceof SVG.Text) {
                        tSpan.textRoot = (SVG.Text) svgContainer14;
                        return;
                    } else {
                        tSpan.textRoot = ((SVG.TextChild) svgContainer14).getTextRoot();
                        return;
                    }
                case 29:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.Use use = new SVG.Use();
                    use.document = this.svgDocument;
                    use.parent = this.currentElement;
                    parseAttributesCore(use, attributes);
                    parseAttributesStyle(use, attributes);
                    parseAttributesTransform(use, attributes);
                    parseAttributesConditional(use, attributes);
                    for (int i18 = 0; i18 < attributes.getLength(); i18++) {
                        String strTrim17 = attributes.getValue(i18).trim();
                        int iM12 = Density.CC.m(attributes, i18);
                        if (iM12 == 25) {
                            SVG.Length length20 = parseLength(strTrim17);
                            use.height = length20;
                            if (length20.isNegative()) {
                                throw new SVGParseException("Invalid <use> element. height cannot be negative");
                            }
                        } else if (iM12 != 26) {
                            switch (iM12) {
                                case 81:
                                    SVG.Length length21 = parseLength(strTrim17);
                                    use.width = length21;
                                    if (length21.isNegative()) {
                                        throw new SVGParseException("Invalid <use> element. width cannot be negative");
                                    }
                                    break;
                                    break;
                                case 82:
                                    use.x = parseLength(strTrim17);
                                    break;
                                case 83:
                                    use.y = parseLength(strTrim17);
                                    break;
                            }
                        } else if ("".equals(attributes.getURI(i18)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i18))) {
                            use.href = strTrim17;
                        }
                    }
                    this.currentElement.addChild(use);
                    this.currentElement = use;
                    return;
                case 30:
                    if (this.currentElement == null) {
                        throw new SVGParseException("Invalid document. Root element must be <svg>");
                    }
                    SVG.View view = new SVG.View();
                    view.document = this.svgDocument;
                    view.parent = this.currentElement;
                    parseAttributesCore(view, attributes);
                    parseAttributesConditional(view, attributes);
                    parseAttributesViewBox(view, attributes);
                    this.currentElement.addChild(view);
                    this.currentElement = view;
                    return;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    return;
            }
        }
    }

    public final void text(String str) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(str.length());
            }
            this.metadataElementContents.append(str);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(str.length());
            }
            this.styleElementContents.append(str);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(str);
        }
    }

    public static float parseFloat(String str, int i) throws SVGParseException {
        float number = new NumberParser().parseNumber(0, i, str);
        if (Float.isNaN(number)) {
            throw new SVGParseException(CaptureSession$State$EnumUnboxingLocalUtility.m("Invalid float value: ", str));
        }
        return number;
    }

    public final void text(char[] cArr, int i, int i2) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i2);
            }
            this.metadataElementContents.append(cArr, i, i2);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i2);
            }
            this.styleElementContents.append(cArr, i, i2);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(new String(cArr, i, i2));
        }
    }
}
