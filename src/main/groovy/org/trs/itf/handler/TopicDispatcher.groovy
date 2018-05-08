package org.trs.itf.handler



import org.trs.data.domain.svc.SessionContext
import org.trs.data.handler.CachedPageHandler
import org.trs.data.handler.DataRequestHandler
import org.trs.data.handler.EventHandler
import org.trs.data.handler.GeneralPageHandler





class TopicDispatcher {
	static CachedPageHandler cachedPageHandler = new CachedPageHandler()
	static GeneralPageHandler pageHandler = new GeneralPageHandler()
	static EventHandler eventHandler = new EventHandler()
	static DataRequestHandler dataRequestHandler = new DataRequestHandler()
	public static  String handle(String topic, String identifier, String payload){
		if (topic.equals("event") && identifier.equals("init/init&")){
			SessionContext.init("Nightly&")//Default
			return ""
		}else if(SessionContext.getApp()!=null && !SessionContext.getApp().initialized){
		SessionContext.init("Nightly&")
			//return "UNINITATILIZED CONTEXT"
		}
		if (topic.equals("pages")){
			return pageHandler.resolvePage(identifier)
		}else if (topic.equals("pagesCachedRead")){
			return cachedPageHandler.resolveCachedPage(identifier)
		}else if (topic.equals("pagesCachedWrite")){
			return cachedPageHandler.writeCachedPage(identifier, payload)
		}else if (topic.equals("event")){
			return eventHandler.propogateEvent(identifier, payload)
		}else if (topic.equals("datasync")){
			return dataRequestHandler.getData(identifier, payload)
		}else{
			return "";
		}
	}

}



