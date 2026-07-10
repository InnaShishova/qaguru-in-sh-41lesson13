import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class RegistrationTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test

    void fillFormTest() {

        textBoxPage.openPage()
                .removeBanners()
                .setFullName("Masha")
                .setEmail("test1@test2.com")
                .setCurrentAddress("Samara, Lenina street")
                .setPermanentAddress("Lenina street")
                .submit()
                .checkResult(
                        "Masha",
                        "test1@test2.com",
                        "Samara, Lenina street",
                        "Lenina street");
    }
}