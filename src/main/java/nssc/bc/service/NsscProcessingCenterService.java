package nssc.bc.service;

import nssc.bc.entity.NsscProcessingCenter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 64807
* @description 针对表【nssc_processing_center】的数据库操作Service
* @createDate 2023-05-26 11:10:28
*/
public interface NsscProcessingCenterService extends IService<NsscProcessingCenter> {
    List<NsscProcessingCenter> getNsscProcessingCenterList();
}
