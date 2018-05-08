package org.trs.data.domain.model.ifs

import org.trs.data.domain.model.listener.ReceptionGuide
import org.trs.itf.model.StateExpressionWrapper

class AppModel extends BaseModel{
	boolean initialized
	
	MenuLabels menuLabels;
	ChronoRange chronoRange;
	String baseLookupDir;
	BaseModel modelToReturn
	
	
	//Actors
	
	 
	 ReceptionGuide receptionGuide
	@Override
	public BaseModel setState(StateExpressionWrapper event) {
		// TODO Auto-generated method stub
		return null;
	}

	public AppModel(String exp){
		
			
	}
	@Override
	public Map getViewData() {
		//	Properties members = this.getMetaClass().getProperties()
		//	while (this.MetaClass getMetaClass().getPro)
		//	}
		return menuLabels.getViewData()+receptionGuide.getViewData()+chronoRange.getViewData()
	
	}
	
	@Override
	public String toString() {
	
		return "AppModel "+ lastEvent+" binding "+'\n'
	}
}
