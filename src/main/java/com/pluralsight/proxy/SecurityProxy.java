package main.java.com.pluralsight.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecurityProxy implements InvocationHandler {

    private Object obj;

    public SecurityProxy(Object obj) {
        this.obj = obj;
    }

    //Builds a proxy around class and interface and then wrapping into SecurityProxy
    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new SecurityProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        try {
            //we can add security as per our requirement if proxy is inceptor to route the calls and return the result
            if (method.getName().contains("post")) {
                throw new IllegalArgumentException("Posts are currently not allowed");

            } else {
                //It acts as an intermediator. Any method we call, it will take the request and pass the result.
                result = method.invoke(obj, args);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Invocation exception : " + e.getMessage());
        }
        return result;
    }
}
