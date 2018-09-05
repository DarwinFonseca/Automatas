/**
 * 
 */
package co.edu.uniminuto.teoriasComputacion.dfonsecaabr.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author DarwinFonck
 *
 */
public class FirstExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String input = br.readLine();
			String[] inputArray;

			while (!input.equals("FIN")) {
				int counter = 0;
				int qState = 0;
				// bw.write(input);
				inputArray = input.split("");
				// System.out.println(Arrays.toString(inputArray));
				while (counter < inputArray.length) {
					if (qState == 0) { // q0
						if (inputArray[counter].equals("0")) { // 0
							qState++;
							counter++;
							continue;
						} else {// 1
							counter = inputArray.length;
							qState = 10;
							continue;
						}
					}
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
				if (qState == 0 || qState == 3) {
					bw.write("La expresión regular " + input + " es válida para el autómata, su estado final fué 'q"
							+ qState + "'.\n");
				} else {
					bw.write("La expresión regular " + input + " no es válida.\n");
				}
				input = br.readLine();
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
