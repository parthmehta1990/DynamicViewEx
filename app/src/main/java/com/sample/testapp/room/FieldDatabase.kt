package com.sample.testapp.room

import android.content.Context
import androidx.room.*
import com.sample.testapp.model.FieldTableModel

@Database(entities = arrayOf(FieldTableModel::class), version = 1, exportSchema = false)
abstract class FieldDatabase : RoomDatabase() {

    abstract fun loginDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: FieldDatabase? = null

        fun getDataseClient(context: Context) : FieldDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, FieldDatabase::class.java, "FIELD_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}