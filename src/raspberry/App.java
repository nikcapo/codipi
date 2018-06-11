package raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.PinState;
import com.pi4j.*;



public class App {

	private int puntos = 0; // Puntos que lleva hechos el usuario
	boolean acierto = false; // Valdra true cuando el usuario pulse el boton correcto
	int led; // Led que se va a encender aleatoriamente
	int tiempoPermitido = 10000; // Tiempo que tiene el usuario para pulsar el boton

	private GpioController gpioController;
	private GpioPinDigitalOutput leds[];
	private GpioPinDigitalInput botones[];

	public static void main(String[] args) {

		System.out.println("Ejecutando ...\n");
		new App();
		System.out.println("\nAplicacion finalizada.");

	}

	public App() {

		puntos = 0;
		gpioController = GpioFactory.getInstance();

		leds = new GpioPinDigitalOutput[3];
		leds[0] = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08, PinState.LOW);
		leds[1] = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09, PinState.LOW);
		leds[2] = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, PinState.LOW);

//		botones = new GpioPinDigitalInput[3];
//		botones[0] = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_UP);
//		botones[1] = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_UP);
//		botones[2] = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_00, PinPullResistance.PULL_UP);

//		botones[0].addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent arg0) {
//				if (led == 0) {
//					acierto = true;
//					System.out.println("Acierto al pulsar el boton 0");
//				}
//			}
//		});
//
//		botones[1].addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent arg0) {
//				if (led == 1) {
//					acierto = true;
//					System.out.println("Acierto al pulsar el boton 1");
//				}
//			}
//		});
//
//		botones[2].addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent arg0) {
//				if (led == 2) {
//					acierto = true;
//					System.out.println("Acierto al pulsar el boton 2");
//				}
//			}
//		});

		try {
			jugar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void jugar() throws InterruptedException {

		long tiempoInicio; // Tiempo en el que empezamos a contar.

		// Sacamos un numero aleatorio entre 0 y 2.
		led = (int) (Math.random() * 3);

		// Encendemos el led correspondiente.
		leds[led].setState(PinState.HIGH);

		// Empezamos a contar el tiempo.
		tiempoInicio = System.currentTimeMillis();

		while (System.currentTimeMillis() - tiempoInicio < tiempoPermitido && !acierto) {
			Thread.sleep(100);
		}

		if (acierto) {
			puntos++;
			acierto = false;
		}
		
		if (puntos == 1) {
			System.out.println("Tienes 1 punto.");
		} else {
			System.out.println("Tienes " + puntos + " puntos.");
		}

	}

}
