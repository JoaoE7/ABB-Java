package br.imd.modelo;

import br.imd.modelo.Tree;
import br.imd.modelo.No;
import br.imd.visao.TreeDrawer;

public class SysMain {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insereAluno(4, "asd");
		t.insereAluno(2, "asdad");
		t.insereAluno(1, "qwe");
		t.insereAluno(3, "asd");
		t.insereAluno(6, "glubglub");
		t.insereAluno(5, "qweqweqwe");
		t.insereAluno(8, "dadaad");
		
		No n = t.busca(4);
		System.out.println(n.getAluno().getNome());
		
		/*
		MyCanvas canvas = new MyCanvas("WOOW", 300, 300);
		canvas.drawNode(n, 50, 50);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		canvas.highlightNode(n);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		canvas.unHighlightNode(n);
		*/
		
		TreeDrawer td = new TreeDrawer(t, 800, 400);
		//td.percorrerPreOrdem();
		//td.percorrerInOrdem();
		//td.percorrerPosOrdem();
		//td.insereAluno(7, "ksfdjksfhj");
		//td.remove(4);
		td.remove(4);
		td.percorrerPreOrdem();
		
		System.out.println("== Fim das ações do programa ==");
	}
}
