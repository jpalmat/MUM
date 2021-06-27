package Exe1.rulesSet;


import Exe1.gui.InfoWindow;
import javafx.application.Application;



/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class InfoRuleSet implements RuleSet {

	InfoWindow infoWindow;
	@Override
	public void applyRules(Application ob) throws RuleException {
		infoWindow = (InfoWindow) ob;
		nonempty();
		//validatePrice();
	}
//	private void validatePrice() throws RuleException {
//		if(!cdWindow.getPriceValue().matches("[0-9]*\\.[0-9][0-9]")) {
//			throw new RuleException("Price must be a floating point number with two decimal places");
//		}
//		
//		Float price = Float.parseFloat(cdWindow.getPriceValue());
//		if(price <= 0.49) {
//			throw new RuleException("Price must be a number greater than 0.49.");
//		}
//	}
	private void nonempty() throws RuleException {
		if(infoWindow.getNameTxt().getText().isEmpty() ||
				infoWindow.getStreetTxt().getText().isEmpty() ||
				infoWindow.getCityTxt().getText().isEmpty() ||
				infoWindow.getStateTxt().getText().isEmpty() ||
				infoWindow.getZipTxt().getText().isEmpty()){
			throw new RuleException("Fields empty");
			}
	}
	
}