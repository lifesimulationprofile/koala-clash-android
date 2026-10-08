package androidx.compose.ui.text.platform;

import android.text.style.ClickableSpan;
import android.view.View;
import androidx.compose.ui.text.LinkAnnotation;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeClickableSpan extends ClickableSpan {
    public final LinkAnnotation link;

    public ComposeClickableSpan(LinkAnnotation linkAnnotation) {
        this.link = linkAnnotation;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.link.getClass();
    }
}
