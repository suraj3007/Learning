package main.java.com.pluralsight.proxy;

public class TwitterDemo {

    public static void main(String[] args) {

        TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());

        System.out.println(service.getTimeline("suraj"));   //Twitter eg was given but for it we need our own developer account

        service.postToTimeline("suraj", "Some message that shouldnt go through");
    }
}
