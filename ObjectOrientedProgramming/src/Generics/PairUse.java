package Generics;

public class PairUse {
     public static void main(String[]args) {
    	 Pair<String , Integer> pInner = new Pair<String , Integer>();
    	 
    	 Pair<Pair<String , Integer > , String> p = new Pair<>();
    	 
    	 p.setfirst(pInner);
    	 System.out.println(p.getfirst());
    	 
    	 p.setsecond("Mayur");
    	 System.out.println(p.getsecond());
     }
}
