package nui.squirt.demo;

import nui.squirt.NUIController;
import nui.squirt.component.Button;
import nui.squirt.component.Frame;
import nui.squirt.component.Label;
import nui.squirt.render.processing.ProcessingRenderingEngine;
import processing.core.PApplet;
import processing.core.PImage;


/* 
 * This demo illustrates the use of the Squirt UI framework.
 * 
 * First this PApplet initializes an NUIController and adds several UI components to it.
 * At each frame it rotates frame 0 and calls render() on the NUIController.
 * The render() function recursively traverses down the component tree, rendering children after rendering the parent.
 * 
 * Notice how the child components of the Frame instances are rendered relative to the parent's position, rotation, and scale.
 * Also notice the transparency of the Frame components when rendered.
 * 
 */
public class NUIPAppletDemo extends PApplet {

	private static final long serialVersionUID = -5298894969210176542L;
	
	private NUIController controller;
	private Frame f, f1, f2;
	
	private PImage img;
	
	@Override
	public void setup() {
		size(screen.width, screen.height);
		smooth();
		rectMode(CENTER);
		ellipseMode(CENTER);
		imageMode(CENTER);
		
		img = createImage(height-80, height-100, RGB);
		img.loadPixels();
		for (int i = 0; i < img.pixels.length; i++) {
			img.pixels[i] = color(random(255), random(255), random(255));
		}
		img.updatePixels();
		
		controller = new NUIController(new ProcessingRenderingEngine(this));
		
		f = new Frame(width/2, height/2, width/2, height/2);
		controller.addComponent(f);
		f.addChild(new Label(0, 0, "Frame0"));
		f.addChild(new Label(60-f.getWidth()/2, 30-f.getHeight()/2, "Label"));
		f.addChild(new Button(50, 50, "Button"));
		
		f1 = new Frame(width*3/4+width/8, height/2+height/8, width/8, height/8);
		controller.addComponent(f1);
		f1.addChild(new Label(0, 0, "Frame1"));
		
		// Adding sub-component prior to adding to controller
		f2 = new Frame(width*3/4+width/8, height/4+height/8, width/8, height/8);
		f2.addChild(new Label(0, 0, "Frame2"));
		controller.addComponent(f2);
	}
	
	@Override
	public void draw() {
		background(255);
		imageMode(CENTER);
		image(img, width/2, height/2);
		f.setRotation((float) (f.getRotation()+0.01));
		controller.render();
	}

	public static void main(String[] args) {
		PApplet.main(new String[]{ "--present", "nui.squirt.demo.NUIPAppletDemo" });
	}
}