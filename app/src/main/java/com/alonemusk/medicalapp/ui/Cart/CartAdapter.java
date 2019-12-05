package com.alonemusk.medicalapp.ui.Cart;

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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.holder> {
    Context context;
    GoTOCart goTOCart;
    public CartAdapter( Context context,GoTOCart goTOCart){

        this.goTOCart=goTOCart;

        this.context=context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_cart,null);
        holder holder=new holder(v,goTOCart);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView textView;
        public holder(@NonNull View itemView, final GoTOCart goTOCart) {
            super(itemView);



        }
    }
    public interface GoTOCart{
        public void gotocart(int position);
    }
}
