package kotlin.internal;

import androidx.appcompat.widget.Toolbar;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.LazyDslKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProgressionUtilKt {
    /* JADX WARN: Code duplicated, block: B:100:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x006d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x0112  */
    /* JADX WARN: Code duplicated, block: B:88:0x012b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x012d  */
    /* JADX WARN: Code duplicated, block: B:92:0x014a  */
    /* JADX WARN: Code duplicated, block: B:93:0x014f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x015b  */
    public static final void LazyColumn(int i, int i2, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, FlingBehavior flingBehavior, Arrangement.Vertical vertical, PaddingValuesImpl paddingValuesImpl, LazyListState lazyListState, GapComposer gapComposer, Alignment.Horizontal horizontal, Modifier modifier, Function1 function1, boolean z, boolean z2) {
        Modifier modifier2;
        int i3;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValuesImpl paddingValuesImpl2;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i4;
        int i5;
        boolean z4;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2;
        FlingBehavior flingBehavior2;
        boolean z5;
        LazyListState lazyListState2;
        boolean z6;
        Alignment.Horizontal horizontal2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Density density;
        boolean zChanged;
        Object objRememberedValue;
        DecayAnimationSpecImpl decayAnimationSpecImpl;
        boolean zChanged2;
        Object objRememberedValue2;
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory;
        boolean zChanged3;
        Object objRememberedValue3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect3;
        int i6;
        Alignment.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect4;
        boolean z7;
        int i7;
        int i8;
        gapComposer.startRestartGroup(53695811);
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (gapComposer.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                lazyListStateRememberLazyListState = lazyListState;
                int i9 = gapComposer.changed(lazyListStateRememberLazyListState) ? 32 : 16;
                i3 |= i9;
            } else {
                lazyListStateRememberLazyListState = lazyListState;
            }
            i3 |= i9;
        } else {
            lazyListStateRememberLazyListState = lazyListState;
        }
        if ((i & 384) == 0) {
            paddingValuesImpl2 = paddingValuesImpl;
            i3 |= gapComposer.changed(paddingValuesImpl2) ? 256 : 128;
        } else {
            paddingValuesImpl2 = paddingValuesImpl;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 3072) == 0) {
                z3 = z;
                i3 |= gapComposer.changed(z3) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                vertical2 = vertical;
                if (gapComposer.changed(vertical2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                vertical2 = vertical;
            }
            i4 = 196608 | i3;
            if ((1572864 & i) == 0) {
                i4 = 720896 | i3;
            }
            i5 = 12582912 | i4;
            if ((100663296 & i) == 0) {
                i5 = 46137344 | i4;
            }
            if ((805306368 & i) == 0) {
                if (gapComposer.changedInstance(function1)) {
                    i7 = 536870912;
                } else {
                    i7 = 268435456;
                }
                i5 |= i7;
            }
            if ((306783379 & i5) != 306783378) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z4)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                        i5 &= -113;
                    }
                    if (i10 != 0) {
                        z3 = false;
                    }
                    BiasAlignment.Horizontal horizontal4 = Alignment.Companion.Start;
                    float f = SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
                    density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                    zChanged = gapComposer.changed(density.getDensity());
                    objRememberedValue = gapComposer.rememberedValue();
                    Object obj = Composer$Companion.Empty;
                    if (zChanged || objRememberedValue == obj) {
                        objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    decayAnimationSpecImpl = (DecayAnimationSpecImpl) objRememberedValue;
                    zChanged2 = gapComposer.changed(decayAnimationSpecImpl);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == obj) {
                        objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) objRememberedValue2;
                    DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = OverscrollKt.LocalOverscrollFactory;
                    gapComposer.startReplaceGroup(282942128);
                    androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) gapComposer.consume(OverscrollKt.LocalOverscrollFactory);
                    if (androidEdgeEffectOverscrollFactory == null) {
                        gapComposer.end(false);
                        androidEdgeEffectOverscrollEffect3 = null;
                    } else {
                        zChanged3 = gapComposer.changed(androidEdgeEffectOverscrollFactory);
                        objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == obj) {
                            objRememberedValue3 = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowColor, androidEdgeEffectOverscrollFactory.glowDrawPadding);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer.end(false);
                        androidEdgeEffectOverscrollEffect3 = (AndroidEdgeEffectOverscrollEffect) objRememberedValue3;
                    }
                    i6 = i5 & (-238551041);
                    horizontal3 = horizontal4;
                    flingBehavior3 = defaultFlingBehavior;
                    androidEdgeEffectOverscrollEffect4 = androidEdgeEffectOverscrollEffect3;
                    z7 = true;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i5 &= -113;
                    }
                    i6 = i5 & (-238551041);
                    androidEdgeEffectOverscrollEffect4 = androidEdgeEffectOverscrollEffect;
                    flingBehavior3 = flingBehavior;
                    horizontal3 = horizontal;
                    z7 = z2;
                }
                LazyListState lazyListState3 = lazyListStateRememberLazyListState;
                boolean z8 = z3;
                gapComposer.endDefaults();
                ByteStreamsKt.LazyList((i6 & 14) | 24576 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | ((i6 >> 3) & 3670016) | ((i6 << 12) & 1879048192), ((i6 >> 12) & 14) | ((i6 >> 18) & 7168), androidEdgeEffectOverscrollEffect4, flingBehavior3, vertical2, paddingValuesImpl2, lazyListState3, gapComposer, horizontal3, modifier2, function1, z8, z7);
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect4;
                flingBehavior2 = flingBehavior3;
                lazyListState2 = lazyListState3;
                horizontal2 = horizontal3;
                z6 = z8;
                z5 = z7;
            } else {
                gapComposer.skipToGroupEnd();
                androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
                flingBehavior2 = flingBehavior;
                z5 = z2;
                lazyListState2 = lazyListStateRememberLazyListState;
                z6 = z3;
                horizontal2 = horizontal;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new LazyDslKt$$ExternalSyntheticLambda0(modifier, lazyListState2, paddingValuesImpl, z6, vertical, horizontal2, flingBehavior2, z5, androidEdgeEffectOverscrollEffect2, function1, i, i2);
            }
        }
        i3 |= 3072;
        z3 = z;
        if ((i & 24576) == 0) {
            vertical2 = vertical;
            if (gapComposer.changed(vertical2)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        } else {
            vertical2 = vertical;
        }
        i4 = 196608 | i3;
        if ((1572864 & i) == 0) {
            i4 = 720896 | i3;
        }
        i5 = 12582912 | i4;
        if ((100663296 & i) == 0) {
            i5 = 46137344 | i4;
        }
        if ((805306368 & i) == 0) {
            if (gapComposer.changedInstance(function1)) {
                i7 = 536870912;
            } else {
                i7 = 268435456;
            }
            i5 |= i7;
        }
        if ((306783379 & i5) != 306783378) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z4)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                    i5 &= -113;
                }
                if (i10 != 0) {
                    z3 = false;
                }
                BiasAlignment.Horizontal horizontal5 = Alignment.Companion.Start;
                float f2 = SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
                density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                zChanged = gapComposer.changed(density.getDensity());
                objRememberedValue = gapComposer.rememberedValue();
                Object obj2 = Composer$Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                decayAnimationSpecImpl = (DecayAnimationSpecImpl) objRememberedValue;
                zChanged2 = gapComposer.changed(decayAnimationSpecImpl);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                DefaultFlingBehavior defaultFlingBehavior2 = (DefaultFlingBehavior) objRememberedValue2;
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal2 = OverscrollKt.LocalOverscrollFactory;
                gapComposer.startReplaceGroup(282942128);
                androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) gapComposer.consume(OverscrollKt.LocalOverscrollFactory);
                if (androidEdgeEffectOverscrollFactory == null) {
                    gapComposer.end(false);
                    androidEdgeEffectOverscrollEffect3 = null;
                } else {
                    zChanged3 = gapComposer.changed(androidEdgeEffectOverscrollFactory);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue3 = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowColor, androidEdgeEffectOverscrollFactory.glowDrawPadding);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowColor, androidEdgeEffectOverscrollFactory.glowDrawPadding);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    gapComposer.end(false);
                    androidEdgeEffectOverscrollEffect3 = (AndroidEdgeEffectOverscrollEffect) objRememberedValue3;
                }
                i6 = i5 & (-238551041);
                horizontal3 = horizontal5;
                flingBehavior3 = defaultFlingBehavior2;
                androidEdgeEffectOverscrollEffect4 = androidEdgeEffectOverscrollEffect3;
                z7 = true;
            } else {
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
                    i5 &= -113;
                }
                if (i10 != 0) {
                    z3 = false;
                }
                BiasAlignment.Horizontal horizontal6 = Alignment.Companion.Start;
                float f3 = SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
                density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                zChanged = gapComposer.changed(density.getDensity());
                objRememberedValue = gapComposer.rememberedValue();
                Object obj3 = Composer$Companion.Empty;
                if (zChanged) {
                    objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
                    gapComposer.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new DecayAnimationSpecImpl(new Toolbar.AnonymousClass1(density));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                decayAnimationSpecImpl = (DecayAnimationSpecImpl) objRememberedValue;
                zChanged2 = gapComposer.changed(decayAnimationSpecImpl);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2) {
                    objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new DefaultFlingBehavior(decayAnimationSpecImpl);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                DefaultFlingBehavior defaultFlingBehavior3 = (DefaultFlingBehavior) objRememberedValue2;
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal3 = OverscrollKt.LocalOverscrollFactory;
                gapComposer.startReplaceGroup(282942128);
                androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) gapComposer.consume(OverscrollKt.LocalOverscrollFactory);
                if (androidEdgeEffectOverscrollFactory == null) {
                    gapComposer.end(false);
                    androidEdgeEffectOverscrollEffect3 = null;
                } else {
                    zChanged3 = gapComposer.changed(androidEdgeEffectOverscrollFactory);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue3 = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowColor, androidEdgeEffectOverscrollFactory.glowDrawPadding);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowColor, androidEdgeEffectOverscrollFactory.glowDrawPadding);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    gapComposer.end(false);
                    androidEdgeEffectOverscrollEffect3 = (AndroidEdgeEffectOverscrollEffect) objRememberedValue3;
                }
                i6 = i5 & (-238551041);
                horizontal3 = horizontal6;
                flingBehavior3 = defaultFlingBehavior3;
                androidEdgeEffectOverscrollEffect4 = androidEdgeEffectOverscrollEffect3;
                z7 = true;
            }
            LazyListState lazyListState4 = lazyListStateRememberLazyListState;
            boolean z9 = z3;
            gapComposer.endDefaults();
            ByteStreamsKt.LazyList((i6 & 14) | 24576 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | ((i6 >> 3) & 3670016) | ((i6 << 12) & 1879048192), ((i6 >> 12) & 14) | ((i6 >> 18) & 7168), androidEdgeEffectOverscrollEffect4, flingBehavior3, vertical2, paddingValuesImpl2, lazyListState4, gapComposer, horizontal3, modifier2, function1, z9, z7);
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect4;
            flingBehavior2 = flingBehavior3;
            lazyListState2 = lazyListState4;
            horizontal2 = horizontal3;
            z6 = z9;
            z5 = z7;
        } else {
            gapComposer.skipToGroupEnd();
            androidEdgeEffectOverscrollEffect2 = androidEdgeEffectOverscrollEffect;
            flingBehavior2 = flingBehavior;
            z5 = z2;
            lazyListState2 = lazyListStateRememberLazyListState;
            z6 = z3;
            horizontal2 = horizontal;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LazyDslKt$$ExternalSyntheticLambda0(modifier, lazyListState2, paddingValuesImpl, z6, vertical, horizontal2, flingBehavior2, z5, androidEdgeEffectOverscrollEffect2, function1, i, i2);
        }
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }
}
