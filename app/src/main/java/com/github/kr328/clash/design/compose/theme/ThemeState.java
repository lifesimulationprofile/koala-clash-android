package com.github.kr328.clash.design.compose.theme;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.design.model.DarkMode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ThemeState {
    public static final ParcelableSnapshotMutableState state$delegate = Stack.mutableStateOf$default(DarkMode.Auto);
}
