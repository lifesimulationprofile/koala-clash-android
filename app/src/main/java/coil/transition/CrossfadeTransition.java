package coil.transition;

import coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1;
import coil.drawable.CrossfadeDrawable;
import coil.network.HttpException;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeTransition implements Transition {
    public final int durationMillis;
    public final ImageResult result;
    public final AsyncImagePainterKt$fakeTransitionTarget$1 target;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Factory implements Transition.Factory {
        public final int durationMillis;

        public Factory(int i) {
            this.durationMillis = i;
            if (i <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        @Override // coil.transition.Transition.Factory
        public final Transition create(AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1, ImageResult imageResult) {
            if (imageResult instanceof SuccessResult) {
                return ((SuccessResult) imageResult).dataSource == 1 ? new NoneTransition(asyncImagePainterKt$fakeTransitionTarget$1, imageResult) : new CrossfadeTransition(asyncImagePainterKt$fakeTransitionTarget$1, imageResult, this.durationMillis);
            }
            return new NoneTransition(asyncImagePainterKt$fakeTransitionTarget$1, imageResult);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Factory) {
                return this.durationMillis == ((Factory) obj).durationMillis;
            }
            return false;
        }

        public final int hashCode() {
            return (this.durationMillis * 31) + 1237;
        }
    }

    public CrossfadeTransition(AsyncImagePainterKt$fakeTransitionTarget$1 asyncImagePainterKt$fakeTransitionTarget$1, ImageResult imageResult, int i) {
        this.target = asyncImagePainterKt$fakeTransitionTarget$1;
        this.result = imageResult;
        this.durationMillis = i;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override // coil.transition.Transition
    public final void transition() {
        this.target.getClass();
        ImageResult imageResult = this.result;
        boolean z = imageResult instanceof SuccessResult;
        new CrossfadeDrawable(imageResult.getDrawable(), imageResult.getRequest().scale, this.durationMillis, (z && ((SuccessResult) imageResult).isPlaceholderCached) ? false : true);
        if (!z && !(imageResult instanceof ErrorResult)) {
            throw new HttpException();
        }
    }
}
