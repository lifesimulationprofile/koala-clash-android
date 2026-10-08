package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.mlkit_vision_common.zzlh;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class zzal implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = zzlh.validateObjectHeader(parcel);
                String[] strArrCreateStringArray = null;
                int i = 0;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i2 = parcel.readInt();
                    char c = (char) i2;
                    if (c == 1) {
                        i = zzlh.readInt(parcel, i2);
                    } else if (c != 2) {
                        zzlh.skipUnknownField(parcel, i2);
                    } else {
                        strArrCreateStringArray = zzlh.createStringArray(parcel, i2);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader);
                return new zzam(i, strArrCreateStringArray);
            case 1:
                int iValidateObjectHeader2 = zzlh.validateObjectHeader(parcel);
                String strCreateString = null;
                String strCreateString2 = null;
                byte[] bArrCreateByteArray = null;
                Point[] pointArr = null;
                zzar zzarVar = null;
                zzau zzauVar = null;
                zzav zzavVar = null;
                zzax zzaxVar = null;
                zzaw zzawVar = null;
                zzas zzasVar = null;
                zzao zzaoVar = null;
                zzap zzapVar = null;
                zzaq zzaqVar = null;
                int i3 = 0;
                int i4 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i5 = parcel.readInt();
                    switch ((char) i5) {
                        case 1:
                            i3 = zzlh.readInt(parcel, i5);
                            break;
                        case 2:
                            strCreateString = zzlh.createString(parcel, i5);
                            break;
                        case 3:
                            strCreateString2 = zzlh.createString(parcel, i5);
                            break;
                        case 4:
                            bArrCreateByteArray = zzlh.createByteArray(parcel, i5);
                            break;
                        case 5:
                            pointArr = (Point[]) zzlh.createTypedArray(i5, parcel, Point.CREATOR);
                            break;
                        case 6:
                            i4 = zzlh.readInt(parcel, i5);
                            break;
                        case 7:
                            zzarVar = (zzar) zzlh.createParcelable(i5, parcel, zzar.CREATOR);
                            break;
                        case '\b':
                            zzauVar = (zzau) zzlh.createParcelable(i5, parcel, zzau.CREATOR);
                            break;
                        case '\t':
                            zzavVar = (zzav) zzlh.createParcelable(i5, parcel, zzav.CREATOR);
                            break;
                        case '\n':
                            zzaxVar = (zzax) zzlh.createParcelable(i5, parcel, zzax.CREATOR);
                            break;
                        case 11:
                            zzawVar = (zzaw) zzlh.createParcelable(i5, parcel, zzaw.CREATOR);
                            break;
                        case '\f':
                            zzasVar = (zzas) zzlh.createParcelable(i5, parcel, zzas.CREATOR);
                            break;
                        case '\r':
                            zzaoVar = (zzao) zzlh.createParcelable(i5, parcel, zzao.CREATOR);
                            break;
                        case 14:
                            zzapVar = (zzap) zzlh.createParcelable(i5, parcel, zzap.CREATOR);
                            break;
                        case 15:
                            zzaqVar = (zzaq) zzlh.createParcelable(i5, parcel, zzaq.CREATOR);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i5);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader2);
                return new zzay(i3, strCreateString, strCreateString2, bArrCreateByteArray, pointArr, i4, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar);
            case 2:
                int iValidateObjectHeader3 = zzlh.validateObjectHeader(parcel);
                int i6 = 0;
                boolean z = false;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i7 = parcel.readInt();
                    char c2 = (char) i7;
                    if (c2 == 1) {
                        i6 = zzlh.readInt(parcel, i7);
                    } else if (c2 != 2) {
                        zzlh.skipUnknownField(parcel, i7);
                    } else {
                        z = zzlh.readBoolean(parcel, i7);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader3);
                return new zzba(i6, z);
            case 3:
                int iValidateObjectHeader4 = zzlh.validateObjectHeader(parcel);
                boolean z2 = false;
                zzbt zzbtVar = null;
                zzbv zzbvVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i8 = parcel.readInt();
                    char c3 = (char) i8;
                    if (c3 == 1) {
                        zzbtVar = (zzbt) zzlh.createParcelable(i8, parcel, zzbt.CREATOR);
                    } else if (c3 == 2) {
                        zzbvVar = (zzbv) zzlh.createParcelable(i8, parcel, zzbv.CREATOR);
                    } else if (c3 == 3) {
                        zzlh.readBoolean(parcel, i8);
                    } else if (c3 != 4) {
                        zzlh.skipUnknownField(parcel, i8);
                    } else {
                        z2 = zzlh.readBoolean(parcel, i8);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader4);
                return new zzbc(zzbtVar, zzbvVar, z2);
            case 4:
                int iValidateObjectHeader5 = zzlh.validateObjectHeader(parcel);
                zzbr zzbrVar = null;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i9 = parcel.readInt();
                    if (((char) i9) != 1) {
                        zzlh.skipUnknownField(parcel, i9);
                    } else {
                        zzbrVar = (zzbr) zzlh.createParcelable(i9, parcel, zzbr.CREATOR);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader5);
                return new zzbe(zzbrVar);
            case 5:
                int iValidateObjectHeader6 = zzlh.validateObjectHeader(parcel);
                String strCreateString3 = null;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                boolean z3 = false;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            i10 = zzlh.readInt(parcel, i16);
                            break;
                        case 2:
                            i11 = zzlh.readInt(parcel, i16);
                            break;
                        case 3:
                            i12 = zzlh.readInt(parcel, i16);
                            break;
                        case 4:
                            i13 = zzlh.readInt(parcel, i16);
                            break;
                        case 5:
                            i14 = zzlh.readInt(parcel, i16);
                            break;
                        case 6:
                            i15 = zzlh.readInt(parcel, i16);
                            break;
                        case 7:
                            z3 = zzlh.readBoolean(parcel, i16);
                            break;
                        case '\b':
                            strCreateString3 = zzlh.createString(parcel, i16);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i16);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader6);
                return new zzan(i10, i11, i12, i13, i14, i15, z3, strCreateString3);
            case 6:
                int iValidateObjectHeader7 = zzlh.validateObjectHeader(parcel);
                String strCreateString4 = null;
                String strCreateString5 = null;
                String strCreateString6 = null;
                String strCreateString7 = null;
                String strCreateString8 = null;
                zzan zzanVar = null;
                zzan zzanVar2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            strCreateString4 = zzlh.createString(parcel, i17);
                            break;
                        case 2:
                            strCreateString5 = zzlh.createString(parcel, i17);
                            break;
                        case 3:
                            strCreateString6 = zzlh.createString(parcel, i17);
                            break;
                        case 4:
                            strCreateString7 = zzlh.createString(parcel, i17);
                            break;
                        case 5:
                            strCreateString8 = zzlh.createString(parcel, i17);
                            break;
                        case 6:
                            zzanVar = (zzan) zzlh.createParcelable(i17, parcel, zzan.CREATOR);
                            break;
                        case 7:
                            zzanVar2 = (zzan) zzlh.createParcelable(i17, parcel, zzan.CREATOR);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i17);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader7);
                return new zzao(strCreateString4, strCreateString5, strCreateString6, strCreateString7, strCreateString8, zzanVar, zzanVar2);
            case 7:
                int iValidateObjectHeader8 = zzlh.validateObjectHeader(parcel);
                zzat zzatVar = null;
                String strCreateString9 = null;
                String strCreateString10 = null;
                zzau[] zzauVarArr = null;
                zzar[] zzarVarArr = null;
                String[] strArrCreateStringArray2 = null;
                zzam[] zzamVarArr = null;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            zzatVar = (zzat) zzlh.createParcelable(i18, parcel, zzat.CREATOR);
                            break;
                        case 2:
                            strCreateString9 = zzlh.createString(parcel, i18);
                            break;
                        case 3:
                            strCreateString10 = zzlh.createString(parcel, i18);
                            break;
                        case 4:
                            zzauVarArr = (zzau[]) zzlh.createTypedArray(i18, parcel, zzau.CREATOR);
                            break;
                        case 5:
                            zzarVarArr = (zzar[]) zzlh.createTypedArray(i18, parcel, zzar.CREATOR);
                            break;
                        case 6:
                            strArrCreateStringArray2 = zzlh.createStringArray(parcel, i18);
                            break;
                        case 7:
                            zzamVarArr = (zzam[]) zzlh.createTypedArray(i18, parcel, zzam.CREATOR);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i18);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader8);
                return new zzap(zzatVar, strCreateString9, strCreateString10, zzauVarArr, zzarVarArr, strArrCreateStringArray2, zzamVarArr);
            case 8:
                int iValidateObjectHeader9 = zzlh.validateObjectHeader(parcel);
                String strCreateString11 = null;
                String strCreateString12 = null;
                String strCreateString13 = null;
                String strCreateString14 = null;
                String strCreateString15 = null;
                String strCreateString16 = null;
                String strCreateString17 = null;
                String strCreateString18 = null;
                String strCreateString19 = null;
                String strCreateString20 = null;
                String strCreateString21 = null;
                String strCreateString22 = null;
                String strCreateString23 = null;
                String strCreateString24 = null;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i19 = parcel.readInt();
                    switch ((char) i19) {
                        case 1:
                            strCreateString11 = zzlh.createString(parcel, i19);
                            break;
                        case 2:
                            strCreateString12 = zzlh.createString(parcel, i19);
                            break;
                        case 3:
                            strCreateString13 = zzlh.createString(parcel, i19);
                            break;
                        case 4:
                            strCreateString14 = zzlh.createString(parcel, i19);
                            break;
                        case 5:
                            strCreateString15 = zzlh.createString(parcel, i19);
                            break;
                        case 6:
                            strCreateString16 = zzlh.createString(parcel, i19);
                            break;
                        case 7:
                            strCreateString17 = zzlh.createString(parcel, i19);
                            break;
                        case '\b':
                            strCreateString18 = zzlh.createString(parcel, i19);
                            break;
                        case '\t':
                            strCreateString19 = zzlh.createString(parcel, i19);
                            break;
                        case '\n':
                            strCreateString20 = zzlh.createString(parcel, i19);
                            break;
                        case 11:
                            strCreateString21 = zzlh.createString(parcel, i19);
                            break;
                        case '\f':
                            strCreateString22 = zzlh.createString(parcel, i19);
                            break;
                        case '\r':
                            strCreateString23 = zzlh.createString(parcel, i19);
                            break;
                        case 14:
                            strCreateString24 = zzlh.createString(parcel, i19);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i19);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader9);
                return new zzaq(strCreateString11, strCreateString12, strCreateString13, strCreateString14, strCreateString15, strCreateString16, strCreateString17, strCreateString18, strCreateString19, strCreateString20, strCreateString21, strCreateString22, strCreateString23, strCreateString24);
            case 9:
                int iValidateObjectHeader10 = zzlh.validateObjectHeader(parcel);
                String strCreateString25 = null;
                String strCreateString26 = null;
                int i20 = 0;
                String strCreateString27 = null;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i21 = parcel.readInt();
                    char c4 = (char) i21;
                    if (c4 == 1) {
                        i20 = zzlh.readInt(parcel, i21);
                    } else if (c4 == 2) {
                        strCreateString25 = zzlh.createString(parcel, i21);
                    } else if (c4 == 3) {
                        strCreateString27 = zzlh.createString(parcel, i21);
                    } else if (c4 != 4) {
                        zzlh.skipUnknownField(parcel, i21);
                    } else {
                        strCreateString26 = zzlh.createString(parcel, i21);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new zzar(i20, strCreateString25, strCreateString27, strCreateString26);
            case 10:
                int iValidateObjectHeader11 = zzlh.validateObjectHeader(parcel);
                double d = 0.0d;
                double d2 = 0.0d;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i22 = parcel.readInt();
                    char c5 = (char) i22;
                    if (c5 == 1) {
                        d = zzlh.readDouble(parcel, i22);
                    } else if (c5 != 2) {
                        zzlh.skipUnknownField(parcel, i22);
                    } else {
                        d2 = zzlh.readDouble(parcel, i22);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader11);
                return new zzas(d, d2);
            case 11:
                int iValidateObjectHeader12 = zzlh.validateObjectHeader(parcel);
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                float f = 0.0f;
                byte[] bArrCreateByteArray2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader12) {
                    int i23 = parcel.readInt();
                    char c6 = (char) i23;
                    if (c6 == 1) {
                        z4 = zzlh.readBoolean(parcel, i23);
                    } else if (c6 == 2) {
                        bArrCreateByteArray2 = zzlh.createByteArray(parcel, i23);
                    } else if (c6 == 3) {
                        z5 = zzlh.readBoolean(parcel, i23);
                    } else if (c6 == 4) {
                        zzlh.zzb(parcel, i23, 4);
                        f = parcel.readFloat();
                    } else if (c6 != 5) {
                        zzlh.skipUnknownField(parcel, i23);
                    } else {
                        z6 = zzlh.readBoolean(parcel, i23);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader12);
                return new zzbr(z4, bArrCreateByteArray2, z5, f, z6);
            case 12:
                int iValidateObjectHeader13 = zzlh.validateObjectHeader(parcel);
                int i24 = 0;
                boolean z7 = false;
                while (true) {
                    float[] fArr = null;
                    while (true) {
                        if (parcel.dataPosition() >= iValidateObjectHeader13) {
                            zzlh.ensureAtEnd(parcel, iValidateObjectHeader13);
                            return new zzbt(fArr, i24, z7);
                        }
                        int i25 = parcel.readInt();
                        char c7 = (char) i25;
                        if (c7 == 1) {
                            int size = zzlh.readSize(parcel, i25);
                            int iDataPosition = parcel.dataPosition();
                            if (size == 0) {
                            }
                            float[] fArrCreateFloatArray = parcel.createFloatArray();
                            parcel.setDataPosition(iDataPosition + size);
                            fArr = fArrCreateFloatArray;
                            break;
                        } else if (c7 == 2) {
                            i24 = zzlh.readInt(parcel, i25);
                        } else if (c7 != 3) {
                            zzlh.skipUnknownField(parcel, i25);
                        } else {
                            z7 = zzlh.readBoolean(parcel, i25);
                        }
                    }
                }
                break;
            case 13:
                int iValidateObjectHeader14 = zzlh.validateObjectHeader(parcel);
                while (true) {
                    float[] fArr2 = null;
                    while (true) {
                        if (parcel.dataPosition() >= iValidateObjectHeader14) {
                            zzlh.ensureAtEnd(parcel, iValidateObjectHeader14);
                            return new zzbv(fArr2);
                        }
                        int i26 = parcel.readInt();
                        if (((char) i26) != 1) {
                            zzlh.skipUnknownField(parcel, i26);
                        } else {
                            int size2 = zzlh.readSize(parcel, i26);
                            int iDataPosition2 = parcel.dataPosition();
                            if (size2 == 0) {
                            }
                            float[] fArrCreateFloatArray2 = parcel.createFloatArray();
                            parcel.setDataPosition(iDataPosition2 + size2);
                            fArr2 = fArrCreateFloatArray2;
                        }
                        break;
                    }
                }
                break;
            case 14:
                int iValidateObjectHeader15 = zzlh.validateObjectHeader(parcel);
                String strCreateString28 = null;
                String strCreateString29 = null;
                String strCreateString30 = null;
                String strCreateString31 = null;
                String strCreateString32 = null;
                String strCreateString33 = null;
                String strCreateString34 = null;
                while (parcel.dataPosition() < iValidateObjectHeader15) {
                    int i27 = parcel.readInt();
                    switch ((char) i27) {
                        case 1:
                            strCreateString28 = zzlh.createString(parcel, i27);
                            break;
                        case 2:
                            strCreateString29 = zzlh.createString(parcel, i27);
                            break;
                        case 3:
                            strCreateString30 = zzlh.createString(parcel, i27);
                            break;
                        case 4:
                            strCreateString31 = zzlh.createString(parcel, i27);
                            break;
                        case 5:
                            strCreateString32 = zzlh.createString(parcel, i27);
                            break;
                        case 6:
                            strCreateString33 = zzlh.createString(parcel, i27);
                            break;
                        case 7:
                            strCreateString34 = zzlh.createString(parcel, i27);
                            break;
                        default:
                            zzlh.skipUnknownField(parcel, i27);
                            break;
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader15);
                return new zzat(strCreateString28, strCreateString29, strCreateString30, strCreateString31, strCreateString32, strCreateString33, strCreateString34);
            case 15:
                int iValidateObjectHeader16 = zzlh.validateObjectHeader(parcel);
                String strCreateString35 = null;
                int i28 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader16) {
                    int i29 = parcel.readInt();
                    char c8 = (char) i29;
                    if (c8 == 1) {
                        i28 = zzlh.readInt(parcel, i29);
                    } else if (c8 != 2) {
                        zzlh.skipUnknownField(parcel, i29);
                    } else {
                        strCreateString35 = zzlh.createString(parcel, i29);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader16);
                return new zzau(strCreateString35, i28);
            case 16:
                int iValidateObjectHeader17 = zzlh.validateObjectHeader(parcel);
                String strCreateString36 = null;
                String strCreateString37 = null;
                while (parcel.dataPosition() < iValidateObjectHeader17) {
                    int i30 = parcel.readInt();
                    char c9 = (char) i30;
                    if (c9 == 1) {
                        strCreateString36 = zzlh.createString(parcel, i30);
                    } else if (c9 != 2) {
                        zzlh.skipUnknownField(parcel, i30);
                    } else {
                        strCreateString37 = zzlh.createString(parcel, i30);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader17);
                return new zzav(strCreateString36, strCreateString37);
            case 17:
                int iValidateObjectHeader18 = zzlh.validateObjectHeader(parcel);
                String strCreateString38 = null;
                String strCreateString39 = null;
                while (parcel.dataPosition() < iValidateObjectHeader18) {
                    int i31 = parcel.readInt();
                    char c10 = (char) i31;
                    if (c10 == 1) {
                        strCreateString38 = zzlh.createString(parcel, i31);
                    } else if (c10 != 2) {
                        zzlh.skipUnknownField(parcel, i31);
                    } else {
                        strCreateString39 = zzlh.createString(parcel, i31);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader18);
                return new zzaw(strCreateString38, strCreateString39);
            case 18:
                int iValidateObjectHeader19 = zzlh.validateObjectHeader(parcel);
                int i32 = 0;
                String strCreateString40 = null;
                String strCreateString41 = null;
                while (parcel.dataPosition() < iValidateObjectHeader19) {
                    int i33 = parcel.readInt();
                    char c11 = (char) i33;
                    if (c11 == 1) {
                        strCreateString40 = zzlh.createString(parcel, i33);
                    } else if (c11 == 2) {
                        strCreateString41 = zzlh.createString(parcel, i33);
                    } else if (c11 != 3) {
                        zzlh.skipUnknownField(parcel, i33);
                    } else {
                        i32 = zzlh.readInt(parcel, i33);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader19);
                return new zzax(i32, strCreateString40, strCreateString41);
            default:
                int iValidateObjectHeader20 = zzlh.validateObjectHeader(parcel);
                long j = 0;
                int i34 = 0;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader20) {
                    int i38 = parcel.readInt();
                    char c12 = (char) i38;
                    if (c12 == 1) {
                        i34 = zzlh.readInt(parcel, i38);
                    } else if (c12 == 2) {
                        i35 = zzlh.readInt(parcel, i38);
                    } else if (c12 == 3) {
                        i36 = zzlh.readInt(parcel, i38);
                    } else if (c12 == 4) {
                        i37 = zzlh.readInt(parcel, i38);
                    } else if (c12 != 5) {
                        zzlh.skipUnknownField(parcel, i38);
                    } else {
                        j = zzlh.readLong(parcel, i38);
                    }
                }
                zzlh.ensureAtEnd(parcel, iValidateObjectHeader20);
                return new zzcc(i34, i35, i36, i37, j);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new zzam[i];
            case 1:
                return new zzay[i];
            case 2:
                return new zzba[i];
            case 3:
                return new zzbc[i];
            case 4:
                return new zzbe[i];
            case 5:
                return new zzan[i];
            case 6:
                return new zzao[i];
            case 7:
                return new zzap[i];
            case 8:
                return new zzaq[i];
            case 9:
                return new zzar[i];
            case 10:
                return new zzas[i];
            case 11:
                return new zzbr[i];
            case 12:
                return new zzbt[i];
            case 13:
                return new zzbv[i];
            case 14:
                return new zzat[i];
            case 15:
                return new zzau[i];
            case 16:
                return new zzav[i];
            case 17:
                return new zzaw[i];
            case 18:
                return new zzax[i];
            default:
                return new zzcc[i];
        }
    }
}
