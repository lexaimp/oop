import java.io.Serializable;

public class MyClass implements Serializable {
    static final long serialVersionUID = 1L;
    private String testField;

    public String getTestField() {
        return testField;
    }

    public MyClass(String testField) {
        this.testField = testField;
    }

}
