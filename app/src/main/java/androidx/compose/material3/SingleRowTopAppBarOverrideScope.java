package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleRowTopAppBarOverrideScope {
    public final Function3 actions;
    public final TopAppBarColors colors;
    public final PaddingValues contentPadding;
    public final float expandedHeight;
    public final Modifier modifier;
    public final Function2 navigationIcon;
    public final TextStyle subtitleTextStyle;
    public final ComposableLambdaImpl title;
    public final TextStyle titleTextStyle;
    public final WindowInsets windowInsets;

    public SingleRowTopAppBarOverrideScope(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, TextStyle textStyle, TextStyle textStyle2, Function2 function2, Function3 function3, float f, PaddingValues paddingValues, WindowInsets windowInsets, TopAppBarColors topAppBarColors) {
        this.modifier = modifier;
        this.title = composableLambdaImpl;
        this.titleTextStyle = textStyle;
        this.subtitleTextStyle = textStyle2;
        this.navigationIcon = function2;
        this.actions = function3;
        this.expandedHeight = f;
        this.contentPadding = paddingValues;
        this.windowInsets = windowInsets;
        this.colors = topAppBarColors;
    }
}
