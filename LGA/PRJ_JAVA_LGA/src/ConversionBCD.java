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
	ConversionBCD()
	{
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
	ConversionBCD(codageBinaire choixCodage, float valUser)
	{
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		//-- relation avec le constructeur parents 
		
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
		if(choixCodage == codageBinaire.BCD)
		{
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			m_tBDigitEntier = new byte[m_nbrDigitValEntier];
			
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			CalculerNbrDigitEntier(valUser);
			//-- appel de la méthode : RecupererDigitEntier => récuperation de chaque digit entier --//
			RecupererDigitEntier(valUser);
			//-- appel de la méthode : ConversionBinaire --// 
			ConversionBinaire();	
		}
	}
	
	//-- destructeur --// 
	public void finalize() {}
	
	
	//----------------------------------------------------------------------------------//
	// Nom de la méthode	: CalculerNbrDigitEntier 
	// Entrée				: valUser		-> float		 
	// Sortie				: 
	// Description			: détermine le nb de digit d'un nombre entier 
	// Date modfification	: le 03.06.2024 
	// Remarque				: méthode héritée - polymorphisme 
	//----------------------------------------------------------------------------------//
	@Override
	protected void CalculerNbrDigitEntier(float valUser) 
	{
		//-- déclaration de variable --// 
		int valUserEntier = 0;
		int cntDigits = 0;
		
		valUserEntier = (int)valUser;
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
		while(valUserEntier != 0)
		{
			valUserEntier = valUserEntier / 10;
			cntDigits++;
		}
		m_nbrDigitValEntier = (byte)cntDigits;
		
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
	@Override
	protected void RecupererDigitEntier(float valUser) 
	{
		//-- déclaration variables --//
		int indexValeurUser = 0;
		int valEntier = (int)valUser;
		int chiffre = 0;
		double diviseur = 0;
		m_tBDigitEntier = new byte[m_nbrDigitValEntier];
		
		//-- ITERATION pour remplir le tb de digit --// 
		for(indexValeurUser = 0; indexValeurUser < m_nbrDigitValEntier; indexValeurUser++)
		{
			diviseur = (int)Math.pow(10, (m_nbrDigitValEntier - (indexValeurUser + 1)));
			
			chiffre = (valEntier / (int)diviseur);
			
			m_tBDigitEntier[indexValeurUser] = (byte) chiffre;
			
			valEntier = valEntier - (int)diviseur;
		}

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
		//-- déclaration de variables --//
		m_tbBinaire = new String[m_nbrDigitValEntier];
		int chiffreToConvert;
		float reste;
		
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
		
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		
		//-- ITERATION d'itération pour pour chaque digit --// 
		for(int i = 0; i < m_nbrDigitValEntier; i++)
		{
			chiffreToConvert = m_tBDigitEntier[i];
			m_tbBinaire[i] = "";
			
			while(chiffreToConvert != 0)
			{
				reste = (float)chiffreToConvert % 2;
				m_tbBinaire[i] = m_tbBinaire[i] + Integer.toString((int) reste); 
				chiffreToConvert = chiffreToConvert / 2;
			}
		}

			//-- récupère la valeur du digit à convertir --// 

			
			//-- ITERATION de conversion  --//

				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				 
				
				//-- MAJ de la valeur à convertir --//
				
				//-- utilisation  de la table ASCII --//  
				
 	
		
	}
}
