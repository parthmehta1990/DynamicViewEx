package com.sample.testapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Field")
data class FieldTableModel (

    @ColumnInfo(name = "fieldname")
    var fieldname: String,

    @ColumnInfo(name = "isActive")
    var Active: Integer

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}