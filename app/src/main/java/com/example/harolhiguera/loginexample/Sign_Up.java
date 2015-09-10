package com.example.harolhiguera.loginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void SignupMethod(View v){
        if(v.getId() == R.id.BSignupButton){

            EditText name = (EditText)findViewById(R.id.TFName);
            EditText email = (EditText)findViewById(R.id.TFEmail);
            EditText uname = (EditText)findViewById(R.id.TFUsername);
            EditText pass1 = (EditText)findViewById(R.id.TFPass1);
            EditText pass2 = (EditText)findViewById(R.id.TFPass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                Toast pass = Toast.makeText(Sign_Up.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                /* Here an object of 4 parameters is created through the class contact
                * then it is send to the DatabaseHelper to execute the insertContact method*/
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                helper.insertContact(c);

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign__up, menu);
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
