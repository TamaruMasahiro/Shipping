package jp.co.shoeisha.example;


/**
 * 送料計算クラス
 * @author kbc11a07
 *
 */
public class Shipping {

	/**
	 * 荷物の送料を計算するメソッド
	 * @param weight 荷物の重さ(kg)
	 * @param x 荷物の縦幅(cm)
	 * @param y	荷物の縦幅(cm)
	 * @param z 荷物の高さ(cm)
	 * @return 荷物の送料
	 * @throws IllegalArgumentException
	 */
	public int calculate(int weight, int x, int y, int z) throws IllegalArgumentException{
		int price = 0;
		int total = x+y+z;
		//weightの判定
		if (weight > 30 || weight < 1)
			throw new IllegalArgumentException("");

		//x,y,zの判定
		if (total > 180 || x < 1 || y < 1 || z < 1)
			throw new IllegalArgumentException("");


		//取得したサイズを元に送料を決定する
		switch(getSize(weight, total)){
			case 'S':
				price = 600;
				break;
			case 'M':
				price = 1200;
				break;
			case 'L':
				price = 1800;
				break;
		}
		return price;
	}

	/**
	 * 荷物の合計長と重さから適正なサイズを求めるメソッド。
	 * @param weight
	 * @param total
	 * @return 荷物のサイズ
	 */
	private char getSize(int weight, int total) {

		if(total <= 60 && weight <= 10)
			return 'S';
		else if (total <= 120 && weight <= 20)
			return 'M';
		else
			return 'L';
	}
}
