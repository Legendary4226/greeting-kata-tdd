import java.util.ArrayList;
import java.util.Objects;

public class GreetingKata {

    private boolean foundNullName = false;
    private final ArrayList<String> normalNames = new ArrayList<>();
    private final ArrayList<String> shoutedNames = new ArrayList<>();

    public String greet(String... names) {
        reset();

        separateNames(names);
        if (names.length == 0 || foundNullName) {
            normalNames.add("my friend");
        }

        return formatGreeting(
            concatNames(normalNames),
            concatNames(shoutedNames)
        );
    }

    public void reset() {
        foundNullName = false;
        normalNames.clear();
        shoutedNames.clear();
    }

    private void separateNames(String[] names) {
        for (String name : names) {
            if (Objects.isNull(name)) {
                foundNullName = true;
                continue;
            }
            boolean isEscaped = isEscaped(name);
            if (!isEscaped && hasComma(name)) {
                separateNames(name.split(","));
                continue;
            }

            if (isEscaped) {
                addNameToProperList(name.replace("\"", ""));
            } else {
                addNameToProperList(name);
            }
        }
    }

    private void addNameToProperList(String name) {
        if (isShouted(name)) {
            shoutedNames.add(name.trim());
        } else {
            normalNames.add(name.trim());
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
    protected boolean hasComma(String name) {
        return name.contains(",");
    }
    protected boolean isEscaped(String name) {
        return name.matches("^\\\".*.\\\"$");
    }
}
