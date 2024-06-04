import java.lang.Enum;


public class Conversion {
	
	//-- attributs --// 
	protected byte m_nbrDigitValEntier; 
	
	//-- future tableau --//
	protected byte m_tBDigitEntier[]; 
	protected String m_tbBinaire[]; 
	
	//-- enumération --// 
	codageBinaire e_code; 
	
	//-- constructeur --// 
	public Conversion(){}
	Conversion(codageBinaire choixCodage, float valUser)
	{}
	
	//-- destructeur --// 
	public void finalize() {}
	
	//-- méthode parents - ne change pas --//
	String[] GetValConvertie() 
	{
		return m_tbBinaire; 
	}
	
	byte GetNbrDigitEntier() 
	{
		return m_nbrDigitValEntier; 
	}
	
	
	//-- méthode "virtuelle" 
	protected void CalculerNbrDigitEntier(float valUser) {}
	protected void RecupererDigitEntier(float valUser) {}
	
}
