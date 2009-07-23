package nui.squirt;

import java.awt.geom.AffineTransform;

import processing.core.PApplet;
import processing.core.PVector;

public interface Component {
	
	public void update();
	
	public void preRender(PApplet p);
	public void render(PApplet p);
	public void postRender(PApplet p);
	
	public AffineTransform getTransformMatrix();
	public AffineTransform getAbsoluteTransformMatrix();
	
	public PVector transformToLocalSpace(PVector v);
	
//	public void setX(float x);
//	public float getX();
//	public void setY(float y);
//	public float getY();
//	
//	public void setRotation(float theta);
//	public float getRotation();
//	public void rotate(float theta);
	
	public void setParent(Container p);
	public Container getParent();
	
	// Indicates whether this Component can accept offers of additional control points
	public boolean canAcceptMoreControlPoints();
	
	// Returns true if no other Components should process this point
	// TODO rename this method to reflect its current meaning
	public boolean offer(ControlPoint cp);
}
