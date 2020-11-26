package timeBlackjack;

public class Player extends People {

	public void sentaku( Stack yama) {
		int handan = Nyuryoku.pNyuryoku();

		while( handan == 1 && this.hantei() < 21 ) {
			this.draw( yama );
			String str = "";
			for ( int i = 0; i < this.getHandSize(); i++ ){
			    str += this.getHand(i) + " ";
			}
			System.out.println("プレイヤーの手札");
			System.out.println(str);

			int total = this.hantei();
			int totalA = this.hanteiA();
			if( total == totalA ) {
				System.out.println( "手札の合計：" +  total );
			}else if( totalA <= 21 ) {
				System.out.println( "手札の合計：" +  total + " / " + totalA);
			}else {
				System.out.println( "手札の合計：" +  total + " / Burst");
			}
			if ( this.getHandTotal() < 21 ) {
				handan = Nyuryoku.pNyuryoku();
			}
		}
		System.out.println();
	}

}
