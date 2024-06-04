import java.lang.*;
import java.util.Arrays;

//- ATTENTION :  la class ConversionBCD doit hériter la class parent 
public class ConversionBCD extends Conversion
{
	protected byte[] m_tbDigitEntier; 
	Conversion objetConversion = new Conversion();
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
	public ConversionBCD(codageBinaire choixCodage, float valUser)
	{
		
		
		//-- implémenter relation avec la méthode parent voir aide dans le CDC 
		super(choixCodage, valUser);
		//-- relation avec le constructeur parents 
		
		//-- TEST sur le choix du codage => utilisation d'une énumération voir aide dans le CDC
			if (choixCodage != choixCodage.BCD)
			{
            // Gérer le cas où le choix de codage n'est pas BCD
            System.out.println("Erreur : Choix de codage invalide. Seuls les codages BCD sont autorisés.");
            return; // Quitter le constructeur si le choix de codage est incorrect
			}
            
			//-- appel de la méthode : CalculerNbrDigitEntier => détermine le nb de digit d'un nombre entier 
			CalculerNbrDigitEntier(valUser);
			//-- création d'un tableau dynamique type "byte" nommé m_tBDigitEntier  --//
	        m_tbDigitEntier = new byte[12]; // Taille maximale pour le codage BCD
	        m_nbrDigitValEntier = 0; // Initialiser le nombre de chiffres
			//-- appel de la méthode : RecupererDigitEntier => récuperation de chaque digit entier --//
			RecupererDigitEntier(valUser);
			//-- appel de la méthode : ConversionBinaire --// 
			ConversionBinaire();
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
	protected void CalculerNbrDigitEntier(float valUser) 
	{
		//-- déclaration de variable --// 
		int valeurEntiere = (int)valUser; // Variable pour stocker l'entier saisi par l'utilisateur
	    int nbDigit = 0;   // Variable pour compter le nombre de chiffres
	    int facteur = 1;  // Facteur de 10 pour la division
		
		//-- ITERATION pour connaitre le nbr de digit sur une valeur entière
		//-- fin de boucle -> égal à 0
	    while (valeurEntiere != 0) {
	        
	        
	    objetConversion.CalculerNbrDigitEntier(facteur);
			//-- division de la valeur entière par des puissance de 10 : 10^0 => (1), 10^1 => (10), 10^2 => (100) ..
			//-- calculer le facteur de 10 
	    	valeurEntiere /= facteur; // Division par 10
			
			//-- MAJ de la valeur entière en fct du facteur 10
	    	facteur *= 10; // Multiplier le facteur par 10
			
			//-- MAJ du Digit => incrément de 1 --//
	    	nbDigit++; // Incrémenter le nombre de chiffres
	    }
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
		  int indexDigit = 0; // Index pour parcourir le tableau
		  int facteur = 1; // Facteur de puissance de 10
		  float valTemp = valUser; // Variable temporaire pour stocker la valeur restante
		
		//-- ITERATION pour remplir le tb de digit --// 
		  while (valTemp != 0) 
		  {
		        // Calculer le chiffre actuel
		        int digit = (int) (valTemp / facteur);

		        // Mettre à jour le tableau de chiffres
		        m_tbDigitEntier[indexDigit] = (byte)digit;

		        // Incrémenter l'index du tableau
		        indexDigit++;

		        // Majorer le facteur de puissance de 10
		        facteur *= 10;

		        // Mettre à jour la valeur restante
		        valTemp -= digit * facteur;
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
	private void ConversionBinaire() 
	{
		// Déclaration des variables
	    int indexDigit = 0; // Index pour parcourir les tableaux
	    String valBinaire; // Valeur binaire temporaire pour chaque chiffre

	    // Initialiser le tableau m_TbBinaire avec des chaînes vides
	    for (int i = 0; i < m_tbBinaire.length; i++) {
	    	objetConversion.m_tbBinaire[i] = "";
	    }

	    // Itération pour chaque chiffre du tableau
	    for (int digit : objetConversion.m_tBDigitEntier) {
	        valBinaire = ""; // Réinitialiser la valeur binaire pour chaque chiffre

	        // Conversion du chiffre en binaire (itération par bit)
	        int valTemp = digit;
	        while (valTemp != 0) {
	            int bit = valTemp % 2; // Obtenir le bit actuel (0 ou 1)
	            valBinaire = bit + valBinaire; // Ajouter le bit à la chaîne binaire (ordre inverse)
	            valTemp /= 2; // Diviser par 2 pour obtenir le prochain bit
	        }

	        // Ajouter des zéros manquants devant la chaîne binaire
	        while (valBinaire.length() < 4) {
	            valBinaire = "0" + valBinaire;
	        }

	        
	        // Stocker la chaîne binaire dans le tableau m_TbBinaire
	        objetConversion.m_tbBinaire[indexDigit] = valBinaire;

	        indexDigit++;
	    }
 	
	}
}
