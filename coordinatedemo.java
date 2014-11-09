public class coordinatedemo{
    public static void main(String[]args){
	coordinate coordinate1,coordinate2;
	coordinate1 = new coordinate();
	coordinate2 = new coordinate();
	coordinate1.orderedpair();
	coordinate2.orderedpair();
    }
    public coordinate(String r){
	toString = r;
    }
    public void result(){
	System.out.println(toString);
    }
}
