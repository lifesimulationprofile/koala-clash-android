package com.github.kr328.clash;

import android.util.SparseIntArray;
import androidx.databinding.DataBinderMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    static {
        new SparseIntArray(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.common.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.core.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.design.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.service.DataBinderMapperImpl());
        return arrayList;
    }
}
