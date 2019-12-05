package com.alonemusk.medicalapp.ui.EnterAdress;


import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewmodel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> Allnote;

    public NoteViewmodel(@NonNull Application application) {
        super(application);
        repository=new NoteRepository(application);
        Allnote=repository.getAllnote();
    }
    public void Insert(Note note){
        repository.insert(note);
    }
    public void Update(Note note){
        repository.update(note);
    }
    public  void delete(Note note){
        repository.delete(note);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public LiveData<List<Note>> getAllnote(){
        return Allnote;
    }




}
