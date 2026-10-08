package com.google.firebase.encoders;

import androidx.work.impl.WorkLauncherImpl;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FieldDescriptor {
    public final String name;
    public final Map properties;

    public FieldDescriptor(String str, Map map) {
        this.name = str;
        this.properties = map;
    }

    public static WorkLauncherImpl builder(String str) {
        return new WorkLauncherImpl(str, 21);
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
    }

    public final int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }
}
