package raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;



import com.pi4j.io.gpio.GpioPinDigitalInput;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;


/**
 * Esta clase permite probar que las conexiones de la Raspberry a los tres
 * interruptores y tres pulsadores son correctas.
 * 
 * @author Carlos Sogorb
 *
 */
public class Pruebas2 {

	public static void main(String[] args) throws InterruptedException {
		disco();
	}

	private static void test() throws InterruptedException {

		// Controlador de GPIOs.
		GpioController gpioController = GpioFactory.getInstance();

		// Pines conectados a LEDs.
		GpioPinDigitalOutput led1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Led 1", PinState.LOW);
		GpioPinDigitalOutput led2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Led 2", PinState.LOW);
		GpioPinDigitalOutput led3 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Led 2", PinState.LOW);

//		// Pines conectados a botones.
	//	GpioPinDigitalInput boton1 = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_00,
//			PinPullResistance.PULL_UP);
//		GpioPinDigitalInput boton2 = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_02,
//				PinPullResistance.PULL_UP);
//		GpioPinDigitalInput boton3 = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_03,
//				PinPullResistance.PULL_UP);

		// Iniciamos el test.
		System.out.println("Iniciando el test");
		System.out.println("========================");

		// Test de leds.
		System.out.println("LED 1 encendido ...");
		led1.high();
		// led1.blink(200);
		Thread.sleep(2000);
		// led1.blink(0);
		led1.low();

		System.out.println("LED 2 encendido ...");
		led2.high();
		// led2.blink(200);
		Thread.sleep(2000);
		// led2.blink(0);
		led2.low();

		System.out.println("LED 3 parpadeando ...");
		led3.high();
		// led3.blink(200);
		Thread.sleep(2000);
		// led3.blink(0);
		led3.low();

		System.out.println("(Todos los LEDs apagados)");
		System.out.println("\nVe pulsando los botones y observa los mensajes de la consola ...");
		// Test de botones.

//		// create and register gpio pin listener
//		boton1.addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//				System.out.println("Pulsado el boton 1");
//			}
//		});
//
//		boton2.addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//				System.out.println("Pulsado el boton 2");
//			}
//		});
//
//		boton3.addListener(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//				System.out.println("Pulsado el boton 3");
//			}
//		});

		while (true) {
			Thread.sleep(500);
		}
	}

	private static void disco() {
		// Controlador de GPIOs.
		GpioController gpioController = GpioFactory.getInstance();

		// Pines conectados a LEDs.
		GpioPinDigitalOutput led1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Led 1", PinState.LOW);
		GpioPinDigitalOutput led2 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Led 2", PinState.LOW);
		GpioPinDigitalOutput led3 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Led 2", PinState.LOW);

		led1.blink(500);
		led2.blink(800);
		led3.blink(1100);

	}

}
