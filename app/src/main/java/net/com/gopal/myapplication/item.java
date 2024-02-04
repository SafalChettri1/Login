package net.com.gopal.myapplication;

public class item {

    String name;
    int image1;
    int date;

    public item(String name, int image1, int date) {
        this.name = name;
        this.image1 = image1;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }



}
