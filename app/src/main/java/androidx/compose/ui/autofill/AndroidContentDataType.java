package androidx.compose.ui.autofill;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidContentDataType {
    public final int androidAutofillType;

    public final boolean equals(Object obj) {
        if (obj instanceof AndroidContentDataType) {
            return this.androidAutofillType == ((AndroidContentDataType) obj).androidAutofillType;
        }
        return false;
    }

    public final int hashCode() {
        return this.androidAutofillType;
    }

    public final String toString() {
        return "AndroidContentDataType(androidAutofillType=" + this.androidAutofillType + ')';
    }
}
