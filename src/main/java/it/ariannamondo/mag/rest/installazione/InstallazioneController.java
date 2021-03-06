/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ariannamondo.mag.rest.installazione;

import it.ariannamondo.mag.config.endpoint.ServiceEndpoint;
import it.ariannamondo.mag.entity.Installazione;
import it.ariannamondo.mag.entity.utils.Response;
import it.ariannamondo.mag.rest.installazione.rs.InstallazionePagination;
import it.ariannamondo.mag.services.installazione.InstallazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jackarian
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class InstallazioneController {

    @Autowired
    private InstallazioneService installazioneService;

    @RequestMapping(value = ServiceEndpoint.INSTALLAZIONE_LIST, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InstallazionePagination> getInstallazions(@PathVariable Long page_size, @PathVariable Long offset) {

        
        InstallazionePagination installation = installazioneService.getInstallation(page_size, offset);
        return ResponseEntity.ok(installation);
    }
    @RequestMapping(value = ServiceEndpoint.INSTALLAZIONE_UPDATE, method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity  updateInstallazione(@PathVariable Long id,@RequestBody Installazione installazione) {

        
        Response<Boolean> resp = installazioneService.update(installazione);
        return ResponseEntity.ok(resp);
    }
    @RequestMapping(value = ServiceEndpoint.INSTALLAZIONE_CREATE, method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> crea(@RequestBody Installazione installazione) {

        
        Response<Installazione> resp = installazioneService.crea(installazione);
        return ResponseEntity.ok(resp);
    }
    @RequestMapping(value = ServiceEndpoint.INSTALLAZIONE_REMOVE, method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> elimina(@PathVariable Long id) {

        
        Response<Boolean> resp = installazioneService.remove(id);
        return ResponseEntity.ok(resp);
    }
}
