package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.parameter.Parameters
import repast.simphony.relogo.Patch
import repast.simphony.relogo.ReLogoModel
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoObserver;
import repast.simphony.engine.environment.RunEnvironment;

class UserObserver extends ReLogoObserver{

	Parameters p = RunEnvironment.getInstance().getParameters();
	Object pg = RunEnvironment.getInstance().endAt(400);


	int maxCarNumber = p.getValue("maxCarNumber");
	int roadLength = p.getValue("roadLength");
	boolean isTrafficLights = p.getValue("isTrafficLights");
	int percentageOfCarsWithLessAcceleration = p.getValue("percentageOfCarsWithLessAcceleration");
	float maxCarAcceleration = p.getValue("maxCarAcceleration");

	float minCarAcceleration = 0.2;
	double highA = 0.8;
	double lessA = 0.3;

	boolean isGreenLine = false;
	boolean ifWorldWithSomeCarsHasLessAcc = false;


	@Setup
	def setup(){

		if(percentageOfCarsWithLessAcceleration > 0) {
			ifWorldWithSomeCarsHasLessAcc = true;
		}

		clearAll()
		setDefaultShape(UserTurtle , "car")
		def currentCarNumber = 0;

		ask(patches()){
			if(pxcor % roadLength == 0 || pycor % roadLength == 0 ) {
				//rysuje drogi
				if(pcolor != green() && pcolor != red()) {
					pcolor = white();

					if(currentCarNumber < maxCarNumber) {
						def x = pxcor
						def y = pycor
						currentCarNumber = currentCarNumber + 1;
						if(!ifWorldWithSomeCarsHasLessAcc) {
							Random r = new Random();
							float randomA = minCarAcceleration + (maxCarAcceleration - minCarAcceleration) * r.nextDouble();
							createUserTurtles(1){
								setColor(black());
								setxy(x, y)
								setA(randomA);
							}
						}
						else {
							int amountOfCarsWithLessA = Math.round(maxCarNumber * percentageOfCarsWithLessAcceleration / 100);
							if(currentCarNumber == amountOfCarsWithLessA) {
								createUserTurtles(1){
									setColor(black());
									setxy(x, y)
									setA(lessA);
								}
							}
							else {
								createUserTurtles(1){
									setColor(black());
									setxy(x, y)
									setA(highA);
								}
							}
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
	def allCarsRoad = 0;
	int tick = 0;

	@Go
	def go(){
		tick += 1
		sumOfStopTime = 0;
		amountOfStoppeCars = 0; //w danej chwili


		ask(patches()){
			if(isTrafficLights) {
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
			allCarsRoad += sCurrent;
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
		if(tick > 0) {
			return (amountOfCarsCrossingCrossing / tick);
		}
		else {
			return 0;
		}
	}

	def calculateAverageCarsSpeed() {
		if(tick > 0) {
			return (allCarsRoad / (tick * maxCarNumber));
		}
		else {
			return 0;
		}
	}


}