package Agents;

import java.util.ArrayList;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ContainerIA {
	AgentContainer agentContainer;
	
	ArrayList<String> usersNoms = new ArrayList<String>();
	ArrayList<String> usersTypes = new ArrayList<String>();
	ArrayList<Integer> usersPoints = new ArrayList<Integer>();
	
	public ContainerIA() {
		try {
			Runtime runtime=Runtime.instance();
			ProfileImpl profileImpl=new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST,"localhost");
			agentContainer=runtime.createAgentContainer(profileImpl);
			agentContainer.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	public static AgentController agentCreator(String name, String type, AgentContainer agentContainer) {
		try {
			AgentController ag = null;
			ag = agentContainer.createNewAgent(name,"Agents.AgentIA",new Object[]{});
			ag.start();
			return ag;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void userCreator(String name, String type) {
		usersNoms.add(name);
		usersTypes.add(type);
	}
}


