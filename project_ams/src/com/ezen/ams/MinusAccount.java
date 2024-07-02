package com.ezen.ams;

public class MinusAccount extends Account {
//    추가필드 // 사용하려면 강제형변환 필요
    private long borrowMoney;
    
//    생성자
    public MinusAccount(){}

    public MinusAccount(String accountNum, String accountOwner, int passwd, long balance, long borrowMoney) {
        super(accountNum, accountOwner, passwd, balance);
        this.borrowMoney = borrowMoney;
    }

//    겟
    public long getBorrowMoney() {
        return borrowMoney;
    }

//    셋
    public void setBorrowMoney(long borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

//    메소드 오버라이딩
//    남은대출금액 - 대출금액
    @Override
    public long getBalance() {
        return super.getBalance() - borrowMoney;
    }

    @Override
    public void printAll() {
        String allInfo = getAccountNum() + "\t" + getAccountOwner() + "\t" + "****" + "\t" + getBalance() + "\t" + borrowMoney;
        System.out.println(allInfo);
    }
}
