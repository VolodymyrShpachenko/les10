package ex2;

public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toJson() {
        StringBuilder result = new StringBuilder();
        result.append("\n    {\n");
        result.append("        \"name\": \"").append(getName()).append("\",\n");
        result.append("        \"age\":").append(getAge()).append("\n");
        result.append("    }");
        return new String(result);
    }
}
