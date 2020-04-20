package main.java.com.pluralsight.prototype;

//Imagine an Amazon application. They cant create object for each item to be displayed.
//Create one object and then clone it for different items
public abstract class Item implements Cloneable {

    private String title;
    private double price;
    private String url;

    //Clone method in root class.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //System.out.println(super.clone().getClass());
        return super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
