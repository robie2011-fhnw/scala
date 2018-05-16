package ch.mse.app.inheritance2;

public class A implements IA {

	@Override
	public void foo() {
		System.out.println("A::foo");
		this.bar();
	}

	@Override
	public void bar() {
		System.out.println("A::bar");
	}

}
