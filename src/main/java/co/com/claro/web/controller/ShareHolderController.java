package co.com.claro.web.controller;
import co.com.claro.entity.AttorneyXShareHolder;
import co.com.claro.entity.ShareHolder;
import co.com.claro.service.AttorneyXShareholderService;
import co.com.claro.service.ShareHolderService;
import co.com.claro.web.utils.GenericResponse;
import co.com.claro.web.utils.ShareholderResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/shareHolder")
@Slf4j
public class ShareHolderController {
    private final ShareHolderService shareHolderService;
    private final AttorneyXShareholderService xShareholderService;

    @Autowired
    public ShareHolderController(ShareHolderService shareHolderService,
                                 AttorneyXShareholderService xShareholderService){
        this.shareHolderService = shareHolderService;
        this.xShareholderService = xShareholderService;
    }

    @GetMapping("")
    public List<ShareHolder> getShareHolders() {
        log.info("process=get-shareHolders");
        return shareHolderService.getAllShareHolder();
    }

    @GetMapping("/{tip}/{num}/{accion}")
    public ShareholderResponse getShareHolderById(@PathVariable String tip ,
                                                  @PathVariable Long num,
                                                  @PathVariable String accion) {
        log.info("process=get-shareHolder, shareHolder_num={}", num);
        ShareholderResponse response = new ShareholderResponse();
        List<String> actionsAttorney = new ArrayList<>();
        GenericResponse generic = new GenericResponse("00","Ok","Ok");
        ShareHolder sh = new ShareHolder();
        try{
            Optional<ShareHolder> shareHolder = shareHolderService.getShareHolderById(tip,num,accion);
            if (shareHolder.isPresent()){
                sh = shareHolder.get();
                if (sh.isApoderado()){
                    actionsAttorney = this.xShareholderService.getActionsByAttorney(tip,num);
                }
            }else {
                generic.setReturnCode("10");
                generic.setDescriptoCode("NOT FOUND");
                generic.setMenssage("la identifiación ó Número de acción no corresponde");
            }
        }catch (Exception e){
            generic.setReturnCode("99");
            generic.setDescriptoCode("SYSTEM ERROR");
            generic.setMenssage("Contacte con el Administrador");
        }
        response.setShareHolder(sh);
        response.setActionsAttorney(actionsAttorney);
        response.setResponseStatus(generic);
        return response;
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public ShareHolder createShareHolder(@RequestBody ShareHolder shareHolder) {
        log.info("process=create-shareHolder, shareHolder_correo={}", shareHolder.getCorreo());
        return this.shareHolderService.createShareHolder(shareHolder);
    }

    @PutMapping("/{tip}/{num}/{accion}")
    public ShareHolder updateShareHolder(  @PathVariable String tip ,
                                           @PathVariable Long num,
                                           @PathVariable String accion,
                                           @RequestBody ShareHolder shareHolder) {
        log.info("process=updatete-shareHolder, shareHolder_correo={}", shareHolder.getCorreo());
        shareHolder.setTipId(tip);
        shareHolder.setNumId(num);
        shareHolder.setNumeroAccion(accion);
        return this.shareHolderService.updateShareHolder(shareHolder);
    }

}
