package nssc.bc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "nssc_processing_center_vector")
public class NsscProcessingCenterVector implements Serializable {

    private Integer flowId;

    private Integer centerId;

    private Integer satelliteId;

    private Integer taskId;

    private Integer imgId;

    private Long imgTime;
}