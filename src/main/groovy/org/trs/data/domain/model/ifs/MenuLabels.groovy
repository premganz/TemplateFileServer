package org.trs.data.domain.model.ifs

import org.trs.data.view.model.PresentationFormatter;
import org.trs.itf.model.StateExpressionWrapper;

class MenuLabels extends BaseModel {
	//Data repo
	def MainMenuLabels =
	['Access Articles on AI', 'Links to Interesting Blog posts (external)', 'Analytical Software']
	
	def MainMenuLabelsv2=	['Test']
	
	def formatClosure = PresentationFormatter.simpleAppendFormatter
	
	//configuration
	def ActiveLabels;
	
	public MenuLabels setState(StateExpressionWrapper event){
		if(event.getName().equals("v2")){
			activeLabels=MainMenuLabels
		}else{
			activeLabels=MainMenuLabelsv2
		}
		return this;
	}
	
		
	public Map getViewData(){
		def labelDetails = [
			optionNames : activeLabels,
			formatSimple: formatClosure
	
		]
	
		return labelDetails;
	}
	
	
	


}
