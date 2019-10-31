package org.trs.itf.handler



/**NOTES- USAGE EXAMPLES OF TEMPLATE
 * ===================================
 * LAMBDA1 :Templating by modifying lists at runtime can be used as
 * =============
 * <%print XXListActor.getPopList( {java.util.ArrayList a->a.addAll(['a','b','c'])})%>
 * <%pops = XXListActor.getMdfLabels('pips_shortForm2_crossqtrs', {String a->a.replaceAll('A','B').replaceAll('C','D').replaceAll('CM','')})%>
 *LAMBDA2 : all elements in list
 *========
 *${ format << physicianNames}
 *
 * CONDITIONALS
 * =========
 *
 * <%if(XXFilterActor.filter.type=="IOP")
 *
 * ASSIGNMENTS
 * =========
 *
 * <%m= CEWActor%>
 *
 * LOOPS
 * ====
 * <%for (e in XXFilterActor.filteredXXs) print 'DRAFTOneofeach'+e.eoc_id+'.*?'+e.filter.recordStatus+e.filter.approvalStatus+'***expr***' %>
 *
 */



class MainProxy {
public static void main(String[] args) throws Exception {
	GroovyListener listener = new GroovyListener();
	
listener.start();
	
	
	
}
}
