package com.github.kr328.clash;

import com.github.kr328.clash.design.model.LogFile;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LogsActivity$loadFiles$$inlined$sortedByDescending$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.compareValues(((LogFile) obj2).date, ((LogFile) obj).date);
    }
}
