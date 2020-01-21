package cn.edu.zust.dmt.tkm.presenters.databases.user;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.edu.zust.dmt.tkm.presenters.databases.BaseDatabaseHelper;
import cn.edu.zust.dmt.tkm.presenters.databases.BaseTableHelper;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.databases
 * @description $
 * @time 1/6/2020 19:12
 * copyright(c) all rights reserved by MR.M
 **/
public class MyUserDatabaseHelper extends BaseDatabaseHelper {

    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;

    private static volatile MyUserDatabaseHelper INSTANCE;

    private static List<BaseTableHelper> mTableHelperList;

    private static ReentrantReadWriteLock LIST_LOCK = new ReentrantReadWriteLock();

    private MyUserDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mTableHelperList = new ArrayList<>();
        MyAccountTableHelper myAccountTableHelper = MyAccountTableHelper.getInstance(this);
        addTableHelperList(myAccountTableHelper);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (BaseTableHelper baseTableHelper :
                mTableHelperList) {
            db.execSQL(baseTableHelper.getCreateSQL());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static synchronized MyUserDatabaseHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MyUserDatabaseHelper(context);
        }
        return INSTANCE;
    }

    private static synchronized void addTableHelperList(BaseTableHelper baseTableHelper) {
        LIST_LOCK.writeLock().lock();
        mTableHelperList.add(baseTableHelper);
        LIST_LOCK.writeLock().unlock();
    }

    public static List<BaseTableHelper> getTableHelperList() {
        LIST_LOCK.readLock().lock();
        List<BaseTableHelper> baseTableHelperList = mTableHelperList;
        LIST_LOCK.readLock().unlock();
        return baseTableHelperList;
    }
}