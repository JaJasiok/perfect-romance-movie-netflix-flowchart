package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	        	        	            
            kSession.fireAllRules();
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static final class DecisionTreeForm {
    	
    	private JFrame frame;
    	
    	String result = "";
    	
		public DecisionTreeForm() {
	    	frame = new JFrame("Movies");
	    	frame.setLayout(new BorderLayout());
	    	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    	
	    	frame.setLocationRelativeTo(null);
	    	frame.setVisible(true);
	    }
		
		public String addContent(String question, String[] options) {
			SwingUtilities.updateComponentTreeUI(frame);
			while(result == "") {
				JLabel label = new JLabel(question);
				
				ButtonGroup buttonGroup = new ButtonGroup();
		    	
		        JPanel panel = new JPanel();
		        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
		    	panel.add(label);	    	
	
		    	for(String s: options) {
		    		JRadioButton button = new JRadioButton(s);
			    	buttonGroup.add(button);
			    	button.addActionListener(new ActionListener() {
			    		@Override
			    		public void actionPerformed(ActionEvent e) {
			    			result = ((JRadioButton) e.getSource()).getText();
			    			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			    		}
			    	});
			    	panel.add(button);
		    	}			
				frame.add(panel);
				frame.pack();
			}
			return result;
		}
    	
//    	public static void createFrame(State state) {
//	    	JFrame frame = new JFrame("Movies");
//	    	frame.setLayout(new BorderLayout());
//	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    	
//	    	JLabel label = new JLabel(state.getQuestion);
//	    	
//	    	ButtonGroup buttonGroup = new ButtonGroup();
//	    	
//	        JPanel panel = new JPanel();
//	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//	    	panel.add(label);	    	
//
//	    	
//	    	for(String s: state.getOptions) {
//	    		JRadioButton button = new JRadioButton(s);
//		    	buttonGroup.add(button);
//		    	button.addActionListener(new ActionListener() {
//		    		@Override
//		    		public void actionPerformed(ActionEvent e) {
//		    			state.setAnswer(((JButton) e.getSource()).getText());
//		    			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//		    			}
//		    		}
//		    	);
//		    	panel.add(button);
//
//	    	}
//	        
//	    	frame.add(panel);
//	    	
//	    	frame.pack();
//	    	frame.setLocationRelativeTo(null);
//	    	frame.setVisible(true);
//    	}
//    	
//    	public static void generateContent() {
//    		
//    	}
//    	
//    }
    
    }

}
