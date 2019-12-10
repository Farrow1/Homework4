 package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    TextView name, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
    }

    public void save(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("save", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Name", name.getText().toString());
        editor.putString("Email", email.getText().toString());
        editor.putString("Password", password.getText().toString());

        editor.commit();

    }

    public void retrieve(View view){
        SharedPreferences sharedpreferences = getSharedPreferences("save",Context.MODE_PRIVATE);

        name.setText(sharedpreferences.getString("Name",null));
        email.setText(sharedpreferences.getString("Email",null));
        password.setText(sharedpreferences.getString("Password",null));
    }

    public void clear(View view){
        name.setText("");
        email.setText("");
        password.setText("");
    }
}
