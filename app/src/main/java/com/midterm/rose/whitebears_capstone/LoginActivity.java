package com.midterm.rose.whitebears_capstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogin(View view){
        String username = ((EditText) findViewById(R.id.edtxtUsername)).getText().toString();
        String password = ((EditText) findViewById(R.id.edtxtPassword)).getText().toString();

        if(verifyLogin(username, password)){
            Intent dashboard = new Intent(this, DashboardActivity.class);
            startActivity(dashboard);
        }else{
            (findViewById(R.id.txtMessage)).setVisibility(View.VISIBLE);
        }
    }

    private boolean verifyLogin(String username, String password) {
        if(username.isEmpty() || password.isEmpty())
            return false;

        return true;
    }
}
