package net.com.gopal.myapplication.api.customerItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import net.com.gopal.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemViewHolder> {


    Context context;
 List<itemModel> itemList;

    public itemAdapter(Context context, ArrayList<itemModel> itemModel) {
        this.context = context;
        this.itemList = itemModel;
    }

//    public void filterByCategory(String categoryId) {
//        List<itemModel> filteredList = new ArrayList<>();
//
//        for (itemModel item : itemList) {
//            if (item.getCategoryId().equals(categoryId)) {
//                filteredList.add(item);
//            }
//
//        }
//
//        itemList = filteredList;
//        notifyDataSetChanged();
//
//    }
public void filterByCategory(String categoryId) {
    List<itemModel> filteredList = new ArrayList<>();

    if (itemList != null) {
        for (itemModel item : itemList) {
            if (item.getCategoryId().equals(categoryId)) {
                filteredList.add(item);
            }
        }
//
        itemList = filteredList;
        notifyDataSetChanged();

    }
}




    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new itemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        itemModel itemModel = itemList.get(position);
        holder.ItemName.setText(itemModel.getItemName());
        holder.Rate.setText(itemModel.getRate());
        Picasso.get().load(itemModel.getImageUrl()).into(holder.ItemUrl);

    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }



}
