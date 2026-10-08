package kotlinx.serialization.descriptors;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassSerialDescriptorBuilder {
    public final String serialName;
    public final ArrayList elementNames = new ArrayList();
    public final HashSet uniqueNames = new HashSet();
    public final ArrayList elementDescriptors = new ArrayList();
    public final ArrayList elementAnnotations = new ArrayList();
    public final ArrayList elementOptionality = new ArrayList();

    public ClassSerialDescriptorBuilder(String str) {
        this.serialName = str;
    }

    public static void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor) {
        if (!classSerialDescriptorBuilder.uniqueNames.add(str)) {
            StringBuilder sbM13m = ImageAnalysis$$ExternalSyntheticLambda1.m13m("Element with name '", str, "' is already registered in ");
            sbM13m.append(classSerialDescriptorBuilder.serialName);
            throw new IllegalArgumentException(sbM13m.toString().toString());
        }
        classSerialDescriptorBuilder.elementNames.add(str);
        classSerialDescriptorBuilder.elementDescriptors.add(serialDescriptor);
        classSerialDescriptorBuilder.elementAnnotations.add(EmptyList.INSTANCE);
        classSerialDescriptorBuilder.elementOptionality.add(false);
    }
}
