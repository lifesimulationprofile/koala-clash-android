package androidx.compose.ui.unit.fontscaling;

import androidx.room.TransactionElement;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class FontScaleConverterTable implements FontScaleConverter {
    public final float[] mFromSpValues;
    public final float[] mToDpValues;

    public FontScaleConverterTable(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.mFromSpValues = fArr;
        this.mToDpValues = fArr2;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertDpToSp(float f) {
        return TransactionElement.Key.access$lookupAndInterpolate(f, this.mToDpValues, this.mFromSpValues);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertSpToDp(float f) {
        return TransactionElement.Key.access$lookupAndInterpolate(f, this.mFromSpValues, this.mToDpValues);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FontScaleConverterTable)) {
            return false;
        }
        FontScaleConverterTable fontScaleConverterTable = (FontScaleConverterTable) obj;
        return Arrays.equals(this.mFromSpValues, fontScaleConverterTable.mFromSpValues) && Arrays.equals(this.mToDpValues, fontScaleConverterTable.mToDpValues);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.mToDpValues) + (Arrays.hashCode(this.mFromSpValues) * 31);
    }

    public final String toString() {
        return "FontScaleConverter{fromSpValues=" + Arrays.toString(this.mFromSpValues) + ", toDpValues=" + Arrays.toString(this.mToDpValues) + '}';
    }
}
