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

public class FirstExercise {

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
					 * If the state is q0, it evaluates the data in the 'counter' position for the
					 * array, if it is 0 it changes to the respective state, if not, the iteration
					 * ends because it does not comply with the automaton.
					 */
					if (qState == 0) {
						if (inputArray[counter].equals("0")) {
							qState++;
							counter++;
							continue;
						} else {// 1
							counter = inputArray.length;
							qState = 10;
							continue;
						}
					}
					/*
					 * If the state is q1, it evaluates the data in the 'counter' position for the
					 * array, if it is 0 it does not change state, if not, the state changes.
					 */
					if (qState == 1) { // q1
						if (inputArray[counter].equals("0")) { // 0
							counter++;
							continue;
						} else { // 1
							qState++;
							counter++;
							continue;
						}
					}
					/*
					 * If the state is q2, it evaluates the data in the 'counter' position for the
					 * array, if it is 0 it does not change state, if not, the state changes.
					 */
					if (qState == 2) { // q2
						if (inputArray[counter].equals("0")) {// 0
							counter++;
							continue;
						} else { // 1
							qState++;
							counter++;
							continue;
						}
					}
					/*
					 * If the state is q3, it evaluates the data in the 'counter' position for the
					 * array, if it is 0 the state changes to 0, if not, it continues in a loop.
					 */
					if (qState == 3) { // q3
						if (inputArray[counter].equals("0")) {// 0
							counter++;
							qState = 0;
							continue;
						} else { // 1
							counter++;
							continue;
						}
					}
				}
				/*
				 * If the final state is equal to any of the acceptance states, the regular
				 * expression is valid, otherwise it is not.
				 */
				if (qState == 0 || qState == 3) {
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
