package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import controller.FileController;
import controller.HolidayFinderController;
import model.Holiday;

public class Main {

	public static void main(String[] args) {
		List<Holiday> holidays;
		
		FileController download = new FileController();
		HolidayFinderController finder = new HolidayFinderController();
		try {
			holidays = download.downloadFile();
			Scanner scanner = new Scanner(System.in);
			int op = 0;
			while(op != 2) {
				System.out.println("Bem-vindo ao Holidays!");
				System.out.println("Digite uma opção:");
				System.out.println("1- Procurar por feriado:");
				System.out.println("2- Sair");
				op = scanner.nextInt();
				scanner.nextLine();
				
				switch(op) {
					case 1:
						System.out.println("Insira o nome do feriado:");
						String holidayName = scanner.nextLine();
						
						try {
							Holiday holiday = finder.findHolidayByName(holidays, holidayName);
				            if (holiday != null) {
				                System.out.println("Data do feriado: " + holiday.getDate());
				            } else {
				                throw new Exception("Feriado não encontrado!");
				            }
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
						
						break;
					case 2:
						System.out.println("Até mais!");
						break;
					default: 
						System.out.println("Opção inválida!");
						break;
				}
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
