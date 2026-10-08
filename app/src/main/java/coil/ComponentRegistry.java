package coil;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentRegistry {
    public final List decoderFactories;
    public final List fetcherFactories;
    public final List interceptors;
    public final List keyers;
    public final List mappers;

    public ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.fetcherFactories = list4;
        this.decoderFactories = list5;
    }
}
