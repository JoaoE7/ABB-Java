package br.imd.visao;

import br.imd.modelo.Tree;

public class TreeDrawer {
	private Tree tree;
	private MyCanvas canvas;
	
	public TreeDrawer(int width, int height) {
		tree = new Tree();
		canvas = new MyCanvas("Representação visual", width, height);
	}
	
	public TreeDrawer(Tree tree, int width, int height) {
		this.tree = tree;
		canvas = new MyCanvas("Representação visual", width, height);
	}
	
	
}
