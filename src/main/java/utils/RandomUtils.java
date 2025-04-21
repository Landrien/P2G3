package utils;

/**
 * Classe pour générer des données aléatoires.
 */
public class RandomUtils
{
    /**
     * Génère une adresse e-mail temporaire.
     *
     * @return Une adresse e-mail basée sur l'horodatage actuel.
     */
    public static String getRandomEmail()
    {
        return "test." + System.currentTimeMillis() + "@yopmail.com";
    }
}
