package com.alonemusk.medicalapp.ui.Search;

import android.app.Application;
import android.util.Log;

import com.alonemusk.medicalapp.MainActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchViewModel extends AndroidViewModel {

    private LiveData<List<SearchMedicine>> currentName;
    private SearchRepository repository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository=new SearchRepository(application);
        currentName=repository.getAllnote();

    }


    public LiveData<List<SearchMedicine>> getCurrentName() {
        if (currentName == null) {
            currentName=repository.getAllnote();
        }
        return currentName;
    }
    public void Insert(SearchMedicine note){
        repository.insert(note);
    }
    public void Update(SearchMedicine note){
        repository.update(note);
    }
    public  void delete(SearchMedicine note){
        repository.delete(note);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public LiveData<List<SearchMedicine>> getAllnote(){
        return currentName;
    }

    }

