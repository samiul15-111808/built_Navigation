package com.example.built_in_nav.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.built_in_nav.R;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SlideshowFragment extends Fragment {

    EditText idEdit,nameEdit,courseEdit,sectionEdit,searchId;
    TextView nameView,sectionView,courseView;
    Button btn1,btn2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);


        nameEdit = view.findViewById(R.id.nameEdit);
        courseEdit = view.findViewById(R.id.courseEdit);
        sectionEdit = view.findViewById(R.id.sectionEdit);
        idEdit = view.findViewById(R.id.idEdit);
        nameView = view.findViewById(R.id.nameOutput);
        courseView = view.findViewById(R.id.courseOutput);
        sectionView = view.findViewById(R.id.sectionOutput);
        btn1 = view.findViewById(R.id.btnId);
        btn2 = view.findViewById(R.id.showbuttonId);
        searchId = view.findViewById(R.id.searchId);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,course,section,idData;

                name = nameEdit.getText().toString();
                course = courseEdit.getText().toString();
                section = sectionEdit.getText().toString();
                idData = idEdit.getText().toString();

                insertionClass data = new insertionClass(name,section,course);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Students");

                myRef.child(idData).setValue(data);

                idEdit.setText("");
                nameEdit.setText("");
                courseEdit.setText("");
                sectionEdit.setText("");
                Toast.makeText(getActivity(),"successfully", Toast.LENGTH_SHORT).show();

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchData = searchId.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Students").child(searchData);

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String name,section,course;

                        name = snapshot.child("name").getValue().toString();
                        course = snapshot.child("course").getValue().toString();
                        section = snapshot.child("section").getValue().toString();

                        nameView.setText(""+name);
                        courseView.setText(""+course);
                        sectionView.setText(""+section);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        return view;
    }
}