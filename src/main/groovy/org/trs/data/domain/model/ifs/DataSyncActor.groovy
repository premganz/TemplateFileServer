package org.trs.data.domain.model.ifs;
import org.trs.data.domain.svc.SessionContext
import org.trs.itf.model.StateExpressionWrapper

class DataSyncActor extends BaseModel{
	
	//repo
	
	
	def config = [
		version: 'v1',
		articles: getArticleIds(),
		
		
	]
	
	
	
	def activeBinding ;

	
	@Override
	public DataSyncActor setState(StateExpressionWrapper event) {}

	@Override
	public Map getViewData() {
		return activeBinding
		
	}

	
	
	
	
}
