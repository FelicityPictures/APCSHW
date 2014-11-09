public class rect{
    public static String rect(int height, int width){
	int i = 0;
	int a = 0;
	String rectangle = "";
	String shape = "";
	while (i<height){
	    while (a<width){
		shape = shape + "*";
		a = a + 1;
	    }
	    rectangle = rectangle + "\n" + shape;
	    i = i + 1;
	}
	return rectangle;
    }
    public static void main(String[]args){
    System.out.println(rect(2,3));
    System.out.println(rect(3,2));
    System.out.println(rect(4,1));
    }
}
