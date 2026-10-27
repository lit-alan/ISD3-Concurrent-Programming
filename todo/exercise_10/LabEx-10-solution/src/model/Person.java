package src.model;

public class Person {
    private final String code;
    private final String indicator;
    private final String name;

    public Person(String code, String indicator, String name) {
        this.code = code;
        this.indicator = indicator;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getIndicator() { return indicator; }
    public String getName() { return name; }
}
