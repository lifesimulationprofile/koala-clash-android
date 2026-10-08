package androidx.appcompat.view.menu;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.camera.view.PreviewView;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import coil.request.RequestService;
import com.caverock.androidsvg.CSSParser;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import java.util.Locale;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CascadingMenuPopup$3$1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$1;
    public final /* synthetic */ Object val$item;
    public final /* synthetic */ Object val$menu;
    public final /* synthetic */ Object val$nextInfo;

    public /* synthetic */ CascadingMenuPopup$3$1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.val$nextInfo = obj;
        this.val$item = obj2;
        this.val$menu = obj3;
        this.this$1 = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzdk zzdkVarZzf;
        switch (this.$r8$classId) {
            case 0:
                CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) ((PreviewView.AnonymousClass1) this.this$1).this$0;
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.val$item;
                CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo) this.val$nextInfo;
                if (cascadingMenuInfo != null) {
                    cascadingMenuPopup.mShouldCloseImmediately = true;
                    cascadingMenuInfo.menu.close(false);
                    cascadingMenuPopup.mShouldCloseImmediately = false;
                }
                if (menuItemImpl.isEnabled() && menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) this.val$menu).performItemAction(menuItemImpl, null, 4);
                    return;
                }
                return;
            case 1:
                WindowInsetsAnimationCompat.Impl21.dispatchOnStart((View) this.val$nextInfo, (WindowInsetsAnimationCompat) this.val$item, (RequestService) this.val$menu);
                ((ValueAnimator) this.this$1).start();
                return;
            default:
                zzwp zzwpVar = (zzwp) this.val$nextInfo;
                StatusLine statusLine = (StatusLine) this.val$item;
                zzrc zzrcVar = (zzrc) this.val$menu;
                String str2 = (String) this.this$1;
                AppCompatDrawableManager.AnonymousClass1 anonymousClass1 = (AppCompatDrawableManager.AnonymousClass1) statusLine.protocol;
                anonymousClass1.TINT_COLOR_CONTROL_NORMAL = zzrcVar;
                zzvd zzvdVar = (zzvd) anonymousClass1.COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
                if (zzvdVar == null || (str = zzvdVar.zzd) == null || str.isEmpty()) {
                    str = "NA";
                } else {
                    zzah.checkNotNull(str);
                }
                zzky zzkyVar = new zzky();
                zzkyVar.zza = zzwpVar.zzc;
                zzkyVar.zzb = zzwpVar.zzd;
                synchronized (zzwp.class) {
                    try {
                        zzdkVarZzf = zzwp.zza;
                        if (zzdkVarZzf == null) {
                            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                            CSSParser cSSParser = new CSSParser();
                            for (int i = 0; i < locales.mImpl.size(); i++) {
                                Locale locale = locales.mImpl.get(i);
                                GmsLogger gmsLogger = CommonUtils.zza;
                                cSSParser.zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(locale.toLanguageTag());
                            }
                            zzdkVarZzf = cSSParser.zzf();
                            zzwp.zza = zzdkVarZzf;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                zzkyVar.zze = zzdkVarZzf;
                zzkyVar.zzh = Boolean.TRUE;
                zzkyVar.zzd = str;
                zzkyVar.zzc = str2;
                zzkyVar.zzf = zzwpVar.zzh.isSuccessful() ? (String) zzwpVar.zzh.getResult() : zzwpVar.zzf.getMlSdkInstanceId();
                zzkyVar.zzj = 10;
                zzkyVar.zzk = Integer.valueOf(zzwpVar.zzj);
                statusLine.message = zzkyVar;
                zzwpVar.zze.zza(statusLine);
                return;
        }
    }

    public CascadingMenuPopup$3$1(PreviewView.AnonymousClass1 anonymousClass1, CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo, MenuItemImpl menuItemImpl, MenuBuilder menuBuilder) {
        this.$r8$classId = 0;
        this.this$1 = anonymousClass1;
        this.val$nextInfo = cascadingMenuInfo;
        this.val$item = menuItemImpl;
        this.val$menu = menuBuilder;
    }
}
