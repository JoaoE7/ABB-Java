package br.imd.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.imd.modelo.No;

@SuppressWarnings("serial")
public class MyCanvas extends JPanel {
	
	private JFrame frame;
	private Image canvasImage;
	private Graphics2D graphic;
	private ArrayList<No> nodeReferences;
	private HashMap<No, ArrayList<Shape>> shapes;
	private HashMap<No, Color> nodeColor;
	private HashMap<No, Point2D.Float> nodePosition;
	
	public MyCanvas(String name, int width, int height) {
		frame = new JFrame(name);
		frame.setContentPane(this);
		this.setPreferredSize(new Dimension(width, height));
		frame.pack();
		nodeReferences = new ArrayList<No>();
		shapes = new HashMap<No, ArrayList<Shape>>();
		nodeColor = new HashMap<No, Color>();
		nodePosition = new HashMap<No, Point2D.Float>();
		
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
	
	public void drawConnection(int x1, int y1, int x2, int y2) {
		graphic.drawLine(x1, y1, x2, y2);
	}
	
	public void drawNode(No no, int size, int x, int y) {
		nodeReferences.add(no);
		// Mudar X e Y;
		nodeColor.put(no, Color.BLACK);
		nodePosition.put(no, new Point2D.Float(x, y));
		
		shapes.put(no, new ArrayList<Shape>());
		shapes.get(no).add(new Ellipse2D.Double(x - size/2, y, size, size));
		shapes.get(no).add(new Ellipse2D.Double(x - (size*0.90)/2,
												y + (size*0.05),
												(size*0.9),
												(size*0.9)));
		redraw();
	}

	public void highlightNode(No no) {
		nodeColor.put(no, Color.GREEN);
		redraw();
	}
	
	public void unHighlightNode(No no) {
		nodeColor.put(no, Color.BLACK);
		redraw();
	}
	
	public void redraw() {
		setForeground(Color.WHITE);
		for (No no : nodeReferences) {
			Color color = nodeColor.get(no);
			for (Shape shape : shapes.get(no)) {
				graphic.setColor(color);
				graphic.fill(shape);
				color = Color.WHITE;
			}
			graphic.setColor(Color.BLACK);
			graphic.drawString("" + no.getAluno().getMatricula(), (int) nodePosition.get(no).getX(), (int) nodePosition.get(no).getY());
		}
		
		repaint();
	}
}
