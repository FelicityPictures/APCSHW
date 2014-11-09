import java.util.Random;
import java.util.Scanner;
public class Game{
    public static void output(String r){
	System.out.println(r);
    }

    public static void output(Adventurer player){
	System.out.println(player.toString());
    }

    //default or custom party?
    public static Adventurer[] life(){
	Scanner input = new Scanner(System.in);
	Random r = new Random();
	Adventurer[] Team = new Adventurer [2];
	output("Welcome to Demacia, adventurer. Would you like to live the a life the government has already decided for you or be free?");
	output("A. I WANT TO BE FREE!");
	output("B. I like my life now");
	String lifeChoice = "";
	while (!lifeChoice.equals("A") && !lifeChoice.equals("B")){
	    lifeChoice = input.nextLine();
	    if(!lifeChoice.equals("A") && !lifeChoice.equals("B")){
		output("The choice you have made is invalid. Try again.");
	    }
	}
	switch (lifeChoice) {
	case "A":
	    makePlayers(Team);
	    break;
	case "B":
	    output("You have decided to be a law abiding citizen and live your life how the government wants you to. You are a fight in Demacia's army. Your job will be to patrol the borders of Demacia, making sure its lands are safe from the danger of getting invaded by Noxus. Your travelling companion is your sister, who is one of the army's top mages. A typical day in your lives would go something like this: ");
	    Team[0] = new Warrior("Garen",50);
	    Team[1] = new Wizard("Lux",50);
	    Team[0].startingHP = Team[0].getHP();
	    Team[1].startingHP = Team[1].getHP();
	}
	return Team;
    }

