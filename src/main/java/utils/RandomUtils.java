package utils;


public class RandomUtils
{
    /**
     * Generates a random email address by appending the current system time in milliseconds
     * to a fixed string and adding the "@gmail.com" domain.
     * @return A randomly generated email address.
     */
    public static String getRandomEmail()
    {
        return "test." + System.currentTimeMillis() + "@gmail.com";
    }
}
