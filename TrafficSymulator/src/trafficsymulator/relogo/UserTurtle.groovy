package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.parameter.Parameters
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoTurtle;
import repast.simphony.engine.environment.RunEnvironment;

class UserTurtle extends ReLogoTurtle{
	Parameters p = RunEnvironment.getInstance().getParameters();
	float maxCarSpeed = p.getValue("maxCarSpeed");

	def stopTime = 0;
	def isStopped;
	def isCrossingCrossing;
	def allRoad = 0;
	def isRecentlyStoppedOnCrossing = false;

	def vCurrent = 0;
	def a;
	def sPrevious = 0;
	def tSinceStart = 0;
	def sCurrent = 0;

	def forward() {
		vCurrent = a * tSinceStart;
		tSinceStart += 1;

		if( self().patchAt(-1,0).pcolor!=gray()  && self().patchAt(0, 1).pcolor!=gray()  &&
		self().patchAt(1, 0).pcolor!=gray()  &&	self().patchAt(0,-1).pcolor!=gray() ) {
			//czyli jesli jest na skrzyzowaniu
			isCrossingCrossing = true
		}
		else {
			isCrossingCrossing = false
		}

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


	def stepWithLights() {
		isStopped = true
		
		if( self().patchAt(-1,0).pcolor!=gray()  && self().patchAt(0, 1).pcolor!=gray()  &&
			self().patchAt(1, 0).pcolor!=gray()  &&	self().patchAt(0,-1).pcolor!=gray() ) {
				//czyli jesli jest na skrzyzowaniu
				isCrossingCrossing = true
			}
			else {
				isCrossingCrossing = false
			}
		
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

	def stepWithRightHandPrinciple() {
		//te, które jad¹ w górê maj¹ pierwszeñstwo
		isStopped = true;
		isCrossingCrossing = false;

		if(self().getHeading() == 90) { //w prawo (muszê przepuœciæ tych co jad¹ w górê)
			if(self().patchAt(1,0).turtlesHere().isEmpty() &&
			self().patchAt(1,-1).turtlesHere().isEmpty() &&
			self().patchAt(1,-2).turtlesHere().isEmpty()) {
				forward();
				isStopped = false;
			}
		}
		else { //w górê (te maja pierwszenstwo)
			if(self().patchAt(0,1).turtlesHere().isEmpty()) { //sprawdza tylko czy pole przed nim jest wolne
				forward();
				isStopped = false;
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