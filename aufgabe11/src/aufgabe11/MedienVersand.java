package aufgabe11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MedienVersand {

	// Attribute
	// MedienObjekte[] artikel;
	Random rand = new Random();
	Zahlgenerator zufall = new Zahlgenerator();
	List<MedienObjekte> artikelList = new ArrayList<MedienObjekte>();

	// Constructor
	// Method
	public void run(String[] arg) {
		if(arg[0].equals("generiere")&& arg[1].equals("n")){
			generiere();
		}
		else if(arg[0].equals("generiere")&& arg[1].equals("n")){
			zeige();
		}
		else
			
			System.exit(0);
 

	}

	public void generiere() {

		int dasBuch = 0;
		int dieCD = 0;
		int dieDVD = 0;
		int range = zufall.generateInt(100, 1000);
		System.out.println("Writing.");
		for (int i = 0; i < range; i++) {

			int wahl = rand.nextInt(3) + 1;
			switch (wahl) {
			case 1:
				artikelList.add(new Buecher("Buch", zufall.ArrToInt(3), zufall
						.generateDouble(10, 40), zufall.ArrToInt(3), rand
						.nextInt(2) + 1));
				dasBuch++;
				break;

			case 2:
				artikelList.add(new CD("CD", zufall.ArrToInt(3), zufall
						.generateDouble(5, 50), zufall.ArrToInt(3), rand
						.nextInt(7) + 1));
				dieCD++;
				break;

			case 3:
				artikelList.add(new DVD("DVD", zufall.ArrToInt(3), zufall
						.generateDouble(5, 70), zufall.ArrToInt(3), rand
						.nextInt(5) + 1));
				dieDVD++;
				break;

			default:
			}
		}
		// System.out.println(artikelList.get(0).getClass());

		System.out.println("Buecher : " + dasBuch + "\nCD : " + dieCD
				+ "\nDVD : " + dieDVD);
		System.out.println(artikelList.size());
		schreibeObjektNachDaten(artikelList, "Medien.dat");

	}

	public int ermitteleFeldbreite(List<MedienObjekte> artikelList) {
		int feldbreite = artikelList.get(0).liefereAttributTextLaenge();
		for (MedienObjekte ware : artikelList)
			if (ware.liefereAttributTextLaenge() > feldbreite)
				feldbreite = ware.liefereAttributTextLaenge();
		return feldbreite;
	}

	public void schreibe(List<MedienObjekte> artikelList) {
		int feldbreite = ermitteleFeldbreite(artikelList) + 2;
		for (int i = 0; i < artikelList.size(); i++) {
			MedienObjekte ware = artikelList.get(i);
			System.out.println((i + 1) + ". "
					+ ware.liefereWarenInfo(feldbreite));
		}
		// for (MedienObjekte ware : artikelList)
		// System.out.println(ware.liefereWarenInfo(feldbreite));
	}

	public void schreibeObjektNachDaten(List<MedienObjekte> artikelList,
			String file) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			oos.writeObject(artikelList); // Write object
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		String fertig = "done writing.";
		System.out.println(fertig);
	}

	@SuppressWarnings("unchecked")
	public void zeige() {

		String file = "Medien.dat";
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			try {

				List<MedienObjekte> neuArtikelList = (List<MedienObjekte>) ois
						.readObject();
				System.out.println("lese von File " + file);
				// Collections.sort(neuArtikelList);
				schreibeObjektNachDaten(neuArtikelList, "verkauf.dat");
				schreibe(neuArtikelList);
//				schreibe(verkaufe(neuArtikelList));
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			file = "verkauf.dat";
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				try {
					List<MedienObjekte> neuArtikelList = (List<MedienObjekte>) ois
							.readObject();
					System.out.println("lese von File " + file);

					schreibe(verkaufe(neuArtikelList));
					ois.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<MedienObjekte> verkaufe(List<MedienObjekte> artikelList) {

		for (int i = 0; i < artikelList.size(); i++) {
			artikelList.get(i).setAnzahl(zufall.ArrToInt(2));
		}
		return artikelList;
	}
}
