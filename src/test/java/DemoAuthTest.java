import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoAuthTest {

    @Test
    public void shouldAuthTest() {
        open("https://www.demoblaze.com/index.html");
        $("#login2").click();
        $("#logInModal").shouldBe(Condition.visible);
        $("#loginusername").sendKeys("4test4");
        $("#loginpassword").sendKeys("4test4");
        $("#logInModal .modal-footer .btn-primary").click();
        $("#nameofuser").shouldHave(Condition.text("4test4"));
    }

    @Test
    @Disabled
    public void shouldNotAuthTest() {
        Faker faker = new Faker();

        open("https://www.demoblaze.com/index.html");
        $("#login2").click();
        $("#logInModal").shouldBe(Condition.visible);
        $("#loginusername").sendKeys(faker.name().firstName());
        $("#loginpassword").sendKeys(faker.internet().password());
        $("#logInModal .modal-footer .btn-primary").click();
        //TODO check modal window
    }
}
