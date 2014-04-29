
public class TimeKeeper{
	
	private long endTime, startTime, duration, timeLeft;
	private boolean run, paused; 
	
	/**
	 * 
	 * @param duration in milliseconds
	 */
	public TimeKeeper(long duration){
		setDuration(duration);
		startTimer();
	}
	
	/**
	 * 
	 * @param duration in milliseconds
 	 * @param paused
 	 * 
	 */
	
	public TimeKeeper(long duration, boolean paused){
		if(paused){
			setDuration(duration);
			startTimer();
			pause();
		}else{
			setDuration(duration);
			startTimer();
		}
	}
	private void startTimer(){
		run = true;
		
		if(paused){
			//The timer is paused
		}else{
			paused = false;
		}
		
		startTime = System.currentTimeMillis();
		endTime = startTime + duration;
		timeLeft();
	}
	
	/**
	 * 
	 * @return true if finished false if running
	 */
	public boolean checkTimer(){
		if(!paused){
			if(timeLeft() <= 0){
				return true;
			}else{
				return false;
			}
		}else{
			pause();
			return false;
		}
	}
	/**
	 * 
	 * @return in milliseconds 
	 */
	public long timeLeft(){
		
		if(!paused){
			timeLeft = endTime - System.currentTimeMillis();
		}
		return timeLeft;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	/**
	 * 
	 * @param duration in milliseconds
	 */
	public void startNew(long duration){
		if(duration > 0){
			reset();
			setDuration(duration);
			startTimer();
		}else{
			throw new IllegalArgumentException("The duration can't be 0 or less");
		}
	}
	public void resume(){
		if(paused){
			endTime = System.currentTimeMillis() + timeLeft;
			this.paused = false;
		}
	}
	public void pause() {
		this.paused = true;
	}
	
	private void setDuration(long duration){
		if(!run){
			if(duration > 0){
				this.duration = duration;
			}else{
				throw new IllegalArgumentException("The duration can't be 0 or less");
			}
		}else{
			throw new IllegalArgumentException("Can't set the duration while the timer is on");
		}
	}
	
	private void reset(){
		endTime = 0;
		startTime = 0;
		timeLeft = 0;
		run = false;
		paused = false;
		setDuration(1);
	}
}
