import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends BaseTest {

    @Test
    public void tst() {
        open("/automation-practice-form");
        $("#firstName").setValue("First");
        $("#lastName").setValue("Last");
        $("#userEmail").setValue("e-mail@ya.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9201111234");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1982");
        $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("subj");

        $x("//label[@for='hobbies-checkbox-1']").click();
        $x("//label[@for='hobbies-checkbox-2']").click();

        $("#uploadPicture").uploadFromClasspath("111.jpg");

        $("#currentAddress").setValue("Some Address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("First Last"),
                text("e-mail@ya.ru"), text("Male"), text("9201111234"), text("Some Address"), text("Haryana"), text ("Karnal"));

        sleep(5000);
    }
}
