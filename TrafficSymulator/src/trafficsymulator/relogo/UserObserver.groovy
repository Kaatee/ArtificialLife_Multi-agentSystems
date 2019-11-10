package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.parameter.Parameters
import repast.simphony.relogo.Patch
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoObserver;
import repast.simphony.engine.environment.RunEnvironment;

class UserObserver extends ReLogoObserver{

	//TODO - wsadowe
	Parameters p = RunEnvironment.getInstance().getParameters();
	int maxCarNumber = p.getValue("maxCarNumber");
	int roadLength = p.getValue("roadLength");
	boolean isTrafficLights = p.getValue("isTrafficLights");
	boolean isGreenLine = p.getValue("isGreenLine");

	@Setup
	def setup(){
		clearAll()
		setDefaultShape(UserTurtle , "car")
		def currentCarNumber = 0;

		ask(patches()){
			if(pxcor % roadLength == 0 || pycor % roadLength == 0 ) {//rysuje drogi
				if(pcolor != green() && pcolor != red()) {
					pcolor = white();

					if(currentCarNumber < maxCarNumber ) {
						def x = pxcor
						def y = pycor
						currentCarNumber = currentCarNumber + 1;
						createUserTurtles(1){
							setColor(black());
							setxy(x, y)
						}

					}
					if(isTrafficLights) { //rysuje sygnalizacje swietlna
						if(pxcor % roadLength == 0 && pycor % roadLength == 0 ) {	//jestem na skrzyzowaniu
							if(isGreenLine) {
								self().patchAt(-1, 0).setPcolor(green());
								self().patchAt(0, -1).setPcolor(red());
							}
							else {
								def rand = Math.random();
								if(rand < 0.5) {
									self().patchAt(-1, 0).setPcolor(green());
									self().patchAt(0, -1).setPcolor(red());
								}
								else{
									self().patchAt(-1, 0).setPcolor(red());
									self().patchAt(0, -1).setPcolor(green());
								}
							}
						}
					}
				}}
			else {
				pcolor = gray();
			}
		}

		ask(turtles()){
			if(self().patchAt(1,0).pcolor != gray()) {
				setHeading(90); //right
			}
			else {
				setHeading(0);
			}
		}


	}

	def sumOfStopTime = 0;
	def amountOfStoppeCars = 0;
	def amountOfCarsCrossingCrossing = 0;

	@Go
	def go(){
		sumOfStopTime = 0;
		amountOfStoppeCars = 0; //w danej chwili

		if(isTrafficLights) {
			ask(patches()){
				goPatch();
			}
		}
		ask(turtles()){
			if(isTrafficLights) {
				stepWithLights();
			}
			else {
				stepWithRightHandPrinciple();
			}

			sumOfStopTime = sumOfStopTime + stopTime; //stopTime - suma czasu jaki dany samochow w sumie stał
			if(isStopped) {
				amountOfStoppeCars +=1;
			}
			if(isCrossingCrossing) {
				amountOfCarsCrossingCrossing = amountOfCarsCrossingCrossing + 1; //suma w calym dzialaniu programu
			}
		}
	}

	def calculateAverageWaitTime() {
		return sumOfStopTime / maxCarNumber;
	}

	def calculateAmountOfStoppedCars() { //liczba zatrzymanych w danej chwili pojazdow
		return amountOfStoppeCars;
	}

	def averageSumOfCarsThatCrossCrossing() {
		//srednia liczba samochodow, ktore przejechaly skrzyzowania
		return amountOfCarsCrossingCrossing / tick();
	}





	/**
	 * Add observer methods here. For example:
	 @Setup
	 def setup(){
	 clearAll()
	 createTurtles(10){
	 forward(random(10))
	 }
	 }
	 *
	 * or
	 * 	
	 @Go
	 def go(){
	 ask(turtles()){
	 left(random(90))
	 right(random(90))
	 forward(random(10))
	 }
	 }
	 */

}