import java.util.*;
import java.io.*;
public class WordGrid{
  private char[][]data;
  private ArrayList<String>words=new ArrayList<String>();
  private ArrayList<String>wordsUsed=new ArrayList<String>();
  Random r = new Random();

  /**Initialize the grid to the size specified and fill all of the positions
   *with spaces.
   *@param row is the starting height of the WordGrid
   *@param col is the starting width of the WordGrid
   */
  public WordGrid(int rows,int columns){
    data = new char[rows][columns];
    for(int i = 0; i<rows; i++){
      for(int s = 0; s<columns; s++){
        data[i][s]= '_';
      }
    }
  }

  /**Set all values in the WordGrid to spaces ' '*/
  private void clear(){
    data = new char[0][];
  }

  /**The proper formatting for a WordGrid is created in the toString.
   *@return a String with each character separated by spaces, and each row
   *separated by newlines.
   */
  public String toString(){
    String a = "";
    for (int i=0; i<data.length; i++){
      for(int s = 0; s<data[i].length; s++){
        a = a + data[i][s] + " ";
      }
      a = a + "\n";
    }
    return a;
  }

  public void loadWordsFromFile(String fileName, boolean fillRandomLetters)throws FileNotFoundException{
    File text=null;
    Scanner scan=null;
    try{
      text = new File(fileName);
      scan = new Scanner(text);
    }catch(Exception e){
      System.out.println("File was not found.");
    }
    while(scan.hasNextLine()){
      words.add(scan.nextLine());
    }
  }

  public void fillRandomLetters() {
    for (int i = 0; i < data.length; ++i) {
      for (int m = 0; m < data[i].length; ++m) {
        if (data[i][m] != ' ') {
          continue;
        }
        data[i][m] = (char)(r.nextInt(26) + 65);
      }
    }
  }

  public String wordsInPuzzle(){
    String a = "";
    int c = 0;
    for(int i=0 ; i<wordsUsed.size() ; i++){
      if(c<4){
        a = a + wordsUsed.get(i) + "/t";
        c++;
      }else{
        c = 0;
        a = a + "\n" + wordsUsed.get(i) + "/t";
        c++;
      }
    }
    return a;
  }

  public void setSeed(long seed){
    r = new Random(seed);
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from left to right, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   */
  public boolean addWordHorizontal(String word,int row, int column){
    int c=0;
    if((data[row].length-column)>=word.length()){
      for(int i = 0; i<word.length();i++){
        String x = "";
        x=x+data[row][column+i];
        String y = "_";
        if(x.equals(y)){
          c++;
        }else{
          String b = "";
          b = b+word.charAt(i);
          if(x.equals(b)){
            c++;
          }
        }
      }
    }
    if(c==word.length()){
      return true;
    }else{
      return false;
    }
  }

  public boolean addWordHorizontalB(String word,int row,int column){
    int c = 0;
    if((data[row].length-(data[row].length-column))>=(word.length()+1)){
      for(int i = 0; i<word.length(); i++){
        String x = "";
        x=x+data[row][column-i];
        String y = "_";
        if(x.equals(y)){
          c++;
        }else{
          String b = "";
          b = b + word.charAt(i);
          if(x.equals(b)){
            c++;
          }
        }
      }
    }
    if(c==word.length()){
      return true;
    }else{
      return false;
    }
  }

  public boolean addWordVertical(String word,int row,int column){
    int c = 0;
    if((data.length-row)>=word.length()){
      for(int i=0; i<word.length(); i++){
        String x = "";
        x=x+data[row+i][column];
        String y = "_";
        if(x.equals(y)){
          c++;
        }else{
          String b = "";
          b=b+word.charAt(i);
          if(x.equals(b)){
            c++;
          }
        }
      }
    }
    if(c==word.length()){
      return true;
    }else{
      return false;
    }
  }
      
 public boolean addWordVerticalB(String word,int row,int column){
    int c = 0;
    if((data.length-(data.length-row))>=word.length()){
      for(int i=0; i<word.length(); i++){
        String x = "";
        x=x+data[row-i][column];
        String y = "_";
        if(x.equals(y)){
          c++;
        }else{
          String b = "";
          b=b+word.charAt(i);
          if(x.equals(b)){
            c++;
          }
        }
      }
    }
    if(c==word.length()){
      return true;
    }else{
      return false;
    }
  }

  public void addWordH(String word,int row,int column){
    if(addWordHorizontal(word,row,column)){
      for(int m = 0;m<word.length();m++){
        data[row][column+m]=word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordHB(String word,int row,int column){
    if(addWordHorizontalB(word,row,column)){
      for(int m = 0;m<word.length();m++){
        data[row][column-m]=word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordV(String word, int row, int column){
    if(addWordVertical(word,row,column)){
      for(int m = 0; m<word.length();m++){
        data[row+m][column]=word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordVB(String word, int row, int column){
    if(addWordVerticalB(word,row,column)){
      for(int m = 0; m<word.length();m++){
        data[row-m][column]=word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }
  //vertical + diagonal should be implemented as well.


  public static void main(String[]args)throws FileNotFoundException{
      
    if (args.length != 3 && args.length != 4) {     
      System.out.println("Usage:");
      System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
      return;
    }
      

    //set up empty word search grid
    String s = args[1];
    String w = args[2];
    int ro = Integer.parseInt(s);
    int col = Integer.parseInt(w);
    WordGrid x = new WordGrid(ro,col);
    String rs = args[3];
    int rands = Integer.parseInt(rs);
    if(rands>=0){
      x.setSeed(rands);
    }
      

    //test it out
    /*  x.addWordH("meow",3,0);
        System.out.println(x.toString());
    */
    x.addWordHB("woof",3,3);
    System.out.println(x.toString());
    /*
      x.addWordV("rawr",0,2);
      System.out.println(x.toString());
    */
    x.addWordVB("evil",3,1);
    System.out.println(x.toString());
  }
}
