package net.com.gopal.myapplication.api.customerItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import net.com.gopal.myapplication.R;

public class itemViewHolder extends RecyclerView.ViewHolder {
    TextView ItemName, Rate;
    ImageView ItemUrl;

    public itemViewHolder(@NonNull View item) {
        super(item);
        ItemName = item.findViewById(R.id.itemName);
        ItemUrl = item.findViewById(R.id.imageUrl);
        Rate = item.findViewById(R.id.rate);
    }
}
