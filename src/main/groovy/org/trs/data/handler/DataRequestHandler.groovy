package org.trs.data.handler

import groovy.json.JsonBuilder

import org.trs.data.domain.model.ifs.DataSyncActor
import org.trs.data.domain.svc.SessionContext




class DataRequestHandler {
	
	
	

	def getData(String requestToken, String meta){
		if(requestToken.isEmpty()){
			DataSyncActor stateConfig = SessionContext.getApp().dataSyncActor
			def var=stateConfig.getViewData()
			def out= new JsonBuilder( var ).toPrettyString()
			println out
			return out
		}
		DataSyncActor stateConfig = new DataSyncActor()
		def var=stateConfig.getViewData[requestToken]
		def out= new JsonBuilder( var ).toPrettyString()
		println out
		return out
	}

	def getDataMap(){

		DataSyncActor stateConfig = new DataSyncActor()
		Map var=stateConfig.getViewData()
		def out= new JsonBuilder( var ).toPrettyString()
		println out
		return out
	}

}
