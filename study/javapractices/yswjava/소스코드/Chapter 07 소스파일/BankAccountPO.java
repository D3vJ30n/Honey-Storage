package study.javapractices.yswjava.소스코드.Chapter

class BankAccountPO {
    static int balance = 0;     // ���� �ܾ�

    public static void main(String[] args) {
        deposit(10000);
        checkMyBalance();
        
        withdraw(3000);
        checkMyBalance(); 
    }

    public static int deposit(int amount) {
        balance += amount;
        return balance;
    }    

    public static int withdraw(int amount) {
        balance -= amount;
        return balance;
    }

    public static int checkMyBalance() {
        System.out.println("�ܾ� : " + balance);
        return balance;
    }

}
	
