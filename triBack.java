public class triBack{
    public static String triBack(int size){
	int h = 1;
	int w = 1;
	String triangle = "";

	while (h<=size){
	    String stars = "";

	    while (w<h+1){
		w = 1;
		while ((size - w)>=h){
		    stars = stars + " ";
		    w = w + 1;
		}

		while ((size - w)<h){
		    stars = stars + "*";
		}
		w = w + 1;
	    }

	    triangle = triangle + "\n" + stars;
	    h = h + 1;
	}

	return triangle;

    }

    public static void main(String[]args){
	System.out.println(triBack(5));
	System.out.println(triBack(6));
	System.out.println(triBack(7));
    }
}
