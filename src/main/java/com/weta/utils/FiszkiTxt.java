package com.weta.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.weta.model.Fiszka;

public class FiszkiTxt {
	

	public List<Fiszka> zaladujFiszkiZPliku() throws IOException {
		List<Fiszka> fiszki = new ArrayList<Fiszka>();
		
		InputStream fiszkiJednostronne = getClass().getResourceAsStream("/FiszkiJednostronne.txt"); 
		InputStream fiszkiObustronne = getClass().getResourceAsStream("/FiszkiObustronne.txt"); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fiszkiObustronne));
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
		
		br = new BufferedReader(new BufferedReader(new InputStreamReader(fiszkiJednostronne)));
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

		return fiszki;
	}

}
