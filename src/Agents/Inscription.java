package Agents;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("serial")
public class Inscription  extends javax.swing.JFrame  {
	static MainContainer mainContainer;
	ContainerIA containerIA;
	ContainerSMA containerSMA;
	
	AgentController ag;
	AgentController ag2;

	static ArrayList<AgentController> agentControllers = new ArrayList<AgentController>();
	
	static String username;
	String type;
	String path = "";
	String eval = "";
	String filename = "";
	List <String> files = new ArrayList <String>();
	int index;
	
	JFrame frame;
	
	static AgentIA IA = null;
	static AgentSMA SMA = null;

    String text = "";

	public Inscription() {
		initComponents();
		setVisible(true);
        mainContainer = new MainContainer();
        containerIA = new ContainerIA();
    	containerSMA = new ContainerSMA();
	}
	
	static void enregistrerIA (AgentIA f) {
		if(IA == null) IA = f;
    }
	
	static void enregistrerSMA (AgentSMA f) {
		if(SMA == null) SMA = f;
	}
	
	private void initComponents() {
        String[] options = {"SMA","IA"};
        
        JLayeredPane layeredPane = new JLayeredPane();
        
        JTextPane textPane = new JTextPane();
        textPane.setBounds(10, 23, 73, 82);
        
        //INTERFACE PRINCIPALE
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 0, 397, 195);
        //layeredPane.add(panel_2);
        panel_2.setLayout(null);
        
        //INTERFACE D INSCRIPTION
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 397, 195);
        layeredPane.add(panel);
        panel.setLayout(null);
        
        //INTERFACE DE CONNEXION
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 397, 195);
        //layeredPane.add(panel_1);
        panel_1.setLayout(null);
		
		
		///conn
		JLabel label = new JLabel("");
		label.setBounds(103, 181, 245, 14);
		label.setForeground(Color.RED);
		panel_1.add(label);
        
        
		///ins
		JLabel label2 = new JLabel("");
		label2.setBounds(103, 181, 150, 14);
		label2.setForeground(Color.RED);
		panel.add(label2);
		
		
		//u
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(306, 147, 91, 20);
		panel_2.add(lblNewLabel);
		
		
		//nf
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(306, 172, 85, 14);
		panel_2.add(lblNewLabel_1);
        
        
//////////////////////////////PANEL (INSCRIPTION)////////////////////////////////////////
        JLabel lblInscription = new JLabel("INSCRIPTION");
        lblInscription.setBounds(151, 22, 94, 14);
        panel.add(lblInscription);
        
        
//////////////////////////////NOM DE L UTILISATEUR////////////////////////////////////////
        JLabel lblNomDeLutilisateur = new JLabel("Nom de l'utilisateur:");
        lblNomDeLutilisateur.setBounds(131, 65, 94, 14);
        panel.add(lblNomDeLutilisateur);
        JTextField textField;
        textField = new JTextField();
        textField.setBounds(131, 84, 114, 20);
        textField.setColumns(10);
        panel.add(textField);
        
        
//////////////////////////////CENTRE D INTERET////////////////////////////////////////
        JLabel lblCentreDintert = new JLabel("Centre d'inter\u00EAt:");
        lblCentreDintert.setBounds(120, 118, 80, 14);
        panel.add(lblCentreDintert);
        JComboBox<?> comboBox = new JComboBox<Object>(options);
        comboBox.setBounds(210, 115, 53, 20);
        panel.add(comboBox);
        
        
