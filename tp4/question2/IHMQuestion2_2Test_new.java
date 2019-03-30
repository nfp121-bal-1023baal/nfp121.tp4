package question2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class IHMQuestion2_2Test_new extends junit.framework.TestCase{
    private question2.IHMQuestion2_2 ihm;
    private Robot robot;

    protected void setUp() throws java.lang.Exception{
        ihm = new question2.IHMQuestion2_2();
        while(!(ihm.isShowing())){}
        ihm.setAlwaysOnTop(true);
        ihm.setLocation(100, 500);
        this.robot = new Robot();
    }

    protected void tearDown(){ // throws java.lang.Exception
        ihm.dispose();
    }

    public void test_IHMConforme() throws Exception{ // juste le bon IHM
        Container panel = ihm.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface", components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[2] instanceof JButton);
    }

    public void test_clic_bouton_A() throws Exception{
        Container panel = ihm.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface", components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[2] instanceof JButton);

        JButton bouton_A = ((JButton)subComponents[0]);
        bouton_A.doClick(200);
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Clic sur le bouton A, 3 lignes sont attendues !!!", st.countTokens()==3);

    }

    public void test_clic_bouton_B() throws Exception{
        Container panel = ihm.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface", components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[2] instanceof JButton);

        JButton bouton_B = ((JButton)subComponents[1]);
        bouton_B.doClick();
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Clic sur le bouton B, 2 lignes sont attendues !!!", st.countTokens()==2);

    }

    public void test_clic_bouton_C() throws Exception{
        Container panel = ihm.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface", components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[2] instanceof JButton);

        JButton bouton_C = ((JButton)subComponents[2]);
        bouton_C.doClick();
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Clic sur le bouton B, 1 ligne est attendue !!!", st.countTokens()==1);
    }

    public void test_deplacement_souris_vers_A() throws Exception{
        try{tearDown();

            Container panel = ihm.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

            // la bonne IHM
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

            Component[] subComponents = ((JPanel)components[0]).getComponents();
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

            Point location = subComponents[0].getLocationOnScreen();
            robot.mouseMove(location.x+(subComponents[0].getWidth()/2),location.y+(subComponents[0].getHeight()/2));
            robot.delay(800);
            TextArea sortie = (TextArea)components[1];
            StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
            assertTrue(" avec JMouseObserver(Bouton A) 1 ligne est attendue !",st.countTokens()==1);
        }catch(Exception e){

        }

    }

    public void test_deplacement_souris_vers_B() throws Exception{
        try{
                tearDown(); // beurk
     
      
                Container panel = ihm.getContentPane();
                Component[] components = panel.getComponents();
        
        assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);
        
        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
      assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);


        Point location = subComponents[1].getLocationOnScreen();
        

        robot.mouseMove(location.x+(subComponents[1].getWidth()/2),location.y+(subComponents[1].getHeight()/2));
        robot.delay(100);
    TextArea sortie = (TextArea)components[1];
    StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
    assertTrue(" avec JMouseObserver pour ce test 1 ligne est attendue !",st.countTokens()==1);
    }catch(Exception e){
      
    }

    }

    public void test_deplacement_souris_vers_C() throws Exception{
        try{ tearDown();

            Container panel = ihm.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

            // la bonne IHM
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

            Component[] subComponents = ((JPanel)components[0]).getComponents();
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

            Point location = subComponents[2].getLocationOnScreen();
            robot.mouseMove(location.x+(subComponents[2].getWidth()/2),location.y+(subComponents[2].getHeight()/2));
             robot.delay(800);
            TextArea sortie = (TextArea)components[1];

            StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
            assertTrue(" avec JMouseObserver(Bouton C) 1 ligne est attendue !",st.countTokens()==1);
        }catch(Exception e){

        }

    }

    public void test_deplacement_vers_A_et_clic() throws Exception{
        try{tearDown();

            Container panel = ihm.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

            // la bonne IHM
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

            Component[] subComponents = ((JPanel)components[0]).getComponents();
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

            Point location = subComponents[0].getLocationOnScreen();
            robot.mouseMove(location.x+(subComponents[0].getWidth()/2),location.y+(subComponents[0].getHeight()/2));
            robot.delay(800);
            JButton bouton_A = ((JButton)subComponents[0]);
            bouton_A.doClick();

            TextArea sortie = (TextArea)components[1];
            StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
            assertTrue(" Deplacement + clic sur A, 4 lignes sont attendues !",st.countTokens()==4);
        }catch(Exception e){

        }

    }

    public void test_deplacement_vers_B_et_Clic() throws Exception{
        try{tearDown();

            Container panel = ihm.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

            // la bonne IHM
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

            Component[] subComponents = ((JPanel)components[0]).getComponents();
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

            Point location = subComponents[1].getLocationOnScreen();
            robot.mouseMove(location.x+(subComponents[0].getWidth()/2),location.y+(subComponents[0].getHeight()/2));
            robot.delay(800);
            JButton bouton_B = ((JButton)subComponents[1]);
            bouton_B.doClick();
 
            
            TextArea sortie = (TextArea)components[1];
            StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
            assertTrue(" Deplacement + clic sur B, 3 lignes sont attendues !",st.countTokens()==3);
        }catch(Exception e){

        }

    }

    public void test_deplacement_vers_C_et_clic() throws Exception{
        try{tearDown();

            Container panel = ihm.getContentPane();
            Component[] components = panel.getComponents();
            assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

            // la bonne IHM
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

            Component[] subComponents = ((JPanel)components[0]).getComponents();
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
            assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

            Point location = subComponents[2].getLocationOnScreen();
            robot.mouseMove(location.x+(subComponents[0].getWidth()/2),location.y+(subComponents[0].getHeight()/2));
            robot.delay(800);
            JButton bouton_C = ((JButton)subComponents[2]);
            bouton_C.doClick();

            TextArea sortie = (TextArea)components[1];
            StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
            assertTrue(" Deplacement + clic sur C, 2 lignes sont attendues !",st.countTokens()==2);
        }catch(Exception e){

        }

    }

}
