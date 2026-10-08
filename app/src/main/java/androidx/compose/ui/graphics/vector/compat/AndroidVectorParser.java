package androidx.compose.ui.graphics.vector.compat;

import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.content.res.CamUtils;
import coil.disk.RealDiskCache;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidVectorParser {
    public int config = 0;
    public final RealDiskCache.RealEditor pathParser;
    public final XmlPullParser xmlParser;

    public AndroidVectorParser(XmlResourceParser xmlResourceParser) {
        this.xmlParser = xmlResourceParser;
        RealDiskCache.RealEditor realEditor = new RealDiskCache.RealEditor(7, false);
        realEditor.editor = new float[64];
        this.pathParser = realEditor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return Intrinsics.areEqual(this.xmlParser, androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public final float getNamedFloat(TypedArray typedArray, String str, int i, float f) {
        if (CamUtils.hasAttribute(this.xmlParser, str)) {
            f = typedArray.getFloat(i, f);
        }
        updateConfig(typedArray.getChangingConfigurations());
        return f;
    }

    public final int hashCode() {
        return (this.xmlParser.hashCode() * 31) + this.config;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidVectorParser(xmlParser=");
        sb.append(this.xmlParser);
        sb.append(", config=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.config, ')');
    }

    public final void updateConfig(int i) {
        this.config = i | this.config;
    }
}
