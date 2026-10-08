package kotlinx.coroutines;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.AbstractClickableNode$onKeyEvent$1;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.TextFieldKeyInput;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGestureNode.ClickTextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.lifecycle.ViewModelKt;
import androidx.work.CoroutineWorker;
import coil.ImageLoader$Builder;
import coil.memory.EmptyStrongMemoryCache;
import com.github.kr328.clash.AppSettingsActivity;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.RestartReceiver;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.store.UiStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import okhttp3.ConnectionPool;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JobKt__JobKt$invokeOnCompletion$1 extends FunctionReferenceImpl implements Function1 {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JobKt__JobKt$invokeOnCompletion$1(int i, Object obj, Class cls, String str, String str2, int i2, int i3, int i4) {
        super(i, obj, cls, str, str2, i2, i3);
        this.$r8$classId = i4;
    }

    /* JADX WARN: Code duplicated, block: B:140:0x0358 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x035a A[LOOP:3: B:129:0x0309->B:141:0x035a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x0361 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0272  */
    /* JADX WARN: Code duplicated, block: B:98:0x0282  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v24, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        CommitTextCommand commitTextCommand;
        int iM169mapZmokQxo;
        boolean z;
        boolean z2;
        Integer numValueOf;
        Object value;
        LinkedHashSet linkedHashSetPlus;
        ?? arrayList;
        List list;
        int i = this.$r8$classId;
        char c = 7;
        Continuation continuation = null;
        Object obj2 = this.receiver;
        switch (i) {
            case 0:
                ((JobNode) obj2).invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                AbstractClickableNode abstractClickableNode = (AbstractClickableNode) obj2;
                MutableLongObjectMap mutableLongObjectMap = abstractClickableNode.currentKeyPressInteractions;
                if (zBooleanValue) {
                    abstractClickableNode.initializeIndicationAndInteractionSourceIfNeeded();
                } else {
                    if (abstractClickableNode.interactionSource != null) {
                        Object[] objArr = mutableLongObjectMap.values;
                        long[] jArr = mutableLongObjectMap.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i2 = 0;
                            while (true) {
                                long j = jArr[i2];
                                if ((((~j) << c) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i3 = 8;
                                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                                    int i5 = 0;
                                    while (i5 < i4) {
                                        if ((j & 255) < 128) {
                                            JobKt.launch$default(abstractClickableNode.getCoroutineScope(), null, new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, (PressInteraction.Press) objArr[(i2 << 3) + i5], null, 1), 3);
                                        }
                                        j >>= i3;
                                        i5++;
                                        i3 = i3;
                                    }
                                    if (i4 == i3) {
                                        if (i2 != length) {
                                            i2++;
                                            c = 7;
                                        }
                                    }
                                } else if (i2 != length) {
                                    i2++;
                                    c = 7;
                                }
                            }
                        }
                        PressInteraction.Press press = abstractClickableNode.indirectPointerPressInteraction;
                        if (press != null) {
                            JobKt.launch$default(abstractClickableNode.getCoroutineScope(), null, new AbstractClickableNode$onKeyEvent$1(abstractClickableNode, press, null, 2), 3);
                        }
                    }
                    mutableLongObjectMap.clear();
                    abstractClickableNode.indirectPointerPressInteraction = null;
                    abstractClickableNode.onCancelKeyInput();
                }
                return Unit.INSTANCE;
            case 2:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                TextFieldKeyInput textFieldKeyInput = (TextFieldKeyInput) obj2;
                TextPreparedSelectionState textPreparedSelectionState = textFieldKeyInput.preparedSelectionState;
                boolean z3 = textFieldKeyInput.editable;
                if (keyEvent.getAction() != 0 || Character.isISOControl(keyEvent.getUnicodeChar())) {
                    commitTextCommand = null;
                } else {
                    DeadKeyCombiner deadKeyCombiner = textFieldKeyInput.keyCombiner;
                    deadKeyCombiner.getClass();
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                        deadKeyCombiner.deadKeyCode = Integer.valueOf(unicodeChar & Integer.MAX_VALUE);
                        numValueOf = null;
                    } else {
                        Integer num = deadKeyCombiner.deadKeyCode;
                        if (num != null) {
                            deadKeyCombiner.deadKeyCode = null;
                            int deadChar = KeyCharacterMap.getDeadChar(num.intValue(), unicodeChar);
                            Integer numValueOf2 = Integer.valueOf(deadChar);
                            if (deadChar == 0) {
                                numValueOf2 = null;
                            }
                            if (numValueOf2 != null) {
                                unicodeChar = numValueOf2.intValue();
                            }
                            numValueOf = Integer.valueOf(unicodeChar);
                        } else {
                            numValueOf = Integer.valueOf(unicodeChar);
                        }
                    }
                    if (numValueOf != null) {
                        commitTextCommand = new CommitTextCommand(new StringBuilder().appendCodePoint(numValueOf.intValue()).toString(), 1);
                    } else {
                        commitTextCommand = null;
                    }
                }
                if (commitTextCommand != null) {
                    if (z3) {
                        textFieldKeyInput.apply(Collections.singletonList(commitTextCommand));
                        textPreparedSelectionState.cachedX = null;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else if (Key_androidKt.m504getTypeZmokQxo(keyEvent) != 2 || (iM169mapZmokQxo = textFieldKeyInput.keyMapping.m169mapZmokQxo(keyEvent)) == 0) {
                    z2 = false;
                } else {
                    switch (iM169mapZmokQxo) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                            z = false;
                            break;
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            z = true;
                            break;
                        default:
                            throw null;
                    }
                    if (!z || z3) {
                        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                        ref$BooleanRef.element = true;
                        ScrollNode$$ExternalSyntheticLambda0 scrollNode$$ExternalSyntheticLambda0 = new ScrollNode$$ExternalSyntheticLambda0(iM169mapZmokQxo, textFieldKeyInput, ref$BooleanRef);
                        TextFieldValue textFieldValue = textFieldKeyInput.value;
                        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(textFieldValue, textFieldKeyInput.offsetMapping, textFieldKeyInput.state.getLayoutResult(), textPreparedSelectionState);
                        scrollNode$$ExternalSyntheticLambda0.invoke(textFieldPreparedSelection);
                        boolean zM638equalsimpl0 = TextRange.m638equalsimpl0(textFieldPreparedSelection.selection, textFieldValue.selection);
                        AnnotatedString annotatedString = textFieldPreparedSelection.annotatedString;
                        if (!zM638equalsimpl0 || !Intrinsics.areEqual(annotatedString, textFieldValue.annotatedString)) {
                            textFieldKeyInput.onValueChange.invoke(TextFieldValue.m661copy3r_uNRQ$default(textFieldValue, annotatedString, textFieldPreparedSelection.selection, 4));
                        }
                        UndoManager undoManager = textFieldKeyInput.undoManager;
                        if (undoManager != null) {
                            undoManager.forceNextSnapshot = true;
                        }
                        z2 = ref$BooleanRef.element;
                    } else {
                        z2 = false;
                    }
                }
                return Boolean.valueOf(z2);
            case 3:
                long j2 = ((Offset) obj).packedValue;
                TextContextMenuGestureNode textContextMenuGestureNode = (TextContextMenuGestureNode) obj2;
                textContextMenuGestureNode.getClass();
                TextContextMenuProvider textContextMenuProvider = (TextContextMenuProvider) HitTestResultKt.currentValueOf(textContextMenuGestureNode, TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider);
                if (textContextMenuProvider != null) {
                    JobKt.launch$default(textContextMenuGestureNode.getCoroutineScope(), null, new ScrollableKt$semanticsScrollBy$2(textContextMenuGestureNode, j2, textContextMenuProvider, textContextMenuGestureNode.new ClickTextContextMenuDataProvider(j2), (Continuation) null), 3);
                }
                return Unit.INSTANCE;
            case 4:
                ((TextContextMenuBuilderScope) obj2).filters.add((Function1) obj);
                return Unit.INSTANCE;
            case 5:
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                AppSettingsActivity appSettingsActivity = (AppSettingsActivity) obj2;
                int i6 = AppSettingsActivity.$r8$clinit;
                appSettingsActivity.getClass();
                int i7 = zBooleanValue2 ? 1 : 2;
                PackageManager packageManager = appSettingsActivity.getPackageManager();
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RestartReceiver.class);
                Global.INSTANCE.getClass();
                packageManager.setComponentEnabledSetting(new ComponentName(Global.getApplication$1().getPackageName(), orCreateKotlinClass.getJClass().getName()), i7, 1);
                return Unit.INSTANCE;
            case 6:
                LogcatActivity.access$copyMessage((LogcatActivity) obj2, (LogMessage) obj);
                return Unit.INSTANCE;
            case 7:
                LogcatActivity.access$copyMessage((LogcatActivity) obj2, (LogMessage) obj);
                return Unit.INSTANCE;
            case 8:
                ((NewProfileViewModel) obj2).setLink((String) obj);
                return Unit.INSTANCE;
            case 9:
                String str = (String) obj;
                ProxyViewModel proxyViewModel = (ProxyViewModel) obj2;
                StateFlowImpl stateFlowImpl = proxyViewModel._expandedGroups;
                do {
                    value = stateFlowImpl.getValue();
                    Set set = (Set) value;
                    if (set.contains(str)) {
                        linkedHashSetPlus = SetsKt.minus(set, str);
                    } else {
                        ImageLoader$Builder imageLoader$Builder = proxyViewModel.uiStore.proxyLastGroup$delegate;
                        KProperty kProperty = UiStore.$$delegatedProperties[7];
                        EmptyStrongMemoryCache emptyStrongMemoryCache = (EmptyStrongMemoryCache) ((ConnectionPool) imageLoader$Builder.applicationContext).delegate;
                        String str2 = (String) imageLoader$Builder.defaults;
                        SharedPreferences.Editor editorEdit = ((SharedPreferences) emptyStrongMemoryCache.weakMemoryCache).edit();
                        editorEdit.putString(str2, str);
                        editorEdit.apply();
                        linkedHashSetPlus = SetsKt.plus(set, str);
                    }
                } while (!stateFlowImpl.compareAndSet(value, linkedHashSetPlus));
                return Unit.INSTANCE;
            case 10:
                String str3 = (String) obj;
                ProxyViewModel proxyViewModel2 = (ProxyViewModel) obj2;
                if (!((Set) proxyViewModel2._testingGroups.getValue()).contains(str3)) {
                    ProxyGroup proxyGroup = (ProxyGroup) ((Map) proxyViewModel2._groups.getValue()).get(str3);
                    if (proxyGroup == null || (list = proxyGroup.proxies) == null) {
                        arrayList = EmptyList.INSTANCE;
                    } else {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Proxy) it.next()).name);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj3 : arrayList) {
                            if (!((Set) proxyViewModel2._testingNodes.getValue()).contains(ProxyViewModel.nodeKey(str3, (String) obj3))) {
                                arrayList2.add(obj3);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel2), null, new ChannelFlow.AnonymousClass2(proxyViewModel2, str3, arrayList2, null, 4), 3);
                        }
                    }
                }
                return Unit.INSTANCE;
            case 11:
                ProxySort proxySort = (ProxySort) obj;
                ProxyViewModel proxyViewModel3 = (ProxyViewModel) obj2;
                StateFlowImpl stateFlowImpl2 = proxyViewModel3._proxySort;
                if (stateFlowImpl2.getValue() != proxySort) {
                    stateFlowImpl2.updateState(null, proxySort);
                    Request.Builder builder = proxyViewModel3.uiStore.proxySort$delegate;
                    KProperty kProperty2 = UiStore.$$delegatedProperties[6];
                    builder.setValue(proxySort);
                    JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel3), null, new CoroutineWorker.AnonymousClass1(proxyViewModel3, continuation, 23), 3);
                }
                return Unit.INSTANCE;
            case 12:
                TunnelState.Mode mode = (TunnelState.Mode) obj;
                ProxyViewModel proxyViewModel4 = (ProxyViewModel) obj2;
                StateFlowImpl stateFlowImpl3 = proxyViewModel4._currentMode;
                if (((Boolean) proxyViewModel4._modeSwitchAllowed.getValue()).booleanValue() && stateFlowImpl3.getValue() != mode) {
                    stateFlowImpl3.updateState(null, mode);
                    JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel4), null, new FilesActivity$showError$1(mode, proxyViewModel4, continuation, 12), 3);
                }
                return Unit.INSTANCE;
            default:
                return Boolean.valueOf(((VpnService) obj2).protect(((Number) obj).intValue()));
        }
    }
}
