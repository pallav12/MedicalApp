package com.alonemusk.medicalapp.ui.EnterAdress;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alonemusk.medicalapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.NoteHolder> {
    private List<Note> notes=new ArrayList<>();
    onMenuClicked onMenuClicked;
    Context context;
    public MyItemRecyclerViewAdapter(onMenuClicked onMenuClicked){
        this.onMenuClicked=onMenuClicked;
    }
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note,viewGroup,false);
        Toolbar toolbar=itemView.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        return new NoteHolder(itemView,onMenuClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {
        Note currentnote=  notes.get(i);
        Log.d(TAG, "onBindViewHolder: 0"+ currentnote.toString());
        noteHolder.title.setText(currentnote.getAddress()+"");

        noteHolder.description.setText(currentnote.getCity()+"");




    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes=notes;
        notifyDataSetChanged();

    }
     void datasetchanged(){
     notifyDataSetChanged();
    }
    public Note getNoteAt(int i){
        return notes.get(i);

    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView description;
        private TextView priority;
        onMenuClicked onMenuClicked;



        public NoteHolder(@NonNull View itemView, final onMenuClicked onMenuClicked) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            this.onMenuClicked=onMenuClicked;
            description=itemView.findViewById(R.id.description);
            Toolbar toolbar=itemView.findViewById(R.id.toolbar);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Log.d("clicked","clicked clicked");
                    switch (item.getItemId()){

                        case R.id.delete:
                            onMenuClicked.onMenuClicked(getAdapterPosition(),1);
                            break;
                        case R.id.Edit:
                            onMenuClicked.onMenuClicked(getAdapterPosition(),2);
                            break;
                        case R.id.set_as_default:

                            onMenuClicked.onMenuClicked(getAdapterPosition(),3);
                            break;

                    }
                    return true;
                }
            });


        }
    }
    public interface onMenuClicked{
        void onMenuClicked(int i,int j);
    }
}
