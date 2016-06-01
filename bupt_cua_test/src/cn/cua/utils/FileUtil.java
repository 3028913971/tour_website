package cn.cua.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;





import org.apache.commons.io.FileUtils;

public class FileUtil {
	public static void appendAsFile2(String content, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println(path+"�����ɹ�");
			}
			
			FileUtils.write(file, "\n"+content,"UTF-8",true);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void appendAsFile( String content,String fileName) {   
        FileWriter writer = null;  
        try {     
            // ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�     
            writer = new FileWriter(fileName, true);     
            writer.write(content);       
        } catch (IOException e) {     
            e.printStackTrace();     
        } finally {     
            try {     
                if(writer != null){  
                    writer.close();     
                }  
            } catch (IOException e) {     
                e.printStackTrace();     
            }     
        }   
    }     
	
	public static void main(String[] args) {
		FileUtil.appendAsFile("\nddddddddddd", "D:/log.txt");
		//FileUtil.method2("D:/log.txt", "\nddddddddddd");
	}

}
