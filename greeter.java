public class greeter{
    //instance variables - the information each object can remember
    String greeting;

    //constructor - the method that is called to instantiate an object
    public greeter(){
 greeting = "Hello!!!";
    }

    public greeter(String s){
 greeting = s;
    }

    //other methods
    public void greet(){
 System.out.println(greeting);
    }
}
