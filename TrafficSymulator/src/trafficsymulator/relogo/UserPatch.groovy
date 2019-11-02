package trafficsymulator.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.Patch
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import trafficsymulator.ReLogoPatch;

class UserPatch extends ReLogoPatch{
	def iteration = 0
	def goPatch() {
		iteration = iteration +1;
		if(iteration%20 ==0) {
			
			if(pcolor == red()) {
				pcolor = green();
			}
			else if(pcolor == green()) {
				pcolor = red();
			}
		}
		
	}
}