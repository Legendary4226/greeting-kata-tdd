
public class GreetingKata {

    public String greet(String... names) {
        if (nameIsEmptyOrNull(names)) {
            return "Hello, my friend.";
        }

        String namesConcat = names[0];
        int i = 1;
        while (i < names.length - 1) {
            namesConcat += ", " + names[i];
            i++;
        }
        if (i < names.length) {
            namesConcat += " and " + names[names.length - 1];
        }

        if (nameIsAllUpperCase(names[0])) {
            return "HELLO " + names[0] + "!";
        }
        return "Hello, " + namesConcat + ".";
    }

    protected boolean nameIsEmptyOrNull(String[] names) {
        return names.length == 0 || names[0] == null;
    }

    protected boolean nameIsAllUpperCase(String name) {
        return name.equals(name.toUpperCase());
    }
}
