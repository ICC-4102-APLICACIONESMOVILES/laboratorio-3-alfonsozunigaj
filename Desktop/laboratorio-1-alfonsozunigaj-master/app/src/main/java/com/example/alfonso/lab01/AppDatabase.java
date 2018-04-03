package com.example.alfonso.lab01;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Alfonso on 02-04-2018.
 */

@Database(entities = {Form.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FormDao formDao();
}
