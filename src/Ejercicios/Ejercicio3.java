package Ejercicios;

import java.io.IOException;

public class Ejercicio3

{

	public static void main(String[] args)

	{

		// Ejecutar Bloc notas

		Process process;

		try

		{

			String[] comando = {"notepad.exe"};

			process = Runtime.getRuntime().exec(comando);

			// Esperar a quecierre

			while(process.isAlive()) {} // No hagonada

			// Mostrarmensaje

			System.out.println("Se cerró el proceso");

		}

		catch (IOException e)

		{

			e.printStackTrace();

		}

	}

}

