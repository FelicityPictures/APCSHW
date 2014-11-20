public class Driver{
    public static void main(String[]args){
	WordGrid x = new WordGrid(5,5);
	System.out.println(x.toString());

	x.addWordHorizontal("meow",3,2);
	System.out.println(x.toString());
    }
}