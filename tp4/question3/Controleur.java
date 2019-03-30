
package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;
     

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                   Controleur.this.push(); /* null est à remplacer */}});
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        
        boutons.add(push);  push.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                   Controleur.this.push(); /* null est à remplacer */ }});
        
        boutons.add(add);   add.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){ 
                     Controleur.this.add();/* null est à remplacer */}});
        
        boutons.add(sub);   sub.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){ 
                     Controleur.this.sub();/* null est à remplacer */}});
        
        boutons.add(mul);   mul.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){ 
                     Controleur.this.mul();/* null est à remplacer */}});
        
        boutons.add(div);   div.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                     Controleur.this.div();/* null est à remplacer */}});
        
        boutons.add(clear); clear.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                     Controleur.this.clear();/* null est à remplacer */}});
        
        add(boutons);
        
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        // à compléter
         if(pile.estVide()){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(false);
          push.setEnabled(true);
       }
       else if(pile.taille()== 1){
          add.setEnabled(false);
          sub.setEnabled(false);
          mul.setEnabled(false);
          div.setEnabled(false);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.taille()> 1 && !pile.estPleine()){
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
          push.setEnabled(true);
        }
        else if(pile.estPleine()) {
          push.setEnabled(false);
          add.setEnabled(true);
          sub.setEnabled(true);
          mul.setEnabled(true);
          div.setEnabled(true);
          clear.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText()); 
        
    }

    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)
     public void push(){
        try{
            this.pile.empiler(operande());
            donnee.setText("");
        }catch(Exception e){}
        
        this.actualiserInterface();
    }
    
     public void add(){
        try{
            this.pile.empiler(this.pile.depiler() + this.pile.depiler());
        }catch(Exception e){}
        this.actualiserInterface();
        
    }
    
    
     public void sub(){
        try{
            int obj1 = this.pile.depiler();
            int obj2 =this.pile.depiler();
            this.pile.empiler(obj2 - obj1);
            
        }catch(Exception e){}
        
        this.actualiserInterface();
    }
    
    
      public void mul(){
        try{
            this.pile.empiler(this.pile.depiler() * this.pile.depiler());
        }catch(Exception e){}
        
        this.actualiserInterface();
    }
    
    
      public void div(){
        try{
            int elem1 = this.pile.depiler();
            if(elem1 != 0){
               int elem2 = this.pile.depiler();
                this.pile.empiler(elem2 / elem1);
            }
            if(elem1 == 0){}
        }catch(Exception e){ }
        this.actualiserInterface();
    }
    
    
     public void clear(){
        for(int i = this.pile.taille(); i >=0 ; i--){
            try{
                this.pile.depiler();
            }catch(Exception e){}
        }
        this.actualiserInterface();
    }
    

}