//////////////////////////////S INSCRIRE////////////////////////////////////////
        JButton jButton1_1 = new JButton();
        jButton1_1.setBounds(131, 151, 114, 33);
        jButton1_1.setText("S'inscrire");
        jButton1_1.setForeground(Color.BLACK);
        jButton1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boolean exist2;
            	if(comboBox.getSelectedItem().toString() == "IA") {
            		exist2 = false;	
        			for(int i=0; i<containerIA.usersNoms.size(); i++) {
        				String a = containerIA.usersNoms.get(i);
        				if(textField.getText().equals(a)) {
        					exist2 = true;
        					break;
        				}
        			}
        			if (!exist2) {
        				containerIA.userCreator(textField.getText(),comboBox.getSelectedItem().toString());
                    	containerIA.usersPoints.add(0);
                    	layeredPane.remove(panel);
                    	layeredPane.add(panel_1);
                    	layeredPane.updateUI();
        			}else label2.setText("Cet utilisateur existe déja");
            	} else if(comboBox.getSelectedItem().toString() == "SMA") {
            		exist2 = false;	
        			for(int i=0; i<containerSMA.usersNoms.size(); i++) {
        				String a = containerSMA.usersNoms.get(i);
        				if(textField.getText().equals(a)) {
        					exist2 = true;
        					break;
        				}
        			}
        			if (!exist2) {
        				containerSMA.userCreator(textField.getText(),comboBox.getSelectedItem().toString());
                    	containerSMA.usersPoints.add(0);
                    	layeredPane.remove(panel);
                    	layeredPane.add(panel_1);
                    	layeredPane.updateUI();
        			}else label2.setText("Cet utilisateur existe déja");
            	}
                textField.setText("");
            }
        });
        panel.add(jButton1_1);
        
        
//////////////////////////////REDIRECTION CONNEXION////////////////////////////////////////
        JButton btnConnexion = new JButton("Connexion");
        btnConnexion.setBackground(Color.WHITE);
        btnConnexion.setBounds(283, 0, 114, 23);
        btnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	layeredPane.remove(panel);
            	layeredPane.add(panel_1);
            	layeredPane.updateUI();
            }
        });
        panel.add(btnConnexion);
        
        

        
//////////////////////////////PANEL 1 (CONNEXION)////////////////////////////////////////
        JLabel lblConnexion = new JLabel("CONNEXION");
        lblConnexion.setBounds(151, 22, 94, 14);
        panel_1.add(lblConnexion);
        
        
//////////////////////////////REDIRECTION INSCRIPTION////////////////////////////////////////
        JButton btnInscription = new JButton("Inscription");
        btnInscription.setBackground(Color.WHITE);
        btnInscription.setBounds(283, 0, 114, 23);
        panel_1.add(btnInscription);
        btnInscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	layeredPane.remove(panel_1);
            	layeredPane.add(panel);
            	layeredPane.updateUI();
            }
        });
        
        
//////////////////////////////NOM DE L UTILISATEUR////////////////////////////////////////
        JLabel lblNomDeLutilisateur_1 = new JLabel("Nom de l'utilisateur:");
        lblNomDeLutilisateur_1.setBounds(131, 59, 94, 14);
        panel_1.add(lblNomDeLutilisateur_1);
        JTextField textField_1;
        textField_1 = new JTextField();
        textField_1.setBounds(131, 84, 114, 20);
        panel_1.add(textField_1);
        textField_1.setColumns(10);
        
        
//////////////////////////////CENTRE D INTERET////////////////////////////////////////
		JLabel lblCentreDintert_1 = new JLabel("Centre d'inter\u00EAt:");
		lblCentreDintert_1.setBounds(120, 118, 80, 14);
		panel_1.add(lblCentreDintert_1);
		JComboBox<?> comboBox_1 = new JComboBox<Object>(options);
        comboBox_1.setBounds(210, 115, 53, 20);
        panel_1.add(comboBox_1);
        
