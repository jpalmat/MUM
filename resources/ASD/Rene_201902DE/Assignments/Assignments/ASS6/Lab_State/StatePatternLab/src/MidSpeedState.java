
public class MidSpeedState implements State {
	
	private CeilingFan fan;

	public MidSpeedState(CeilingFan fan) {
		this.fan = fan;
	}

	@Override
	public void pullGreen() {
		// TODO Auto-generated method stub
		fan.state = fan.high;
	}

	@Override
	public void pullRed() {
		// TODO Auto-generated method stub
		fan.state = fan.low;
		
	}
	
	public String toString() {
		return "medium speed";
	}

}
