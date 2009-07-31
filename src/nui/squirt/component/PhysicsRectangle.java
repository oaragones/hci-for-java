package nui.squirt.component;

import java.awt.Color;

import nui.squirt.ControlPoint;

import org.jbox2d.collision.PolygonDef;
import org.jbox2d.dynamics.World;

import processing.core.PApplet;
import processing.core.PVector;

public class PhysicsRectangle extends PhysicsComponent {
	
	private float width;
	private float height;
	
	private Color fillColor = Color.CYAN;
	private Color strokeColor = Color.BLACK;
	private float strokeWeight = 1;
	
	public PhysicsRectangle(float x, float y, float w, float h, World world) {
		super(x, y, world);
		this.width = w;
		this.height = h;
		
		// Create collision rectangle
		PolygonDef shapeDef = new PolygonDef();
		// Make sure it has non-zero density, otherwise it will have 0 mass and be static
		shapeDef.density = 0.1f;
		shapeDef.setAsBox(getWidth()/2, getHeight()/2);
		getBody().createShape(shapeDef);
		
		// Set mass of body
		getBody().setMassFromShapes();
	}
	
	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public float getStrokeWeight() {
		return strokeWeight;
	}

	public void setStrokeWeight(float strokeWeight) {
		this.strokeWeight = strokeWeight;
	}

	public void update() {
		if (getBody().isFrozen()) setFillColor(Color.DARK_GRAY);
		if (getBody().isSleeping()) {
			setStrokeColor(Color.BLUE);
		}
		else {
			setStrokeColor(Color.BLACK);
		}
	}
	
	@Override
	public void preRender(PApplet p) {
		super.preRender(p);
		
		p.rectMode(PApplet.CENTER);
		p.fill(getFillColor().getRGB());
		p.stroke(getStrokeColor().getRGB());
		p.strokeWeight(getStrokeWeight());
	}
	
	@Override
	public void render(PApplet p) {
		p.rect(0, 0, getWidth(), getHeight());
		super.render(p);
	}

	public boolean isUnderPoint(ControlPoint cp) {
		PVector l = transformToLocalSpace(new PVector(cp.getX(), cp.getY()));
		return (l.x > -getWidth()/2 && l.x < getWidth()/2 && l.y > -getHeight()/2 && l.y < getHeight()/2);
	}
	
	public boolean offer(ControlPoint cp) {
		cp.addControlPointListener(this);
		return true;
	}

}
