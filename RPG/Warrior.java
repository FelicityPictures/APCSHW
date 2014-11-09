import java.util.Random;
public class Warrior extends Adventurer{
    private Random r = new Random();
    private int bonusHealth,bonusSTR,bonusDEX,Rage;

    public Warrior(){
	super("Darius");
	bonusHealth = 10;
	bonusSTR = 4;
	bonusDEX = 3;
	Rage = 0;
	setHP(getHP() + bonusHealth);
    }
 
    public Warrior(String s){
	super(s);
	bonusHealth = 10;
	bonusSTR = 4;
	bonusDEX = 3;
	Rage = 0;
	setHP(getHP() + bonusHealth);
    }
    
    public Warrior(String s,int startHP){
	super(s,startHP);
	bonusHealth  = 10;
	bonusSTR = 4;
	bonusDEX = 3;
	Rage = 0;
	setHP(getHP() + bonusHealth);
    }
    
    public int getDEX(){
	return super.getDEX()+bonusDEX;
    }
    
    public int getSTR(){
	return super.getSTR()+bonusSTR;
    }

    public int getRage(){
	return Rage;
    }

    public void setRage(int r){
	Rage = r;
    }

    public String getStats(){
	return "Name:" + getName() + "\t" + "HP:" + getHP() + "\t" + "STR:" + getSTR() + "\t" + "DEX:" + getDEX() + "\t" + "INT:" + getINT() + "\t" + "Rage:" + getRage();
    }

    public void attack(Adventurer other){
	if (hit(other) || hit(other)){
	    Random damage = new Random(r.nextInt());
	    int d = damage.nextInt(getSTR()/2)+1;
	    other.setHP(other.getHP() - d);
	    Rage = Rage + 1;
	    System.out.println(this.getName() + " charges at " + other.getName() + " and deals " + d + " damage!");
	}else{
	    System.out.println(this.getName() + " rushes forward to attack " + other.getName() + "... and misses");
	}
    }

    public void specialAttack(Adventurer other){
	if(Rage>0){
	    if(hit(other) || hit(other)){
		Random damage = new Random(r.nextInt());
		int d = damage.nextInt(getSTR())+1;
		other.setHP(other.getHP() - d);
	    System.out.println( this.getName() + " swings the sword at " + other.getName() + " and deals " + d + " damage!");
	    }else{
	    System.out.println(this.getName() + " swings the sword at " + other.getName() + "... and misses");
	    }
	    Rage = Rage - 1;
	}else{
	    System.out.println(getName() + " does not have enough rage to use a special attack so instead...");
	    attack(other);
	}
    }
    
    public void toHeal(int initialHP){
	setRage(0);
	setHP(initialHP);
    }
}
