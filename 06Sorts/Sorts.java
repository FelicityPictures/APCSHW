import java.util.*;
public class Sorts{

    public static String name(){
	return "Ng,Felicity";
    }

    public static int period(){
	return 6;
    }
    
    public static void insertion(int[]data){
	for(int i = 0; i<data.length-1;i++){
	    if(data[i]>data[i+1]){
		int x = data[i];
		data[i]=data[i+1];
		data[i+1]=x;
		for(int m = i+1;m>0;m--){
		    if(data[m]<data[m-1]){
			int t = data[m];
			data[m]=data[m-1];
			data[m-1]=t;
		    }
		}
	    }
	}
    }

    public static void selection(int[]data){
	for(int i=0; i<data.length; i++){
	    int s=data[i];
	    for(int m=i; m<data.length; m++){
		if(s>data[m]){
		    int q = s;
		    s = data[m];
		    data[m]=q;
		}
	    }
	    if(s!=data[i]){
		data[i]=s;
	    }
	}
    }

    public static void bubble(int[]data){
	for(int i=data.length-1;i>0;i--){
	    for(int w=0;w<i;w++){
		if(data[w]>data[w+1]){
		    int m = data[w];
		    data[w]=data[w+1];
		    data[w+1]=m;
		}
	    }
	}
    }

    public static void radix(int[]data){
	int[]bucket = new int[data.length];
	for(int i=0;i<data.length;i++){


	    //LEFT OFF HERE
	}}

    //From Alvin Lin's code
    public static void out(int[] c) {
	String out = "[ ";
	for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
	}
	out += c[c.length - 1] + " ]";
	System.out.println(out);
    }
	    
    public static void main(String[]args){
	int[]t = new int[11];
	t[0]=100;
	t[1]=9;
	t[2]=32;
	t[3]=3;
	t[4]=11;
	t[5]=4;
	t[6]=2;
	t[7]=0;
	t[8]=7;
	t[9]=19;
	t[10]=11;
	out(t);
	bubble(t);
	out(t);
    }
}
