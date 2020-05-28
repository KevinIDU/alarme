package interfaceGraphique;

import moniteur.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;	

/**
 * Classe mere des deux moniteurs, héritant des de JFrame(GUI) et des interfaces (listener)
 * Création des différents boutons et fenetres ainsi que les listes dans lesquelles les informations vont être stockées
 */


public class Monitoring extends JFrame implements ListSelectionListener, ActionListener {
	
	
	
		
	JPanel panBout = new JPanel();
	JPanel bouton_listeAlarme = new JPanel();
	JList liste;
	JButton suprimer = new JButton("Suprimer");
	JButton details = new JButton("Details");

	JPanel container = new JPanel();
	Box left = Box.createVerticalBox();
	JScrollPane scroller = new JScrollPane();
	
	ArrayList<String> liste_info = new ArrayList<String>();
	ArrayList<String> liste_string = new ArrayList<String>();
	ArrayList<Boolean> liste_boolean = new ArrayList<Boolean>();
	
	ArrayList<Moniteur> listeMoni = new ArrayList<Moniteur>();
	
	ArrayList<String> Archives = new ArrayList<String>();
	
	
	
	/**
	 * Paramétrage des fenêtres principales
	 * @param title titre de la fenetre que l'on va générer
	 */
	
	public Monitoring(String title) {
		
		suprimer.addActionListener(this);
	    panBout.add(suprimer);
	    left.add(panBout);
	    
		details.addActionListener(this);
	    panBout.add(details);
	    left.add(panBout);
	  
	    
	    container.add(left, BorderLayout.CENTER);
	    
	    
	    this.liste = new JList(liste_info.toArray());
	    this.scroller.add(this.liste);
	    this.scroller.setPreferredSize(new Dimension(300,110));

	    bouton_listeAlarme.add(this.scroller);
	    
	    
		//fenetre
	    this.setTitle(title);
	    this.setSize(450, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocation(600,400);
	    this.setContentPane(container);
	    
	    setVisible(true);

	  
	
		
	}
	
	/**
	 * Paramétrage de la partie informations ( quand on clique sur "détails" )
	 * 
	 * @param info sur l'alarme selectionnée
	 */

	public void addAlarmeInfo(String info) {
		
		this.liste_info.add(info);
		
		this.liste = new JList(liste_info.toArray());
		this.remove(this.bouton_listeAlarme);
		this.scroller.remove(this.liste);
		this.bouton_listeAlarme.remove(this.scroller);
		this.scroller = new JScrollPane(this.liste);
		this.bouton_listeAlarme.add(scroller, BorderLayout.EAST);
		this.add(this.bouton_listeAlarme, BorderLayout.EAST);
		this.bouton_listeAlarme.updateUI();
		JOptionPane Jope = new JOptionPane();
		Jope.showMessageDialog(this, info, "Alarme déclenchée ", JOptionPane.WARNING_MESSAGE);
			
	}
	
	public void addAlarmeString(String string) {
		this.liste_string.add(string);
	}
	public void addBoolean(boolean traite) {
		this.liste_boolean.add(traite);
	}
	
	public void addMoniteur(Moniteur moni) {
		this.listeMoni.add(moni);
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
	
	/**
	 * Lorsque l'utilisateur va appuyer sur le bouton "suprimer", la méthode va retirer tous les événements correspondant à l'alarme des différentes listes.
	 * <p>
	 *Si l'utilisateur n'a pas encore visualisé les détails, le programme refusera de supprimer le message.
	 *Lorsque l'utilisateur va appuyer sur le bouton "détails", une fenetre va s'ouvrir et afficher toutes les informations sur l'alarme séléctionnée.
	 * @param e l'action "appuyer sur le bouton"
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Suprimer"))
		{
		
			int index = this.liste.getSelectedIndex();
			if(this.liste_boolean.get(index) == true) {
				
		
					if(index >= 0) {
						this.liste_info.remove(index);
						this.liste_string.remove(index);
						this.liste_boolean.remove(index);
						this.scroller.remove(this.liste);
						this.bouton_listeAlarme.remove(this.scroller);
						this.bouton_listeAlarme.remove(this.liste);
						this.liste = new JList(liste_info.toArray());
						this.remove(this.bouton_listeAlarme);
						this.scroller = new JScrollPane(this.liste);
						this.bouton_listeAlarme.add(scroller, BorderLayout.EAST);
						this.add(this.bouton_listeAlarme, BorderLayout.EAST);
						
						
						
					}
			}else {
				JOptionPane Jope = new JOptionPane();
				Jope.showMessageDialog(this, "Veuillez visualiser les details avant de supprimer l'alarme ","ATTENTION", JOptionPane.WARNING_MESSAGE);
			}
			
			this.bouton_listeAlarme.updateUI();
		}
		
		if(e.getActionCommand().contentEquals("Details"))
		{
			int index = this.liste.getSelectedIndex();
			if(index >= 0) {
				this.liste_boolean.set(index, true);
				JOptionPane Jope = new JOptionPane();
				Jope.showMessageDialog(this, this.liste_string.get(index), "Information sur l'alarme ", JOptionPane.WARNING_MESSAGE);
			}
		}

	}


}


	

