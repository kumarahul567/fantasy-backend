// File: MainActivity.java
package com.example.fantasycricket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
        registerBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterActivity.class)));
    }
}

// File: LoginActivity.java
package com.example.fantasycricket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String emailStr = email.getText().toString();
        String passStr = password.getText().toString();

        // Here, call backend API using Retrofit/Volley. Placeholder response:
        if (emailStr.equals("user@test.com") && passStr.equals("123456")) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}

// File: RegisterActivity.java
package com.example.fantasycricket;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String emailStr = email.getText().toString();
        String passStr = password.getText().toString();

        // Call backend to register. Mock response:
        if (!emailStr.isEmpty() && !passStr.isEmpty()) {
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
