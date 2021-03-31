package gestionarestudenti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMenu 
{	
	private Scanner consoleScanner = new Scanner(System.in);
	private ArrayList<Grupa> StudentsList = new ArrayList<Grupa>();
	private int currentNume = 0;
	protected void DisplayMenu()
	{
		try 
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} 
		catch (InterruptedException | IOException e) 
		{
			System.out.println("Consola nu poate fi curatata " + e.getMessage());
		}
        
		System.out.println("***** GESTIONARE STUDENTI ******\n");
		System.out.println("0. Iesire");
		System.out.println("1. Adaugare");
		System.out.println("2. Modificare");
		System.out.println("3. Stergere");
		System.out.println("4. Vizualizare");
		System.out.println("\nIntorduceti optiunea dvs.: ");
		
	}
	
	public void Run()
	{
		int option = 0;
		
		do
		{
			DisplayMenu();
			option = consoleScanner.nextInt();
			switch (option)
			{
				case 1:
					uiAddGrupa();
					break;
				case 2:
					uiModifyGrupa();
					break;
				case 3:
					uiDeleteGrupa();
					break;
				case 4:
					uiViewStudents();
					break;
					
				default:
					System.out.println("\nAlegeti o optiune valida");
			
			}
			
		}while (option != 0);	
		
		System.out.println("Aplicatia se inchide ...");
	}

	private void listStudent(Grupa Student)
	{
		System.out.println(Student.getNume() + "\t" + Student.getProfil() + "\t" +  Student.getAn() + "\t" + Student.getFacultate() );
	}
	private void uiViewStudents() {
		
		System.out.println("Nume \tProfil\tAn\tFacultate");
		
		for(Grupa currentGrupa: StudentsList)
		{
			listStudent(currentGrupa);			
		}
		consoleScanner.nextLine();
		consoleScanner.nextLine();
		
	}

	private void uiDeleteGrupa() {
		System.out.println("Sterge student");
		
	}

	private void uiModifyGrupa() {
		System.out.println("Modifica student");
		
	}

	private Grupa readGrupaInfo()
	{

		Grupa newGrupa = new Grupa();
		consoleScanner.nextLine();
		System.out.println("Introduceti Profil: ");
		newGrupa.setProfil(consoleScanner.nextLine());
		System.out.println("Introduceti An: ");
		newGrupa.setAn(consoleScanner.nextLine());
		System.out.println("Introduceti Facultate: ");
		newGrupa.setFacultate(consoleScanner.nextLine());
		return newGrupa;		
	}
	private void uiAddGrupa() {
		System.out.println("Adauga student");
		Grupa readGrupa = readGrupaInfo();		
		if (!StudentsList.contains(readGrupa))
		{
			currentNume++;
			readGrupa.setNume("" + currentNume);
			StudentsList.add(readGrupa);
			return;
		}

		System.out.println("Studentul deja exista.");
		consoleScanner.nextLine();
	}
	
}
