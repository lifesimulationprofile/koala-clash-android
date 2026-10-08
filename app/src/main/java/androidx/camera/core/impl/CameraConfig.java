package androidx.camera.core.impl;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraConfig extends ReadableConfig {
    public static final AutoValue_Config_Option OPTION_USECASE_CONFIG_FACTORY = new AutoValue_Config_Option("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class, null);
    public static final AutoValue_Config_Option OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = new AutoValue_Config_Option("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class, null);
    public static final AutoValue_Config_Option OPTION_SESSION_PROCESSOR = new AutoValue_Config_Option("camerax.core.camera.SessionProcessor", SessionProcessor.class, null);
    public static final AutoValue_Config_Option OPTION_POSTVIEW_SUPPORTED = new AutoValue_Config_Option("camerax.core.camera.isPostviewSupported", Boolean.class, null);
    public static final AutoValue_Config_Option OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED = new AutoValue_Config_Option("camerax.core.camera.isCaptureProcessProgressSupported", Boolean.class, null);
}
