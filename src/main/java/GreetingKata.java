
public class GreetingKata {

    public String greet(String... names) {
        if (nameIsNull(names)) {
            return "Hello, my friend.";
        }

        String name2 = "";
        if (names.length == 2) {
            name2 = " and " + names[1];
        }

        if (nameIsAllUpperCase(names[0])) {
            return "HELLO " + names[0] + "!";
        }
        return "Hello, " + names[0] + name2 + ".";
    }

    protected boolean nameIsNull(String[] names) {
        return names[0] == null;
    }

    protected boolean nameIsAllUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }
}
