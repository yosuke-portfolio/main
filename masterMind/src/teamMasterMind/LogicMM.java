package teamMasterMind;

public class LogicMM {
	public boolean masterMindLogic(PlayerResult result, AnsNum cpu) {
		boolean judge = false;

		//CPUの数字をインスタンスから取り出す
		String ansStr = cpu.getAnsNum();
		int ansNum = Integer.parseInt(ansStr);
//		System.out.println(ansStr); //テスト用
		// cpuの数字を4つに分解
		int[] ans = new int[4];
		ans[0] = ansNum / 1000;
		ans[1] = (ansNum - ans[0] * 1000) / 100;
		ans[2] = (ansNum - ans[0] * 1000 - ans[1] * 100) / 10;
		ans[3] = (ansNum - ans[0] * 1000 - ans[1] * 100 - ans[2] * 10);

		//PlayerResultから数字を取り出し分解
		int player = Integer.parseInt(result.getPlayerResult());
		int hit = 0;
		int blow = 0;

		// プレイヤーの数字を4つに分解
		int playerSen = player / 1000;
		int playerHyaku = (player - playerSen * 1000) / 100;
		int playerJu = (player - playerSen * 1000 - playerHyaku * 100) / 10;
		int playerIti = (player - playerSen * 1000 - playerHyaku * 100 - playerJu * 10);

		// 千の位を確認
		if (playerSen == ans[0]) {
			hit++;
		} else {
			for (int j = 0; j < ans.length; j++) {
				if (ans[j] == playerSen) {
					blow++;
					break;
				}
			}
		}

		// 百の位を確認
		if (playerHyaku == ans[1]) {
			hit++;
		} else {
			for (int j = 0; j < ans.length; j++) {
				if (ans[j] == playerHyaku) {
					blow++;
					break;
				}
			}
		}

		// 十の位を確認
		if (playerJu == ans[2]) {
			hit++;
		} else {
			for (int j = 0; j < ans.length; j++) {
				if (ans[j] == playerJu) {
					blow++;
					break;
				}
			}
		}

		// 一の位を確認
		if (playerIti == ans[3]) {
			hit++;
		} else {
			for (int j = 0; j < ans.length; j++) {
				if (ans[j] == playerIti) {
					blow++;
					break;
				}
			}
		}

		//hit の判定 ヒットが4ならゲームクリア画面
		if (hit == 4) {
			judge = true;
		}
		result.setHit( String.valueOf(hit) );
		result.setBlow( String.valueOf(blow) );

		return judge;
	}
}
