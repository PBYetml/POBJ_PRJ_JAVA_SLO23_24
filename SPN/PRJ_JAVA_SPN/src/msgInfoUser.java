import java.lang.Enum;


public enum msgInfoUser 
{
		
	//-- attribut type énumération --// 
	TITRE_1 ("PROJET"), 
	TITRE_2 ("Version"),
	TITRE_3 ("Auteur"), 
	
	MESSAGE_1 ("inserez un nombre : "), 
	MESSAGE_2 ("!! Erreur !! => valeur hors limite "), 
	MESSAGE_3 ("!! Erreur !! => format réel"); 
	

	private String msg1 = "";
	
	//-- constructeur enumération --// 
	msgInfoUser(String message)
	{
		this.msg1 = message; 
	}
	
	//-- méthode énumeration --// 
	public String toString() 
	{
		return msg1; 
	}
}
