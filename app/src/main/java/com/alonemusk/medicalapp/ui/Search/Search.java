package com.alonemusk.medicalapp.ui.Search;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ImageView;

import com.alonemusk.medicalapp.AfterSearch;
import com.alonemusk.medicalapp.MainActivity;
import com.alonemusk.medicalapp.R;
import com.alonemusk.medicalapp.classes.JsonParsing;
import com.alonemusk.medicalapp.classes.MedicineNameId;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Search extends Fragment implements SearchAdapter.MedicineClicked {

    private SearchViewModel mViewModel;
    private RecyclerView recyclerView;
    public SearchAdapter searchAdapter;
    private ImageView imageView;
    public SearchView searchView;
    ArrayList<SearchMedicine>searchMedicines;

    public static Search newInstance() {
        return new Search();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.search_fragment, container, false);


        findViews(v);


        onClickListener();




        return v;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();

        OkHttpClient client = new OkHttpClient();

        String url = "http://ec2-3-16-216-35.us-east-2.compute.amazonaws.com:3000/fetch-medicine-and-id";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();

                            ArrayList<JSONObject>jsonObjects= JsonParsing.parsejson(myResponse);


                            for(JSONObject obj:jsonObjects){
                                SearchMedicine object = gson.fromJson(String.valueOf(obj), SearchMedicine.class);
                                mViewModel.Insert(object);
                                ;

                            }
                        }
                    });
                }

            }
        });
        mViewModel.getAllnote().observe(this, new Observer<List<SearchMedicine>>() {
            @Override
            public void onChanged(List<SearchMedicine> notes) {
                searchAdapter.setNotes(notes);
                searchMedicines=new ArrayList<>(notes);



            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);
                Log.d(TAG, "onQueryTextChange: "+newText);
                return true;
            }
        });



    }

    private void findViews(View v) {
        recyclerView=v.findViewById(R.id.recyclerView);
        imageView=v.findViewById(R.id.back);
        searchView=v.findViewById(R.id.search);


    }
    private void initViews(){
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchMedicines=new ArrayList<>();
        searchAdapter=new SearchAdapter(this,this);
        recyclerView.setAdapter(searchAdapter);
    }
    private void onClickListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void medicineClicked(int position) {
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_navigation_search_to_navigation_after_search);



    }
}
