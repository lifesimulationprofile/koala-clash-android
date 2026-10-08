package androidx.camera.core.internal;

import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.ReadableConfig;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface TargetConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_TARGET_NAME = new AutoValue_Config_Option("camerax.core.target.name", String.class, null);
    public static final AutoValue_Config_Option OPTION_TARGET_CLASS = new AutoValue_Config_Option("camerax.core.target.class", Class.class, null);

    String getTargetName();

    String getTargetName(String str);
}
