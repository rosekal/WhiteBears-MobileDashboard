package com.midterm.rose.whitebears_capstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements HttpCall.AsyncResponse{

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogin(View view){
        (findViewById(R.id.txtMessage)).setVisibility(View.INVISIBLE);
        username = ((EditText) findViewById(R.id.edtxtUsername)).getText().toString();
        password = ((EditText) findViewById(R.id.edtxtPassword)).getText().toString();
        HttpCall hc = new HttpCall();
        hc.delegate = this;
        hc.execute("Login", username, password);

    }

    @Override
    public void processFinish(String output) {
        if(output.equals("success")){
            Intent dashboard = new Intent(this, DashboardActivity.class);
            dashboard.putExtra("userName", username);
            startActivity(dashboard);
        }else{
            (findViewById(R.id.txtMessage)).setVisibility(View.VISIBLE);
        }
    }
}
