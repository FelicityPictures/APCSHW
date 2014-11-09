public class BankAccount{
    private String username, password;
    private int accountNumber, pin;
    private double balance;

    public BankAccount(){
	username = "John Smith";
	password = "moneyinthebank1234";
	accountNumber = 234903950;
	pin = 2341;
	balance = 50000;
    }

    public BankAccount(String u, String pw, int a, int pn, double b){
	username = u;
	password = pw;
	accountNumber = a;
	pin = pn;
	balance = b;
    }

    public String getUsername(){
	return username;
    }
    public void setUsername(String u){
	username = u;
    }

    public String getPassword(){
	return password;
    }
    public void setPassword(String pw){
	password = pw;
    }

    public int getAccountNumber(){
	if (accountNumber>100000000 && accountNumber<999999999){
	    return accountNumber;
	}else{
	    return 999999999;
	}
    }
    public void setAccountNumber(int a){
	accountNumber = a;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double b){
	balance = b;
    }

    public int getPin(){
	return pin;
    }
    public void setPin(int pn){
	pin = pn;
    }


    public boolean deposit(double d){
	if (d>0){	
	    balance = balance + d;
	    return true;
	}else{
	    return false;
	}
    }

    public boolean withdraw(double w){
	if (w > 0 && w < balance){
	    balance = balance - w;
	    return true;
	}else{
	    System.out.println("Error: Withdrawal could not be completed");
	    return false;
	}
    }

    public boolean authenticate(int inputNumber, String inputPassword){
	if (inputNumber == accountNumber && inputPassword == password){
	    return true;
	}else{
	    return false;
	}
    }

    public void print(){
	System.out.println(username);
	System.out.println(password);
	System.out.println(accountNumber);
	System.out.println(pin);
	System.out.println(balance);
    }

    public String toString(){
	if (accountNumber > 999999998){
	    return "Error: only integers between 100000000 and 999999998, inclusive, can be put in";
	}else{
	    return username + "\t" + accountNumber + "\t" + balance;
	}
    }

    public static void main(String[]args){
	BankAccount John,Mary;
	John = new BankAccount();
	Mary = new BankAccount("Mary Bloody","bleh94834",275923382,8204,10000);
	John.deposit(600);
	John.withdraw(333);
	Mary.deposit(10000);
	Mary.withdraw(90000);
	System.out.println(John.toString());
	System.out.println(Mary.toString());
    }
}
