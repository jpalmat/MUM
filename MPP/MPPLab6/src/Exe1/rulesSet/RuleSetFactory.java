package Exe1.rulesSet;

import Exe1.gui.InfoWindow;
import javafx.application.Application;



final public class RuleSetFactory {
	private RuleSetFactory(){}
	
	public static RuleSet getRuleSet(Application c) {
		if(c instanceof InfoWindow) {
			return new InfoRuleSet();
		} 
		return null;
	}
}