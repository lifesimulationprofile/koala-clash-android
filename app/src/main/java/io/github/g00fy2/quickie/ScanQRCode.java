package io.github.g00fy2.quickie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.work.WorkManager;
import io.github.g00fy2.quickie.content.AddressParcelable;
import io.github.g00fy2.quickie.content.CalendarDateTimeParcelable;
import io.github.g00fy2.quickie.content.CalendarEventParcelable;
import io.github.g00fy2.quickie.content.ContactInfoParcelable;
import io.github.g00fy2.quickie.content.EmailParcelable;
import io.github.g00fy2.quickie.content.GeoPointParcelable;
import io.github.g00fy2.quickie.content.PersonNameParcelable;
import io.github.g00fy2.quickie.content.PhoneParcelable;
import io.github.g00fy2.quickie.content.QRContent;
import io.github.g00fy2.quickie.content.SmsParcelable;
import io.github.g00fy2.quickie.content.UrlBookmarkParcelable;
import io.github.g00fy2.quickie.content.WifiParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.enums.EnumEntriesList;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ScanQRCode extends WorkManager {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ScanQRCode(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.work.WorkManager
    public final Intent createIntent(AppCompatActivity appCompatActivity, Object obj) {
        Bundle bundleExtra;
        switch (this.$r8$classId) {
            case 0:
                return new Intent(appCompatActivity, (Class<?>) QRScannerActivity.class);
            case 1:
                return new Intent("android.intent.action.CREATE_DOCUMENT").setType("text/plain").putExtra("android.intent.extra.TITLE", (String) obj);
            case 2:
                return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType((String) obj);
            case 3:
                return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
            case 4:
                return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{(String) obj});
            case 5:
                return (Intent) obj;
            default:
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = intentSenderRequest.fillInIntent;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        intentSenderRequest = new IntentSenderRequest(intentSenderRequest.intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
        }
    }

    @Override // androidx.work.WorkManager
    public PreviewView.AnonymousClass1 getSynchronousResult(AppCompatActivity appCompatActivity, Object obj) {
        switch (this.$r8$classId) {
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                String[] strArr = (String[]) obj;
                if (strArr.length == 0) {
                    return new PreviewView.AnonymousClass1(1, EmptyMap.INSTANCE);
                }
                for (String str : strArr) {
                    if (ContextCompat.checkSelfPermission(appCompatActivity, str) != 0) {
                        return null;
                    }
                }
                int iMapCapacity = MapsKt__MapsKt.mapCapacity(strArr.length);
                if (iMapCapacity < 16) {
                    iMapCapacity = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new PreviewView.AnonymousClass1(1, linkedHashMap);
            case 4:
                if (ContextCompat.checkSelfPermission(appCompatActivity, (String) obj) != 0) {
                    return null;
                }
                return new PreviewView.AnonymousClass1(1, Boolean.TRUE);
            default:
                return super.getSynchronousResult(appCompatActivity, obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0193  */
    /* JADX WARN: Code duplicated, block: B:190:0x03a0  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Iterable, java.lang.Object] */
    @Override // androidx.work.WorkManager
    public final Object parseResult(Intent intent, int i) {
        Object qRSuccess;
        QRContent contactInfo;
        Object obj;
        CalendarEventParcelable calendarEventParcelable;
        Exception illegalStateException;
        Intent intent2 = intent;
        switch (this.$r8$classId) {
            case 0:
                if (i == -1) {
                    QRContent plain = null;
                    byte[] byteArrayExtra = intent2 != null ? intent2.getByteArrayExtra("quickie-bytes") : null;
                    String stringExtra = intent2 != null ? intent2.getStringExtra("quickie-value") : null;
                    if (intent2 == null) {
                        plain = new QRContent.Plain(byteArrayExtra, stringExtra);
                    } else {
                        Bundle extras = intent2.getExtras();
                        Integer numValueOf = extras != null ? Integer.valueOf(extras.getInt("quickie-type", 0)) : null;
                        QRContent.Phone.PhoneType phoneType = QRContent.Phone.PhoneType.UNKNOWN;
                        EnumEntriesList enumEntriesList = QRContent.Phone.PhoneType.$ENTRIES;
                        Object obj2 = QRContent.Email.EmailType.UNKNOWN;
                        EnumEntriesList enumEntriesList2 = QRContent.Email.EmailType.$ENTRIES;
                        int i2 = 10;
                        if (numValueOf != null && numValueOf.intValue() == 1) {
                            ContactInfoParcelable contactInfoParcelable = (ContactInfoParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", ContactInfoParcelable.class);
                            if (contactInfoParcelable != null) {
                                ?? r3 = contactInfoParcelable.addressParcelables;
                                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, 10));
                                for (AddressParcelable addressParcelable : r3) {
                                    List list = addressParcelable.addressLines;
                                    int i3 = addressParcelable.type;
                                    if (i3 >= 0) {
                                        EnumEntriesList enumEntriesList3 = QRContent.ContactInfo.Address.AddressType.$ENTRIES;
                                        if (i3 < enumEntriesList3.getSize()) {
                                            obj = enumEntriesList3.get(i3);
                                        } else {
                                            obj = QRContent.ContactInfo.Address.AddressType.UNKNOWN;
                                        }
                                    } else {
                                        obj = QRContent.ContactInfo.Address.AddressType.UNKNOWN;
                                    }
                                    arrayList.add(new QRContent.ContactInfo.Address(list, (QRContent.ContactInfo.Address.AddressType) obj));
                                }
                                ?? r4 = contactInfoParcelable.emailParcelables;
                                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, 10));
                                for (EmailParcelable emailParcelable : r4) {
                                    int i4 = i2;
                                    String str = emailParcelable.address;
                                    String str2 = emailParcelable.body;
                                    String str3 = emailParcelable.subject;
                                    int i5 = emailParcelable.type;
                                    arrayList2.add(new QRContent.Email(byteArrayExtra, stringExtra, str, str2, str3, (QRContent.Email.EmailType) ((i5 < 0 || i5 >= enumEntriesList2.getSize()) ? obj2 : enumEntriesList2.get(i5))));
                                    enumEntriesList2 = enumEntriesList2;
                                    i2 = i4;
                                    arrayList = arrayList;
                                }
                                ArrayList arrayList3 = arrayList;
                                PersonNameParcelable personNameParcelable = contactInfoParcelable.nameParcelable;
                                QRContent.ContactInfo.PersonName personName = new QRContent.ContactInfo.PersonName(personNameParcelable.first, personNameParcelable.formattedName, personNameParcelable.last, personNameParcelable.middle, personNameParcelable.prefix, personNameParcelable.pronunciation, personNameParcelable.suffix);
                                String str4 = contactInfoParcelable.organization;
                                ?? r1 = contactInfoParcelable.phoneParcelables;
                                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r1, i2));
                                for (PhoneParcelable phoneParcelable : r1) {
                                    String str5 = phoneParcelable.number;
                                    int i6 = phoneParcelable.type;
                                    arrayList4.add(new QRContent.Phone(byteArrayExtra, stringExtra, str5, (QRContent.Phone.PhoneType) ((i6 < 0 || i6 >= enumEntriesList.getSize()) ? phoneType : enumEntriesList.get(i6))));
                                }
                                contactInfo = new QRContent.ContactInfo(byteArrayExtra, stringExtra, arrayList3, arrayList2, personName, str4, arrayList4, contactInfoParcelable.title, contactInfoParcelable.urls);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 2) {
                            EmailParcelable emailParcelable2 = (EmailParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", EmailParcelable.class);
                            if (emailParcelable2 != null) {
                                String str6 = emailParcelable2.address;
                                String str7 = emailParcelable2.body;
                                String str8 = emailParcelable2.subject;
                                int i7 = emailParcelable2.type;
                                if (i7 >= 0 && i7 < enumEntriesList2.getSize()) {
                                    obj2 = enumEntriesList2.get(i7);
                                }
                                contactInfo = new QRContent.Email(byteArrayExtra, stringExtra, str6, str7, str8, (QRContent.Email.EmailType) obj2);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 4) {
                            PhoneParcelable phoneParcelable2 = (PhoneParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", PhoneParcelable.class);
                            if (phoneParcelable2 != null) {
                                String str9 = phoneParcelable2.number;
                                int i8 = phoneParcelable2.type;
                                plain = new QRContent.Phone(byteArrayExtra, stringExtra, str9, (QRContent.Phone.PhoneType) ((i8 < 0 || i8 >= enumEntriesList.getSize()) ? phoneType : enumEntriesList.get(i8)));
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 6) {
                            SmsParcelable smsParcelable = (SmsParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", SmsParcelable.class);
                            if (smsParcelable != null) {
                                plain = new QRContent.Sms(byteArrayExtra, stringExtra, smsParcelable.message, smsParcelable.phoneNumber);
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 8) {
                            UrlBookmarkParcelable urlBookmarkParcelable = (UrlBookmarkParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", UrlBookmarkParcelable.class);
                            if (urlBookmarkParcelable != null) {
                                plain = new QRContent.Url(byteArrayExtra, stringExtra, urlBookmarkParcelable.title, urlBookmarkParcelable.url);
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 9) {
                            WifiParcelable wifiParcelable = (WifiParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", WifiParcelable.class);
                            if (wifiParcelable != null) {
                                contactInfo = new QRContent.Wifi(byteArrayExtra, stringExtra, wifiParcelable.encryptionType, wifiParcelable.password, wifiParcelable.ssid);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 10) {
                            GeoPointParcelable geoPointParcelable = (GeoPointParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", GeoPointParcelable.class);
                            if (geoPointParcelable != null) {
                                contactInfo = new QRContent.GeoPoint(byteArrayExtra, stringExtra, geoPointParcelable.lat, geoPointParcelable.lng);
                                plain = contactInfo;
                            }
                        } else if (numValueOf != null && numValueOf.intValue() == 11 && (calendarEventParcelable = (CalendarEventParcelable) IntentCompat.getParcelableExtra(intent2, "quickie-parcelable", CalendarEventParcelable.class)) != null) {
                            String str10 = calendarEventParcelable.description;
                            CalendarDateTimeParcelable calendarDateTimeParcelable = calendarEventParcelable.end;
                            QRContent.CalendarEvent.CalendarDateTime calendarDateTime = new QRContent.CalendarEvent.CalendarDateTime(calendarDateTimeParcelable.day, calendarDateTimeParcelable.hours, calendarDateTimeParcelable.minutes, calendarDateTimeParcelable.month, calendarDateTimeParcelable.seconds, calendarDateTimeParcelable.year, calendarDateTimeParcelable.utc);
                            String str11 = calendarEventParcelable.location;
                            String str12 = calendarEventParcelable.organizer;
                            CalendarDateTimeParcelable calendarDateTimeParcelable2 = calendarEventParcelable.start;
                            contactInfo = new QRContent.CalendarEvent(byteArrayExtra, stringExtra, str10, calendarDateTime, str11, str12, new QRContent.CalendarEvent.CalendarDateTime(calendarDateTimeParcelable2.day, calendarDateTimeParcelable2.hours, calendarDateTimeParcelable2.minutes, calendarDateTimeParcelable2.month, calendarDateTimeParcelable2.seconds, calendarDateTimeParcelable2.year, calendarDateTimeParcelable2.utc), calendarEventParcelable.status, calendarEventParcelable.summary);
                            plain = contactInfo;
                        }
                        if (plain == null) {
                            plain = new QRContent.Plain(byteArrayExtra, stringExtra);
                        }
                    }
                    qRSuccess = new QRResult.QRSuccess(plain);
                } else {
                    if (i == 0) {
                        return QRResult.QRUserCanceled.INSTANCE;
                    }
                    if (i == 2) {
                        return QRResult.QRMissingPermission.INSTANCE;
                    }
                    if (i != 3) {
                        return new QRResult.QRError(new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown activity result code ", i)));
                    }
                    if (intent2 == null || (illegalStateException = (Exception) IntentCompat.getParcelableExtra(intent2, "quickie-exception", Exception.class)) == null) {
                        illegalStateException = new IllegalStateException("Could retrieve root exception");
                    }
                    qRSuccess = new QRResult.QRError(illegalStateException);
                }
                return qRSuccess;
            case 1:
                if (i != -1) {
                    intent2 = null;
                }
                if (intent2 != null) {
                    return intent2.getData();
                }
                return null;
            case 2:
                if (i != -1) {
                    intent2 = null;
                }
                if (intent2 != null) {
                    return intent2.getData();
                }
                return null;
            case 3:
                if (i == -1 && intent2 != null) {
                    String[] stringArrayExtra = intent2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent2.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList5 = new ArrayList(intArrayExtra.length);
                        for (int i9 : intArrayExtra) {
                            arrayList5.add(Boolean.valueOf(i9 == 0));
                        }
                        ArrayList arrayListFilterNotNull = ArraysKt.filterNotNull(stringArrayExtra);
                        Iterator it = arrayListFilterNotNull.iterator();
                        Iterator it2 = arrayList5.iterator();
                        ArrayList arrayList6 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListFilterNotNull, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList6.add(new Pair(it.next(), it2.next()));
                        }
                        return MapsKt__MapsKt.toMap(arrayList6);
                    }
                }
                return EmptyMap.INSTANCE;
            case 4:
                if (intent2 == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent2.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                boolean z = false;
                if (intArrayExtra2 != null) {
                    for (int i10 : intArrayExtra2) {
                        if (i10 == 0) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 5:
                return new ActivityResult(intent2, i);
            default:
                return new ActivityResult(intent2, i);
        }
    }
}
