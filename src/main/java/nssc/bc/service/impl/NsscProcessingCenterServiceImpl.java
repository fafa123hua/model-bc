package nssc.bc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import nssc.bc.entity.NsscProcessingCenter;
import nssc.bc.service.NsscProcessingCenterService;
import nssc.bc.mapper.NsscProcessingCenterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@AllArgsConstructor
public class NsscProcessingCenterServiceImpl extends ServiceImpl<NsscProcessingCenterMapper, NsscProcessingCenter> implements NsscProcessingCenterService{
    @Resource
    final NsscProcessingCenterMapper nsscProcessingCenterMapper;
    @Override
    public List<NsscProcessingCenter> getNsscProcessingCenterList() {
        QueryWrapper<NsscProcessingCenter> wa = new QueryWrapper<>();
        return nsscProcessingCenterMapper.selectList(wa);
    }
}




