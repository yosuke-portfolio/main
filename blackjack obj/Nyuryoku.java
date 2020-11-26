package timeBlackjack;

public class Nyuryoku {

	public static int pNyuryoku() {
		int select = 10;

		while (!(select == 0 || select == 1)) {
			System.out.print("0:STAND 1:HIT を入力>");
			String pSelect = new java.util.Scanner(System.in).nextLine();
			String hSelect = null;

			boolean fullOut = pFullOut(pSelect);
			if (fullOut) {
				hSelect = numHenkan(pSelect);
				select = Integer.parseInt(hSelect);
				if (!(select == 0 || select == 1)) {
					System.out.println("指定の数字以外が入力されました");
					continue;
				}
			} else {
				System.out.println("数字以外が入力されました");
				continue;
			}
		}
		if (select == 0) {
			System.out.println("STANDが選択されました");
		} else if (select == 1) {
			System.out.println("HITが選択されました");
		}
		System.out.println();
		return select;
	}

	public static boolean pFullOut(String pSelect) {
		for (int i = 0; i < pSelect.length(); i++) {

			//i文字めの文字についてCharacter.isDigitメソッドで判定する
			if (Character.isDigit(pSelect.charAt(i))) {

				//数字の場合は次の文字の判定へ
				continue;
			} else {
				//数字でない文字がひとつでも含まれていたらfalseを返す
				return false;
			}
		}
		return true;
	}

	public static String numHenkan(String str) {
		String result = null;
		if (str != null) {
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < sb.length(); i++) {
				int c = (int) sb.charAt(i);
				if (c >= 0xFF10 && c <= 0xFF19) {
					sb.setCharAt(i, (char) (c - 0xFEE0));
				}
			}
			result = sb.toString();
		}
		return result;
	}

}
