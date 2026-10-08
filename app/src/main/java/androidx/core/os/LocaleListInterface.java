package androidx.core.os;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public interface LocaleListInterface {
    Locale get(int i);

    Object getLocaleList();

    boolean isEmpty();

    int size();

    String toLanguageTags();
}
