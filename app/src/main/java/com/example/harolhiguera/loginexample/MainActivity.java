package com.example.harolhiguera.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickMethod(View v){
        if(v.getId() == R.id.BLogin){

            EditText a = (EditText)findViewById(R.id.TFUsername);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFPass1);
            String pass = b.getText().toString();
            /* Go to the db with the username and grab the password that corresponds..if so */
            String x;
            x = "Username not Found";
            String password = helper.searchPass(str);
            if (password.equals(x)){
                Toast temp = Toast.makeText(MainActivity.this, x, Toast.LENGTH_SHORT);
                temp.show();
            }else if (pass.equals(password)) {
                Intent i = new Intent(MainActivity.this, Second_Screem.class);
                i.putExtra("username", str);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(MainActivity.this, "Username and password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(v.getId() == R.id.BSignup){
            Intent i = new Intent(MainActivity.this, Sign_Up.class);
            startActivity(i);
        }
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
