package com.github.kr328.clash.log;

import android.content.Context;
import com.github.kr328.clash.design.model.LogFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import kotlin.io.FilesKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatWriter implements AutoCloseable {
    public final BufferedWriter writer;

    public LogcatWriter(Context context) {
        Regex regex = LogFile.REGEX_FILE;
        this.writer = new BufferedWriter(new FileWriter(FilesKt.resolve(FilesKt.resolve(context.getCacheDir(), "logs"), String.format("clash-%d.log", Arrays.copyOf(new Object[]{Long.valueOf(new Date().getTime())}, 1)))));
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.writer.close();
    }
}
