package util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public static String[] separarValores(String registro){
		List<String> valores = new ArrayList<String>();
		Matcher separador = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(registro);
		while (separador.find())
			valores.add(separador.group(1));
		
		return valores.toArray(new String[valores.size()]);
	}

	public static Boolean validaValoresParaSalvar(String[] valores){
		Boolean retorno = true;
		
		if(valores.length != 5){
			retorno = false;
		}
			
		return retorno;
	}
	
	public static Boolean validaValoresParaPesquisa(String[] valores){
		Boolean retorno = true;
		
		if(valores.length != 3){
			retorno = false;
		}
			
		return retorno;
	}
	
	public static LocalTime retornarHorarioProgramacao(String hora){
		String[] horario = hora.split("\\:");
		LocalTime horarioProgramacao = LocalTime.of(Integer.parseInt(horario[0]), Integer.parseInt(horario[1]));
		return horarioProgramacao;
	}
}
