package Agents;

import java.util.ArrayList;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ContainerSMA {
	AgentContainer agentContainer;
	public ArrayList<String> usersNoms = new ArrayList<String>();
	static ArrayList<String> usersTypes = new ArrayList<String>();
	ArrayList<Integer> usersPoints = new ArrayList<Integer>();
	
	public ContainerSMA() {
		Runtime runtime = Runtime.instance();
		Properties properties = new ExtendedProperties();
		properties.setProperty(Profile.GUI, "true");
		Profile profile = new ProfileImpl(properties);
		
		agentContainer = runtime.createAgentContainer(profile);
		
		try {
			agentContainer.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	public static AgentController agentCreator(String name, String type, AgentContainer mainContainer) {
		try {
			AgentController ag = null;
			ag = mainContainer.createNewAgent(name,"Agents.AgentSMA",new Object[]{});
			ag.start();
			return ag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void userCreator(String name, String type) {
		usersNoms.add(name);
		usersTypes.add(type);
	}
}