package com.google.mlkit.vision.barcode.common.internal;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.TooltipPopup;
import coil.request.RequestService;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.vision.barcode.common.Barcode;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface BarcodeSource {
    Rect getBoundingBox();

    TooltipPopup getCalendarEvent();

    TooltipPopup getContactInfo();

    Point[] getCornerPoints();

    Barcode.Email getEmail();

    int getFormat();

    Barcode.GeoPoint getGeoPoint();

    Barcode.Phone getPhone();

    byte[] getRawBytes();

    String getRawValue();

    GmsLogger getSms();

    RequestService getUrl();

    int getValueType();

    StatusLine getWifi();
}
