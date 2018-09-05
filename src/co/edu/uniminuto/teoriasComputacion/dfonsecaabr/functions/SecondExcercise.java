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
//La expresi�n regular a no es v�lida.
//La expresi�n regular aaaa no es v�lida.
//La expresi�n regular acacacaca no es v�lida.
//La expresi�n regular cc no es v�lida.
//La expresi�n regular ccccc no es v�lida.
//La expresi�n regular baca no es v�lida.
//La expresi�n regular acab es v�lida para el aut�mata, su estado final fu� 'q3'.
//La expresi�n regular acaba es v�lida para el aut�mata, su estado final fu� 'q4'.
//La expresi�n regular acabaccccccc es v�lida para el aut�mata, su estado final fu� 'q4'.
//La expresi�n regular acababbbcbcbcbcbcbcbc es v�lida para el aut�mata, su estado final fu� 'q4'.
//La expresi�n regular bb es v�lida para el aut�mata, su estado final fu� 'q3'.
//La expresi�n regular cb es v�lida para el aut�mata, su estado final fu� 'q3'.
//La expresi�n regular cab es v�lida para el aut�mata, su estado final fu� 'q3'.
//La expresi�n regular caba es v�lida para el aut�mata, su estado final fu� 'q4'.
//La expresi�n regular cababbb es v�lida para el aut�mata, su estado final fu� 'q4'.

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
					bw.write("La expresi�n regular " + input + " es v�lida para el aut�mata, su estado final fu� 'q"
							+ qState + "'.\n");
				} else {
					bw.write("La expresi�n regular " + input + " no es v�lida.\n");
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
