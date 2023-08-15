package utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class RandomUtils {

    public static String generateRandomMobileNumber() {
        int mobileNumberLength = 10;
        String generatedMobileNumber = RandomStringUtils.randomNumeric(mobileNumberLength);
        LogUtils.getLogger().info("Created random mobile number: " + generatedMobileNumber);
        return generatedMobileNumber;
    }

    public static String generateRandomEmail() {
        int maxEmailNameLength = 20;
        int generatedEmailLength = (int) (5 + Math.random() * maxEmailNameLength);
        String generatedRandomEmailName = RandomStringUtils.randomAlphabetic(generatedEmailLength).toLowerCase();
        String generatedRandomEmail = generatedRandomEmailName + "@google.com";
        LogUtils.getLogger().info("Created random email: " + generatedRandomEmail);
        return generatedRandomEmail;
    }

    public static String generateRandomName() {
        int maxNameLength = 20;
        int generatedNameLength = (int) (3 + Math.random() * maxNameLength);
        String generatedRandomName = RandomStringUtils.randomAlphabetic(generatedNameLength).toLowerCase();
        String randomName = StringUtils.capitalize(generatedRandomName);
        LogUtils.getLogger().info("Created random name: " + randomName);
        return randomName;
    }

    public static String generateRandomPassword() {
        int maxPasswordLength = 25;
        int generatedPasswordLength = (int) (6 + Math.random() * maxPasswordLength);
        String generatedRandomPassword = RandomStringUtils.randomAlphanumeric(generatedPasswordLength);
        LogUtils.getLogger().info("Created random password: " + generatedRandomPassword);
        return generatedRandomPassword;
    }




}
