package thinkmobiles.com.homework_8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePersonActivity extends AppCompatActivity {
    EditText editText_first_name;
    EditText editText_last_name;
    EditText editText_gender;
    EditText editText_age;
    EditText editText_phone;

    Button btn_create;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.create_person);

            editText_first_name = (EditText) findViewById(R.id.editText_first_name);
            editText_last_name = (EditText) findViewById(R.id.editText_last_name);
            editText_gender = (EditText) findViewById(R.id.editText_gender);
            editText_age = (EditText) findViewById(R.id.editText_age);
            editText_phone = (EditText) findViewById(R.id.editText_phone);
            btn_create = (Button)findViewById(R.id.btn_create);
            setActionBar();
    }
    private void setActionBar(){
        final ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void OnClickAccept(View view) {
        if ((editText_first_name.getText().toString()).equals("")){
            Toast.makeText(this, "Enter first name", Toast.LENGTH_SHORT).show();
        }
        if ((editText_last_name.getText().toString()).equals("")){
            Toast.makeText(this, "Enter last name", Toast.LENGTH_SHORT).show();
        }
            else{
                if ((editText_age.getText().toString()).equals("")&&
                    (editText_gender.getText().toString()).equals("")&&
                    (editText_phone.getText().toString()).equals("")
                    ) {
                sentData();
                    Constants.bgRed=true;
            } else {
                sentData();
                    Toast.makeText(this, "Full", Toast.LENGTH_SHORT).show();
                    Constants.bgRed=false;
            }
        }
    }

    private void sentData(){
        Person person = new Person();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY1, person);

        person.setName(editText_first_name.getText().toString());
        person.setLastName(editText_last_name.getText().toString());
        person.setGender(editText_gender.getText().toString());
        person.setAge(editText_age.getText().toString());
        person.setPhone(editText_phone.getText().toString());

        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);
        finish();
    }
}