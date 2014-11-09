public class personalgreeterdemo{
    public static void main(String []args){
	personalgreeter Bob, Amy;
	Bob = new personalgreeter();
	Amy = new personalgreeter();
	Amy.setName("Amy");
	Bob.greetpersonally("Bob");
	Amy.greetpersonally();
    }
}
