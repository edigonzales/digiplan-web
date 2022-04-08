package ch.so.arp.digiplanweb.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.so.arp.digiplanweb.model.Dokument;
import ch.so.arp.digiplanweb.model.DokumentTyp;
import ch.so.arp.digiplanweb.model.Gemeinde;
import ch.so.arp.digiplanweb.repository.DokumentRepository;
import ch.so.arp.digiplanweb.repository.DokumentTypRepository;
import ch.so.arp.digiplanweb.repository.GemeindeRepository;

@Named
@RequestScoped
public class HelloWorldBacking {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GemeindeRepository gemeindeRepository;

    @Autowired
    DokumentTypRepository dokumentTypRepository;

    @Autowired
    DokumentRepository dokumentRepository;

    private String firstName = "John";
    private String lastName = "Doe";
    private String txt2;
    
    private String selectedMunicipality;

    private String selectedDocumentType;

    private LinkedList<Dokument> documents;
    
    @PostConstruct
    public void init() {
        // Damit beim ersten Aufruf die Dokumente gelistet werden.
        //products = service.getProducts(10);
    }
       
    public String getSelectedDocumentType() {
        return selectedDocumentType;
    }

    public void setSelectedDocumentType(String selectedDocumentType) {
        this.selectedDocumentType = selectedDocumentType;
    }

    public String getSelectedMunicipality() {
        return selectedMunicipality;
    }

    public void setSelectedMunicipality(String selectedMunicipality) {
        this.selectedMunicipality = selectedMunicipality;
    }
    
    public LinkedList<Dokument> getDocuments() {
        System.out.println("FOOOO");
        if (documents != null) {
            System.out.println(documents.size());            
        }
        return documents;
    }

    public void setDocuments(LinkedList<Dokument> documents) {
        this.documents = documents;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        return "Hello " + firstName + " " + lastName + "!";
    }
    
    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        logger.info("set txt2");
        this.txt2 = txt2;
    }
    
    public List<String> completeText(String query) {
        logger.info("Query: " + query);
        String queryLowerCase = query.toLowerCase();
        List<String> dokumentTypList = new ArrayList<>();
        List<DokumentTyp> dokumentTypen = dokumentTypRepository.findAll();
        for (DokumentTyp dokumentTyp : dokumentTypen) {
            dokumentTypList.add(dokumentTyp.dispName());
        }

        return dokumentTypList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    
    public LinkedList<String> getMunicipalities() {
        LinkedList<String> gemeinden = new LinkedList<>();
        List<Gemeinde> gemeindeList = gemeindeRepository.findAll();
        for (Gemeinde gemeinde : gemeindeList) {
            gemeinden.add(gemeinde.name());
        }
        return gemeinden;
    }
    
    public LinkedHashMap<String, String> getDocumentTypes() {
        LinkedHashMap<String, String> dokumentTypMap = new LinkedHashMap<>();
        List<DokumentTyp> dokumentTypen = dokumentTypRepository.findAll();
        for (DokumentTyp dokumentTyp : dokumentTypen) {
            dokumentTypMap.put(dokumentTyp.ilicode(), dokumentTyp.dispName());
        }

        return dokumentTypMap;
    }
    
    public void submit() {
        System.out.println("selectedMunicipality:" + selectedMunicipality + "**");
        System.out.println("selectedDocumentType:" + selectedDocumentType + "**");
        
        
        documents = new LinkedList<Dokument>();
        documents.addAll(dokumentRepository.findAll());
        
        System.out.println(documents.size());
    }

}
