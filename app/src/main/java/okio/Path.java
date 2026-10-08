package okio;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleDelegate;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.TransactionElement;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.model.RemoteModelManager$RemoteModelManagerRegistration;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.internal.zzg;
import com.google.mlkit.vision.barcode.internal.zzi;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause0;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class Path implements Comparable {
    public static final String DIRECTORY_SEPARATOR = File.separator;
    public final ByteString bytes;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class Companion implements MenuPresenter.Callback, FloatDecayAnimationSpec, PlatformLocaleDelegate, CreationExtras.Key, Clock, DynamiteModule.VersionPolicy, ComponentFactory, SelectClause0 {
        public static Companion zza;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static Path get$default(String str) {
            ByteString byteString = okio.internal.Path.SLASH;
            Buffer buffer = new Buffer();
            buffer.m868writeUtf8(str);
            return okio.internal.Path.toPath(buffer, false);
        }

        public static android.graphics.Path getPath(float f, float f2, float f3, float f4) {
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            switch (this.$r8$classId) {
                case 18:
                    return new Toolbar.AnonymousClass1(restrictedComponentContainer.setOf(RemoteModelManager$RemoteModelManagerRegistration.class));
                case 19:
                    return new RemoteModelManager$RemoteModelManagerRegistration(restrictedComponentContainer.getProvider(TransactionElement.Key.class));
                default:
                    return new zzg((zzi) restrictedComponentContainer.get(zzi.class), (ExecutorSelector) restrictedComponentContainer.get(ExecutorSelector.class), (MlKitContext) restrictedComponentContainer.get(MlKitContext.class));
            }
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getAbsVelocityThreshold() {
            return 0.0f;
        }

        @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
        public LocaleList getCurrent() {
            return new LocaleList(Collections.singletonList(new Locale(java.util.Locale.getDefault())));
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public long getDurationNanos(float f) {
            return 0L;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getTargetValue(float f, float f2) {
            return 0.0f;
        }

        @Override // com.google.android.datatransport.runtime.time.Clock
        public long getTime() {
            return System.currentTimeMillis();
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getValueFromNanos(float f, float f2, long j) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float getVelocityFromNanos(float f, long j) {
            return 0.0f;
        }

        public boolean isPrecomputedText(CharSequence charSequence) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
        public ViewUtils.RelativePadding selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
            ViewUtils.RelativePadding relativePadding = new ViewUtils.RelativePadding();
            int iZza = iVersions.zza(context, str);
            relativePadding.start = iZza;
            if (iZza != 0) {
                relativePadding.bottom = -1;
                return relativePadding;
            }
            int iZzb = iVersions.zzb(context, str, true);
            relativePadding.end = iZzb;
            if (iZzb != 0) {
                relativePadding.bottom = 1;
            }
            return relativePadding;
        }

        public Companion(Handshake.AnonymousClass2 anonymousClass2) {
            this.$r8$classId = 7;
        }

        public static Path get$default(File file) {
            String str = Path.DIRECTORY_SEPARATOR;
            String string = file.toString();
            ByteString byteString = okio.internal.Path.SLASH;
            Buffer buffer = new Buffer();
            buffer.m868writeUtf8(string);
            return okio.internal.Path.toPath(buffer, false);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }

    public Path(ByteString byteString) {
        this.bytes = byteString;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.bytes.compareTo(((Path) obj).bytes);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).bytes, this.bytes);
    }

    public final ArrayList getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int iAccess$rootLength = okio.internal.Path.access$rootLength(this);
        ByteString byteString = this.bytes;
        if (iAccess$rootLength == -1) {
            iAccess$rootLength = 0;
        } else if (iAccess$rootLength < byteString.getSize$okio() && byteString.internalGet$okio(iAccess$rootLength) == 92) {
            iAccess$rootLength++;
        }
        int size$okio = byteString.getSize$okio();
        int i = iAccess$rootLength;
        while (iAccess$rootLength < size$okio) {
            if (byteString.internalGet$okio(iAccess$rootLength) == 47 || byteString.internalGet$okio(iAccess$rootLength) == 92) {
                arrayList.add(byteString.substring(i, iAccess$rootLength));
                i = iAccess$rootLength + 1;
            }
            iAccess$rootLength++;
        }
        if (i < byteString.getSize$okio()) {
            arrayList.add(byteString.substring(i, byteString.getSize$okio()));
        }
        return arrayList;
    }

    public final int hashCode() {
        return this.bytes.hashCode();
    }

    public final Path parent() {
        ByteString byteString = okio.internal.Path.DOT;
        ByteString byteString2 = this.bytes;
        if (Intrinsics.areEqual(byteString2, byteString)) {
            return null;
        }
        ByteString byteString3 = okio.internal.Path.SLASH;
        if (Intrinsics.areEqual(byteString2, byteString3)) {
            return null;
        }
        ByteString byteString4 = okio.internal.Path.BACKSLASH;
        if (Intrinsics.areEqual(byteString2, byteString4)) {
            return null;
        }
        ByteString byteString5 = okio.internal.Path.DOT_DOT;
        int size$okio = byteString2.getSize$okio();
        byte[] bArr = byteString5.data;
        if (byteString2.rangeEquals(size$okio - bArr.length, byteString5, bArr.length) && (byteString2.getSize$okio() == 2 || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString3, 1) || byteString2.rangeEquals(byteString2.getSize$okio() - 3, byteString4, 1))) {
            return null;
        }
        byteString2.getClass();
        int iLastIndexOf = byteString2.lastIndexOf(byteString3.internalArray$okio());
        if (iLastIndexOf == -1) {
            byteString2.getClass();
            iLastIndexOf = byteString2.lastIndexOf(byteString4.internalArray$okio());
        }
        if (iLastIndexOf == 2 && volumeLetter() != null) {
            if (byteString2.getSize$okio() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(byteString2, 0, 3, 1));
        }
        if (iLastIndexOf == 1 && byteString2.rangeEquals(0, byteString4, byteString4.getSize$okio())) {
            return null;
        }
        if (iLastIndexOf != -1 || volumeLetter() == null) {
            if (iLastIndexOf == -1) {
                return new Path(byteString);
            }
            return iLastIndexOf == 0 ? new Path(ByteString.substring$default(byteString2, 0, 1, 1)) : new Path(ByteString.substring$default(byteString2, 0, iLastIndexOf, 1));
        }
        if (byteString2.getSize$okio() == 2) {
            return null;
        }
        return new Path(ByteString.substring$default(byteString2, 0, 2, 1));
    }

    public final Path relativeTo(Path path) {
        int iAccess$rootLength = okio.internal.Path.access$rootLength(this);
        ByteString byteString = this.bytes;
        Path path2 = iAccess$rootLength == -1 ? null : new Path(byteString.substring(0, iAccess$rootLength));
        path.getClass();
        ByteString byteString2 = path.bytes;
        int iAccess$rootLength2 = okio.internal.Path.access$rootLength(path);
        if (!Intrinsics.areEqual(path2, iAccess$rootLength2 != -1 ? new Path(byteString2.substring(0, iAccess$rootLength2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
        }
        ArrayList segmentsBytes = getSegmentsBytes();
        ArrayList segmentsBytes2 = path.getSegmentsBytes();
        int iMin = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i == iMin && byteString.getSize$okio() == byteString2.getSize$okio()) {
            return Companion.get$default(".");
        }
        if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        Buffer buffer = new Buffer();
        ByteString slash = okio.internal.Path.getSlash(path);
        if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i2 = i; i2 < size; i2++) {
            buffer.m864write(okio.internal.Path.DOT_DOT);
            buffer.m864write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i < size2) {
            buffer.m864write((ByteString) segmentsBytes.get(i));
            buffer.m864write(slash);
            i++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    public final Path resolve(String str) {
        Buffer buffer = new Buffer();
        buffer.m868writeUtf8(str);
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(buffer, false), false);
    }

    public final File toFile() {
        return new File(this.bytes.utf8());
    }

    public final String toString() {
        return this.bytes.utf8();
    }

    public final Character volumeLetter() {
        ByteString byteString = okio.internal.Path.SLASH;
        ByteString byteString2 = this.bytes;
        if (ByteString.indexOf$default(byteString2, byteString) != -1 || byteString2.getSize$okio() < 2 || byteString2.internalGet$okio(1) != 58) {
            return null;
        }
        char cInternalGet$okio = (char) byteString2.internalGet$okio(0);
        if (('a' > cInternalGet$okio || cInternalGet$okio >= '{') && ('A' > cInternalGet$okio || cInternalGet$okio >= '[')) {
            return null;
        }
        return Character.valueOf(cInternalGet$okio);
    }
}
