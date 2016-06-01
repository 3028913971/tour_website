package cn.cua.domain;

public class ThemeInfo {
	private int themeId;
	private String themeName;
	private String themeIsTop;
	private String themeFileName;
	private String themeRealName;
	
	
	
	public ThemeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ThemeInfo(int themeId, String themeName, String themeIsTop,
			String themeFileName, String themeRealName) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
		this.themeIsTop = themeIsTop;
		this.themeFileName = themeFileName;
		this.themeRealName = themeRealName;
	}


	public int getThemeId() {
		return themeId;
	}
	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}
	public String getThemeName() {
		return themeName;
	}
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	public String getThemeIsTop() {
		return themeIsTop;
	}
	public void setThemeIsTop(String themeIsTop) {
		this.themeIsTop = themeIsTop;
	}
	public String getThemeFileName() {
		return themeFileName;
	}
	public void setThemeFileName(String themeFileName) {
		this.themeFileName = themeFileName;
	}
	public String getThemeRealName() {
		return themeRealName;
	}
	public void setThemeRealName(String themeRealName) {
		this.themeRealName = themeRealName;
	}


	@Override
	public String toString() {
		return "ThemeInfo [themeId=" + themeId + ", themeName=" + themeName
				+ ", themeIsTop=" + themeIsTop + ", themeFileName="
				+ themeFileName + ", themeRealName=" + themeRealName + "]";
	}
	
	
}
