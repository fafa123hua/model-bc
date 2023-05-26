package nssc.bc.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nssc.bc.common.R;
import nssc.bc.entity.NsscProcessingCenter;
import nssc.bc.service.NsscProcessingCenterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/process/center")
@AllArgsConstructor
public class NsscProcessingCenterController {

    final NsscProcessingCenterService nsscProcessingCenterService;

    //    获取
    @GetMapping("/list")
    public R getNsscProcessingCenterList() {
        List<NsscProcessingCenter> nss = nsscProcessingCenterService.getNsscProcessingCenterList();
        return R.ok(nss);
    }

    //    根据id查询
    @GetMapping("/{frequency}")
    public R<NsscProcessingCenter> getInfo(@PathVariable("frequency") Integer frequency) {
        NsscProcessingCenter nss = nsscProcessingCenterService.getById(frequency);
        return R.ok(nss);
    }

}
