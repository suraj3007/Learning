package main.java.com.pluralsight.prototype;

public class PrototypeDemo2 {

    public static void main(String[] args) {

        Registry registry = new Registry();

        //For Movie category, we have not used new keyword. Instead we clone the object stored in registry.
        Movie movie = (Movie) registry.createItems("Movie");
        //Now change the item as per requirement. For eg. new movie with different name
        movie.setTitle("Creational patterns in java");

        System.out.println(movie);
        System.out.println(movie.getTitle());
        System.out.println(movie.getRuntime());
        System.out.println(movie.getPrice());

        //For Movie category, we have not used new keyword. Instead we clone the object stored in registry.
        Movie anotherMovie = (Movie) registry.createItems("Movie");
        //Now change the item as per requirement. For eg. new movie with different name
        movie.setTitle("Gang of Four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getPrice());

    }
}
