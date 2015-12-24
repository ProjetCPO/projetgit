package FileActions;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modeles.Soutenance;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Outils.ApplicationSession;

public class Sauvegarde {

	public Sauvegarde(){}
	
	public void save(Soutenance soutenances[][], java.io.File xmlfile) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ; 
		try {
			DocumentBuilder builder = factory.newDocumentBuilder() ; 
			Document document = builder.newDocument() ; 
			Element root = document.createElement("agenda") ; 
			Comment comment = document.createComment("Commentaire") ; 
			root.appendChild(comment) ; 
			
			
			for(int j = 0 ; j < 5 ; ++j) {
				for (int i = 0 ; i < 22 ; ++i) {
					if (soutenances[i][j] != null) {
						Element schedule = document.createElement("Schedule") ; 
						schedule.setAttribute("date", soutenances[i][j].getDateSout().toString().substring(0, 19) + soutenances[i][j].getDateSout().toString().substring(soutenances[i][j].getDateSout().toString().length()-5, soutenances[i][j].getDateSout().toString().length())) ; 
						Element defense = document.createElement("Defense") ; 
						defense.setAttribute("studentlastname", soutenances[i][j].getEtudiant().getNom()) ; 
						defense.setAttribute("studentfirstname", soutenances[i][j].getEtudiant().getPrenom()) ; 
						defense.setAttribute("classroom", soutenances[i][j].getSalleSout().getNom()) ; 
						defense.setAttribute("juries", "" + soutenances[i][j].getJury().size()) ; 
						defense.setAttribute("documents", "" + soutenances[i][j].getDocuments().size()) ; 
						schedule.appendChild(defense) ; 
						root.appendChild(schedule) ; 
					}
				}
			}
			
			
			document.appendChild(root) ; 
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance() ; 
			try {
				Transformer transformer = transformerFactory.newTransformer() ; 
				DOMSource source = new DOMSource(document) ; 
				StreamResult output = new StreamResult(xmlfile) ; 
				transformer.setOutputProperty(OutputKeys.INDENT,"yes") ; 
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2") ; 
				transformer.transform(source,output); 
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("saveSuccess"), ApplicationSession.instance().getString("save"), JOptionPane.INFORMATION_MESSAGE);
	}
}
