import java.lang.*;
import java.util.Arrays;

//- ATTENTION :  la class ConversionBCD doit hériter la class parent 
public class ConversionBCD extends Conversion 
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
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
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
	public  ConversionBCD(codageBinaire choixCodage, float valUser )
	{
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		//-- relation avec le constructeur parents 
		
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
		 if(choixCodage == codageBinaire.BCD )
		 {
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			  byte m_tBDigitEntier[] = {m_nbrDigitValEntier};
			  
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			  CalculerNbrDigitEntier(valUser);
			  
			//-- appel de la méthode : RecupererDigitEntier => récuperation de chaque digit entier --//
			  RecupererDigitEntier(valUser);
			//-- appel de la méthode : ConversionBinaire --//
			 
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
	@Override protected void CalculerNbrDigitEntier(float valUser) 
	{
		//-- déclaration de variable --// 
		int valEntier = Math.round(valUser); // Conversion d'un float en un entier
		byte m_nbrDigit = 0; // Initialisation du nombre de chiffres à 0
		
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
	    // Itération pour déterminer le nombre de chiffres
		
	    while (valEntier != 0)
	    {
	        // Calcul du facteur de 10
	        int facteur10 = 1;
	        for (int i = 1; i <= m_nbrDigit; i++)
	        {
	            facteur10 *= 10;
	        }
	        
	        // Mise à jour de la valeur entière en fonction du facteur de 10
	        valEntier = valEntier % facteur10;

	        // Incrémentation du nombre de chiffres
	        m_nbrDigit++;
	    }
	    
	    // Mise à jour du nombre maximum de chiffres
	    m_nbrDigitValEntier = m_nbrDigit;
		

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
	  @Override protected void RecupererDigitEntier (float valUser) 
	{
		//-- déclaration variables --//
		int valuser_transition;
		
		
		valuser_transition = (int)valUser;
		
		//-- itération pour remplire le tableau de digit --//

		for (int i = 0; i < m_nbrDigitValEntier; i++)
		{
			//recuperation du digite puis sauvegadre dans le tableau dans la case correspondnate

			m_tBDigitEntier[i] = (byte) ((valuser_transition % 10) * 10);

			//mise a jour de la valeur entière a sauvegardé
			valuser_transition = (valuser_transition / 10);
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
		
		int valeur, reste ; 
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
		
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		//m_tbBinaire = "0";
		
		//-- ITERATION d'itération pour pour chaque digit --// 
		
		for (int i = 0; i < m_nbrDigitValEntier; i++)
		{
			
			
			valeur  = m_tBDigitEntier[i];
			
		    while (valeur > 0)
		    {
		        reste = valeur / 2;
		        
		        if( reste !=0) 
		        {
		        	m_tbBinaire[i] += '1';
		        	
		        }
		        else
		        {
		        	m_tbBinaire[i] += '0';
		        }
		        
		        valeur = valeur - reste;   	
		    }

		} 
		
		

			//-- récupère la valeur du digit à convertir --// 

			
			//-- ITERATION de conversion  --//

				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				 
				
				//-- MAJ de la valeur à convertir --//
				
				//-- utilisation  de la table ASCII --//  
				
 	
		
	}
}
