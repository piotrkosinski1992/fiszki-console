package com.weta.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.weta.exception.ToBigNumberException;
import com.weta.exception.WrongDirectoryException;
import com.weta.model.Fiszka;

public class FiszkiService {
	

	public List<Fiszka> zaladujFiszkiZPliku(File fiszkiFile) throws IOException {
		
		List<Fiszka> fiszki = new ArrayList<Fiszka>();
		
		InputStream targetStream = new FileInputStream(fiszkiFile);
//		Bad habit of commenting
//		InputStream targetStream = getClass().getResourceAsStream("/" + fiszkiFile.getPath()); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(targetStream));
		
		if(fiszkiFile.getName().contains("dwustronne")) {
			
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			    	
			    	String[] fiszka = line.split(",");
			    	fiszki.add(new Fiszka(fiszka[0], fiszka[1]));
			    	fiszki.add(new Fiszka(fiszka[1], fiszka[0]));
			    	line = br.readLine();
			    	
			    }
			} finally {
			    br.close();
			}
		} else if(fiszkiFile.getName().contains("jednostronne")) {

			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			    	
			    	String[] fiszka = line.split(",");
			    	fiszki.add(new Fiszka(fiszka[0], fiszka[1]));
			    	line = br.readLine();
			    	
			    }
			} finally {
			    br.close();
			}
		}

		return fiszki;
	}
	
	public List<String> getListOfElementsInDirectory(String directoryName) throws WrongDirectoryException, URISyntaxException {
		
		List<String> elementNames = new ArrayList<>();
		
		File element = new File(directoryName);
		
		if(!element.exists()) {
			throw new WrongDirectoryException("Directory does not exist: " + directoryName);
		}
		
		if(element.isDirectory()) {
			Arrays.asList(element.listFiles()).forEach(e -> elementNames.add(e.getName()));
		} else {
			elementNames.add(element.getName());
		}
	
		return elementNames;
	}

	public int verifyPassedValue(String nextLine, int listSize) throws NumberFormatException, ToBigNumberException  {

			int passedValueInt = Integer.parseInt(nextLine);
		
			if(passedValueInt < 0 || passedValueInt >= listSize) {
				throw new ToBigNumberException("Passed value is out of bound");
			}

			
			return passedValueInt;
	}

}
