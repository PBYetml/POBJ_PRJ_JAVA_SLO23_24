import java.util.ArrayList;		// lib pour des tableaux dynamique d'objet 
import java.util.Scanner;
import java.text.*;


public class User 
{
	//--  attribut --//
	private float m_valUser; 
	
	//-- attribut - constant --// 
	private final short CST_LIMIT_MAX; 
	private final short CST_LIMIT_MIN; 
	
	//-- attribut - objet --// 
	private Conversion choixConversion_o; 
		
	// constructeur
	User(short limitMax, short limitMin)
	{
		this.CST_LIMIT_MAX = limitMax; 
		this.CST_LIMIT_MIN = limitMin; 
	}
	
	//-- méthodes --// 
	void AfficherMsgUser(msgInfoUser e_option, Object... option_o) 
	{
		//-- déclaration variable --// 
		int longeurObjet; 
		
		//-- déclaration d'objet 
		Object optionMethode_o[] = option_o; 
		
		//-- longueur des paramètre 
		longeurObjet = optionMethode_o.length; 
		
		
		if (longeurObjet == 0)
		{
			System.out.println(e_option.toString());
		}
		else 
		{
			
			System.out.println(e_option.toString() + " " + optionMethode_o[0].toString());
		}
	}
	
	
	boolean ValiderValUser(float valATester) 
	{
		//-- déclaration de variables --// 
		boolean checkValeur = false; 
		
		float difference; 
		
		//-- test si valATester est dans les limites fixée au départ--// 
		if((valATester < CST_LIMIT_MAX) && (valATester >= CST_LIMIT_MIN))
		{
			//-- séparation entre la valeur entière et la valeur réelle 
			difference = valATester - (int)valATester; 
			
			//-- test si entier --// 
			if(difference == (float)0.0)
			{
				checkValeur = true; 
				m_valUser = valATester; 
			}
			else 
			{
				this.AfficherMsgUser(msgInfoUser.MESSAGE_3);
				checkValeur = false; 
			}
		}
		else
		{
			this.AfficherMsgUser(msgInfoUser.MESSAGE_2);
			checkValeur = false; 
		}
		
		return checkValeur; 
	}
	
	
	
	
	float SetNumberValue() 
	{
		//-- déclaration variable --// 
		float valUserReel = (float)0.0; 
		
		//-- déclaration d'objet --// 
		Scanner clavier_o = new Scanner(System.in); 
		String recupClavier_o = new String(); 
		
		//-- récuperation buffer clavier --//
		recupClavier_o = clavier_o.nextLine(); 
		
		//-- convertion chaine de caractère en string --// 
		valUserReel = Float.parseFloat(recupClavier_o); 
		
		return valUserReel; 
	}
	
	
	float GetNumberValue() 
	{
		return m_valUser; 
	}
	
	void AfficherValConvertie(Conversion objAconvertir_o)
	{
		//-- déclaration de variable --// 
		byte iteration, iterationDigit;  
		byte digitBinaire, longeurChaine; 
		
		String chaineATraiter = ""; 
		String[] chaineBase; 
		StringBuilder chaineAfficher; 
		
		//-- récupération chaine de caractère à afficher --//
		chaineBase = objAconvertir_o.GetValConvertie(); 
		
		//affichage 
		System.out.print("=> valeur BCD : ");
		
		//-- affichage de la valeur binaire dans le bon sens --//
		//-- iteration 
		for(iteration = 0 ; iteration < objAconvertir_o.GetNbrDigitEntier() ; iteration += 1)
		{
			digitBinaire = (byte)chaineBase[iteration].length(); 
			
			for(iterationDigit = (byte)(digitBinaire - 1); iterationDigit > 0;  iterationDigit -= 1)
			{
				chaineATraiter += chaineBase[iteration].charAt(iterationDigit); 
			}
			
			
			if(chaineATraiter.length() >= 4)
			{
				System.out.print(chaineATraiter); 
			}
			else 
			{

				chaineAfficher = new StringBuilder(); 
				//String.format("%0" + (10 - valAfficher[iteration].length()) + "d", 0); 
				for(iterationDigit = 0; iterationDigit < (4 - chaineATraiter.length()) ;  iterationDigit += 1) 
				{
					chaineAfficher.append("0"); 
				}
				
				chaineAfficher.append(chaineATraiter); 
			
				System.out.print(chaineAfficher + " ");
				chaineATraiter = ""; 
				
			}
		}
	}
	
	
	//-- entrée programme --// 
	public static void main(String[] args) 
	{
		//-- déclaration de variable --// 
		boolean validationValUser = false; 
		
		final byte NUM_PRJ = 01; 
		final byte VER_PRJ = 01; 
		
		//-- déclaration d'objet propre au main --// 
		String langage_o = new String("JAVA"); 
		String auteur_o = new String("Philou"); 
		
		User UserAction_o = new User((short)10000, (short)0); 
		
		//-- configuration message user => titre --// 
		UserAction_o.AfficherMsgUser(msgInfoUser.TITRE_1, langage_o);
		UserAction_o.AfficherMsgUser(msgInfoUser.TITRE_2, VER_PRJ);
		UserAction_o.AfficherMsgUser(msgInfoUser.TITRE_3, auteur_o);
		
		//-- itération => tant que la valeur n'est pas validée --// 
		do
		{
			//-- message user 
			UserAction_o.AfficherMsgUser(msgInfoUser.MESSAGE_1);
			
			//-- validation valeur
			validationValUser = UserAction_o.ValiderValUser(UserAction_o.SetNumberValue()); 
	
		}
		while(!validationValUser); 
		
		//-- choix du codage de la valeur choisie par l'utilisateur --//
		//UserAction_o.choixConversion_o = new ConversionBCD(codageBinaire.BCD, UserAction_o.GetNumberValue()); 
		
		//-- affichage de la valeur à convertir --//
		UserAction_o.AfficherValConvertie(UserAction_o.choixConversion_o);
		
		// TODO Auto-generated method stub

	}

}
