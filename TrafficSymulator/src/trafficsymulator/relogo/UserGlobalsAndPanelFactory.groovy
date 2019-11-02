package trafficsymulator.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		addSliderWL("maxCarNumber", "Maksymalna liczba samochodow: ", 1, 1, 200, 50)
		addChooserWL("symetricWorld", "Czy �wiat jest symatryczny ", [true, false], 0)
	
		addSliderWL("roadLength", "D�ugo�� drogi mi�dzy dwoma skrzy�owaniami: ", 1, 1, 20, 7)
		
		addSliderWL("maxCarSpeed", "Maksymalna pr�dko�� pojazdu: ", 1, 0.1, 10, 1)
		addSliderWL("trafficLightsChangeDuration", "Czas zmiany �wiate�: ", 1, 1, 100, 10)
		addChooserWL("delay", "Czy samochody maj� op�nienie ", [false, true], 0)
		
		
		//parametry mierzone: 
		//�redni czas oczekiwania pojazdow na �wiat�ach
		//�rednia pr�sko�� pojazd�w
		//liczba zatrzymanych pojazd�w
		
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