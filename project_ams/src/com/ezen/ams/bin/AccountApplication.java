package com.ezen.ams.bin;

import com.ezen.ams.Account;
import java.util.Scanner;

public class AccountApplication {
    public static void main(String[] args) {

//  프로그램 헤더
        System.out.println("**********************************");
//        System.out.println("***" + Account.printBankName() + "은행 계좌 관리 프로그램 ***");
        System.out.println("**********************************");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
//      Account account = null;
        Account[] accounts = new Account[100];
//      테스트용 더미데이터
        accounts[0] = new Account("123-123", "민경찬", 1234, 10000);
        accounts[1] = new Account("234-234", "김경찬", 1234, 10000);
        accounts[2] = new Account("345-345", "박경찬", 1234, 10000);

        int count = 3;

        while (running) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("--------------------------------------------------");

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
                    Account account = new Account(accountNum, accountOwner, passWd, balance);
//                  생성된 계좌를 배열에 저장
                    accounts[count] = account;
                    count++;

                    System.out.println("신규계좌 " + account.getAccountNum() + "가 생성되었습니다.");
                    break;

//                  전체 계좌 출력
                case 2 :
                    System.out.println("----------------------------------------");
                    System.out.println("계좌번호\t예금주명\t비밀번호\t잔액");
                    System.out.println("----------------------------------------");
                    for (int i = 0; i < count; i++) {
                        String accountNum2 = accounts[i].getAccountNum();
                        String accountOwner2 = accounts[i].getAccountOwner();
                        String passWd2 = "****";
                        long balance2 = accounts[i].getBalance();
                        System.out.println(accountNum2 + "\t" + accountOwner2 + "\t" + passWd2 + "\t" + balance2);
                    }
                    break;

//                  입금
                case 3 :
                    System.out.print("계좌번호 : ");
                    String inputAccountNum = scanner.next();
                    System.out.print("예금액 : ");
                    long inputMoney = scanner.nextLong();
                    boolean find = false;
                    for (int i = 0; i < count; i++) {
                        Account findAccount = accounts[i];
                        String accountNum3 = findAccount.getAccountNum();
//                      입력한 계좌번호가 찾아진 계좌의 게좌번호와 같으면
                        if (accountNum3.equals(inputAccountNum)) {
                            long balance3 = findAccount.deposit(inputMoney);
                            System.out.println("※ 정상 입금 처리되었습니다.");
                            System.out.println("- 입금 후 잔액 : " + balance3);
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        System.out.println("입금하고자하는 계좌가 존재하지 않습니다.");
                    }
                    break;

//                  출금
                case 4 :
                    System.out.print("계좌번호 : ");
                    String outputAccountNum = scanner.next();
                    System.out.print("출금액 : ");
                    long outputMoney = scanner.nextLong();
                    boolean isFind = false;
                    for (int i = 0; i < count; i++) {
                        Account findAccount = accounts[i];
                        String accountNum3 = findAccount.getAccountNum();
//                      입력한 계좌번호가 찾아진 계좌의 게좌번호와 같으면
                        if (accountNum3.equals(outputAccountNum)) {
                            long balance3 = findAccount.withdraw(outputMoney);
                            System.out.println("※ 정상 출금 처리되었습니다.");
                            System.out.println("- 출금 후 잔액 : " + balance3);
                            isFind = true;
                            break;
                        }
                    }
                    if (!isFind) {
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
