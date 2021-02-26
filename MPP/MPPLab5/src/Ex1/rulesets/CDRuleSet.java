package Ex1.rulesets;

import java.awt.Component;

import Ex1.gui.CDWindow;



/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	CDWindow cdWindow;
	@Override
	public void applyRules(Component ob) throws RuleException {
		cdWindow = (CDWindow) ob;
		nonempty();
		validatePrice();
	}
	private void validatePrice() throws RuleException {
		if(!cdWindow.getPriceValue().matches("[0-9]*\\.[0-9][0-9]")) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}
		
		Float price = Float.parseFloat(cdWindow.getPriceValue());
		if(price <= 0.49) {
			throw new RuleException("Price must be a number greater than 0.49.");
		}
	}
	private void nonempty() throws RuleException {
		if(cdWindow.getPriceValue().trim().isEmpty() ||
			cdWindow.getArtistValue().trim().isEmpty() ||
			cdWindow.getTitleValue().trim().isEmpty()){
			throw new RuleException("Fields empty");
			}
	}
	
}