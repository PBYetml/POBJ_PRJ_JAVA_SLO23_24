import java.lang.*;
import java.util.Arrays;

import ConversionBCD.e_CodageBinaire;

//- ATTENTION :  la class ConversionBCD doit hériter la class parent 
public class ConversionBCD extends Conversion  //  Hérite de la classe parent 
{
	
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
		super(); // Appel de constructeur par défaut de la classe ConversionBCD, car il hérite de la classe Conversion
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
	}
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: ConversionBCD => constructeur non surchargé 
	// Entrée				: choixCodage -> tyoe codageBinaire -> choixCodage
	//						  valUser	  -> float 
	// Sortie				: 
	// Description			: constructeur 
	// Date modfification	: le 03.06.2024 
	// Remarque				: voir commentaire
	//----------------------------------------------------------------------------------//
	public ConversionBCD(codageBinaire choixCodage, float valUser) { // Redéfinir la méthode 
	
		
		if (choixCodage == codageBinaire.BCD) {
			CalculerNbrDigitEntier(valUser);  // Sur la donnée il est écrit après, cependant il faut le mettre avant 
            
            // Création d'un tableau dynamique via pointeur
			m_tBDigitEntier = new byte[m_nbrDigitValEntier];
            
            RecupererDigitEntier(valUser);
            ConversionBinaire();
		}
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		//-- relation avec le constructeur parents 
		
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
		
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			
			//-- appel de la méthode : RecupererDigitEntier => récuperation de chaque digit entier --//
			
			//-- appel de la méthode : ConversionBinaire --// 
	}
	
	//-- destructeur --// 
	public void finalize() {}  //Destructeur en java 
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: CalculerNbrDigitEntier 
	// Entrée				: valUser		-> float		 
	// Sortie				: 
	// Description			: détermine le nb de digit d'un nombre entier 
	// Date modfification	: le 03.06.2024 
	// Remarque				: méthode héritée - polymorphisme 
	//----------------------------------------------------------------------------------//
	private void CalculerNbrDigitEntier(float valUser) 
	{
		 byte compteurBoucle = 0;
	        int valEntiere = (int) valUser;
	        
	        while (valEntiere != 0) {
	            valEntiere /= 10;   // valEntiere = valEntiere / 10;
	            compteurBoucle++;
	        }

	        m_nbrDigitValEntier = (byte)compteurBoucle; // m_nbrDigitMaxValEntier contient le nombre de chiffres que l'utilisateur rentre
		
		//-- déclaration de variable --// 
		
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
		
			//-- division de la valeur entière par des puissance de 10 : 10^0 => (1), 10^1 => (10), 10^2 => (100) ..
			//-- calculer le facteur de 10 
			
			//-- MAJ de la valeur entière en fct du facteur 10
			 
			
			//-- MAJ du Digit => incrément de 1 --//
			 
		
		//-- MAJ nb de digit MAx --//

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
	private void RecupererDigitEntier(float valUser) 
	{
		
		//-- déclaration variables --//
		int diviseur;
        int chiffre;
        int indexChiffre;

        
        // Itération pour remplir le tableau de digits
        for (indexChiffre = 0; indexChiffre < m_nbrDigitValEntier; indexChiffre++) {  // m_nbrDigitMaxValEntier récupère le nombre de chiffre que les gens rentre 
            diviseur = (int) Math.pow(10, (super.m_nbrDigitValEntier - (indexChiffre + 1)));  // pour savoir si on divise par 100, 10 ou 1 
            chiffre = (int) (valUser / diviseur); 
            m_tBDigitEntier[indexChiffre] = (byte)chiffre; 
            valUser = valUser - (chiffre * diviseur); // 
        }
		
		//-- ITERATION pour remplir le tb de digit --// 

			//-- MAJ facteur de puissance de 10 --// 
			
			//-- MAJ tableau de digits --// 
			
			//-- MAJ valUser --// 
			
			
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
	private void ConversionBinaire() 
	{
		// Problème de conversion, le premier "paquet" ne fonctionne pas correctement ?

	    	//-- Creation du tableau dynamique de string en fct des digits entier --// 
		 m_tbBinaire = new String[m_nbrDigitValEntier];
	    	
	    	for (int i = 0; i < m_nbrDigitValEntier; i++)  //le i c'est pour itération de la boucle for :)
	    	{
	    		String binaire = "";  //sinon ça vaut null 
	    		int chiffre = m_tBDigitEntier[i];

	    		while (chiffre!= 0) {
	                int bit = chiffre % 2;
	                binaire = bit + binaire;
	                chiffre = chiffre / 2;
	            }
	            
	            // J'ai dû ajouter des "0" sur la gauche pour compléter les 4 bits 
	            while (binaire.length() < 4) {
	                binaire = "0" + binaire;
	            }
	            
	            m_tbBinaire[i] = binaire; 
	    	}
		
		//-- déclaration de variables --// 
		
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
		
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		
		//-- ITERATION d'itération pour pour chaque digit --// 

			//-- récupère la valeur du digit à convertir --// 

			
			//-- ITERATION de conversion  --//

				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				 
				
				//-- MAJ de la valeur à convertir --//
				
				//-- utilisation  de la table ASCII --//  
				
 	
		
	}
}
