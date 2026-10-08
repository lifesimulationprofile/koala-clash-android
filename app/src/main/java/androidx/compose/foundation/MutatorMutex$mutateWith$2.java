package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MutatorMutex$mutateWith$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ Object $priority;
    public final /* synthetic */ int $r8$classId = 2;
    public Object $receiver;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutateWith$2(Context context, UUID uuid, Continuation continuation) {
        super(2, continuation);
        this.$priority = uuid;
        this.$block = context;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2((MutatePriority) this.$priority, (MutatorMutex) this.this$0, (SuspendLambda) this.$block, (DefaultScrollableState$scrollScope$1) this.$receiver, continuation);
                mutatorMutex$mutateWith$2.L$0 = obj;
                return mutatorMutex$mutateWith$2;
            case 1:
                MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$3 = new MutatorMutex$mutateWith$2((Map) this.L$0, (MutableState) this.L$3, (MutableState) this.$receiver, (MutableState) this.L$4, (MutableState) this.this$0, (ParcelableSnapshotMutableLongState) this.$priority, (ParcelableSnapshotMutableLongState) this.$block, continuation);
                mutatorMutex$mutateWith$3.L$2 = obj;
                return mutatorMutex$mutateWith$3;
            default:
                return new MutatorMutex$mutateWith$2((Context) this.$block, (UUID) this.$priority, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0351 A[Catch: Exception -> 0x02d4, TRY_ENTER, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0361  */
    /* JADX WARN: Code duplicated, block: B:138:0x038d A[Catch: Exception -> 0x02d4, LOOP:0: B:136:0x0387->B:138:0x038d, LOOP_END, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:142:0x03b2 A[Catch: Exception -> 0x02d4, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:144:0x03bf A[Catch: Exception -> 0x02d4, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:148:0x03cb A[Catch: Exception -> 0x02d4, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:150:0x03d7 A[Catch: Exception -> 0x02d4, TryCatch #8 {Exception -> 0x02d4, blocks: (B:132:0x0351, B:135:0x0363, B:136:0x0387, B:138:0x038d, B:139:0x0399, B:140:0x03ac, B:142:0x03b2, B:144:0x03bf, B:146:0x03c5, B:148:0x03cb, B:150:0x03d7, B:152:0x03e7, B:153:0x03eb, B:113:0x02cd), top: B:239:0x02cd }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0432  */
    /* JADX WARN: Code duplicated, block: B:166:0x0459 A[Catch: Exception -> 0x046b, LOOP:3: B:164:0x0453->B:166:0x0459, LOOP_END, TryCatch #2 {Exception -> 0x046b, blocks: (B:163:0x0433, B:164:0x0453, B:166:0x0459, B:167:0x0465), top: B:228:0x0433 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x03c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v46 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r37v0 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v49, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v69 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v71 */
    /* JADX WARN: Type inference failed for: r3v72 */
    /* JADX WARN: Type inference failed for: r3v73 */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r3v75 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x0480 -> B:173:0x0483). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r39) {
        /*
            Method dump skipped, instruction units count: 1378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MutatorMutex$mutateWith$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2 function2, DefaultScrollableState$scrollScope$1 defaultScrollableState$scrollScope$1, Continuation continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = (SuspendLambda) function2;
        this.$receiver = defaultScrollableState$scrollScope$1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutatorMutex$mutateWith$2(Map map, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, Continuation continuation) {
        super(2, continuation);
        this.L$0 = map;
        this.L$3 = mutableState;
        this.$receiver = mutableState2;
        this.L$4 = mutableState3;
        this.this$0 = mutableState4;
        this.$priority = parcelableSnapshotMutableLongState;
        this.$block = parcelableSnapshotMutableLongState2;
    }
}
