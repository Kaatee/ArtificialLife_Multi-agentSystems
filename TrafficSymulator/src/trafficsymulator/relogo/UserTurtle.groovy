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
	
	def step() {
		if( (self().patchAt(-1,0).pcolor==green() || self().patchAt(-1,0).pcolor==red() || self().patchAt(-1,0).pcolor==white()) &&
			(self().patchAt(0, 1).pcolor==green() || self().patchAt(0, 1).pcolor==red() || self().patchAt(0, 1).pcolor==white()) &&
			(self().patchAt(1, 0).pcolor==green() || self().patchAt(1, 0).pcolor==red() || self().patchAt(1, 0).pcolor==white()) &&
			(self().patchAt(0,-1).pcolor==green() || self().patchAt(0,-1).pcolor==red()|| self().patchAt(0,-1).pcolor==white())) { //czyli jesli jest na skrzyzowaniu
			//pewnie da sie tego ida jakos inaczej zrobic
			def x = Math.random()
			if(x < 0.5  && self().patchAt(0,0).pcolor != red() ) {
				setHeading(90);// w prawo
				fd(1);
			}
			if(x >= 0.5  && self().patchAt(0,0).pcolor != red() ) {
				setHeading(0);
				fd(1);
			}
		}
		else {
			if(self().patchAt(0,0).pcolor != red() ) { //i jeszcze sprawdzic czy nie stoi juz inne autko
				fd(1);
		}
		}
	}
}