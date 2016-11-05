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
			//Cria um novo nó
		   this.root = no;
		} else {
			//highlight no root
			if (no.getAluno().getMatricula() > this.root.getAluno().getMatricula()) {
				//pausa
				//Valor da matricula do root é menor do que a matricula do elemento que queremos inserir, 
				//então  vai pra sub-árvore da direita
				if (this.rightTree == null)
					this.rightTree = new Tree();
				//unHighlight no root
				this.rightTree.inserir(no);	
			} else if (no.getAluno().getMatricula() < this.root.getAluno().getMatricula()) {
				//pausa
				//Valor da matricula do root é maior do que a matricula do elemento que queremos inserir, 
				//então  vai pra sub-árvore da esquerda
				if (this.leftTree == null)
					this.leftTree = new Tree();
				//unHighlight no root
				this.leftTree.inserir(no);
			}
		}
	}
	
	public boolean remove (int matricula) {
		if (this.root == null) {
			return false;
		}
		if (this.root.getAluno().getMatricula() == matricula) {
			if (this.leftTree == null && this.rightTree == null) {
				this.root = null;
			} else if (this.leftTree != null && this.rightTree == null) {
				this.root = this.leftTree.root;
				this.leftTree = this.leftTree.leftTree;
				this.rightTree = this.leftTree.rightTree;
			} else if (this.leftTree == null && this.rightTree != null) {
				this.root = this.rightTree.root;
				this.leftTree = this.rightTree.leftTree;
				this.rightTree = this.rightTree.rightTree;
			} else {
				Tree ant = this;
				Tree atual = this.leftTree;
				while (atual.rightTree != null) {
					ant = atual;
					atual = atual.rightTree;
				}
				this.root = atual.root;
				if (ant == this) {
					this.leftTree = atual.leftTree;
				} else {
					ant.rightTree = atual.leftTree;
				}
			}
			return true;
		}
		Tree ant = null;
		Tree atual = this;
		while (atual != null && atual.root.getAluno().getMatricula() != matricula) {
			if (atual.root.getAluno().getMatricula() > matricula) {
				ant = atual;
				atual = atual.leftTree;
			} else {
				ant = atual;
				atual = atual.rightTree;
			}
		}
		
		if (atual == null) {
			return false;
		}
		
		if (atual.leftTree == null && atual.rightTree == null) {
			if (ant.leftTree == atual) {
				ant.leftTree = null;
			} else {
				ant.rightTree = null;
			}
		} else if (atual.leftTree != null && atual.rightTree == null) {
			if (ant.leftTree == atual) {
				ant.leftTree = atual.leftTree;
			} else {
				ant.rightTree = atual.leftTree;
			}
		} else if (atual.leftTree == null && atual.rightTree != null) {
			if (ant.leftTree == atual) {
				ant.leftTree = atual.rightTree;
			} else {
				ant.rightTree = atual.rightTree;
			}
		} else {
			Tree ant2 = atual;
			Tree atual2 = atual.leftTree;
			while (atual2.rightTree != null) {
				ant2 = atual2;
				atual2 = atual2.rightTree;
			}
			atual.root = atual2.root;
			if (ant2 == atual) {
				atual.leftTree = atual2.leftTree;
			} else {
				ant2.rightTree = atual2.leftTree;
			}
		}
		return true;
	}
	
	public No busca(int matricula) {
		// Se nao encontrar, retorna no vazio
		if (root == null)
			return new No(new Aluno(0,""));
		////Highlight no root
		
		if (root.getAluno().getMatricula() == matricula)
			//pausa
			//(?) Espera alguma confirmação para chamar unHighlight 
			return root;
		
		if (root.getAluno().getMatricula() > matricula)
			//pausa
			//Valor da matricula do root é maior do que a matricula do elemento que estamos buscando,
			//então vai pra arvore da esquerda
			//unHighlight no root
			return leftTree.busca(matricula);
		else
			//pausa
			//Valor da matricula do root é menor do que a matricula do elemento que estamos buscando,
			//então vai pra arvore da direita
			//unHighlight no root
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
