package com.lightsoft.parceler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import org.parceler.Parcels;

public class EmployeeDetailsActivity extends Activity {

    public static final String ARG_EMPLOYEE = "employee";

    public static final int EDIT_REQ_CODE = 101;

    private Employee employee;

    private TextView textName;

    private TextView textLastName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_EMPLOYEE))
            employee = Parcels.unwrap(savedInstanceState.getParcelable(ARG_EMPLOYEE));
        else
            employee = new Employee("John", "Doe");

        textName = findViewById(R.id.textName);
        textLastName = findViewById(R.id.textLastName);

        initializeViews();
    }

    private void initializeViews() {
        textName.setText(employee.getName());
        textLastName.setText(employee.getLastName());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Bundle bundle = outState != null ? outState : new Bundle();
        bundle.putParcelable(ARG_EMPLOYEE, Parcels.wrap(employee));
        super.onSaveInstanceState(bundle);
    }

    public void onEditClicked(View view) {
        Intent intent = new Intent(this, EditEmployeeActivity.class);
        intent.putExtra(ARG_EMPLOYEE, Parcels.wrap(employee));
        startActivityForResult(intent, EDIT_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_REQ_CODE && resultCode == RESULT_OK && data != null) {
            employee = Parcels.unwrap(data.getParcelableExtra(ARG_EMPLOYEE));
            initializeViews();
        }
    }
}
