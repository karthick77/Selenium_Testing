package laowoorks;


public class AnyomousClass {

	public static void main(String[] args) {

		AClass a1 = new AClass(){
			
			public void display() {
				System.out.println("My Class Display");
			}
			
			public void show() {
				System.out.println("My Class Show");
			}
		};
		
		a1.display();
		a1.show();
	}

}
