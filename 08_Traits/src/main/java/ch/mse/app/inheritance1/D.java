package ch.mse.app.inheritance1;

interface B {
	default int getValue() { return 1; }
}

interface C {
	default int getValue() { return 2; }
}


public class D implements B, C {

	public int getValue() {
		return C.super.getValue();
	}

}
