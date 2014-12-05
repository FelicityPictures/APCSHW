public class SuperArray{
  int size;
  String[] data;

  public SuperArray(){
    this(10);
  }

  public SuperArray(int startCapacity){
    size = 0;
    data = new String[ startCapacity ];
  }
		
  public String toString(){
    String res = "[";
    for(int i = 0; i < size; i++){
      res += data[i];
      if(i != size - 1){
        res += " ";
      }
    }
    return res + "]";
  }

  public void add(String o){
    if(size() == data.length){
      resize(size * 2);
    }
    data[ size ] = o;
    size++;
  }
  public void add(int index, String o){
    if(index < 0 || index > size() ){
      throw new IndexOutOfBoundsException();
    }				
    if(size() == data.length){
      resize( size * 2 );
    }
    for(int i = data.length - 1; i > index; i--){
      data[i] = data[i - 1];
    }
    data[ index ] = o;
    size++;
  }

  public int size(){
    return size;
  }

  public void clear(){
    size = 0;
  }

  public void resize(int newCapacity){
    String[] newData = new String[newCapacity];
    int max = Math.min(newCapacity,size);
    for(int i = 0; i < max; i++){
      newData[i]= data[i];
    }
    data = newData;
  }
		
  public String set(int index, String o){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    String temp = data[index];
    data[index]= o;
    return temp;
  }

  public String get(int index){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public String remove(int index){
    if(index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }

    String temp = data[index];
    while(index < size() - 1){
      data[index] = data[index + 1];
      index++;
    }
    size--;
    if(size < data.length / 4){
      resize(data.length / 2);
    }
    return temp;
  }

  public void insertionSort(){
    for(int i = 1; i<size()-1;i++){
      int result = data[i].compareTo(data[i+1]);
      String x = new String(data[i]);
      String y = new String(data[i+1]);
      if(result>0){
        data[i] = y;
        data[i+1]=x;
      }
      for(int m = i;m>0;m--){
        String z = new String(data[m-1]);
        result = y.compareTo(z);
        if(result<0){
          data[m]=z;
          data[m-1]=y;
        }
      }
    }
  }

    public void selectionSort(){
	for(int m=0; m<size-1; m++){
	    String s=data[m];
	    for(int i=m; i<size-1; i++){
		int result = data[i].compareTo(data[i+1]);
		if(result>0){
		    s = data[i+1];
		    remove(i+1);
		}
	    }
	    if(!s.equals(data[m])){
		add(m,s);
	    }
	}
    }

    public int find(String t){
	for(int i=0;0<size;i++){
	    if(data[i].equals(t)){
		return i;
	    }
	}
	return -10;
    }

  public static void main(String[]args){
    SuperArray test = new SuperArray();
    test.add("dog");
    test.add("cat");
    test.add("frog");
    test.add("beetle");
    test.add("cows");
    test.add("turtle");
    test.add("hedgehog");
    test.add("chameleon");
    test.add("lion");
    test.add("ferret");
    test.add("bird");
    System.out.println(test.toString());
    //testing find method
    /*
 try{
      System.out.println(test.find("lion"));
    }catch(Exception e){
      System.out.println("String not found in the array.");
      }
    */
}
