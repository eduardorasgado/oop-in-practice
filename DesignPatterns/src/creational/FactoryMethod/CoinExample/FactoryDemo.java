package creational.FactoryMethod.CoinExample;

public class FactoryDemo {

	public static void main(String[] args) {
		System.out.println(CoinFactory.getCoin(CoinType.GOLD).getDescription());
	}
}
