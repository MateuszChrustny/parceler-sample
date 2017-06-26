package com.lightsoft.parceler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import static com.lightsoft.parceler.EmployeeDetailsActivity.ARG_EMPLOYEE;

public class EditEmployeeActivity extends Activity {

    private Employee employee;

    private EditText editName;

    private EditText editLastName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        editName = findViewById(R.id.editName);
        editLastName = findViewById(R.id.editLastName);

        if (getIntent() != null && getIntent().hasExtra(ARG_EMPLOYEE)) {
            employee = getIntent().getParcelableExtra(ARG_EMPLOYEE);
        }

        initializeViews();
    }

    private void initializeViews() {
        editName.setText(employee.getName());
        editLastName.setText(employee.getLastName());
    }

    public void onSaveClicked(View view) {
        employee.setName(editName.getText().toString());
        employee.setLastName(editLastName.getText().toString());

        Intent resultIntent = new Intent();
        resultIntent.putExtra(ARG_EMPLOYEE, employee);

        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
