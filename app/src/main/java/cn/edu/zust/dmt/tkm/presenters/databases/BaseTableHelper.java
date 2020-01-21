package cn.edu.zust.dmt.tkm.presenters.databases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.databases
 * @description $
 * @time 1/6/2020 20:05
 * copyright(c) all rights reserved by MR.M
 **/
public abstract class BaseTableHelper {

    private final String TABLE_NAME;
    private final String[] TABLE_COLUMNS;
    private final BaseDatabaseHelper DATABASE_HELPER;

    public BaseTableHelper() {
        this.TABLE_NAME = getTableName();
        this.TABLE_COLUMNS = getTableColumnName();
        this.DATABASE_HELPER = getParentDatabaseHelper();
    }

    /**
     * @description insert model T as new line
     */
    public synchronized <T> void insert(T bean) {
        try (SQLiteDatabase db = getParentDatabaseHelper().getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            contentValues = getContentValue(contentValues, bean);
            if (contentValues != null) {
                db.insert(TABLE_NAME, null, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @description clear all table data
     */
    public synchronized void clearAll() {
        try (SQLiteDatabase db = DATABASE_HELPER.getWritableDatabase()) {
            String sql = "delete from " + TABLE_NAME;
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized <T> List<T> query() {
        SQLiteDatabase db = DATABASE_HELPER.getReadableDatabase();
        List<T> list = new ArrayList<>();
        String querySql = "select * from " + TABLE_NAME;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(querySql, null);
            while (cursor.moveToNext()) {
                Object myLineModel = getModelFromTableLine(cursor);
                list.add((T) myLineModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return list;
    }

    protected abstract String getTableName();

    protected abstract String[] getTableColumnName();

    protected abstract BaseDatabaseHelper getParentDatabaseHelper();

    /**
     * @description turn model to contentValues
     */
    protected abstract ContentValues getContentValue(ContentValues contentValues, Object bean);

    /**
     * @description get model from cursor
     */
    protected abstract Object getModelFromTableLine(Cursor cursor);

    public abstract String getCreateSQL();
}
