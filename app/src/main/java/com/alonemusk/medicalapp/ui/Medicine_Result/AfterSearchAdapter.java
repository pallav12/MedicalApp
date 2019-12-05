package com.alonemusk.medicalapp.ui.Medicine_Result;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alonemusk.medicalapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AfterSearchAdapter extends RecyclerView.Adapter<AfterSearchAdapter.holder> {
    ArrayList<String>str;
    Context context;
    GoTOCart goTOCart;
    public AfterSearchAdapter(ArrayList<String>str, Context context,GoTOCart goTOCart){
        this.str=str;
        Log.d("strrr",str.size()+"");
        this.goTOCart=goTOCart;

        this.context=context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_medicine,null);
        holder holder=new holder(v,goTOCart);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {


        holder.textView.setText(str.get(position));

    }

    @Override
    public int getItemCount() {
        return str.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView textView;
        public holder(@NonNull View itemView, final GoTOCart goTOCart) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goTOCart.gotocart(getAdapterPosition());

                }
            });


        }
    }
    public interface GoTOCart{
        public void gotocart(int position);
    }
}
