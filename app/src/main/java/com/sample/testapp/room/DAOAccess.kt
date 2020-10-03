package com.sample.testapp.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.testapp.model.FieldTableModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(fieldTableModel: FieldTableModel)

    @Query("SELECT * FROM Field ")
    fun getDetails() : LiveData<List<FieldTableModel>>

    @Query("SELECT * FROM Field WHERE fieldname =:fname")
    fun getFieldDetails(fname: String?) : LiveData<FieldTableModel>
}