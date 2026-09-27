public class Paralellogram
{
	private double a,b;
	private float alpha;

	public Paralellogram(double a, double b, float alpha)
	{
		this.a = a;
		this.b = b;
		this.alpha = alpha;
	}

	public Paralellogram(double a, double b)
	{
		this.a = a;
		this.b = b;
		this.alpha = 90;
	}

	public Paralellogram(double a)
	{
		this.a = a;
		this.b = a;
		this.alpha = 90;
	}

	public double getArea()
	{
		return a*b*Math.sin(Math.toRadians(alpha));
	}

	public double getPerimeter()
	{
		return 2*(a+b);
	}

	public int compareTo(Paralellogram other)
	{
		return Double.compare(this.getArea(), other.getArea());
	}

	public boolean isSimilar(Paralellogram other)
	{
		if (other == null)
			return false;

		boolean anglesMatch = (this.alpha == other.alpha) || (this.alpha == (180 - other.alpha));
		if (!anglesMatch)
			return false;

		return (this.a / other.a == this.b / other.b) || (this.a / other.b == this.b / other.a);
	}

	public double getSideA()
	{
		return a;
	}

	public double getSideB()
	{
		return b;
	}

	public float getAngle()
	{
		return alpha;
	}
}
