package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.exception.ScannerInputException;
import fr.diginamic.recensement.utils.UserInputValidator;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'un département
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationDepartementService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ScannerInputException
	{

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		// validation
		choix = UserInputValidator.validateInt(choix);

		List<Ville> villes = rec.getVilles();
		int somme = 0;
		for (Ville ville: villes){
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
			}
		}
		if (somme>0){
			System.out.println("Population du département "+choix+" : "+ somme);
		}
		else {
			System.out.println("Département "+choix+ " non trouvé.");
		}
	}

}