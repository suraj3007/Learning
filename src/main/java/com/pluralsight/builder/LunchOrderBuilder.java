package main.java.com.pluralsight.builder;

/**
 * Solution : Builder pattern
 * The builder design pattern provides a way for you to build complex immutable objects. The process is:
 * The client calls a constructor (or static factory) with all the required parameters and gets a builder object.
 * The client calls setter like methods to set each optional parameter of interest.
 * Finally the client calls the build method to generate the object which is immutable.
 */

public class LunchOrderBuilder {

    /**
     * In Builder pattern, we create a static inner class.
     * This will build the argument as it is passed without worrying about various combination.
     * It will ensure the object immutability
     */

    public static class Builder {

        /**
         * Create same set of variables in static class as well.
         * This will maintain the separate container for all these variables.
         */

        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        /**
         * This will call the private constructor by only this build method.
         * @return : LunchOrderBuilder
         */
        public LunchOrderBuilder build() {
            return new LunchOrderBuilder(this);
        }

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    /**
     * This will be instantiated by build method.
     * Here, it will copy the container variables in actual set of variables.
     * Hence, no need of setter methods which ensures object immutability.
     * @param builder
     */
    private LunchOrderBuilder(Builder builder) {

        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;

    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}