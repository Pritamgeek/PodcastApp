package com.example.user.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.Login;
import com.facebook.login.widget.LoginButton;

import static com.example.user.firstapplication.R.id.password;
import static com.example.user.firstapplication.R.id.username;

/**
 * Created by User on 10-10-2017.
 */

public class LoginActivity extends AppCompatActivity{

    TextView tv;
    Button loginbutton;
    private static EditText emailfield;
    private static EditText passfield;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        tv = (TextView) findViewById(R.id.textView7);
        loginbutton = (Button) findViewById(R.id.login);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        LoginButton();
    }

    private void LoginButton(){
        emailfield = (EditText)findViewById(R.id.email);
        passfield = (EditText)findViewById(password);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((emailfield.getText().toString().equals("pritam@mendios.com"))&&(passfield.getText().toString().equals("threering")))
                {
                    Toast.makeText(LoginActivity.this,"Username and password is correct",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LoggedActivity.class);
                    LoginActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"Username and password is NOT correct",
                            Toast.LENGTH_SHORT).show();
                    loginbutton.setEnabled(false);
                }

            }


        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
