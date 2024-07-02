package com.ezen.ams.bin;

import com.ezen.ams.Account;
import com.ezen.ams.AccountService;

import java.util.Scanner;

public class AccountApplicationVer3 {

    public static void printmenu(){
        System.out.println("--------------------------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
//  프로그램 헤더
        System.out.println("***************************************");
//        System.out.println("***" + Account.bankName + "은행 계좌 관리 프로그램 ***");
        System.out.println("***************************************");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
//      Account account = null;

        AccountService accountService = new AccountService();

//      테스트용 더미데이터
        accountService.addAccount(new Account("123-123", "민경찬", 1234, 10000));
        accountService.addAccount(new Account("111-111", "김경찬", 1234, 10000));
        accountService.addAccount(new Account("222-222", "박경찬", 1234, 10000));
//        accounts[0] = new Account("123-123", "민경찬", 1234, 10000);
//        accounts[1] = new Account("234-234", "김경찬", 1234, 10000);
//        accounts[2] = new Account("345-345", "박경찬", 1234, 10000);

        while (running) {
            printmenu();
            System.out.print("선택 > ");
            int menuNum = scanner.nextInt();
//            논리값비교 if, 값비교 swith
            switch (menuNum) {
                case 1:
//                    계좌번호 입력받기
                    String accountNum = null;
                    String accountOwner = null;
                    int passWd = 0;
                    long balance = 0L;

                    System.out.print("계좌번호 : ");
                    accountNum = scanner.next();
                    System.out.print("예금주명 : ");
                    accountOwner = scanner.next();
                    System.out.print("비밀번호 : ");
                    passWd = scanner.nextInt();
                    System.out.print("초기입금액 : ");
                    balance = scanner.nextLong();

//                  신규계좌 생성
                    Account newAccount = new Account(accountNum, accountOwner, passWd, balance);
                    accountService.addAccount(newAccount);
                    System.out.println("신규계좌 " + newAccount.getAccountNum() + "가 생성되었습니다.");
                    break;

//                  전체 계좌 출력
                case 2 :
//                    accountService.printAccounts();
                    break;

//                  입금
                case 3 :
                    System.out.print("계좌번호 : ");
                    String inputAccountNum = scanner.next();
                    System.out.print("예금액 : ");
                    long inputMoney = scanner.nextLong();
                    long restMoney= accountService.depositAccount(inputAccountNum, inputMoney);
                    if (restMoney >= 0) {
                        System.out.println("※ 정상 입금 처리되었습니다.");
                        System.out.println("- 입금 후 잔액 : " + restMoney);
                    } else {
                        System.out.println("※ 입금하고자 하는 계좌가 존재하지 않습니다.");
                    }
                    break;

//                  출금
                case 4 :
                    System.out.print("계좌번호 : ");
                    String outputAccountNum = scanner.next();
                    System.out.print("출금액 : ");
                    long outputMoney = scanner.nextLong();
                    long restMoney2 = accountService.withdrawAccount(outputAccountNum, outputMoney);
                    if (restMoney2 >= 0) {
                        System.out.println("※ 정상 출금 처리되었습니다.");
                        System.out.println("- 출금 후 잔액 : " + restMoney2);
                    } else {
                        System.out.println("출금하고자하는 계좌가 존재하지 않습니다.");
                    }
                    break;

//                  종료
                case 5 :
                    System.out.println("프로그램 종료");
//                    return;
                    running = false;
                    break;
            }
        }




    }
}
