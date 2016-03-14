package thinkmobiles.com.homework_8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements onViewClickListener {

    private static RecyclerView mRecyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    private static RecyclerView.Adapter mAdapter;
    private static ArrayList<Person> myDataset = new ArrayList<Person>();
    int requestId=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myDataset, this);
        mRecyclerView.setAdapter(mAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_person) {
            Intent intent = new Intent(MainActivity.this, CreatePersonActivity.class);
            startActivityForResult(intent, requestId);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

     protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null){
            return;
        }
         Bundle bundle = data.getExtras();
         if(bundle != null) {
             Person person = (Person) bundle.getSerializable(Constants.KEY1);
             person.getName();
             person.getLastName();
             person.getGender();
             person.getAge();
             person.getPhone();

             myDataset.add(person);
             mAdapter.notifyItemInserted(mAdapter.getItemCount() - 1);
             mAdapter.notifyItemRangeInserted(mAdapter.getItemCount() - 1, mAdapter.getItemCount());
         }
    }

    @Override
    public void personItemSelected(View v, int index) {
        switch (v.getId()) {
            case R.id.person_firstname:
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.KEY2, myDataset.get(index));

                Intent intent = new Intent(this, ViewPerson.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.del_person:
                myDataset.remove(index);
                mAdapter.notifyItemRemoved(index);
                break;
        }
    }
}