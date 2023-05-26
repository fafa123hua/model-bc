package nssc.bc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nssc.bc.common.R;
import nssc.bc.entity.NsscProcessingCenterVector;
import nssc.bc.service.NsscProcessingCenterVectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/process/center/vector")
@AllArgsConstructor
public class NsscProcessingCenterVectorController {
    final NsscProcessingCenterVectorService nsscProcessingCenterVectorService;

    //    获取
    @GetMapping("/list")
    public R getNsscProcessingCenterVectorList() {
        List<NsscProcessingCenterVector> nss = nsscProcessingCenterVectorService.getNsscProcessingCenterVectorList();
        return R.ok(nss);
    }
}
