package Generics;

public class Pair<T,S>{
      private T first;
      private S second;
      
      public Pair() {
    	  
      }
      public Pair(T first , S second) {
    	  this.first = first;
    	  this.second = second;
      }
      public T getfirst() {
    	  return first;
      }
      public void setfirst(T first) {
    	  this.first= first;
      }
      public S getsecond() {
    	  return second;
      }
      public void setsecond(S second) {
    	  this.second=second;
      }
}
