package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class jClass;

    public PackageReference(Class cls) {
        this.jClass = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageReference) {
            return Intrinsics.areEqual(this.jClass, ((PackageReference) obj).jClass);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    public final int hashCode() {
        return this.jClass.hashCode();
    }

    public final String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
