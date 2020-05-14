package com.example.assigntest.database;

import android.content.Context;

import com.example.assigntest.database.Dao.StudentsDao;
import com.example.assigntest.database.model.Student;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


    @Database(entities = {Student.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        private static AppDatabase mInstance;

        //method to get room database
        public static AppDatabase getDatabase(Context context) {

            if (mInstance == null)
                mInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "Student")
                        .fallbackToDestructiveMigration()
                        .build();

            return mInstance;
        }

        //method to remove instance
        public static void closeDatabase() {
            mInstance = null;
        }

        public abstract StudentsDao studentsDao();
    }

