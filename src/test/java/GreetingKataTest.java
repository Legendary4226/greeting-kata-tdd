import org.junit.Assert;
import org.junit.Test;

public class GreetingKataTest {

    GreetingKata greetingKata = new GreetingKata();

    @Test
    public void takeBob_shouldGreetBob() {
        Assert.assertEquals("Hello, Bob.", greetingKata.greet("Bob"));
    }

    @Test
    public void takeNoName_shouldGreetMyFriend() {
        Assert.assertEquals("Hello, my friend.", greetingKata.greet());
        Assert.assertEquals("Hello, my friend.", greetingKata.greet((String) null));
    }

    @Test
    public void takeUpperCaseBob_shouldGreetBobByShoutingBack() {
        Assert.assertEquals("HELLO BOB!", greetingKata.greet("BOB"));
    }

    @Test
    public void takeBobAndJane_shouldGreetBobAndJane() {
        Assert.assertEquals(
            "Hello, Bob and Jane.",
            greetingKata.greet("Bob", "Jane")
        );
    }

    @Test
    public void takeBobJaneAndJill_shouldGreetBobJaneAndJill() {
        Assert.assertEquals(
            "Hello, Bob, Jane and Jill.",
            greetingKata.greet("Bob", "Jane", "Jill")
        );
    }

    @Test
    public void mixNormalAndShoutedNames_shouldGreetSeparately() {
        Assert.assertEquals(
            "Hello, Amy and Charlotte. AND HELLO BRIAN!",
            greetingKata.greet("Amy", "BRIAN", "Charlotte")
        );
        Assert.assertEquals(
            "Hello, Amy and Charlotte. AND HELLO BRIAN!",
            greetingKata.greet("Amy", "Charlotte", "BRIAN")
        );
        Assert.assertEquals(
            "Hello, Amy and Charlotte. AND HELLO BOB AND BRIAN!",
            greetingKata.greet("BOB", "Amy", "Charlotte", "BRIAN")
        );
        Assert.assertEquals(
            "Hello, Amy and Charlotte. AND HELLO BOB, JILL AND BRIAN!",
            greetingKata.greet("BOB", "Amy", "Charlotte", "JILL", "BRIAN")
        );
    }

    @Test
    public void nameWithComma_shouldBeConsideredAsAnInput() {
        Assert.assertEquals(
            "Hello, Bob and Jane. AND HELLO DIANA!",
            greetingKata.greet("Bob", "DIANA,Jane")
        );
        Assert.assertEquals(
            "Hello, Bob and Jane. AND HELLO DIANA!",
            greetingKata.greet("Bob", "DIANA  ,  Jane")
        );
    }

    @Test
    public void nameEscapedLikeCSVField_shouldNotBeConsideredAsAnInput() {
        Assert.assertTrue(greetingKata.isEscaped("\"Charlie, Dianne\""));
        Assert.assertFalse(greetingKata.isEscaped("\"Charlie, D\"ianne"));
        Assert.assertFalse(greetingKata.isEscaped("Char\"lie, D\"ianne"));
        Assert.assertFalse(greetingKata.isEscaped("Char\"lie, Dianne\""));

        Assert.assertEquals(
            "Hello, Bob and Charlie, Dianne.",
            greetingKata.greet("Bob", "\"Charlie, Dianne\"")
        );
    }
}
