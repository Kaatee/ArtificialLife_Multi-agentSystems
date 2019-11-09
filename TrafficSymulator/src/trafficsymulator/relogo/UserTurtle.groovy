package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoTurtle;

class UserTurtle extends ReLogoTurtle{
	def stopTime = 0;
	def isStopped;
	def isCrossingCrossing;
	def allRoad = 0;
	def isRecentlyStoppedOnCrossing = false;
	
	def vCurrent = 0;
	def a = 1.2;
	def sPrevious = 0;
	def tSinceStart = 0;
	/*
	 * 	"maxCarNumber", "Maksymalna liczba samochodow: ", 1, 1, 200, 50)	
		"roadLength", "D³ugoœæ drogi miêdzy dwoma skrzy¿owaniami: ", 1, 1, 20, 7)
		"maxCarSpeed", "Maksymalna prêdkoœæ pojazdu: ", 0.01, 0.01, 1, 1)
		"maxCarAcceleration", "Maksumalne pzyœpieszenie pojazdu: ", 0.01, 0.01, 1, 1)
		"trafficLightsChangeDuration", "Czas zmiany œwiate³: ", 1, 1, 100, 10)
	 */
	
	def forward() {
		def sCurrent;
		vCurrent = a * tSinceStart;
		tSinceStart += 1;
		if(vCurrent <= maxCarSpeed) {
			sCurrent = 0.5 * a * tSinceStart - sPrevious;
		}
		else {
			sCurrent = sPrevious;
		}
		fd(sCurrent);
		allRoad += sCurrent;
		sPrevious = sCurrent;
	}
	
	
	def step() {
		isStopped = true
		isCrossingCrossing = false
		if(self().patchAt(0,0).pcolor != red()  ) {
				if(self().getHeading() == 90) {
					if(self().patchAt(1,0).turtlesHere().isEmpty()) {
						forward();
						isStopped = false;
					}
				}
				else {
					if(self().patchAt(0,1).turtlesHere().isEmpty()) {
						forward();
						isStopped = false;
					}
				}
		}
		
		if(isStopped) {
			stopTime = stopTime + 1;
			vCurrent = 0;
			sPrevious = 0;
			tSinceStart = 0;
		}
	}
}