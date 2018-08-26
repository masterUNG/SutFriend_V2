package masterung.androidthai.in.th.sutfriend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListUserViewHolder>{

    private Context context;
    private ArrayList<String> nameStringArrayList, urlAvataStringArrayList;
    private LayoutInflater layoutInflater;

    public ListUserAdapter(Context context,
                           ArrayList<String> nameStringArrayList,
                           ArrayList<String> urlAvataStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameStringArrayList = nameStringArrayList;
        this.urlAvataStringArrayList = urlAvataStringArrayList;
    }   // Constructor

    @Override
    public ListUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_view_list_user, parent, false);
        ListUserViewHolder listUserViewHolder = new ListUserViewHolder(view);


        return listUserViewHolder;

    }

    @Override
    public void onBindViewHolder(ListUserViewHolder holder, int position) {

        String nameString = nameStringArrayList.get(position);
        String urlAvataString = urlAvataStringArrayList.get(position);

        holder.textView.setText(nameString);
        Picasso.get()
                .load(urlAvataString)
                .resize(100, 100)
                .into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return nameStringArrayList.size();
    }

    public class ListUserViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView circleImageView;
        private TextView textView;


        public ListUserViewHolder(View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.circleAvata);
            textView = itemView.findViewById(R.id.txtName);


        }
    }   // Second Class


}   // Main Class
