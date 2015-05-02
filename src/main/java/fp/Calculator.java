package fp;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
	/*
	 * Este metodo calcula el seno de un angulo
	 */
	public static Double sin(double n){
		return Math.rint(Math.sin(Math.toRadians(n))*10)/10;
	}

	/*
	 * Escribir todos los numeros del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		ArrayList<Integer> arrayListStepsNumber = new ArrayList<Integer>();
		while(number > step){
			number -= step;
			arrayListStepsNumber.add(number);
		}
		Integer [] arrayStepsNumber = arrayListStepsNumber.toArray(new Integer [arrayListStepsNumber.size()]);
		int count = 0;
		for(Integer stepNumber: arrayListStepsNumber){
			arrayStepsNumber[count] = stepNumber;
			count++;
		}
		return arrayStepsNumber;
	}

	/*
	 * Modulo al que se le pasa un numero entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int [] arrayDivisors = null;
		if(n != 0){
			ArrayList<Integer> arrayListDivisors = new ArrayList<Integer>();
			int divisor = n;
			while(divisor > 0){
				if(n%divisor == 0){
					arrayListDivisors.add(divisor);
				}
				divisor--;
			}
			arrayDivisors = new int [arrayListDivisors.size()];
			int count = 0;
			for(int num : arrayListDivisors){
				arrayDivisors[count] = num;
				count++;
			}
		}
		return arrayDivisors;
	}
	

	/*
	 * Toma como parametros dos listas. La primera con los 6 numeros de una
	 * apuesta de la primitiva, y la segunda con los 6 numeros ganadores. La
	 * funcion debe devolver el numero de aciertos.
	 */
	public static Integer checkMyBet(List<Integer> apuesta, List<Integer> aciertos) {
		Integer rights = 0;
		if(apuesta != null && aciertos != null){
			for(int count = 0; count < 6; count++){
				if(apuesta.get(count).intValue() == aciertos.get(count).intValue()){
					rights++;
				}
			}
		}
		return rights;
	}

	/*
	 * Pedir un numero de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String [] arrayUnits = {"Cero","Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve"};
		String [] arrayTens = {"Veinte","Treinta","Cuarenta","Cincuenta","Sesenta","Setenta","Ochenta","Noventa"};
		String [] arrayAuxTens = {"Diez","Once","Doce","Trece","Catorce","Quince"};
		String numberString = null;
		int tens = n/10;
		int units = n%10;
		switch(tens){
			case 0: numberString = arrayUnits[units];
					break;
			case 1: 
					if(units < 6){
						numberString = arrayAuxTens[units];
					}else if(units >= 6){
						numberString = "Dieci" + arrayUnits[units];
					};
					break;
			case 2:
					switch(units){
						case 0: numberString = arrayTens[tens-2];
								break;
						default: numberString = "Veinti" + arrayUnits[units].toLowerCase();
								break;
					}
					break;
			case 3: case 4: case 5: case 6: case 7: case 8: case 9:
					switch(units){
						case 0: numberString = arrayTens[tens-2];
								break;
						default: numberString = arrayTens[tens-2] + " y " + arrayUnits[units].toLowerCase();
								break;
					}
					break;
			default: numberString = "Numero no valido";
					break;
		}
		return numberString;
	}

	/*
	 * Este metodo devuelve cierto si el anyo de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		try{
			int year = Integer.parseInt(fecha.substring(6));
			return year%4 == 0 && (year%100 != 0 || year%400 == 0);
		}catch(RuntimeException e){
			return false;
		}
	}

	/*
	 * Este metodo devuelve cierto si la fecha es valida
	 */
	public static boolean isValidDate(String date) {
		boolean right = false;
		try{
			int day = Integer.parseInt(date.substring(0,2));
			int month = Integer.parseInt(date.substring(3,5));
			int year = Integer.parseInt(date.substring(6));
			if(day <= 31 && day >= 1 && month <= 12 && month >= 1 && year >= 1){
				switch(month){
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						if(day <= 31){
							right = true;
						}
					case 2:
						if(day <= 28 && !Calculator.isLeapYear(date) || day <= 29 && Calculator.isLeapYear(date)){
							right = true;
						}
					default:
						if(day <= 30){
							right = true;
						}
				}
			}
		}catch(RuntimeException e){};
		return right;
	}
}
