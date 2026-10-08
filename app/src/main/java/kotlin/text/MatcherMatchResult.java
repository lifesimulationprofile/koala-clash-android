package kotlin.text;

import java.util.regex.Matcher;
import kotlin.collections.ReversedListReadOnly;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class MatcherMatchResult {
    public ReversedListReadOnly groupValues_;
    public final MatcherMatchResult$groups$1 groups = new MatcherMatchResult$groups$1(0, this);
    public final CharSequence input;
    public final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        this.matcher = matcher;
        this.input = charSequence;
    }

    public final IntRange getRange() {
        Matcher matcher = this.matcher;
        return RangesKt.until(matcher.start(), matcher.end());
    }
}
