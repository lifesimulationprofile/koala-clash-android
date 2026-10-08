package com.github.kr328.clash.service.data.migrations;

import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* JADX INFO: compiled from: r8-map-id-642a9409e8c86705d83235ec931e7b4e3b870bec9858ab19ec33568b7f2d7797 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MigrationsKt {
    public static final MigrationsKt$LEGACY_MIGRATION$1 LEGACY_MIGRATION = MigrationsKt$LEGACY_MIGRATION$1.INSTANCE;
    public static final Migration[] MIGRATIONS;

    static {
        final int i = 1;
        final int i2 = 2;
        final int i3 = 0;
        final int i4 = 3;
        final int i5 = 4;
        MIGRATIONS = new Migration[]{new Migration(i, i2) { // from class: com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                switch (i3) {
                    case 0:
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `pending`");
                        break;
                    case 1:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `updatedAt` INTEGER NOT NULL DEFAULT 0");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `announce` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `supportURL` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `profileImage` BLOB");
                        frameworkSQLiteDatabase.execSQL("UPDATE `imported` SET `updatedAt` = `createdAt` WHERE `updatedAt` = 0");
                        break;
                    default:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `modeSwitchAllowed` INTEGER NOT NULL DEFAULT 1");
                        break;
                }
            }
        }, new Migration(i2, i4) { // from class: com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                switch (i) {
                    case 0:
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `pending`");
                        break;
                    case 1:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `updatedAt` INTEGER NOT NULL DEFAULT 0");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `announce` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `supportURL` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `profileImage` BLOB");
                        frameworkSQLiteDatabase.execSQL("UPDATE `imported` SET `updatedAt` = `createdAt` WHERE `updatedAt` = 0");
                        break;
                    default:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `modeSwitchAllowed` INTEGER NOT NULL DEFAULT 1");
                        break;
                }
            }
        }, new Migration(i4, i5) { // from class: com.github.kr328.clash.service.data.migrations.MigrationsKt$MIGRATION_1_2$1
            @Override // androidx.room.migration.Migration
            public final void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
                switch (i2) {
                    case 0:
                        frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `pending`");
                        break;
                    case 1:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `updatedAt` INTEGER NOT NULL DEFAULT 0");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `announce` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `supportURL` TEXT");
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `profileImage` BLOB");
                        frameworkSQLiteDatabase.execSQL("UPDATE `imported` SET `updatedAt` = `createdAt` WHERE `updatedAt` = 0");
                        break;
                    default:
                        frameworkSQLiteDatabase.execSQL("ALTER TABLE `imported` ADD COLUMN `modeSwitchAllowed` INTEGER NOT NULL DEFAULT 1");
                        break;
                }
            }
        }};
    }
}
