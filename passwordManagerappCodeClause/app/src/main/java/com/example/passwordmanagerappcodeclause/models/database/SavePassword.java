package com.example.passwordmanagerappcodeclause.models.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.passwordmanagerappcodeclause.R;
import com.example.passwordmanagerappcodeclause.models.password.Password;

public class SavePassword extends AppCompatActivity {
    private EditText editPwdName,editPwdValue,editPwdLogin;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_password);

        initViews();
    }
    public void initViews(){
        editPwdLogin=findViewById(R.id.edit_pwd_login);
        editPwdName=findViewById(R.id.edit_pwd_name);
        editPwdValue=findViewById(R.id.edit_pwd_value);
        btnSave=findViewById(R.id.btn_save);

        String generatedPassword = getIntent().getStringExtra("pwd");
        editPwdValue.setText(generatedPassword);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbHelper = new DatabaseHelper(SavePassword.this);
                Password password = new Password(editPwdName.getText().toString(),editPwdLogin.getText().toString(),editPwdValue.getText().toString());
                boolean saved = dbHelper.insert(password);
                if(saved){
                    Toast.makeText(SavePassword.this, "Password is saved", Toast.LENGTH_SHORT).show();
                    btnSave.setEnabled(false);
                }
            }
        });
    }
}