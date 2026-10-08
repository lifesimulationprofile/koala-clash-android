package com.github.kr328.clash.service;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import androidx.work.impl.WorkLauncherImpl;
import coil.intercept.EngineInterceptor;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import dev.chrisbanes.haze.HazeStyleKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileProcessor {
    public static final ContextScope logoScope;
    public static final ConcurrentHashMap pendingLogos;
    public static final ProfileProcessor INSTANCE = new ProfileProcessor();
    public static final MutexImpl profileLock = new MutexImpl();
    public static final MutexImpl processLock = new MutexImpl();
    public static final SynchronizedLazyImpl httpClient$delegate = new SynchronizedLazyImpl(new HazeStyleKt$$ExternalSyntheticLambda0(1));

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ProfileMeta {
        public final String announce;
        public final long download;
        public final long expire;
        public final Long intervalSeconds;
        public final boolean modeSwitchAllowed;
        public final String profileLogoUrl;
        public final String supportURL;
        public final String title;
        public final long total;
        public final long upload;

        public /* synthetic */ ProfileMeta(long j, long j2, long j3, long j4, int i) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, null, null, null, null, null, true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProfileMeta)) {
                return false;
            }
            ProfileMeta profileMeta = (ProfileMeta) obj;
            return this.upload == profileMeta.upload && this.download == profileMeta.download && this.total == profileMeta.total && this.expire == profileMeta.expire && Intrinsics.areEqual(this.title, profileMeta.title) && Intrinsics.areEqual(this.intervalSeconds, profileMeta.intervalSeconds) && Intrinsics.areEqual(this.announce, profileMeta.announce) && Intrinsics.areEqual(this.supportURL, profileMeta.supportURL) && Intrinsics.areEqual(this.profileLogoUrl, profileMeta.profileLogoUrl) && this.modeSwitchAllowed == profileMeta.modeSwitchAllowed;
        }

        public final int hashCode() {
            long j = this.upload;
            long j2 = this.download;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.total;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.expire;
            int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
            String str = this.title;
            int iHashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.intervalSeconds;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str2 = this.announce;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.supportURL;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.profileLogoUrl;
            return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.modeSwitchAllowed ? 1231 : 1237);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ProfileMeta(upload=");
            sb.append(this.upload);
            sb.append(", download=");
            sb.append(this.download);
            sb.append(", total=");
            sb.append(this.total);
            sb.append(", expire=");
            sb.append(this.expire);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", intervalSeconds=");
            sb.append(this.intervalSeconds);
            sb.append(", announce=");
            sb.append(this.announce);
            Density.CC.m(sb, ", supportURL=", this.supportURL, ", profileLogoUrl=", this.profileLogoUrl);
            sb.append(", modeSwitchAllowed=");
            sb.append(this.modeSwitchAllowed);
            sb.append(")");
            return sb.toString();
        }

        public ProfileMeta(long j, long j2, long j3, long j4, String str, Long l, String str2, String str3, String str4, boolean z) {
            this.upload = j;
            this.download = j2;
            this.total = j3;
            this.expire = j4;
            this.title = str;
            this.intervalSeconds = l;
            this.announce = str2;
            this.supportURL = str3;
            this.profileLogoUrl = str4;
            this.modeSwitchAllowed = z;
        }
    }

    static {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        logoScope = JobKt.CoroutineScope(CoroutineContext.DefaultImpls.plus(DefaultIoScheduler.INSTANCE, JobKt.SupervisorJob$default()));
        pendingLogos = new ConcurrentHashMap();
    }

    public static final void access$commitFiles(File file, File file2) throws IOException {
        FilesKt.deleteRecursively(file2);
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.renameTo(file2)) {
            return;
        }
        FilesKt.copyRecursively$default(file, file2, 6);
        FilesKt.deleteRecursively(file);
    }

    public static final void access$enforceFieldsValid(String str, Profile.Type type, String str2, long j) {
        String scheme;
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Empty name");
        }
        int length = str2.length();
        Profile.Type type2 = Profile.Type.File;
        if (length == 0 && type != type2) {
            throw new IllegalArgumentException("Invalid url");
        }
        if (str2.length() <= 0 || type == type2) {
            if (j != 0 && TimeUnit.MILLISECONDS.toMinutes(j) < 15) {
                throw new IllegalArgumentException("Invalid interval");
            }
        } else {
            Uri uri = Uri.parse(str2);
            String lowerCase = (uri == null || (scheme = uri.getScheme()) == null) ? null : scheme.toLowerCase(Locale.getDefault());
            if (!Intrinsics.areEqual(lowerCase, "https") && !Intrinsics.areEqual(lowerCase, "http")) {
                throw new IllegalArgumentException("Unsupported url ".concat(str2));
            }
        }
    }

    public static final void access$rememberPendingLogo(UUID uuid, String str) {
        ConcurrentHashMap concurrentHashMap = pendingLogos;
        if (str == null || StringsKt.isBlank(str)) {
            concurrentHashMap.remove(uuid);
        } else {
            concurrentHashMap.put(uuid, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x028e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0292  */
    /* JADX WARN: Code duplicated, block: B:104:0x0294  */
    /* JADX WARN: Code duplicated, block: B:106:0x0297  */
    /* JADX WARN: Code duplicated, block: B:107:0x0299  */
    /* JADX WARN: Code duplicated, block: B:110:0x029d  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:67:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:72:0x021e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:80:0x0249  */
    /* JADX WARN: Code duplicated, block: B:88:0x0266  */
    /* JADX WARN: Code duplicated, block: B:94:0x0282  */
    /* JADX WARN: Code duplicated, block: B:97:0x0287  */
    /* JADX WARN: Code duplicated, block: B:98:0x0289  */
    public static final Object access$resolve(Context context, Profile.Type type, String str, File file, IFetchObserver iFetchObserver, ContinuationImpl continuationImpl) throws Throwable {
        ProfileProcessor$resolve$1 profileProcessor$resolve$1;
        ProfileProcessor profileProcessor;
        LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda3;
        Profile.Type type2;
        String str2;
        File file2;
        Headers headers;
        ProfileProcessor profileProcessor2;
        String str3;
        ProfileMeta profileMeta;
        String strDecodeTitleOrPlain;
        String strDecodeTitleOrPlain2;
        String str4;
        String str5;
        String str6;
        Long lValueOf;
        String str7;
        String str8;
        String str9;
        boolean z;
        String str10;
        boolean z2;
        boolean z3;
        String string;
        String string2;
        String string3;
        Long longOrNull;
        if (continuationImpl instanceof ProfileProcessor$resolve$1) {
            profileProcessor$resolve$1 = (ProfileProcessor$resolve$1) continuationImpl;
            int i = profileProcessor$resolve$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                profileProcessor$resolve$1.label = i - Integer.MIN_VALUE;
            } else {
                profileProcessor$resolve$1 = new ProfileProcessor$resolve$1(continuationImpl);
            }
        } else {
            profileProcessor$resolve$1 = new ProfileProcessor$resolve$1(continuationImpl);
        }
        Object obj = profileProcessor$resolve$1.result;
        int i2 = profileProcessor$resolve$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = iFetchObserver;
            LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda4 = new LogcatReader$$ExternalSyntheticLambda3(ref$ObjectRef, 2);
            ProfileProcessor profileProcessor3 = INSTANCE;
            profileProcessor$resolve$1.L$0 = profileProcessor3;
            profileProcessor$resolve$1.L$1 = type;
            profileProcessor$resolve$1.L$2 = str;
            profileProcessor$resolve$1.L$3 = file;
            profileProcessor$resolve$1.L$4 = logcatReader$$ExternalSyntheticLambda4;
            profileProcessor$resolve$1.label = 1;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            Object objWithContext = JobKt.withContext(DefaultIoScheduler.INSTANCE, new NavHostKt$NavHost$33$1(type, str, logcatReader$$ExternalSyntheticLambda4, context, file, null, 2), profileProcessor$resolve$1);
            if (objWithContext != coroutineSingletons) {
                profileProcessor = profileProcessor3;
                obj = objWithContext;
                logcatReader$$ExternalSyntheticLambda3 = logcatReader$$ExternalSyntheticLambda4;
                type2 = type;
                str2 = str;
                file2 = file;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            logcatReader$$ExternalSyntheticLambda3 = profileProcessor$resolve$1.L$4;
            file2 = profileProcessor$resolve$1.L$3;
            str2 = profileProcessor$resolve$1.L$2;
            type2 = (Profile.Type) profileProcessor$resolve$1.L$1;
            profileProcessor = profileProcessor$resolve$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            headers = (Headers) profileProcessor$resolve$1.L$1;
            profileProcessor2 = profileProcessor$resolve$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        profileProcessor = profileProcessor2;
        if (headers != null) {
            str3 = headers.get("subscription-userinfo");
        } else {
            str3 = null;
        }
        profileProcessor.getClass();
        if (str3 != null || StringsKt.isBlank(str3)) {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        } else {
            long jLongValueExact = 0;
            long jLongValueExact2 = 0;
            long jLongValueExact3 = 0;
            long jLongValueExact4 = 0;
            for (String str11 : StringsKt.split$default(str3, new String[]{";"}, 0, 6)) {
                List listSplit$default = StringsKt.split$default(str11, new String[]{"="}, 2, 2);
                if (listSplit$default.size() >= 2) {
                    String string4 = StringsKt.trim((String) listSplit$default.get(0)).toString();
                    String string5 = StringsKt.trim((String) listSplit$default.get(1)).toString();
                    if (string5.length() != 0) {
                        try {
                            if (StringsKt.contains(string4, "upload", false)) {
                                jLongValueExact = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string5, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string4, "download", false)) {
                                jLongValueExact2 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string5, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string4, "total", false)) {
                                jLongValueExact3 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string5, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string4, "expire", false)) {
                                jLongValueExact4 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string5, new char[]{'.'}))).longValueExact();
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Exception e) {
                            Log.w("KoalaClash", "Parse subscription-userinfo flag '" + str11 + "': " + e, e);
                        }
                    }
                }
            }
            profileMeta = new ProfileMeta(jLongValueExact, jLongValueExact2, jLongValueExact3, jLongValueExact4, 1008);
        }
        if (headers != null) {
            return profileMeta;
        }
        strDecodeTitleOrPlain = decodeTitleOrPlain(headers.get("profile-title"));
        strDecodeTitleOrPlain2 = decodeTitleOrPlain(headers.get("announce"));
        str4 = headers.get("support-url");
        if (str4 != null || StringsKt.isBlank(str4)) {
            str5 = null;
        } else {
            str5 = str4;
        }
        str6 = headers.get("profile-update-interval");
        if (str6 != null || (string3 = StringsKt.trim(str6).toString()) == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(string3)) == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(TimeUnit.HOURS.toSeconds(longOrNull.longValue()));
        }
        str7 = headers.get("profile-logo");
        if (str7 != null || (string2 = StringsKt.trim(str7).toString()) == null || string2.length() <= 0) {
            str8 = null;
        } else {
            str8 = string2;
        }
        str9 = headers.get("global-mode");
        if (str9 != null || (string = StringsKt.trim(str9).toString()) == null) {
            z = true;
        } else {
            z = !string.equalsIgnoreCase("false");
        }
        if (strDecodeTitleOrPlain == null) {
            str10 = "<none>";
        } else {
            str10 = strDecodeTitleOrPlain;
        }
        Object obj2 = lValueOf != null ? lValueOf : "<none>";
        if (strDecodeTitleOrPlain2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (str5 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Log.d("KoalaClash", "Profile headers parsed: title=" + str10 + ", interval=" + obj2 + "s, announce=" + z2 + ", supportURL=" + z3 + ", logo=" + (str8 != null) + ", modeSwitchAllowed=" + z, null);
        return new ProfileMeta(profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, strDecodeTitleOrPlain, lValueOf, strDecodeTitleOrPlain2, str5, str8, z);
        Headers headers2 = (Headers) obj;
        if (type2 != Profile.Type.File || str2.length() > 0) {
            CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = JobKt.CompletableDeferred$default();
            Bridge.INSTANCE.nativeValidate(new WorkLauncherImpl(16, logcatReader$$ExternalSyntheticLambda3, completableDeferredImplCompletableDeferred$default), file2.getAbsolutePath());
            profileProcessor$resolve$1.L$0 = profileProcessor;
            profileProcessor$resolve$1.L$1 = headers2;
            profileProcessor$resolve$1.L$2 = null;
            profileProcessor$resolve$1.L$3 = null;
            profileProcessor$resolve$1.L$4 = null;
            profileProcessor$resolve$1.label = 2;
            if (completableDeferredImplCompletableDeferred$default.awaitInternal(profileProcessor$resolve$1) != coroutineSingletons) {
                headers = headers2;
                profileProcessor2 = profileProcessor;
                profileProcessor = profileProcessor2;
            }
            return coroutineSingletons;
        }
        headers = headers2;
        if (headers != null) {
            str3 = headers.get("subscription-userinfo");
        } else {
            str3 = null;
        }
        profileProcessor.getClass();
        if (str3 != null) {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        } else {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        }
        if (headers != null) {
            return profileMeta;
        }
        strDecodeTitleOrPlain = decodeTitleOrPlain(headers.get("profile-title"));
        strDecodeTitleOrPlain2 = decodeTitleOrPlain(headers.get("announce"));
        str4 = headers.get("support-url");
        if (str4 != null) {
            str5 = null;
        } else {
            str5 = null;
        }
        str6 = headers.get("profile-update-interval");
        if (str6 != null) {
            lValueOf = null;
        } else {
            lValueOf = null;
        }
        str7 = headers.get("profile-logo");
        if (str7 != null) {
            str8 = null;
        } else {
            str8 = null;
        }
        str9 = headers.get("global-mode");
        if (str9 != null) {
            z = true;
        } else {
            z = true;
        }
        if (strDecodeTitleOrPlain == null) {
            str10 = "<none>";
        } else {
            str10 = strDecodeTitleOrPlain;
        }
        if (lValueOf != null) {
        }
        if (strDecodeTitleOrPlain2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (str5 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (str8 != null) {
        }
        Log.d("KoalaClash", "Profile headers parsed: title=" + str10 + ", interval=" + obj2 + "s, announce=" + z2 + ", supportURL=" + z3 + ", logo=" + (str8 != null) + ", modeSwitchAllowed=" + z, null);
        return new ProfileMeta(profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, strDecodeTitleOrPlain, lValueOf, strDecodeTitleOrPlain2, str5, str8, z);
    }

    public static String decodeTitleOrPlain(String str) {
        String str2;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        if (!StringsKt.isBlank(str) && StringsKt__StringsJVMKt.startsWith(str, "base64:", false)) {
            try {
                str2 = new String(Base64.decode(StringsKt.removePrefix(str, "base64:"), 0), Charsets.UTF_8);
            } catch (Exception e) {
                Log.w("KoalaClash", "Decode base64 header '" + str + "': " + e, e);
                str2 = null;
            }
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        String string = StringsKt.trim(str).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    public static void scheduleLogoFetch(Context context, UUID uuid) {
        String str = (String) pendingLogos.remove(uuid);
        if (str == null) {
            return;
        }
        JobKt.launch$default(logoScope, null, new EngineInterceptor.AnonymousClass2(str, uuid, context, (Continuation) null), 3);
    }
}
