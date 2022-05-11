import java.util.Scanner;

/**
 * <H2>Clase PrimaMainMetodos</H2>
 * 
 * <p>Programa que permite visualizar la prima que le corresponde a un empleado en función de las características introducidas por teclado.</p>
 * <p>Solicita 4 parámetros por teclado:</p>
 * <ol>
 * <li>Número de empleado</li>
 * <li>Nombre del empleado</li>
 * <li>Meses de trabajo en la empresa</li>
 * <li>Condición de Directivo</li>
 * </ol>
 * 
 * @author JuanC Paramá juancpc19@educastur.es
 * @version 1.0
 * <p><strong>Fecha:</strong></p>
 * <p>9 mayo 2022</p>
 */
public class PrimaMainMetodos {

	/**
	 * Variable estática de tipo Scanner llamada teclado para leer datos por teclado
	 */
	static Scanner  teclado=new Scanner(System.in);

	/**
	 * Método main principal de la aplicación que pide por teclado los datos del empleado y llama a los distintos métodos de la aplicación para calcular la prima que le corresponde.
	 * @param args Argumentos del programa
	 */
	public static void main(String[] args) {

		/**
		 * Número entero con el número de empleado
		 */
		int numEmple;
		/**
		 * Cadena de texto con el nombre del empleado
		 */
		String nomEmple;
		/**
		 * Número entero con la antigüedad del empleado en la empresa
		 */
		int meses;
		/**
		 * Caracter de texto que indica si empleado es directivo (+) o no (-)
		 */
		char esDirectivo;
		/**
		 * Caracter de texto que recoge por teclado la opción para seguir calculando primas
		 */
		char respuesta;
		
		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');
	}

	
	/**
	 * Método estático que devuelve el tipo de prima que le corresponde a un empleado en función de sus características.
	 * 
	 * @param esDirectivo Un carácter indicando si es directivo (+) o no (-).
	 * @param meses Un entero indicando la antigüedad en la empresa del empleado.
	 * @return <ul>
     *          <li>P1: Cuando es directivo y tiene antigüedad &gt;= 12 meses</li>
     *          <li>P2: Cuando no es directivo y tiene antigüedad &gt;= 12 meses</li>
     *          <li>P3: Cuando es directivo y tiene antigüedad &lt; 12 meses</li>
     *          <li>P4: Cuando no es directivo y tiene antigüedad &lt; 12 meses</li>
     *          </ul>
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}


	/**
	 * Método estático que solicita por teclado continuamente el número de empleado hasta que éste se encuentre entre 100 y 999.
	 * 
	 * @return Un número entero identificando al empleado siempre y cuando cumpla con los criterios.
	 */
	public static int leerNumEmple() {
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);
		teclado.nextLine();
		return numEmple;
	}


	/**
	 * Método estático que solicita por teclado un nombre de empleado hasta que la cadena introducida tenga más de 10 caracteres.
	 * 
	 * @return Una cadena de texto con el nombre del empleado.
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);
		return nomEmple;
	}


	/**
	 * Método estático que solicita por teclado el número de meses de antigüedad hasta que el número introducido sea mayor o igual que 0.
	 * @return Devuelve el número introducido por teclado siempre y cuando sea mayor o igual que 0.
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}


	/**
	 * Método estático que pregunta por teclado por la condición de directivo hasta que se introduzca el caracter '+' o el caracter '-'.
	 * @return Devuelve el valor introducido por teclado siempre y cuando sea '+' o '-'.
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}