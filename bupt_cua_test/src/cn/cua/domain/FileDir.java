package cn.cua.domain;

public class FileDir {
	private String dirName;
	private String fileName;
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public FileDir(String dirName, String fileName) {
		super();
		this.dirName = dirName;
		this.fileName = fileName;
	}
	public FileDir() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FileDir [dirName=" + dirName + ", fileName=" + fileName + "]";
	}
	
	
}
