package androidx.work.impl.constraints.controllers;

import androidx.navigation.NavDestinationBuilder;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintController {
    public final NavDestinationBuilder tracker;

    public ConstraintController(NavDestinationBuilder navDestinationBuilder) {
        this.tracker = navDestinationBuilder;
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(Object obj);
}
