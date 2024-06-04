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
	// Entrée				: choixCodage -> type codageBinaire -> choixCodage
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
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			CalculerNbrDigitEntier(valUser);
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			m_tBDigitEntier = new byte[m_nbrDigitValEntier];
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

	protected void CalculerNbrDigitEntier(float valUser) 
	{
		//-- déclaration de variable --// 
		
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
		while((int)valUser != 0)
		{
			m_nbrDigitValEntier++;
			valUser /= 10;
		}
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
	protected void RecupererDigitEntier(float valUser) 
	{
		//-- déclaration variables --//
		int scanValue = 0;
		int powerScan = (int) Math.pow(10,m_nbrDigitValEntier-1);
		
		//-- ITERATION pour remplir le tb de digit --// 
		for(scanValue = 0; scanValue < m_nbrDigitValEntier; scanValue++)
		{
			//-- MAJ tableau de digits --// 
			m_tBDigitEntier[scanValue]= (byte)(((int)valUser/powerScan) % 10);
			//-- MAJ valUser --// 
			powerScan /= 10;
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
	protected void ConversionBinaire() 
	{
		//-- déclaration de variables --//
		int scanValue = 0;
		int scanBinary = 0;
		int digitValue = 0;
		
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
		m_tbBinaire = new String[m_nbrDigitValEntier];
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		for(scanValue = 0; scanValue < m_nbrDigitValEntier; scanValue++)
			m_tbBinaire[scanValue] = "";
		//-- ITERATION d'itération pour pour chaque digit --// 
		for(scanValue = 0; scanValue < m_nbrDigitValEntier; scanValue++)
		{
			//-- récupère la valeur du digit à convertir --// 
			digitValue = m_tBDigitEntier[scanValue];
			//-- ITERATION de conversion  --//
			for(scanBinary = 0; scanBinary < 4; scanBinary++)
			{
				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				m_tbBinaire[scanValue] += (char)((digitValue&0x01)+0x30);
				
				//-- MAJ de la valeur à convertir --//
				digitValue = digitValue >> 1;
				//-- utilisation  de la table ASCII --//
			}
				  
				
		}
			
 	
		
	}
}
