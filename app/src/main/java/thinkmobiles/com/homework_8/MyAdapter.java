package thinkmobiles.com.homework_8;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Andrii on 11.03.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static onViewClickListener itemListener;
    private ArrayList<Person> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView person_firstname;
        TextView del_person;
        LinearLayout mlayout;

        public MyViewHolder(View v) {
            super(v);
            person_firstname = (TextView) v.findViewById(R.id.person_firstname);
            del_person = (TextView) v.findViewById(R.id.del_person);
            mlayout = (LinearLayout) v.findViewById(R.id.mlayout);

            person_firstname.setOnClickListener(this);
            del_person.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.personItemSelected(v, this.getLayoutPosition());
        }
    }

    public MyAdapter( ArrayList<Person> myDataset, onViewClickListener itemListener ) {
        mDataset = myDataset;
        MyAdapter.itemListener = itemListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final TextView del_person = holder.del_person;
        final TextView person_firstname = holder.person_firstname;
        person_firstname.setText(mDataset.get(position).getName());

        if (Constants.bgRed){
            holder.mlayout.setBackgroundColor(Color.RED);
        } else {
            holder.mlayout.setBackgroundColor(Color.YELLOW);}
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}