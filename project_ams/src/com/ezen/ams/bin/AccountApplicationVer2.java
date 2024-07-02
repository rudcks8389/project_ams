package com.ezen.ams.bin;

import com.ezen.ams.Account;
import com.ezen.ams.AccountService;

public class AccountApplicationVer2 {
    public static void main(String[] args) {
//      AccountService accountService = new AccountService(); > 디폴트생성 > [100]
        AccountService accountService = new AccountService(10);

//  신규 계좌 등록
        Account account = new Account("123-123", "민경찬", 1234, 10000);
        accountService.addAccount(account);

        accountService.addAccount(new Account("234-234", "김경찬", 1234, 10000));

//  계좌 목록 출력
//        accountService.printAccounts();

//  입금
        String accountNum = "123-123";
        long inputMoney = 10000;
        long balance = accountService.depositAccount(accountNum, inputMoney);

//  정상 입금 처리시
        if (balance > 0) {
            System.out.println("※ 정상 입금 처리되었습니다.");
            System.out.println("- 입금 후 잔액 : " + balance);
        } else {
            System.out.println("※ 입금하고자 하는 계좌가 존재하지 않습니다.");
        }

//  출금
        long outputMoney = 10000;
        balance = accountService.withdrawAccount(accountNum, outputMoney);

//  정상 출금 처리시
        if (balance >= 0) {
            System.out.println("※ 정상 출금 처리되었습니다.");
            System.out.println("- 출금 후 잔액 : " + balance);
        } else {
            System.out.println("※ 출금하고자 하는 계좌가 존재하지 않습니다.");
        }



    }
}
