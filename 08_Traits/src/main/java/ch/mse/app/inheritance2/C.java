package ch.mse.app.inheritance2;

public class C extends B implements IA, IB {
	final _A _super;

	C() {
		_super = new _A(this);
	}

	@Override
	public void foo() {
		System.out.println("C::foo");
		_super._foo();
	}

	@Override
	public void bar() {
		System.out.println("C::bar");
		test();
	}

}
