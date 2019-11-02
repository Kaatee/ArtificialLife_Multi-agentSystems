package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.Patch
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	
	@Setup
	def setup(){
		clearAll()
		setDefaultShape(UserTurtle , "car")
		def currentCarNumber = 0;
		
		ask(patches()){
			if(pxcor % roadLength == 0 || pycor % roadLength == 0  ) {
				if(pcolor != green() && pcolor != red()) {
				pcolor = white();
				
				if(currentCarNumber < maxCarNumber ) {
					def x = pxcor
					def y = pycor
					currentCarNumber = currentCarNumber + 1;
					createUserTurtles(1){
						if(delay == true) {
							setCarDelay(Math.random()*10); //max Car delay = 10
						}
						setColor(black());
						setxy(x, y)
						}
						
				}
				
				if(pxcor % roadLength == 0 && pycor % roadLength == 0 ) {		
					self().patchAt(-1, 0).setPcolor(green());
					self().patchAt(0, -1).setPcolor(red());
				}
			}}
			else {
				pcolor = gray();
			}
		}
		
		ask(turtles()){
			if(self().patchAt(1,0).pcolor != gray()) {
					setHeading(90);
				}
				else {
					setHeading(0);
				}
		}
		
		
	}
	
	
	@Go
	def go(){
		ask(patches()){
			goPatch();
		}
		ask(turtles()){
			step();
		}
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