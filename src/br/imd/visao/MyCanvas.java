package br.imd.visao;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.imd.modelo.No;
import br.imd.modelo.Tree;

@SuppressWarnings("serial")
public class MyCanvas extends JPanel {
	
	private JFrame frame;
	private Image canvasImage;
	private Graphics2D graphic;
	private ArrayList<No> nodeReferences;
	private HashMap<No, Shape> shapes;
	
	public MyCanvas(String name, int width, int height) {
		frame = new JFrame(name);
		frame.setContentPane(this);
		this.setPreferredSize(new Dimension(width, height));
		frame.pack();
		nodeReferences = new ArrayList<No>();
		shapes = new HashMap<No, Shape>();
		
		canvasImage = this.createImage(width, height);
		graphic = (Graphics2D)canvasImage.getGraphics();
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, width, height);
		graphic.setColor(Color.BLACK);
		
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(canvasImage, 0, 0, null);
	}
	
	public void drawTree(Tree tree) {
		
	}
	
	public void drawNode(No no, int x, int y) {
		nodeReferences.add(no);
		// Mudar X e Y;
		shapes.put(no, new Ellipse2D.Double(x, y, 100, 100));
		redraw();
	}
	
	public void redraw() {
		for (No no : nodeReferences) {
			System.out.println("a\na\na\na\n");
			Shape shape = shapes.get(no);
			setForeground(Color.white);
			graphic.fill(shape);
		}
	}
}
