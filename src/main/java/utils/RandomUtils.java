package utils;

public class RandomUtils
{
    public static String getRandomEmail()
    {
        return "test." + System.currentTimeMillis() + "@yopmail.com";
    }
}
