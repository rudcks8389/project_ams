package com.ezen.ams;

// AccountApplication 클래스를 재사용 가능하게 만든 클래스
// 계좌 목록 관리
public class AccountService {
//  필드
    private Account[] accounts;
    private MinusAccount[] minusAccounts;
    private int count;

//  생성자
    public AccountService() {
        accounts = new Account[100];
    }

    public AccountService(int capacity) {
        accounts = new Account[capacity];
    }

//  getter, 계좌 목록 기능
    public Account[] getAccounts() {
        return accounts;
    }

    public MinusAccount[] getMinusAccounts() {
        return minusAccounts;
    }

    public int getCount() {
        return count;
    }

    //  setter, 수정 기능, 계좌등록 후 set 사용시 기존 데이터 삭제 가능성 있음
//    public void setAccounts(Account[] accounts) {
//        this.accounts = accounts;
//    }

//  계좌 생성
    public void addAccount(Account account){
        accounts[count++] = account;
//        count++;
    }

//  입금
    public long depositAccount(String accountNum, long money){
        long balance = 0;
        boolean find = false;
        Account findAccount = findAccount(accountNum);
        if (findAccount != null) {
            balance = findAccount.deposit(money);
            find = true;
        }
        if (!find) {
            balance = -1;
        }
        return balance;
    }

//  출금
    public long withdrawAccount(String accountNum, long money) {
        long balance = 0;
        boolean find = false;
        Account findAccount = findAccount(accountNum);
        if (findAccount != null) {
            balance = findAccount.withdraw(money);
            find = true;
        }
        if (!find) {
            balance = -1;
        }
        return balance;
    }
//  계좌 검색
        public Account findAccount (String accountNum){
            for (int i = 0; i < count; i++) {
                Account account = accounts[i];
                if (account.getAccountNum().equals(accountNum)) {
                    return account;
                }
            }
            return null;
        }

//  계좌 삭제
    public boolean removeAccount(String accountNum){
        for (int i = 0; i < count; i++) {
//            Account account = accounts[i];
//            String num = account.getAccountNum();
//            boolean same = accounts[i].getAccountNum().equals(accountNum);

//          삭제하고자 하는 객체일 경우
            if (accounts[i].getAccountNum().equals(accountNum)) {
                for (int j = i; j < count-1; j++) {
                    accounts[j] = accounts[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }
}