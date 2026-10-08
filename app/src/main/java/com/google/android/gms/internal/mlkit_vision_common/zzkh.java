package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.network.HttpException;
import com.github.kr328.clash.design.compose.theme.ThemeState;
import com.github.kr328.clash.design.model.DarkMode;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzkh {
    /* JADX WARN: Code duplicated, block: B:4:0x0013  */
    public static final boolean isInDarkTheme(GapComposer gapComposer) {
        boolean z;
        gapComposer.startReplaceGroup(-986042636);
        DarkMode darkMode = (DarkMode) ThemeState.state$delegate.getValue();
        if (darkMode == DarkMode.ForceLight) {
            z = false;
        } else {
            z = true;
            if (darkMode != DarkMode.ForceDark) {
                if (darkMode != DarkMode.Auto) {
                    throw new HttpException();
                }
                gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
                if ((((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources().getConfiguration().uiMode & 48) != 32) {
                    z = false;
                }
            }
        }
        gapComposer.end(false);
        return z;
    }
}
