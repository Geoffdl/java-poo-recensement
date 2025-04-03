package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.diginamic.recensement.exception.ScannerInputException;
import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;
import fr.diginamic.recensement.utils.UserInputValidator;

/**
 * Affichage des N départements les plus peuplés
 *
 * @author DIGINAMIC
 */
public class RechercheDepartementsPlusPeuplees extends MenuService
{

    @Override
    public void traiter(Recensement recensement, Scanner scanner) throws ScannerInputException
    {

        System.out.println("Veuillez saisir un nombre de départements:");
        String nbDeptsStr = scanner.nextLine().trim().toLowerCase().replace(" ", ""); // pré-traitement avant validation

        //Verification de la validitié des données
        nbDeptsStr = UserInputValidator.validateInt(nbDeptsStr);


        int nbDepts = 0;
        if (!nbDeptsStr.equalsIgnoreCase("2a") || !nbDeptsStr.equalsIgnoreCase("2b"))
        {

             nbDepts = Integer.parseInt(nbDeptsStr);
        }



        List<Ville> villes = recensement.getVilles();
        Map<String, Departement> mapDepts = new HashMap<>();

        for (Ville ville : villes)
        {

            Departement departement = mapDepts.get(ville.getCodeDepartement());
            if (departement == null)
            {
                departement = new Departement(ville.getCodeDepartement());
                mapDepts.put(ville.getCodeDepartement(), departement);
            }
            departement.addVille(ville);
        }

        List<Departement> departements = new ArrayList<Departement>();
        departements.addAll(mapDepts.values());

        Collections.sort(departements, new EnsemblePopComparateur(false));

        for (int i = 0; i < nbDepts; i++)
        {
            Departement departement = departements.get(i);
            System.out.println(
                    "Département " + departement.getCode() + " : " + departement.getPopulation() + " habitants.");
        }

    }

}