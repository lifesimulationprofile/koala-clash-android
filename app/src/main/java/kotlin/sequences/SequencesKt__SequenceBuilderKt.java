package kotlin.sequences;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzgn;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SequencesKt__SequenceBuilderKt {
    public static ImageVector _keyboardArrowRight;

    public static final ImageVector getKeyboardArrowRight() {
        ImageVector imageVector = _keyboardArrowRight;
        if (imageVector != null) {
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.KeyboardArrowRight", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
        int i = VectorKt.$r8$clinit;
        SolidColor solidColor = new SolidColor(Color.Black);
        ArrayList arrayList = new ArrayList(32);
        arrayList.add(new PathNode.MoveTo(8.59f, 16.59f));
        arrayList.add(new PathNode.LineTo(13.17f, 12.0f));
        arrayList.add(new PathNode.LineTo(8.59f, 7.41f));
        arrayList.add(new PathNode.LineTo(10.0f, 6.0f));
        arrayList.add(new PathNode.RelativeLineTo(6.0f, 6.0f));
        arrayList.add(new PathNode.RelativeLineTo(-6.0f, 6.0f));
        arrayList.add(new PathNode.RelativeLineTo(-1.41f, -1.41f));
        arrayList.add(PathNode.Close.INSTANCE);
        ImageVector.Builder.m500addPathoIyEayM$default(builder, arrayList, solidColor);
        ImageVector imageVectorBuild = builder.build();
        _keyboardArrowRight = imageVectorBuild;
        return imageVectorBuild;
    }

    public static SequenceBuilderIterator iterator(Function2 function2) {
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.nextStep = zzgn.createCoroutineUnintercepted(sequenceBuilderIterator, sequenceBuilderIterator, function2);
        return sequenceBuilderIterator;
    }
}
