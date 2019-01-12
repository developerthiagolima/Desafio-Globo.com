package controle;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Grade;
import util.ExcecaoValoresValidos;
import util.StdIn;
import util.StdOut;
import util.Util;

public class GradeProgramacao {
	
	private List<Grade> listaGrade;

	public void executar(){
		String registro = "";
		listaGrade = new ArrayList<Grade>();
		
		while(!registro.equalsIgnoreCase("sair")){
			registro = StdIn.readLine();
			String [] valores = Util.separarValores(registro);
			
	        switch (valores[0]) {
			case "S":
				try {
					salvarGrade(valores);
				} catch (ExcecaoValoresValidos e) {
					StdOut.println(e.getMessage());
				}
				break;
			case "Q":
				try {
					pesquisarGrade(valores);
				} catch (ExcecaoValoresValidos e) {
					StdOut.println(e.getMessage());
				}
				break;

			default:
				break;
			}   
		}

	}
	
	public void salvarGrade(String[] valores) throws ExcecaoValoresValidos{
		if(Util.validaValoresParaSalvar(valores)){
			Grade grade = new Grade(valores);
			listaGrade.add(grade);
		}else{
			throw new ExcecaoValoresValidos("Valores digitados incorretamente! Por favor tente novamente.");
		}
	}
	
	public void pesquisarGrade(String[] valores) throws ExcecaoValoresValidos{
		if(Util.validaValoresParaPesquisa(valores)){
			listaGrade.stream()
					.filter(g -> {
						LocalTime hora = Util.retornarHorarioProgramacao(valores[2]);
	                    if ( (valores[1].equals(g.getUf()) || g.getUf().equals("\"BR\"")) && (hora.isAfter(g.getInicio()) && hora.isBefore(g.getFim())) ) {
	                        return true;
	                    }
	                    return false;
	                })
	                .findFirst().map(g -> {
	                	StdOut.println("A "+valores[1]+" "+valores[2]+" "+g.getUf()+" "+g.getDescricao()+"");
	                    return g;
	                }).orElseGet(() -> {
	                	StdOut.println("A "+valores[1]+" "+valores[2]+" noise");
	                    return null;
	                });
			
		}else{
			throw new ExcecaoValoresValidos("Valores digitados incorretamente! Por favor tente novamente.");
		}
	}
	
}
