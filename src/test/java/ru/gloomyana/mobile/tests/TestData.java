package ru.gloomyana.mobile.tests;

import com.github.javafaker.Faker;
import org.aeonbits.owner.ConfigFactory;
import ru.gloomyana.mobile.config.GetDataConfig;

public class TestData {
    Faker faker = new Faker();
    GetDataConfig config = ConfigFactory.create(GetDataConfig.class, System.getProperties());

    String firstName, lastName, email, companyName, position, phoneNumber;

    public void GenerateUserEmail() {
        email = faker.internet().emailAddress();
    }

    public void GenerateUserData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        companyName = faker.company().name();
        position = faker.company().profession();
        phoneNumber = faker.phoneNumber().subscriberNumber(10);
    }
}
