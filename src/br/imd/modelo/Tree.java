package br.imd.modelo;

public class Tree {
	
	private No root;
	private Tree leftTree;
	private Tree rightTree;
	
	public Tree(){
		// construtor vazio
	}
	
	public Tree getRightTree() {
		return rightTree;
	}
	
	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}
	
	public Tree getLeftTree() {
		return leftTree;
	}
	
	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}
	
	 public No getRoot() {
	        return root;
	 }

	public void setRoot(No root) {
	        this.root = root;
	}
	
	public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }

	public void inserir(No no) {
		if(this.root == null) {
		   this.root = no;
		} else {
			if (no.getAluno().getMatricula() > this.root.getAluno().getMatricula()) {
				if (this.rightTree == null)
					this.rightTree = new Tree();
				this.rightTree.inserir(no);
			} else if (no.getAluno().getMatricula() < this.root.getAluno().getMatricula()) {
				if (this.leftTree == null)
					this.leftTree = new Tree();
				this.leftTree.inserir(no);
			}
		}
	}
	
	public No busca(int matricula) {
		// Se não encontrar, retorna nó vazio
		if (root == null)
			return new No(new Aluno(0,""));
		
		if (root.getAluno().getMatricula() == matricula)
			return root;
		
		if (root.getAluno().getMatricula() > matricula)
			return leftTree.busca(matricula);
		else
			return rightTree.busca(matricula);
	}
	
	public void percorrerInOrdem(VisitFunction func) {
		if (root == null) return;
		
		if (leftTree != null) leftTree.percorrerInOrdem(func);
		func.execute(root);
		if (rightTree != null) rightTree.percorrerInOrdem(func);
	}

	public void percorrerPreOrdem(VisitFunction func) {
		if (root == null) return;
		
		func.execute(root);
		if (leftTree != null) leftTree.percorrerPreOrdem(func);
		if (rightTree != null) rightTree.percorrerPreOrdem(func);
	}
	
	public void percorrerPosOrdem(VisitFunction func) {
		if (root == null) return;
		
		if (leftTree != null) leftTree.percorrerPosOrdem(func);
		if (rightTree != null) rightTree.percorrerPosOrdem(func);
		func.execute(root);
	}
}
