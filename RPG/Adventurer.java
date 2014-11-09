import java.util.Random;

public abstract class Adventurer{
    private String Name;
    private int HP,DEX,STR,INT;
    public int startingHP;
    private Random r = new Random();

    public Adventurer(String n,int startHP){
	Name = n;
	HP = startHP;
	DEX = 10;
	STR = 10;
	INT = 10;
    }

    public Adventurer(String n){
	this(n,50);
    }

    public Adventurer(){
	this("n00bslayer123",50);
    }

    public String getName(){
	return Name;
    }

    public int getHP(){
	return HP;
    }

    public int getDEX(){
	return DEX;
    }

    public int getSTR(){
	return STR;
    }

    public int getINT(){
	return INT;
    }

    public void setHP(int h){
	HP = h;
    }

    public void setDEX(int d){
	DEX = d;
    }

    public void setSTR(int s){
	STR = s;
    }

    public void setINT(int i){
	INT = i;
    }

    public String toString(){
	return getName();
    }

    public String getStats(){
	return "Name:" + getName() + "\t" + "HP:" + getHP() + "\t" + "STR:" + getSTR() + "\t" + "DEX:" + getDEX() + "\t" + "INT:" + getINT();
    }

    public boolean hit(Adventurer other){
	int i = (r.nextInt(3));
	int hh = getDEX()/other.getDEX();
	if (i<=hh){
	    return true;
	}else{
	    return false;
	}
    }

    public abstract void attack(Adventurer other);

    public abstract void specialAttack(Adventurer other);
    
    public abstract void toHeal(int initialHP);
}
