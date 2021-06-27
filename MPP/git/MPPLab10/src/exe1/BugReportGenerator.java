package exe1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;


/**
 * This class scans the package lesson10.labs.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "exe1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		
		//sample code for reading annotations -- you will need to change
		//this quite a bit to solve the problem
		//Sample code below obtains a list of names of developers assigned to bugs
		List<String> names = new ArrayList<String>();
		Map<String, List<String>> report = new HashMap<String, List<String>>();
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				String name = annotation.assignedTo();
				if(report.containsKey(name)) {
					report.get(name).addAll(getAnnotationData(annotation));
				} else {
					report.put(name, getAnnotationData(annotation));
				}
			}
		}
		System.out.println(printMap(report));
		
	}
	private String printMap(Map<String, List<String>> report) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, List<String>> entry : report.entrySet()) {
			sb.append(entry.getKey()).append("\n");
			sb.append(printList(entry.getValue()));
	    }
		return sb.toString();
	}
	private String printList(List<String> values) {
		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append("\t").append(value).append("\n");
		}
		return sb.toString();
	}
	private List<String> getAnnotationData(BugReport annotation) {
		List<String> list = new ArrayList<String>();
		list.add(REPORTED_BY+ annotation.reportedBy());
		list.add(DESCRIPTION+ annotation.description());
		list.add(SEVERITY+ String.valueOf(annotation.severity()));
		list.add("");
		return list;
	}
	
	
}
