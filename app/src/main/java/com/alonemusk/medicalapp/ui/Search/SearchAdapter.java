package com.alonemusk.medicalapp.ui.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alonemusk.medicalapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> implements Filterable {
    Fragment fragment;
    private List<SearchMedicine> exampleList;

    private List<SearchMedicine> searchMedicines=new ArrayList<>();


    public SearchViewModel searchViewModel;
    public MedicineClicked medicineClicked;
    public SearchAdapter(Fragment fragment,MedicineClicked medicineClicked){
        this.fragment=fragment;
        this.medicineClicked =medicineClicked;


    }
    public void setNotes(List<SearchMedicine> notes){
        this.searchMedicines=notes;
        exampleList=new ArrayList<>(searchMedicines);
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(fragment.getContext()).inflate(R.layout.searchitem,null);


        return new SearchHolder(v,medicineClicked);
    }


    @Override
    public void onBindViewHolder(@NonNull final SearchHolder holder, final int position) {
        holder.tv.setText( searchMedicines.get(position).getMedicine_name());


    }



    @Override
    public int getItemCount() {
        return searchMedicines.size();
    }

    public class SearchHolder extends RecyclerView.ViewHolder{
        public TextView tv;
        public MedicineClicked medicineClicked;

        public SearchHolder(@NonNull View itemView, final MedicineClicked medicineClicked) {
            super(itemView);
            this.medicineClicked=medicineClicked;
            tv=itemView.findViewById(R.id.searchItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    medicineClicked.medicineClicked(getAdapterPosition());
                }
            });
        }

    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SearchMedicine> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SearchMedicine item : searchMedicines) {
                    if (item.getMedicine_name().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            searchMedicines.clear();
            searchMedicines.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    public interface MedicineClicked{
        public void medicineClicked(int position);

    }

}
