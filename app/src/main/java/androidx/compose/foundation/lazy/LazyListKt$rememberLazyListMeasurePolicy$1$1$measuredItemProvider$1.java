package androidx.compose.foundation.lazy;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 {
    public final /* synthetic */ int $afterContentPadding;
    public final /* synthetic */ int $beforeContentPadding;
    public final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    public final /* synthetic */ int $itemsCount;
    public final /* synthetic */ boolean $reverseLayout;
    public final /* synthetic */ int $spaceBetweenItems;
    public final /* synthetic */ LazyListState $state;
    public final /* synthetic */ LazyLayoutMeasureScopeImpl $this_LazyLayoutMeasurePolicy;
    public final /* synthetic */ long $visualItemOffset;
    public final long childConstraints;
    public final LazyListItemProviderImpl itemProvider;
    public final LazyLayoutMeasureScopeImpl measureScope;
    public final MutableIntObjectMap placeablesCache;

    public LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(long j, LazyListItemProviderImpl lazyListItemProviderImpl, LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl, int i, int i2, Alignment.Horizontal horizontal, boolean z, int i3, int i4, long j2, LazyListState lazyListState) {
        this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScopeImpl;
        this.$itemsCount = i;
        this.$spaceBetweenItems = i2;
        this.$horizontalAlignment = horizontal;
        this.$reverseLayout = z;
        this.$beforeContentPadding = i3;
        this.$afterContentPadding = i4;
        this.$visualItemOffset = j2;
        this.$state = lazyListState;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.placeablesCache = new MutableIntObjectMap();
        this.itemProvider = lazyListItemProviderImpl;
        this.measureScope = lazyLayoutMeasureScopeImpl;
        this.childConstraints = ConstraintsKt.Constraints$default(0, Constraints.m681getMaxWidthimpl(j), 0, Integer.MAX_VALUE, 5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: getAndMeasure-0kLqBqw, reason: not valid java name */
    public final LazyListMeasuredItem m144getAndMeasure0kLqBqw(int i, long j) {
        LazyListItemProviderImpl lazyListItemProviderImpl = this.itemProvider;
        Object key = lazyListItemProviderImpl.getKey(i);
        Object contentType = lazyListItemProviderImpl.getContentType(i);
        MutableIntObjectMap mutableIntObjectMap = this.placeablesCache;
        List list = (List) mutableIntObjectMap.get(i);
        if (list == null) {
            LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl = this.measureScope;
            LazyListItemProviderImpl lazyListItemProviderImpl2 = lazyLayoutMeasureScopeImpl.itemProvider;
            MutableIntObjectMap mutableIntObjectMap2 = lazyLayoutMeasureScopeImpl.measurablesCache;
            List listSubcompose = (List) mutableIntObjectMap2.get(i);
            if (listSubcompose == null) {
                Object key2 = lazyListItemProviderImpl2.getKey(i);
                listSubcompose = lazyLayoutMeasureScopeImpl.subcomposeMeasureScope.subcompose(key2, lazyLayoutMeasureScopeImpl.itemContentFactory.getContent(i, key2, lazyListItemProviderImpl2.getContentType(i)));
                mutableIntObjectMap2.set(i, listSubcompose);
            }
            int size = listSubcompose.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((Measurable) listSubcompose.get(i2)).mo515measureBRTryo0(j));
            }
            mutableIntObjectMap.set(i, arrayList);
            list = arrayList;
        }
        return new LazyListMeasuredItem(i, list, this.$horizontalAlignment, this.$this_LazyLayoutMeasurePolicy.subcomposeMeasureScope.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i != this.$itemsCount + (-1) ? this.$spaceBetweenItems : 0, this.$visualItemOffset, key, contentType, this.$state.itemAnimator, j);
    }
}
