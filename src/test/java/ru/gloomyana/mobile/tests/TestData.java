package ru.gloomyana.mobile.tests;

import com.github.javafaker.Faker;
import lombok.Setter;
import org.aeonbits.owner.ConfigFactory;
import ru.gloomyana.mobile.config.GetDataConfig;

public class TestData {
    Faker faker = new Faker();
    GetDataConfig config = ConfigFactory.create(GetDataConfig.class, System.getProperties());

    @Setter
    String firstName, lastName, email, companyName, position, phoneNumber;

    public void GenerateUserEmail() {
        setEmail(faker.internet().emailAddress());
    }

    public void GenerateUserData() {
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setEmail(faker.internet().emailAddress());
        setCompanyName(faker.company().name());
        setPosition(faker.company().profession());
        setPhoneNumber(faker.phoneNumber().subscriberNumber(10));
    }
}
