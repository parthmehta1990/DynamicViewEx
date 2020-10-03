package com.sample.testapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sample.testapp.viewmodel.FieldViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fieldViewModel: FieldViewModel

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity

        fieldViewModel = ViewModelProvider(this).get(FieldViewModel::class.java)

        fieldViewModel.getDetails(context)!!.observe(this, Observer {

            if (it.isEmpty()) {
                //no data
                fieldViewModel.insertData(context, "investment", 1)
                fieldViewModel.insertData(context, "fixed", 0)
                fieldViewModel.insertData(context, "dop", 1)
                fieldViewModel.insertData(context, "units", 0)
                fieldViewModel.insertData(context, "price", 1)

               

            }else {

                showFields()


            }
        })


    }

    fun showFields(){
        //show and hide the field
        fieldViewModel.getFieldsDetails(context, "investment")!!.observe(this, Observer {

            if (it.Active == 0) {
                editTextTextPersonName.visibility = View.GONE
            } else {
                editTextTextPersonName.visibility = View.VISIBLE
            }
        })

        fieldViewModel.getFieldsDetails(context, "fixed")!!.observe(this, Observer {
            switch1.isChecked = it.Active != 0
        })

        fieldViewModel.getFieldsDetails(context, "dop")!!.observe(this, Observer {
            if (it.Active == 0) {
                editTextTextPersonName2.visibility = View.GONE
            } else {
                editTextTextPersonName2.visibility = View.VISIBLE
            }
        })

        fieldViewModel.getFieldsDetails(context, "units")!!.observe(this, Observer {
            if (it.Active == 0) {
                editTextTextPersonName3.visibility = View.GONE
            } else {
                editTextTextPersonName3.visibility = View.VISIBLE
            }
        })

        fieldViewModel.getFieldsDetails(context, "price")!!.observe(this, Observer {
            if (it.Active == 0) {
                editTextTextPersonName4.visibility = View.GONE
            } else {
                editTextTextPersonName4.visibility = View.VISIBLE
            }
        })
    }
}