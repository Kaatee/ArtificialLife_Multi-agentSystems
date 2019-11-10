package trafficsymulator;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<trafficsymulator.relogo.UserTurtle> result = new AgentSet<trafficsymulator.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof trafficsymulator.relogo.UserTurtle)
			result.add((trafficsymulator.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<trafficsymulator.relogo.UserTurtle> result = new AgentSet<trafficsymulator.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof trafficsymulator.relogo.UserTurtle)
			result.add((trafficsymulator.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<trafficsymulator.relogo.UserTurtle>();
		}

		Set<trafficsymulator.relogo.UserTurtle> total = new HashSet<trafficsymulator.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<trafficsymulator.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof trafficsymulator.relogo.UserTurtle);
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public trafficsymulator.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof trafficsymulator.relogo.UserTurtle)
			return (trafficsymulator.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtles(){
		AgentSet<trafficsymulator.relogo.UserTurtle> a = new AgentSet<trafficsymulator.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(trafficsymulator.relogo.UserTurtle.class)) {
			if (e instanceof trafficsymulator.relogo.UserTurtle){
				a.add((trafficsymulator.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof trafficsymulator.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> userLinks(){
		AgentSet<trafficsymulator.relogo.UserLink> a = new AgentSet<trafficsymulator.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(trafficsymulator.relogo.UserLink.class)) {
			if (e instanceof trafficsymulator.relogo.UserLink){
				a.add((trafficsymulator.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (trafficsymulator.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}


}