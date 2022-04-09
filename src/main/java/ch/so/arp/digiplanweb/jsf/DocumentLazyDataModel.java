package ch.so.arp.digiplanweb.jsf;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ch.so.arp.digiplanweb.model.Dokument;
import ch.so.arp.digiplanweb.repository.DokumentRepository;

@Component
public class DocumentLazyDataModel extends LazyDataModel<Dokument> {

    private static final long serialVersionUID = 1L;
    
    DokumentRepository dokumentRepository;

    public DocumentLazyDataModel(DokumentRepository dokumentRepository) {
        this.dokumentRepository = dokumentRepository;
    }
    
    public void setFilter() {
        System.out.println("setFilter");
    }
    
    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        // TODO Auto-generated method stub
        return dokumentRepository.count();
    }

    @Override
    public List<Dokument> load(int first, int pageSize, Map<String, SortMeta> sortBy,
            Map<String, FilterMeta> filterBy) {        
        // TODO filter...
        
        
        System.out.println("first (offset):" + first);
        System.out.println("pageSize (limit):" + pageSize);
        if (first == 0 && pageSize == 0) {
            System.out.println("HAAAAALLLLI");
            return dokumentRepository.findAll();
        } else {
            return dokumentRepository.findAll(pageSize, first);   
        }
    }

}
