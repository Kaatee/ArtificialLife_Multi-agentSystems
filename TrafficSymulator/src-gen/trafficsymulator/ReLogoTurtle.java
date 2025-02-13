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
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoTurtle extends BaseTurtle{

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> hatchUserTurtles(int number, Closure closure) {
		AgentSet<trafficsymulator.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.hatch(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof trafficsymulator.relogo.UserTurtle){
				result.add((trafficsymulator.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Makes a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> hatchUserTurtles(int number) {
		return hatchUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<trafficsymulator.relogo.UserTurtle> result = new AgentSet<trafficsymulator.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof trafficsymulator.relogo.UserTurtle)
			result.add((trafficsymulator.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserTurtle")
	public AgentSet<trafficsymulator.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getTurtleLocation(),displacement,getMyObserver());
		AgentSet<trafficsymulator.relogo.UserTurtle> result = new AgentSet<trafficsymulator.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof trafficsymulator.relogo.UserTurtle)
			result.add((trafficsymulator.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<trafficsymulator.relogo.UserTurtle>();
		}
	}

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
	 * Returns the value from the getP() method of the underlying patch.
	 * 
	 * @return getP() of type repast.simphony.parameter.Parameters
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public repast.simphony.parameter.Parameters getP(){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		return p.getP();
	}

	/**
	 * Calls the setP(repast.simphony.parameter.Parameters) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public void setP(repast.simphony.parameter.Parameters value){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		p.setP(value);
	}

	/**
	 * Returns the value from the getTrafficLightsChangeDuration() method of the underlying patch.
	 * 
	 * @return getTrafficLightsChangeDuration() of type int
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public int getTrafficLightsChangeDuration(){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		return p.getTrafficLightsChangeDuration();
	}

	/**
	 * Calls the setTrafficLightsChangeDuration(int) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public void setTrafficLightsChangeDuration(int value){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		p.setTrafficLightsChangeDuration(value);
	}

	/**
	 * Returns the value from the getIteration() method of the underlying patch.
	 * 
	 * @return getIteration() of type java.lang.Object
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public java.lang.Object getIteration(){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		return p.getIteration();
	}

	/**
	 * Calls the setIteration(java.lang.Object) method of the underlying patch.
	 * 
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserPatch")
	public void setIteration(java.lang.Object value){
		trafficsymulator.relogo.UserPatch p = (trafficsymulator.relogo.UserPatch)patchHere();
		p.setIteration(value);
	}

	/**
	 * Makes a directed userLink from a turtle to the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink createUserLinkFrom(Turtle t, Closure closure){
		trafficsymulator.relogo.UserLink link = (trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink createUserLinkFrom(Turtle t){
			return createUserLinkFrom(t,null);
	}

	/**
	 * Makes directed userLinks from a collection to the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a, Closure closure){
		AgentSet<trafficsymulator.relogo.UserLink> links = new AgentSet<trafficsymulator.relogo.UserLink>();
		for(Turtle t : a){
			links.add((trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(t,this));
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks from a collection to the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> createUserLinksFrom(Collection<? extends Turtle> a){
		return createUserLinksFrom(a,null);
	}

	/**
	 * Makes a directed userLink to a turtle from the caller then executes a set of
	 * commands on the created userLink.
	 * 
	 * @param t
	 *            a turtle
	 * @param closure
	 *            a set of commands
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink createUserLinkTo(Turtle t, Closure closure){
		trafficsymulator.relogo.UserLink link = (trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,t);
		if (closure != null){
			this.ask(link,closure);
		}
		return link;
	}

	/**
	 * Makes a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return created userLink
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink createUserLinkTo(Turtle t){
			return createUserLinkTo(t,null);
	}

	/**
	 * Makes directed userLinks to a collection from the caller then executes a set
	 * of commands on the created userLinks.
	 * 
	 * @param a
	 *            a collection
	 * @param closure
	 *            a set of commands
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a, Closure closure){
		AgentSet<trafficsymulator.relogo.UserLink> links = new AgentSet<trafficsymulator.relogo.UserLink>();
		for(Object t : a){
			if (t instanceof Turtle){
				links.add((trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").addEdge(this,(Turtle)t));
			}
		}
		if (closure != null){
			this.ask(links,closure);
		}
		return links;
	}

	/**
	 * Makes directed userLinks to a collection from the caller.
	 * 
	 * @param a
	 *            a collection
	 * @return created userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> createUserLinksTo(Collection<? extends Turtle> a){
		return createUserLinksTo(a,null);
	}

	/**
	 * Queries if there is a directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink from
	 *         turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public boolean inUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(t, this);
	}

	/**
	 * Returns the agentset with directed userLinks to the caller.
	 * 
	 * @return agentset with directed userLinks to the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet inUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getPredecessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink from a turtle to the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink from turtle t to the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink inUserLinkFrom(Turtle t){
		return (trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(t,this);
	}

	/**
	 * Returns an agentset of directed userLinks from other turtles to the caller.
	 * 
	 * @return agentset of directed userLinks from other turtles to the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> myInUserLinks(){
		AgentSet<trafficsymulator.relogo.UserLink> result = new AgentSet<trafficsymulator.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getInEdges(this)){
			if (o instanceof trafficsymulator.relogo.UserLink){
				result.add((trafficsymulator.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Returns an agentset of directed userLinks to other turtles from the caller.
	 * 
	 * @return agentset of directed userLinks to other turtles from the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> myOutUserLinks(){
		AgentSet<trafficsymulator.relogo.UserLink> result = new AgentSet<trafficsymulator.relogo.UserLink>();
		for(Object o :  this.getMyObserver().getNetwork("UserLink").getOutEdges(this)){
			if (o instanceof trafficsymulator.relogo.UserLink){
				result.add((trafficsymulator.relogo.UserLink) o);
			}
		}
		return result;
	}

	/**
	 * Queries if there is a directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return true or false based on whether there is a directed userLink to
	 *         turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public boolean outUserLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isPredecessor(this, t);
	}

	/**
	 * Returns the agentset with directed userLinks from the caller.
	 * 
	 * @return agentset with directed userLinks from the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet outUserLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getSuccessors(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns the directed userLink to a turtle from the caller.
	 * 
	 * @param t
	 *            a turtle
	 * @return directed userLink to turtle t from the caller
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public trafficsymulator.relogo.UserLink outUserLinkTo(Turtle t){
		return (trafficsymulator.relogo.UserLink)this.getMyObserver().getNetwork("UserLink").getEdge(this, t);
	}

	/**
	 * Reports true if there is a userLink connecting t and the caller.
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public boolean userLinkNeighborQ(Turtle t){
		return this.getMyObserver().getNetwork("UserLink").isAdjacent(this, t);
	}

	/**
	 * Returns the agentset of all turtles found at the other end of
	 * userLinks connected to the calling turtle.
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet userLinkNeighbors(){
		AgentSet result = new AgentSet();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getAdjacent(this)){
			result.add(o);
		}
		return result;
	}

	/**
	 * Returns an agentset of the caller's userLinks.
	 * 
	 * @return agentset of the caller's userLinks
	 */
	@ReLogoBuilderGeneratedFor("trafficsymulator.relogo.UserLink")
	public AgentSet<trafficsymulator.relogo.UserLink> myUserLinks(){
		AgentSet<trafficsymulator.relogo.UserLink> result = new AgentSet<trafficsymulator.relogo.UserLink>();
		for(Object o : this.getMyObserver().getNetwork("UserLink").getEdges(this)){
			if (o instanceof trafficsymulator.relogo.UserLink){
				result.add((trafficsymulator.relogo.UserLink)o);
			}
		}
		return result;
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