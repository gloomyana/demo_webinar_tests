package ru.gloomyana.mobile.tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    String passwordRecoveryPageTitle = "Enter your email address",
            emailSentPageTitle = "A message has been sent to you containing instructions",
            eventPageTitle = "There are no events scheduled for that day Find out what's next",
            loginPageTitle = "Webinar",
            editUserPageTitle = "Edit profile",
            userEmail = "qa.guru-student@gmail.com",
            userPassword = "rot3c#754P3V",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            companyName = faker.company().name(),
            position = faker.company().profession(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10);
}
