package com.google.firebase.components;

import androidx.appcompat.widget.TooltipCompat;
import androidx.compose.foundation.style.InteractionSet;
import androidx.room.RoomOpenHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Component {
    public final Set dependencies;
    public final ComponentFactory factory;
    public final Set providedInterfaces;
    public final Set publishedEvents;
    public final int type;

    public Component(HashSet hashSet, HashSet hashSet2, int i, ComponentFactory componentFactory, HashSet hashSet3) {
        this.providedInterfaces = Collections.unmodifiableSet(hashSet);
        this.dependencies = Collections.unmodifiableSet(hashSet2);
        this.type = i;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(hashSet3);
    }

    public static RoomOpenHelper builder(Class cls) {
        return new RoomOpenHelper(cls, new Class[0]);
    }

    public static Component of(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            TooltipCompat.checkNotNull(cls2, "Null interface");
        }
        Collections.addAll(hashSet, clsArr);
        return new Component(new HashSet(hashSet), new HashSet(hashSet2), 0, new InteractionSet(obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{0, type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }
}
