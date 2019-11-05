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
	def carDelay;
	def stopTime = 0;
	def isStopped = true;
	/*
	 * 	"maxCarNumber", "Maksymalna liczba samochodow: ", 1, 1, 200, 50)	
		"roadLength", "D³ugoœæ drogi miêdzy dwoma skrzy¿owaniami: ", 1, 1, 20, 7)
		"maxCarSpeed", "Maksymalna prêdkoœæ pojazdu: ", 0.01, 0.01, 1, 1)
		"maxCarAcceleration", "Maksumalne pzyœpieszenie pojazdu: ", 0.01, 0.01, 1, 1)
		"trafficLightsChangeDuration", "Czas zmiany œwiate³: ", 1, 1, 100, 10)
		"delay", "Czy samochody maj¹ opó¿nienie ", [false, true], 0)
	 */
	
	def step() {
		isStopped = true
		if( (self().patchAt(-1,0).pcolor==green() || self().patchAt(-1,0).pcolor==red() || self().patchAt(-1,0).pcolor==white()) &&
			(self().patchAt(0, 1).pcolor==green() || self().patchAt(0, 1).pcolor==red() || self().patchAt(0, 1).pcolor==white()) &&
			(self().patchAt(1, 0).pcolor==green() || self().patchAt(1, 0).pcolor==red() || self().patchAt(1, 0).pcolor==white()) &&
			(self().patchAt(0,-1).pcolor==green() || self().patchAt(0,-1).pcolor==red()|| self().patchAt(0,-1).pcolor==white())) { //czyli jesli jest na skrzyzowaniu
			//pewnie da sie tego ida jakos inaczej zrobic
			def x = Math.random()
			if(x < 0.5  && self().patchAt(0,0).pcolor != red() ) {
				setHeading(90);// w prawo
				if(self().patchAt(1,0).turtlesHere().isEmpty()) {
					fd(1);
					isStopped = false;
				}
			}
			if(x >= 0.5  && self().patchAt(0,0).pcolor != red() ) {
				setHeading(0);
				if(self().patchAt(0,1).turtlesHere().isEmpty()) {
					fd(1);
					isStopped = false;
				}
			}
		}
		else {
			if(self().patchAt(0,0).pcolor != red()  ) {
				if(self().getHeading() == 90) {
					if(self().patchAt(1,0).turtlesHere().isEmpty()) {
						fd(1);
						isStopped = false;
					}
				}
				else {
					if(self().patchAt(0,1).turtlesHere().isEmpty()) {
						fd(1);
						isStopped = false;
					}
				}
		}
		}
		if(isStopped) {
			stopTime = stopTime + 1;
		}
	}
}