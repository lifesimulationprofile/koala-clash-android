package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewOffsetBehavior extends CoordinatorLayout.Behavior {
    public ViewOffsetHelper viewOffsetHelper;

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.onLayoutChild(view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        layoutChild(coordinatorLayout, view, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(view);
        }
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        View view2 = viewOffsetHelper.view;
        viewOffsetHelper.layoutTop = view2.getTop();
        viewOffsetHelper.layoutLeft = view2.getLeft();
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        View view3 = viewOffsetHelper2.view;
        int top = 0 - (view3.getTop() - viewOffsetHelper2.layoutTop);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - viewOffsetHelper2.layoutLeft));
        return true;
    }
}