    //make custom party
    public static Adventurer[] makePlayers(Adventurer[] Team){
	Scanner input = new Scanner(System.in);
	Random r = new Random();
	//create yourself
	output("\n"+"You refused to be another mindless citizen of Demacia. Because of this, you are now on the run from the officials.");
	try {
	    Thread.sleep(3000);}
	catch (Exception e){}
	output("Select your profession. The only way to be live is to fight. The borders of Demacia are not safe.");
	output("A. Wizard");
	output("B. Warrior");
	output("C. Rogue");
	output("D. Martial Artist");

	String classSelect = "";
	while (!classSelect.equals("A") && !classSelect.equals("B") && !classSelect.equals("C") && !classSelect.equals("D")){
	    classSelect = input.nextLine();
	    if(!classSelect.equals("A") && !classSelect.equals("B") && !classSelect.equals("C") && !classSelect.equals("D")){
		output("The choice you have made is invalid. Try again.");
	    }
	}
	output("\n" + "What's your name?");
	String playerName = input.nextLine();
	switch (classSelect) {
	case "A":
	    Team[0] = new Wizard(playerName,50);
	    output("\n" + "Magic would make you have a strong mind, but a weak body. Be careful, " + playerName + ".");
	    break;
	case "B":
	    Team[0] = new Warrior(playerName,50);
	    output("\n" + "Your blade will protect you, but be sure not to cut yourself on it " + playerName + ".");
	    break;
	case "C":
	    Team[0] = new Rogue(playerName,50);
	    output("\n" + "This fighting style requires you to be quick both in mind and body, but don't forget who you were " + playerName + ".");
	    break;
	case "D":
	    Team[0] = new MartialArtist(playerName,50);
	    output("\n" + "Your strength can save or kill you. Don't overexert yourself, " + playerName + ".");
	    break;
	}
	//set stats
	try {
	    Thread.sleep(1000);}
	catch (Exception e){}
	output("You are given 30 stat points. These points help strengthen your character and make them more efficient. You can invest these points into dexterity, strength, and intelligence. The higher your dexterity, the better your chances of hitting your enemies are. Warriors, rogues, and martial artists utilize strength. Wizards depend on intelligence more.");
	int start = 30;
	try {
	    Thread.sleep(7000);}
	catch (Exception e){}
	output("How many points would you like to invest into dexterity?");
	int dex = input.nextInt();
	while (dex>start || dex<0){
	    dex = input.nextInt();
	    if(dex>start || dex<0){
		output("The number of points you tried to invest into your dexterity is invalid. Try again.");
	    }
	}
	Team[0].setDEX(dex);
	output("" + dex + " points have been invested into your dexterity.");
	try {
	    Thread.sleep(1500);}
	catch (Exception e){}

	output("You have " + (start-dex) + " points left to be used. How many would you like to invest into your strength?");
	int str = input.nextInt();
	while(str>(start-dex) || str<0){
	    str = input.nextInt();
	    if(str>(start-dex) || str<0){
		output("The number of points you tried to invest into strength is invalid. Try again.");
	    }
	}
	Team[0].setSTR(str);
	output("" + str + " points have been invested into your strength.");
	try {
	    Thread.sleep(1500);}
	catch (Exception e){}
	output("You have " + (start - (dex + str)) + " points left. These will be invested into your intelligence.");
	int intel = start - (Team[0].getDEX() + Team[0].getSTR());
	Team[0].setINT(intel);
	try {
	    Thread.sleep(1500);}
	catch (Exception e){}
	//create your companion
	output("Jarven, your best friend, was also tired of abiding by the rigid laws of Demacia. He ran away with you, but has some memory lose.");
	try {
	    Thread.sleep(2000);}
	catch (Exception e){}
	output("What was his profession again?");
	output("A. Wizard");
	output("B. Warrior");
	output("C. Rogue");
	output("D. Martial Artist");

	classSelect = "";
	while (!classSelect.equals("A") && !classSelect.equals("B") && !classSelect.equals("C") && !classSelect.equals("D")){
	    classSelect = input.nextLine();
	    if(!classSelect.equals("A") && !classSelect.equals("B") && !classSelect.equals("C") && !classSelect.equals("D")){
		output("The choice you have made is invalid. Try again.");
	    }
	}
	
  	switch (classSelect) {
	case "A":
	    Team[1] = new Wizard("Jarvan",50);
	    output("\n" + "Oh! That's right. Jarvan is a wizard.");
	    break;
	case "B":
	    Team[1] = new Warrior("Jarvan",50);
	    output("\n" + "Oh! That's right. Jarvan is a warrior.");
	    break;
	case "C":
	    Team[1] = new Rogue("Jarvan",50);
	    output("\n" + "Oh! That's right. Jarvan is a rogue");
	    break;
	case "D":
	    Team[1] = new MartialArtist("Jarvan",50);
	    output("\n" + "Oh! That's right. Jarvan is a martial artist");
	    break;
	}
	output("Jarven has 30 points to be used on his stats. Help him invest them.");
	int startJ = 30;
	try {
	    Thread.sleep(1000);}
	catch (Exception e){}
	output("How many points would you like to invest into Jarven's dexterity?");
	int dexJ= input.nextInt();
	while (dexJ>start || dexJ<0){
	    dexJ = input.nextInt();
	    if(dexJ>start || dexJ<0){
		output("The number of points you tried to invest into dexterity is invalid. Try again.");
	    }
	}
	Team[1].setDEX(dexJ);
	output("" + dexJ + " points have been invested into Jarven's dexterity.");
	try {
	    Thread.sleep(1500);}
	catch (Exception e){}


	output("You have " + (startJ-dexJ) + " points left to be used. How many would you like to invest into strength?");
	int strJ= input.nextInt();
	while(strJ>(startJ-dexJ) || strJ<0){
	    strJ = input.nextInt();
	    if(strJ>(startJ-dexJ) || strJ<0){
		output("The number of points you tried to invest into strength is invalid. Try again.");
	    }
	}
	Team[1].setSTR(strJ);
	output("" + strJ + " points have been invested into Jarven's strength.");
	try {
	    Thread.sleep(1500);}
	catch (Exception e){}


	output("You have " + (startJ - (dexJ+strJ)) + " points left. These will be invested into Jarven's intelligence.");
	int intelJ= startJ - (dexJ+strJ);
	Team[1].setINT(intelJ);
	Team[0].startingHP = Team[0].getHP();
	Team[1].startingHP = Team[1].getHP();
	try {
	    Thread.sleep(1000);}
	catch (Exception e){}
	output("\n" + "Being a fugitive of the law is not easy. Every day, you have to continue moving so the Demacian officials don't catch you. On top of that, Noxians have been slowly creeping beyond the borders into Demacian territory. They would often try to kill you and Jarven. Speaking of Noxians...");
	try {
	    Thread.sleep(5000);}
	catch (Exception e){}
	return Team;
    }

    public static Adventurer challenged(){
	Random r = new Random();
	output("\n" + "A Noxian has challenged you to a duel!");
	try {
	    Thread.sleep(2000);}
	catch (Exception e){}
	int opponentClass = r.nextInt(4);
	int opponentHealth = r.nextInt(50)+30;
	Adventurer opponent = null;
	switch (opponentClass){
	case 0:
	    opponent = new MartialArtist("Urgot",opponentHealth);
	    output("You accept the duel against the martial artist, " + opponent + ".");
	    break;
	case 1:
	    opponent = new Wizard("LeBlanc",opponentHealth);
	    output("You accept the duel against the dark mage, " + opponent + ".");
	    break;
	case 2:
	    opponent = new Warrior("Jax",opponentHealth);
	    output("You accept the duel against the fighter, " + opponent + ".");
	    break;
	case 3:
	    opponent = new Rogue("Talon",opponentHealth);
	    output("You accept the duel against the thief, " + opponent + ".");
	    break;
	}
	return opponent;
    }