//////////////////////////////SE CONNECTER//////////////////////////////////////// 
        JButton btnSeConnecter = new JButton("Se Connecter");
        btnSeConnecter.setBounds(131, 151, 114, 33);
        panel_1.add(btnSeConnecter);
        btnSeConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boolean exist2 = false;
            	type = comboBox_1.getSelectedItem().toString();
        		username = textField_1.getText();
            	if(type.equals("IA")) {
            		exist2 = false;	
        			for(int i=0; i<containerIA.usersNoms.size(); i++) {
        				String a = containerIA.usersNoms.get(i);
        				if(textField_1.getText().equals(a)) {
        					exist2 = true;
        					break;
        				}
        			}
        			if (exist2 == false) {
        				label.setText("Cet utilisateur n'est pas inscrit");
        				System.out.println("ce nom est inscrit  ");
        			} else {
	            		ag = ContainerSMA.agentCreator(textField_1.getText(), comboBox_1.getSelectedItem().toString(), containerIA.agentContainer);
	            		
	            		int maxIndex = 0;
	            		int max = containerIA.usersPoints.get(0);
	            		for(int i=1; i<containerIA.usersPoints.size(); i++) {
	            			if(max < containerIA.usersPoints.get(i)) {
	            				max = containerIA.usersPoints.get(i);
	                			maxIndex = i;
	            			}
	            		}
	            		for (int i=0; i < containerIA.usersNoms.size(); i++) {
	            			if(containerIA.usersNoms.get(i).equals(username)) index = i;
	            			else {
	            				if(i == maxIndex) {
	            					text = text + containerIA.usersNoms.get(i) + " (LEADER)\n";
	            				} else 
	            					text = text + containerIA.usersNoms.get(i) + "\n";
	            			}
	            		}
	            		layeredPane.remove(panel_1);
	                	layeredPane.add(panel_2);
	                	layeredPane.updateUI();
            		}
            	} else if(type.equals("SMA")) {
            		exist2 = false;	
        			for(int i=0; i<containerSMA.usersNoms.size(); i++) {
        				String a = containerSMA.usersNoms.get(i);
        				if(textField_1.getText().equals(a)) {
        					exist2 = true;
        					break;
        				}
        			}
        			if (exist2 == false) {
        				label.setText("Cet utilisateur n'est pas inscrit");
        			} else {
	            		ag = ContainerSMA.agentCreator(textField_1.getText(), comboBox_1.getSelectedItem().toString(), containerSMA.agentContainer);
	            		
	            		int maxIndex = 0;
	            		int max = containerSMA.usersPoints.get(0);
	            		for(int i=1; i<containerSMA.usersPoints.size(); i++) {
	            			if(max < containerSMA.usersPoints.get(i)) {
	            				max = containerSMA.usersPoints.get(i);
	                			maxIndex = i;
	            			}
	            		}
	            		for (int i=0; i < containerSMA.usersNoms.size(); i++) {
	            			if(containerSMA.usersNoms.get(i).equals(username)) index = i;
	            			else {
	            				if(i == maxIndex) {
	            					text = text + containerSMA.usersNoms.get(i) + " (LEADER)\n";
	            				} else 
	            					text = text + containerSMA.usersNoms.get(i) + "\n";
	            			}
	            		}
	            		layeredPane.remove(panel_1);
	                	layeredPane.add(panel_2);
	                	layeredPane.updateUI();
        			}
	            }
            	textField.setText("");
            	textField_1.setText("");
                textPane.setText(text);
        		
            }
        });

        

//////////////////////////////PANEL 2//////////////////////////////////////// 
//////////////////////////////CONTACTS////////////////////////////////////////        
        JLabel lblContacts = new JLabel("Contacts");
        lblContacts.setBounds(21, 0, 62, 23);
        panel_2.add(lblContacts);
        panel_2.add(textPane);
        
        
//////////////////////////////DOCS ENVOYES////////////////////////////////////////          
        JLabel lblContacts_1 = new JLabel("Documents envoyés");
        lblContacts_1.setBounds(89, 0, 115, 23);
        panel_2.add(lblContacts_1);
        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBounds(103, 23, 73, 82);
        panel_2.add(textPane_1);
        textPane_1.setText(textPane_1.getText()+filename+"\n");
        
        
