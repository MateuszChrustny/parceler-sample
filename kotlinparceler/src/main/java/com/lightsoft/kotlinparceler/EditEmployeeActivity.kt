package com.lightsoft.kotlinparceler

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_edit_employee.*
import org.parceler.Parcels

class EditEmployeeActivity : Activity() {

    private var employee: Employee? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_employee)
        employee = Parcels.unwrap(intent?.getParcelableExtra(ARG_EMPLOYEE)) ?: Employee()
        initializeViews()
    }

    private fun initializeViews() {
        editName.setText(employee?.name)
        editLastName.setText(employee?.lastName)
    }

    fun onSaveClicked(view: View) {

        employee?.name = editName.text.toString()
        employee?.lastName = editLastName.text.toString()

        val resultIntent = Intent()
        resultIntent.putExtra(ARG_EMPLOYEE, Parcels.wrap(employee))

        setResult(RESULT_OK, resultIntent)
        finish()
    }
}

