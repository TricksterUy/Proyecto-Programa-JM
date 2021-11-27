package mainIdeas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JuntaMedica {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

// Declaramos los Strings
		String nombre, hijo, cedula, expediente, unidad, dictamen, plazo, valor, nuevovalor, grado;

		// Declaramos los arrays
		ArrayList<String> gdo = new ArrayList<String>();
		ArrayList<String> nom = new ArrayList<String>();
		ArrayList<String> ijo = new ArrayList<String>();
		ArrayList<String> ci = new ArrayList<String>();
		ArrayList<String> exp = new ArrayList<String>();
		ArrayList<String> ue = new ArrayList<String>();
		ArrayList<String> dic = new ArrayList<String>();
		ArrayList<String> pl = new ArrayList<String>();

		// Declaramos Variables
		int opcion = 0, salida = 0, indice=0, modifica=0, indice2=0;
		boolean salir = false;
		boolean modificar=false;

		// Primero solicitamos nombre de Usuario y determinamos la hora

		String usuario;
		String respuesta = JOptionPane.showInputDialog("Bienvenido al Programa de la Junta Medica de Aptitud \nEscribe tu nombre:");
		usuario = respuesta;
		System.out.print("Hola " + usuario);
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH");
		String horaActual = formateador.format(LocalDateTime.now());
		int hora = Integer.valueOf(horaActual);

		if (hora > 12) {
			System.out.println(", buenas tardes.");
		} else {
			System.out.println(", buenos dias.");
		}
		System.out.println("\nBienvenido al Programa de la Junta Medica de Aptitud\n");
		System.out.println("A continuacion se desplegaran las opciones validas del programa\n");

		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Ahora procederemos con el menu de ingreso
		while (!salir) {
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------");
			System.out.println("Elige una de las siguientes opciones para comenzar a trabajar:\n");
			System.out.println("1) Ingresar un nuevo expediente");
			System.out.println("2) Visualizar el total de los expedientes ingresados");
			System.out.println("3) Buscar funcionario por Cedula de Identidad");
			System.out.println("4) Modificar valores ingresados");
			System.out.println("5) Eliminar un usuario ingresado");
			System.out.println("6) Salir del programa\n");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(
						"\nA continuacion se le pedira que ingrese una serie de datos del funcionario a agregar:\n");

				// el teclado.nextLine se repite para limpiar el buffer, sino omite la 1ra linea

				teclado.nextLine();
				System.out.print("Grado: ");
				grado = teclado.nextLine();
				gdo.add(grado);
				System.out.print("Nombres y Apellidos: ");
				nombre = teclado.nextLine();
				nom.add(nombre);
				System.out.print("Cedula de Identidad: ");
				cedula = teclado.nextLine();
				ci.add(cedula);

				System.out.print("Numero de Expediente: ");
				expediente = teclado.nextLine();
				exp.add(expediente);
				System.out.print("Unidad Ejecutora: ");
				unidad = teclado.nextLine();
				ue.add(unidad);

				System.out.print("Dictamen: ");
				dictamen = teclado.nextLine();
				dic.add(dictamen);
				System.out.print("Plazo: ");
				plazo = teclado.nextLine();
				pl.add(plazo);

				System.out.print("Numero de Expedientes Hijos: ");
				hijo = teclado.nextLine();
				ijo.add(hijo);

				break;
			case 2:
				System.out.println("\nSe imprimiran a continuacion los funcionarios ingresados\n");
				for (int i = 0; i < nom.size(); i++) {
					System.out.println("-> Grado: " + gdo.get(i));
					System.out.println("-> Nombre y Apellido: " + nom.get(i));
					System.out.println("-> C.I.: " + ci.get(i));
					System.out.println("-> Exp.: " + exp.get(i));
					System.out.println("-> Unidad: " + ue.get(i));
					System.out.println("-> Dictamen: " + dic.get(i));
					System.out.println("-> Plazo: " + pl.get(i));
					System.out.println("-> Exp. Hijos: " + ijo.get(i));
					System.out.println("--------------------------------------------------------");
				}
				break;
			case 3:
				teclado.nextLine();
				System.out.print("\nIngrese la Cedula que desea buscar, este le mostrara en que posicion se encuentra: ");
				valor=teclado.nextLine();
				indice= ci.indexOf(valor);
				if (indice !=-1) {
					System.out.println("La cedula se encuentra en la posicion: -> " +indice+ "\nDesea ver los datos de dicha celda? \n\n1)Si \n2)No\n");
					modifica=teclado.nextInt();
					switch (modifica) {
					case 1:
						System.out.print("\nIngrese el indice a mostrar: ");
						indice2=teclado.nextInt();
						System.out.println("--------------------------------------------------------");
						System.out.println("-> Grado: " + gdo.get(indice2));
						System.out.println("-> Nombre y Apellido: " + nom.get(indice2));
						System.out.println("-> C.I.: " + ci.get(indice2));
						System.out.println("-> Exp.: " + exp.get(indice2));
						System.out.println("-> Unidad: " + ue.get(indice2));
						System.out.println("-> Dictamen: " + dic.get(indice2));
						System.out.println("-> Plazo: " + pl.get(indice2));
						System.out.println("-> Exp. Hijos: " + ijo.get(indice2));
						System.out.println("--------------------------------------------------------");
						break;
					case 2:
						modificar=true;
						System.out.println("\nNo desea ver nada, volvemos al menu inicial");
						break;
					default:
						System.out.println("\nNo ingreso una opcion valida, sera devuelto al inicio del programa");
					}
				}
				else {
					System.out.println("La cedula ingresada no se encuentra");
				}
				break;
				
			case 4:
				teclado.nextLine();
				System.out.print("\nIngrese la Cedula que desea buscar, este le mostrara en que posicion se encuentra: ");
				valor=teclado.nextLine();
				indice= ci.indexOf(valor);
				if (indice !=-1) {
					System.out.println("La cedula se encuentra en la posicion: -> " +indice);
					System.out.println("\nDesea modificar algunos de los datos de dicho indice?\n");
					System.out.println("1) Modificar Grado");
					System.out.println("2) Modificar Nombres y Apellidos");
					System.out.println("3) Modificar Cedula de Identidad");
					System.out.println("4) Modificar Numero de Expediente");
					System.out.println("5) Modificar Unidad Ejecutora");
					System.out.println("6) Modificar Dictamen");
					System.out.println("7) Modificar Plazo");
					System.out.println("8) Modificar Expedientes Hijos");
					System.out.println("9) No modificar nada y volver al menu\n");					
					modifica=teclado.nextInt();
					switch (modifica) {
					case 1:						
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Grado: ");
						nuevovalor = teclado.nextLine();
						gdo.set(indice, nuevovalor);
						break;
					case 2:						
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Nombre y Apellido: ");
						nuevovalor = teclado.nextLine();
						nom.set(indice, nuevovalor);
						break;
					case 3:
						teclado.nextLine();
						System.out.print("\nIngrese la nueva Cedula de Identidad: ");
						nuevovalor = teclado.nextLine();
						ci.set(indice, nuevovalor);
						break;
					case 4:
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Numero de Expediente: ");
						nuevovalor = teclado.nextLine();
						exp.set(indice, nuevovalor);
						break;
					case 5:
						teclado.nextLine();
						System.out.print("\nIngrese la nueva Unidad Ejecutora: ");
						nuevovalor = teclado.nextLine();
						ue.set(indice, nuevovalor);
						break;
					case 6:
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Dictamen: ");
						nuevovalor = teclado.nextLine();
						dic.set(indice, nuevovalor);
						break;
					case 7:
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Plazo: ");
						nuevovalor = teclado.nextLine();
						pl.set(indice, nuevovalor);
						break;
					case 8:
						teclado.nextLine();
						System.out.print("\nIngrese el nuevo Nro. de Expediente Hijo: ");
						nuevovalor = teclado.nextLine();
						ijo.set(indice, nuevovalor);
						break;
					case 9:
						modificar=true;
						System.out.println("\nNo modificaremos nada, volvemos al menu inicial");
						break;
					default:
						System.out.println("\nNo ingreso una opcion valida, sera devuelto al inicio del programa");
					}
				}
				else {
					System.out.println("La cedula ingresada no se encuentra");
				}
				break;
			case 5:
				teclado.nextLine();
				System.out.print("\nIngrese la Cedula que desea buscar, este le mostrara en que posicion se encuentra: ");
				valor=teclado.nextLine();
				indice= ci.indexOf(valor);
				if (indice !=-1) {
					System.out.println("La cedula se encuentra en la posicion: -> " +indice);
					System.out.println("\nDesea eliminar los datos de dicha celda? \n\n1) Si \n2) No\n");
					modifica=teclado.nextInt();
					switch (modifica) {
					case 1:
						//System.out.print("\nIngrese el indice a eliminar: ");
						//indice2=teclado.nextInt();
						System.out.println("--------------------------------------------------------");
						System.out.println("\nSe eliminaron correctamente los siguientes datos\n");
						System.out.println("-> Grado: " + gdo.remove(indice));
						System.out.println("-> Nombre y Apellido: " + nom.remove(indice));
						System.out.println("-> C.I.: " + ci.remove(indice));
						System.out.println("-> Exp.: " + exp.remove(indice));
						System.out.println("-> Unidad: " + ue.remove(indice));
						System.out.println("-> Dictamen: " + dic.remove(indice));
						System.out.println("-> Plazo: " + pl.remove(indice));
						System.out.println("-> Exp. Hijos: " + ijo.remove(indice));
						System.out.println("--------------------------------------------------------");
						break;
					case 2:
						modificar=true;
						System.out.println("\nNo desea eliminar nada, volvemos al menu inicial");
						break;
					default:
						System.out.println("\nNo ingreso una opcion valida, sera devuelto al inicio del programa");
					}
				}
				else {
					System.out.println("La cedula ingresada no se encuentra");
				}
				break;

			case 6:
				System.out.println("\nRealmente desea salir del programa? \n\nPulse 1 para salir \nPulse 2 para continuar en el programa");
				salida = teclado.nextInt();
				switch (salida) {
				case 1:
					salir = true;
					System.out.println("\nHasta la proxima, vuelva pronto");
					break;

				case 2:
					salir = false;
					break;
				default:
					System.out.println("No ingreso una opcion valida de salida, sera devuelto al inicio del programa");
				}
				System.out.println(
						"--------------------------------------------------------------------------------------");
				break;

			default:
				System.out.println("No ingreso una opcion valida");
			}
		}
		teclado.close();
	}

}
