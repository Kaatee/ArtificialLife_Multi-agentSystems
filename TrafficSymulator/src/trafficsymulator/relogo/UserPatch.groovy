package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.parameter.Parameters
import repast.simphony.relogo.Patch
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoPatch;
import repast.simphony.engine.environment.RunEnvironment;

class UserPatch extends ReLogoPatch{
	Parameters p = RunEnvironment.getInstance().getParameters();
	int trafficLightsChangeDuration = p.getValue("trafficLightsChangeDuration");
	
	def iteration = 0
	def goPatch() {
		iteration = iteration +1;
		if(iteration % trafficLightsChangeDuration == 0) {

			if(pcolor == red()) {
				pcolor = green();
			}
			else if(pcolor == green()) {
				pcolor = red();
			}
		}
	}
}