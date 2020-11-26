package timeBlackjack;

public class Dealer extends People {
	public void shuffle( Stack yama ) {
		for (int i = 0; i < yama.stack.length; i++){
		    int r = new java.util.Random().nextInt(52);
		    String saf = yama.stack[i];
		    yama.stack[i] = yama.stack[r];
		    yama.stack[r] = saf;
		}
	}

	public void hit( Stack yama ) {
		while( this.getHandTotal() < 17 ) {
			draw( yama );
			this.setHandTotal( hantei() );
		}
	}

	public void openDealerHand(Dealer dealer) {
		System.out.println("ディーラーの手札");
		System.out.println( dealer.getHand(0) + " ??" );
		System.out.println("");
	}

	public void battleJudge( Player player, Dealer dealer ) {
		int pNum = player.hantei();
		int pNumA = player.hanteiA();
		if( pNum != pNumA ) {
			if( pNumA <= 21 ) {
				pNum = pNumA;
			}
		}

		int dNum = dealer.hantei();
		int dNumA = dealer.hanteiA();
		if( dNum != dNumA ) {
			if( dNumA <= 21 ) {
				dNum = dNumA;
			}
		}
		if ( dNum >= pNum ) {
			System.out.println("残念。あなたの負け。");
		}else {
			System.out.println("あなたの勝ち！！");
		}


	}



}
