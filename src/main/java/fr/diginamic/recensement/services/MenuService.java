package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.exception.ScannerInputException;
import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe représentant un service
 *
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * Méthode abstraite de traitement que doivent posséder toutes les méthodes de
	 * services
	 *
	 * @param recensement  lignes du fichier
	 * @param scanner scanner
	 * @throws ScannerInputException Erreur sur l'entrée de données via le scanner
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws ScannerInputException;
}