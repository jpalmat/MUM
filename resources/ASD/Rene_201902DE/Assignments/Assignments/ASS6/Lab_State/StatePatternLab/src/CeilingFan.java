
public class CeilingFan {
	State state;
	OffState off;
	LowSpeedState low;
	MidSpeedState mid;
	HighSpeedState high;

	public CeilingFan() {
		off = new OffState(this);
		low = new LowSpeedState(this);
		mid = new MidSpeedState(this);
		high = new HighSpeedState(this);
		state = off;
	}

	public void pullgreen() {
		state.pullGreen();
		System.out.println(state.toString());
	}

	public void pullred() {
		state.pullRed();
		System.out.println(state.toString());
	}
}
