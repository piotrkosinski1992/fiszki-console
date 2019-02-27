package com.weta.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.weta.model.Fiszka;

public class BazaFiszek {

	private List<Fiszka> listaFiszek = new ArrayList<>();

	public BazaFiszek() {
	}

	public List<Fiszka> getListaFiszek() {
		return listaFiszek;
	}

	public void setListaFiszek(List<Fiszka> listaFiszek) {
		this.listaFiszek = listaFiszek;
	}

	public void updateFiszka() {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Napisz błędną wersję fiszki:");

			String incorrectFiszkaSide = sc.nextLine();
			
			if(incorrectFiszkaSide.equals("")) {
				break;
			}

			Optional<Fiszka> incorrectFiszkaFromDB = listaFiszek.stream()
					.filter(fiszka -> fiszka.getFirstSide().equals(incorrectFiszkaSide)
							|| fiszka.getSecondSide().equals(incorrectFiszkaSide))
					.findFirst();

			if (incorrectFiszkaFromDB.isPresent()) {
				System.out.println("Napisz Poprawną wersję:");
				String correctedFiszkaSide = sc.nextLine();

				if(incorrectFiszkaFromDB.get().getFirstSide().equals(incorrectFiszkaSide)) {
					incorrectFiszkaFromDB.get().setFirstSide(correctedFiszkaSide);
				} else {
					incorrectFiszkaFromDB.get().setSecondSide(correctedFiszkaSide);
				}
				break;
				
			} else {
				System.out.println("Podana strona fiszki nie istnieje");
				continue;
			}
		}

	}

}
