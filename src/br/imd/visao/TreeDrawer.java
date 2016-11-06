import br.imd.modelo.Tree;

public class TreeDrawer {
	private Tree tree;
	private MyCanvas canvas;
	private int NODESIZE = 50;
	private int VERTICALDIST = 70;

	public TreeDrawer(int width, int height) {
		tree = new Tree();
		canvas = new MyCanvas("Representação visual", width, height);
	}
	
	public TreeDrawer(Tree tree, int width, int height) {
		this.tree = tree;
		canvas = new MyCanvas("Representação visual", width, height);
	}
	
	// 50 é a distância vertical entre eles
	public void drawTree() {
		int leftX = 0;
		int rightX = canvas.getWidth();
		int currDepth = 1;

		if (tree.getLeftTree() != null) {
			canvas.drawConnection(leftX/2 + rightX/2, currDepth*VERTICALDIST + NODESIZE/2, 3*leftX/4 + rightX/4, (currDepth+1)*VERTICALDIST + NODESIZE/2);
			drawTree(tree.getLeftTree(), currDepth+1, leftX, leftX/2 + rightX/2);
		}
		if (tree.getRightTree() != null) {
			canvas.drawConnection(leftX/2 + rightX/2, currDepth*VERTICALDIST + NODESIZE/2, leftX/4 + 3*rightX/4, (currDepth+1)*VERTICALDIST + NODESIZE/2);
			drawTree(tree.getRightTree(), currDepth+1, leftX/2 + rightX/2, rightX);
		}
		
		canvas.drawNode(tree.getRoot(), NODESIZE, leftX/2 + rightX/2, currDepth*VERTICALDIST);
	}
	
	private void drawTree(Tree tree, int currDepth, int leftX, int rightX) {
		if (tree.getLeftTree() != null) {
			canvas.drawConnection(leftX/2 + rightX/2, currDepth*VERTICALDIST + NODESIZE/2, 3*leftX/4 + rightX/4, (currDepth+1)*VERTICALDIST + NODESIZE/2);
			drawTree(tree.getLeftTree(), currDepth+1, leftX, leftX/2 + rightX/2);
		}
		if (tree.getRightTree() != null) {
			canvas.drawConnection(leftX/2 + rightX/2, currDepth*VERTICALDIST + NODESIZE/2, leftX/4 + 3*rightX/4, (currDepth+1)*VERTICALDIST + NODESIZE/2);
			drawTree(tree.getRightTree(), currDepth+1, leftX/2 + rightX/2, rightX);
		}
		
		canvas.drawNode(tree.getRoot(), NODESIZE, leftX/2 + rightX/2, currDepth*VERTICALDIST);
	}
	
	public void percorrerInOrdem() {
		System.out.println("=== Percorrimento em ordem simetrica ===");
		tree.percorrerInOrdemVisual(canvas);
		System.out.println();
	}

	public void percorrerPreOrdem() {
		System.out.println("=== Percorrimento em pre-ordem ===");
		tree.percorrerPreOrdemVisual(canvas);
		System.out.println();
	}

	public void percorrerPosOrdem() {
		System.out.println("=== Percorrimento em pos-ordem ===");
		tree.percorrerPosOrdemVisual(canvas);
		System.out.println();
	}
	
	public void busca(int matricula) {
		System.out.println("=== Busca ===");
		tree.buscaVisual(canvas, matricula);
		System.out.println();
	}
	
	public void insereAluno(int matricula, String nome) {
        Aluno aluno = new Aluno(matricula, nome);
        No no = new No(aluno);
        inserir(no);
    }
	
	public void inserir(No no ) {
		System.out.println("=== Inserir ===");
		tree.inserirVisual(canvas, no);
		drawTree();
		System.out.println("Inserção do " +no.getAluno().getMatricula()+ " foi concluido");
		System.out.println();
	}
	
	public void remove(int matricula) {
		System.out.println("=== Remove ===");
		tree.removeVisual(canvas, matricula);
		canvas.redraw();
		drawTree();
		System.out.println("Remoção de "+ matricula +" feita com sucesso");
		System.out.println();
	}	 
}
