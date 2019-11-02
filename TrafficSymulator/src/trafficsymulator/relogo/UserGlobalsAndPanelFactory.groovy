package trafficsymulator.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		addSliderWL("maxCarNumber", "Maksymalna liczba samochodow: ", 1, 1, 200, 50)
		addChooserWL("symetricWorld", "Czy œwiat jest symatryczny ", [true, false], 0)
	
		addSliderWL("roadLength", "D³ugoœæ drogi miêdzy dwoma skrzy¿owaniami: ", 1, 1, 20, 7)
		
		addSliderWL("maxCarSpeed", "Maksymalna prêdkoœæ pojazdu: ", 1, 0.1, 10, 1)
		addSliderWL("trafficLightsChangeDuration", "Czas zmiany œwiate³: ", 1, 1, 100, 10)
		addChooserWL("delay", "Czy samochody maj¹ opó¿nienie ", [false, true], 0)
		
		
		//parametry mierzone: 
		//œredni czas oczekiwania pojazdow na œwiat³ach
		//œrednia prêskoœæ pojazdów
		//liczba zatrzymanych pojazdów
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
	        addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
	        // Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
	        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
	        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
	        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
	        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
	        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
	        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
	        addChooser("chooserVariable2", [1, 66, "seven"], 0)
	        // State change button (method name in observer)
	        addStateChangeButton("change")
	        // State change button with label (method name in observer, label)
	        addStateChangeButtonWL("changeSomething","Change Something")
	        
		 */

	}
}