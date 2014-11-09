import java.util.Random;
public class Wizard extends Adventurer{   
    private Random r = new Random(); 
    private int Mana,bonusINT,bonusDEX;

    public Wizard(){
	super("Xerath");
	bonusDEX = 1;
	bonusINT = 5;
	Mana = 10;
    }

    public Wizard(String s){
	super(s,50);
	bonusDEX = 1;
	bonusINT = 5;
	Mana = 10;
    }

    public Wizard(String s, int startHP){
	super(s,startHP);
	bonusDEX = 1;
	bonusINT = 5;
	Mana = 10;
    }

    public int getMana(){
	return Mana;
    }

    public void setMana(int m){
	Mana = m;
    }

    public int getDEX(){
	return super.getDEX()+bonusDEX;
    }

    public int getINT(){
	return super.getINT()+bonusINT;
    }

    public String getStats(){
	return "Name:" + getName() + "\t" + "HP:" + getHP() + "\t" + "STR:" + getSTR() + "\t" + "DEX:" + getDEX() + "\t" + "INT:" + getINT() + "\t" + "Mana:" + getMana();
    }

    public boolean hitMagic(Adventurer other){
	int i = (r.nextInt(3));
	int hh = getINT()/other.getINT();
	if (i<=hh){
	    return true;
	}else{
	    return false;
	}
    }

    public void attack(Adventurer other){
        if (hit(other) || hit(other)){
	    Random damage = new Random(r.nextInt());
	    int d = damage.nextInt(getSTR()/2)+1;
	    other.setHP(other.getHP() - d);
	    System.out.println(this.getName()+ " jabs " +other.getName() + " with a staff" + " and deals " + d + " damage!");
	}else{
	    System.out.println(this.getName() + " jabs " + other.getName() + " with a staff... and misses");
	}
    }

    public void specialAttack(Adventurer other){
	if (Mana>=2){
	    if (hitMagic(other) || hitMagic(other)){
		Random damage = new Random(r.nextInt());
		int d = damage.nextInt(getINT())+1;
		other.setHP(other.getHP() - d);
		System.out.println(this.getName() + " hurls balls of fire at " + other.getName() + " and deals " + d + " damage!");
	    }else{
		System.out.println(this.getName() + " hurls balls of fire at " + other.getName() + "... and misses");
	    }
	    Mana = Mana - 2;
	}else{
	    System.out.println(getName() + " does not have enough mana to use a special attack so instead...");
	    attack(other);
	}
    }

    public void toHeal(int initialHP){
	setHP(initialHP);
	setMana(10);
    }

}
