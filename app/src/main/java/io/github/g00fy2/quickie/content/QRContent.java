package io.github.g00fy2.quickie.content;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraNoResponseWhenEnablingFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashTooSlowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFlashNotFireQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWithFlashUnderexposureQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegCaptureDownsizingQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegHalCorruptImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.TemporalNoiseQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import androidx.camera.camera2.internal.compat.quirk.YuvImageOnePixelShiftQuirk;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.AutoValue_StateObservable_ErrorWrapper;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class QRContent {

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CalendarEvent extends QRContent {
        public final String description;
        public final CalendarDateTime end;
        public final String location;
        public final String organizer;
        public final byte[] rawBytes;
        public final String rawValue;
        public final CalendarDateTime start;
        public final String status;
        public final String summary;

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class CalendarDateTime {
            public final int day;
            public final int hours;
            public final int minutes;
            public final int month;
            public final int seconds;
            public final boolean utc;
            public final int year;

            public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
                this.day = i;
                this.hours = i2;
                this.minutes = i3;
                this.month = i4;
                this.seconds = i5;
                this.year = i6;
                this.utc = z;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CalendarDateTime)) {
                    return false;
                }
                CalendarDateTime calendarDateTime = (CalendarDateTime) obj;
                return this.day == calendarDateTime.day && this.hours == calendarDateTime.hours && this.minutes == calendarDateTime.minutes && this.month == calendarDateTime.month && this.seconds == calendarDateTime.seconds && this.year == calendarDateTime.year && this.utc == calendarDateTime.utc;
            }

            public final int hashCode() {
                return (((((((((((this.day * 31) + this.hours) * 31) + this.minutes) * 31) + this.month) * 31) + this.seconds) * 31) + this.year) * 31) + (this.utc ? 1231 : 1237);
            }

            public final String toString() {
                return "CalendarDateTime(day=" + this.day + ", hours=" + this.hours + ", minutes=" + this.minutes + ", month=" + this.month + ", seconds=" + this.seconds + ", year=" + this.year + ", utc=" + this.utc + ")";
            }
        }

        public CalendarEvent(byte[] bArr, String str, String str2, CalendarDateTime calendarDateTime, String str3, String str4, CalendarDateTime calendarDateTime2, String str5, String str6) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.description = str2;
            this.end = calendarDateTime;
            this.location = str3;
            this.organizer = str4;
            this.start = calendarDateTime2;
            this.status = str5;
            this.summary = str6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarEvent)) {
                return false;
            }
            CalendarEvent calendarEvent = (CalendarEvent) obj;
            return Intrinsics.areEqual(this.rawBytes, calendarEvent.rawBytes) && Intrinsics.areEqual(this.rawValue, calendarEvent.rawValue) && Intrinsics.areEqual(this.description, calendarEvent.description) && Intrinsics.areEqual(this.end, calendarEvent.end) && Intrinsics.areEqual(this.location, calendarEvent.location) && Intrinsics.areEqual(this.organizer, calendarEvent.organizer) && Intrinsics.areEqual(this.start, calendarEvent.start) && Intrinsics.areEqual(this.status, calendarEvent.status) && Intrinsics.areEqual(this.summary, calendarEvent.summary);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.summary.hashCode() + Modifier.CC.m((this.start.hashCode() + Modifier.CC.m(Modifier.CC.m((this.end.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.description)) * 31, 31, this.location), 31, this.organizer)) * 31, 31, this.status);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("CalendarEvent(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", description=");
            sbM.append(this.description);
            sbM.append(", end=");
            sbM.append(this.end);
            sbM.append(", location=");
            Density.CC.m(sbM, this.location, ", organizer=", this.organizer, ", start=");
            sbM.append(this.start);
            sbM.append(", status=");
            sbM.append(this.status);
            sbM.append(", summary=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.summary, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ContactInfo extends QRContent {
        public final ArrayList addresses;
        public final ArrayList emails;
        public final PersonName name;
        public final String organization;
        public final ArrayList phones;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String title;
        public final List urls;

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class Address {
            public final List addressLines;
            public final AddressType type;

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
            public final class AddressType {
                public static final /* synthetic */ EnumEntriesList $ENTRIES;
                public static final /* synthetic */ AddressType[] $VALUES;
                public static final AddressType UNKNOWN;

                static {
                    AddressType addressType = new AddressType("UNKNOWN", 0);
                    UNKNOWN = addressType;
                    AddressType[] addressTypeArr = {addressType, new AddressType("WORK", 1), new AddressType("HOME", 2)};
                    $VALUES = addressTypeArr;
                    $ENTRIES = new EnumEntriesList(addressTypeArr);
                }

                public static AddressType valueOf(String str) {
                    return (AddressType) Enum.valueOf(AddressType.class, str);
                }

                public static AddressType[] values() {
                    return (AddressType[]) $VALUES.clone();
                }
            }

            public Address(List list, AddressType addressType) {
                this.addressLines = list;
                this.type = addressType;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Address)) {
                    return false;
                }
                Address address = (Address) obj;
                return Intrinsics.areEqual(this.addressLines, address.addressLines) && this.type == address.type;
            }

            public final int hashCode() {
                return this.type.hashCode() + (this.addressLines.hashCode() * 31);
            }

            public final String toString() {
                return "Address(addressLines=" + this.addressLines + ", type=" + this.type + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class PersonName {
            public final String first;
            public final String formattedName;
            public final String last;
            public final String middle;
            public final String prefix;
            public final String pronunciation;
            public final String suffix;

            public PersonName(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                this.first = str;
                this.formattedName = str2;
                this.last = str3;
                this.middle = str4;
                this.prefix = str5;
                this.pronunciation = str6;
                this.suffix = str7;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PersonName)) {
                    return false;
                }
                PersonName personName = (PersonName) obj;
                return Intrinsics.areEqual(this.first, personName.first) && Intrinsics.areEqual(this.formattedName, personName.formattedName) && Intrinsics.areEqual(this.last, personName.last) && Intrinsics.areEqual(this.middle, personName.middle) && Intrinsics.areEqual(this.prefix, personName.prefix) && Intrinsics.areEqual(this.pronunciation, personName.pronunciation) && Intrinsics.areEqual(this.suffix, personName.suffix);
            }

            public final int hashCode() {
                return this.suffix.hashCode() + Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(Modifier.CC.m(this.first.hashCode() * 31, 31, this.formattedName), 31, this.last), 31, this.middle), 31, this.prefix), 31, this.pronunciation);
            }

            public final String toString() {
                StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("PersonName(first=", this.first, ", formattedName=", this.formattedName, ", last=");
                Density.CC.m(sbM, this.last, ", middle=", this.middle, ", prefix=");
                Density.CC.m(sbM, this.prefix, ", pronunciation=", this.pronunciation, ", suffix=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.suffix, ")");
            }
        }

        public ContactInfo(byte[] bArr, String str, ArrayList arrayList, ArrayList arrayList2, PersonName personName, String str2, ArrayList arrayList3, String str3, List list) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.addresses = arrayList;
            this.emails = arrayList2;
            this.name = personName;
            this.organization = str2;
            this.phones = arrayList3;
            this.title = str3;
            this.urls = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ContactInfo)) {
                return false;
            }
            ContactInfo contactInfo = (ContactInfo) obj;
            return Intrinsics.areEqual(this.rawBytes, contactInfo.rawBytes) && Intrinsics.areEqual(this.rawValue, contactInfo.rawValue) && this.addresses.equals(contactInfo.addresses) && this.emails.equals(contactInfo.emails) && this.name.equals(contactInfo.name) && Intrinsics.areEqual(this.organization, contactInfo.organization) && this.phones.equals(contactInfo.phones) && Intrinsics.areEqual(this.title, contactInfo.title) && Intrinsics.areEqual(this.urls, contactInfo.urls);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.urls.hashCode() + Modifier.CC.m((this.phones.hashCode() + Modifier.CC.m((this.name.hashCode() + ((this.emails.hashCode() + ((this.addresses.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31)) * 31, 31, this.organization)) * 31, 31, this.title);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("ContactInfo(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", addresses=");
            sbM.append(this.addresses);
            sbM.append(", emails=");
            sbM.append(this.emails);
            sbM.append(", name=");
            sbM.append(this.name);
            sbM.append(", organization=");
            sbM.append(this.organization);
            sbM.append(", phones=");
            sbM.append(this.phones);
            sbM.append(", title=");
            sbM.append(this.title);
            sbM.append(", urls=");
            sbM.append(this.urls);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Email extends QRContent {
        public final String address;
        public final String body;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String subject;
        public final EmailType type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class EmailType {
            public static final /* synthetic */ EnumEntriesList $ENTRIES;
            public static final /* synthetic */ EmailType[] $VALUES;
            public static final EmailType UNKNOWN;

            static {
                EmailType emailType = new EmailType("UNKNOWN", 0);
                UNKNOWN = emailType;
                EmailType[] emailTypeArr = {emailType, new EmailType("WORK", 1), new EmailType("HOME", 2)};
                $VALUES = emailTypeArr;
                $ENTRIES = new EnumEntriesList(emailTypeArr);
            }

            public static EmailType valueOf(String str) {
                return (EmailType) Enum.valueOf(EmailType.class, str);
            }

            public static EmailType[] values() {
                return (EmailType[]) $VALUES.clone();
            }
        }

        public Email(byte[] bArr, String str, String str2, String str3, String str4, EmailType emailType) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.address = str2;
            this.body = str3;
            this.subject = str4;
            this.type = emailType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email = (Email) obj;
            return Intrinsics.areEqual(this.rawBytes, email.rawBytes) && Intrinsics.areEqual(this.rawValue, email.rawValue) && Intrinsics.areEqual(this.address, email.address) && Intrinsics.areEqual(this.body, email.body) && Intrinsics.areEqual(this.subject, email.subject) && this.type == email.type;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.type.hashCode() + Modifier.CC.m(Modifier.CC.m(Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.address), 31, this.body), 31, this.subject);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Email(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", address=");
            Density.CC.m(sbM, this.address, ", body=", this.body, ", subject=");
            sbM.append(this.subject);
            sbM.append(", type=");
            sbM.append(this.type);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class GeoPoint extends QRContent {
        public final double lat;
        public final double lng;
        public final byte[] rawBytes;
        public final String rawValue;

        public GeoPoint(byte[] bArr, String str, double d, double d2) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.lat = d;
            this.lng = d2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GeoPoint)) {
                return false;
            }
            GeoPoint geoPoint = (GeoPoint) obj;
            return Intrinsics.areEqual(this.rawBytes, geoPoint.rawBytes) && Intrinsics.areEqual(this.rawValue, geoPoint.rawValue) && Double.compare(this.lat, geoPoint.lat) == 0 && Double.compare(this.lng, geoPoint.lng) == 0;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            int iHashCode2 = str != null ? str.hashCode() : 0;
            long jDoubleToLongBits = Double.doubleToLongBits(this.lat);
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
            long jDoubleToLongBits2 = Double.doubleToLongBits(this.lng);
            return i + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("GeoPoint(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", lat=");
            sbM.append(this.lat);
            sbM.append(", lng=");
            sbM.append(this.lng);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Phone extends QRContent {
        public final String number;
        public final byte[] rawBytes;
        public final String rawValue;
        public final PhoneType type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
        public final class PhoneType {
            public static final /* synthetic */ EnumEntriesList $ENTRIES;
            public static final /* synthetic */ PhoneType[] $VALUES;
            public static final PhoneType UNKNOWN;

            static {
                PhoneType phoneType = new PhoneType("UNKNOWN", 0);
                UNKNOWN = phoneType;
                PhoneType[] phoneTypeArr = {phoneType, new PhoneType("WORK", 1), new PhoneType("HOME", 2), new PhoneType("FAX", 3), new PhoneType("MOBILE", 4)};
                $VALUES = phoneTypeArr;
                $ENTRIES = new EnumEntriesList(phoneTypeArr);
            }

            public static PhoneType valueOf(String str) {
                return (PhoneType) Enum.valueOf(PhoneType.class, str);
            }

            public static PhoneType[] values() {
                return (PhoneType[]) $VALUES.clone();
            }
        }

        public Phone(byte[] bArr, String str, String str2, PhoneType phoneType) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.number = str2;
            this.type = phoneType;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Phone)) {
                return false;
            }
            Phone phone = (Phone) obj;
            return Intrinsics.areEqual(this.rawBytes, phone.rawBytes) && Intrinsics.areEqual(this.rawValue, phone.rawValue) && Intrinsics.areEqual(this.number, phone.number) && this.type == phone.type;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.type.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.number);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Phone(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", number=");
            sbM.append(this.number);
            sbM.append(", type=");
            sbM.append(this.type);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Plain extends QRContent {
        public final byte[] rawBytes;
        public final String rawValue;

        public Plain(byte[] bArr, String str) {
            this.rawBytes = bArr;
            this.rawValue = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Plain)) {
                return false;
            }
            Plain plain = (Plain) obj;
            return Intrinsics.areEqual(this.rawBytes, plain.rawBytes) && Intrinsics.areEqual(this.rawValue, plain.rawValue);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            return "Plain(rawBytes=" + Arrays.toString(this.rawBytes) + ", rawValue=" + this.rawValue + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Sms extends QRContent {
        public final String message;
        public final String phoneNumber;
        public final byte[] rawBytes;
        public final String rawValue;

        public Sms(byte[] bArr, String str, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.message = str2;
            this.phoneNumber = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Sms)) {
                return false;
            }
            Sms sms = (Sms) obj;
            return Intrinsics.areEqual(this.rawBytes, sms.rawBytes) && Intrinsics.areEqual(this.rawValue, sms.rawValue) && Intrinsics.areEqual(this.message, sms.message) && Intrinsics.areEqual(this.phoneNumber, sms.phoneNumber);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.phoneNumber.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.message);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Sms(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", message=");
            sbM.append(this.message);
            sbM.append(", phoneNumber=");
            sbM.append(this.phoneNumber);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Url extends QRContent {
        public final byte[] rawBytes;
        public final String rawValue;
        public final String title;
        public final String url;

        public Url(byte[] bArr, String str, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.title = str2;
            this.url = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.rawBytes, url.rawBytes) && Intrinsics.areEqual(this.rawValue, url.rawValue) && Intrinsics.areEqual(this.title, url.title) && Intrinsics.areEqual(this.url, url.url);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.url.hashCode() + Modifier.CC.m((iHashCode + (str != null ? str.hashCode() : 0)) * 31, 31, this.title);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Url(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", title=");
            sbM.append(this.title);
            sbM.append(", url=");
            sbM.append(this.url);
            sbM.append(")");
            return sbM.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Wifi extends QRContent {
        public final int encryptionType;
        public final String password;
        public final byte[] rawBytes;
        public final String rawValue;
        public final String ssid;

        public Wifi(byte[] bArr, String str, int i, String str2, String str3) {
            this.rawBytes = bArr;
            this.rawValue = str;
            this.encryptionType = i;
            this.password = str2;
            this.ssid = str3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wifi)) {
                return false;
            }
            Wifi wifi = (Wifi) obj;
            return Intrinsics.areEqual(this.rawBytes, wifi.rawBytes) && Intrinsics.areEqual(this.rawValue, wifi.rawValue) && this.encryptionType == wifi.encryptionType && Intrinsics.areEqual(this.password, wifi.password) && Intrinsics.areEqual(this.ssid, wifi.ssid);
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final byte[] getRawBytes() {
            return this.rawBytes;
        }

        @Override // io.github.g00fy2.quickie.content.QRContent
        public final String getRawValue() {
            return this.rawValue;
        }

        public final int hashCode() {
            byte[] bArr = this.rawBytes;
            int iHashCode = (bArr == null ? 0 : Arrays.hashCode(bArr)) * 31;
            String str = this.rawValue;
            return this.ssid.hashCode() + Modifier.CC.m((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.encryptionType) * 31, 31, this.password);
        }

        public final String toString() {
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Wifi(rawBytes=", Arrays.toString(this.rawBytes), ", rawValue=", this.rawValue, ", encryptionType=");
            sbM.append(this.encryptionType);
            sbM.append(", password=");
            sbM.append(this.password);
            sbM.append(", ssid=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sbM, this.ssid, ")");
        }
    }

    /* JADX WARN: Code duplicated, block: B:304:0x0517  */
    /* JADX WARN: Code duplicated, block: B:337:0x05a7  */
    public static Headers.Builder get(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer num;
        QuirkSettingsHolder quirkSettingsHolder = QuirkSettingsHolder.sInstance;
        quirkSettingsHolder.getClass();
        try {
            try {
                Object obj = ((AtomicReference) quirkSettingsHolder.mObservable.before).get();
                QuirkSettings quirkSettings = (QuirkSettings) (obj instanceof AutoValue_StateObservable_ErrorWrapper ? new ImmediateFuture$ImmediateFailedFuture(0, null) : Futures.immediateFuture(obj)).get();
                ArrayList arrayList = new ArrayList();
                CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num2 = (Integer) cameraCharacteristicsCompat.get(key);
                if (quirkSettings.shouldEnableQuirk(AeFpsRangeLegacyQuirk.class, num2 != null && num2.intValue() == 2)) {
                    arrayList.add(new AeFpsRangeLegacyQuirk(cameraCharacteristicsCompat));
                }
                if (quirkSettings.shouldEnableQuirk(AspectRatioLegacyApi21Quirk.class, false)) {
                    arrayList.add(new AspectRatioLegacyApi21Quirk());
                }
                HashSet hashSet = JpegHalCorruptImageQuirk.KNOWN_AFFECTED_DEVICES;
                String str = Build.DEVICE;
                Locale locale = Locale.US;
                if (quirkSettings.shouldEnableQuirk(JpegHalCorruptImageQuirk.class, hashSet.contains(str.toLowerCase(locale)))) {
                    arrayList.add(new JpegHalCorruptImageQuirk());
                }
                HashSet hashSet2 = JpegCaptureDownsizingQuirk.KNOWN_AFFECTED_FRONT_CAMERA_DEVICES;
                String str2 = Build.MODEL;
                if (quirkSettings.shouldEnableQuirk(JpegCaptureDownsizingQuirk.class, hashSet2.contains(str2.toLowerCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new JpegCaptureDownsizingQuirk());
                }
                Integer num3 = (Integer) cameraCharacteristicsCompat.get(key);
                if (quirkSettings.shouldEnableQuirk(CamcorderProfileResolutionQuirk.class, num3 != null && num3.intValue() == 2)) {
                    CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk = new CamcorderProfileResolutionQuirk();
                    cameraCharacteristicsCompat.getStreamConfigurationMapCompat();
                    arrayList.add(camcorderProfileResolutionQuirk);
                }
                String str3 = Build.HARDWARE;
                if (quirkSettings.shouldEnableQuirk(CaptureNoResponseQuirk.class, ("samsungexynos7420".equalsIgnoreCase(str3) || "universal7420".equalsIgnoreCase(str3)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CaptureNoResponseQuirk());
                }
                Integer num4 = (Integer) cameraCharacteristicsCompat.get(key);
                int i = Build.VERSION.SDK_INT;
                if (quirkSettings.shouldEnableQuirk(LegacyCameraOutputConfigNullPointerQuirk.class, i > 23 && num4 != null && num4.intValue() == 2)) {
                    arrayList.add(new LegacyCameraOutputConfigNullPointerQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(LegacyCameraSurfaceCleanupQuirk.class, i > 23 && i < 29 && (num = (Integer) cameraCharacteristicsCompat.get(key)) != null && num.intValue() == 2)) {
                    arrayList.add(new LegacyCameraSurfaceCleanupQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.BUILD_MODELS.contains(str2.toUpperCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWashedOutImageQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.AFFECTED_MODELS.contains(str2.toUpperCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
                }
                String str4 = Build.BRAND;
                if (quirkSettings.shouldEnableQuirk(YuvImageOnePixelShiftQuirk.class, ("motorola".equalsIgnoreCase(str4) && "MotoG3".equalsIgnoreCase(str2)) || ("samsung".equalsIgnoreCase(str4) && "SM-G532F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J700F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-A920F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J415F".equalsIgnoreCase(str2)) || ("xiaomi".equalsIgnoreCase(str4) && "Mi A1".equalsIgnoreCase(str2))))))) {
                    arrayList.add(new YuvImageOnePixelShiftQuirk());
                }
                Iterator it = FlashTooSlowQuirk.AFFECTED_MODEL_PREFIXES.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                            if (((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    break;
                }
                if (quirkSettings.shouldEnableQuirk(FlashTooSlowQuirk.class, z)) {
                    arrayList.add(new FlashTooSlowQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(AfRegionFlipHorizontallyQuirk.class, Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new AfRegionFlipHorizontallyQuirk());
                }
                CameraCharacteristics.Key key2 = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num5 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(ConfigureSurfaceToSecondarySessionFailQuirk.class, num5 != null && num5.intValue() == 2)) {
                    arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
                }
                Integer num6 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(PreviewOrientationIncorrectQuirk.class, num6 != null && num6.intValue() == 2)) {
                    arrayList.add(new PreviewOrientationIncorrectQuirk());
                }
                Integer num7 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(CaptureSessionStuckQuirk.class, num7 != null && num7.intValue() == 2)) {
                    arrayList.add(new CaptureSessionStuckQuirk());
                }
                List list = ImageCaptureFlashNotFireQuirk.BUILD_MODELS_FRONT_CAMERA;
                String str5 = Build.MODEL;
                Locale locale2 = Locale.US;
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFlashNotFireQuirk.class, (list.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) || ImageCaptureFlashNotFireQuirk.BUILD_MODELS.contains(str5.toLowerCase(locale2)))) {
                    arrayList.add(new ImageCaptureFlashNotFireQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.BUILD_MODELS.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.BUILD_MODELS_FRONT_CAMERA.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
                }
                Integer num8 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(IncorrectCaptureStateQuirk.class, num8 != null && num8.intValue() == 2)) {
                    arrayList.add(new IncorrectCaptureStateQuirk());
                }
                Iterator it2 = TorchFlashRequiredFor3aUpdateQuirk.AFFECTED_PIXEL_MODELS.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).equals((String) it2.next())) {
                            if (((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    break;
                }
                if (quirkSettings.shouldEnableQuirk(TorchFlashRequiredFor3aUpdateQuirk.class, z2)) {
                    arrayList.add(new TorchFlashRequiredFor3aUpdateQuirk());
                }
                String str6 = Build.MANUFACTURER;
                if (quirkSettings.shouldEnableQuirk(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, ("HUAWEI".equalsIgnoreCase(str6) && "HUAWEI ALE-L04".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j320f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j700f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j111f".equalsIgnoreCase(Build.MODEL)) || (("OPPO".equalsIgnoreCase(str6) && "A37F".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j510fn".equalsIgnoreCase(Build.MODEL))))))) {
                    arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, "Huawei".equalsIgnoreCase(str6))) {
                    arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
                }
                String str7 = Build.BRAND;
                if (("blu".equalsIgnoreCase(str7) && "studio x10".equalsIgnoreCase(Build.MODEL)) || (("itel".equalsIgnoreCase(str7) && "itel w6004".equalsIgnoreCase(Build.MODEL)) || (("vivo".equalsIgnoreCase(str7) && "vivo 1805".equalsIgnoreCase(Build.MODEL)) || ("positivo".equalsIgnoreCase(str7) && "twist 2 pro".equalsIgnoreCase(Build.MODEL))))) {
                    z3 = true;
                } else {
                    String str8 = Build.MODEL;
                    if (("pixel 4 xl".equalsIgnoreCase(str8) && Build.VERSION.SDK_INT == 29) || ("motorola".equalsIgnoreCase(str7) && "moto e13".equalsIgnoreCase(str8))) {
                        z3 = true;
                    } else {
                        if ("samsung".equalsIgnoreCase(str7)) {
                            String str9 = Build.DEVICE;
                            if ("gta8".equalsIgnoreCase(str9) || "gta8wifi".equalsIgnoreCase(str9)) {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, z3)) {
                    arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
                }
                String str10 = Build.MODEL;
                if (quirkSettings.shouldEnableQuirk(TemporalNoiseQuirk.class, "Pixel 8".equalsIgnoreCase(str10) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new TemporalNoiseQuirk());
                }
                HashSet hashSet3 = ImageCaptureFailedForVideoSnapshotQuirk.PROBLEMATIC_UNI_SOC_MODELS;
                Locale locale3 = Locale.US;
                if (hashSet3.contains(str10.toLowerCase(locale3)) || (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER))) {
                    z4 = true;
                } else {
                    String str11 = Build.HARDWARE;
                    if (str11.toLowerCase(locale3).startsWith("ums") || (("itel".equalsIgnoreCase(str7) && str11.toLowerCase(locale3).startsWith("sp")) || ("HUAWEI".equalsIgnoreCase(str7) && "FIG-LX1".equalsIgnoreCase(str10)))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailedForVideoSnapshotQuirk.class, z4)) {
                    arrayList.add(new ImageCaptureFailedForVideoSnapshotQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk.class, "samsung".equalsIgnoreCase(str7) && str10.toLowerCase(locale3).startsWith("sm-m556"))) {
                    arrayList.add(new AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk());
                }
                Headers.Builder builder = new Headers.Builder(arrayList);
                LazyKt__LazyJVMKt.d("CameraQuirks", "camera2 CameraQuirks = " + Headers.Builder.toString(builder));
                return builder;
            } catch (InterruptedException e) {
                e = e;
                throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e);
            }
        } catch (InterruptedException | ExecutionException e2) {
            e = e2;
        }
    }

    public abstract byte[] getRawBytes();

    public abstract String getRawValue();
}