//////////////////////////////PARCOURIR////////////////////////////////////////
		JButton btnParcourir = new JButton("Parcourir");
		btnParcourir.setBounds(0, 116, 91, 20);
		panel_2.add(btnParcourir);
		
		JTextPane textPane_2 = new JTextPane();
        textPane_2.setForeground(SystemColor.control);
        textPane_2.setBounds(103, 116, 86, 20);
        textPane_2.setText("");
        panel_2.add(textPane_2);
		
		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
				jfc.setAcceptAllFileFilterUsed(false);
				jfc.addChoosableFileFilter(filter);
				jfc.setDialogTitle("Sellectionnez un document");
				
				int returnValue = jfc.showOpenDialog(null);
			
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					path = jfc.getSelectedFile().getAbsolutePath();
					filename = jfc.getSelectedFile().getName();
					files.add(filename);
					textPane_2.setText(filename);
				}
			}
		});
		
        
//////////////////////////////EVALUATION////////////////////////////////////////
        JLabel lblEvaluation = new JLabel("Evaluation:");
        lblEvaluation.setBounds(10, 147, 69, 14);
        panel_2.add(lblEvaluation);
        JTextField textField_eval;
        textField_eval = new JTextField();
        textField_eval.setBounds(88, 144, 29, 20);
        panel_2.add(textField_eval);
        textField_eval.setColumns(10);
        
        
//////////////////////////////DESCRIPTION////////////////////////////////////////
        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(10, 172, 73, 14);
        panel_2.add(lblDescription);
    	JTextField textField_desc;
        textField_desc = new JTextField();
        textField_desc.setBounds(90, 169, 86, 20);
        panel_2.add(textField_desc);
        textField_desc.setColumns(10);
        
        
//////////////////////////////DESTINATAIRE////////////////////////////////////////
		JLabel lblEvaluation_1 = new JLabel("Destinataire:");
		lblEvaluation_1.setBounds(127, 147, 91, 14);
		panel_2.add(lblEvaluation_1);
		JTextField textField_dest;
		textField_dest = new JTextField();
		textField_dest.setBounds(199, 144, 86, 20);
		panel_2.add(textField_dest);
		textField_dest.setColumns(10);
        
        
//////////////////////////////ENVOYER////////////////////////////////////////
        JButton btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setBounds(199, 168, 96, 23);
        panel_2.add(btnEnvoyer);
        btnEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
    			boolean exist;
    			boolean exist2;
            	if(path != "") {
            		if(type == "IA") {
            			try {
    						exist = false;
                			for(int i=0; i<agentControllers.size(); i++) {
                				String a = agentControllers.get(i).getName().split("@", 2)[0];
                				if(textField_dest.getText().equals(a)) {
                					exist = true;
                					break;
                				}
                			}
    						exist2 = false;
                			for(int i=0; i<containerIA.usersNoms.size(); i++) {
                				String a = containerIA.usersNoms.get(i);
                				if(textField_dest.getText().equals(a)) {
                					exist2 = true;
                					break;
                				}
                			}
                			if(!exist2) {
                				lblNewLabel.setText("Utilisateur");
                				lblNewLabel_1.setText("introuvable");
            				} else {
        						if(!exist) {
        							ag2 = ContainerIA.agentCreator(textField_dest.getText(), comboBox_1.getSelectedItem().toString(), containerIA.agentContainer);
                					agentControllers.add(ag2);
                				}
        						
	        					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
	    		                msg.setContent(path);
	    		                msg.addReceiver(new AID (textField_dest.getText(),AID.ISLOCALNAME));
	    		                IA.send(msg);
	    						ag.start();
	    						
	    						if(!textField_eval.getText().isEmpty()) {
	        						System.out.println(containerIA.usersPoints.get(index));
	                    			int a = containerIA.usersPoints.get(index)+1;
	                    			containerIA.usersPoints.set(index, a);
	                    		}
	    	                	textPane_1.setText(textPane_1.getText()+filename+"\n");
	            			}
    					} catch (StaleProxyException e) {
    						e.printStackTrace();
    					}
                	} else if(type == "SMA") {
    					try {
    						exist = false;
                			for(int i=0; i<agentControllers.size(); i++) {
                				String a = agentControllers.get(i).getName().split("@", 2)[0];
                				if(textField_dest.getText().equals(a)) {
                					exist = true;
                					break;
                				}
                			}
    						exist2 = false;
                			for(int i=0; i<containerSMA.usersNoms.size(); i++) {
                				String a = containerSMA.usersNoms.get(i);
                				if(textField_dest.getText().equals(a)) {
                					exist2 = true;
                					break;
                				}
                			}
                			if(!exist2) {
                				lblNewLabel.setText("Utilisateur");
                				lblNewLabel_1.setText("introuvable");
            				} else {
        						if(!exist) {
        							ag2 = ContainerSMA.agentCreator(textField_dest.getText(), comboBox_1.getSelectedItem().toString(), containerSMA.agentContainer);
                					agentControllers.add(ag2);
                				}
        						
	        					ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
	    		                msg.setContent(path);
	    		                msg.addReceiver(new AID (textField_dest.getText(),AID.ISLOCALNAME));
	    		                SMA.send(msg);
	    						ag.start();
	    						
	    						if(!textField_eval.getText().isEmpty()) {
	        						System.out.println(containerSMA.usersPoints.get(index));
	                    			int a = containerSMA.usersPoints.get(index)+1;
	                    			containerSMA.usersPoints.set(index, a);
	                    		}

	    	                	textPane_1.setText(textPane_1.getText()+filename+"\n");
	            			}
    					} catch (StaleProxyException e) {
    						e.printStackTrace();
    					}
                	}
                }
            	path = "";
            	textField_dest.setText("");
            	filename = "";
            	textPane_2.setText("");
            	textField_eval.setText("");
            }
        });
        
        
