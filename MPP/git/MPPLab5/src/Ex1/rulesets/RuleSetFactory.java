package Ex1.rulesets;

import java.awt.Component;
import java.util.HashMap;

import Ex1.gui.BookWindow;
import Ex1.gui.CDWindow;



final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	{
		map.put(BookWindow.class, new BookRuleSet());
		map.put(CDWindow.class, new CDRuleSet());
	}
	
	public static RuleSet getRuleSet(Component c) {
		if(c instanceof BookWindow) {
			return new BookRuleSet();
		} if (c instanceof CDWindow) {
			return new CDRuleSet();
		}
		return null;
	}
}