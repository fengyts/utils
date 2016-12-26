package com.lhs.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtil {

	public static void createJaveSourceFile(String path, String fileName, String writeString) throws IOException {
		String allPath = path + File.separator + fileName;
		File file = new File(allPath);
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		out.write(writeString.getBytes());
		out.flush();
		out.close();
	}

}