package net.com.gopal.myapplication.api;

public class MenuModel {
    String Category;
    String IconURL;
    String CategoryId;

    public MenuModel(String category, String iconURL, String categoryId) {
        Category = category;
        IconURL = iconURL;
        CategoryId = categoryId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getIconURL() {
        return IconURL;
    }

    public void setIconURL(String iconURL) {
        IconURL = iconURL;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }
}
