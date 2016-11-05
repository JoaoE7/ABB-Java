package br.imd.modelo;

import br.imd.visao.MyCanvas;
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
		t.insereAluno(7, "dadaad");
		
		No n = t.busca(4);
		System.out.println(n.getAluno().getNome());
		TreePrinter printer = new TreePrinter();
		
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
		td.drawTree();
		
		t.percorrerInOrdem(printer);
		System.out.println();
		t.percorrerPosOrdem(printer);
		System.out.println();
		t.percorrerPreOrdem(printer);
	}
}
