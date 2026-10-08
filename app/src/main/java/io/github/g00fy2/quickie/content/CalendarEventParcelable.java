package io.github.g00fy2.quickie.content;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CalendarEventParcelable implements Parcelable {
    public static final Parcelable.Creator<CalendarEventParcelable> CREATOR = new zzb(12);
    public final String description;
    public final CalendarDateTimeParcelable end;
    public final String location;
    public final String organizer;
    public final CalendarDateTimeParcelable start;
    public final String status;
    public final String summary;

    public CalendarEventParcelable(String str, CalendarDateTimeParcelable calendarDateTimeParcelable, String str2, String str3, CalendarDateTimeParcelable calendarDateTimeParcelable2, String str4, String str5) {
        this.description = str;
        this.end = calendarDateTimeParcelable;
        this.location = str2;
        this.organizer = str3;
        this.start = calendarDateTimeParcelable2;
        this.status = str4;
        this.summary = str5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.description);
        this.end.writeToParcel(parcel, i);
        parcel.writeString(this.location);
        parcel.writeString(this.organizer);
        this.start.writeToParcel(parcel, i);
        parcel.writeString(this.status);
        parcel.writeString(this.summary);
    }
}
