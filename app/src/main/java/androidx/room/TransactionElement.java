package androidx.room;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.hardware.camera2.CameraCharacteristics;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.zzu;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.zza;
import com.google.mlkit.common.sdkinternal.zzb;
import com.google.mlkit.common.sdkinternal.zzd;
import io.github.g00fy2.quickie.extensions.BarcodeExtensionsKt;
import java.lang.ref.ReferenceQueue;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executors;
import kotlin.coroutines.CoroutineContext;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TransactionElement implements CoroutineContext.Element {
    public static final Key Key = new Key(0);

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class Key implements CoroutineContext.Key, CreationExtras.Key, ProfileInstaller$DiagnosticsCallback, Factory, ComponentFactory, OnFailureListener {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Key(int i) {
            this.$r8$classId = i;
        }

        public static final String access$binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            byte[] bArr3 = PublicSuffixDatabase.WILDCARD_LABEL;
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != 10) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i2 = i7 + i8;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i8++;
                }
                int i9 = i2 - i7;
                int i10 = i;
                boolean z2 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[i10][i11];
                        byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                        int i13 = b & 255;
                        z = z2;
                        i3 = i13;
                    }
                    byte b2 = bArr[i7 + i12];
                    byte[] bArr5 = Util.EMPTY_BYTE_ARRAY;
                    i4 = i3 - (b2 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        i11 = -1;
                        z2 = true;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i14 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        int length3 = bArr2.length;
                        for (int i15 = i10 + 1; i15 < length3; i15++) {
                            length2 += bArr2[i15].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i7, i9, StandardCharsets.UTF_8);
                            }
                        }
                    }
                    i5 = i2 + 1;
                }
                length = i6;
            }
            return null;
        }

        public static final float access$lookupAndInterpolate(float f, float[] fArr, float[] fArr2) {
            float f2;
            float f3;
            float f4;
            float f5;
            float fAbs = Math.abs(f);
            float fSignum = Math.signum(f);
            int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
            if (iBinarySearch >= 0) {
                return fSignum * fArr2[iBinarySearch];
            }
            int i = -(iBinarySearch + 1);
            int i2 = i - 1;
            if (i2 >= fArr.length - 1) {
                float f6 = fArr[fArr.length - 1];
                float f7 = fArr2[fArr.length - 1];
                if (f6 == 0.0f) {
                    return 0.0f;
                }
                return (f7 / f6) * f;
            }
            if (i2 == -1) {
                float f8 = fArr[0];
                f4 = fArr2[0];
                f5 = f8;
                f3 = 0.0f;
                f2 = 0.0f;
            } else {
                float f9 = fArr[i2];
                float f10 = fArr[i];
                f2 = fArr2[i2];
                f3 = f9;
                f4 = fArr2[i];
                f5 = f10;
            }
            return (((f4 - f2) * Math.max(0.0f, Math.min(1.0f, f3 == f5 ? 0.0f : (fAbs - f3) / (f5 - f3)))) + f2) * fSignum;
        }

        public static boolean handleDeleteSurroundingText(EmojiInputConnection emojiInputConnection, Editable editable, int i, int i2, boolean z) {
            int iMin;
            if (editable != null && i >= 0 && i2 >= 0) {
                int selectionStart = Selection.getSelectionStart(editable);
                int selectionEnd = Selection.getSelectionEnd(editable);
                if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                    if (z) {
                        int iMax = Math.max(i, 0);
                        int length = editable.length();
                        if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                            loop0: while (true) {
                                boolean z2 = false;
                                while (true) {
                                    if (iMax == 0) {
                                        break loop0;
                                    }
                                    selectionStart--;
                                    if (selectionStart < 0) {
                                        if (!z2) {
                                            selectionStart = 0;
                                            break loop0;
                                        }
                                        break loop0;
                                    }
                                    char cCharAt = editable.charAt(selectionStart);
                                    if (z2) {
                                        if (Character.isHighSurrogate(cCharAt)) {
                                            iMax--;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt)) {
                                        iMax--;
                                    } else if (!Character.isHighSurrogate(cCharAt)) {
                                        z2 = true;
                                    }
                                    selectionStart = -1;
                                    break loop0;
                                }
                            }
                        }
                        selectionStart = -1;
                        break loop0;
                        int iMax2 = Math.max(i2, 0);
                        iMin = editable.length();
                        if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                            loop2: while (true) {
                                boolean z3 = false;
                                while (true) {
                                    if (iMax2 != 0) {
                                        if (selectionEnd >= iMin) {
                                            if (!z3) {
                                                break loop2;
                                            }
                                            break loop2;
                                        }
                                        char cCharAt2 = editable.charAt(selectionEnd);
                                        if (z3) {
                                            if (Character.isLowSurrogate(cCharAt2)) {
                                                iMax2--;
                                                selectionEnd++;
                                            }
                                        } else if (!Character.isSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        } else if (!Character.isLowSurrogate(cCharAt2)) {
                                            selectionEnd++;
                                            z3 = true;
                                        }
                                        iMin = -1;
                                        break loop2;
                                    }
                                    iMin = selectionEnd;
                                    break loop2;
                                }
                            }
                        }
                        iMin = -1;
                        break loop2;
                        if (selectionStart != -1 && iMin != -1) {
                        }
                    } else {
                        selectionStart = Math.max(selectionStart - i, 0);
                        iMin = Math.min(selectionEnd + i2, editable.length());
                    }
                    TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, iMin, TypefaceEmojiSpan.class);
                    if (typefaceEmojiSpanArr != null && typefaceEmojiSpanArr.length > 0) {
                        for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                            int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                            int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                            selectionStart = Math.min(spanStart, selectionStart);
                            iMin = Math.max(spanEnd, iMin);
                        }
                        int iMax3 = Math.max(selectionStart, 0);
                        int iMin2 = Math.min(iMin, editable.length());
                        emojiInputConnection.beginBatchEdit();
                        editable.delete(iMax3, iMin2);
                        emojiInputConnection.endBatchEdit();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            Cleaner cleaner = new Cleaner();
            zza zzaVar = new zza(0);
            ReferenceQueue referenceQueue = cleaner.zza;
            Set set = cleaner.zzb;
            set.add(new zzd(cleaner, referenceQueue, set, zzaVar));
            Thread thread = new Thread(new zzb(0, referenceQueue, set), "MlKitCleaner");
            thread.setDaemon(true);
            thread.start();
            return cleaner;
        }

        @Override // javax.inject.Provider
        public Object get() {
            return new zzu(3, Executors.newSingleThreadExecutor());
        }

        public Signature[] getSigningSignatures(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 6:
                    return "CompositionErrorContext";
                default:
                    return super.toString();
            }
        }

        public Key(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Headers.Builder builder, SequentialExecutor sequentialExecutor, HandlerScheduledExecutorService handlerScheduledExecutorService) {
            this.$r8$classId = 2;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num != null) {
                num.intValue();
            }
            builder.contains(UseTorchAsFlashQuirk.class);
            BarcodeExtensionsKt.isFlashAvailable(new OnBackPressedDispatcher$$ExternalSyntheticLambda0(3, cameraCharacteristicsCompat));
        }

        public Key() {
            this.$r8$classId = 7;
            new LruCache(16);
            long[] jArr = ScatterMapKt.EmptyGroup;
            new MutableScatterMap();
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onDiagnosticReceived() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
        }
    }
}
