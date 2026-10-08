package com.github.kr328.clash.common.constants;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.common.util.GlobalKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Intents {
    public static final String ACTION_CLASH_REQUEST_STOP;
    public static final String ACTION_CLASH_STARTED;
    public static final String ACTION_CLASH_STOPPED;
    public static final String ACTION_MODE_CHANGED;
    public static final String ACTION_PROFILE_CHANGED;
    public static final String ACTION_PROFILE_LOADED;
    public static final String ACTION_PROFILE_UPDATE_COMPLETED;
    public static final String ACTION_PROFILE_UPDATE_FAILED;
    public static final String ACTION_SERVICE_RECREATED;
    public static final String ACTION_START_CLASH;
    public static final String ACTION_STOP_CLASH;
    public static final String ACTION_TOGGLE_CLASH;

    static {
        String str = GlobalKt.packageName;
        ACTION_START_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.START_CLASH");
        ACTION_STOP_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.STOP_CLASH");
        ACTION_TOGGLE_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.TOGGLE_CLASH");
        ACTION_SERVICE_RECREATED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_RECREATED");
        ACTION_CLASH_STARTED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_STARTED");
        ACTION_CLASH_STOPPED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_STOPPED");
        ACTION_CLASH_REQUEST_STOP = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_REQUEST_STOP");
        ACTION_PROFILE_CHANGED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_CHANGED");
        ACTION_PROFILE_UPDATE_COMPLETED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_UPDATE_COMPLETED");
        ACTION_PROFILE_UPDATE_FAILED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_UPDATE_FAILED");
        ACTION_PROFILE_LOADED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_LOADED");
        ACTION_MODE_CHANGED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.MODE_CHANGED");
    }
}
