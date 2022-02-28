package bankApp;

import java.util.Scanner;

public class bankApp {

	
		public static void main(String[] args) {
			BankAccount testAccount = new BankAccount("testName", "testID");
			testAccount.showMenu();
		}

	}

	class BankAccount {
		int balance;
		int prevTrans;
		String name;
		String customerID;

		BankAccount(String cname, String cid) {
			name = cname;
			customerID = cid;
		}

		void deposit(int num) {
			int oldBalance = balance;
			balance += num;
			prevTrans = num;
			System.out.println(num + " was added to the " + name + " account");
			System.out.println("Old " + name + "account balance: " + oldBalance + "\n" + "New  " + name
					+ "account balance: " + balance);
		}

		void withdraw(int num) {
			int oldBalance = balance;
			balance -= num;
			prevTrans = -num;
			System.out.println(num + " was removed to the " + name + " account");
			System.out.println("Old " + name + "account balance: " + oldBalance + "\n" + "New  " + name
					+ "account balance: " + balance);
		}

		void printLastTrans() {
			String transaction;// = (prevTrans > 0) ? "Deposited " : "Withdrawn ";
			if (prevTrans > 0) {
				transaction = "Deposited ";
			} else {
				transaction = "Withdrawn ";
				prevTrans = Math.abs(prevTrans);
			}

			System.out.println("Previous transaction: " + transaction + prevTrans);
		}

		void checkBal() {
			System.out.println(name + " current balance: " + balance);
		}

		void showMenu() {
			Scanner scanner = new Scanner(System.in);

			char option = '\0';

			do {
				System.out.println("Welcome, " + name + "please select one of the following options below:");
				System.out.println("A. Check Balance \n " + "B. Deposit \n " + "C. Withdraw \n "
						+ "D. Veiw previous transaction \n " + "E. exit");
				System.out.print("Enter choice: ");
				option = scanner.next().charAt(0);
				System.out.println("\n");

				switch (option) {
				case 'a': {
					checkBal();
					break;
				}
				case 'b': {
					System.out.print("Enter deposit amount: ");
					int amount = scanner.nextInt();
					deposit(amount);
					break;
				}
				case 'c': {
					System.out.print("Enter withdraw amount: ");
					int amountB = scanner.nextInt();
					withdraw(amountB);
					break;
				}
				case 'd': {
					printLastTrans();
					break;
				}
				case 'e': {
					option = 'e';
					break;
				}
				default: {
					System.out.println("Invalid selection");
					break;
				}
				}

			} while (option != 'e');
			System.out.println("thanks bye");
		}

	}
