
public class LowSpeedState implements State {
	
	private CeilingFan fan;

	public LowSpeedState(CeilingFan fan) {
		this.fan = fan;
	}

	@Override
	public void pullGreen() {
		// TODO Auto-generated method stub
		fan.state = fan.mid;
	}

	@Override
	public void pullRed() {
		// TODO Auto-generated method stub
		fan.state = fan.off;
		
	}
	
	public String toString() {
		return "low speed";
	}

}
