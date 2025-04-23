package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText etName, etPhone, etPassword, etConfirmPassword;
    private UserDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new UserDatabaseHelper(this);

        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        Button btnRegister = findViewById(R.id.btn_register);
        Button btnBack = findViewById(R.id.btn_back);
        Button btnLogin = findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(v -> handleRegistration());
        btnLogin.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        btnBack.setOnClickListener(v -> finish());
    }

    private void handleRegistration() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Inconsistent passwords entered twice", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dbHelper.isPhoneExists(phone)) {
            Toast.makeText(this, "Phone number already registered", Toast.LENGTH_SHORT).show();
            return;
        }

        long id = dbHelper.addUser(name, phone, password);
        if (id > 0) {
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
        }
    }
}