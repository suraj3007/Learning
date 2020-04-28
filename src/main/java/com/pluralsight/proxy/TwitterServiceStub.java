package main.java.com.pluralsight.proxy;

public class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline(String screenName) {
        return "My twitter timeline";
    }

    @Override
    public void postToTimeline(String screenName, String message) {
        System.out.println(message);
    }
}
