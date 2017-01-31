package com.practicaljava.lesson14;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Lists the contents of a zip file.
 * 
 * @author David Lall
 *
 */

public class ReadZipFile {
	public static void main (String[] args) {
		final String ZIP_LOCATION = "H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson14\\Stuff.zip";
		try (
			FileInputStream myFile = new FileInputStream(ZIP_LOCATION);
			ZipInputStream zipInputStream = new ZipInputStream(myFile);) {
			ZipEntry zipFile;
			while ((zipFile = zipInputStream.getNextEntry()) != null) {
				System.out.println(zipFile);
			}
			myFile.close();
		}
		catch (IOException ioe) {
			System.out.println("Can't read contents of Stuff.zip");
		}
	}
}