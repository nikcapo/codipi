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
	        final GpioPinDigitalOutput led4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led4.low();
	        
	        final GpioPinDigitalOutput led5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led5.low();
	        
	        final GpioPinDigitalOutput led6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED", PinState.HIGH);
	        Thread.sleep(1000);
	        led6.low();
	}

}
