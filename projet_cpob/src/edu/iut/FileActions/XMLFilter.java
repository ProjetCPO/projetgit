package edu.iut.FileActions;

import java.io.File;

import javax.swing.filechooser.FileFilter;


public class XMLFilter extends FileFilter {

	private static String suffixe = "xml" ; 
	private String description = "Fichier XML (*.xml)" ; 
	
	public XMLFilter(){}
	
	boolean appartient(String suffixe) {
		if(suffixe.equals(XMLFilter.suffixe))
			return true;
		return false;
	}
	
	public boolean accept(File f) {
		if (f.isDirectory()) return true ; 
		String suffixe = null ; 
		String s = f.getName() ; 
		int i = s.lastIndexOf('.') ; 
		if(i > 0 &&  i < s.length() - 1)
			suffixe = s.substring(i+1).toLowerCase() ; 
		return suffixe != null && appartient(suffixe) ; 
	}
	
	// la description du filtre
	public String getDescription() {
		return description ; 
	}
	
}
