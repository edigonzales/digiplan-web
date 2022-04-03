package ch.so.arp.digiplanweb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import ch.so.arp.digiplanweb.model.Dokument;
import ch.so.arp.digiplanweb.model.DokumentTyp;
import ch.so.arp.digiplanweb.model.Gemeinde;
import ch.so.arp.digiplanweb.repository.DokumentRepository;
import ch.so.arp.digiplanweb.repository.DokumentTypRepository;
import ch.so.arp.digiplanweb.repository.GemeindeRepository;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DokumentRepository dokumentRepository;

    @Autowired
    DokumentTypRepository dokumentTypRepository;

    @Autowired
    GemeindeRepository gemeindeRepository;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<String>("digiplan-web", HttpStatus.OK);
    }
    
    @GetMapping("/dokument")
    public ResponseEntity<String> dokument() {
        List<Dokument> dokumente = dokumentRepository.findAll();
        return new ResponseEntity<String>(String.valueOf(dokumente.size()), HttpStatus.OK);
    }

    @GetMapping("/dokumenttyp")
    public ResponseEntity<String> dokumentTyp() {
        List<DokumentTyp> dokumentTypen = dokumentTypRepository.findAll();
        return new ResponseEntity<String>(String.valueOf(dokumentTypen.size()), HttpStatus.OK);
    }

    @GetMapping("/gemeinde")
    public ResponseEntity<List<Gemeinde>> gemeinde() {
        List<Gemeinde> gemeinden = gemeindeRepository.findAll();
        return new ResponseEntity<List<Gemeinde>>(gemeinden, HttpStatus.OK);
    }

}
