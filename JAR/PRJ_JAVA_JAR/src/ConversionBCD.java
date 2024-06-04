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
		super();
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
		super();
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
		if(choixCodage == codageBinaire.BCD)
		{
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			CalculerNbrDigitEntier(valUser);
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
			private static final byte[] m_tBDigitEntier = new byte[10];
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
	@Override public void CalculerNbrDigitEntier(float valUser) 
	{
		//-- déclaration de variable --// 
		byte countDigits = 0;	// Variable de comptage du nombre d'itération de la boucle
		int valUserEntier = (int) valUser;	// Valeur entière de valUser
		
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
		while (valUserEntier > 0)
		{
			//-- division de la valeur entière par des puissance de 10 : 10^0 => (1), 10^1 => (10), 10^2 => (100) ..
			//-- calculer le facteur de 10 
			
			//-- MAJ de la valeur entière en fct du facteur 10
			valUserEntier = valUserEntier / 10;
			
			//-- MAJ du Digit => incrément de 1 --//
			countDigits++;
		};
		
		//-- MAJ nb de digit MAx --//
		m_nbrDigitValEntier = countDigits;
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
	public void RecupererDigitEntier(float valUser) 
	{
		//-- déclaration variables --//
		byte i = 0;	// Variable de comptage de la boucle
		int valUserEntier = (int)valUser;	// Valeur entière de valUser
		byte digit = 0;
		
		//-- ITERATION pour remplir le tb de digit --// 
		for (i = m_nbrDigitValEntier; i > 0; i--)
		{
			//-- MAJ facteur de puissance de 10 --// 
			
			//-- MAJ tableau de digits --// 
			digit = (byte) ((valUserEntier / (10 ^ i)) % 10);
			m_tBDigitEntier[m_nbrDigitValEntier - 1] = digit;
			//-- MAJ valUser --// 
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
	public void ConversionBinaire() 
	{
		//-- déclaration de variables --// 
		char i = 0;	// Variable de comptage de la boucle des digits
		char y = 0;	// Variable de comptage de la boucle de convertion
		byte digit = 0;	// Variable de sauvegarde du digit
		byte tb_Bin[];	// 
		
		
		//-- MAJ du tableau m_tbBinaire de string en fct des digit entier --// 
		m_tbBinaire = new String[m_nbrDigitValEntier];
		//-- partir avec des cases à Zéro dans le tableau m_tbBinaire  --// 
		for(i = 0; i < m_tbBinaire.length; i++) {
			m_tbBinaire[i] = "0";
		}
		//-- ITERATION d'itération pour pour chaque digit --// 
		for (i = 0; i < m_nbrDigitValEntier; i++)
		{
			//-- récupère la valeur du digit à convertir --// 
			digit = m_tBDigitEntier[i];
			
			//-- ITERATION de conversion  --//
			while (digit > 0)
			{
				//-- conversion binaire -> modulo 2 (récupère le reste) --//
				tb_Bin[y] = (byte) (digit % 2);
				
				//-- MAJ de la valeur à convertir --//
				digit = (byte) (digit / 2);
				
				//-- utilisation  de la table ASCII --//  
				tb_Bin[y] = (byte)(tb_Bin[y] + '0');
				
				y++;
			}
			String str = new String(tb_Bin);
			m_tbBinaire[i] = str;
		}		
	}
}
