package kotlinx.serialization;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class UnknownFieldException extends SerializationException {
    public UnknownFieldException(int i) {
        super(ImageAnalysis$$ExternalSyntheticLambda1.m("An unknown field for index ", i));
    }
}
