
import com.panxf.console.biz.user.OrganService;
import com.panxf.console.common.constant.UserSysConstant;
import com.panxf.console.common.model.AceTreeItem;
import com.panxf.console.common.utils.AppUtil;
import com.panxf.console.controller.base.BaseController;
import com.panxf.lang.common.log.MyLog;
import com.panxf.lang.common.result.ServiceResp;
import com.panxf.lang.common.utils.JsonUtil;
import com.panxf.user.dto.enums.EnumCommonStatus;
import com.panxf.user.dto.req.UserOrganTreeQueryReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author panxiufeng
 * @version Id: OrganController.java, v 0.1 2019/5/20 14:36 panxiufeng Exp $$
 */

@Controller
@RequestMapping("/console/organ")
public class OrganController extends BaseController {


    private static MyLog log = MyLog.get(OrganController.class);
    @Autowired
    private OrganService organService;


    @RequestMapping("/index")
    public String index(ModelMap model) {
        model.put("pageContentUrl","/console/user/organ/organcontent");

        UserOrganTreeQueryReqDto dto = new UserOrganTreeQueryReqDto();
        dto.setRootOrganId(UserSysConstant.ROOT_ORAGN_ID);
        dto.setUserId(AppUtil.getLoginUser().getUserId());
        List<Integer> statusList = new ArrayList<Integer>();
        statusList.add(EnumCommonStatus.ENABLED.getCode());
        dto.setStatusList(statusList);
        ServiceResp<AceTreeItem> resp = organService.queryAceOrganTree(dto);
        if(resp.isSuccess()){
            log.info(JsonUtil.toJsonString(resp.getResultData()));
            Map<String,AceTreeItem> treeMap = new HashMap<String,AceTreeItem>();
            treeMap.put("root",resp.getResultData());
            model.addAttribute("treeJson", resp.getResultData() == null?"{}": JsonUtil.toJsonString(treeMap));
        }else{
            model.addAttribute("treeJson", "{}");
        }

        return "/console/common/index";
    }

}