package main.java.com.pluralsight.prototype;

import java.util.ArrayList;
import java.util.List;


/**
 * In shallow copy, the reference (i.e, Record in this eg) will be same for both object.
 * Changes made to this reference will get reflected in both the object.
 * In shallow copy, we have to be careful as changes made to reference can be risky sometime
 */

public class PrototypeDemo {

    public static void main(String[] args) {

        String sql = "select * from movies where title = ?";

        List<String> parameters = new ArrayList<>();
        parameters.add("Star wars");

        Record record = new Record();

        Statement firstStatement = new Statement(sql, parameters, record);

        System.out.println(firstStatement.getSql());
        System.out.println(firstStatement.getParameters());
        System.out.println(firstStatement.getRecord());

        //Copy of firstStatement. Avoiding the use of new keyword. Therefore, avoiding costly creation
        Statement secondStatement = firstStatement.clone();

        System.out.println(secondStatement.getSql());
        System.out.println(secondStatement.getParameters());
        System.out.println(secondStatement.getRecord());

    }
}