    public static void combat(Adventurer[] Team, Adventurer opponent){
	Scanner input = new Scanner(System.in);
	Random r = new Random();
	
	boolean turn = r.nextBoolean();
	if(turn){
	    output(opponent + " made the first move.");
	try {
	    Thread.sleep(1000);}
	catch (Exception e){}
	    boolean qwer = r.nextBoolean();
	    if(qwer){
		opponent.attack(Team[0]);
	    }else{
		opponent.specialAttack(Team[0]);
		}
	}else{
	    output("You decide to attack first.");
	}

	for(int i = 1; (Team[0].getHP()>0 || Team[1].getHP()>0) && opponent.getHP()>0; i++){
	    String whatToDo = "";
	    //You attack
	    whatToDo = input.nextLine();
	    if(Team[0].getHP()>0 && opponent.getHP()>0){
		output("********************Round " + i + " ***************************");
		output("\n" + "Your Team:" + "\n" + Team[0].getStats() + "\n" + Team[1].getStats());
		output("\n" + "Your Opponent:" + "\n" + opponent.getStats());
		output("\n" + "What will you do?");
		output("A. Attack.");
		output("B. Special Attack.");
		output("C. Give up.");
		while(!whatToDo.equals("A") && !whatToDo.equals("B") && !whatToDo.equals("C")){
		    whatToDo = input.nextLine();
		    if(!whatToDo.equals("A") && !whatToDo.equals("B") && !whatToDo.equals("C")){
			output("The choice you have made is invalid. Try again.");
		    }
		}
	    }
	    switch(whatToDo){
	    case "A":
		Team[0].attack(opponent);
		break;
	    case "B":
		Team[0].specialAttack(opponent);
		break;
	    case "C":
		Team[0].setHP(0);
		break;
	    }
	    if (Team[0].getHP()<=0){
		output("\n" + Team[0].getName() + " has been rendered unable to fight.");
	    }
	
	    //companion attacks
	    try {
		Thread.sleep(2000);}
	    catch (Exception e){}
	    String whatToDoj = "";
	    if(Team[1].getHP()>0 && opponent.getHP()>0){
		output("\n" + "Your Team:" + "\n" + Team[0].getStats() + "\n" + Team[1].getStats());
		output("\n" + "Your Opponent:" + "\n" + opponent.getStats());
		output("\n" + "What will " + Team[1]+ " do?");
		output("A. Attack.");
		output("B. Special Attack.");
		output("C. Give up.");
		while(!whatToDoj.equals("A") && !whatToDoj.equals("B") && !whatToDoj.equals("C")){
		    whatToDoj = input.nextLine();
		    if(!whatToDoj.equals("A") && !whatToDoj.equals("B") && !whatToDoj.equals("C")){
			output("The choice you have made is invalid. Try again.");
		    }
		}

		switch(whatToDoj){
		case "A":
		    Team[1].attack(opponent);
		    break;
		case "B":
		    Team[1].specialAttack(opponent);
		    break;
		case "C":
		    Team[1].setHP(0);
		    break;
		}
	
		if (Team[1].getHP()<=0){
		    output("\n" + Team[1].getName() + " has been rendered unable to fight.");
		}
	    }
	

	    //Noxian attacks
	    if((Team[0].getHP()>0 || Team[1].getHP()>0) && opponent.getHP()>0){
		int w = r.nextInt(2);
		int a = r.nextInt(2);
		try {
		    Thread.sleep(2000);}
		catch (Exception e){}
		if(w==0 && Team[0].getHP()>0){
		    if(a==0){
			opponent.attack(Team[0]);
		    }else{
			opponent.specialAttack(Team[0]);
		    }
		}else{
		    if(a==0){
			opponent.attack(Team[1]);
		    }else{
			opponent.specialAttack(Team[1]);
		    }
		}
	    }
	}
   	    if(Team[0].getHP()<=0 && Team[1].getHP()<=0){
		output("\n" + "Your team is no longer able to battle. You have lost your lives and the game.");
	    }

	    if(opponent.getHP()<=0){
		output("\n" + "You have defeated the Noxian! Victory is yours... for now. Would you like to continue your journey or are you going to settle down for the night?");
		output("A. Continue");
		output("B. I want you settle down for the night");
		String fightMore = "";
		while (!fightMore.equals("A") && !fightMore.equals("B")){
		    fightMore = input.nextLine();
		    if(!fightMore.equals("A") && !fightMore.equals("B")){
			output("The choice you have made is invalid. Try again.");
		    }
		}
		switch (fightMore) {
		    //heal or basically reset character?
		case "A":
		    Team[0].toHeal(Team[0].startingHP);
		    Team[1].toHeal(Team[1].startingHP);
		    story(Team,opponent);
		    break;
		
		    //End game
		case "B":
		    output("Tired and hungry, you and " + Team[2].getName() + " set up camp for the night and go to bed. Good nights.");
		    break;
		}
	    }
    }
    public static void action(Adventurer[] Team,Adventurer opponent){
	Team = life();
	opponent = challenged(/*the parameters don't matter here at all*/);
	System.out.println("Opponent:"+opponent);
	System.out.println("Team:"+Team[0]+" & " + Team[1]);
	combat(Team,opponent);
    }
    public static void story(Adventurer[] Team,Adventurer opponent){
	opponent = challenged();
	combat(Team,opponent);
    }
    
    public static void main(String[] args){
	Random r = new Random();
	Scanner input = new Scanner(System.in);
	Adventurer[] party = null;
	Adventurer foe = null;
	action(party,foe);
	input.close();
    }
}
