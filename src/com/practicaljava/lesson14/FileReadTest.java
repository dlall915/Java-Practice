package com.practicaljava.lesson14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lists the contents of a text file.
 * 
 * @author David Lall
 *
 */
public class FileReadTest {
	public static void main (String[] args) {
		try (
			FileInputStream myFile = new FileInputStream("H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson14\\states.txt");
			InputStreamReader inputStreamReader = 
					new InputStreamReader(myFile, "UTF8");
			BufferedReader reader = new BufferedReader(inputStreamReader);) {
			String stateName;
			while ((stateName = reader.readLine()) != null) {
				System.out.println(stateName);
			}
			myFile.close();
		}
		catch (IOException ioe) {
			System.out.println("Can't read states.txt");
		}
	}
}