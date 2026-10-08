package com.github.kr328.clash.log;

import com.github.kr328.clash.LogcatActivity;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatFilter extends BufferedWriter {
    public final LogcatActivity context;

    public LogcatFilter(OutputStreamWriter outputStreamWriter, LogcatActivity logcatActivity) {
        super(outputStreamWriter);
        this.context = logcatActivity;
    }
}
