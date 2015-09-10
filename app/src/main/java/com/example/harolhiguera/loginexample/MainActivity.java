package com.example.harolhiguera.loginexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickMethod(View v){
        if(v.getId() == R.id.BLogin){
            //Trnasfer the Username from the main activity to the second activity
            //Get what is in the edit text (Username)
            EditText a = (EditText)findViewById(R.id.TFUsername);
            //Convert it to string
            String str = a.getText().toString();
            //Now the intent.. normally
            Intent i = new Intent(MainActivity.this, Second_Screem.class);
            i.putExtra("username", str);
            startActivity(i);
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
