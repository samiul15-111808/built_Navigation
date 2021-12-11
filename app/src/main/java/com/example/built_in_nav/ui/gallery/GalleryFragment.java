package com.example.built_in_nav.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.built_in_nav.R;

import java.util.Objects;

public class GalleryFragment extends Fragment {
    private Spinner sp1, sp2;
    private EditText editOne;
    private Button b1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        editOne = view.findViewById(R.id.textAmount);
        sp1 = view.findViewById(R.id.form);
        sp2 = view.findViewById(R.id.to);
        b1 = view.findViewById(R.id.buttonId);

        String[] form = {"USD Dollar", "TAKA"};
        ArrayAdapter ad = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, form);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(ad);


        String[] to = {"Bangladeshi taka","Indian Rupee","Canada","USD Dollar"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item, to);
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(ad1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total;
                double amount = Double.parseDouble(editOne.getText().toString());

                if (sp1.getSelectedItem().toString() == "USD Dollar" && sp2.getSelectedItem().toString() == "Bangladeshi taka"){
                    total = amount * 84.84174;
                    Toast.makeText(getView().getContext(), Double.toString(total), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "USD Dollar" && sp2.getSelectedItem().toString() == "Indian Rupee"){
                    total = amount * 74.24749;
                    Toast.makeText(getView().getContext(), Double.toString(total), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "USD Dollar" && sp2.getSelectedItem().toString() == "Canada"){
                    total = amount * 100;
                    Toast.makeText(getView().getContext(), Double.toString(total), Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString() == "TAKA" && sp2.getSelectedItem().toString() == "USD Dollar"){
                    total = amount * 100;
                    Toast.makeText(getView().getContext(), Double.toString(total), Toast.LENGTH_LONG).show();
                }



            }
        });




        return view;
    }
}