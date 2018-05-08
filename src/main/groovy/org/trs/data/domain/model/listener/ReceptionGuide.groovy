package org.trs.data.domain.model.listener

import java.util.concurrent.TimeUnit

import org.trs.data.domain.model.ifs.BaseModel;
import org.trs.data.utils.DateUtils
import org.trs.itf.model.StateExpressionWrapper;

class ReceptionGuide extends BaseModel {

	boolean adminUser
	boolean newUser
	def version="1"
	
	def time=''
	def date=''
	def List<String> hiddenLinks=[]
	
	def binding = [				ReceptionGuide:this	]
	
	public BaseModel setState(StateExpressionWrapper event) {
		lastEvent=event.getName()
		date=DateUtils.getDateAsString("America/Chicago","Mdyyyy")
		time=DateUtils.getApproxDateAsRegex("America/Chicago","hmm",1,TimeUnit.MINUTES)
		def version = event.value('version')
		def hiddenLinks = event.values('hiddenLinks');
		if(event.getName()=~'enterAdmin'){
			
			adminUser=true
		}else if(event.getName()=~'enterNew'){
			newUser=true
		}else if(event.getName()=~'unknown'){
			
		}else{
			newUser=false
			adminUser=false
		}

		return this;
	}

	
	
	@Override
	public Map getViewData() {
		return binding;
	}

	@Override
	public String toString() {
		return "ReceptionGuide";
	}



}
