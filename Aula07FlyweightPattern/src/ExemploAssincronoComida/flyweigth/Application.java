package ExemploAssincronoComida.flyweigth;

import ExemploAssincronoComida.flyweight.dto.ComidaDTO;
import ExemploAssincronoComida.flyweight.factory.ComidaFactory;

public class Application {

	public static void main(String[] args) {

		final ComidaFactory comida = new ComidaFactory();

		ComidaDTO pastaVerdura = comida.getComida("Pastas");
		pastaVerdura.setPrecio(10000);

		final ComidaDTO pastaCarne = comida.getComida("Pastas");
		System.out.println(pastaCarne.toString());
	}
}
