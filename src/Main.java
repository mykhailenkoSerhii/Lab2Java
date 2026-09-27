import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose Task ");
		int task = scanner.nextInt();
		if(task == 1)
			taskOne(scanner);
	}

	public static void taskOne(Scanner scanner)
	{
		System.out.println("Input Wallet 1 Money - ");
		double money1 = scanner.nextDouble();

		System.out.println("Input Wallet 2 Money - ");
		double money2 = scanner.nextDouble();

		Money wallet1 = new Money(money1);
		Money wallet2 = new Money(money2);

		System.out.println("Wallet 1 : " + wallet1);
		System.out.println("Wallet 2 : " + wallet2);

		wallet2.add(wallet1);
		System.out.println("Sum : " + wallet2);

		wallet2.sub(wallet1);
		System.out.println("Sub : " + wallet2);

		wallet1.div(wallet2);
		System.out.println("Div1 : " + wallet2);

		wallet2.div(2);
		System.out.println("Div2 : " + wallet2);

		System.out.printf("w1 > w2 - %b, w1 < w2 - %b, w1 == w2 - %b \n",
				wallet1.greaterThan(wallet2), wallet1.lesserThan(wallet2), wallet1.equals(wallet2));
	}
}
