package ch.mse.app.inheritance2;

public class _A extends A {
	private final IA extension;
	public _A(IA extension) { this.extension = extension; }
	
	public void _foo() { super.foo(); }
	public void _bar() { super.bar(); }
	
	public void foo() { extension.foo(); }
	public void bar() { extension.bar(); }
}
