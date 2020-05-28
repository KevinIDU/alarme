package interfaceGraphique;

import event.*;
import source.*;
import moniteur.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe créant la fenetre que nous avons appelé "simulation", c'est la fenetre centrale qui permet de créer nos alarmes avant qu'elles ne soient envoyées vers les moniteurs.
 * <p>
 * Elle hérite de la classe JFrame ainsi que de l'interface ActionListener
 */

public class Simulation extends JFrame implements ActionListener{
	
	  protected JPanel container = new JPanel();
	  protected Box left = Box.createVerticalBox();
	  
	  
	  protected JLabel labelMoni = new JLabel("Moniteur :") ;
	  protected JComboBox comboMoni = new JComboBox();
	  
    
	  protected JLabel labelBat = new JLabel("Batiment :");
	  protected JComboBox comboBat = new JComboBox();
	  

	  
	  protected JLabel labelType = new JLabel("Type d'alarme :") ;
	  protected JComboBox comboType = new JComboBox();
	  
	  
	  protected JLabel labelNiveau = new JLabel("Niveau d'importance :") ;
	  protected JComboBox comboNiveau = new JComboBox();
	  
	 
	  protected JPanel spe = new JPanel();
	  protected JLabel labelSpe = new JLabel(" ");
	  protected JTextField speField = new JTextField("",10);
	  
	  protected JButton bouton = new JButton("Simuler");
	  
	  protected Monitoring monitors;
	  protected Monitoring sauvegarde;
	  
	  JPanel moniteur = new JPanel();
	  JPanel batiment = new JPanel();
	  JPanel type = new JPanel();
	
	  JPanel niveau = new JPanel();
	
	  JPanel panBout = new JPanel();
	  
	
	  public Simulation() {
			 
			//fenetre
		    this.setTitle("Simulateur alarme");
		    this.setSize(400, 250);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);

		    
		    //batiment
		    comboBat.setPreferredSize(new Dimension(1000, 20));
		    String[] tabBat = {"C203", "C204", "C205", "C206"}; // recuperer liste batiments
		    comboBat = new JComboBox(tabBat);
		    batiment.add(labelBat);
		    batiment.add(comboBat);
		    
		    //type alarme
		    comboType.setPreferredSize(new Dimension(100, 20));
		    String[] tabType = {"Incendie", "Gaz", "Radiation"};
		    comboType = new JComboBox(tabType);
		    type.add(labelType);
		    type.add(comboType);
		    

		    
		    
		    //Niveau importance
		    comboNiveau.setPreferredSize(new Dimension(100, 20));
		    String[] tabNiveau = {"1", "2", "3"};
		    comboNiveau = new JComboBox(tabNiveau);
		    niveau.add(labelNiveau);
		    niveau.add(comboNiveau);
		    
		    //bouton valider
		    panBout.add(bouton);
		    
		    
		    bouton.addActionListener(this);
		    comboType.addActionListener(this);
		    
		    
		    
		  //affichage
		    
		    left.add(batiment);
		    left.add(type);
		   
