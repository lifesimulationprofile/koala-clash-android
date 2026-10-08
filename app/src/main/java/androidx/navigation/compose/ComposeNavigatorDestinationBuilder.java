package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestinationBuilder;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder {
    public final ComposeNavigator composeNavigator;
    public final ComposableLambdaImpl content;

    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, String str, ComposableLambdaImpl composableLambdaImpl) {
        super(composeNavigator, str);
        this.composeNavigator = composeNavigator;
        this.content = composableLambdaImpl;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination build() {
        return (ComposeNavigator.Destination) super.build();
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination instantiateDestination() {
        return new ComposeNavigator.Destination(this.composeNavigator, this.content);
    }
}
