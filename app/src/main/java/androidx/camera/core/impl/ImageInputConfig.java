package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageInputConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_INPUT_FORMAT = new AutoValue_Config_Option("camerax.core.imageInput.inputFormat", Integer.TYPE, null);
    public static final AutoValue_Config_Option OPTION_INPUT_DYNAMIC_RANGE = new AutoValue_Config_Option("camerax.core.imageInput.inputDynamicRange", DynamicRange.class, null);

    DynamicRange getDynamicRange();

    int getInputFormat();
}
