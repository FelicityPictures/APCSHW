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

  public void loadWordsFromFile(String fileName, boolean fillRandomLetters)
    throws FileNotFoundException{
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
        if (data[i][m] != '_') {
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
  private boolean addWordHorizontal(String word,int row, int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row][column + i] == '_' || data[row][column + i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean addWordHorizontalB(String word,int row,int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row][column - i] == '_' ||
            data[row][column - i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean addWordVertical(String word,int row,int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row + i][column] == '_' ||
            data[row + i][column] == word.charAt(i)){
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
      
  private boolean addWordVerticalB(String word,int row,int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row - i][column] == '_' ||
            data[row - i][column] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
      
  private boolean addWordDiagD(String word, int row, int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row + i][column + i] == '_' ||
            data[row + i][column + i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }
  
  private boolean addWordDiagU(String word, int row, int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row - i][column + i] == '_' ||
            data[row - i][column + i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean addWordDiagBD(String word, int row, int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row + i][column - i] == '_' ||
            data[row + i][column - i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean addWordDiagBU(String word, int row, int column){
    try {
      for (int i = 0; i < word.length(); ++i) {
        if (data[row - i][column - i] == '_' ||
            data[row - i][column - i] == word.charAt(i)) {
          continue;
        }
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
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

  public void addWordDD(String word, int row, int column){
    if(addWordDiagD(word, row, column)){
      for(int m = 0; m<word.length();m++){
        data[row + m][column + m] = word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordDU(String word, int row, int column){
    if(addWordDiagU(word, row, column)){
      for(int m = 0; m<word.length();m++){
        data[row - m][column + m] = word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordDBD(String word, int row, int column){
    if(addWordDiagBD(word, row, column)){
      for(int m = 0; m<word.length();m++){
        data[row + m][column - m] = word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }

  public void addWordBU(String word, int row, int column){
    if(addWordDiagBU(word, row, column)){
      for(int m = 0; m<word.length();m++){
        data[row - m][column - m] = word.charAt(m);
      }
      wordsUsed.add(word);
    }
  }
  
  public void addWordsRandomly(ArrayList<String>addWords){
    for(int i = 0; i<addWords.size() ; i++){
      int p = r.nextInt(8);
      int rr = r.nextInt(data.length);
      int cc = r.nextInt(data[0].length);
      if(p == 0){
        addWordH(addWords.get(i),rr,cc);
      }
      if(p == 1){
        addWordHB(addWords.get(i),rr,cc);
      }
      if(p == 2){
        addWordV(addWords.get(i),rr,cc);
      }
      if(p == 3){
        addWordVB(addWords.get(i),rr,cc);
      }
      if(p == 4){
        addWordDD(addWords.get(i),rr,cc);
      }
      if(p == 5){
        addWordDU(addWords.get(i),rr,cc);
      }
      if(p == 6){
        addWordDBD(addWords.get(i),rr,cc);
      }
      if(p == 7){
        addWordBU(addWords.get(i),rr,cc);
      }
    }
    wordsUsed=addWords;
  }
  
  public static void main(String[]args)throws FileNotFoundException{
      
    if (args.length != 3 && args.length != 4) {     
      System.out.println("Usage:");
      System.out.println("java WordGrid <rows> <columns> [seed <answer>]");
      return;
    }
      

    //set up empty word search grid
    String s = args[0];
    String w = args[1];
    int ro = Integer.parseInt(s);
    int col = Integer.parseInt(w);
    WordGrid x = new WordGrid(ro,col);
    String rs = args[2];
    int rands = Integer.parseInt(rs);
    if(rands>=0){
      x.setSeed(rands);
    }
      

    //test it out
    x.addWordH("meow",3,0);
    System.out.println(x.toString());
    
    x.addWordHB("woof",3,3);
    System.out.println(x.toString());
    
    x.addWordV("rawr",0,2);
    System.out.println(x.toString());
    
    x.addWordVB("evil",3,1);
    System.out.println(x.toString());
  }
}
