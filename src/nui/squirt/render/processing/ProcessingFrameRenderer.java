package nui.squirt.render.processing;

import nui.squirt.Context;
import nui.squirt.component.Frame;
import nui.squirt.render.FrameRenderer;
import nui.squirt.render.RenderingEngine;

public class ProcessingFrameRenderer extends FrameRenderer {

	public ProcessingFrameRenderer(RenderingEngine e) {
		super(e);
	}

	@Override
	public void render(Frame f, Context t) {
		// TODO Auto-generated method stub
		
	}
	
//	public void prepare(Frame f) {
//		ProcessingRenderingEngine engine = (ProcessingRenderingEngine) getRenderingEngine();
//		engine.performTranslation(f);
//	}
//
//	public void draw(Frame f) {
//		ProcessingRenderingEngine engine = (ProcessingRenderingEngine) getRenderingEngine();
//		PApplet pApplet = engine.getPApplet();
//		
//		// Draw a rectangle representing the frame
//		pApplet.rectMode(PApplet.CENTER);
//		pApplet.noStroke();
//		pApplet.fill(75, 75, 75, 150);
//		pApplet.rect(0, 0, f.getWidth(), f.getHeight());
//	}
//
//	public void postDraw(Frame f) {
//		ProcessingRenderingEngine engine = (ProcessingRenderingEngine) getRenderingEngine();
//		engine.undoTranslation();
//	}

}
