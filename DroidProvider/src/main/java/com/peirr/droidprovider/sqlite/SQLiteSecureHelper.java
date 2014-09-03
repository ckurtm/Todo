/*
 * Copyright (c) 2012 Kurt Mbanje
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   ckurtm at gmail dot com
 *   https://github.com/ckurtm/DroidProvider
 */
package com.peirr.droidprovider.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.peirr.droidprovider.sqlite.annotations.ProviderUtil;

import javax.crypto.SecretKey;


/**
 * encryption options for R/W to sqlite DB
 *
 * @author kurt
 */
public abstract class SQLiteSecureHelper extends SQLiteOpenHelper {
    public static final String ID = "_id";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "base";
    protected SecretKey sk;
    protected Context ctx;
    protected ProviderUtil proc;
    protected SQLiteDatabase db;
    String tag = SQLiteSecureHelper.class.getSimpleName();


    public SQLiteSecureHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        ctx = context;
        proc = new ProviderUtil(sk);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(tag, "onCreate()");
        this.db = db;
        proc = new ProviderUtil(db, sk);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(tag, "onUpgrade [old:" + oldVersion + "][new:" + newVersion + "]");
    }


    public SQLiteDatabase getDb() {
        return db;
    }
}
