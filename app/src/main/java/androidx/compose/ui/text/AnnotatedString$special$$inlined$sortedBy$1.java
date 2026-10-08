package androidx.compose.ui.text;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedString$special$$inlined$sortedBy$1 implements Comparator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AnnotatedString$special$$inlined$sortedBy$1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) obj).start), Integer.valueOf(((AnnotatedString.Range) obj2).start));
    }
}
