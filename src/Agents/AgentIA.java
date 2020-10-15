package Agents;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class AgentIA extends Agent {
    protected void setup() {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AgentIA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inscription.enregistrerIA(this);
    }
}