package androidx.databinding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class MergedDataBinderMapper extends DataBinderMapper {
    public final HashSet mExistingMappers = new HashSet();
    public final CopyOnWriteArrayList mMappers = new CopyOnWriteArrayList();

    public MergedDataBinderMapper() {
        new CopyOnWriteArrayList();
    }

    public final void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add(dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            Iterator it = dataBinderMapper.collectDependencies().iterator();
            while (it.hasNext()) {
                addMapper((DataBinderMapper) it.next());
            }
        }
    }
}
