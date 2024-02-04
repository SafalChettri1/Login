package net.com.gopal.myapplication.api.customerItem;

public class itemModel {
    String ItemName;
    String ImageUrl;
    String Rate;
    String CategoryId;

    public itemModel(String itemName, String imageUrl, String rate, String categoryId) {
        ItemName = itemName;
        ImageUrl = imageUrl;
        Rate = rate;
        CategoryId = categoryId;
    }
//    public itemModel(String itemName, String imageUrl, String rate) {
//        ItemName = itemName;
//        ImageUrl = imageUrl;
//        Rate = rate;
//    }



    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }
}
