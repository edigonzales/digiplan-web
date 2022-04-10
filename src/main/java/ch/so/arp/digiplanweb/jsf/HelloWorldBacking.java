package ch.so.arp.digiplanweb.jsf;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.LazyDataModel;
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
// Bei RequestScoped funktioniert das Paging nicht. Die Filter gehen vergessen.
@SessionScoped
//@RequestScoped
//@ViewScoped
public class HelloWorldBacking {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GemeindeRepository gemeindeRepository;

    @Autowired
    DokumentTypRepository dokumentTypRepository;

    @Autowired
    DokumentRepository dokumentRepository;
    
    private String selectedMunicipality;

    private String selectedDocumentType;

    private DocumentLazyDataModel documentLazyDataModel; 
    
    private HashMap<String,String> filters = new HashMap<>();
    
    @PostConstruct
    public void init() {
        documentLazyDataModel = new DocumentLazyDataModel(dokumentRepository);
    }
       
    public String getSelectedDocumentType() {
        return selectedDocumentType;
    }

    // TODO:
    // Vorbereites FilterObjekt mit Keys der erlaubten Filter?
    
    public void setSelectedDocumentType(String selectedDocumentType) {
        this.selectedDocumentType = selectedDocumentType;
        if (!selectedDocumentType.isBlank()) {
            filters.put("typ", selectedDocumentType);
        }
    }

    public String getSelectedMunicipality() {
        return selectedMunicipality;
    }

    public void setSelectedMunicipality(String selectedMunicipality) {
        this.selectedMunicipality = selectedMunicipality;
        if (!selectedMunicipality.isBlank()) {
            filters.put("gemeindename", selectedMunicipality);
        }
    }
        
    public LazyDataModel<Dokument> getDocumentModel() {
        return this.documentLazyDataModel;
    }
    
//    public List<String> completeText(String query) {
//        logger.info("Query: " + query);
//        String queryLowerCase = query.toLowerCase();
//        List<String> dokumentTypList = new ArrayList<>();
//        List<DokumentTyp> dokumentTypen = dokumentTypRepository.findAll();
//        for (DokumentTyp dokumentTyp : dokumentTypen) {
//            dokumentTypList.add(dokumentTyp.dispName());
//        }
//
//        return dokumentTypList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
//    }
    
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
    
    public void reset() {
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("searchform:documents_table");
        dataTable.reset();
        
        //PrimeFaces.current().ajax().update("searchform:documents_table");

        // TODO: Das ist der Vorschlaghammer? Funktioniert nicht, wenn man z.B. eingeloggt ist.
        // Sonst werden jedoch die Inputs nicht geresettet.
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    /*
     * Weil der Filter allenfalls ändert, muss alles was die Tabelle betrifft auf
     * der Serverseite getriggert werden. D.h. vor allem auch das Refreshen/Updaten, 
     * welches sonst im p:commandButton mit update="documents_table" gemacht werden
     * kann und man so die Reihenfolge der einzelnen Prozesse nicht garantierten kann:
     * Das Updaten der Tabelle muss nach dem Setzen des Filters passieren.
     */
    public void submit() {  
        
        // TODO: 
        // Wenn man die Gemeinde wieder "wegwählt" wird der Filter nicht zurückgesetzt.
        // -> FIXME
        logger.info("selectedDocumentType: " + selectedDocumentType + "**");
        logger.info("selectedMunicipality: " + selectedMunicipality + "**");
        
        documentLazyDataModel.setFilter(filters);
    
        DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("searchform:documents_table");
        dataTable.reset();
        
        PrimeFaces.current().ajax().update("searchform:documents_table");        
    }

}
