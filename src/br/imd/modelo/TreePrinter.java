package br.imd.modelo;

public class TreePrinter implements VisitFunction {
	@Override
	public void execute(No no) {
		System.out.println(no.getAluno().getMatricula() + " " + no.getAluno().getNome());
	}
	
}
