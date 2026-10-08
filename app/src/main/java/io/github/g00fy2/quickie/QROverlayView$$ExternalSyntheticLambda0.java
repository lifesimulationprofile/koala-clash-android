package io.github.g00fy2.quickie;

import android.view.View;
import coil.decode.SvgDecoder$$ExternalSyntheticLambda0;
import kotlin.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QROverlayView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function f$0;

    public /* synthetic */ QROverlayView$$ExternalSyntheticLambda0(Function function, int i) {
        this.$r8$classId = i;
        this.f$0 = function;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Exception {
        int i = this.$r8$classId;
        Function function = this.f$0;
        switch (i) {
            case 0:
                int i2 = QROverlayView.$r8$clinit;
                ((Function1) function).invoke(Boolean.valueOf(!view.isSelected()));
                break;
            default:
                int i3 = QROverlayView.$r8$clinit;
                ((SvgDecoder$$ExternalSyntheticLambda0) function).invoke();
                break;
        }
    }
}
