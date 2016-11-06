package br.imd.modelo;

/* Interface básica para os percorrimentos em ordem da árvore
 * Permite que qualquer classe a implemente para realizar procedimentos
 * diversos na árvore percorrida na ordem desejada
 */
public interface VisitFunction {
	public void execute(No no);
}
