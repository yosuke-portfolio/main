package teamMasterMind;

public class PlayerResult implements java.io.Serializable {
	private String playerResult;
	private String hit;
	private String blow;

	public PlayerResult() {}

	public PlayerResult( String playerResult) {
		this.playerResult = playerResult;
	}


	public String getPlayerResult() {
		return this.playerResult;
	}

	public String getHit() {
		return this.hit;
	}
	public void setHit( String hit ) {
		this.hit = hit;
	}

	public String getBlow() {
		return this.blow;
	}
	public void setBlow( String blow ) {
		this.blow = blow;
	}

}
