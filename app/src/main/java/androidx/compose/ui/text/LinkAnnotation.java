package androidx.compose.ui.text;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LinkAnnotation implements AnnotatedString.Annotation {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Clickable extends LinkAnnotation {
        public final TextLinkStyles styles;
        public final String tag;

        public Clickable(String str, TextLinkStyles textLinkStyles) {
            this.tag = str;
            this.styles = textLinkStyles;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Clickable)) {
                return false;
            }
            Clickable clickable = (Clickable) obj;
            return Intrinsics.areEqual(this.tag, clickable.tag) && Intrinsics.areEqual(this.styles, clickable.styles);
        }

        public final int hashCode() {
            int iHashCode = this.tag.hashCode() * 31;
            TextLinkStyles textLinkStyles = this.styles;
            return (iHashCode + (textLinkStyles != null ? textLinkStyles.hashCode() : 0)) * 31;
        }

        public final String toString() {
            return Modifier.CC.m(new StringBuilder("LinkAnnotation.Clickable(tag="), this.tag, ')');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Url extends LinkAnnotation {
        public final TextLinkStyles styles;
        public final String url;

        public Url(String str, TextLinkStyles textLinkStyles) {
            this.url = str;
            this.styles = textLinkStyles;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.url, url.url) && Intrinsics.areEqual(this.styles, url.styles);
        }

        public final int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            TextLinkStyles textLinkStyles = this.styles;
            return (iHashCode + (textLinkStyles != null ? textLinkStyles.hashCode() : 0)) * 31;
        }

        public final String toString() {
            return Modifier.CC.m(new StringBuilder("LinkAnnotation.Url(url="), this.url, ')');
        }
    }
}
