package pageObject;

import org.junit.jupiter.api.Test;
import pageObject.base.TestBase;
import pageObject.page.RegistrationPage;
import testFormQa.random.RandomData;

public class TestFormPage extends TestBase {

    @Test
    void testForm() {

        String firstName = RandomData.randomFirstName();
        String lastName = RandomData.randomLastName();
        String email = RandomData.randomEmail();
        String phone = RandomData.randomPhone();
        String address = RandomData.randomAddress();

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("1")
                .setPhone(phone)
                .setBirthDay("30", "September", "2008")
                .setSubjectContainer("English")
                .setHobbiesCheckbox()
                .uploadFile("fileupload/screenshot.jpg")
                .setAddress(address)
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmitForm();


        new RegistrationPage()
                .verifyModalWindow()
                .verifyResults("Student Name", firstName)
                .verifyResults("Student Email", email)
                .verifyResults("Mobile", phone)
                .verifyResults("Gender", "Male")
                .verifyResults("Date of Birth", "30 September,2008")
                .verifyResults("Address", address)
                .closeModalWindow();

    }
}
