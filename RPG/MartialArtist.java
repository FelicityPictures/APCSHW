import java.util.Random;
public class MartialArtist extends Adventurer{
    private Random r = new Random();
    private int bonusHealth,bonusSTR,bonusDEX,Qi;

    public MartialArtist(){
	super("Lee Sin");
	bonusHealth = 5;
	bonusSTR = 3;
	bonusDEX = 4;
	Qi = 40;
	setHP(getHP() + bonusHealth);
    }

    public MartialArtist(String s){
	super(s);
	bonusHealth = 5;
	bonusSTR = 3;
	bonusDEX = 4;
	Qi = 40;
	setHP(getHP() + bonusHealth);
    }

    public MartialArtist(String s,int startHP){
	super(s,startHP);
	bonusHealth  = 5;
	bonusSTR = 3;
	bonusDEX = 4;
	Qi = 40;
	setHP(getHP() + bonusHealth);
    }

    public int getDEX(){
	return super.getDEX()+bonusDEX;
    }

    public int getSTR(){
	return super.getSTR()+bonusSTR;
    }

    public int getQi(){
	return Qi;
    }

    public void setQi(int q){
	Qi = q;
    }

    public String getStats(){
	return "Name:" + getName() + "\t" + "HP:" + getHP() + "\t" + "STR:" + getSTR() + "\t" + "DEX:" + getDEX() + "\t" + "INT:" + getINT() + "\t" + "Qi:" + getQi();
    }

    public void attack(Adventurer other){
	if (Qi>=2){	
	    if (hit(other) || hit(other)){
		Random damage = new Random(r.nextInt());
		int d = damage.nextInt(getSTR()/2)+1;
		other.setHP(other.getHP() - d);
		Qi = Qi - 2;
		System.out.println(this.getName() + " karate chops " + other.getName() + " and deals " + d + " damage!");
	    }else{
		System.out.println(this.getName() + " karate chops " + other.getName() + "... and misses");
	    }
	}else{
	    System.out.println(getName() + " does not have enough Qi to use a special attack. " + getName() + " must skip a turn in order to regain Qi.");
		Qi = Qi + 2;
	}
    }

    public void specialAttack(Adventurer other){
	if(Qi>=5){
	    if(hit(other) || hit(other)){
		Random damage = new Random(r.nextInt());
		int d = damage.nextInt(getSTR())+1;
		other.setHP(other.getHP() - d);
		System.out.println( this.getName() + " roundhouse kicks " + other.getName() + " and deals " + d + " damage!");
	    }else{
		System.out.println(this.getName() + " roundhouse kicks " + other.getName() + "... and misses");
	    }
	    Qi = Qi - 5;
	}else{
	    System.out.println(getName() + " does not have enough Qi to use a special attack so instead...");
	    attack(other);
	}
    }

    public void toHeal(int initialHP){
	setHP(initialHP);
	setQi(40);
    }

}
