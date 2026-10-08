package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BatteryNotLowTracker(Context context, WorkManagerTaskExecutor workManagerTaskExecutor, int i) {
        super(context, workManagerTaskExecutor);
        this.$r8$classId = i;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getIntentFilter() {
        switch (this.$r8$classId) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.os.action.CHARGING");
                intentFilter2.addAction("android.os.action.DISCHARGING");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void onBroadcastReceive(Intent intent) {
        switch (this.$r8$classId) {
            case 0:
                if (intent.getAction() != null) {
                    Logger$LogcatLogger.get().debug(BatteryNotLowTrackerKt.TAG, "Received " + intent.getAction());
                    String action = intent.getAction();
                    if (action != null) {
                        int iHashCode = action.hashCode();
                        if (iHashCode != -1980154005) {
                            if (iHashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                                setState(Boolean.FALSE);
                            }
                            break;
                        } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
                            setState(Boolean.TRUE);
                            break;
                        }
                    }
                }
                break;
            case 1:
                String action2 = intent.getAction();
                if (action2 != null) {
                    Logger$LogcatLogger.get().debug(BatteryChargingTrackerKt.TAG, "Received ".concat(action2));
                    switch (action2.hashCode()) {
                        case -1886648615:
                            if (action2.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                setState(Boolean.FALSE);
                                break;
                            }
                            break;
                        case -54942926:
                            if (action2.equals("android.os.action.DISCHARGING")) {
                                setState(Boolean.FALSE);
                                break;
                            }
                            break;
                        case 948344062:
                            if (action2.equals("android.os.action.CHARGING")) {
                                setState(Boolean.TRUE);
                                break;
                            }
                            break;
                        case 1019184907:
                            if (action2.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                setState(Boolean.TRUE);
                                break;
                            }
                            break;
                    }
                }
                break;
            default:
                if (intent.getAction() != null) {
                    Logger$LogcatLogger.get().debug(StorageNotLowTrackerKt.TAG, "Received " + intent.getAction());
                    String action3 = intent.getAction();
                    if (action3 != null) {
                        int iHashCode2 = action3.hashCode();
                        if (iHashCode2 != -1181163412) {
                            if (iHashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                                setState(Boolean.TRUE);
                            }
                            break;
                        } else if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                            setState(Boolean.FALSE);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final Object readSystemState() {
        switch (this.$r8$classId) {
            case 0:
                Intent intentRegisterReceiver = ((Context) this.route).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    Logger$LogcatLogger.get().error(BatteryNotLowTrackerKt.TAG, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                float intExtra2 = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
                boolean z = true;
                if (intExtra != 1 && intExtra2 <= 0.15f) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                Intent intentRegisterReceiver2 = ((Context) this.route).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver2 == null) {
                    Logger$LogcatLogger.get().error(BatteryChargingTrackerKt.TAG, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra3 = intentRegisterReceiver2.getIntExtra("status", -1);
                return Boolean.valueOf(intExtra3 == 2 || intExtra3 == 5);
            default:
                Intent intentRegisterReceiver3 = ((Context) this.route).registerReceiver(null, getIntentFilter());
                boolean z2 = true;
                if (intentRegisterReceiver3 != null && intentRegisterReceiver3.getAction() != null) {
                    String action = intentRegisterReceiver3.getAction();
                    if (action == null) {
                        z2 = false;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1181163412) {
                            action.equals("android.intent.action.DEVICE_STORAGE_LOW");
                        } else if (iHashCode != -730838620 || !action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        }
                        z2 = false;
                    }
                }
                return Boolean.valueOf(z2);
        }
    }
}
