package com.alonemusk.medicalapp.ui.Search;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {SearchMedicine.class},version = 3)

public abstract class SearchDatabase extends RoomDatabase {
    private static SearchDatabase instance;
    public abstract SearchDao searchDao();
    public static synchronized SearchDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SearchDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;


    }
    private static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsyncTask(instance).execute();
        }
    };
    private static class populateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private SearchDao searchDao;
        private    populateDbAsyncTask(SearchDatabase db){
            searchDao=db.searchDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
