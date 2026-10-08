package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.tasks.zzs;
import com.google.android.material.chip.ChipGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CheckableGroup {
    public final Object checkables;
    public final Serializable checkedIds;
    public Object onCheckedStateChangeListener;
    public boolean selectionRequired;
    public boolean singleSelection;

    public CheckableGroup() {
        this.checkables = new HashMap();
        this.checkedIds = new HashSet();
    }

    public boolean checkInternal(MaterialCheckable materialCheckable) {
        int id = materialCheckable.getId();
        HashSet hashSet = (HashSet) this.checkedIds;
        if (hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) ((HashMap) this.checkables).get(Integer.valueOf(getSingleCheckedId()));
        if (materialCheckable2 != null) {
            uncheckInternal(materialCheckable2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return zAdd;
    }

    public ArrayList getCheckedIdsSortedByChildOrder(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet((HashSet) this.checkedIds);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MaterialCheckable) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int getSingleCheckedId() {
        HashSet hashSet = (HashSet) this.checkedIds;
        if (!this.singleSelection || hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public void onCheckedStateChanged() {
        ConnectionPool connectionPool = (ConnectionPool) this.onCheckedStateChangeListener;
        if (connectionPool != null) {
            new HashSet((HashSet) this.checkedIds);
            ChipGroup chipGroup = (ChipGroup) connectionPool.delegate;
            ChipGroup.OnCheckedStateChangeListener onCheckedStateChangeListener = chipGroup.onCheckedStateChangeListener;
            if (onCheckedStateChangeListener != null) {
                chipGroup.checkableGroup.getCheckedIdsSortedByChildOrder(chipGroup);
                ChipGroup chipGroup2 = (ChipGroup) ((zzs) onCheckedStateChangeListener).zza;
                if (chipGroup2.checkableGroup.singleSelection) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public boolean uncheckInternal(MaterialCheckable materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        HashSet hashSet = (HashSet) this.checkedIds;
        if (!hashSet.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return zRemove;
    }

    public CheckableGroup(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z, boolean z2) {
        this.checkables = context;
        this.checkedIds = str;
        this.onCheckedStateChangeListener = roomOpenHelper;
        this.singleSelection = z;
        this.selectionRequired = z2;
    }
}
