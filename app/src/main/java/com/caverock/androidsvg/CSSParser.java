package com.caverock.androidsvg;

import android.util.Log;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.navigation.NavOptions;
import com.github.kr328.clash.log.LogcatCache;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CSSParser implements ViewPropertyAnimatorListener {
    public boolean inMediaRule;
    public Object deviceMediaType = new Object[4];
    public int source = 0;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Attrib {
        public final String name;
        public final int operation;
        public final String value;

        public Attrib(int i, String str, String str2) {
            this.name = str;
            this.operation = i;
            this.value = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CSSTextScanner extends LogcatCache {
        public CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        public static int hexChar(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            if (i >= 65 && i <= 70) {
                return i - 55;
            }
            if (i < 97 || i > 102) {
                return -1;
            }
            return i - 87;
        }

        public final String nextCSSString() {
            int iHexChar;
            if (empty()) {
                return null;
            }
            char cCharAt = ((String) this.array).charAt(this.removed);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.removed++;
            int iIntValue = nextChar().intValue();
            while (iIntValue != -1 && iIntValue != cCharAt) {
                if (iIntValue == 92) {
                    iIntValue = nextChar().intValue();
                    if (iIntValue != -1) {
                        if (iIntValue == 10 || iIntValue == 13 || iIntValue == 12) {
                            iIntValue = nextChar().intValue();
                        } else {
                            int iHexChar2 = hexChar(iIntValue);
                            if (iHexChar2 != -1) {
                                for (int i = 1; i <= 5 && (iHexChar = hexChar((iIntValue = nextChar().intValue()))) != -1; i++) {
                                    iHexChar2 = (iHexChar2 * 16) + iHexChar;
                                }
                                sb.append((char) iHexChar2);
                            }
                        }
                    }
                }
                sb.append((char) iIntValue);
                iIntValue = nextChar().intValue();
            }
            return sb.toString();
        }

        public final String nextIdentifier() {
            int i;
            int i2;
            String str = (String) this.array;
            if (empty()) {
                i2 = this.removed;
            } else {
                int i3 = this.removed;
                int iCharAt = str.charAt(i3);
                if (iCharAt == 45) {
                    iCharAt = advanceChar();
                }
                if ((iCharAt < 65 || iCharAt > 90) && ((iCharAt < 97 || iCharAt > 122) && iCharAt != 95)) {
                    i = i3;
                } else {
                    int iAdvanceChar = advanceChar();
                    while (true) {
                        if ((iAdvanceChar < 65 || iAdvanceChar > 90) && ((iAdvanceChar < 97 || iAdvanceChar > 122) && !((iAdvanceChar >= 48 && iAdvanceChar <= 57) || iAdvanceChar == 45 || iAdvanceChar == 95))) {
                            break;
                        }
                        iAdvanceChar = advanceChar();
                    }
                    i = this.removed;
                }
                this.removed = i3;
                i2 = i;
            }
            int i4 = this.removed;
            if (i2 == i4) {
                return null;
            }
            String strSubstring = str.substring(i4, i2);
            this.removed = i2;
            return strSubstring;
        }

        /* JADX WARN: Code duplicated, block: B:125:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:185:0x0321  */
        /* JADX WARN: Code duplicated, block: B:22:0x004b  */
        /* JADX WARN: Code duplicated, block: B:239:0x03fa  */
        /* JADX WARN: Code duplicated, block: B:248:0x043b  */
        /* JADX WARN: Code duplicated, block: B:253:0x0457  */
        /* JADX WARN: Code duplicated, block: B:255:0x045b  */
        /* JADX WARN: Code duplicated, block: B:259:0x0471  */
        /* JADX WARN: Code duplicated, block: B:263:0x0480  */
        /* JADX WARN: Code duplicated, block: B:279:0x047a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:280:0x046d A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v32 */
        /* JADX WARN: Type inference failed for: r10v33 */
        /* JADX WARN: Type inference failed for: r10v34, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r10v41 */
        /* JADX WARN: Type inference failed for: r10v42 */
        /* JADX WARN: Type inference failed for: r11v10, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v12, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v13, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v14, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v15, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v16, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v19 */
        /* JADX WARN: Type inference failed for: r11v20 */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v9, types: [com.caverock.androidsvg.CSSParser$SimpleSelector] */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v36, types: [androidx.navigation.NavOptions$Builder] */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v65 */
        public final ArrayList nextSelectorGroup() throws CSSParseException {
            ArrayList arrayList;
            int i;
            ?? simpleSelector;
            int i2;
            String strNextQuotedString;
            char c;
            PseudoClass pseudoClassRoot;
            int i3;
            IntegerParser integerParser;
            NavOptions.Builder builder;
            ?? r2;
            NavOptions.Builder builder2;
            ArrayList arrayListNextSelectorGroup;
            String str = null;
            if (empty()) {
                return null;
            }
            int i4 = 1;
            ArrayList arrayList2 = new ArrayList(1);
            Selector selector = new Selector();
            while (!empty() && !empty()) {
                int i5 = this.removed;
                ArrayList arrayList3 = selector.simpleSelectors;
                int i6 = 2;
                if (arrayList3 == null || arrayList3.isEmpty()) {
                    i = 0;
                } else if (consume('>')) {
                    skipWhitespace();
                    i = 2;
                } else if (consume('+')) {
                    skipWhitespace();
                    i = 3;
                } else {
                    i = 0;
                }
                if (consume('*')) {
                    simpleSelector = new SimpleSelector(str, i);
                } else {
                    String strNextIdentifier = nextIdentifier();
                    if (strNextIdentifier != null) {
                        SimpleSelector simpleSelector2 = new SimpleSelector(strNextIdentifier, i);
                        selector.specificity += i4;
                        simpleSelector = simpleSelector2;
                    } else {
                        simpleSelector = str;
                    }
                }
                while (!empty()) {
                    if (consume('.')) {
                        if (simpleSelector == 0) {
                            simpleSelector = new SimpleSelector(str, i);
                        }
                        String strNextIdentifier2 = nextIdentifier();
                        if (strNextIdentifier2 == null) {
                            throw new CSSParseException("Invalid \".class\" simpleSelectors");
                        }
                        simpleSelector.addAttrib(i6, "class", strNextIdentifier2);
                        selector.addedAttributeOrPseudo();
                    } else if (consume('#')) {
                        if (simpleSelector == 0) {
                            simpleSelector = new SimpleSelector(str, i);
                        }
                        String strNextIdentifier3 = nextIdentifier();
                        if (strNextIdentifier3 == null) {
                            throw new CSSParseException("Invalid \"#id\" simpleSelectors");
                        }
                        simpleSelector.addAttrib(i6, "id", strNextIdentifier3);
                        selector.specificity += 1000000;
                    } else if (consume('[')) {
                        if (simpleSelector == 0) {
                            simpleSelector = new SimpleSelector(str, i);
                        }
                        skipWhitespace();
                        String strNextIdentifier4 = nextIdentifier();
                        if (strNextIdentifier4 == null) {
                            throw new CSSParseException("Invalid attribute simpleSelectors");
                        }
                        skipWhitespace();
                        if (consume('=')) {
                            i2 = i6;
                        } else if (consume("~=")) {
                            i2 = 3;
                        } else {
                            i2 = consume("|=") ? 4 : 0;
                        }
                        if (i2 != 0) {
                            skipWhitespace();
                            if (empty()) {
                                strNextQuotedString = str;
                            } else {
                                strNextQuotedString = nextQuotedString();
                                if (strNextQuotedString == null) {
                                    strNextQuotedString = nextIdentifier();
                                }
                            }
                            if (strNextQuotedString == null) {
                                throw new CSSParseException("Invalid attribute simpleSelectors");
                            }
                            skipWhitespace();
                        } else {
                            strNextQuotedString = str;
                        }
                        if (!consume(']')) {
                            throw new CSSParseException("Invalid attribute simpleSelectors");
                        }
                        if (i2 == 0) {
                            i2 = i4;
                        }
                        simpleSelector.addAttrib(i2, strNextIdentifier4, strNextQuotedString);
                        selector.addedAttributeOrPseudo();
                    } else {
                        simpleSelector = simpleSelector;
                        if (consume(':')) {
                            if (simpleSelector == 0) {
                                simpleSelector = new SimpleSelector(str, i);
                            }
                            String strNextIdentifier5 = nextIdentifier();
                            if (strNextIdentifier5 == null) {
                                throw new CSSParseException("Invalid pseudo class");
                            }
                            PseudoClassIdents pseudoClassIdents = (PseudoClassIdents) PseudoClassIdents.cache.get(strNextIdentifier5);
                            if (pseudoClassIdents == null) {
                                pseudoClassIdents = PseudoClassIdents.UNSUPPORTED;
                            }
                            String str2 = "Invalid or missing parameter section for pseudo class: ";
                            switch (pseudoClassIdents.ordinal()) {
                                case 0:
                                    c = '+';
                                    pseudoClassRoot = new PseudoClassRoot(2);
                                    selector.addedAttributeOrPseudo();
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 1:
                                    c = '+';
                                    pseudoClassRoot = new PseudoClassRoot(0);
                                    selector.addedAttributeOrPseudo();
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    String str3 = str;
                                    boolean z = pseudoClassIdents == PseudoClassIdents.nth_child || pseudoClassIdents == PseudoClassIdents.nth_of_type;
                                    boolean z2 = pseudoClassIdents == PseudoClassIdents.nth_of_type || pseudoClassIdents == PseudoClassIdents.nth_last_of_type;
                                    int i7 = this.appended;
                                    String str4 = (String) this.array;
                                    if (empty()) {
                                        r2 = str3;
                                        str2 = "Invalid or missing parameter section for pseudo class: ";
                                        c = '+';
                                    } else {
                                        int i8 = this.removed;
                                        if (consume('(')) {
                                            skipWhitespace();
                                            if (consume("odd")) {
                                                builder2 = new NavOptions.Builder(2, 1);
                                            } else {
                                                if (consume("even")) {
                                                    builder2 = new NavOptions.Builder(2, 0);
                                                } else {
                                                    int i9 = (!consume('+') && consume('-')) ? -1 : 1;
                                                    IntegerParser integerParser2 = IntegerParser.parseInt(this.removed, i7, str4);
                                                    if (integerParser2 != null) {
                                                        this.removed = integerParser2.pos;
                                                    }
                                                    if (consume('n') || consume('N')) {
                                                        if (integerParser2 == null) {
                                                            integerParser2 = new IntegerParser(this.removed, 1L);
                                                        }
                                                        skipWhitespace();
                                                        c = '+';
                                                        boolean zConsume = consume('+');
                                                        int i10 = (zConsume || !(zConsume = consume('-'))) ? 1 : -1;
                                                        if (zConsume) {
                                                            skipWhitespace();
                                                            integerParser = IntegerParser.parseInt(this.removed, i7, str4);
                                                            if (integerParser != null) {
                                                                this.removed = integerParser.pos;
                                                                int i11 = i9;
                                                                i9 = i10;
                                                                i3 = i11;
                                                            } else {
                                                                this.removed = i8;
                                                            }
                                                        } else {
                                                            int i12 = i9;
                                                            i9 = i10;
                                                            i3 = i12;
                                                            integerParser = null;
                                                        }
                                                    } else {
                                                        integerParser = integerParser2;
                                                        str2 = "Invalid or missing parameter section for pseudo class: ";
                                                        i3 = 1;
                                                        integerParser2 = null;
                                                        c = '+';
                                                    }
                                                    builder = new NavOptions.Builder(integerParser2 == null ? 0 : i3 * ((int) integerParser2.value), integerParser == null ? 0 : ((int) integerParser.value) * i9);
                                                    skipWhitespace();
                                                    r2 = builder;
                                                    if (!consume(')')) {
                                                        this.removed = i8;
                                                    }
                                                }
                                                r2 = 0;
                                            }
                                            str2 = "Invalid or missing parameter section for pseudo class: ";
                                            c = '+';
                                            builder = builder2;
                                            skipWhitespace();
                                            r2 = builder;
                                            if (!consume(')')) {
                                                this.removed = i8;
                                                r2 = 0;
                                            }
                                        } else {
                                            r2 = str3;
                                            str2 = "Invalid or missing parameter section for pseudo class: ";
                                            c = '+';
                                        }
                                    }
                                    if (r2 == 0) {
                                        throw new CSSParseException(str2.concat(strNextIdentifier5));
                                    }
                                    PseudoClass pseudoClassAnPlusB = new PseudoClassAnPlusB(r2.enterAnim, r2.exitAnim, z, z2, simpleSelector.tag);
                                    selector.addedAttributeOrPseudo();
                                    pseudoClassRoot = pseudoClassAnPlusB;
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                    break;
                                case 6:
                                    PseudoClass pseudoClassAnPlusB2 = new PseudoClassAnPlusB(0, 1, true, false, null);
                                    selector.addedAttributeOrPseudo();
                                    pseudoClassRoot = pseudoClassAnPlusB2;
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 7:
                                    PseudoClass pseudoClassAnPlusB3 = new PseudoClassAnPlusB(0, 1, false, false, null);
                                    selector.addedAttributeOrPseudo();
                                    pseudoClassRoot = pseudoClassAnPlusB3;
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 8:
                                    PseudoClass pseudoClassAnPlusB4 = new PseudoClassAnPlusB(0, 1, true, true, simpleSelector.tag);
                                    selector.addedAttributeOrPseudo();
                                    pseudoClassRoot = pseudoClassAnPlusB4;
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 9:
                                    PseudoClass pseudoClassAnPlusB5 = new PseudoClassAnPlusB(0, 1, false, true, simpleSelector.tag);
                                    selector.addedAttributeOrPseudo();
                                    pseudoClassRoot = pseudoClassAnPlusB5;
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 10:
                                    pseudoClassRoot = new PseudoClassOnlyChild(false, null);
                                    selector.addedAttributeOrPseudo();
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 11:
                                    pseudoClassRoot = new PseudoClassOnlyChild(true, simpleSelector.tag);
                                    selector.addedAttributeOrPseudo();
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 12:
                                    pseudoClassRoot = new PseudoClassRoot(1);
                                    selector.addedAttributeOrPseudo();
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 13:
                                    if (empty()) {
                                        arrayListNextSelectorGroup = str;
                                    } else {
                                        int i13 = this.removed;
                                        if (consume('(')) {
                                            skipWhitespace();
                                            arrayListNextSelectorGroup = nextSelectorGroup();
                                            if (arrayListNextSelectorGroup != null && consume(')')) {
                                                int size = arrayListNextSelectorGroup.size();
                                                int i14 = 0;
                                                while (i14 < size) {
                                                    Object obj = arrayListNextSelectorGroup.get(i14);
                                                    i14++;
                                                    ArrayList arrayList4 = ((Selector) obj).simpleSelectors;
                                                    if (arrayList4 != null) {
                                                        int size2 = arrayList4.size();
                                                        int i15 = 0;
                                                        while (true) {
                                                            if (i15 < size2) {
                                                                Object obj2 = arrayList4.get(i15);
                                                                int i16 = i15 + 1;
                                                                ArrayList arrayList5 = ((SimpleSelector) obj2).pseudos;
                                                                if (arrayList5 == null) {
                                                                    continue;
                                                                } else {
                                                                    int size3 = arrayList5.size();
                                                                    int i17 = 0;
                                                                    while (true) {
                                                                        if (i17 < size3) {
                                                                            Object obj3 = arrayList5.get(i17);
                                                                            int i18 = i17 + 1;
                                                                            if (((PseudoClass) obj3) instanceof PseudoClassNot) {
                                                                                arrayListNextSelectorGroup = null;
                                                                            } else {
                                                                                i17 = i18;
                                                                            }
                                                                        } else {
                                                                            i15 = i16;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                this.removed = i13;
                                                arrayListNextSelectorGroup = str;
                                            }
                                        } else {
                                            arrayListNextSelectorGroup = str;
                                        }
                                    }
                                    if (arrayListNextSelectorGroup == null) {
                                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: ".concat(strNextIdentifier5));
                                    }
                                    PseudoClassNot pseudoClassNot = new PseudoClassNot();
                                    pseudoClassNot.selectorGroup = arrayListNextSelectorGroup;
                                    int size4 = arrayListNextSelectorGroup.size();
                                    int i19 = Integer.MIN_VALUE;
                                    int i20 = 0;
                                    while (i20 < size4) {
                                        Object obj4 = arrayListNextSelectorGroup.get(i20);
                                        i20++;
                                        int i21 = ((Selector) obj4).specificity;
                                        if (i21 > i19) {
                                            i19 = i21;
                                        }
                                    }
                                    selector.specificity = i19;
                                    pseudoClassRoot = pseudoClassNot;
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                    break;
                                case 14:
                                    if (!empty()) {
                                        int i22 = this.removed;
                                        if (consume('(')) {
                                            skipWhitespace();
                                            ?? arrayList6 = str;
                                            while (true) {
                                                String strNextIdentifier6 = nextIdentifier();
                                                arrayList6 = arrayList6;
                                                if (strNextIdentifier6 == null) {
                                                    this.removed = i22;
                                                } else {
                                                    if (arrayList6 == 0) {
                                                        arrayList6 = new ArrayList();
                                                    }
                                                    arrayList6.add(strNextIdentifier6);
                                                    skipWhitespace();
                                                    if (!skipCommaWhitespace()) {
                                                        if (!consume(')')) {
                                                            this.removed = i22;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    pseudoClassRoot = new PseudoClassNotSupported(strNextIdentifier5);
                                    selector.addedAttributeOrPseudo();
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                    pseudoClassRoot = new PseudoClassNotSupported(strNextIdentifier5);
                                    selector.addedAttributeOrPseudo();
                                    c = '+';
                                    if (simpleSelector.pseudos == null) {
                                        simpleSelector.pseudos = new ArrayList();
                                    }
                                    simpleSelector.pseudos.add(pseudoClassRoot);
                                    str = null;
                                    i4 = 1;
                                    i6 = 2;
                                    break;
                                default:
                                    throw new CSSParseException("Unsupported pseudo class: ".concat(strNextIdentifier5));
                            }
                        } else {
                            if (simpleSelector != 0) {
                                this.removed = i5;
                                arrayList = selector.simpleSelectors;
                                if (arrayList != null && !arrayList.isEmpty()) {
                                    arrayList2.add(selector);
                                }
                                return arrayList2;
                            }
                            if (selector.simpleSelectors == null) {
                                selector.simpleSelectors = new ArrayList();
                            }
                            selector.simpleSelectors.add(simpleSelector);
                            if (!skipCommaWhitespace()) {
                                arrayList2.add(selector);
                                selector = new Selector();
                            }
                            str = null;
                            i4 = 1;
                        }
                    }
                }
                if (simpleSelector != 0) {
                    this.removed = i5;
                    arrayList = selector.simpleSelectors;
                    if (arrayList != null) {
                        arrayList2.add(selector);
                    }
                    return arrayList2;
                }
                if (selector.simpleSelectors == null) {
                    selector.simpleSelectors = new ArrayList();
                }
                selector.simpleSelectors.add(simpleSelector);
                if (!skipCommaWhitespace()) {
                    arrayList2.add(selector);
                    selector = new Selector();
                }
                str = null;
                i4 = 1;
            }
            arrayList = selector.simpleSelectors;
            if (arrayList != null) {
                arrayList2.add(selector);
            }
            return arrayList2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class MediaType {
        public static final /* synthetic */ MediaType[] $VALUES;
        public static final MediaType all;
        public static final MediaType screen;

        static {
            MediaType mediaType = new MediaType("all", 0);
            all = mediaType;
            MediaType mediaType2 = new MediaType("aural", 1);
            MediaType mediaType3 = new MediaType("braille", 2);
            MediaType mediaType4 = new MediaType("embossed", 3);
            MediaType mediaType5 = new MediaType("handheld", 4);
            MediaType mediaType6 = new MediaType("print", 5);
            MediaType mediaType7 = new MediaType("projection", 6);
            MediaType mediaType8 = new MediaType("screen", 7);
            screen = mediaType8;
            $VALUES = new MediaType[]{mediaType, mediaType2, mediaType3, mediaType4, mediaType5, mediaType6, mediaType7, mediaType8, new MediaType("speech", 8), new MediaType("tty", 9), new MediaType("tv", 10)};
        }

        public static MediaType valueOf(String str) {
            return (MediaType) Enum.valueOf(MediaType.class, str);
        }

        public static MediaType[] values() {
            return (MediaType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface PseudoClass {
        boolean matches(SVG.SvgElementBase svgElementBase);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassAnPlusB implements PseudoClass {
        public final int a;
        public final int b;
        public final boolean isFromStart;
        public final boolean isOfType;
        public final String nodeName;

        public PseudoClassAnPlusB(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.isFromStart = z;
            this.isOfType = z2;
            this.nodeName = str;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0064 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0065 A[RETURN] */
        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public final boolean matches(SVG.SvgElementBase svgElementBase) {
            int i;
            int i2;
            boolean z = this.isOfType;
            String nodeName = this.nodeName;
            if (z && nodeName == null) {
                nodeName = svgElementBase.getNodeName();
            }
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator it = svgContainer.getChildren().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) ((SVG.SvgObject) it.next());
                    if (svgElementBase2 == svgElementBase) {
                        i = i2;
                    }
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i2++;
                    }
                }
            } else {
                i = 0;
                i2 = 1;
            }
            int i3 = this.isFromStart ? i + 1 : i2 - i;
            int i4 = this.a;
            int i5 = this.b;
            if (i4 == 0) {
                if (i3 == i5) {
                    return true;
                }
                return false;
            }
            int i6 = i3 - i5;
            if (i6 % i4 == 0 && (Integer.signum(i6) == 0 || Integer.signum(i6) == Integer.signum(i4))) {
                return true;
            }
            return false;
        }

        public final String toString() {
            String str = this.isFromStart ? "" : "last-";
            boolean z = this.isOfType;
            int i = this.b;
            int i2 = this.a;
            return z ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(i2), Integer.valueOf(i), this.nodeName) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(i2), Integer.valueOf(i));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassIdents {
        public static final /* synthetic */ PseudoClassIdents[] $VALUES;
        public static final PseudoClassIdents UNSUPPORTED;
        public static final HashMap cache;
        public static final PseudoClassIdents nth_child;
        public static final PseudoClassIdents nth_last_of_type;
        public static final PseudoClassIdents nth_of_type;

        /* JADX INFO: Fake field, exist only in values array */
        PseudoClassIdents EF0;

        static {
            PseudoClassIdents pseudoClassIdents = new PseudoClassIdents("target", 0);
            PseudoClassIdents pseudoClassIdents2 = new PseudoClassIdents("root", 1);
            PseudoClassIdents pseudoClassIdents3 = new PseudoClassIdents("nth_child", 2);
            nth_child = pseudoClassIdents3;
            PseudoClassIdents pseudoClassIdents4 = new PseudoClassIdents("nth_last_child", 3);
            PseudoClassIdents pseudoClassIdents5 = new PseudoClassIdents("nth_of_type", 4);
            nth_of_type = pseudoClassIdents5;
            PseudoClassIdents pseudoClassIdents6 = new PseudoClassIdents("nth_last_of_type", 5);
            nth_last_of_type = pseudoClassIdents6;
            PseudoClassIdents pseudoClassIdents7 = new PseudoClassIdents("first_child", 6);
            PseudoClassIdents pseudoClassIdents8 = new PseudoClassIdents("last_child", 7);
            PseudoClassIdents pseudoClassIdents9 = new PseudoClassIdents("first_of_type", 8);
            PseudoClassIdents pseudoClassIdents10 = new PseudoClassIdents("last_of_type", 9);
            PseudoClassIdents pseudoClassIdents11 = new PseudoClassIdents("only_child", 10);
            PseudoClassIdents pseudoClassIdents12 = new PseudoClassIdents("only_of_type", 11);
            PseudoClassIdents pseudoClassIdents13 = new PseudoClassIdents("empty", 12);
            PseudoClassIdents pseudoClassIdents14 = new PseudoClassIdents("not", 13);
            PseudoClassIdents pseudoClassIdents15 = new PseudoClassIdents("lang", 14);
            PseudoClassIdents pseudoClassIdents16 = new PseudoClassIdents("link", 15);
            PseudoClassIdents pseudoClassIdents17 = new PseudoClassIdents("visited", 16);
            PseudoClassIdents pseudoClassIdents18 = new PseudoClassIdents("hover", 17);
            PseudoClassIdents pseudoClassIdents19 = new PseudoClassIdents("active", 18);
            PseudoClassIdents pseudoClassIdents20 = new PseudoClassIdents("focus", 19);
            PseudoClassIdents pseudoClassIdents21 = new PseudoClassIdents("enabled", 20);
            PseudoClassIdents pseudoClassIdents22 = new PseudoClassIdents("disabled", 21);
            PseudoClassIdents pseudoClassIdents23 = new PseudoClassIdents("checked", 22);
            PseudoClassIdents pseudoClassIdents24 = new PseudoClassIdents("indeterminate", 23);
            PseudoClassIdents pseudoClassIdents25 = new PseudoClassIdents("UNSUPPORTED", 24);
            UNSUPPORTED = pseudoClassIdents25;
            $VALUES = new PseudoClassIdents[]{pseudoClassIdents, pseudoClassIdents2, pseudoClassIdents3, pseudoClassIdents4, pseudoClassIdents5, pseudoClassIdents6, pseudoClassIdents7, pseudoClassIdents8, pseudoClassIdents9, pseudoClassIdents10, pseudoClassIdents11, pseudoClassIdents12, pseudoClassIdents13, pseudoClassIdents14, pseudoClassIdents15, pseudoClassIdents16, pseudoClassIdents17, pseudoClassIdents18, pseudoClassIdents19, pseudoClassIdents20, pseudoClassIdents21, pseudoClassIdents22, pseudoClassIdents23, pseudoClassIdents24, pseudoClassIdents25};
            cache = new HashMap();
            for (PseudoClassIdents pseudoClassIdents26 : values()) {
                if (pseudoClassIdents26 != UNSUPPORTED) {
                    cache.put(pseudoClassIdents26.name().replace('_', '-'), pseudoClassIdents26);
                }
            }
        }

        public static PseudoClassIdents valueOf(String str) {
            return (PseudoClassIdents) Enum.valueOf(PseudoClassIdents.class, str);
        }

        public static PseudoClassIdents[] values() {
            return (PseudoClassIdents[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassNot implements PseudoClass {
        public List selectorGroup;

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public final boolean matches(SVG.SvgElementBase svgElementBase) {
            Iterator it = this.selectorGroup.iterator();
            while (it.hasNext()) {
                if (CSSParser.ruleMatch((Selector) it.next(), svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        public final String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassNotSupported implements PseudoClass {
        public final String clazz;

        public PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public final boolean matches(SVG.SvgElementBase svgElementBase) {
            return false;
        }

        public final String toString() {
            return this.clazz;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassOnlyChild implements PseudoClass {
        public final boolean isOfType;
        public final String nodeName;

        public PseudoClassOnlyChild(boolean z, String str) {
            this.isOfType = z;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public final boolean matches(SVG.SvgElementBase svgElementBase) {
            int i;
            boolean z = this.isOfType;
            String nodeName = this.nodeName;
            if (z && nodeName == null) {
                nodeName = svgElementBase.getNodeName();
            }
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator it = svgContainer.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) ((SVG.SvgObject) it.next());
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public final String toString() {
            return this.isOfType ? ImageAnalysis$$ExternalSyntheticLambda1.m$1("only-of-type <", this.nodeName, ">") : "only-child";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PseudoClassRoot implements PseudoClass {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ PseudoClassRoot(int i) {
            this.$r8$classId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public final boolean matches(SVG.SvgElementBase svgElementBase) {
            switch (this.$r8$classId) {
                case 0:
                    return svgElementBase.parent == null;
                case 1:
                    return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
                default:
                    return false;
            }
        }

        public final String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "root";
                case 1:
                    return "empty";
                default:
                    return "target";
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Rule {
        public Selector selector;
        public int source;
        public SVG.Style style;

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.selector));
            sb.append(" {...} (src=");
            int i = this.source;
            if (i != 1) {
                str = i != 2 ? "null" : "RenderOptions";
            } else {
                str = "Document";
            }
            sb.append(str);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Selector {
        public ArrayList simpleSelectors = null;
        public int specificity = 0;

        public final void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = this.simpleSelectors;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                sb.append((SimpleSelector) obj);
                sb.append(' ');
            }
            sb.append('[');
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.specificity, ']');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SimpleSelector {
        public final int combinator;
        public final String tag;
        public ArrayList attribs = null;
        public ArrayList pseudos = null;

        public SimpleSelector(String str, int i) {
            this.combinator = 0;
            this.tag = null;
            this.combinator = i == 0 ? 1 : i;
            this.tag = str;
        }

        public final void addAttrib(int i, String str, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(i, str, str2));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            int i = this.combinator;
            if (i == 2) {
                sb.append("> ");
            } else if (i == 3) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            ArrayList arrayList = this.attribs;
            int i2 = 0;
            if (arrayList != null) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    Attrib attrib = (Attrib) obj;
                    sb.append('[');
                    String str2 = attrib.name;
                    String str3 = attrib.value;
                    sb.append(str2);
                    int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(attrib.operation);
                    if (iOrdinal == 1) {
                        sb.append('=');
                        sb.append(str3);
                    } else if (iOrdinal == 2) {
                        sb.append("~=");
                        sb.append(str3);
                    } else if (iOrdinal == 3) {
                        sb.append("|=");
                        sb.append(str3);
                    }
                    sb.append(']');
                }
            }
            ArrayList arrayList2 = this.pseudos;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    sb.append(':');
                    sb.append((PseudoClass) obj2);
                }
            }
            return sb.toString();
        }
    }

    public static int getChildPosition(ArrayList arrayList, int i, SVG.SvgElementBase svgElementBase) {
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        Object obj = arrayList.get(i);
        SVG.SvgContainer svgContainer = svgElementBase.parent;
        if (obj != svgContainer) {
            return -1;
        }
        Iterator it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            if (((SVG.SvgObject) it.next()) == svgElementBase) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static ArrayList parseMediaList(CSSTextScanner cSSTextScanner) {
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty()) {
            String str = (String) cSSTextScanner.array;
            String strSubstring = null;
            if (!cSSTextScanner.empty()) {
                int i = cSSTextScanner.removed;
                char cCharAt = str.charAt(i);
                if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
                    cSSTextScanner.removed = i;
                } else {
                    int iAdvanceChar = cSSTextScanner.advanceChar();
                    while (true) {
                        if ((iAdvanceChar < 65 || iAdvanceChar > 90) && (iAdvanceChar < 97 || iAdvanceChar > 122)) {
                            break;
                        }
                        iAdvanceChar = cSSTextScanner.advanceChar();
                    }
                    strSubstring = str.substring(i, cSSTextScanner.removed);
                }
            }
            if (strSubstring == null) {
                break;
            }
            try {
                arrayList.add(MediaType.valueOf(strSubstring));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    public static boolean ruleMatch(Selector selector, int i, ArrayList arrayList, int i2, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = (SimpleSelector) selector.simpleSelectors.get(i);
        if (!selectorMatch(simpleSelector, svgElementBase)) {
            return false;
        }
        int i3 = simpleSelector.combinator;
        if (i3 == 1) {
            if (i != 0) {
                while (i2 >= 0) {
                    if (!ruleMatchOnAncestors(selector, i - 1, arrayList, i2)) {
                        i2--;
                    }
                }
                return false;
            }
            return true;
        }
        if (i3 == 2) {
            return ruleMatchOnAncestors(selector, i - 1, arrayList, i2);
        }
        int childPosition = getChildPosition(arrayList, i2, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i - 1, arrayList, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    public static boolean ruleMatchOnAncestors(Selector selector, int i, ArrayList arrayList, int i2) {
        SimpleSelector simpleSelector = (SimpleSelector) selector.simpleSelectors.get(i);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) arrayList.get(i2);
        if (!selectorMatch(simpleSelector, svgElementBase)) {
            return false;
        }
        int i3 = simpleSelector.combinator;
        if (i3 == 1) {
            if (i != 0) {
                while (i2 > 0) {
                    i2--;
                    if (ruleMatchOnAncestors(selector, i - 1, arrayList, i2)) {
                    }
                }
                return false;
            }
            return true;
        }
        if (i3 == 2) {
            return ruleMatchOnAncestors(selector, i - 1, arrayList, i2 - 1);
        }
        int childPosition = getChildPosition(arrayList, i2, svgElementBase);
        if (childPosition <= 0) {
            return false;
        }
        return ruleMatch(selector, i - 1, arrayList, i2, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x006d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x006c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[LOOP:1: B:28:0x005c->B:46:?, LOOP_END, SYNTHETIC] */
    public static boolean selectorMatch(SimpleSelector simpleSelector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList;
        int size;
        int i;
        Object obj;
        ArrayList arrayList2;
        String str = simpleSelector.tag;
        if (str == null || str.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            ArrayList arrayList3 = simpleSelector.attribs;
            if (arrayList3 == null) {
                arrayList = simpleSelector.pseudos;
                if (arrayList != null) {
                    return true;
                }
                size = arrayList.size();
                i = 0;
                while (i < size) {
                    obj = arrayList.get(i);
                    i++;
                    if (!((PseudoClass) obj).matches(svgElementBase)) {
                    }
                }
                return true;
            }
            int size2 = arrayList3.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList3.get(i2);
                i2++;
                Attrib attrib = (Attrib) obj2;
                String str2 = attrib.name;
                String str3 = attrib.value;
                if (str2.equals("id")) {
                    if (!str3.equals(svgElementBase.id)) {
                    }
                } else if (str2.equals("class") && (arrayList2 = svgElementBase.classNames) != null && arrayList2.contains(str3)) {
                }
            }
            arrayList = simpleSelector.pseudos;
            if (arrayList != null) {
                return true;
            }
            size = arrayList.size();
            i = 0;
            while (i < size) {
                obj = arrayList.get(i);
                i++;
                if (!((PseudoClass) obj).matches(svgElementBase)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
        this.inMediaRule = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd() {
        if (this.inMediaRule) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.deviceMediaType;
        actionBarContextView.mVisibilityAnim = null;
        super/*android.view.ViewGroup*/.setVisibility(this.source);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.inMediaRule = false;
    }

    public void parseAtRule(ConnectionPool connectionPool, CSSTextScanner cSSTextScanner) throws CSSParseException {
        int iIntValue;
        char cCharAt;
        int iHexChar;
        String strNextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (strNextIdentifier == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        int i = 0;
        if (!this.inMediaRule && strNextIdentifier.equals("media")) {
            ArrayList mediaList = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.consume('{')) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.skipWhitespace();
            MediaType mediaType = (MediaType) this.deviceMediaType;
            int size = mediaList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    parseRuleset(cSSTextScanner);
                    break;
                }
                Object obj = mediaList.get(i2);
                i2++;
                MediaType mediaType2 = (MediaType) obj;
                if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                    this.inMediaRule = true;
                    connectionPool.addAll(parseRuleset(cSSTextScanner));
                    this.inMediaRule = false;
                    break;
                }
            }
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume('}')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (this.inMediaRule || !strNextIdentifier.equals("import")) {
            Log.w("CSSParser", "Ignoring @" + strNextIdentifier + " rule");
            while (!cSSTextScanner.empty() && ((iIntValue = cSSTextScanner.nextChar().intValue()) != 59 || i != 0)) {
                if (iIntValue != 123) {
                    if (iIntValue == 125 && i > 0 && (i = i - 1) == 0) {
                        break;
                    }
                } else {
                    i++;
                }
            }
        } else {
            String strNextCSSString = null;
            if (!cSSTextScanner.empty()) {
                int i3 = cSSTextScanner.removed;
                if (cSSTextScanner.consume("url(")) {
                    cSSTextScanner.skipWhitespace();
                    String strNextCSSString2 = cSSTextScanner.nextCSSString();
                    if (strNextCSSString2 == null) {
                        String str = (String) cSSTextScanner.array;
                        StringBuilder sb = new StringBuilder();
                        while (!cSSTextScanner.empty() && (cCharAt = str.charAt(cSSTextScanner.removed)) != '\'' && cCharAt != '\"' && cCharAt != '(' && cCharAt != ')' && !LogcatCache.isWhitespace(cCharAt) && !Character.isISOControl((int) cCharAt)) {
                            cSSTextScanner.removed++;
                            if (cCharAt == '\\') {
                                if (!cSSTextScanner.empty()) {
                                    int i4 = cSSTextScanner.removed;
                                    cSSTextScanner.removed = i4 + 1;
                                    cCharAt = str.charAt(i4);
                                    if (cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\f') {
                                        int iHexChar2 = CSSTextScanner.hexChar(cCharAt);
                                        if (iHexChar2 != -1) {
                                            for (int i5 = 1; i5 <= 5 && !cSSTextScanner.empty() && (iHexChar = CSSTextScanner.hexChar(str.charAt(cSSTextScanner.removed))) != -1; i5++) {
                                                cSSTextScanner.removed++;
                                                iHexChar2 = (iHexChar2 * 16) + iHexChar;
                                            }
                                            sb.append((char) iHexChar2);
                                        }
                                    }
                                }
                            }
                            sb.append(cCharAt);
                        }
                        strNextCSSString2 = sb.length() == 0 ? null : sb.toString();
                    }
                    if (strNextCSSString2 == null) {
                        cSSTextScanner.removed = i3;
                    } else {
                        cSSTextScanner.skipWhitespace();
                        if (cSSTextScanner.empty() || cSSTextScanner.consume(")")) {
                            strNextCSSString = strNextCSSString2;
                        } else {
                            cSSTextScanner.removed = i3;
                        }
                    }
                }
            }
            if (strNextCSSString == null) {
                strNextCSSString = cSSTextScanner.nextCSSString();
            }
            if (strNextCSSString == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            cSSTextScanner.skipWhitespace();
            parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        }
        cSSTextScanner.skipWhitespace();
    }

    public boolean parseRule(ConnectionPool connectionPool, CSSTextScanner cSSTextScanner) throws CSSParseException {
        ArrayList arrayListNextSelectorGroup = cSSTextScanner.nextSelectorGroup();
        int i = 0;
        if (arrayListNextSelectorGroup == null || arrayListNextSelectorGroup.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.consume('{')) {
            throw new CSSParseException("Malformed rule block: expected '{'");
        }
        cSSTextScanner.skipWhitespace();
        SVG.Style style = new SVG.Style();
        do {
            String strNextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(':')) {
                throw new CSSParseException("Expected ':'");
            }
            cSSTextScanner.skipWhitespace();
            String str = (String) cSSTextScanner.array;
            String strSubstring = null;
            if (!cSSTextScanner.empty()) {
                int i2 = cSSTextScanner.removed;
                int iCharAt = str.charAt(i2);
                int i3 = i2;
                while (iCharAt != -1 && iCharAt != 59 && iCharAt != 125 && iCharAt != 33 && iCharAt != 10 && iCharAt != 13) {
                    if (!LogcatCache.isWhitespace(iCharAt)) {
                        i3 = cSSTextScanner.removed + 1;
                    }
                    iCharAt = cSSTextScanner.advanceChar();
                }
                if (cSSTextScanner.removed > i2) {
                    strSubstring = str.substring(i2, i3);
                } else {
                    cSSTextScanner.removed = i2;
                }
            }
            if (strSubstring == null) {
                throw new CSSParseException("Expected property value");
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (!cSSTextScanner.consume("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                cSSTextScanner.skipWhitespace();
            }
            cSSTextScanner.consume(';');
            SVGParser.processStyleProperty(style, strNextIdentifier, strSubstring);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.empty()) {
                break;
            }
        } while (!cSSTextScanner.consume('}'));
        cSSTextScanner.skipWhitespace();
        int size = arrayListNextSelectorGroup.size();
        while (i < size) {
            Object obj = arrayListNextSelectorGroup.get(i);
            i++;
            int i4 = this.source;
            Rule rule = new Rule();
            rule.selector = (Selector) obj;
            rule.style = style;
            rule.source = i4;
            connectionPool.add(rule);
        }
        return true;
    }

    public ConnectionPool parseRuleset(CSSTextScanner cSSTextScanner) {
        ConnectionPool connectionPool = new ConnectionPool(2);
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                    if (!cSSTextScanner.consume('@')) {
                        if (!parseRule(connectionPool, cSSTextScanner)) {
                            break;
                        }
                    } else {
                        parseAtRule(connectionPool, cSSTextScanner);
                    }
                }
            } catch (CSSParseException e) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e.getMessage());
                return connectionPool;
            }
        }
        return connectionPool;
    }

    public void zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(Object obj) {
        obj.getClass();
        zzd(this.source + 1);
        Object[] objArr = (Object[]) this.deviceMediaType;
        int i = this.source;
        this.source = i + 1;
        objArr[i] = obj;
    }

    public void zzd(int i) {
        Object[] objArr = (Object[]) this.deviceMediaType;
        int length = objArr.length;
        if (length >= i) {
            if (this.inMediaRule) {
                this.deviceMediaType = (Object[]) objArr.clone();
                this.inMediaRule = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.deviceMediaType = Arrays.copyOf(objArr, i2);
        this.inMediaRule = false;
    }

    public zzdk zzf() {
        this.inMediaRule = true;
        Object[] objArr = (Object[]) this.deviceMediaType;
        int i = this.source;
        zzcq zzcqVar = zzcs.zza;
        return i == 0 ? zzdk.zza : new zzdk(i, objArr);
    }

    public static boolean ruleMatch(Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        Object obj = svgElementBase.parent;
        while (true) {
            if (obj == null) {
                break;
            }
            arrayList.add(0, obj);
            obj = ((SVG.SvgObject) obj).parent;
        }
        int size = arrayList.size() - 1;
        ArrayList arrayList2 = selector.simpleSelectors;
        if ((arrayList2 == null ? 0 : arrayList2.size()) == 1) {
            return selectorMatch((SimpleSelector) selector.simpleSelectors.get(0), svgElementBase);
        }
        ArrayList arrayList3 = selector.simpleSelectors;
        return ruleMatch(selector, (arrayList3 != null ? arrayList3.size() : 0) - 1, arrayList, size, svgElementBase);
    }
}
