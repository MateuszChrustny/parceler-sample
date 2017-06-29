package com.lightsoft.kotlinparceler

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.lightsoft.kotlinparceler.model.Employee
import kotlinx.android.synthetic.main.activity_employee_details.*
import org.parceler.Parcels

class EmployeeDetailsActivity : android.app.Activity() {

    private var employee: Employee? = null


    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)
        employee = Parcels.unwrap(savedInstanceState?.getParcelable(ARG_EMPLOYEE)) ?: Employee("John", "Doe", null)
        initializeViews()
    }

    private fun initializeViews() {
        textName.text = employee?.name
        textLastName.text = employee?.lastName
    }


    override fun onSaveInstanceState(outState: android.os.Bundle?) {
        val bundle = outState ?: Bundle()
        bundle.putParcelable(ARG_EMPLOYEE, Parcels.wrap(employee))
        super.onSaveInstanceState(bundle)
    }

    fun onEditClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        val intent = Intent(this, EditEmployeeActivity::class.java)
        intent.putExtra(ARG_EMPLOYEE, Parcels.wrap(employee))
        startActivityForResult(intent, EDIT_REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_REQ_CODE && resultCode == RESULT_OK) {
            employee = Parcels.unwrap(data?.getParcelableExtra(ARG_EMPLOYEE))
            initializeViews()
        }
    }
}