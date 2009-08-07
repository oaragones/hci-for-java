package nui.squirt;



public interface ControlPoint {
	
	public boolean isDead();
	public void kill();

	public float getX();
	public float getY();
	public float getPreviousX();
	public float getPreviousY();
	
	public void addControlPointListener(ControlPointListener l);
	public void removeControlPointListener(ControlPointListener l);
	
	public void fireControlPointCreatedEvent();
	public void fireControlPointDiedEvent();
	public void fireControlPointUpdatedEvent();
}
