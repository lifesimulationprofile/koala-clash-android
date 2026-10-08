package coil.transition;

import android.graphics.drawable.Drawable;
import coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1;
import coil.network.HttpException;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class NoneTransition implements Transition {
    public final ImageResult result;
    public final AsyncImagePainterKt$fakeTransitionTarget$1 target;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Factory implements Transition.Factory {
        @Override // coil.transition.Transition.Factory
        public final Transition create(AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1, ImageResult imageResult) {
            return new NoneTransition(asyncImagePainterKt$fakeTransitionTarget$1, imageResult);
        }

        public final boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public final int hashCode() {
            return Factory.class.hashCode();
        }
    }

    public NoneTransition(AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1, ImageResult imageResult) {
        this.target = asyncImagePainterKt$fakeTransitionTarget$1;
        this.result = imageResult;
    }

    @Override // coil.transition.Transition
    public final void transition() {
        ImageResult imageResult = this.result;
        boolean z = imageResult instanceof SuccessResult;
        AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1 = this.target;
        if (z) {
            Drawable drawable = ((SuccessResult) imageResult).drawable;
            asyncImagePainterKt$fakeTransitionTarget$1.getClass();
        } else {
            if (!(imageResult instanceof ErrorResult)) {
                throw new HttpException();
            }
            Drawable drawable2 = ((ErrorResult) imageResult).drawable;
            asyncImagePainterKt$fakeTransitionTarget$1.getClass();
        }
    }
}
