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
		if(task == 2)
			taskTwo(scanner);
		if(task == 3)
			taskThree(scanner);
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

	public static void taskTwo(Scanner scanner)
	{
		Paralellogram a = new Paralellogram(2, 3, 45);
		Paralellogram b = new Paralellogram(4, 6, 135);

		System.out.printf("Parallelogram 1 (%.2f, %.2f, %.2f) \nArea = %.2f, Perimeter = %.2f \n\n",
				a.getSideA(), a.getSideB(), a.getAngle(),
				a.getPerimeter(), a.getPerimeter());
		System.out.printf("Parallelogram 2 (%.2f, %.2f, %.2f) \nArea = %.2f, Perimeter = %.2f \n\n",
				b.getSideA(), b.getSideB(), b.getAngle(),
				b.getPerimeter(), b.getPerimeter());
		System.out.printf("Are the two parallelograms similar? - %b\n", a.isSimilar(b));
		System.out.printf("Are the two parallelograms equal? - %b\n\n", a.equals(b));
	}

	public static void taskThree(Scanner scanner)
	{
		BinaryTree tree = new BinaryTree(0);

		System.out.println("---- Adding elements ----");
		System.out.println("Input '0' to stop adding elements to the tree");
		while(true)
		{
			System.out.print("- ");
			int element = scanner.nextInt();
			if(element == 0)
			{
				System.out.println("Finished adding elements");
				break;
			}
			System.out.println();

			if(tree.contains(element))
				System.out.printf("Tree already contains [%d] \n", element);
			else tree.insert(element);
			System.out.printf("Added [%d] to the binary tree \n", element);
		}

		System.out.printf("\nSmallest value in the binary tree: %d \n\n", tree.getSmallestValue());

		System.out.println("---- Removing ----");
		System.out.println("Input '0' to stop removing elements from the tree");
		while(true)
		{
			System.out.print("- ");
			int element = scanner.nextInt();
			if(element == 0)
			{
				System.out.println("Finished removing elements");
				break;
			}
			System.out.println();

			if(tree.contains(element))
			{
				tree.remove(element);
				System.out.printf("Removed element [%d] \n", element);
			}
			else System.out.printf("The tree doesn't contain element [%d] \n", element);
		}
		System.out.println(tree);
	}
}
