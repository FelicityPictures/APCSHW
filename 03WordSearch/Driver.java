public class Driver{
    public static void main(String[]args){
	WordGrid x = new WordGrid(5,5);
	System.out.println(x.toString());

	x.addWord("meow",3,0);
	System.out.println(x.toString());
    }
}
