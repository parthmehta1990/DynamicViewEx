package com.sample.testapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sample.testapp.model.FieldTableModel
import com.sample.testapp.repository.FieldRepository

class FieldViewModel  : ViewModel() {

    var liveDataLogin: LiveData<FieldTableModel>? = null

    var listliveDataLogin: LiveData<List<FieldTableModel>>? = null

    fun insertData(context: Context, fieldName: String, isActive: Int) {
        FieldRepository.insertData(context, fieldName, isActive)
    }

    fun getDetails(context: Context) : LiveData<List<FieldTableModel>>? {
        listliveDataLogin = FieldRepository.getDetails(context)
        return listliveDataLogin
    }

    fun getFieldsDetails(context: Context,fieldName:String) : LiveData<FieldTableModel>? {
        liveDataLogin = FieldRepository.getFieldDetails(context,fieldName)
        return liveDataLogin
    }
}