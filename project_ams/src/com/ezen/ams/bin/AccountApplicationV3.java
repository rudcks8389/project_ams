package com.ezen.ams.bin;

import com.ezen.ams.Account;
import com.ezen.ams.AccountService;

import java.util.Scanner;

public class AccountApplicationV3 {

    private static Scanner scanner = new Scanner(System.in);
    private static AccountService accountService = new AccountService();

    //  메뉴 출력
    public static void printMenu() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.계좌검색 | 6.계좌삭제 | 7.종료");
        System.out.println("----------------------------------------------------------------------------");
    }

    //  계좌 등록
    public static void createAccount() {
        String accountNum = null;
        String accountOwner = null;
        int password = 0;
        long balance = 0L;
        System.out.print("계좌번호 : ");
        accountNum = scanner.next();
        System.out.print("예금주명 : ");
        accountOwner = scanner.next();
        System.out.print("비밀번호 : ");
        password = scanner.nextInt();
        System.out.print("초기입금액 : ");
        balance = scanner.nextLong();
        // 신규계좌 생성
        Account newAccount = new Account(accountNum, accountOwner, password, balance);
        accountService.addAccount(newAccount);
        System.out.println("※ 신규 계좌(" + newAccount.getAccountNum() + ")를 등록 하였습니다..");
    }

    //  계좌 목록 출력
    public static void printAccounts() {
        Account[] accounts = accountService.getAccounts();
        printHeader();
        for (int i = 0; i < accountService.getCount(); i++) {
            printRow(accounts[i]);
        }
    }


    //  계좌 데이터 헤더 출력
    private static void printHeader() {
        System.out.println("----------------------------------------");
        System.out.println("계좌번호\t예금주명\t비밀번호\t잔액");
        System.out.println("----------------------------------------");
    }

    //  계좌 데이터 출력
    private static void printRow(Account account) {
        System.out.printf("%1$8s\t%2$4s\t%3$10s\t%4$,8d\n",
                          account.getAccountNum(),
                          account.getAccountOwner(),
                          "****",
                          account.getBalance());
    }

    //  입금
    public static void depositAccount() {
        System.out.print("계좌번호 : ");
        String inputAccountNum = scanner.next();
        System.out.print("예금액 : ");
        long inputMoney = scanner.nextLong();
        long restMoney = accountService.depositAccount(inputAccountNum, inputMoney);
        if (restMoney >= 0) {
            System.out.println("※ 정상 입금 처리되었습니다.");
            System.out.println("- 입금 후 잔액 : " + restMoney);
        } else {
            System.out.println("※ 입금하고자 하는 계좌가 존재하지 않습니다..");
        }
    }

    //  출금
    public static void withdrawAccount() {
        System.out.print("계좌번호 : ");
        String outputAccountNum = scanner.next();
        System.out.print("출금액 : ");
        long outputMoney = scanner.nextLong();
        long restMoney2 = accountService.withdrawAccount(outputAccountNum, outputMoney);
        if (restMoney2 >= 0) {
            System.out.println("※ 정상 출금 처리되었습니다.");
            System.out.println("- 출금 후 잔액 : " + restMoney2);
        } else {
            System.out.println("※ 출금하고자 하는 계좌가 존재하지 않습니다..");
        }
    }

    //  계좌번호로 검색
    public static void findByAccountNum() {
        System.out.println("검색할 계좌번호 : ");
        String accountNum = scanner.next();
        Account findAccount = accountService.findAccount(accountNum);
        if (findAccount != null) {
            printHeader();
            printRow(findAccount);
        } else {
            System.out.println("존재하지 않는 계좌번호 입니다.");
        }
    }

    //  계좌번호로 삭제
    public static void removeByAccountNum() {
        System.out.println("삭제할 계좌번호: ");
        String accountNum = scanner.next();
        boolean isDelete = accountService.removeAccount(accountNum);

        if (isDelete) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("존재하지 않는 계좌입니다.");
        }
    }

//  메인메소드
    public static void main(String[] args) {
        System.out.println("****************************************");
//        System.out.println("*** " + Account.bankName + "은행 계좌 관리 프로그램 ***");
        System.out.println("****************************************");

        boolean running = true;

        // 테스트를 위한 샘플(더미) 데이터 입력
        accountService.addAccount(new Account("1111-2222", "김기정", 1111, 100000));
        accountService.addAccount(new Account("1111-3333", "김찬규", 1111, 10000));
        accountService.addAccount(new Account("1111-4444", "김희주", 1111, 1000));

        while(running) {
            printMenu();
            System.out.print("선택 > ");
            int menuNum = scanner.nextInt();
            switch (menuNum) {
                case 1:
                    createAccount();
                    break;
                case 2: // 전체계좌 목록 조회
                    printAccounts();
                    break;
                case 3: // 예금
                    depositAccount();
                    break;
                case 4: // 출금
                    withdrawAccount();
                    break;
                case 5: // 계좌번호로 검색
                    findByAccountNum();
                    break;
                case 6: // 계좌 삭제
                    removeByAccountNum();
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다..");
                    //return;
                    running = false;
                    break;
            }
        }


    }
}
