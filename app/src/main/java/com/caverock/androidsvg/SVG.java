package com.caverock.androidsvg;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.LocationManager;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Base64;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.appcompat.app.TwilightManager$TwilightState;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.view.PreviewView;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposePausableCompositionException;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.GeometryUtilsKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.PaintCompat;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.DefaultGlyphChecker;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.EmojiProcessor$ProcessorSm;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.recyclerview.widget.RecyclerView;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkTagDao_Impl$1;
import androidx.work.impl.model.WorkTagDao_Impl$2;
import coil.disk.RealDiskCache;
import coil.request.RequestService;
import com.github.kr328.clash.log.LogcatCache;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import com.google.android.gms.internal.mlkit_vision_common.zzle;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.MaterialCalendar;
import com.koala.clash.R;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Adler32;
import java.util.zip.GZIPInputStream;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.Dispatcher;
import okhttp3.internal.http1.HeadersReader;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class SVG implements Applier {
    public static SVG sInstance;
    public final /* synthetic */ int $r8$classId;
    public Object cssRules;
    public Object idToElementMap;
    public Object rootElement;

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Circle extends GraphicsElement {
        public Length cx;
        public Length cy;
        public Length r;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "circle";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class ClipPath extends Group implements NotDirectlyRendered {
        public Boolean clipPathUnitsAreUser;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "clipPath";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Colour extends SvgPaint {
        public static final Colour BLACK = new Colour(-16777216);
        public static final Colour TRANSPARENT = new Colour(0);
        public final int colour;

        public Colour(int i) {
            this.colour = i;
        }

        public final String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class CurrentColor extends SvgPaint {
        public static final CurrentColor instance = new CurrentColor();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Defs extends Group implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "defs";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Ellipse extends GraphicsElement {
        public Length cx;
        public Length cy;
        public Length rx;
        public Length ry;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "ellipse";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class GradientElement extends SvgElementBase implements SvgContainer {
        public List children = new ArrayList();
        public Matrix gradientTransform;
        public Boolean gradientUnitsAreUser;
        public String href;
        public int spreadMethod;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + svgObject + " elements.");
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final List getChildren() {
            return this.children;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class GraphicsElement extends SvgElement implements HasTransform, SvgConditional {
        public Matrix transform;
        public HashSet requiredFeatures = null;
        public String requiredExtensions = null;
        public HashSet systemLanguage = null;
        public HashSet requiredFormats = null;
        public HashSet requiredFonts = null;

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFeatures(HashSet hashSet) {
            this.requiredFeatures = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFonts(HashSet hashSet) {
            this.requiredFonts = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFormats(HashSet hashSet) {
            this.requiredFormats = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setSystemLanguage(HashSet hashSet) {
            this.systemLanguage = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class Group extends SvgConditionalContainer implements HasTransform {
        public Matrix transform;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "group";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        public Length height;
        public String href;
        public Matrix transform;
        public Length width;
        public Length x;
        public Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "image";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Line extends GraphicsElement {
        public Length x1;
        public Length x2;
        public Length y1;
        public Length y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "line";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length markerHeight;
        public boolean markerUnitsAreUser;
        public Length markerWidth;
        public Float orient;
        public Length refX;
        public Length refY;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "marker";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        public Length height;
        public Boolean maskContentUnitsAreUser;
        public Boolean maskUnitsAreUser;
        public Length width;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "mask";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface NotDirectlyRendered {
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class PaintReference extends SvgPaint {
        public final SvgPaint fallback;
        public final String href;

        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public final String toString() {
            return this.href + " " + this.fallback;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Path extends GraphicsElement {
        public LogcatCache d;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "path";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface PathInterface {
        void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5);

        void close();

        void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

        void lineTo(float f, float f2);

        void moveTo(float f, float f2);

        void quadTo(float f, float f2, float f3, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length height;
        public String href;
        public Boolean patternContentUnitsAreUser;
        public Matrix patternTransform;
        public Boolean patternUnitsAreUser;
        public Length width;
        public Length x;
        public Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "pattern";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public class PolyLine extends GraphicsElement {
        public float[] points;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "polyline";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Polygon extends PolyLine {
        @Override // com.caverock.androidsvg.SVG.PolyLine, com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "polygon";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Rect extends GraphicsElement {
        public Length height;
        public Length rx;
        public Length ry;
        public Length width;
        public Length x;
        public Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "rect";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Style implements Cloneable {
        public Dispatcher clip;
        public String clipPath;
        public int clipRule;
        public Colour color;
        public int direction;
        public Boolean display;
        public SvgPaint fill;
        public Float fillOpacity;
        public int fillRule;
        public ArrayList fontFamily;
        public Length fontSize;
        public int fontStyle;
        public Integer fontWeight;
        public int imageRendering;
        public String markerEnd;
        public String markerMid;
        public String markerStart;
        public String mask;
        public Float opacity;
        public Boolean overflow;
        public SvgPaint solidColor;
        public Float solidOpacity;
        public long specifiedFlags = 0;
        public SvgPaint stopColor;
        public Float stopOpacity;
        public SvgPaint stroke;
        public Length[] strokeDashArray;
        public Length strokeDashOffset;
        public int strokeLineCap;
        public int strokeLineJoin;
        public Float strokeMiterLimit;
        public Float strokeOpacity;
        public Length strokeWidth;
        public int textAnchor;
        public int textDecoration;
        public int vectorEffect;
        public SvgPaint viewportFill;
        public Float viewportFillOpacity;
        public Boolean visibility;

        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1L;
            Colour colour = Colour.BLACK;
            style.fill = colour;
            style.fillRule = 1;
            Float fValueOf = Float.valueOf(1.0f);
            style.fillOpacity = fValueOf;
            style.stroke = null;
            style.strokeOpacity = fValueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = 1;
            style.strokeLineJoin = 1;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = fValueOf;
            style.color = colour;
            style.fontFamily = null;
            style.fontSize = new Length(7, 12.0f);
            style.fontWeight = 400;
            style.fontStyle = 1;
            style.textDecoration = 1;
            style.direction = 1;
            style.textAnchor = 1;
            Boolean bool = Boolean.TRUE;
            style.overflow = bool;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = bool;
            style.visibility = bool;
            style.stopColor = colour;
            style.stopOpacity = fValueOf;
            style.clipPath = null;
            style.clipRule = 1;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = fValueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = fValueOf;
            style.vectorEffect = 1;
            style.imageRendering = 1;
            return style;
        }

        public final Object clone() {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Svg extends SvgViewBoxContainer {
        public Length height;
        public Length width;
        public Length x;
        public Length y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "svg";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface SvgConditional {
        String getRequiredExtensions();

        Set getRequiredFeatures();

        Set getRequiredFonts();

        Set getRequiredFormats();

        Set getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(HashSet hashSet);

        void setRequiredFonts(HashSet hashSet);

        void setRequiredFormats(HashSet hashSet);

        void setSystemLanguage(HashSet hashSet);
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface SvgContainer {
        void addChild(SvgObject svgObject);

        List getChildren();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgElement extends SvgElementBase {
        public Box boundingBox = null;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgElementBase extends SvgObject {
        public String id = null;
        public Boolean spacePreserve = null;
        public Style baseStyle = null;
        public Style style = null;
        public ArrayList classNames = null;

        public final String toString() {
            return getNodeName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SvgLinearGradient extends GradientElement {
        public Length x1;
        public Length x2;
        public Length y1;
        public Length y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "linearGradient";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgObject {
        public SVG document;
        public SvgContainer parent;

        public abstract String getNodeName();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgPaint implements Cloneable {
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        public PreserveAspectRatio preserveAspectRatio = null;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SvgRadialGradient extends GradientElement {
        public Length cx;
        public Length cy;
        public Length fx;
        public Length fy;
        public Length r;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "radialGradient";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        public Box viewBox;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Switch extends Group {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "switch";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "symbol";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class TRef extends TextContainer implements TextChild {
        public String href;
        public Text textRoot;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "tref";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public final Text getTextRoot() {
            return this.textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class TSpan extends TextPositionedContainer implements TextChild {
        public Text textRoot;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "tspan";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public final Text getTextRoot() {
            return this.textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Text extends TextPositionedContainer implements HasTransform {
        public Matrix transform;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "text";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public final void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public interface TextChild {
        Text getTextRoot();
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class TextContainer extends SvgConditionalContainer {
        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public final void addChild(SvgObject svgObject) throws SVGParseException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class TextPath extends TextContainer implements TextChild {
        public String href;
        public Length startOffset;
        public Text textRoot;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "textPath";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public final Text getTextRoot() {
            return this.textRoot;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class TextPositionedContainer extends TextContainer {
        public ArrayList dx;
        public ArrayList dy;
        public ArrayList x;
        public ArrayList y;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class TextSequence extends SvgObject implements TextChild {
        public String text;

        @Override // com.caverock.androidsvg.SVG.TextChild
        public final Text getTextRoot() {
            return null;
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("TextChild: '"), this.text, "'");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Use extends Group {
        public Length height;
        public String href;
        public Length width;
        public Length x;
        public Length y;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "use";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "view";
        }
    }

    public /* synthetic */ SVG(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.id)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.id)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (elementById = getElementById((SvgContainer) obj, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    public static SVG getFromInputStream(InputStream inputStream) {
        SVGParser sVGParser = new SVGParser();
        sVGParser.svgDocument = null;
        sVGParser.currentElement = null;
        sVGParser.ignoring = false;
        sVGParser.inMetadataElement = false;
        sVGParser.metadataTag = null;
        sVGParser.metadataElementContents = null;
        sVGParser.inStyleElement = false;
        sVGParser.styleElementContents = null;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int i = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (i == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            sVGParser.parseUsingXmlPullParser(inputStream);
            return sVGParser.svgDocument;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }

    public void addView(android.view.View view, int i, boolean z) {
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = i < 0 ? recyclerView.getChildCount() : getOffset(i);
        ((HeadersReader) this.cssRules).insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.getChildViewHolderInt(view);
    }

    @Override // androidx.compose.runtime.Applier
    public void apply(Object obj, Function2 function2) {
        switch (this.$r8$classId) {
            case 7:
                ((MutableIntList) this.rootElement).add(7);
                MutableObjectList mutableObjectList = (MutableObjectList) this.cssRules;
                mutableObjectList.add(function2);
                mutableObjectList.add(obj);
                break;
            default:
                function2.invoke(this.idToElementMap, obj);
                break;
        }
    }

    public void attachViewToParent(android.view.View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = i < 0 ? recyclerView.getChildCount() : getOffset(i);
        ((HeadersReader) this.cssRules).insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + recyclerView.exceptionLabel());
            }
            childViewHolderInt.mFlags &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public void clear() {
        ((ArrayList) this.cssRules).clear();
        this.idToElementMap = this.rootElement;
        ((LayoutNode) this.rootElement).removeAll$ui();
    }

    public void delete(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.rootElement;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl$2 workTagDao_Impl$2 = (WorkTagDao_Impl$2) this.cssRules;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = workTagDao_Impl$2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            workTagDao_Impl$2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public Object dequeue() {
        Object objRemoveLast;
        synchronized (this.cssRules) {
            objRemoveLast = ((ArrayDeque) this.rootElement).removeLast();
        }
        return objRemoveLast;
    }

    public void detachViewFromParent(int i) {
        RecyclerView.ViewHolder childViewHolderInt;
        int offset = getOffset(i);
        ((HeadersReader) this.cssRules).remove(offset);
        RecyclerView recyclerView = RecyclerView.this;
        android.view.View childAt = recyclerView.getChildAt(offset);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + recyclerView.exceptionLabel());
            }
            childViewHolderInt.addFlags(256);
        }
        recyclerView.detachViewFromParent(offset);
    }

    @Override // androidx.compose.runtime.Applier
    public void down(Object obj) {
        switch (this.$r8$classId) {
            case 7:
                ((MutableIntList) this.rootElement).add(1);
                ((MutableObjectList) this.cssRules).add(obj);
                break;
            default:
                ((ArrayList) this.cssRules).add(this.idToElementMap);
                this.idToElementMap = obj;
                break;
        }
    }

    public void enqueue(ImageProxy imageProxy) throws Exception {
        Object objDequeue;
        ImageInfo imageInfo = imageProxy.getImageInfo();
        CameraCaptureResult cameraCaptureResult = imageInfo instanceof CameraCaptureResultImageInfo ? ((CameraCaptureResultImageInfo) imageInfo).mCameraCaptureResult : null;
        if ((cameraCaptureResult.getAfState() != CameraCaptureMetaData$AfState.LOCKED_FOCUSED && cameraCaptureResult.getAfState() != CameraCaptureMetaData$AfState.PASSIVE_FOCUSED) || cameraCaptureResult.getAeState() != CameraCaptureMetaData$AeState.CONVERGED || cameraCaptureResult.getAwbState() != CameraCaptureMetaData$AwbState.CONVERGED) {
            ((ZslControlImpl$$ExternalSyntheticLambda0) this.idToElementMap).getClass();
            imageProxy.close();
            return;
        }
        synchronized (this.cssRules) {
            try {
                objDequeue = ((ArrayDeque) this.rootElement).size() >= 3 ? dequeue() : null;
                ((ArrayDeque) this.rootElement).addFirst(imageProxy);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((ZslControlImpl$$ExternalSyntheticLambda0) this.idToElementMap) == null || objDequeue == null) {
            return;
        }
        ((ImageProxy) objDequeue).close();
    }

    public Canvas getCanvas() {
        return ((CanvasDrawScope) this.idToElementMap).drawParams.canvas;
    }

    public android.view.View getChildAt(int i) {
        return RecyclerView.this.getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return RecyclerView.this.getChildCount() - ((ArrayList) this.idToElementMap).size();
    }

    public Density getDensity() {
        return ((CanvasDrawScope) this.idToElementMap).drawParams.density;
    }

    public Box getDocumentDimensions() {
        int i;
        float fFloatValue$1;
        int i2;
        Svg svg = (Svg) this.rootElement;
        Length length = svg.width;
        Length length2 = svg.height;
        if (length == null || length.isZero() || (i = length.unit) == 9 || i == 2 || i == 3) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float fFloatValue$2 = length.floatValue$1();
        if (length2 == null) {
            Box box = ((Svg) this.rootElement).viewBox;
            fFloatValue$1 = box != null ? (box.height * fFloatValue$2) / box.width : fFloatValue$2;
        } else {
            if (length2.isZero() || (i2 = length2.unit) == 9 || i2 == 2 || i2 == 3) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            fFloatValue$1 = length2.floatValue$1();
        }
        return new Box(0.0f, 0.0f, fFloatValue$2, fFloatValue$1);
    }

    public KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = (KeyboardActions) this.cssRules;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        throw null;
    }

    public LayoutDirection getLayoutDirection() {
        return ((CanvasDrawScope) this.idToElementMap).drawParams.layoutDirection;
    }

    public int getOffset(int i) {
        HeadersReader headersReader = (HeadersReader) this.cssRules;
        if (i < 0) {
            return -1;
        }
        int childCount = RecyclerView.this.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iCountOnesBefore = i - (i2 - headersReader.countOnesBefore(i2));
            if (iCountOnesBefore == 0) {
                while (headersReader.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iCountOnesBefore;
        }
        return -1;
    }

    public Size[] getOutputSizes(int i) {
        List arrayList;
        ArrayList arrayList2;
        HashMap map = (HashMap) this.idToElementMap;
        if (map.containsKey(Integer.valueOf(i))) {
            if (((Size[]) map.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) map.get(Integer.valueOf(i))).clone();
        }
        Size[] outputSizes = ((StreamConfigurationMap) ((PreviewView.AnonymousClass1) this.rootElement).this$0).getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            LazyKt__LazyJVMKt.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
            return outputSizes;
        }
        RequestService requestService = (RequestService) this.cssRules;
        requestService.getClass();
        ArrayList arrayList3 = new ArrayList(Arrays.asList(outputSizes));
        if (((ExtraSupportedOutputSizeQuirk) requestService.systemCallbacks) != null) {
            Size[] sizeArr = (i == 34 && "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL)) ? new Size[]{new Size(1440, 1080), new Size(960, 720)} : new Size[0];
            if (sizeArr.length > 0) {
                arrayList3.addAll(Arrays.asList(sizeArr));
            }
        }
        kotlinx.coroutines.internal.Symbol symbol = (kotlinx.coroutines.internal.Symbol) requestService.hardwareBitmapService;
        symbol.getClass();
        if (((ExcludedSupportedSizesQuirk) DeviceQuirks.sQuirks.get(ExcludedSupportedSizesQuirk.class)) == null) {
            arrayList = new ArrayList();
        } else {
            String str = symbol.symbol;
            String str2 = Build.BRAND;
            if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(4160, 3120));
                    arrayList2.add(new Size(4000, 3000));
                }
            } else if ("OnePlus".equalsIgnoreCase(str2) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(4160, 3120));
                    arrayList2.add(new Size(4000, 3000));
                }
            } else if ("HUAWEI".equalsIgnoreCase(str2) && "HWANE".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(720, 720));
                    arrayList2.add(new Size(400, 400));
                }
            } else if (ExcludedSupportedSizesQuirk.isSamsungJ7PrimeApi27Above()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new Size(4128, 3096));
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(3264, 2448));
                    arrayList2.add(new Size(3264, 1836));
                    arrayList2.add(new Size(2448, 2448));
                    arrayList2.add(new Size(1920, 1920));
                    arrayList2.add(new Size(2048, 1536));
                    arrayList2.add(new Size(2048, 1152));
                    arrayList2.add(new Size(1920, 1080));
                }
            } else if (ExcludedSupportedSizesQuirk.isSamsungJ7Api27Above()) {
                arrayList2 = new ArrayList();
                if (str.equals("0")) {
                    if (i == 34) {
                        arrayList2.add(new Size(4128, 3096));
                        arrayList2.add(new Size(4128, 2322));
                        arrayList2.add(new Size(3088, 3088));
                        arrayList2.add(new Size(3264, 2448));
                        arrayList2.add(new Size(3264, 1836));
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    } else if (i == 35) {
                        arrayList2.add(new Size(2048, 1536));
                        arrayList2.add(new Size(2048, 1152));
                        arrayList2.add(new Size(1920, 1080));
                    }
                } else if (str.equals("1") && (i == 34 || i == 35)) {
                    arrayList2.add(new Size(2576, 1932));
                    arrayList2.add(new Size(2560, 1440));
                    arrayList2.add(new Size(1920, 1920));
                    arrayList2.add(new Size(2048, 1536));
                    arrayList2.add(new Size(2048, 1152));
                    arrayList2.add(new Size(1920, 1080));
                }
            } else if ("REDMI".equalsIgnoreCase(str2) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) {
                arrayList2 = new ArrayList();
                if (str.equals("0") && i == 256) {
                    arrayList2.add(new Size(9280, 6944));
                }
            } else {
                LazyKt__LazyJVMKt.w("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
                arrayList = Collections.EMPTY_LIST;
            }
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            arrayList3.removeAll(arrayList);
        }
        if (arrayList3.isEmpty()) {
            LazyKt__LazyJVMKt.w("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        Size[] sizeArr2 = (Size[]) arrayList3.toArray(new Size[0]);
        map.put(Integer.valueOf(i), sizeArr2);
        return (Size[]) sizeArr2.clone();
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public long m795getSizeNHjbRc() {
        return ((CanvasDrawScope) this.idToElementMap).drawParams.size;
    }

    public android.view.View getUnfilteredChildAt(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return RecyclerView.this.getChildCount();
    }

    public boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            EmojiCompat.GlyphChecker glyphChecker = (EmojiCompat.GlyphChecker) this.idToElementMap;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset = metadataItem.__offset(8);
            if (i__offset != 0) {
                ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos);
            }
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) glyphChecker;
            defaultGlyphChecker.getClass();
            ThreadLocal threadLocal = DefaultGlyphChecker.sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = defaultGlyphChecker.mTextPaint;
            String string = sb.toString();
            int i3 = PaintCompat.$r8$clinit;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i4 = typefaceEmojiRasterizer.mCache & 4;
            typefaceEmojiRasterizer.mCache = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (typefaceEmojiRasterizer.mCache & 3) == 2;
    }

    public void hideViewInternal(android.view.View view) {
        ((ArrayList) this.idToElementMap).add(view);
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.rootElement;
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            android.view.View view2 = childViewHolderInt.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            int i = childViewHolderInt.mPendingAccessibilityState;
            if (i != -1) {
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = view2.getImportantForAccessibility();
            }
            if (recyclerView.isComputingLayout()) {
                childViewHolderInt.mPendingAccessibilityState = 4;
                recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
            } else {
                WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, Object obj) {
        switch (this.$r8$classId) {
            case 7:
                MutableIntList mutableIntList = (MutableIntList) this.rootElement;
                mutableIntList.add(5);
                mutableIntList.add(i);
                ((MutableObjectList) this.cssRules).add(obj);
                break;
            default:
                ((LayoutNode) this.idToElementMap).insertAt$ui(i, (LayoutNode) obj);
                break;
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, Object obj) {
        switch (this.$r8$classId) {
            case 7:
                MutableIntList mutableIntList = (MutableIntList) this.rootElement;
                mutableIntList.add(6);
                mutableIntList.add(i);
                ((MutableObjectList) this.cssRules).add(obj);
                break;
            default:
                break;
        }
    }

    public boolean isStaleResolvedFont() {
        if (((State) this.rootElement).getValue() != this.idToElementMap) {
            return true;
        }
        SVG svg = (SVG) this.cssRules;
        return svg != null && svg.isStaleResolvedFont();
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        switch (this.$r8$classId) {
            case 7:
                MutableIntList mutableIntList = (MutableIntList) this.rootElement;
                mutableIntList.add(3);
                mutableIntList.add(i);
                mutableIntList.add(i2);
                mutableIntList.add(i3);
                break;
            default:
                ((LayoutNode) this.idToElementMap).move$ui(i, i2, i3);
                break;
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void onEndChanges() {
        switch (this.$r8$classId) {
            case 7:
                break;
            default:
                Owner owner = ((LayoutNode) this.rootElement).owner;
                if (owner != null) {
                    ((AndroidComposeView) owner).onEndApplyChanges();
                }
                break;
        }
    }

    public void playTo(SVG svg, zzky zzkyVar) {
        Exception exc;
        MutableIntList mutableIntList = (MutableIntList) this.rootElement;
        int i = mutableIntList._size;
        MutableObjectList mutableObjectList = (MutableObjectList) this.cssRules;
        MutableObjectList mutableObjectList2 = new MutableObjectList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            try {
                try {
                    switch (mutableIntList.get(i2)) {
                        case 0:
                            svg.up();
                            i2 = i4;
                            break;
                        case 1:
                            int i5 = i3 + 1;
                            svg.down(mutableObjectList.get(i3));
                            i3 = i5;
                            i2 = i4;
                            break;
                        case 2:
                            int i6 = i2 + 2;
                            i2 += 3;
                            svg.remove(mutableIntList.get(i4), mutableIntList.get(i6));
                            break;
                        case 3:
                            int i7 = i2 + 2;
                            try {
                                int i8 = i2 + 3;
                                try {
                                    i2 += 4;
                                    svg.move(mutableIntList.get(i4), mutableIntList.get(i7), mutableIntList.get(i8));
                                } catch (Exception e) {
                                    exc = e;
                                    i2 = i8;
                                    throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i2 - 1, exc);
                                }
                            } catch (Exception e2) {
                                exc = e2;
                                i2 = i7;
                            }
                            break;
                        case 4:
                            svg.clear();
                            i2 = i4;
                            break;
                        case 5:
                            i2 += 2;
                            int i9 = i3 + 1;
                            svg.insertBottomUp(mutableIntList.get(i4), mutableObjectList.get(i3));
                            i3 = i9;
                            break;
                        case 6:
                            i2 += 2;
                            try {
                                mutableIntList.get(i4);
                                int i10 = i3 + 1;
                                i3 = i10;
                            } catch (Exception e3) {
                                exc = e3;
                                throw new ComposePausableCompositionException(mutableObjectList, mutableObjectList2, mutableIntList, i2 - 1, exc);
                            }
                            break;
                        case 7:
                            int i11 = i3 + 1;
                            Object obj = mutableObjectList.get(i3);
                            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj);
                            i3 += 2;
                            svg.apply(mutableObjectList.get(i11), (Function2) obj);
                            i2 = i4;
                            break;
                        case 8:
                            Object obj2 = svg.idToElementMap;
                            if (obj2 instanceof ComposeNodeLifecycleCallback) {
                                ComposeNodeLifecycleCallback composeNodeLifecycleCallback = (ComposeNodeLifecycleCallback) obj2;
                                if (((MutableVector) zzkyVar.zze).remove(composeNodeLifecycleCallback)) {
                                    composeNodeLifecycleCallback.onDeactivate();
                                }
                            }
                            mutableObjectList2.add(obj2);
                            svg.reuse();
                            i2 = i4;
                            break;
                        default:
                            i2 = i4;
                            break;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    i2 = i4;
                }
            } catch (Throwable th) {
                svg.onEndChanges();
                throw th;
            }
        }
        if (i3 != mutableObjectList._size) {
            ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
        }
        mutableObjectList.clear();
        mutableIntList._size = 0;
        svg.onEndChanges();
    }

    public Object process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessor$EmojiProcessCallback emojiProcessor$EmojiProcessCallback) {
        int i4;
        char c;
        EmojiProcessor$ProcessorSm emojiProcessor$ProcessorSm = new EmojiProcessor$ProcessorSm((MetadataRepo$Node) ((Dispatcher) this.cssRules).runningAsyncCalls);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zHandleEmoji = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (true) {
                if (iCharCount < i2 && i5 < i3 && zHandleEmoji) {
                    SparseArray sparseArray = emojiProcessor$ProcessorSm.mCurrentNode.mChildren;
                    MetadataRepo$Node metadataRepo$Node = sparseArray == null ? null : (MetadataRepo$Node) sparseArray.get(iCodePointAt);
                    if (emojiProcessor$ProcessorSm.mState == 2) {
                        if (metadataRepo$Node != null) {
                            emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                            emojiProcessor$ProcessorSm.mCurrentDepth++;
                        } else {
                            if (iCodePointAt == 65038) {
                                emojiProcessor$ProcessorSm.reset();
                            } else if (iCodePointAt != 65039) {
                                MetadataRepo$Node metadataRepo$Node2 = emojiProcessor$ProcessorSm.mCurrentNode;
                                if (metadataRepo$Node2.mData != null) {
                                    if (emojiProcessor$ProcessorSm.mCurrentDepth != 1) {
                                        emojiProcessor$ProcessorSm.mFlushNode = metadataRepo$Node2;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else if (emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        emojiProcessor$ProcessorSm.mFlushNode = emojiProcessor$ProcessorSm.mCurrentNode;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else {
                                        emojiProcessor$ProcessorSm.reset();
                                    }
                                    c = 3;
                                } else {
                                    emojiProcessor$ProcessorSm.reset();
                                }
                            }
                            c = 1;
                        }
                        c = 2;
                    } else if (metadataRepo$Node == null) {
                        emojiProcessor$ProcessorSm.reset();
                        c = 1;
                    } else {
                        emojiProcessor$ProcessorSm.mState = 2;
                        emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                        emojiProcessor$ProcessorSm.mCurrentDepth = 1;
                        c = 2;
                    }
                    emojiProcessor$ProcessorSm.mLastCodepoint = iCodePointAt;
                    if (c == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                        if (iCharCount >= i2) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c == 3) {
                        if (!z && hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData)) {
                            break;
                        }
                        zHandleEmoji = emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData);
                        i5++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (emojiProcessor$ProcessorSm.mState == 2 && emojiProcessor$ProcessorSm.mCurrentNode.mData != null && ((emojiProcessor$ProcessorSm.mCurrentDepth > 1 || emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) && i5 < i3 && zHandleEmoji && (z || !hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData)))) {
            emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData);
        }
        return emojiProcessor$EmojiProcessCallback.getResult();
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        switch (this.$r8$classId) {
            case 7:
                MutableIntList mutableIntList = (MutableIntList) this.rootElement;
                mutableIntList.add(2);
                mutableIntList.add(i);
                mutableIntList.add(i2);
                break;
            default:
                ((LayoutNode) this.idToElementMap).removeAt$ui(i, i2);
                break;
        }
    }

    public SvgElementBase resolveIRI(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        String strReplace = str.replace("\\\n", "").replace("\\A", "\n");
        if (strReplace.length() <= 1 || !strReplace.startsWith("#")) {
            return null;
        }
        String strSubstring = strReplace.substring(1);
        HashMap map = (HashMap) this.idToElementMap;
        if (strSubstring == null || strSubstring.length() == 0) {
            return null;
        }
        if (strSubstring.equals(((Svg) this.rootElement).id)) {
            return (Svg) this.rootElement;
        }
        if (map.containsKey(strSubstring)) {
            return (SvgElementBase) map.get(strSubstring);
        }
        SvgElementBase elementById = getElementById((Svg) this.rootElement, strSubstring);
        map.put(strSubstring, elementById);
        return elementById;
    }

    @Override // androidx.compose.runtime.Applier
    public void reuse() {
        RectManager rectManager;
        AndroidAutofillManager androidAutofillManager;
        RectManager rectManager2;
        switch (this.$r8$classId) {
            case 7:
                ((MutableIntList) this.rootElement).add(8);
                break;
            default:
                LayoutNode layoutNode = (LayoutNode) this.idToElementMap;
                NodeChain nodeChain = layoutNode.nodes;
                if (!layoutNode.isAttached()) {
                    InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
                }
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                if (layoutNodeSubcompositionsState != null) {
                    layoutNodeSubcompositionsState.markActiveNodesAsReused(false);
                }
                layoutNode.isCurrentlyCalculatingSemanticsConfiguration = false;
                if (layoutNode.isDeactivated) {
                    layoutNode.isDeactivated = false;
                } else {
                    Modifier.Node node = (TailModifierNode) nodeChain.tail;
                    for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
                        if (node2.isAttached) {
                            node2.reset$ui();
                        }
                    }
                    for (Modifier.Node node3 = node; node3 != null; node3 = node3.parent) {
                        if (node3.isAttached) {
                            node3.runDetachLifecycle$ui();
                        }
                    }
                    while (node != null) {
                        if (node.isAttached) {
                            node.markAsDetached$ui();
                        }
                        node = node.parent;
                    }
                }
                int i = layoutNode.semanticsId;
                Owner owner = layoutNode.owner;
                if (owner != null && (rectManager2 = ((AndroidComposeView) owner).getRectManager()) != null) {
                    rectManager2.remove(layoutNode);
                }
                layoutNode.semanticsId = SemanticsModifierKt.lastIdentifier.addAndGet(1);
                Owner owner2 = layoutNode.owner;
                if (owner2 != null) {
                    AndroidComposeView androidComposeView = (AndroidComposeView) owner2;
                    androidComposeView.getLayoutNodes().remove(i);
                    androidComposeView.getLayoutNodes().set(layoutNode.semanticsId, layoutNode);
                }
                for (Modifier.Node node4 = (Modifier.Node) nodeChain.head; node4 != null; node4 = node4.child) {
                    node4.markAsAttached$ui();
                }
                nodeChain.runAttachLifecycle();
                if (nodeChain.m563hasH91voCI$ui(8)) {
                    layoutNode.invalidateSemantics$ui();
                }
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode);
                Owner owner3 = layoutNode.owner;
                if (owner3 != null) {
                    AndroidComposeView androidComposeView2 = (AndroidComposeView) owner3;
                    if (AndroidComposeView.autofillSupported() && (androidAutofillManager = androidComposeView2._autofillManager) != null) {
                        AndroidComposeView androidComposeView3 = androidAutofillManager.view;
                        RealDiskCache.RealEditor realEditor = androidAutofillManager.platformAutofillManager;
                        MutableIntSet mutableIntSet = androidAutofillManager.currentlyDisplayedIDs;
                        if (mutableIntSet.remove(i)) {
                            realEditor.notifyViewVisibilityChanged(androidComposeView3, i, false);
                        }
                        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
                        if (semanticsConfiguration != null && semanticsConfiguration.props.contains(SemanticsProperties.ContentType)) {
                            mutableIntSet.add(layoutNode.semanticsId);
                            realEditor.notifyViewVisibilityChanged(androidComposeView3, layoutNode.semanticsId, true);
                        }
                    }
                }
                Owner owner4 = layoutNode.owner;
                if (owner4 != null && (rectManager = ((AndroidComposeView) owner4).getRectManager()) != null) {
                    rectManager.recalculateRectIfDirty(layoutNode);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public boolean m796runActionKlQnJC8(int i) {
        SoftwareKeyboardController softwareKeyboardController;
        if (i == 7 || i == 2 || i == 6 || i == 5 || i == 3 || i == 4) {
            getKeyboardActions();
        } else if (i != 1 && i != 0) {
            throw new IllegalStateException("invalid ImeAction");
        }
        if (i == 6) {
            FocusOwner focusOwner = (FocusOwner) this.idToElementMap;
            if (focusOwner != null) {
                ((FocusOwnerImpl) focusOwner).m345moveFocusaToIllA(1, true);
                return true;
            }
            Intrinsics.throwUninitializedPropertyAccessException("focusManager");
            throw null;
        }
        if (i != 5) {
            if (i != 7 || (softwareKeyboardController = (SoftwareKeyboardController) this.rootElement) == null) {
                return false;
            }
            ((DelegatingSoftwareKeyboardController) softwareKeyboardController).hide();
            return true;
        }
        FocusOwner focusOwner2 = (FocusOwner) this.idToElementMap;
        if (focusOwner2 != null) {
            ((FocusOwnerImpl) focusOwner2).m345moveFocusaToIllA(2, true);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        throw null;
    }

    public void schedule(AutoValue_TransportContext autoValue_TransportContext, int i, boolean z) {
        char c;
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this.idToElementMap;
        Context context = (Context) this.rootElement;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = autoValue_TransportContext.backendName;
        String str2 = autoValue_TransportContext.backendName;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        Priority priority = autoValue_TransportContext.priority;
        adler32.update(byteBufferAllocate.putInt(PriorityMapping.toInt(priority)).array());
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i2 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i2 < i) {
                        break;
                    }
                    zzle.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", autoValue_TransportContext);
                    return;
                }
            }
        }
        Cursor cursorRawQuery = ((SQLiteEventStore) ((EventStore) this.cssRules)).getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(PriorityMapping.toInt(priority))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Set set = ((AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority)).flags;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", PriorityMapping.toInt(priority));
            if (bArr != null) {
                c = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Integer numValueOf2 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c] = autoValue_TransportContext;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void setCanvas(Canvas canvas) {
        ((CanvasDrawScope) this.idToElementMap).drawParams.canvas = canvas;
    }

    public void setDensity(Density density) {
        ((CanvasDrawScope) this.idToElementMap).drawParams.density = density;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        ((CanvasDrawScope) this.idToElementMap).drawParams.layoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public void m797setSizeuvyYCjk(long j) {
        ((CanvasDrawScope) this.idToElementMap).drawParams.size = j;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 13:
                return ((HeadersReader) this.cssRules).toString() + ", hidden list:" + ((ArrayList) this.idToElementMap).size();
            default:
                return super.toString();
        }
    }

    public void unhideViewInternal(android.view.View view) {
        if (((ArrayList) this.idToElementMap).remove(view)) {
            RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.rootElement;
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                RecyclerView recyclerView = RecyclerView.this;
                int i = childViewHolderInt.mWasImportantForAccessibilityBeforeHidden;
                if (recyclerView.isComputingLayout()) {
                    childViewHolderInt.mPendingAccessibilityState = i;
                    recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
                } else {
                    android.view.View view2 = childViewHolderInt.itemView;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view2.setImportantForAccessibility(i);
                }
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
            }
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        switch (this.$r8$classId) {
            case 7:
                ((MutableIntList) this.rootElement).add(0);
                break;
            default:
                this.idToElementMap = Stack.m292popimpl((ArrayList) this.cssRules);
                break;
        }
    }

    public /* synthetic */ SVG(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.rootElement = obj;
        this.cssRules = obj2;
        this.idToElementMap = obj3;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Box {
        public final /* synthetic */ int $r8$classId;
        public float height;
        public float minX;
        public float minY;
        public float width;

        public Box(float f, float f2) {
            this.$r8$classId = 1;
            this.minY = f;
            this.width = f2;
        }

        public float getLinearZoom() {
            return this.height;
        }

        public float getMaxZoomRatio() {
            return this.minY;
        }

        public float getMinZoomRatio() {
            return this.width;
        }

        public float getZoomRatio() {
            return this.minX;
        }

        public void intersect(float f, float f2, float f3, float f4) {
            this.minX = Math.max(f, this.minX);
            this.minY = Math.max(f2, this.minY);
            this.width = Math.min(f3, this.width);
            this.height = Math.min(f4, this.height);
        }

        public boolean isEmpty() {
            return (this.minX >= this.width) | (this.minY >= this.height);
        }

        public float maxX() {
            return this.minX + this.width;
        }

        public float maxY() {
            return this.minY + this.height;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0015  */
        public void setZoomRatio() {
            float f = this.width;
            float f2 = this.minY;
            float f3 = 1.0f;
            if (1.0f > f2 || 1.0f < f) {
                throw new IllegalArgumentException("Requested zoomRatio 1.0 is not within valid range [" + f + " , " + f2 + "]");
            }
            this.minX = 1.0f;
            if (f2 == f) {
                f3 = 0.0f;
            } else if (1.0f != f2) {
                if (1.0f == f) {
                    f3 = 0.0f;
                } else {
                    float f4 = 1.0f / f;
                    f3 = (1.0f - f4) / ((1.0f / f2) - f4);
                }
            }
            this.height = f3;
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
                case 1:
                default:
                    return super.toString();
                case 2:
                    return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.minX) + ", " + GeometryUtilsKt.toStringAsFixed(this.minY) + ", " + GeometryUtilsKt.toStringAsFixed(this.width) + ", " + GeometryUtilsKt.toStringAsFixed(this.height) + ')';
            }
        }

        /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
        public void m798translatek4lQ0M(long j) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
            this.minX += fIntBitsToFloat;
            this.minY += fIntBitsToFloat2;
            this.width += fIntBitsToFloat;
            this.height += fIntBitsToFloat2;
        }

        public Box() {
            this.$r8$classId = 2;
            this.minX = 0.0f;
            this.minY = 0.0f;
            this.width = 0.0f;
            this.height = 0.0f;
        }

        public Box(float f, float f2, float f3, float f4) {
            this.$r8$classId = 0;
            this.minX = f;
            this.minY = f2;
            this.width = f3;
            this.height = f4;
        }

        public Box(Box box) {
            this.$r8$classId = 0;
            this.minX = box.minX;
            this.minY = box.minY;
            this.width = box.width;
            this.height = box.height;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Length implements Cloneable {
        public final int unit;
        public final float value;

        public Length(int i, float f) {
            this.value = f;
            this.unit = i;
        }

        public final float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            float fSqrt;
            if (this.unit != 9) {
                return floatValueX(sVGAndroidRenderer);
            }
            SVGAndroidRenderer.RendererState rendererState = (SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state;
            Box box = rendererState.viewBox;
            if (box == null) {
                box = rendererState.viewPort;
            }
            float f = this.value;
            if (box == null) {
                return f;
            }
            float f2 = box.width;
            float f3 = box.height;
            if (f2 == f3) {
                fSqrt = f * f2;
            } else {
                fSqrt = f * ((float) (Math.sqrt((f3 * f3) + (f2 * f2)) / 1.414213562373095d));
            }
            return fSqrt / 100.0f;
        }

        public final float floatValue$1() {
            float f;
            float f2;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.unit);
            float f3 = this.value;
            if (iOrdinal == 0) {
                return f3;
            }
            if (iOrdinal == 3) {
                return f3 * 96.0f;
            }
            if (iOrdinal == 4) {
                f = f3 * 96.0f;
                f2 = 2.54f;
            } else if (iOrdinal == 5) {
                f = f3 * 96.0f;
                f2 = 25.4f;
            } else if (iOrdinal == 6) {
                f = f3 * 96.0f;
                f2 = 72.0f;
            } else {
                if (iOrdinal != 7) {
                    return f3;
                }
                f = f3 * 96.0f;
                f2 = 6.0f;
            }
            return f / f2;
        }

        public final float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            float textSize;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.unit);
            float f = this.value;
            switch (iOrdinal) {
                case 1:
                    textSize = ((SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state).fillPaint.getTextSize();
                    break;
                case 2:
                    textSize = ((SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state).fillPaint.getTextSize() / 2.0f;
                    break;
                case 3:
                    sVGAndroidRenderer.getClass();
                    return f * 96.0f;
                case 4:
                    sVGAndroidRenderer.getClass();
                    return (f * 96.0f) / 2.54f;
                case 5:
                    sVGAndroidRenderer.getClass();
                    return (f * 96.0f) / 25.4f;
                case 6:
                    sVGAndroidRenderer.getClass();
                    return (f * 96.0f) / 72.0f;
                case 7:
                    sVGAndroidRenderer.getClass();
                    return (f * 96.0f) / 6.0f;
                case 8:
                    SVGAndroidRenderer.RendererState rendererState = (SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state;
                    Box box = rendererState.viewBox;
                    if (box == null) {
                        box = rendererState.viewPort;
                    }
                    if (box != null) {
                        return (f * box.width) / 100.0f;
                    }
                default:
                    return f;
            }
            return textSize * f;
        }

        public final float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit != 9) {
                return floatValueX(sVGAndroidRenderer);
            }
            SVGAndroidRenderer.RendererState rendererState = (SVGAndroidRenderer.RendererState) sVGAndroidRenderer.state;
            Box box = rendererState.viewBox;
            if (box == null) {
                box = rendererState.viewPort;
            }
            float f = this.value;
            return box == null ? f : (f * box.height) / 100.0f;
        }

        public final boolean isNegative() {
            return this.value < 0.0f;
        }

        public final boolean isZero() {
            return this.value == 0.0f;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.value));
            switch (this.unit) {
                case 1:
                    str = "px";
                    break;
                case 2:
                    str = "em";
                    break;
                case 3:
                    str = "ex";
                    break;
                case 4:
                    str = "in";
                    break;
                case 5:
                    str = "cm";
                    break;
                case 6:
                    str = "mm";
                    break;
                case 7:
                    str = "pt";
                    break;
                case 8:
                    str = "pc";
                    break;
                case 9:
                    str = "percent";
                    break;
                default:
                    str = "null";
                    break;
            }
            sb.append(str);
            return sb.toString();
        }

        public Length(float f) {
            this.value = f;
            this.unit = 1;
        }

        public final float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f) {
            if (this.unit == 9) {
                return (this.value * f) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }
    }

    public SVG(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.rootElement = workDatabase_Impl;
        new WorkTagDao_Impl$1(workDatabase_Impl, 5);
        this.cssRules = new WorkTagDao_Impl$2(workDatabase_Impl, 3);
        this.idToElementMap = new WorkTagDao_Impl$2(workDatabase_Impl, 4);
    }

    public SVG(SoftwareKeyboardController softwareKeyboardController) {
        this.$r8$classId = 6;
        this.rootElement = softwareKeyboardController;
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public SVG(StreamConfigurationMap streamConfigurationMap, RequestService requestService) {
        this.$r8$classId = 3;
        this.idToElementMap = new HashMap();
        new HashMap();
        new HashMap();
        this.rootElement = new PreviewView.AnonymousClass1(10, streamConfigurationMap);
        this.cssRules = requestService;
    }

    public SVG(ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        this.$r8$classId = 4;
        this.cssRules = new Object();
        this.rootElement = new ArrayDeque(3);
        this.idToElementMap = zslControlImpl$$ExternalSyntheticLambda0;
    }

    public SVG(RecyclerView.AnonymousClass5 anonymousClass5) {
        this.$r8$classId = 13;
        this.rootElement = anonymousClass5;
        this.cssRules = new HeadersReader(2);
        this.idToElementMap = new ArrayList();
    }

    public SVG(CanvasDrawScope canvasDrawScope) {
        this.$r8$classId = 8;
        this.idToElementMap = canvasDrawScope;
        this.rootElement = new RealDiskCache.RealEditor(6, this);
    }

    private final /* synthetic */ void onEndChanges$androidx$compose$runtime$RecordingApplier() {
    }

    public SVG(Runnable runnable) {
        this.$r8$classId = 11;
        this.cssRules = new CopyOnWriteArrayList();
        this.idToElementMap = new HashMap();
        this.rootElement = runnable;
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class SolidColor extends SvgElementBase implements SvgContainer {
        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final List getChildren() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "solidColor";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final void addChild(SvgObject svgObject) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public final class Stop extends SvgElementBase implements SvgContainer {
        public Float offset;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final List getChildren() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public final String getNodeName() {
            return "stop";
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final void addChild(SvgObject svgObject) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
    public abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        public List children = new ArrayList();
        public HashSet requiredFeatures = null;
        public String requiredExtensions = null;
        public HashSet requiredFormats = null;
        public HashSet requiredFonts = null;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
            this.children.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public final List getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final Set getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFeatures(HashSet hashSet) {
            this.requiredFeatures = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFonts(HashSet hashSet) {
            this.requiredFonts = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setRequiredFormats(HashSet hashSet) {
            this.requiredFormats = hashSet;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public final void setSystemLanguage(HashSet hashSet) {
        }
    }

    public SVG(Context context, LocationManager locationManager) {
        this.$r8$classId = 2;
        this.idToElementMap = new TwilightManager$TwilightState();
        this.rootElement = context;
        this.cssRules = locationManager;
    }

    public SVG(Context context) {
        this.$r8$classId = 18;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(PredictiveBackHandlerKt.resolveOrThrow(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
        RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        this.idToElementMap = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateList = ShortcutManagerCompat.getColorStateList(context, typedArrayObtainStyledAttributes, 6);
        this.rootElement = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(7, 0));
        this.cssRules = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        new Paint().setColor(colorStateList.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }

    public SVG(Dispatcher dispatcher, AsyncTimeout.Companion companion, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.$r8$classId = 12;
        this.rootElement = companion;
        this.cssRules = dispatcher;
        this.idToElementMap = defaultGlyphChecker;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new kotlinx.coroutines.internal.Symbol(str, 2));
        }
    }

    public SVG(TypefaceResult$Immutable typefaceResult$Immutable, SVG svg) {
        this.$r8$classId = 10;
        this.rootElement = typefaceResult$Immutable;
        this.cssRules = svg;
        this.idToElementMap = typefaceResult$Immutable.value;
    }

    public SVG(LayoutNode layoutNode) {
        this.$r8$classId = 9;
        this.rootElement = layoutNode;
        this.cssRules = new ArrayList();
        this.idToElementMap = layoutNode;
    }

    public SVG(Object obj) {
        this.$r8$classId = 7;
        this.rootElement = new MutableIntList();
        this.cssRules = new MutableObjectList();
        this.idToElementMap = obj;
    }
}
