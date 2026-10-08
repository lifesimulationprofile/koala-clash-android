package io.github.g00fy2.quickie.extensions;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import com.google.mlkit.vision.barcode.common.Barcode;
import io.github.g00fy2.quickie.content.CalendarDateTimeParcelable;
import java.nio.BufferUnderflowException;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BarcodeExtensionsKt {
    public static boolean isFlashAvailable(OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0) {
        Boolean bool;
        try {
            CameraCharacteristics.Key key = CameraCharacteristics.FLASH_INFO_AVAILABLE;
            onBackPressedDispatcher$$ExternalSyntheticLambda0.getClass();
            bool = (Boolean) ((CameraCharacteristicsCompat) onBackPressedDispatcher$$ExternalSyntheticLambda0.f$0).get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e) {
            if (DeviceQuirks.sQuirks.get(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                LazyKt__LazyJVMKt.d("FlashAvailability", String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)));
            } else {
                LazyKt__LazyJVMKt.e("FlashAvailability", String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)), e);
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            LazyKt__LazyJVMKt.w("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final CalendarDateTimeParcelable toParcelableCalendarEvent(Barcode.CalendarDateTime calendarDateTime) {
        return new CalendarDateTimeParcelable(calendarDateTime != null ? calendarDateTime.zzc : -1, calendarDateTime != null ? calendarDateTime.zzd : -1, calendarDateTime != null ? calendarDateTime.zze : -1, calendarDateTime != null ? calendarDateTime.zzb : -1, calendarDateTime != null ? calendarDateTime.zzf : -1, calendarDateTime != null ? calendarDateTime.zza : -1, calendarDateTime != null ? calendarDateTime.zzg : false);
    }
}
