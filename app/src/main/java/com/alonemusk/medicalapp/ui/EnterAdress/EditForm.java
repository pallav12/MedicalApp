package com.alonemusk.medicalapp.ui.EnterAdress;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alonemusk.medicalapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static android.content.ContentValues.TAG;

public class EditForm extends Fragment {

    private AddressFormViewModel mViewModel;
    String address;
    String Landmark;
    String City;
    String state;

    public static AddressForm newInstance() {
        return new AddressForm();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.address_form_fragment, container, false);

        final EditText editText =v.findViewById(R.id.line1);
        editText.setText(getArguments().getString("address"));



        final EditText editText2 =v.findViewById(R.id.line2);
        editText2.setText(getArguments().getString("state"));


        final EditText editTex3 =v.findViewById(R.id.line3);
        editTex3.setText(getArguments().getString("city"));


        final EditText editTex4 =v.findViewById(R.id.line4);



        Button button=v.findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                address=editText.getText().toString();
                Landmark=editText2.getText().toString();
                City=editTex3.getText().toString();
                state=editTex4.getText().toString();

                NoteViewmodel noteViewmodel=ViewModelProviders.of(getActivity()).get(NoteViewmodel.class);
                List<Note> notes=noteViewmodel.getAllnote().getValue();
                if (notes != null) {

                    noteViewmodel.delete(notes.get(getArguments().getInt("position")));
                }

                Log.d(TAG, "onClick: "+address+Landmark);
                noteViewmodel.Insert(new Note(19,address,Landmark,City,state,"true"));
                final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

                navController.navigate(R.id.action_navigation_edit_form_to_navigation_adress);


            }
        });






        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddressFormViewModel.class);



    }

}
