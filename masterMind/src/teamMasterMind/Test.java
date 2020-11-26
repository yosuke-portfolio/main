package teamMasterMind;

public class Test {

	public static void main(String[] args) {
		//CPUの数字を決定
		AnsNum cpu = new AnsNum();
		String ansStr = cpu.getAnsNum();
		int ansNum = Integer.parseInt(ansStr);
		System.out.println(ansStr);
		// cpuの数字を4つに分解
		int[] ans = new int[4];
		ans[0] = ansNum / 1000;
		ans[1] = ( ansNum - ans[0]*1000) / 100;
		ans[2] = ( ansNum - ans[0]*1000 - ans[1]*100 ) / 10;
		ans[3] = ( ansNum - ans[0]*1000 - ans[1]*100 - ans[2]*10 );

		System.out.println("");
		System.out.println("【数当てゲーム 4桁】チャンスは10回！");

		for (int i = 0; i < 10; i++) {
			System.out.println("4桁の数字を入力してください");
			int player = new java.util.Scanner(System.in).nextInt();
			int hit = 0;
			int blow = 0;

	   // プレイヤーの数字を4つに分解
			int playerSen = player / 1000;
			int playerHyaku = (player - playerSen*1000) / 100;
			int playerJu = ( player - playerSen*1000 - playerHyaku*100 ) / 10;
			int playerIti = ( player - playerSen*1000 - playerHyaku*100 - playerJu*10 );

	   // 千の位を確認
			if ( playerSen == ans[0] ){
				hit++;
			}else{
				for ( int j = 0; j < ans.length; j++ ){
					if ( ans[j] == playerSen ){
						blow++;
						break;
					}
				}
			}

		// 百の位を確認
			if ( playerHyaku == ans[1] ){
				hit++;
			}else{
				for ( int j = 0; j < ans.length; j++ ){
					if ( ans[j] == playerHyaku ){
						blow++;
						break;
					}
				}
			}

	   // 十の位を確認
	   if ( playerJu == ans[2] ){
	       hit++;
	   }else{
	       for ( int j = 0; j < ans.length; j++ ){
	           if ( ans[j] == playerJu ){
	               blow++;
	               break;
	           }
	       }
	   }

	   // 一の位を確認
	   if ( playerIti == ans[3] ){
	       hit++;
	   }else{
	       for ( int j = 0; j < ans.length; j++ ){
	           if ( ans[j] == playerIti ){
	               blow++;
	               break;
	           }
	       }
	   }

	   //hit の判定 ヒットが4なら「おめでとう」と表示してbreakで終わり
	   if( hit == 4 ){
	       System.out.println("正解！おめでとう！");
	       break;
	   }else{
	       System.out.println("Hit:" + hit + " blow:" + blow);
	       }
	   }

	   System.out.println("ゲーム終了です。お疲れさまでした。");

	}

}
