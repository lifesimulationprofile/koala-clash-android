package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.appcompat.widget.TooltipCompat;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.CleanupCallback;
import androidx.work.impl.WorkDatabase_Impl;
import coil.disk.RealDiskCache;
import coil.network.HttpException;
import coil.request.Parameters;
import com.caverock.androidsvg.SVG;
import com.github.kr328.clash.service.data.Database_Impl;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.common.internal.zzv;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.photos.vision.barhopper.zze;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.internal.CharMappings;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public class RoomOpenHelper implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int $r8$classId;
    public Object configuration;
    public final Object delegate;
    public Object identityHash;
    public final Object legacyHash;
    public int version;

    public RoomOpenHelper(TooltipPopup tooltipPopup, AutoValue_BackendResponse autoValue_BackendResponse, Iterable iterable, AutoValue_TransportContext autoValue_TransportContext, int i) {
        this.$r8$classId = 2;
        this.configuration = tooltipPopup;
        this.delegate = autoValue_BackendResponse;
        this.identityHash = iterable;
        this.legacyHash = autoValue_TransportContext;
        this.version = i;
    }

    public static void deleteDatabaseFile(String str) {
        if (StringsKt__StringsJVMKt.equals(str, ":memory:", true)) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e) {
            Log.w("SupportSQLite", "delete failed: ", e);
        }
    }

    public static /* synthetic */ void fail$default(RoomOpenHelper roomOpenHelper, String str, int i, String str2, int i2) {
        if ((i2 & 2) != 0) {
            i = roomOpenHelper.version;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        roomOpenHelper.fail(i, str, str2);
        throw null;
    }

    public void add(Dependency dependency) {
        if (((HashSet) this.configuration).contains(dependency.anInterface)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.delegate).add(dependency);
    }

    public int appendHex(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            ((StringBuilder) this.delegate).append((char) (fromHexChar(charSequence, i + 3) + (fromHexChar(charSequence, i) << 12) + (fromHexChar(charSequence, i + 1) << 8) + (fromHexChar(charSequence, i + 2) << 4)));
            return i2;
        }
        this.version = i;
        if (i2 < charSequence.length()) {
            return appendHex(charSequence, this.version);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public Component build() {
        if (((ComponentFactory) this.identityHash) != null) {
            return new Component(new HashSet((HashSet) this.configuration), new HashSet((HashSet) this.delegate), this.version, (ComponentFactory) this.identityHash, (HashSet) this.legacyHash);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public boolean canConsumeValue() {
        int i = this.version;
        if (i == -1) {
            return false;
        }
        String str = (String) this.legacyHash;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.version = i;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i++;
        }
        this.version = i;
        return false;
    }

    public void consumeBooleanLiteral(String str, int i) {
        String str2 = (String) this.legacyHash;
        if (str2.length() - i < str.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (str2.charAt(i + i2) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.version = str.length() + i;
    }

    public String consumeKeyString() {
        String string;
        StringBuilder sb = (StringBuilder) this.delegate;
        String str = (String) this.legacyHash;
        consumeNextToken('\"');
        int i = this.version;
        int iIndexOf$default = StringsKt.indexOf$default(str, '\"', i, 4);
        if (iIndexOf$default == -1) {
            consumeStringLenient();
            fail$kotlinx_serialization_json((byte) 1, false);
            throw null;
        }
        int i2 = i;
        while (i2 < iIndexOf$default) {
            if (str.charAt(i2) == '\\') {
                int iPrefetchOrEof = this.version;
                char cCharAt = str.charAt(i2);
                boolean z = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iPrefetchOrEof, i2);
                        int iPrefetchOrEof2 = prefetchOrEof(i2 + 1);
                        if (iPrefetchOrEof2 == -1) {
                            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iAppendHex = iPrefetchOrEof2 + 1;
                        char cCharAt2 = str.charAt(iPrefetchOrEof2);
                        if (cCharAt2 == 'u') {
                            iAppendHex = appendHex(str, iAppendHex);
                        } else {
                            char c = cCharAt2 < 'u' ? CharMappings.ESCAPE_2_CHAR[cCharAt2] : (char) 0;
                            if (c == 0) {
                                fail$default(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c);
                        }
                        iPrefetchOrEof = prefetchOrEof(iAppendHex);
                        if (iPrefetchOrEof == -1) {
                            fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4);
                            throw null;
                        }
                    } else {
                        i2++;
                        if (i2 >= str.length()) {
                            sb.append((CharSequence) str, iPrefetchOrEof, i2);
                            iPrefetchOrEof = prefetchOrEof(i2);
                            if (iPrefetchOrEof == -1) {
                                fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                        }
                        cCharAt = str.charAt(i2);
                    }
                    i2 = iPrefetchOrEof;
                    z = true;
                    cCharAt = str.charAt(i2);
                }
                if (z) {
                    sb.append((CharSequence) str, iPrefetchOrEof, i2);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    string = string2;
                } else {
                    string = str.subSequence(iPrefetchOrEof, i2).toString();
                }
                this.version = i2 + 1;
                return string;
            }
            i2++;
        }
        this.version = iIndexOf$default + 1;
        return str.substring(i, iIndexOf$default);
    }

    public byte consumeNextToken() {
        String str = (String) this.legacyHash;
        int i = this.version;
        while (i != -1 && i < str.length()) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.version = i2;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = i2;
        }
        this.version = str.length();
        return (byte) 10;
    }

    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public long consumeNumericLiteral() {
        boolean z;
        boolean z2;
        long j;
        double dPow;
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        String str = (String) this.legacyHash;
        ?? r6 = 0;
        if (iPrefetchOrEof >= str.length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iPrefetchOrEof) == '\"') {
            iPrefetchOrEof++;
            if (iPrefetchOrEof == str.length()) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            z = true;
        } else {
            z = false;
        }
        int i = iPrefetchOrEof;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long j2 = 0;
        long j3 = 0;
        while (true) {
            if (i == str.length()) {
                z2 = z;
                break;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt != 'e' && cCharAt != 'E') || z4) {
                if (cCharAt == '-' && z4) {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    z3 = false;
                } else if (cCharAt != '+' || !z4) {
                    z2 = z;
                    if (cCharAt != '-') {
                        if (WriteModeKt.charToTokenClass(cCharAt) != 0) {
                            break;
                        }
                        i++;
                        int i2 = cCharAt - '0';
                        if (i2 < 0 || i2 >= 10) {
                            fail$default(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        if (z4) {
                            j2 = (j2 * ((long) 10)) + ((long) i2);
                        } else {
                            j3 = (j3 * ((long) 10)) - ((long) i2);
                            if (j3 > 0) {
                                fail$default(this, "Numeric value overflow", 0, null, 6);
                                throw null;
                            }
                        }
                        z = z2;
                    } else {
                        if (i != iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        i++;
                        z = z2;
                        r6 = 0;
                        z5 = true;
                    }
                } else {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    r6 = 0;
                    z3 = true;
                }
                r6 = 0;
            } else {
                if (i == iPrefetchOrEof) {
                    fail$default(this, "Unexpected symbol " + cCharAt + " in numeric literal", 0, r6, 6);
                    throw r6;
                }
                i++;
                z3 = true;
                z4 = true;
            }
        }
        boolean z6 = i != iPrefetchOrEof;
        if (iPrefetchOrEof == i || (z5 && iPrefetchOrEof == i - 1)) {
            fail$default(this, "Expected numeric literal", 0, null, 6);
            throw null;
        }
        if (z2) {
            if (!z6) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            if (str.charAt(i) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6);
                throw null;
            }
            i++;
        }
        this.version = i;
        long j4 = j3;
        if (z4) {
            double d = j4;
            if (!z3) {
                dPow = Math.pow(10.0d, -j2);
            } else {
                if (!z3) {
                    throw new HttpException();
                }
                dPow = Math.pow(10.0d, j2);
            }
            double d2 = d * dPow;
            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                fail$default(this, "Numeric value overflow", 0, null, 6);
                throw null;
            }
            if (Math.floor(d2) != d2) {
                fail$default(this, "Can't convert " + d2 + " to Long", 0, null, 6);
                throw null;
            }
            j = (long) d2;
        } else {
            j = j4;
        }
        if (z5) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        fail$default(this, "Numeric value overflow", 0, null, 6);
        throw null;
    }

    public String consumeString() {
        String str = (String) this.identityHash;
        if (str == null) {
            return consumeKeyString();
        }
        this.identityHash = null;
        return str;
    }

    public String consumeStringLenient() {
        String string;
        StringBuilder sb = (StringBuilder) this.delegate;
        String str = (String) this.legacyHash;
        String str2 = (String) this.identityHash;
        if (str2 != null) {
            this.identityHash = null;
            return str2;
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= str.length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4);
            throw null;
        }
        byte bCharToTokenClass = WriteModeKt.charToTokenClass(str.charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + str.charAt(iSkipWhitespaces), 0, null, 6);
            throw null;
        }
        boolean z = false;
        while (WriteModeKt.charToTokenClass(str.charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= str.length()) {
                sb.append((CharSequence) str, this.version, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.version = iSkipWhitespaces;
                    sb.append((CharSequence) str, 0, 0);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    return string2;
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        if (z) {
            sb.append((CharSequence) str, this.version, iSkipWhitespaces);
            String string3 = sb.toString();
            sb.setLength(0);
            string = string3;
        } else {
            string = str.subSequence(this.version, iSkipWhitespaces).toString();
        }
        this.version = iSkipWhitespaces;
        return string;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Boolean bool;
        TooltipPopup tooltipPopup = (TooltipPopup) this.configuration;
        SVG svg = (SVG) tooltipPopup.mLayoutParams;
        EventStore eventStore = (EventStore) tooltipPopup.mMessageView;
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) this.delegate;
        Iterable iterable = (Iterable) this.identityHash;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.legacyHash;
        int i = this.version;
        int i2 = autoValue_BackendResponse.status;
        if (i2 == 2) {
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) eventStore;
            sQLiteEventStore.getClass();
            if (iterable.iterator().hasNext()) {
                String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + SQLiteEventStore.toIdList(iterable);
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    db.compileStatement(str).execute();
                    db.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } catch (Throwable th) {
                    db.endTransaction();
                    throw th;
                }
            }
            svg.schedule(autoValue_TransportContext, i + 1, false);
            return null;
        }
        SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) eventStore;
        sQLiteEventStore2.getClass();
        if (iterable.iterator().hasNext()) {
            sQLiteEventStore2.getDb().compileStatement("DELETE FROM events WHERE _id in " + SQLiteEventStore.toIdList(iterable)).execute();
        }
        if (i2 == 1) {
            long time = ((Clock) tooltipPopup.mTmpAppPos).getTime() + autoValue_BackendResponse.nextRequestWaitMillis;
            sQLiteEventStore2.getClass();
            sQLiteEventStore2.inTransaction(new HeadersReader(time, autoValue_TransportContext));
        }
        SQLiteDatabase db2 = sQLiteEventStore2.getDb();
        db2.beginTransaction();
        try {
            Long transportContextId = SQLiteEventStore.getTransportContextId(db2, autoValue_TransportContext);
            if (transportContextId == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = sQLiteEventStore2.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th2) {
                    cursorRawQuery.close();
                    throw th2;
                }
            }
            db2.setTransactionSuccessful();
            db2.endTransaction();
            if (!bool.booleanValue()) {
                return null;
            }
            svg.schedule(autoValue_TransportContext, 1, true);
            return null;
        } catch (Throwable th3) {
            db2.endTransaction();
            throw th3;
        }
    }

    public void fail(int i, String str, String str2) {
        throw WriteModeKt.JsonDecodingException(i, (String) this.legacyHash, str + " at path: " + ((StatusLine) this.configuration).getPath() + (str2.length() == 0 ? "" : "\n".concat(str2)));
    }

    public void fail$kotlinx_serialization_json(byte b, boolean z) {
        String str = (String) this.legacyHash;
        String str2 = WriteModeKt.tokenDescription(b);
        int i = z ? this.version - 1 : this.version;
        fail$default(this, "Expected " + str2 + ", but had '" + ((this.version == str.length() || i < 0) ? "EOF" : String.valueOf(str.charAt(i))) + "' instead", i, null, 4);
        throw null;
    }

    public int fromHexChar(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public String getPairedConcurrentCameraId(String str) {
        HashMap map = (HashMap) this.delegate;
        if (!map.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) map.get(str)) {
            ArrayList arrayList = (ArrayList) this.identityHash;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                CameraInfoInternal implementation = ((CameraInfoInternal) obj).getImplementation();
                Preconditions.checkArgument("CameraInfo doesn't contain Camera2 implementation.", implementation instanceof Camera2CameraInfoImpl);
                if (str2.equals(((Camera2CameraInfoImpl) ((Camera2CameraInfoImpl) implementation).mCamera2CameraInfo.this$0).mCameraId)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        WorkDatabase_Impl.AnonymousClass1 anonymousClass1 = (WorkDatabase_Impl.AnonymousClass1) this.delegate;
        Cursor cursorQuery = frameworkSQLiteDatabase.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0;
            cursorQuery.close();
            anonymousClass1.createAllTables(frameworkSQLiteDatabase);
            if (!z) {
                zzv zzvVarOnValidateSchema = anonymousClass1.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzvVarOnValidateSchema.zzc) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + zzvVarOnValidateSchema.zza);
                }
            }
            updateIdentity(frameworkSQLiteDatabase);
            switch (anonymousClass1.$r8$classId) {
                case 0:
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) anonymousClass1.this$0;
                    List list = workDatabase_Impl.mCallbacks;
                    if (list != null) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ((CleanupCallback) workDatabase_Impl.mCallbacks.get(i)).getClass();
                        }
                        return;
                    }
                    return;
                default:
                    Database_Impl database_Impl = (Database_Impl) anonymousClass1.this$0;
                    int i2 = Database_Impl.$r8$clinit;
                    List list2 = database_Impl.mCallbacks;
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((CleanupCallback) it.next()).getClass();
                        }
                        return;
                    }
                    return;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    public void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        WorkDatabase_Impl.AnonymousClass1 anonymousClass1 = (WorkDatabase_Impl.AnonymousClass1) this.delegate;
        String str = (String) this.identityHash;
        Cursor cursorQuery = frameworkSQLiteDatabase.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
            cursorQuery.close();
            if (z) {
                Cursor cursorQuery2 = frameworkSQLiteDatabase.query(new RealDiskCache.RealEditor(26, "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                try {
                    String string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(0) : null;
                    cursorQuery2.close();
                    if (!str.equals(string) && !((String) this.legacyHash).equals(string)) {
                        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + str + ", found: " + string);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery2, th);
                        throw th2;
                    }
                }
            } else {
                zzv zzvVarOnValidateSchema = anonymousClass1.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzvVarOnValidateSchema.zzc) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + zzvVarOnValidateSchema.zza);
                }
                updateIdentity(frameworkSQLiteDatabase);
            }
            switch (anonymousClass1.$r8$classId) {
                case 0:
                    ((WorkDatabase_Impl) anonymousClass1.this$0).mDatabase = frameworkSQLiteDatabase;
                    frameworkSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                    ((WorkDatabase_Impl) anonymousClass1.this$0).internalInitInvalidationTracker(frameworkSQLiteDatabase);
                    List list = ((WorkDatabase_Impl) anonymousClass1.this$0).mCallbacks;
                    if (list != null) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ((CleanupCallback) ((WorkDatabase_Impl) anonymousClass1.this$0).mCallbacks.get(i)).onOpen(frameworkSQLiteDatabase);
                        }
                    }
                    break;
                default:
                    Database_Impl database_Impl = (Database_Impl) anonymousClass1.this$0;
                    int i2 = Database_Impl.$r8$clinit;
                    database_Impl.mDatabase = frameworkSQLiteDatabase;
                    frameworkSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                    ((Database_Impl) anonymousClass1.this$0).internalInitInvalidationTracker(frameworkSQLiteDatabase);
                    List list2 = ((Database_Impl) anonymousClass1.this$0).mCallbacks;
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((CleanupCallback) it.next()).onOpen(frameworkSQLiteDatabase);
                        }
                    }
                    break;
            }
            this.configuration = null;
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(cursorQuery, th3);
                throw th4;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0038 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[LOOP:1: B:11:0x0022->B:92:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0055 A[SYNTHETIC] */
    public void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2) {
        Set set;
        Iterable iterable;
        TreeMap treeMap;
        Set setKeySet;
        Iterator it;
        boolean z;
        Integer num;
        int i3;
        int iIntValue;
        int iIntValue2;
        WorkDatabase_Impl.AnonymousClass1 anonymousClass1 = (WorkDatabase_Impl.AnonymousClass1) this.delegate;
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.configuration;
        boolean z2 = true;
        if (databaseConfiguration != null) {
            Parameters.Builder builder = databaseConfiguration.migrationContainer;
            builder.getClass();
            if (i == i2) {
                iterable = EmptyList.INSTANCE;
            } else {
                boolean z3 = i2 > i;
                ArrayList arrayList = new ArrayList();
                int iIntValue3 = i;
                while (true) {
                    if (z3) {
                        if (iIntValue3 < i2) {
                            treeMap = (TreeMap) builder.entries.get(Integer.valueOf(iIntValue3));
                            if (treeMap != null) {
                                if (z3) {
                                    setKeySet = treeMap.descendingKeySet();
                                } else {
                                    setKeySet = treeMap.keySet();
                                }
                                it = setKeySet.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    num = (Integer) it.next();
                                    if (!z3) {
                                        iIntValue2 = num.intValue();
                                        if (i2 <= iIntValue2 && iIntValue2 < iIntValue3) {
                                            arrayList.add(treeMap.get(num));
                                            iIntValue3 = num.intValue();
                                            z = true;
                                            break;
                                            break;
                                        }
                                    } else {
                                        i3 = iIntValue3 + 1;
                                        iIntValue = num.intValue();
                                        if (i3 <= iIntValue && iIntValue <= i2) {
                                            arrayList.add(treeMap.get(num));
                                            iIntValue3 = num.intValue();
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                if (!z) {
                                }
                            }
                            iterable = null;
                        } else {
                            iterable = arrayList;
                        }
                    } else if (iIntValue3 > i2) {
                        treeMap = (TreeMap) builder.entries.get(Integer.valueOf(iIntValue3));
                        if (treeMap != null) {
                            if (z3) {
                                setKeySet = treeMap.descendingKeySet();
                            } else {
                                setKeySet = treeMap.keySet();
                            }
                            it = setKeySet.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    z = false;
                                    break;
                                    break;
                                }
                                num = (Integer) it.next();
                                if (!z3) {
                                    i3 = iIntValue3 + 1;
                                    iIntValue = num.intValue();
                                    if (i3 <= iIntValue) {
                                        continue;
                                    }
                                } else {
                                    iIntValue2 = num.intValue();
                                    if (i2 <= iIntValue2) {
                                        continue;
                                    }
                                }
                            }
                            if (!z) {
                            }
                        }
                        iterable = null;
                    } else {
                        iterable = arrayList;
                    }
                }
            }
            if (iterable != null) {
                switch (anonymousClass1.$r8$classId) {
                    case 0:
                        DBUtil.dropFtsSyncTriggers(frameworkSQLiteDatabase);
                        break;
                    default:
                        DBUtil.dropFtsSyncTriggers(frameworkSQLiteDatabase);
                        break;
                }
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((Migration) it2.next()).migrate(frameworkSQLiteDatabase);
                }
                zzv zzvVarOnValidateSchema = anonymousClass1.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzvVarOnValidateSchema.zzc) {
                    throw new IllegalStateException("Migration didn't properly handle: " + zzvVarOnValidateSchema.zza);
                }
                updateIdentity(frameworkSQLiteDatabase);
                return;
            }
        }
        DatabaseConfiguration databaseConfiguration2 = (DatabaseConfiguration) this.configuration;
        if (databaseConfiguration2 != null) {
            if ((i > i2 && databaseConfiguration2.allowDestructiveMigrationOnDowngrade) || !databaseConfiguration2.requireMigration || ((set = databaseConfiguration2.migrationNotRequiredFrom) != null && set.contains(Integer.valueOf(i)))) {
                z2 = false;
            }
            if (!z2) {
                switch (anonymousClass1.$r8$classId) {
                    case 0:
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) anonymousClass1.this$0;
                        List list = workDatabase_Impl.mCallbacks;
                        if (list != null) {
                            int size = list.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                ((CleanupCallback) workDatabase_Impl.mCallbacks.get(i4)).getClass();
                            }
                        }
                        break;
                    default:
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `imported`");
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `selections`");
                        Database_Impl database_Impl = (Database_Impl) anonymousClass1.this$0;
                        int i5 = Database_Impl.$r8$clinit;
                        List list2 = database_Impl.mCallbacks;
                        if (list2 != null) {
                            Iterator it3 = list2.iterator();
                            while (it3.hasNext()) {
                                ((CleanupCallback) it3.next()).getClass();
                            }
                        }
                        break;
                }
                anonymousClass1.createAllTables(frameworkSQLiteDatabase);
                return;
            }
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public String peekLeadingMatchingValue(String str) {
        int i = this.version;
        try {
            if (consumeNextToken() == 6 && Intrinsics.areEqual(peekString(), str)) {
                this.identityHash = null;
                if (consumeNextToken() == 5) {
                    return peekString();
                }
            }
            return null;
        } finally {
            this.version = i;
            this.identityHash = null;
        }
    }

    public byte peekNextToken() {
        String str = (String) this.legacyHash;
        int i = this.version;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.version = iPrefetchOrEof;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iPrefetchOrEof);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.version = iPrefetchOrEof;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = iPrefetchOrEof + 1;
        }
    }

    public String peekString() {
        if (peekNextToken() != 1) {
            return null;
        }
        String strConsumeString = consumeString();
        this.identityHash = strConsumeString;
        return strConsumeString;
    }

    public int prefetchOrEof(int i) {
        if (i < ((String) this.legacyHash).length()) {
            return i;
        }
        return -1;
    }

    public int skipWhitespaces() {
        char cCharAt;
        int i = this.version;
        if (i == -1) {
            return i;
        }
        String str = (String) this.legacyHash;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.version = i;
        return i;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.legacyHash);
                sb.append("', currentPosition=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.version, ')');
            default:
                return super.toString();
        }
    }

    public boolean tryConsumeComma() {
        int iSkipWhitespaces = skipWhitespaces();
        String str = (String) this.legacyHash;
        if (iSkipWhitespaces >= str.length() || iSkipWhitespaces == -1 || str.charAt(iSkipWhitespaces) != ',') {
            return false;
        }
        this.version++;
        return true;
    }

    public void unexpectedToken(char c) {
        int i = this.version;
        if (i > 0 && c == '\"') {
            try {
                this.version = i - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.version = i;
                if (Intrinsics.areEqual(strConsumeStringLenient, "null")) {
                    fail(this.version - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.version = i;
                throw th;
            }
        }
        fail$kotlinx_serialization_json(WriteModeKt.charToTokenClass(c), true);
        throw null;
    }

    public void updateIdentity(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) this.identityHash) + "')");
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, WorkDatabase_Impl.AnonymousClass1 anonymousClass1, String str, String str2) {
        this.$r8$classId = 0;
        int i = anonymousClass1.version;
        this.$r8$classId = 0;
        this.version = i;
        this.configuration = databaseConfiguration;
        this.delegate = anonymousClass1;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    public void consumeNextToken(char c) {
        int i = this.version;
        if (i != -1) {
            String str = (String) this.legacyHash;
            while (i < str.length()) {
                int i2 = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                    this.version = i2;
                    if (cCharAt == c) {
                        return;
                    }
                    unexpectedToken(c);
                    throw null;
                }
                i = i2;
            }
            this.version = -1;
            unexpectedToken(c);
            throw null;
        }
        unexpectedToken(c);
        throw null;
    }

    public RoomOpenHelper(CameraManagerCompat cameraManagerCompat) {
        this.$r8$classId = 1;
        this.version = 0;
        HashMap map = new HashMap();
        this.delegate = map;
        this.legacyHash = new HashSet();
        this.configuration = new ArrayList();
        this.identityHash = new ArrayList();
        Set hashSet = new HashSet();
        try {
            hashSet = cameraManagerCompat.mImpl.getConcurrentCameraIds();
        } catch (CameraAccessExceptionCompat unused) {
            LazyKt__LazyJVMKt.e("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (zze.isBackwardCompatible(cameraManagerCompat, str) && zze.isBackwardCompatible(cameraManagerCompat, str2)) {
                        ((HashSet) this.legacyHash).add(new HashSet(Arrays.asList(str, str2)));
                        if (!map.containsKey(str)) {
                            map.put(str, new ArrayList());
                        }
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        ((List) map.get(str)).add((String) arrayList.get(1));
                        ((List) map.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (InitializationException unused2) {
                    LazyKt__LazyJVMKt.d("Camera2CameraCoordinator", "Concurrent camera id pair: (" + str + ", " + str2 + ") is not backward compatible");
                }
            }
        }
    }

    public byte consumeNextToken(byte b) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == b) {
            return bConsumeNextToken;
        }
        fail$kotlinx_serialization_json(b, true);
        throw null;
    }

    public RoomOpenHelper(String str) {
        this.$r8$classId = 4;
        StatusLine statusLine = new StatusLine(13, false);
        statusLine.protocol = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        statusLine.message = iArr;
        statusLine.code = -1;
        this.configuration = statusLine;
        this.delegate = new StringBuilder();
        this.legacyHash = str;
    }

    public RoomOpenHelper(Class cls, Class[] clsArr) {
        this.$r8$classId = 3;
        HashSet hashSet = new HashSet();
        this.configuration = hashSet;
        this.delegate = new HashSet();
        this.version = 0;
        this.legacyHash = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            TooltipCompat.checkNotNull(cls2, "Null interface");
        }
        Collections.addAll((HashSet) this.configuration, clsArr);
    }
}
