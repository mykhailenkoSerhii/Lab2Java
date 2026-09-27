public class Money
{
	private int b1, b2, b5, b10, b20, b50, b100, b200, b500;
	private int c1,c2,c5,c10,c25,c50;

	private double total;

	public Money(double total)
	{
		setFromTotal(total);
	}

	private void setFromTotal(double total)
	{
		this.total = total;

		b500 = (int) (total/500);
		total -= b500*500;

		b200 = (int) (total/200);
		total -= b200*200;

		b100 = (int) (total/100);
		total -= b100*100;

		b50 = (int) (total/50);
		total -= b50*50;

		b20 = (int) (total/20);
		total -= b20*20;

		b10 = (int) (total/10);
		total -= b10*10;

		b5 = (int) (total/5);
		total -= b5*5;

		b2 = (int) (total/2);
		total -= b2*2;

		b1 = (int) total;
		total -= b1;

		total *= 100;

		c50 = (int) (total/50);
		total -= c50*50;

		c25 = (int) (total/25);
		total -= c25*25;

		c10 = (int) (total/10);
		total -= c10*10;

		c5 = (int) (total/5);
		total -= c5*5;

		c2 = (int) (total/2);
		total -= c2*2;

		c1 = (int) total;
	}

	public double getTotal()
	{
		return total;
	}

	public void add(Money money)
	{
		this.setFromTotal(this.getTotal()+money.getTotal());
	}

	public void sub(Money money)
	{
		double subTotal = this.getTotal()-money.getTotal();
		if(subTotal <= 0)
			subTotal = 0;
		this.setFromTotal(subTotal);
	}

	public void div(Money money)
	{
		this.setFromTotal(getTotal()/money.getTotal());
	}

	public void div(double total)
	{
		this.setFromTotal(getTotal()/total);
	}

	public boolean greaterThan(Money money)
	{
		return this.getTotal()>money.getTotal();
	}

	public boolean lesserThan(Money money)
	{
		return this.getTotal()<money.getTotal();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Money money)
			return this.getTotal() == money.getTotal();
		return super.equals(obj);
	}

	@Override
	public String toString()
	{
		return String.format("%.2f грн", getTotal()).replace('.', ',');
	}
}
