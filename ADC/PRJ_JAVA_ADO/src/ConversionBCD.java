import java.lang.*;
import java.util.Arrays;
//- ATTENTION :  la class ConversionBCD doit hériter la class parent 
public class ConversionBCD 
{
	private int m_valeurEntier;
    private int m_nbrDigitValEntier;
    private byte[] m_tBDigitEntier;
    private String m_tbBinaire;
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: ConversionBCD => constructeur non surchargé 
	// Entrée				: 
	// Sortie				: 
	// Description			: constructeur 
	// Date modfification	: le 03.06.2024 
	// Remarque				: implémenter une méthode spécifique pour realiser la 
	//						  relation avec la class parent 
	//----------------------------------------------------------------------------------//
	ConversionBCD()
	{
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		super();
	}
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: ConversionBCD => constructeur surchargé 
	// Entrée				: choixCodage -> tyoe codageBinaire -> choixCodage
	//						  valUser	  -> float 
	// Sortie				: 
	// Description			: constructeur 
	// Date modfification	: le 03.06.2024 
	// Remarque				: voir commentaire
	//----------------------------------------------------------------------------------//
	ConversionBCD(int choixCodage, int valUser)
	{
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		//-- relation avec le constructeur parents 
		//new ConversionBCD();
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
		if (choixCodage == choixCodageBinaire.BCD) {
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			CalculerNbrDigitEntier(valUser);
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			m_tBDigitEntier = new byte[10];
			//-- appel de la méthode : RecupererDigitEntier => récuperation de chaque digit entier --//
			RecupererDigitEntier(valUser);
			//-- appel de la méthode : ConversionBinaire --// 
			ConversionBinaire();
		}
	}
	
	//-- destructeur --// 
	void finalize() {}
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: CalculerNbrDigitEntier 
	// Entrée				: valUser		-> float		 
	// Sortie				: 
	// Description			: détermine le nb de digit d'un nombre entier 
	// Date modfification	: le 03.06.2024 
	// Remarque				: méthode héritée - polymorphisme 
	//----------------------------------------------------------------------------------//
	void CalculerNbrDigitEntier(int valUser) 
	{
		//-- déclaration de variable --// 
	    int digit = 0;
	    int facteur10 = 1;
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
	    while (valUser != 0) {
			//-- division de la valeur entière par des puissance de 10 : 10^0 => (1), 10^1 => (10), 10^2 => (100) ..
			//-- calculer le facteur de 10 
	    	valUser /= 10;
			//-- MAJ de la valeur entière en fct du facteur 10
	    	facteur10 *= 10;
			//-- MAJ du Digit => incrément de 1 --//
	    	if (valUser >= facteur10 / 10) { // Correction de la condition
	            digit++;
	        }
	    }
		
		//-- MAJ nb de digit MAx --//
	    this.m_nbrDigitValEntier = digit;
	}
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: RecupererDigitEntier 
	// Entrée				: valUser		-> float 
	// Sortie				: 
	// in-out				: 
	// Description			: détermine la valeur de chaque digit et l'enregistre dans 
	//						  un tableau
	// Date modfification	: le 03.06.2024  
	// Remarque				: 
	//----------------------------------------------------------------------------------//
	void RecupererDigitEntier(float valUser) 
	{
		//-- déclaration variables --//
	    int nbDigit = this.m_nbrDigitValEntier;
	    int facteur10 = 1;
	    int i = 0; 
		//-- ITERATION pour remplir le tb de digit --// 
	    while (nbDigit > 0) {
			//-- MAJ facteur de puissance de 10 --// 
	    	facteur10 *= 10;
			//-- MAJ tableau de digits --// 
	    	this.m_TbDigitEntier[i] = valUser / facteur10;
			//-- MAJ valUser --// 
	    	valUser %= facteur10;
	        // Décrémentation du nombre de digits
	        nbDigit--;
	        i++;
	    }
	} 
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: ConversionBinaire
	// Entrée				: 
	// Sortie				: 
	// in-out				: 
	// Description			: convertir un valeur décimale selon les attributs de la 
	//						  la classe parent 
	// Date modfification	: le 03.06.2024 
	// Remarque				: 
	//----------------------------------------------------------------------------------//
	void ConversionBinaire() 
	{
		//-- déclaration de variables --// 
		int index = 0;
	    int digitBinaire;
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
	    m_tbBinaire = "";
	    for (int i = 0; i < m_tBDigitEntier.length; i++) {
	        m_tbBinaire += "0";
	    }
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		
		//-- ITERATION d'itération pour pour chaque digit --// 
	    for (int digitEntier : m_tBDigitEntier) {
	        // Conversion binaire (modulo 2)
	        digitBinaire = digitEntier % 2;
			//-- récupère la valeur du digit à convertir --// 

			
			//-- ITERATION de conversion  --//

				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				 
				
				//-- MAJ de la valeur à convertir --//
				
				//-- utilisation  de la table ASCII --//  
	       char caractereBinaire = (char) (digitBinaire + '0');
	       m_tbBinaire = m_tbBinaire.substring(0, index) + caractereBinaire + m_tbBinaire.substring(index + 1);
	       index++;
	    }
	}
}
