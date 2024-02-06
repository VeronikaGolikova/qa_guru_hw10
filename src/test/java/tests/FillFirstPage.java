package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pageobject.AnketaPo;

public class FillFirstPage extends TestBase {

    AnketaPo anketaPo = new AnketaPo();
    @ParameterizedTest(name = "Ввести в поле фамилия значение {0}")
    @ValueSource(strings = {"Иванов", "Петров", "Сидоров"})
    void parametrizedTestLastNameInputSource(String lastname) {
        anketaPo.openPage();
        anketaPo.setLastName(lastname);
        anketaPo.lastNameHasValue(lastname);
    }

    @ParameterizedTest(name = "Заполнить первый шаг анкеты разными значениями из CsvSource")
    @CsvSource(value = {
            "Иванов, Иван, Иванович, 10.10.2000, +79090834736, M",
            "Николенко, Юлия, Сергеевна, 21.10.1998, +79090834777, F"})
    void parametrizedTestCsv(
            String lastname, String firstname, String middlename, String birth, String phoneNumber, String gender) {
        anketaPo.openPage();
        anketaPo.setLastName(lastname);
        anketaPo.setFirstName(firstname);
        anketaPo.setMiddleName(middlename);
        anketaPo.setPassportBirthDate(birth);
        anketaPo.setPhoneNumber(phoneNumber);
        anketaPo.setGender(gender);
        anketaPo.submit();
        anketaPo.popupAppeared();
    }

    @ParameterizedTest(name = "Заполнить первый шаг анкеты разными значениями из файла")
    @CsvFileSource(resources = "/testData/parametrizedTestCsvFile.csv")
    void parametrizedTestCsvFile(
            String lastname, String firstname, String middlename, String birth, String phoneNumber, String gender) {
        anketaPo.openPage();
        anketaPo.setLastName(lastname);
        anketaPo.setFirstName(firstname);
        anketaPo.setMiddleName(middlename);
        anketaPo.setPassportBirthDate(birth);
        anketaPo.setPhoneNumber(phoneNumber);
        anketaPo.setGender(gender);
        anketaPo.submit();
        anketaPo.popupAppeared();
    }
}
