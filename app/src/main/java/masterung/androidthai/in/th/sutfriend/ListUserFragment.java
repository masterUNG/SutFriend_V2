package masterung.androidthai.in.th.sutfriend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListUserFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create RecyclerView
        createRecyclerView();


    }

    private void createRecyclerView() {
        final RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewUser);

        final int[] countInt = new int[]{0};

        final ArrayList<String> nameStringArrayList = new ArrayList<>();
        final ArrayList<String> urlAvataStringArrayList = new ArrayList<>();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("User");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int i = (int) dataSnapshot.getChildrenCount();
                ArrayList<UserSutModel> userSutModels = new ArrayList<>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    UserSutModel userSutModel = dataSnapshot1.getValue(UserSutModel.class);
                    userSutModels.add(userSutModel);

                    UserSutModel userSutModel1 = userSutModels.get(countInt[0]);
                    countInt[0] += 1;
                    nameStringArrayList.add(userSutModel1.getNameString());
                    urlAvataStringArrayList.add(userSutModel1.getUrlAvataString());

                }

                ListUserAdapter listUserAdapter = new ListUserAdapter(getActivity(), nameStringArrayList, urlAvataStringArrayList);
                recyclerView.setAdapter(listUserAdapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_user, container, false);
        return view;
    }
}
