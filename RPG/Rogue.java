import java.util.Random;
public class Rogue extends Adventurer{
    private int Stamina,bonusDEX;
    private Random r = new Random();

    public Rogue(){
	super("Phantom");
	bonusDEX = 5;	
	Stamina = 30;
    }

    public Rogue(String s){
	super(s);
	bonusDEX = 5;
	Stamina = 30;
    }

    public Rogue(String s,int startHP){
	super(s,startHP);
	bonusDEX = 5;
	Stamina  = 30;
    }

    public int getDEX(){
	return super.getDEX()+bonusDEX;
    }

    public int getStamina(){
	return Stamina;
    }

    public void setStamina(int e){
	Stamina = e;
    }

    public String getStats(){
	return "Name:" + getName() + "\t" + "HP:" + getHP() + "\t" + "STR:" + getSTR() + "\t" + "DEX:" + getDEX() + "\t" + "INT:" + getINT() + "\t" + "Stamina:" + getStamina();
    }

    public void attack(Adventurer other){
        if (hit(other) || hit(other)){
	    Random damage = new Random(r.nextInt());	    
	    int d = damage.nextInt(getSTR()/2)+1;
	    other.setHP(other.getHP() - d);
	    System.out.println(this.getName() + " attacks " + other.getName() + " and deals " + d + " damage!");
        }else{
	    System.out.println(this.getName() + " attacks " + other.getName() + "... and misses");
        }
    }

    public void specialAttack(Adventurer other){
	if (Stamina>=5){
	    if (hit(other) || hit(other)){
		Random damage = new Random(r.nextInt());
		int d = damage.nextInt(getSTR())+1;
		other.setHP(other.getHP() - d);
		System.out.println(this.getName() + " throws daggers at " + other.getName() + " and deals " + d + " damage!");
	    }else{
		System.out.println(this.getName() + " throws daggers at " + other.getName() + "... and misses");
	    }
	    Stamina = Stamina - 5;
	}else{
	    System.out.println(getName() + " does not have enough stamina to use a attack so instead...");
	    attack(other);
	}
    }

    public void toHeal(int initialHP){
	setHP(initialHP);
	setStamina(30);
    }

}
