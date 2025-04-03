package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.exception.ScannerInputException;
import org.apache.commons.lang3.math.NumberUtils;

public class UserInputValidator
{
    /**
     * Nettoie le string pour validation avec .trim().replace(" ", "")
     *
     * @param scanner user input
     * @return un string nettoyé pour validation
     */
    public static String cleanStringForIntValidation(String scanner)
    {
        return scanner = scanner.trim().replace(" ", "");
    }

    /**
     * Valide si le champs est bien un convertible en un Int valide pour la logique de l'application (positif entre 1 et 1000)
     *
     * @param scanner user input
     * @return user input
     * @throws ScannerInputException if input is invalid
     */
    public static String validateInt(String scanner) throws ScannerInputException
    {
        scanner = cleanStringForIntValidation(scanner);
        if (scanner.equalsIgnoreCase("2a") | scanner.equalsIgnoreCase("2b"))
        {
            return scanner;
        }
        if (!NumberUtils.isDigits(scanner))
        {
            throw new ScannerInputException("Le champs doit etre renseigné par un nombre");
        }

        if (Integer.parseInt(scanner) < 1 | Integer.parseInt(scanner) > 999)
        {
            throw new ScannerInputException("Le champs doit etre un entier positif compris entre 1 et 999");
        } else
        {
            return scanner;
        }
    }

    public static String validateString(String scanner) throws ScannerInputException
    {
        scanner = cleanStringForIntValidation(scanner);
        if (scanner.equals("2A") | scanner.equals("2B"))
        {
            return scanner;
        }
        if (!NumberUtils.isDigits(scanner))
        {
            throw new ScannerInputException("Le champs doit etre renseigné par un nombre");
        }
        return scanner;
    }
}