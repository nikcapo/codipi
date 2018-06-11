package raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;



public class PruebaLeds {

	public static void main(String[] args) throws InterruptedException {
		 System.out.println("<--Pi4J--> GPIO Control Example ... started.");

	        // create gpio controller
	        final GpioController gpio = GpioFactory.getInstance();

	        // provision gpio pin #01 as an output pin and turn on
	        final GpioPinDigitalOutput led1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led1.low();
	        
	        final GpioPinDigitalOutput led2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led2.low();
	        
	        final GpioPinDigitalOutput led3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led3.low();
	}

}