		    left.add(niveau);
		    
		    
		    left.add(panBout);
		    container.add(left, BorderLayout.CENTER);
		    this.setContentPane(container);
		    this.setVisible(true);        
		    
		  }
	  
	  /**
		 * Indique les actions a effectuer pour chaque action que peut réaliser l'utilisateur avec les menus.
		 * <p>
		 *On spécifie également dans quel moniteur envoyer l'alarme en fonction du type de cette dernière.
		 *Moniteur A: Incendie et Gaz
		 *Moniteur B: Radiations et Gaz
		 * @param e l'action "appuyer sur le bouton"
		 */

	  @Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().toString() == "comboBoxChanged") {
		    	Integer getBat = (Integer) comboBat.getSelectedIndex();
		    	String getType = (String)comboType.getSelectedItem();
		    	
		    	Integer getNiveau = (Integer)comboNiveau.getSelectedIndex();
		
		 
		    	    if(getType.equals("Gaz")) {
		    	    	left.removeAll();
		    			labelSpe.setText("Type de gaz :");
		    			spe.add(labelSpe);
		    			spe.add(speField);
		    			left.add(batiment);
		    			left.add(type);
		    			left.add(niveau);
		    			left.add(spe);
		    			left.add(panBout);
		    			
		    			container.updateUI();
		    	    }else if(getType.equals("Radiation")) {
		    	    	left.removeAll();
		    	    	labelSpe.setText("Niveau de radiation :");
		    	    	spe.add(labelSpe);
		    	    	spe.add(speField);
		    	    	left.add(batiment);
		    		    left.add(type);
		    		    left.add(niveau);
		    	    	left.add(spe);
		    		    left.add(panBout);
		    	    	
		    	    	container.updateUI();
		    	    } 
		    	    else {
		    	    		
		    	    	left.removeAll();
		    	    	left.add(batiment);
		    		    left.add(type);
		    		    left.add(niveau);
		    		    left.add(panBout);
		    		    
		    	    	container.updateUI();
		    	    }
		    	}else {
		    		String getType = (String)comboType.getSelectedItem();
		    	    if(getType.equals("Gaz")) {
		    	    	SourceGaz sg = new SourceGaz();
		    	        Moniteur ecologie = new Moniteur("B");	
		    	        sg.addGazListener(ecologie);
		    	        GazEvent ge = sg.generateGazEvent(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),comboBat.getSelectedItem().toString(),speField.getText().toString());
		    	        this.monitors.addAlarmeInfo(ge.toInfo());
		    	        this.monitors.addAlarmeString(ge.toString());
		    	        this.monitors.addBoolean(ge.toTraite());
		    	        this.sauvegarde.addAlarmeInfo(ge.toInfo());
		    	        this.sauvegarde.addAlarmeString(ge.toString());
		    	        this.sauvegarde.addBoolean(ge.toTraite());
		    	        
		    	    }else if(getType.equals("Radiation")) {
		    	    	SourceRadiation rad = new SourceRadiation();
		    	        Moniteur ecologie = new Moniteur("B");	
		    	        rad.addRadiationListener(ecologie);
		    	        if(Integer.parseInt(speField.getText().toString()) >= 0 && Integer.parseInt(speField.getText().toString()) <= 100) {
		    	        	RadiationEvent re = rad.generateRadiationEvent(java.time.LocalDateTime.now(), Integer.parseInt(comboNiveau.getSelectedItem().toString()), Integer.parseInt(speField.getText().toString()),comboBat.getSelectedItem().toString());
		    	        	this.monitors.addAlarmeInfo(re.toInfo());
		    	        	this.monitors.addAlarmeString(re.toString());
		    	        	this.monitors.addBoolean(re.toTraite());
		    	        }else {
		    	        	JOptionPane.showMessageDialog(this,
		    	        		  	"Les radiations doivent être comprises entre 0 et 100 !",
		    	        		    "Erreur sur la valeur",
		    	        		    JOptionPane.ERROR_MESSAGE);
		    	        }
		    	        
		    	        
		    	    }else {
		    	    	SourceIncendie feu = new SourceIncendie();
		    	        Moniteur pompier = new Moniteur("A");	
		    	        feu.addIncendieListener(pompier);
		    	        IncendieEvent ie = feu.generateIncendieEvent( comboBat.getSelectedItem().toString(), Integer.parseInt(comboNiveau.getSelectedItem().toString()),java.time.LocalDateTime.now());
		    	        this.sauvegarde.addAlarmeInfo(ie.toInfo());
		    	        this.sauvegarde.addAlarmeString(ie.toString());
		    	        this.sauvegarde.addBoolean(ie.toTraite());
		    	}
		    }
	  }
	  public void addA(Monitoring mon) {
		  this.monitors = mon;	
		  }
	public void addB(Monitoring sauv) {
		 this.sauvegarde = sauv;	
		  }

		 }





