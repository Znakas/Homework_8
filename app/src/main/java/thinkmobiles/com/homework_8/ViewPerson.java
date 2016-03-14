package thinkmobiles.com.homework_8;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Andrii on 12.03.2016.
 */
    public class ViewPerson extends AppCompatActivity {
        TextView view_first_name;
        TextView view_last_name;
        TextView view_gender;
        TextView view_age;
        TextView view_phone;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.wiew_person);

            view_first_name = (TextView) findViewById(R.id.view_first_name);
            view_last_name = (TextView) findViewById(R.id.view_last_name);
            view_gender = (TextView) findViewById(R.id.view_gender);
            view_age = (TextView) findViewById(R.id.view_age);
            view_phone = (TextView) findViewById(R.id.view_phone);
            setActionBar();
            setData();
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
    void setData(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            Person person = (Person)bundle.getSerializable(Constants.KEY2);
            view_first_name.setText(person != null ? person.getName() : null);
            view_last_name.setText(person != null ? person.getLastName() : null);
            view_gender.setText(person != null ? person.getGender() : null);
            view_age.setText(person != null ? person.getAge() : null);
            view_phone.setText(person != null ? person.getPhone() : null);
        }
    }
}