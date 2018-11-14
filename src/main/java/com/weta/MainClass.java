package com.weta;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.weta.model.Fiszka;
import com.weta.repo.BazaFiszek;
import com.weta.utils.FiszkiTxt;

/**
 * 
 * @author Kosinski
 * 
 * To run externaly, use cmd command: java -cp Fiszki-1.jar com.weta.MainClass
 *
 */
public class MainClass {

	public static void main(String[] args) throws IOException {
		BazaFiszek baza = new BazaFiszek();
		FiszkiTxt fiszkiUtil = new FiszkiTxt();
		
		baza.setListaFiszek(fiszkiUtil.zaladujFiszkiZPliku());
		
		int lbFiszek = baza.getListaFiszek().size();

		Random random = new Random();

		int lbPoprawnychOdpowiedzi = 0;
		int lbZlychOdpowiedzi = 0;

		Scanner sc = new Scanner(System.in);


		while (baza.getListaFiszek().size() > 0) {

				Fiszka wylosowana = baza.getListaFiszek().get(random.nextInt(lbFiszek));

				System.out.println(wylosowana.getPolski());

				String lacinska = sc.nextLine();

				if (lacinska.replaceAll(" ", "").equals(wylosowana.getLacinski().replaceAll(" ", ""))) {
					System.out.println("BRAWO\n");
					baza.getListaFiszek().remove(wylosowana);
					lbPoprawnychOdpowiedzi++;
					lbFiszek--;

				} else {
					System.out.println("B≥πd, poprawna odpowiedü to: " + wylosowana.getLacinski() + "\n");
					lbZlychOdpowiedzi++;
				}
				
				System.out.println("Pozosta≥o do zrobienia: " + baza.getListaFiszek().size() + " fiszek");
 
		}
		int wynik = (lbPoprawnychOdpowiedzi * 100) / (lbPoprawnychOdpowiedzi + lbZlychOdpowiedzi);
		System.out.println("KONIEC \nTwoja skutecznosc to: " + (wynik) + "%");
	}
}
