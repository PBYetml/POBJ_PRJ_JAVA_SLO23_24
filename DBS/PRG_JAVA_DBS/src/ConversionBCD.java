import java.lang.*;
import java.util.Arrays;

// ATTENTION: la classe ConversionBCD doit hériter de la classe parente
public class ConversionBCD extends Conversion {

   
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: ConversionBCD => constructeur non surchargé 
	// Entrée				: 
	// Sortie				: 
	// Description			: constructeur 
	// Date modfification	: le 03.06.2024 
	// Remarque				: implémenter une méthode spécifique pour realiser la 
	//						  relation avec la class parent 
	//----------------------------------------------------------------------------------//
	public ConversionBCD()
	{
		super(); // Appel au constructeur de la classe parente
	}
	
    
    //----------------------------------------------------------------------------------//
    // Nom de la méthode  : ConversionBCD => constructeur non surchargé
    // Entrée             : 
    // Sortie             : 
    // Description        : Constructeur
    // Date de modification: 03/06/2024
    // Remarque           : Implémenter une méthode spécifique pour établir la relation
    //                      avec la classe parente
    //----------------------------------------------------------------------------------//
    public ConversionBCD(float valUser) 
    {
        super(); // Appel au constructeur de la classe parente

        // Initialiser un tableau de 10 octets pour les chiffres BCD
        m_tBDigitEntier = new byte[10];

        // Calculer le nombre de chiffres entiers
        calculerNbrDigitEntier(valUser);

        // Extraire les chiffres entiers et les convertir en BCD
        recupererDigitEntier(valUser);

        // ConversionBinaire (à implémenter selon vos besoins)
        conversionBinaire(); 
    }
    
	//-- destructeur --// 
	public void finalize() 
	{
		
	}

    //----------------------------------------------------------------------------------//
    // Nom de la méthode  : CalculerNbrDigitEntier
    // Entrée             : valeurUtilisateur -> float
    // Sortie             : 
    // Description        : Détermine le nombre de chiffres d'un nombre entier
    // Date de modification: 03/06/2024
    // Remarque           : Méthode héritée - polymorphisme
    //----------------------------------------------------------------------------------//
    private void calculerNbrDigitEntier(float valUser) {
        // Code pour calculer le nombre de chiffres entiers de la valeur décimale fournie
        // et stocker le résultat dans m_nbrDigitValEntier

        int valeurEntiere = (int) valUser;
        int nombreChiffre = 0;

        while (valeurEntiere > 0) {
            valeurEntiere /= 10;
            nombreChiffre++;
        }

        m_nbrDigitValEntier = (byte) nombreChiffre;
    }

    //----------------------------------------------------------------------------------//
    // Nom de la méthode  : RecupererDigitEntier
    // Entrée             : valeurUtilisateur -> float
    // Sortie             : 
    // in-out             : 
    // Description        : Détermine la valeur de chaque chiffre et l'enregistre dans un tableau
    // Date de modification: 03/06/2024
    // Remarque           : 
    //----------------------------------------------------------------------------------//
    private void recupererDigitEntier(float valUser) {
        // Code pour extraire les chiffres entiers de la valeur décimale fournie
        // et les stocker dans le tableau m_tBDigitEntier

        int valeurEntiere = (int) valUser;
        int i = 0;

        while (valeurEntiere > 0) {
            m_tBDigitEntier[i] = (byte) (valeurEntiere % 10);
            valeurEntiere /= 10;
            i++;
        }
    }

    //----------------------------------------------------------------------------------//
    // Nom de la méthode  : ConversionBinaire
    // Entrée             : 
    // Sortie             : 
    // in-out             : 
    // Description        : Convertir une valeur décimale selon les attributs de la classe parente
    // Date de modification: 03/06/2024
    // Remarque           : 
    //----------------------------------------------------------------------------------//
 // ... code précédent ...
    private void conversionBinaire() {
        // Code pour convertir chaque chiffre BCD en sa représentation binaire
        // et stocker les chaînes binaires converties dans m_tbBinaire

        byte valeurDigit;
        int i, j;
        char[] chaineBinaire;

        for (i = 0; i < m_nbrDigitValEntier; i++) {
            valeurDigit = m_tBDigitEntier[i];
            chaineBinaire = new char[8]; // Longueur maximale pour un octet en binaire
            j = chaineBinaire.length - 1;

            while (valeurDigit > 0) {
                chaineBinaire[j] = (char) ((valeurDigit % 2) + '0');
                valeurDigit /= 2;
                j--;
            }

            m_tbBinaire[i] = new String(chaineBinaire).trim(); // Supprimer les zéros non significatifs
        }
    }
}
