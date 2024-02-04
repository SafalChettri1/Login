package net.com.gopal.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myviewHolder extends RecyclerView.ViewHolder {

 ImageView IconImageView;
 TextView CategoryID, Category;


    public myviewHolder(@NonNull View itemView) {
        super(itemView);
        IconImageView = itemView.findViewById(R.id.imageview1);
        Category = itemView.findViewById(R.id.name);
        CategoryID = itemView.findViewById(R.id.date);
//        imageView2 = itemView.findViewById(R.id.imageview2);
//        date2 = itemView.findViewById(R.id.date2);
//        name2 = itemView.findViewById(R.id.name2);

    }
}