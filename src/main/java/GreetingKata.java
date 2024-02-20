import java.util.ArrayList;
import java.util.Objects;

public class GreetingKata {

    private final ArrayList<String> normalNames = new ArrayList<>();
    private final ArrayList<String> shoutedNames = new ArrayList<>();

    public String greet(String... names) {
        reset();
        separateNames(names);

        return formatGreeting(
            concatNames(normalNames),
            concatNames(shoutedNames)
        );
    }

    public void reset() {
        normalNames.clear();
        shoutedNames.clear();
    }

    private void separateNames(String[] names) {
        boolean foundNullName = false;
        for (String name : names) {
            if (Objects.isNull(name)) {
                foundNullName = true;
            } else if (isShouted(name)) {
                shoutedNames.add(name);
            } else {
                normalNames.add(name);
            }
        }
        if (names.length == 0 || foundNullName) {
            normalNames.add("my friend");
        }
    }

    private StringBuilder concatNames(ArrayList<String> names) {
        StringBuilder concat = new StringBuilder();
        int i = 0;
        while (i < names.size()) {
            if (!loopFirst(i)) {
                if (loopLast(i, names.size())) {
                    concat.append(" and ");
                } else {
                    concat.append(", ");
                }
            }
            concat.append(names.get(i));
            i++;
        }
        return concat;
    }

    private String formatGreeting(StringBuilder normalConcat, StringBuilder shoutedConcat) {
        StringBuilder output = new StringBuilder();
        if (!normalNames.isEmpty()) {
            output.append("Hello, ").append(normalConcat).append(".");
        }
        if (!shoutedNames.isEmpty()) {
            if (!normalNames.isEmpty()) {
                output.append(" AND ");
            }
            output.append("HELLO ").append(shoutedConcat.toString().toUpperCase()).append("!");
        }
        return output.toString();
    }

    protected boolean isShouted(String name) {
        return name.equals(name.toUpperCase());
    }
    protected boolean loopFirst(int i) {
        return i == 0;
    }
    protected boolean loopLast(int i, int size) {
        return i == size - 1;
    }
}
