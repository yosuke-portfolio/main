package timeBlackjack;

public class Main {

	public static void main(String[] args) {
		Stack yama = new Stack();//山札を作る
		Dealer dealer = new Dealer();//ディーラー登場
		Player player = new Player();//プレイヤー登場

		//ディーラーが山札をシャッフル
		dealer.shuffle(yama);

		//プレイヤーが2枚カードを引く
		player.draw(yama);
		player.draw(yama);

		//ディーラーが2枚カードを引く
		dealer.draw(yama);
		dealer.draw(yama);

		//ディーラーの手札
		dealer.openDealerHand(dealer);

		//プレイヤーの手札を表示
		player.openHand(player);

		//ディーラーのブラックジャックを判定
		String judge = dealer.judgeBJ(dealer);
		if (judge == "BJ") {
			return;
		}

		//プレイヤーの選択
		player.sentaku(yama);

		//プレイヤーのブラックジャックを判定
		judge = player.judgeBJ(player);
		if (judge == "BJ") {
			return;
		}

		//バーストの判定
		judge = player.judgeBurst(player);
		if (judge == "burst") {
			return;
		}

		//ディーラーのターン
		dealer.hit(yama);

		//ディーラーのバースト判定
		judge = dealer.judgeBurst(dealer);
		if (judge == "burst") {
			return;
		}


		//お互いの手札、合計値を再確認
		player.openHand(player);
		dealer.openHand(dealer);


		dealer.battleJudge(player, dealer);
		System.out.println("ゲームを終了します。");

	}

}
