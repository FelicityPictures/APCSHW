public class SuperArray{
  private int length;
  public String[] data;
    
  public SuperArray(){
    data = new String[10];
  }
    
  public SuperArray(int size){
    if(size<0){
      throw new IndexOutOfBoundsException();
    }
    setLength(size);
    data = new String[size];
  }
    
  public int getLength(){
    return length;
  }

  private void setLength(int l){
    length = l;
  }
    
  public String toString(){
    String display = "[ ";
    for(int i=0; i<getLength(); i++){
      display = display + data[i] + " ";
    }
    display = display + "]";
    return display;
  }

  public void add(String e){
    resize(getLength()+1);
    data[getLength()-1]=e;
  }

  public void add(int index, String e){
    if(index<0 || index>(getLength()-1)){
      throw new IndexOutOfBoundsException();
    }
    int t = 0;
    int place=0;
    for(int i = index; i<getLength(); i++){
	    if (data[i] == null){
        place = i;
        t++;
        break;
	    }
    }
    if(t>0){
	    for(int i=place; i>index; i--){
        data[i]=data[i-1];
	    }
    }else{
	    resize(getLength()+1);
	    for(int i=getLength()-1; i>index; i--){
        data[i]=data[i-1];
	    }
    }
    data[index]=e;
  }

  public int size(){
      int c=0;
      for(int i = 0; i<getLength();i++){
	  if(data[i]!= null){
	      c++;
	  }
      }
      return c;
  }

  public void resize(int newSize){
    String[]newData = new String [newSize];
    if(newSize>getLength()){
	    for(int i=0; i<getLength(); i++){
        newData[i]=data[i];
      }
    }else{
	    for(int i=0; i<newSize; i++){
        newData[i]=data[i];
      }
    }
    setLength(newSize);
    data=newData;
  }

  public void clear(){
    resize(0);
  }

  public String get(int index){
    if(index<0 || index>(getLength()-1)){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  public String set(int index, String e){
    if(index<0 || index>(getLength()-1)){
      throw new IndexOutOfBoundsException();
    }
    String replaced = new String();
    replaced = data[index];
    data[index] = e;
    return replaced;
  }

  public String remove(int index){
    if(index<0 || index>(getLength()-1)){
      throw new IndexOutOfBoundsException();
    }
    String removed = new String();
    if(index < 0  || index >= size()){
      removed=null;
    }else{
	    removed = data[index];
	    data[index] = null;
    }
    return removed;
  }

}
