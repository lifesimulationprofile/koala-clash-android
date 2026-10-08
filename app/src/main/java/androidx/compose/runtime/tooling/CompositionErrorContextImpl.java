package androidx.compose.runtime.tooling;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.room.TransactionElement;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionErrorContextImpl implements OperationErrorContext, CoroutineContext.Element {
    public static final TransactionElement.Key Key = new TransactionElement.Key(6);
    public final GapComposer composer;

    public CompositionErrorContextImpl(GapComposer gapComposer) {
        this.composer = gapComposer;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public final List buildStackTrace(Integer num) {
        return this.composer.parentStackTrace$runtime();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Key;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public final boolean getSourceInformationEnabled() {
        return this.composer.sourceMarkersEnabled;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }
}