//////////////////////////////AIDE////////////////////////////////////////
        JButton btnAide = new JButton("Aide");
        btnAide.setBounds(279, 0, 89, 23);
        panel_2.add(btnAide);
        btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	try {
	        		Desktop.getDesktop().browse(new URI("http://www.google.fr"));
	        	} catch (IOException e1) {
	        		e1.printStackTrace();
	        	} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
        });

        
//////////////////////////////DECONNEXION////////////////////////////////////////
        JButton btnDec = new JButton("Deconnexion");
        btnDec.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				try {
					ag.kill();
				} catch (StaleProxyException e) {
					e.printStackTrace();
				}
				
				for(int i=0; i<agentControllers.size(); i++) {
					try {
						agentControllers.get(i).kill();
						agentControllers.remove(i);
					} catch (StaleProxyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				text = "";
				IA = null;
				SMA = null;
        		
        		layeredPane.remove(panel_2);
            	layeredPane.add(panel_1);
            	layeredPane.updateUI();
        	}
        });
        btnDec.setBounds(368, 0, 29, 23);
        panel_2.add(btnDec);
        
        
//////////////////////////////USELESS////////////////////////////////////////        
		JRadioButton rdbtnEnvoiDunDocument = new JRadioButton("Envoi d'un document");
		rdbtnEnvoiDunDocument.setBounds(224, 23, 167, 23);
		panel_2.add(rdbtnEnvoiDunDocument);
		
		JRadioButton rdbtnDemandeDunDocument = new JRadioButton("Demande d'un document");
		rdbtnDemandeDunDocument.setBounds(224, 49, 167, 23);
		panel_2.add(rdbtnDemandeDunDocument);
		
		JRadioButton rdbtnDemandeDvaluation = new JRadioButton("Demande d'\u00E9valuation");
		rdbtnDemandeDvaluation.setBounds(224, 77, 167, 23);
		panel_2.add(rdbtnDemandeDvaluation);
		
		JButton btnSend = new JButton("Valider");
		btnSend.setForeground(new Color(0, 128, 0));
		btnSend.setBounds(199, 111, 89, 31);
		panel_2.add(btnSend);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(255, 0, 0));
		btnAnnuler.setBounds(290, 111, 89, 31);
		panel_2.add(btnAnnuler);
		
		
		
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);
        pack();
    }

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Inscription();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}