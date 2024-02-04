package net.com.gopal.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import net.com.gopal.myapplication.api.MenuModel;
import net.com.gopal.myapplication.api.customerItem.itemAdapter;
import net.com.gopal.myapplication.api.customerItem.itemModel;


import java.util.ArrayList;

import com.squareup.picasso.Picasso;


public class myAdapter extends RecyclerView.Adapter<myviewHolder> {

    private ArrayList<itemModel> itemList;
    Context context;
    ArrayList<MenuModel> menuList;
    MyOnItemClickListener itemClickListener;



    public myAdapter(Context context, ArrayList<MenuModel> menuList, MyOnItemClickListener itemClickListener) {
        this.context = context;
        this.menuList = menuList;
        this.itemClickListener = itemClickListener;
    }




    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        MenuModel menuModel = menuList.get(position);

        holder.Category.setText(menuModel.getCategory());
        holder.CategoryID.setText(menuModel.getCategoryId());
        Picasso.get().load(menuModel.getIconURL()).into(holder.IconImageView);
        holder.IconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call onItemClick method of the listener
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(menuModel);
//                    new itemAdapter(context, itemList).filterByCategory(menuModel.getCategory());
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public interface MyOnItemClickListener {
        void onItemClick(MenuModel menuModel);
    }
}

//        holder.name.setText(items.get(position).getName());
//        holder.date.setText(String.valueOf(items.get(position).getDate())); // Convert int to String
//        holder.imageView.setImageResource(items.get(position).getImage1());
//        holder.imageView2.setImageResource(items.get(position).getImage2());
//        holder.date2.setText(String.valueOf(items.get(position).getDate2()));
//        holder.name2.setText(items.get(position).getName2());




