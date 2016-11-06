package br.imd.modelo;

/* Uma implementação da função de visita dos percursos em ordem da árvore
 * Simplesmente imprime o conteúdo do Nó atual no console
 */
public class TreePrinter implements VisitFunction {
	@Override
	public void execute(No no) {
		System.out.println(no.getAluno().getMatricula() + " " + no.getAluno().getNome());
	}
	
}
