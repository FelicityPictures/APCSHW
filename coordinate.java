public class coordinate{
    private int x;
    private int y;
    public coordinate(){
	x = 2;
	y = 13;
    }
    public void setx(int coordinate1){
	x = coordinate1;
    }
    public void sety(int coordinate2){
	y = coordinate2;
    }
    public void setxy(int coordinate1, int coordinate2){
	x = coordinate1;
	y = coordinate2;
    }
    public int coordinate1(){
	return x;
    }
    public int coordinate2(){
	return y;
    }
    public String toString (){
	return "(" + x + "," + y + ")";
    }
}
