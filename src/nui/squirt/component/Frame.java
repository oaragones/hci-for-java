package nui.squirt.component;

import nui.squirt.Component;
import nui.squirt.render.FrameRenderer;
import nui.squirt.render.Renderer;
import nui.squirt.render.RenderingEngine;

public class Frame extends AbstractContainer {

	private FrameRenderer renderer;
	
	private float width;
	private float height;

	public Frame(float x, float y, float w, float h) {
		super(x, y);
		this.width = w;
		this.height = h;
	}

	public FrameRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(Renderer r) {
		this.setRenderer((FrameRenderer) r);
	}

	public void setRenderer(FrameRenderer renderer) {
		this.renderer = renderer;
		RenderingEngine e = renderer.getRenderingEngine();
		
		for (Component c: children) {
			Renderer r = c.getRenderer();
			if (r == null || !r.getRenderingEngine().equals(e)) {
				c.setRenderer(e.getRenderer(c));
			}
		}
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
