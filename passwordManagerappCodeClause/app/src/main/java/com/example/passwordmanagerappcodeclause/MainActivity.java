package com.example.passwordmanagerappcodeclause;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.passwordmanagerappcodeclause.models.database.DatabaseHelper;
import com.example.passwordmanagerappcodeclause.models.database.SavePassword;
import com.example.passwordmanagerappcodeclause.models.generators.LowerCaseGenerator;
import com.example.passwordmanagerappcodeclause.models.generators.NumericGenerator;
import com.example.passwordmanagerappcodeclause.models.generators.PasswordGenerator;
import com.example.passwordmanagerappcodeclause.models.generators.SpecialCharGenerator;
import com.example.passwordmanagerappcodeclause.models.generators.UpperCaseGenerator;
import com.example.passwordmanagerappcodeclause.models.password.Password;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textError;
    private EditText editPasswordSize;
    private TextView textPasswordGenerated;
    private CheckBox checkLower;
    private CheckBox checkUpper;
    private CheckBox checkNumeric;
    private CheckBox checkSpecial;
    private Button btnCopy,btnGenerate,btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        clickListeners();
        //displaySavedPasswords();
    }
//    private void displaySavedPasswords() {
//        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
//        List<Password> passwordList = db.getPasswordList();
//        Log.e("PWD_LIST",passwordList.toString());
//    }

    private void clickListeners(){
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int passwordSize=Integer.parseInt(editPasswordSize.getText().toString());

                textError.setText("");

                if(passwordSize<8){
                    textError.setText("Password size should be greater than 8 ");
                    return;
                }
                PasswordGenerator.clear();

                if(checkLower.isChecked())  PasswordGenerator.add(new LowerCaseGenerator());
                if(checkUpper.isChecked())  PasswordGenerator.add(new UpperCaseGenerator());
                if(checkNumeric.isChecked())  PasswordGenerator.add(new NumericGenerator());
                if(checkSpecial.isChecked())  PasswordGenerator.add(new SpecialCharGenerator());

                if(PasswordGenerator.isEmpty()){
                    textError.setText("Select at least one of the above options");
                    return;
                }

                String passwd=PasswordGenerator.generatePassword(passwordSize);
                textPasswordGenerated.setText(passwd);
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                manager.setPrimaryClip(ClipData.newPlainText("passwd",textPasswordGenerated.getText().toString()));
                Toast.makeText(MainActivity.this, "password copied", Toast.LENGTH_SHORT).show();
             }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPwd= textPasswordGenerated.getText().toString();
                Intent intent = new Intent(MainActivity.this, SavePassword.class);
                intent.putExtra("pwd",getPwd);
                startActivity(intent);
            }
        });
    }



    private void initViews(){
        textError = findViewById(R.id.text_error);
        editPasswordSize=findViewById(R.id.edit_pwd_size);
        textPasswordGenerated=findViewById(R.id.text_password_result);
        checkLower=findViewById(R.id.check_lower);
        checkUpper=findViewById(R.id.check_upper);
        checkNumeric=findViewById(R.id.check_numeric);
        checkSpecial=findViewById(R.id.check_special);
        btnCopy=findViewById(R.id.btn_copy);
        btnGenerate=findViewById(R.id.btn_generate);
        btnSave=findViewById(R.id.btn_save);

    }
}