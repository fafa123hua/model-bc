package nssc.bc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "nssc_processing_center")
public class NsscProcessingCenter implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer flowId;

    private Integer frequency;

    private Integer centerId;

    private Integer receiveData;

    private Integer dataManageWait;

    private Integer taskManageWait;

    private Integer taskNum;

    private Long endTime;
}