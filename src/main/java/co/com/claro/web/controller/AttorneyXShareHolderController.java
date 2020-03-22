package co.com.claro.web.controller;

import co.com.claro.entity.AttorneyXShareHolder;
import co.com.claro.service.AttorneyXShareholderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/AttorneyXShareHolder")
@Slf4j
public class AttorneyXShareHolderController {
    private final AttorneyXShareholderService xShareholderService;

    @Autowired
    public AttorneyXShareHolderController(AttorneyXShareholderService xShareholderService) {
        this.xShareholderService = xShareholderService;
    }

    @GetMapping("")
    public List<AttorneyXShareHolder> getAllAttorneyXShareHolder() {
        log.info("process=get-AttorneyXShareHolder");
        return xShareholderService.getAllAttorneyXShareHolder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttorneyXShareHolder> getAttorneyXShareHolderById( @PathVariable Long id) {
        log.info("process=get-AttorneyXShareHolder, AttorneyXShareHolder_id={}", id);
        Optional<AttorneyXShareHolder> attorneyXShareHolder = xShareholderService.getAttorneyXShareHolderById(id);
        return attorneyXShareHolder.map( u -> ResponseEntity.ok(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public AttorneyXShareHolder createAttorneyXShareHolder(@RequestBody AttorneyXShareHolder attorneyXShareHolder) {
        log.info("process=create-AttorneyXShareHolder, AttorneyXShareHolder_correo={}", attorneyXShareHolder.getApoNumId());
        return this.xShareholderService.createAttorneyXShareHolder(attorneyXShareHolder);
    }

    @PutMapping("/{id}")
    public AttorneyXShareHolder updateAttorneyXShareHolder(@PathVariable Long id,
                                            @RequestBody AttorneyXShareHolder attorneyXShareHolder) {
        log.info("process=updatete-AttorneyXShareHolder, AttorneyXShareHolder_correo={}",
                attorneyXShareHolder.getIpUltAcceso());
        attorneyXShareHolder.setId(id);
        return this.xShareholderService.updateAttorneyXShareHolder(attorneyXShareHolder);
    }
}
