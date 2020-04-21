package main.java.com.pluralsight.factoryMethod;

//Subclass : Blog website which contains these set of pages. Here, subclasses will decide which class to instantiate
public class Blog extends Website {

    @Override
    public void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
