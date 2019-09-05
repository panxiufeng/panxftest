import com.panxf.console.common.model.AceTreeItem;
import com.panxf.console.common.model.ZtreeSimpleModel;
import com.panxf.lang.common.result.ServiceResp;
import com.panxf.user.dto.entity.UserOrganInfo;
import com.panxf.user.dto.req.UserOrganInfoAddReqDto;
import com.panxf.user.dto.req.UserOrganInfoDeleteReqDto;
import com.panxf.user.dto.req.UserOrganInfoModifyReqDto;
import com.panxf.user.dto.req.UserOrganInfoModifyStatusReqDto;
import com.panxf.user.dto.req.UserOrganInfoQueryListReqDto;
import com.panxf.user.dto.req.UserOrganTreeQueryReqDto;
import com.panxf.user.dto.resp.UserOrganInfoQueryListRespDto;

public interface OrganService {

    //查询组织机构列表
    ServiceResp<UserOrganInfoQueryListRespDto> queryList(UserOrganInfoQueryListReqDto dto);

    //分页查询组织机构列表
    ServiceResp<UserOrganInfoQueryListRespDto> queryPage(UserOrganInfoQueryListReqDto dto);

    //查询单个机构
    UserOrganInfo queryOne(UserOrganInfoQueryListReqDto dto);

    //新增组织机构
    ServiceResp<Integer> insert(UserOrganInfoAddReqDto dto);

    //修改组织机构
    ServiceResp<Boolean> modify(UserOrganInfoModifyReqDto dto);

    //修改组织机构状态
    ServiceResp<Boolean> modifyStatus(UserOrganInfoModifyStatusReqDto dto);

    //删除组织机构（软删）
    ServiceResp<Boolean> delete(UserOrganInfoDeleteReqDto dto);

    //查询组织机构树
    ServiceResp<ZtreeSimpleModel> queryOrganTree(UserOrganTreeQueryReqDto dto);
    //查询组织机构树
    ServiceResp<AceTreeItem> queryAceOrganTree(UserOrganTreeQueryReqDto dto);

    //根据id查询机构
    ServiceResp<UserOrganInfoQueryListRespDto> queryOrganById(Integer id,boolean withParent);
}
