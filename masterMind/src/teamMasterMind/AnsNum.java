package teamMasterMind;

public class AnsNum implements java.io.Serializable {
	private String[] ans;

	public AnsNum() {
		this.ans = new String[4];
		int ansNum[] = new int[4];
		for (int i = 0; i < ansNum.length; i++){
		       ansNum[i] = new java.util.Random().nextInt(9);
		       ans[i] = String.valueOf(ansNum[i]);
		 }
	}

	public String getAnsNum() {
		String ansStr = "";
		for (int i = 0; i < ans.length; i++) {
			ansStr += ans[i];
		}

		return ansStr;
	}
}
