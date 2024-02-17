
public class GreetingKata {

    public String greet() {
        return "Hello, my friend.";
    }

    public String greet(String name, String... names) {
        String name2 = "";
        if (names.length == 1) {
            name2 = " and " + names[0];
        }

        if (nameIsAllUpperCase(name)) {
            return "HELLO " + name + name2 + "!";
        }
        return "Hello, " + name + name2 + ".";
    }

    protected boolean nameIsAllUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }
}
