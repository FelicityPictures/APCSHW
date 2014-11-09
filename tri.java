public class tri{
    public static String tri(int size){
	int h = 0;
	int w = 0;
	String stars = "";
	String triangles = "";
	while (h<size){
	    while (w<h+1){
		stars = stars + "*";
		w = w + 1;
	    }
	    triangles = triangles + "\n" + stars;
	    h = h + 1;
	}
	return triangles;
    }
    public static void main(String[]args){
	System.out.println(tri(3));
	System.out.println(tri(2));
	System.out.println(tri(4));
    }
}
