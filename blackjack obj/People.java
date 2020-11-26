package timeBlackjack;

import java.util.ArrayList;

public class People {
//フィールド
	private ArrayList<String> hand;
    private int handTotal;
    private int handTotalA;
//コンストラクタ
    public People(){
        this.hand = new ArrayList<String>();
        this.setHandTotal(0);
        this.setHandTotalA(0);
    }

//アクセサ
    public int getHandTotal() { return this.handTotal; }
    public void setHandTotal( int handTotal ) {
    	this.handTotal = handTotal;
    }

    public int getHandTotalA() { return this.handTotalA; }
    public void setHandTotalA( int handTotal ) {
    	this.handTotalA = handTotal;
    }

    public String getHand(int num) { return this.hand.get(num); }
    public int getHandSize() { return this.hand.size(); }


//山札からカードを引く
    public void draw( Stack yama ){
        this.hand.add( yama.getCard() );
    }

//手札の合計を判断する
    public int hantei(){
        this.setHandTotal(0);
        ArrayList<Integer> handNum = new ArrayList<Integer>();
        for(int i = 0; i < this.hand.size(); i++){
        	handNum.add( Integer.parseInt( this.hand.get(i).substring(1) ) );
            if( handNum.get(i) >= 10 ){
                handNum.set( i , 10 );
            }
            int total = this.getHandTotal() + handNum.get(i);
            this.setHandTotal( total ) ;
        }
        return this.getHandTotal();
 	}
//手札の合計を判定する Aを11としてカウント
    public int hanteiA(){
        this.setHandTotalA(0);
        ArrayList<Integer> handNum = new ArrayList<Integer>();
        int aceCount = 0;
        for (int i = 0; i < this.hand.size(); i++){
        	handNum.add( Integer.parseInt( this.hand.get(i).substring(1) ) );
            if( handNum.get(i) >= 10 ){
                handNum.set( i, 10 );
            }
            if( handNum.get(i) == 1 && aceCount == 0 ) {
            	aceCount++;
            	handNum.set( i, 11 );
            }
            this.setHandTotalA( this.getHandTotalA() + handNum.get(i) );
        }
        return this.getHandTotalA();
 	}


//ブラックジャックを判定する
	public String judgeBJ( People people ) {
		if( this.hand.size() == 2 && this.hanteiA() == 21 ) {
			String str = "";
			if( people instanceof Player ) {
	    		System.out.println("プレイヤーの手札");
	    		for(int i = 0; i < this.hand.size(); i++) {
	    			str += this.hand.get(i) + " ";
	    		}
	    		System.out.println(str);
	    		System.out.println("あなたがブラックジャックです。");
	    		System.out.println("あなたの勝ち！！");
	    		System.out.println("ゲームを終了します。");
	    		return "BJ";


	    	} else if( people instanceof Dealer ) {
	    		System.out.println("ディーラーの手札");
	    		for(int i = 0; i < this.hand.size(); i++) {
	    			str += this.hand.get(i) + " ";
	    		}
	    		System.out.println(str);
	    		System.out.println("ディーラーがブラックジャックです。");
	    		System.out.println("あなたの負け。");
	    		System.out.println("ゲームを終了します。");
	    		return "BJ";
	    	}
		}
		return null;
	}

//バーストの判定
	public String judgeBurst( People people ) {
		int judge = this.hantei();
		if( judge > 21 ) {
			if( people instanceof Player ) {
	    		System.out.println("バースト");
	    		this.openHand(people);
	    		System.out.println("あなたの負け。");
	    		System.out.println("ゲームを終了します。");
	    		return "burst";
	    	} else if( people instanceof Dealer ) {
	    		System.out.println("ディーラーのバースト");
	    		this.openHand(people);
	    		System.out.println("あなたの勝ち！！");
	    		System.out.println("ゲームを終了します。");
	    		return "burst";
	    	}
		}

		return null;
	}


//手札を公開する
    public void openHand( People people ) {
    	if( people instanceof Player ) {
    		System.out.println("プレイヤーの手札");
    	} else if( people instanceof Dealer ) {
    		System.out.println("ディーラーの手札");
    	}

    	String str = "";
    	for( int i = 0; i < this.hand.size(); i++ ) {
    		str += this.hand.get(i) + " ";
    	}

    	//手札の合計を判定
    	int total = this.hantei();
    	int totalA = this.hanteiA();
    	System.out.println(str);

    	if( total == totalA ) {
    		System.out.println("手札の合計：" +  total);
    	}else {
    		if( totalA <= 21 ) {
    			System.out.println("手札の合計：" +  total + " / " + totalA);
    		}else {
    			System.out.println("手札の合計：" +  total + " / Burst");
    		}

    	}
    	System.out.println();

    }


}
