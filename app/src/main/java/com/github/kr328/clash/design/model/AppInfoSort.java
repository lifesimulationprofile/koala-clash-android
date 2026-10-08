package com.github.kr328.clash.design.model;

import androidx.recyclerview.widget.GapWorker;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public enum AppInfoSort implements Comparator {
    Label(new GapWorker.AnonymousClass1(3)),
    PackageName(new GapWorker.AnonymousClass1(4)),
    InstallTime(new GapWorker.AnonymousClass1(5)),
    UpdateTime(new GapWorker.AnonymousClass1(6));

    public final /* synthetic */ Comparator $$delegate_0;

    AppInfoSort(Comparator comparator) {
        this.$$delegate_0 = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.$$delegate_0.compare((AppInfo) obj, (AppInfo) obj2);
    }
}
