package androidx.compose.ui.text.android.selection;

import com.google.android.gms.internal.mlkit_vision_barcode.zztt;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderUnderApi29 extends zztt {
    public final BreakIterator breakIterator;

    public GraphemeClusterSegmentFinderUnderApi29(CharSequence charSequence) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.breakIterator = characterInstance;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztt
    public final int next(int i) {
        return this.breakIterator.following(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztt
    public final int previous(int i) {
        return this.breakIterator.preceding(i);
    }
}
