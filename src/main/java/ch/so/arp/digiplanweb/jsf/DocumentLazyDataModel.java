package ch.so.arp.digiplanweb.jsf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.so.arp.digiplanweb.model.Dokument;
import ch.so.arp.digiplanweb.repository.DokumentRepository;

@Component
public class DocumentLazyDataModel extends LazyDataModel<Dokument> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final long serialVersionUID = 1L;
    
    private DokumentRepository dokumentRepository;
    
    private HashMap<String,String> filters;

    public DocumentLazyDataModel(DokumentRepository dokumentRepository) {
        this.dokumentRepository = dokumentRepository;
    }
    
    public void setFilter(HashMap<String,String> filters) {
        logger.info("setFilter: " + filters.toString());
        this.filters = filters;
    }
    
    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return dokumentRepository.count(filters);
    }

    @Override
    public List<Dokument> load(int first, int pageSize, Map<String, SortMeta> sortBy,
            Map<String, FilterMeta> filterBy) {        
        
        logger.info("load");
        logger.info("first (offset):" + first);
        logger.info("pageSize (limit):" + pageSize);
//        logger.info(filters.toString());
//        System.out.println(filters.hashCode());
        
        List<Dokument> result = dokumentRepository.findAll(pageSize, first, filters);
        logger.info("size: " + String.valueOf(result.size()));
        System.out.println("page size : " + this.getPageSize());
        System.out.println("row count : " + this.getRowCount());

        //this.setRowCount(50);
        
        return result;
    }
}
