package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.Saver;
import androidx.work.impl.WorkLauncherImpl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SaversKt {
    public static final WorkLauncherImpl AnnotationRangeListSaver;
    public static final WorkLauncherImpl AnnotationRangeSaver;
    public static final WorkLauncherImpl BaselineShiftSaver;
    public static final WorkLauncherImpl ClickableSaver;
    public static final SaversKt$NonNullValueClassSaver$1 ColorSaver;
    public static final WorkLauncherImpl FontStyleSaver;
    public static final WorkLauncherImpl FontSynthesisSaver;
    public static final WorkLauncherImpl FontWeightSaver;
    public static final SaversKt$NonNullValueClassSaver$1 HyphensSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleAlignmentSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleModeSaver;
    public static final WorkLauncherImpl LineHeightStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 LineHeightStyleTrimSaver;
    public static final WorkLauncherImpl LinkSaver;
    public static final WorkLauncherImpl LocaleListSaver;
    public static final WorkLauncherImpl LocaleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 OffsetSaver;
    public static final WorkLauncherImpl ParagraphStyleSaver;
    public static final WorkLauncherImpl ShadowSaver;
    public static final WorkLauncherImpl SpanStyleSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextAlignSaver;
    public static final WorkLauncherImpl TextDecorationSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextDirectionSaver;
    public static final WorkLauncherImpl TextGeometricTransformSaver;
    public static final WorkLauncherImpl TextIndentSaver;
    public static final WorkLauncherImpl TextLinkStylesSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitSaver;
    public static final SaversKt$NonNullValueClassSaver$1 TextUnitTypeSaver;
    public static final WorkLauncherImpl UrlAnnotationSaver;
    public static final WorkLauncherImpl VerbatimTtsAnnotationSaver;

    static {
        int i = 10;
        new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(0), new SaversKt$$ExternalSyntheticLambda10(26));
        AnnotationRangeListSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(2), new SaversKt$$ExternalSyntheticLambda2(8));
        AnnotationRangeSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(13), new SaversKt$$ExternalSyntheticLambda2(20));
        VerbatimTtsAnnotationSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(20), new SaversKt$$ExternalSyntheticLambda2(22));
        UrlAnnotationSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(22), new SaversKt$$ExternalSyntheticLambda2(23));
        LinkSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(29), new SaversKt$$ExternalSyntheticLambda2(0));
        ClickableSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(0), new SaversKt$$ExternalSyntheticLambda2(16));
        ParagraphStyleSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(21), new SaversKt$$ExternalSyntheticLambda2(24));
        SpanStyleSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(23), new SaversKt$$ExternalSyntheticLambda2(25));
        TextLinkStylesSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(24), new SaversKt$$ExternalSyntheticLambda10(0));
        TextDecorationSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(25), new SaversKt$$ExternalSyntheticLambda10(27));
        TextGeometricTransformSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(26), new SaversKt$$ExternalSyntheticLambda10(28));
        TextIndentSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(27), new SaversKt$$ExternalSyntheticLambda10(29));
        FontWeightSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda0(28), new SaversKt$$ExternalSyntheticLambda2(1));
        BaselineShiftSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(1), new SaversKt$$ExternalSyntheticLambda2(2));
        new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(3), new SaversKt$$ExternalSyntheticLambda2(3));
        ShadowSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(4), new SaversKt$$ExternalSyntheticLambda2(4));
        ColorSaver = new SaversKt$NonNullValueClassSaver$1(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);
        TextAlignSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(5), new SaversKt$$ExternalSyntheticLambda2(5));
        TextDirectionSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(6), new SaversKt$$ExternalSyntheticLambda2(6));
        HyphensSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(7), new SaversKt$$ExternalSyntheticLambda2(7));
        FontStyleSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(8), new SaversKt$$ExternalSyntheticLambda2(9));
        FontSynthesisSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(9), new SaversKt$$ExternalSyntheticLambda2(10));
        TextUnitSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(10), new SaversKt$$ExternalSyntheticLambda2(11));
        TextUnitTypeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(11), new SaversKt$$ExternalSyntheticLambda2(12));
        OffsetSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(12), new SaversKt$$ExternalSyntheticLambda2(13));
        LocaleListSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(14), new SaversKt$$ExternalSyntheticLambda2(14));
        LocaleSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(15), new SaversKt$$ExternalSyntheticLambda2(15));
        LineHeightStyleSaver = new WorkLauncherImpl(i, new SaversKt$$ExternalSyntheticLambda3(16), new SaversKt$$ExternalSyntheticLambda2(17));
        LineHeightStyleAlignmentSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(17), new SaversKt$$ExternalSyntheticLambda2(18));
        LineHeightStyleTrimSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(18), new SaversKt$$ExternalSyntheticLambda2(19));
        LineHeightStyleModeSaver = new SaversKt$NonNullValueClassSaver$1(new SaversKt$$ExternalSyntheticLambda3(19), new SaversKt$$ExternalSyntheticLambda2(21));
    }

    public static final Object save(Object obj, Saver saver, SaveableHolder saveableHolder) {
        Object objSave;
        return (obj == null || (objSave = saver.save(saveableHolder, obj)) == null) ? Boolean.FALSE : objSave;
    }
}
