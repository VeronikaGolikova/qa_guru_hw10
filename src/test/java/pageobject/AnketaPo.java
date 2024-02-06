package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class AnketaPo {

    private final SelenideElement
            firstNameInput = $x("//*[@data-test-id='firstName']//input"),
            lastNameInput = $x("//*[@data-test-id='lastName']//input"),
            middleNameInput = $x("//*[@data-test-id='middleName']//input"),
            passportBirthDateInput = $x("//*[@data-test-id='passportBirthDate']//input"),
            userPhoneInput = $x("//*[@data-test-id='phone']//input"),
            genderFemaleButton = $x("//*[@data-test-id='female-gender-button']"),
            genderMaleButton = $x("//*[@data-test-id='male-gender-button']"),
            submitButton = $x("//*[@data-test-id='finish-first-step-button']"),
            popupHeader = $x("//*[contains(@data-test-id,'sms-confirmation-modal')]//h3");

    public AnketaPo openPage() {
        open("alfaform-dc-short-ui/");
        return this;
    }

    public AnketaPo setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AnketaPo setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AnketaPo setMiddleName(String value) {
        middleNameInput.setValue(value);
        return this;
    }

    public AnketaPo setMaleGender() {
        genderMaleButton.click();
        return this;
    }

    public AnketaPo setFemaleGender() {
        genderFemaleButton.click();
        return this;
    }

    public AnketaPo setGender(String gender) {
        if (gender.equals("M")){
            setMaleGender();
            return this;
        }
        if (gender.equals("F")){
            setFemaleGender();
            return this;
        }
        return this;
    }

    public AnketaPo setPassportBirthDate(String value) {
        passportBirthDateInput.setValue(value);
        return this;
    }

    public AnketaPo setPhoneNumber(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    public AnketaPo submit() {
        submitButton.click();
        return this;
    }

    public AnketaPo lastNameHasValue(String value) {
        lastNameInput.shouldHave(value(value));
        return this;
    }

    public AnketaPo popupAppeared() {
        popupHeader.shouldBe();
        return this;
    }
}
