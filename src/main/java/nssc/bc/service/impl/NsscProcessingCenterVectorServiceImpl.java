package nssc.bc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import nssc.bc.entity.NsscProcessingCenter;
import nssc.bc.entity.NsscProcessingCenterVector;
import nssc.bc.service.NsscProcessingCenterVectorService;
import nssc.bc.mapper.NsscProcessingCenterVectorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@AllArgsConstructor
public class NsscProcessingCenterVectorServiceImpl extends ServiceImpl<NsscProcessingCenterVectorMapper, NsscProcessingCenterVector> implements NsscProcessingCenterVectorService{
    @Resource
    final NsscProcessingCenterVectorMapper nsscProcessingCenterVectorMapper;
    @Override
    public List<NsscProcessingCenterVector> getNsscProcessingCenterVectorList() {
        QueryWrapper<NsscProcessingCenterVector> wa = new QueryWrapper<>();
        return nsscProcessingCenterVectorMapper.selectList(wa);
    }
}




