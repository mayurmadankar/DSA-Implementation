package Classes_and_Objects;

public class FractionUse {

	public static void temp() {
		// TODO Auto-generated method stub
        Fraction f1 = new Fraction(20,30);
        f1.print();
//        2/3
        
        f1.setnumerator(12);
//        4/1
        int d = f1.getdenominator();
        System.out.println(d);
//        1
        f1.print();
//        4
        f1.setnumerator(10);
        int i=50;
        
        try {
        	 i++;
            f1.setdenominator(0); 
            i++;
        }
        catch(ZeroDenominatorException e){
        	System.out.println("dont give input as zero");
        	System.out.println(i);
        }
         //  1/3
        f1.print();
        
        
        Fraction f2 = new Fraction(3,4);
        f1.add(f2);
        f1.print();
//        f1=>13/12
        f2.print();
//        f2=>3/4
        
        Fraction f3 = new Fraction(4,5);
        f3.multiply(f2);
        f3.print();
//      f3=>3/5
        f2.print();
//        f2=>3/4
        
        Fraction f4 = Fraction.add(f1,f3);
        f1.print();
        f3.print();
        f4.print();
	}
	public static void main(String []args) throws ZeroDenominatorException{
		temp();
	}
}

  