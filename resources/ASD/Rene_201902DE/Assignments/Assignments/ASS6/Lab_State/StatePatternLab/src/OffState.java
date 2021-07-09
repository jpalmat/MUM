
public class OffState implements State {
	
	private CeilingFan fan;

	public OffState(CeilingFan fan) {
		this.fan = fan;
	}

	@Override
	public void pullGreen() {
		// TODO Auto-generated method stub
		fan.state = fan.low;
	}

	@Override
	public void pullRed() {
		// TODO Auto-generated method stub
		fan.state = fan.high;
	}
	
	public String toString() {
		return "turning off";
	}

}
