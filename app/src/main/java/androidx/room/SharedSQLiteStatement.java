package androidx.room;

import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import com.google.android.material.progressindicator.BaseProgressIndicator;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.SynchronizedLazyImpl;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    public Object database;
    public final Serializable lock;
    public final Serializable stmt$delegate;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.database = roomDatabase;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(21, this));
    }

    public FrameworkSQLiteStatement acquire() {
        RoomDatabase roomDatabase = (RoomDatabase) this.database;
        roomDatabase.assertNotMainThread();
        if (((AtomicBoolean) this.lock).compareAndSet(false, true)) {
            return (FrameworkSQLiteStatement) ((SynchronizedLazyImpl) this.stmt$delegate).getValue();
        }
        String strCreateQuery = createQuery();
        roomDatabase.assertNotMainThread();
        roomDatabase.assertNotSuspendingTransaction();
        return roomDatabase.getOpenHelper().getWritableDatabase().compileStatement(strCreateQuery);
    }

    public abstract void cancelAnimatorImmediately();

    public abstract String createQuery();

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(BaseProgressIndicator.AnonymousClass3 anonymousClass3);

    public void release(FrameworkSQLiteStatement frameworkSQLiteStatement) {
        if (frameworkSQLiteStatement == ((FrameworkSQLiteStatement) ((SynchronizedLazyImpl) this.stmt$delegate).getValue())) {
            ((AtomicBoolean) this.lock).set(false);
        }
    }

    public abstract void requestCancelAnimatorAfterCurrentCycle();

    public abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();

    /* JADX WARN: Type inference failed for: r0v1, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int[], java.io.Serializable] */
    public SharedSQLiteStatement(int i) {
        this.lock = new float[i * 2];
        this.stmt$delegate = new int[i];
    }
}
