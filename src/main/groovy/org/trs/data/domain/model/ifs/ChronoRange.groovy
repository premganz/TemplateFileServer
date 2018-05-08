package org.trs.data.domain.model.ifs

import org.trs.data.domain.model.ifs.BaseModel
import org.trs.data.domain.svc.SessionContext
import org.trs.itf.model.StateExpressionWrapper

class ChronoRange extends BaseModel {
	//repo
	int curY=2017
	int curMNumber=1
	def curMon="MR"
	def startMon="MR"
	


	
	
	def Months_cm_54_Spaces=formatList(generateMonthsDetails(curMon,54,monthFormatter))
	def Months_CurrentMonth_24_Spaces=formatList(generateMonthsDetails(curMon,24,monthFormatter))
	def Months_quarterend_54_Spaces=formatList(generateMonthsDetails(startMon,54,monthFormatter))
	def months_cm_60_Spaces=formatList(generateMonthsDetails(curMon,60,monthFormatter))
	

	def binding = [PeriodListBox:this]
	public ChronoRange(curQ, curMon,endQ){
	
	this.curMon=curMon
	
	}

public ChronoRange(){
	
}
	@Override
	public ChronoRange setState(StateExpressionWrapper event) {
		if(event.getName()=~'readArchive'){
			def curQ=event.value('year')
		
				
				def curMon="JU"
				def endQ="DE"				
				binding=[ChronoSelectArticles:new ChronoRange(curQ,curMon,endQ)]

			}
			
		return this

	}

	@Override
	public Map getViewData() {
		return binding;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 'ChronoSelectArticles '
	}



	/**data generator methods***/



	
	static def monthFormatter = {String month, int year ->
		return month+"-"+year
	}

	
	static class monthWrapper{
		static def months = ['DE','JA','FE','MR','AP','MA','JU','JL','AU','SE','OC','NO','DE']
		static def getPvsM(mon, int yr){
			def qNoIdx = months.findLastIndexOf(0,{String input ->return input.equals(mon)}) -1
			if(qNoIdx==0){
				yr=yr-1
			}
			return [months[qNoIdx],yr]


		}
	}

	

	def generateMonthsDetails(String startMon,  int count, clos){
		def quartList = []
		def addYr=curY
		def addQ = startMon
		quartList.add(clos(addQ,addYr))
		while(count-->0){
			def result = monthWrapper.getPvsM(addQ,addYr)
			addQ= result[0]
			addYr=result[1]
			quartList.add(clos(addQ,addYr))


		}
		return quartList.toString()

	}

	static formatList(list){
		return list.toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll(",", "")
	}



}
