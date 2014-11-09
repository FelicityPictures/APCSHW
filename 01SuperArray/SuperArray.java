public class SuperArray{
    private int length;
    public Object[] data;
    
    public SuperArray(){
	setLength(10);
	data = new Object[10];
    }
    
    public SuperArray(int size){
	setLength(size);
	data = new Object[size];
    }
    
    public int getLength(){
	return length;
    }

    public void setLength(int l){
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

    public void add(Object e){
	resize(getLength()+1);
	data[getLength()-1]=e;
    }

    public void add(int index, Object e){
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
	return getLength();
    }

    public void resize(int newSize){
	Object[]newData = new Object [newSize];
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
	for(int i=0; i<getLength(); i++){
	    data[i] = null;
	}
    }

    public Object get(int index){
	if(index < 0  || index >= size()){
	    return "Error. Index is out of range.";
	}else{
	    return data[index];
	}
    }

    public Object set(int index, Object e){
	if(index < 0  || index >= size()){
	    return null;
	}else{
	    Object replaced = new Object();
	    replaced = data[index];
	    data[index] = e;
	    return replaced;
	}
    }

    public Object remove(int index){
	Object removed = new Object();
	if(index < 0  || index >= size()){
	    removed=null;
	}else{
	    removed = data[index];
	    data[index] = null;
	}
	return removed;
    }

}
