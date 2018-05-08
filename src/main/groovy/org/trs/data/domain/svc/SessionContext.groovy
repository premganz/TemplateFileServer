package org.trs.data.domain.svc


import org.trs.data.domain.model.ifs.AppModel
import org.trs.data.domain.model.ifs.ChronoRange
import org.trs.data.domain.model.ifs.MenuLabels
import org.trs.data.domain.model.listener.ReceptionGuide
import org.trs.itf.model.StateExpressionWrapper

class SessionContext  {

	static AppModel app = new AppModel("Daily&");

	public static init(String name){
		app= new AppModel()
		app.initialized=true
		StateExpressionWrapper defWrap = new StateExpressionWrapper(name)
		app.receptionGuide = new ReceptionGuide().setState(defWrap);
		app.chronoRange=new ChronoRange().setState(defWrap)
		app.menuLabels=new MenuLabels().setState(defWrap)
		
	}



}
