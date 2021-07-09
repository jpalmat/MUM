
public class HighSpeedState implements State {
	
	private CeilingFan fan;

	public HighSpeedState(CeilingFan fan) {
		this.fan = fan;
	}

	@Override
	public void pullGreen() {
		// TODO Auto-generated method stub
		fan.state = fan.off;
	}

	@Override
	public void pullRed() {
		// TODO Auto-generated method stub
		fan.state = fan.mid;
		
	}
	
	public String toString() {
		return "high speed";
	}

}
