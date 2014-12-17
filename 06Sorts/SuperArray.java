public class SuperArray{
  int size;
  int[] data;

  public SuperArray(){
    this(10);
  }

  public SuperArray(int startCapacity){
    size = 0;
    data = new int[ startCapacity ];
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

  public void add(int o){
    if(size() == data.length){
	    resize(size * 2);
    }
    data[ size ] = o;
    size++;
  }
  public void add(int index, int o){
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
    int[] newData = new int[newCapacity];
    int max = Math.min(newCapacity,size);
    for(int i = 0; i < max; i++){
	    newData[i]= data[i];
    }
    data = newData;
  }
		
  public int set(int index, int o){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    int temp = data[index];
    data[index]= o;
    return temp;
  }

  public int get(int index){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public int remove(int index){
    if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
    }

    int temp = data[index];
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

  public void bubbleSort(){
    for(int i=size-1;i>0;i--){
      for(int w=0;w<i;w++){
        if(data[w]>data[w+1]){
          int m = data[w];
          data[w]=data[w+1];
          data[w+1]=m;
        }
      }
    }
  }

  public static void main(String[]args){
    SuperArray t = new SuperArray();
    t.add(100);
    t.add(9);
    t.add(32);
    t.add(3);
    t.add(11);
    t.add(4);
    t.add(2);
    t.add(0);
    t.add(7);
    t.add(19);
    t.add(11);
    System.out.println(t.toString());
    t.bubbleSort();
    System.out.println(t.toString());
  }
}
