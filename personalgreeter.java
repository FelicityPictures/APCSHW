public class personalgreeter{
    private String greeting = "Hello, ";
    private String name;
    public void greetpersonally(String username){
	System.out.println(greeting + username);
    }
    public void greetpersonally(){
	System.out.println(greeting + name);
    }
    public void setName(String username){
	name = username;
    }
}
