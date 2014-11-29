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
        String y = "";
        y=y+'_';
        if(x.equals(y)){
          c++;
        }else{
          String a = "";
          a = a + data[row][column+i];
          String b = "";
          b = b+word.charAt(i);
          if(a.equals(b)){
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
  public void addWord(String word,int row,int column){
    if(addWordHorizontal(word,row,column)){
      for(int m = 0;m<word.length();m++){
	    data[row][column+m]=word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }
    //vertical + diagonal should be implemented as well.

}
