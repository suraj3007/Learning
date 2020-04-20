package main.java.com.pluralsight.builder;


public class TestDemo {

    public static void main(String[] args) {
        ImmutableUser user = new ImmutableUser.UserBuilder("shekhar", "password").firstName("shekhar")
                .lastName("gulati").email("shekhargulati84@gmail.com").build();
    }

}
