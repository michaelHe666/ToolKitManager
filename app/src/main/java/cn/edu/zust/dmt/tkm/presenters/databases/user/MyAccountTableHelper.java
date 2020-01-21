package cn.edu.zust.dmt.tkm.presenters.databases.user;

import android.content.ContentValues;
import android.database.Cursor;

import cn.edu.zust.dmt.tkm.presenters.databases.BaseDatabaseHelper;
import cn.edu.zust.dmt.tkm.presenters.databases.BaseTableHelper;
import cn.edu.zust.dmt.tkm.models.MyAccountModel;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.databases
 * @description $
 * @time 1/6/2020 19:28
 * copyright(c) all rights reserved by MR.M
 **/
public class MyAccountTableHelper extends BaseTableHelper {

    private static MyAccountTableHelper INSTANCE;

    private static final String[] COLUMN_ARRAY = {
            "phoneNumber", "username", "password", "status", "permission"};

    private static final String TABLE_NAME = "user_account";

    private final BaseDatabaseHelper myDatabase;

    private static final String SQL_CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            COLUMN_ARRAY[0] + " char(11) primary key," +
            COLUMN_ARRAY[1] + " varchar(20)," +
            COLUMN_ARRAY[2] + " varchar(20)," +
            COLUMN_ARRAY[3] + " integer," +
            COLUMN_ARRAY[4] + " integer" +
            ")";


    private MyAccountTableHelper(BaseDatabaseHelper baseDatabaseHelper) {
        myDatabase = baseDatabaseHelper;
    }

    public static MyAccountTableHelper getInstance(BaseDatabaseHelper baseDatabaseHelper) {
        if (INSTANCE == null) {
            INSTANCE = new MyAccountTableHelper(baseDatabaseHelper);
        }
        return INSTANCE;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected BaseDatabaseHelper getParentDatabaseHelper() {
        return myDatabase;
    }

    @Override
    public String getCreateSQL() {
        return SQL_CREATE_TABLE;
    }

    @Override
    protected String[] getTableColumnName() {
        return COLUMN_ARRAY;
    }

    @Override
    protected ContentValues getContentValue(ContentValues contentValues, Object bean) {
        if (bean instanceof MyAccountModel) {
            MyAccountModel myAccountModel = (MyAccountModel) bean;
            contentValues.put(COLUMN_ARRAY[0], myAccountModel.getPhoneNumber());
            contentValues.put(COLUMN_ARRAY[1], myAccountModel.getUsername());
            contentValues.put(COLUMN_ARRAY[2], myAccountModel.getPassword());
            contentValues.put(COLUMN_ARRAY[3], myAccountModel.getStatus());
            contentValues.put(COLUMN_ARRAY[4], myAccountModel.getPermission());
            return contentValues;
        }
        return null;
    }

    @Override
    protected Object getModelFromTableLine(Cursor cursor) {
        return new MyAccountModel(
                cursor.getString(cursor.getColumnIndex(COLUMN_ARRAY[0])),
                cursor.getString(cursor.getColumnIndex(COLUMN_ARRAY[1])),
                cursor.getString(cursor.getColumnIndex(COLUMN_ARRAY[2])),
                cursor.getInt(cursor.getColumnIndex(COLUMN_ARRAY[3])),
                cursor.getInt(cursor.getColumnIndex(COLUMN_ARRAY[4]))
        );
    }
}
