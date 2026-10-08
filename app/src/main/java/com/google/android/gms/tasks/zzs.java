package com.google.android.gms.tasks;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.TooltipPopup;
import coil.request.RequestService;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxs;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxu;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxy;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzya;
import com.google.android.gms.internal.mlkit_vision_barcode.zzyb;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.internal.MaterialCheckable;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.CountDownLatch;
import okhttp3.Route;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs implements OnSuccessListener, OnFailureListener, OnCanceledListener, MaterialButton.OnPressedChangeListener, ChipGroup.OnCheckedStateChangeListener, MaterialCheckable.OnCheckedChangeListener, BarcodeSource {
    public final Object zza;

    public /* synthetic */ zzs(Object obj) {
        this.zza = obj;
    }

    public synchronized void connected(Route route) {
        ((LinkedHashSet) this.zza).remove(route);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Rect getBoundingBox() {
        Point[] pointArr = ((zzyb) this.zza).zze;
        if (pointArr == null) {
            return null;
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : pointArr) {
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getCalendarEvent() {
        Barcode.CalendarDateTime calendarDateTime;
        Barcode.CalendarDateTime calendarDateTime2;
        zzxr zzxrVar = ((zzyb) this.zza).zzm;
        if (zzxrVar == null) {
            return null;
        }
        String str = zzxrVar.zza;
        String str2 = zzxrVar.zzb;
        String str3 = zzxrVar.zzc;
        String str4 = zzxrVar.zzd;
        String str5 = zzxrVar.zze;
        zzxq zzxqVar = zzxrVar.zzf;
        if (zzxqVar == null) {
            calendarDateTime2 = null;
            calendarDateTime = null;
        } else {
            calendarDateTime = null;
            calendarDateTime2 = new Barcode.CalendarDateTime(zzxqVar.zza, zzxqVar.zzb, zzxqVar.zzc, zzxqVar.zzd, zzxqVar.zze, zzxqVar.zzf, zzxqVar.zzg);
        }
        zzxq zzxqVar2 = zzxrVar.zzg;
        return new TooltipPopup(str, str2, str3, str4, str5, calendarDateTime2, zzxqVar2 == null ? calendarDateTime : new Barcode.CalendarDateTime(zzxqVar2.zza, zzxqVar2.zzb, zzxqVar2.zzc, zzxqVar2.zzd, zzxqVar2.zze, zzxqVar2.zzf, zzxqVar2.zzg));
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public TooltipPopup getContactInfo() {
        zzxs zzxsVar = ((zzyb) this.zza).zzn;
        if (zzxsVar == null) {
            return null;
        }
        zzxw zzxwVar = zzxsVar.zza;
        TooltipPopup tooltipPopup = zzxwVar == null ? null : new TooltipPopup(zzxwVar.zza, zzxwVar.zzb, zzxwVar.zzc, zzxwVar.zzd, zzxwVar.zze, zzxwVar.zzf, zzxwVar.zzg);
        String str = zzxsVar.zzb;
        String str2 = zzxsVar.zzc;
        zzxx[] zzxxVarArr = zzxsVar.zzd;
        ArrayList arrayList = new ArrayList();
        if (zzxxVarArr != null) {
            for (zzxx zzxxVar : zzxxVarArr) {
                if (zzxxVar != null) {
                    arrayList.add(new Barcode.Phone(zzxxVar.zzb, zzxxVar.zza));
                }
            }
        }
        zzxu[] zzxuVarArr = zzxsVar.zze;
        ArrayList arrayList2 = new ArrayList();
        if (zzxuVarArr != null) {
            for (zzxu zzxuVar : zzxuVarArr) {
                if (zzxuVar != null) {
                    arrayList2.add(new Barcode.Email(zzxuVar.zza, zzxuVar.zzb, zzxuVar.zzc, zzxuVar.zzd));
                }
            }
        }
        String[] strArr = zzxsVar.zzf;
        Object objAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        zzxp[] zzxpVarArr = zzxsVar.zzg;
        ArrayList arrayList3 = new ArrayList();
        if (zzxpVarArr != null) {
            for (zzxp zzxpVar : zzxpVarArr) {
                if (zzxpVar != null) {
                    arrayList3.add(new Barcode.Address(zzxpVar.zza, zzxpVar.zzb));
                }
            }
        }
        return new TooltipPopup(tooltipPopup, str, str2, arrayList, arrayList2, objAsList, arrayList3);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Point[] getCornerPoints() {
        return ((zzyb) this.zza).zze;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Email getEmail() {
        zzxu zzxuVar = ((zzyb) this.zza).zzg;
        if (zzxuVar == null) {
            return null;
        }
        return new Barcode.Email(zzxuVar.zza, zzxuVar.zzb, zzxuVar.zzc, zzxuVar.zzd);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getFormat() {
        return ((zzyb) this.zza).zza;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.GeoPoint getGeoPoint() {
        zzxv zzxvVar = ((zzyb) this.zza).zzl;
        if (zzxvVar != null) {
            return new Barcode.GeoPoint(zzxvVar.zza, zzxvVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public Barcode.Phone getPhone() {
        zzxx zzxxVar = ((zzyb) this.zza).zzh;
        if (zzxxVar != null) {
            return new Barcode.Phone(zzxxVar.zzb, zzxxVar.zza);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public byte[] getRawBytes() {
        return ((zzyb) this.zza).zzd;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public String getRawValue() {
        return ((zzyb) this.zza).zzc;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public GmsLogger getSms() {
        zzxy zzxyVar = ((zzyb) this.zza).zzi;
        if (zzxyVar != null) {
            return new GmsLogger(1, zzxyVar.zza, zzxyVar.zzb);
        }
        return null;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public RequestService getUrl() {
        zzxz zzxzVar = ((zzyb) this.zza).zzk;
        if (zzxzVar == null) {
            return null;
        }
        return new RequestService(23, zzxzVar.zza, zzxzVar.zzb, false);
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public int getValueType() {
        return ((zzyb) this.zza).zzf;
    }

    @Override // com.google.mlkit.vision.barcode.common.internal.BarcodeSource
    public StatusLine getWifi() {
        zzya zzyaVar = ((zzyb) this.zza).zzj;
        if (zzyaVar == null) {
            return null;
        }
        return new StatusLine(zzyaVar.zzc, zzyaVar.zza, zzyaVar.zzb);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((CountDownLatch) this.zza).countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((CountDownLatch) this.zza).countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((CountDownLatch) this.zza).countDown();
    }

    public zzs(int i) {
        switch (i) {
            case 9:
                this.zza = new LinkedHashSet();
                break;
            default:
                this.zza = new CountDownLatch(1);
                break;
        }
    }
}
