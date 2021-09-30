
public class Game {
	private int gID;
	private String gName;
	private String gPlatform;
	public int getgID() {
		return gID;
	}
	public void setgId(int gID) {
		this.gID = gID;
	}	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgPlatform() {
		return gPlatform;
	}
	public void setgPlatform(String gPlatform) {
		this.gPlatform = gPlatform;
	}
	public Game(int gID, String gName, String gPlatform) {
		super();
		this.gID = gID;
		this.gName = gName;
		this.gPlatform = gPlatform;
	}
	public Game(String gName, String gPlatform) {
		super();
		this.gName = gName;
		this.gPlatform = gPlatform;
	}

}
