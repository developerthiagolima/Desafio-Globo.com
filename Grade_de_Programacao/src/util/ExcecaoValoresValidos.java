package util;

public class ExcecaoValoresValidos extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ExcecaoValoresValidos(){}

	public ExcecaoValoresValidos(String mensagem){
		super(mensagem);
	}
}
