package com.sample.testapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.sample.testapp.model.FieldTableModel
import com.sample.testapp.room.FieldDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class FieldRepository {

    companion object {

        var loginDatabase: FieldDatabase? = null

        var loginTableModel: LiveData<FieldTableModel>? = null

        var listTableModel: LiveData<List<FieldTableModel>>? = null

        fun initializeDB(context: Context) : FieldDatabase {
            return FieldDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, fieldname: String, isActive: Int) {

            loginDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val loginDetails = FieldTableModel(fieldname, isActive)
                loginDatabase!!.loginDao().InsertData(loginDetails)
            }

        }

        fun getDetails(context: Context) : LiveData<List<FieldTableModel>>? {

            loginDatabase = initializeDB(context)

            listTableModel = loginDatabase!!.loginDao().getDetails()

            return listTableModel
        }

        fun getFieldDetails(context: Context,fieldName:String) : LiveData<FieldTableModel>? {

            loginDatabase = initializeDB(context)

            loginTableModel = loginDatabase!!.loginDao().getFieldDetails(fieldName)

            return loginTableModel
        }

    }
}