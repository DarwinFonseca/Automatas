/**
 * 
 */
package co.edu.uniminuto.teoriasComputacion.dfonsecaabr.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Darwin Gonzalo Fonseca Abril
 * @id 436354
 * @nrc 8041 - Teorías de la computación
 */

public class SecondExcercise {

	public static void main(String[] args) {
		try { // Try catch to control the different exceptions that can be created.

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String input = br.readLine(); // This variable receives the first input line
			String[] inputArray; // Variable of array type to store each value of the string "input"

			while (!input.equals("FIN")) {

				int counter = 0; // Control variable
				int qState = 0; // Variable that represents the state of q
				inputArray = input.split(""); // Returns an array with the respective values of the string "input"

				while (counter < inputArray.length) { // Go through the array, after each validation, perform a continue
														// to advance to the next data.

					/*
					 * For each q-state it evaluates the three possibilities of the language {a, b,
					 * c} and makes the respective changes to the counter and the states.
					 */
					if (qState == 0) { // q0
						switch (inputArray[counter]) {
						case "a":
							counter++;
							qState = 1;
							continue;
						case "b":
							counter++;
							qState = 2;
							continue;
						case "c":
							counter++;
							qState = 2;
							continue;
						}
					}
					if (qState == 1) { // q1
						switch (inputArray[counter]) {
						case "a":
							counter = inputArray.length;
							qState = 10;
							continue;
						case "b":
							counter++;
							qState = 3;
							continue;
						case "c":
							counter++;
							qState = 2;
							continue;
						}
					}
					if (qState == 2) { // q2
						switch (inputArray[counter]) {
						case "a":
							counter++;
							qState = 1;
							continue;
						case "b":
							counter++;
							qState = 3;
							continue;
						case "c":
							counter = inputArray.length;
							qState = 10;
							continue;
						}
					}
					if (qState == 3) { // q3
						switch (inputArray[counter]) {
						case "a":
							counter++;
							qState = 4;
							continue;
						case "b":
							counter = inputArray.length;
							qState = 10;
							continue;
						case "c":
							counter = inputArray.length;
							qState = 10;
							continue;
						}
					}
					if (qState == 4) { // q4
						switch (inputArray[counter]) {
						case "a":
							counter = inputArray.length;
							qState = 10;
							continue;
						case "b":
							counter++;
							continue;
						case "c":
							counter++;
							continue;
						}
					}
				}
				/*
				 * If the final state is equal to any of the acceptance states, the regular
				 * expression is valid, otherwise it is not.
				 */
				if (qState == 3 || qState == 4) {
					// The br.write(*) method allows to store the answers
					bw.write("La expresión regular " + input + " es válida para el autómata, su estado final fué 'q"
							+ qState + "'.\n");
				} else {
					bw.write("La expresión regular " + input + " no es válida.\n");
				}
				// Read the next line
				input = br.readLine();
			}
			// Show in console all the information stored in bw object
			bw.flush();
			br.close();
			bw.close();
		} catch (Exception e) {// Show in console the exceptions
			e.printStackTrace();
		}
	}

}
