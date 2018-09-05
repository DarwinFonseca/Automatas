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
//	La expresi�n regular a no es v�lida.
//	La expresi�n regular b no es v�lida.
//	La expresi�n regular c no es v�lida.
//	La expresi�n regular aca no es v�lida.
//	La expresi�n regular baba no es v�lida.
//	La expresi�n regular caac no es v�lida.
//	La expresi�n regular bbb no es v�lida.
//	La expresi�n regular aaaa no es v�lida.
//	La expresi�n regular ccc no es v�lida.
//	La expresi�n regular cb es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular ab es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular babababaab es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular cabacabaacab es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular cabacabacb es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular bacabacabb es v�lida para el aut�mata, su estado final fu� 'q3'.
//	La expresi�n regular baacbaacbabb es v�lida para el aut�mata, su estado final fu� 'q3'.

	
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
