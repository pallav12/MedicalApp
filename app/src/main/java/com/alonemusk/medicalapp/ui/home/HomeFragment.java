package com.alonemusk.medicalapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.alonemusk.medicalapp.FirstActivity;
import com.alonemusk.medicalapp.R;
import com.alonemusk.medicalapp.ui.EnterAdress.ItemFragment;
import com.alonemusk.medicalapp.ui.EnterAdress.dummy.DummyContent;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment implements ItemFragment.OnListFragmentInteractionListener {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        SearchView searchView=root.findViewById(R.id.search);
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_navigation_home_to_navigation_search);

            }
        });
        TextView textView=root.findViewById(R.id.pincode);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_adress);
            }
        });
        TextView textView1=root.findViewById(R.id.deliverto);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_adress);
            }
        });



        return root;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}