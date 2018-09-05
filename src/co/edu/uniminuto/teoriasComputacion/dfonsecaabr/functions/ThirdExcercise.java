package co.edu.uniminuto.teoriasComputacion.dfonsecaabr.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ThirdExcercise {

//	a
//	b
//	c
//	aca
//	baba
//	caac
//	bbb
//	aaaa
//	ccc
//	cb
//	ab
//	babababaab
//	cabacabaacab
//	cabacabacb
//	bacabacabb
//	baacbaacbabb
//	FIN
	
	//RESUTADOS ESPERADOS
//	La expresión regular a no es válida.
//	La expresión regular b no es válida.
//	La expresión regular c no es válida.
//	La expresión regular aca no es válida.
//	La expresión regular baba no es válida.
//	La expresión regular caac no es válida.
//	La expresión regular bbb no es válida.
//	La expresión regular aaaa no es válida.
//	La expresión regular ccc no es válida.
//	La expresión regular cb es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular ab es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular babababaab es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular cabacabaacab es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular cabacabacb es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular bacabacabb es válida para el autómata, su estado final fué 'q3'.
//	La expresión regular baacbaacbabb es válida para el autómata, su estado final fué 'q3'.

	
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
							qState = 0;
							continue;
						}
					}
					if (qState == 2) { // q2
						switch (inputArray[counter]) {
						case "a":
							counter++;
							qState = 0;
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
							counter = inputArray.length;
							qState = 10;
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
				}
				if (qState == 3) {
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
