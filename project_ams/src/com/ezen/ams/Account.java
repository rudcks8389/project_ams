package com.ezen.ams;

/*
* 일상생활의 은행계좌(객체)를 표현한 클래스(설계도)
* */
public class Account {
//   정적 필드(static 변수)
    public static String bankName = "EZEN Bank";
//   정적 초기화 블록
//   static { }

// 상수(관례상 전부 대문자로 표기)
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;

//   인스턴스 필드(인스턴스 변수)
    private String accountNum; // 계좌번호
    private String accountOwner; // 예금주명
    private int passwd; // 비밀번호
    private long balance; // 잔액

// 생성자(constructor) 오버로딩
    public Account() {}

    public Account(String accountNum, String accountOwner) {
        this(accountNum, accountOwner, 0, 0L);
    }

    public Account(String accountNum, String accountOwner, int passwd, long balance) {
        this.accountNum = accountNum;
        this.accountOwner = accountOwner;
        this.passwd = passwd;
        this.balance = balance;
    }


    /*  숨겨진 필드의 값을 변경하거나 읽어갈 수 있도록
    setter/getter 메소드를 정의하여야 한다.
    이것을 '캡슐화'라고 한다.
 */

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public void setPasswd(int passwd) {
        this.passwd = passwd;
    }

    public void setBalance(long balance) {
//        입력된 값 검증(데이터 유효성 검증)
//  0 <= balance <= 1,000,000
        if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
            this.balance = balance;
        }
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public int getPasswd() {
        return passwd;
    }

    //    인스턴스 메소드(객체의 고유 기능)
//    입금 기능 정의
    public long deposit(long money){
//        balance = balance + money;
        balance += money;
        return balance;
    }

//    출금 기능 정의
    public long withdraw(long money){
        balance -= money;
        return balance;
    }

//    잔액 조회
    public long getBalance(){
        return balance;
    }

//    비밀번호 확인
    public boolean checkPasswd(int passwd){
        return this.passwd == passwd;
    }

//    계좌가 가지고 있는 모든 속성(필드) 출력
    public void printAll(){
        System.out.println(accountNum + "\t" + accountOwner + "\t" + "****" + "\t" + balance);
    }


//    모든 계좌 객체의 공통 기능
    public static void printBankName(){
        System.out.print("은행명 : " + bankName);
    }

}
