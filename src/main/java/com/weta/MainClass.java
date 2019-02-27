package com.weta;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import com.weta.exception.ToBigNumberException;
import com.weta.exception.WrongDirectoryException;
import com.weta.model.Fiszka;
import com.weta.repo.BazaFiszek;
import com.weta.utils.FiszkiService;

/**
 * 
 * @author Kosinski
 * 
 * To run externaly, use cmd command: java -cp Fiszki-1.jar com.weta.MainClass .
 *
 */
public class MainClass {

	private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

	public static void main(String[] args) throws IOException, URISyntaxException {
		final String FISZKI_DIRECTORY_PATH = "fiszki/";
		boolean fiszkiFileChooseCompleted = false;
		BazaFiszek baza = new BazaFiszek();
		FiszkiService fiszkiService = new FiszkiService();
		Scanner sc = new Scanner(System.in);
		
		int pickedFaculty = 0;
		int pickedFiszkiFile = 0;
		
		List<String> facultyDirectoriesNames = null;
		List<String> fiszkiFileNames = null;
		
		
		while(!fiszkiFileChooseCompleted) {
			facultyDirectoriesNames = new ArrayList<>();
			fiszkiFileNames = new ArrayList<>();
			try {
				AtomicInteger counter = new AtomicInteger(0);
				facultyDirectoriesNames = fiszkiService.getListOfElementsInDirectory(FISZKI_DIRECTORY_PATH);

				LOGGER.info("Wybierz przedmiot:\n");
				facultyDirectoriesNames.forEach(faculty -> System.out.println(counter.getAndIncrement() + ". " + faculty));
				
				pickedFaculty = fiszkiService.verifyPassedValue(sc.nextLine(), facultyDirectoriesNames.size());
				
				fiszkiFileNames = fiszkiService.getListOfElementsInDirectory(FISZKI_DIRECTORY_PATH + facultyDirectoriesNames.get(pickedFaculty));

				LOGGER.info("Wybierz plik z fiszkami:\n");
				counter.set(0);
				fiszkiFileNames.forEach(fiszkiFile -> System.out.println(counter.getAndIncrement() + ". " + fiszkiFile));
				
				pickedFiszkiFile = fiszkiService.verifyPassedValue(sc.nextLine(), fiszkiFileNames.size());
				
				fiszkiService.getListOfElementsInDirectory(FISZKI_DIRECTORY_PATH + facultyDirectoriesNames.get(pickedFaculty) + "/" + fiszkiFileNames.get(pickedFiszkiFile));
				
				
				
			} catch (WrongDirectoryException | NumberFormatException | ToBigNumberException e) {
				LOGGER.warning("Error: " + e.getMessage());
				continue;
			}
			
			fiszkiFileChooseCompleted = true;

		}
		
		
		baza.setListaFiszek(fiszkiService.zaladujFiszkiZPliku(new File(FISZKI_DIRECTORY_PATH + facultyDirectoriesNames.get(pickedFaculty) + "/" + fiszkiFileNames.get(pickedFiszkiFile))));
		
		int lbFiszek = baza.getListaFiszek().size();

		Random random = new Random();

		int lbPoprawnychOdpowiedzi = 0;
		int lbZlychOdpowiedzi = 0;

		while (baza.getListaFiszek().size() > 0) {
				Scanner scanner = new Scanner(System.in);
				
				Fiszka fiszka = baza.getListaFiszek().get(random.nextInt(lbFiszek));

				System.out.println(fiszka.getFirstSide());

				String secondSideFromUser = scanner.nextLine();
				
				if(secondSideFromUser.equals("e")) {
					baza.updateFiszka();
					continue;
				}

				if (secondSideFromUser.replaceAll(" ", "").equals(fiszka.getSecondSide().replaceAll(" ", ""))) {
					System.out.println("BRAWO\n");
					baza.getListaFiszek().remove(fiszka);
					lbPoprawnychOdpowiedzi++;
					lbFiszek--;

				} else {
					System.out.println("Błąd, poprawna odpowiedz to: " + fiszka.getSecondSide() + "\n");
					lbZlychOdpowiedzi++;
				}
				
				System.out.println("Pozostało do zrobienia: " + baza.getListaFiszek().size() + " fiszek");
 
		}
		int wynik = (lbPoprawnychOdpowiedzi * 100) / (lbPoprawnychOdpowiedzi + lbZlychOdpowiedzi);
		System.out.println("KONIEC \nTwoja skutecznosc to: " + (wynik) + "%");
	}
}
