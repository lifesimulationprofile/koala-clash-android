package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.MeteringRepeatingSession$MeteringRepeatingConfig;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Preview$$ExternalSyntheticLambda2;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.graphics.ColorUtils;
import androidx.work.Worker;
import coil.request.RequestService;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.material.textfield.IconHelper;
import com.google.common.util.concurrent.ListenableFuture;
import com.koala.clash.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager INSTANCE;
    public ResourceManagerInternal mResourceManager;

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class AnonymousClass1 {
        public Object COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
        public Object COLORFILTER_COLOR_CONTROL_ACTIVATED;
        public Object COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
        public Object TINT_CHECKABLE_BUTTON_LIST;
        public Object TINT_COLOR_CONTROL_NORMAL;
        public Object TINT_COLOR_CONTROL_STATE_LIST;

        public AnonymousClass1(String str, String str2, Set set) {
            Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
            this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = setUnmodifiableSet;
            Map map = Collections.EMPTY_MAP;
            this.COLORFILTER_COLOR_CONTROL_ACTIVATED = str;
            this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = str2;
            this.TINT_COLOR_CONTROL_STATE_LIST = SignInOptions.zaa;
            HashSet hashSet = new HashSet(setUnmodifiableSet);
            Iterator it = map.values().iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            this.TINT_COLOR_CONTROL_NORMAL = Collections.unmodifiableSet(hashSet);
        }

        public static boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList createButtonColorStateList(Context context, int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        public static LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawable;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = AppCompatDrawableManager.DEFAULT_MODE;
            }
            drawableMutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        public void addMetadata(String str, String str2) {
            HashMap map = (HashMap) this.TINT_CHECKABLE_BUTTON_LIST;
            if (map == null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            map.put(str, str2);
        }

        public AutoValue_EventInternal build() {
            String strM = ((String) this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL) == null ? " transportName" : "";
            if (((EncodedPayload) this.COLORFILTER_COLOR_CONTROL_ACTIVATED) == null) {
                strM = strM.concat(" encodedPayload");
            }
            if (((Long) this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " eventMillis");
            }
            if (((Long) this.TINT_COLOR_CONTROL_STATE_LIST) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " uptimeMillis");
            }
            if (((HashMap) this.TINT_CHECKABLE_BUTTON_LIST) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " autoMetadata");
            }
            if (strM.isEmpty()) {
                return new AutoValue_EventInternal((String) this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, (Integer) this.TINT_COLOR_CONTROL_NORMAL, (EncodedPayload) this.COLORFILTER_COLOR_CONTROL_ACTIVATED, ((Long) this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY).longValue(), ((Long) this.TINT_COLOR_CONTROL_STATE_LIST).longValue(), (HashMap) this.TINT_CHECKABLE_BUTTON_LIST);
            }
            throw new IllegalStateException("Missing required properties:".concat(strM));
        }

        public SessionConfig createSessionConfig() {
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            Size size = (Size) this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
            surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
            Surface surface = new Surface(surfaceTexture);
            SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom((MeteringRepeatingSession$MeteringRepeatingConfig) this.COLORFILTER_COLOR_CONTROL_ACTIVATED, size);
            builderCreateFrom.mCaptureConfigBuilder.index = 1;
            SurfaceRequest.AnonymousClass2 anonymousClass2 = new SurfaceRequest.AnonymousClass2(surface);
            this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = anonymousClass2;
            ListenableFuture listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture);
            RequestService requestService = new RequestService(3, surface, surfaceTexture, false);
            listenableFutureNonCancellationPropagating.addListener(new Worker.AnonymousClass2(1, listenableFutureNonCancellationPropagating, requestService), SetsKt.directExecutor());
            builderCreateFrom.addSurface((SurfaceRequest.AnonymousClass2) this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, DynamicRange.SDR, -1);
            SessionConfig.CloseableErrorListener closeableErrorListener = (SessionConfig.CloseableErrorListener) this.TINT_CHECKABLE_BUTTON_LIST;
            if (closeableErrorListener != null) {
                closeableErrorListener.close();
            }
            SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new Preview$$ExternalSyntheticLambda2(1, this));
            this.TINT_CHECKABLE_BUTTON_LIST = closeableErrorListener2;
            builderCreateFrom.mErrorListener = closeableErrorListener2;
            return builderCreateFrom.build();
        }

        public ColorStateList getTintListForDrawableRes(Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return IconHelper.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return IconHelper.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i != R.drawable.abc_switch_thumb_material) {
                if (i == R.drawable.abc_btn_default_mtrl_shape) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
                }
                if (i == R.drawable.abc_btn_borderless_material) {
                    return createButtonColorStateList(context, 0);
                }
                if (i == R.drawable.abc_btn_colored_material) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                }
                if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                    return IconHelper.getColorStateList(context, R.color.abc_tint_spinner);
                }
                if (arrayContains((int[]) this.TINT_COLOR_CONTROL_NORMAL, i)) {
                    return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                }
                if (arrayContains((int[]) this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                    return IconHelper.getColorStateList(context, R.color.abc_tint_default);
                }
                if (arrayContains((int[]) this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                    return IconHelper.getColorStateList(context, R.color.abc_tint_btn_checkable);
                }
                if (i == R.drawable.abc_seekbar_thumb_material) {
                    return IconHelper.getColorStateList(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }
    }

    public static synchronized AppCompatDrawableManager get() {
        try {
            if (INSTANCE == null) {
                preload();
            }
        } catch (Throwable th) {
            throw th;
        }
        return INSTANCE;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        return ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
    }

    public static synchronized void preload() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
            ResourceManagerInternal resourceManagerInternal = INSTANCE.mResourceManager;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            anonymousClass1.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            anonymousClass1.TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            anonymousClass1.COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            anonymousClass1.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            anonymousClass1.TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            anonymousClass1.TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            resourceManagerInternal.setHooks(anonymousClass1);
        }
    }

    public static void tintDrawable(Drawable drawable, ConnectionSpec.Builder builder, int[] iArr) {
        PorterDuff.Mode mode = ResourceManagerInternal.DEFAULT_MODE;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = builder.supportsTlsExtensions;
        if (z || builder.tls) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z ? (ColorStateList) builder.cipherSuites : null;
            PorterDuff.Mode mode2 = builder.tls ? (PorterDuff.Mode) builder.tlsVersions : ResourceManagerInternal.DEFAULT_MODE;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }
}
