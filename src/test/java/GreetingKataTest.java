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
    }

    @Test
    public void takeUpperCaseBob_shouldGreetBobByShoutingBack() {
        Assert.assertEquals("HELLO BOB!", greetingKata.greet("BOB"));
    }

    @Test
    public void takeBobAndJane_shouldGreetBobAndJane() {
        Assert.assertEquals("Hello, Bob and Jane.", greetingKata.greet("Bob", "Jane"));
    }
}
