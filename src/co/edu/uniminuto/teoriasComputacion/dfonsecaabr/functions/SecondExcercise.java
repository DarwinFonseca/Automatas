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
public class SecondExcercise {
//a
//aaaa
//acacacaca
//cc
//ccccc
//baca
//acab
//acaba
//acabaccccccc
//acababbbcbcbcbcbcbcbc
//bb
//cb
//cab
//caba
//cababbb
//FIN
	
//RESPUESTAS ESPERADAS
//La expresión regular a no es válida.
//La expresión regular aaaa no es válida.
//La expresión regular acacacaca no es válida.
//La expresión regular cc no es válida.
//La expresión regular ccccc no es válida.
//La expresión regular baca no es válida.
//La expresión regular acab es válida para el autómata, su estado final fué 'q3'.
//La expresión regular acaba es válida para el autómata, su estado final fué 'q4'.
//La expresión regular acabaccccccc es válida para el autómata, su estado final fué 'q4'.
//La expresión regular acababbbcbcbcbcbcbcbc es válida para el autómata, su estado final fué 'q4'.
//La expresión regular bb es válida para el autómata, su estado final fué 'q3'.
//La expresión regular cb es válida para el autómata, su estado final fué 'q3'.
//La expresión regular cab es válida para el autómata, su estado final fué 'q3'.
//La expresión regular caba es válida para el autómata, su estado final fué 'q4'.
//La expresión regular cababbb es válida para el autómata, su estado final fué 'q4'.

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
				if (qState == 3 || qState == 4) {
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
