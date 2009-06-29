package nui.squirt;

import nui.squirt.render.Renderer;

public interface Component {
	
	public void setRenderer(Renderer r);
	public Renderer getRenderer();
	
	public void setX(float x);
	public float getX();
	public void setY(float y);
	public float getY();
	
	public void setRotation(float theta);
	public float getRotation();
	
	public void setVisible(boolean v);
	public boolean isVisible();
	
	public void render();

}
