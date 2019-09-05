/**
 * Software License Declaration.
 * <p>
 * wandaph.com, Co,. Ltd.
 * Copyright ? 2017 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to wandaph contracting agent or authorized programmer only.
 * This source code is written and edited by wandaph Co,.Ltd Inc specially for financial
 * business contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to wandaph Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise wandaph will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to wandaph Co,. Ltd Inc in time, Thank you!
 */

import com.google.common.collect.Lists;
import com.panxf.console.biz.user.OrganService;
import com.panxf.console.client.user.OrganClient;
import com.panxf.console.common.model.AceTreeItem;
import com.panxf.console.common.model.AdditionalParameters;
import com.panxf.console.common.model.ZtreeSimpleModel;
import com.panxf.lang.common.enums.EnumCommonErrCode;
import com.panxf.lang.common.exception.BizException;
import com.panxf.lang.common.log.MyLog;
import com.panxf.lang.common.result.BaseResp;
import com.panxf.lang.common.result.PageResp;
import com.panxf.lang.common.result.ServiceResp;
import com.panxf.user.dto.entity.UserOrganInfo;
import com.panxf.user.dto.pojo.OrganTreeNode;
import com.panxf.user.dto.req.UserOrganInfoAddReqDto;
import com.panxf.user.dto.req.UserOrganInfoDeleteReqDto;
import com.panxf.user.dto.req.UserOrganInfoModifyReqDto;
import com.panxf.user.dto.req.UserOrganInfoModifyStatusReqDto;
import com.panxf.user.dto.req.UserOrganInfoQueryByIdDto;
import com.panxf.user.dto.req.UserOrganInfoQueryListReqDto;
import com.panxf.user.dto.req.UserOrganTreeQueryReqDto;
import com.panxf.user.dto.resp.UserOrganInfoQueryListRespDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author panxiufeng
 * @version Id: OrganServiceImpl.java, v 0.1 2019/5/17 15:43 panxiufeng Exp $$
 */
@Service
public class OrganServiceImpl implements OrganService {


    private static MyLog log = MyLog.get(OrganServiceImpl.class);

    @Autowired
    private OrganClient organClient;

    @Override
    public ServiceResp<UserOrganInfoQueryListRespDto> queryList(UserOrganInfoQueryListReqDto dto) {

        try {
            BaseResp<UserOrganInfoQueryListRespDto> resp = organClient.queryList(dto);
            if(resp.isSuccess()){
                return new ServiceResp<UserOrganInfoQueryListRespDto>(resp.getData());
            }
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("查询组织机构列表异常:", se);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("查询组织机构列表异常:", e);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<UserOrganInfoQueryListRespDto> queryPage(UserOrganInfoQueryListReqDto dto) {

        try {
            PageResp<UserOrganInfoQueryListRespDto> resp = organClient.queryPage(dto);
            if(resp.isSuccess()){
                return new ServiceResp<UserOrganInfoQueryListRespDto>(resp.getData(),
                        (int) resp.getTotalCount(), dto.getPageReq().getPageNo(), dto.getPageReq().getPageSize());
            }
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("分页查询组织机构列表异常:", se);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("分页查询组织机构列表异常:", e);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public UserOrganInfo queryOne(UserOrganInfoQueryListReqDto dto) {
        BaseResp<UserOrganInfoQueryListRespDto> resp = organClient.queryList(dto);
        if(resp.isSuccess()){
            if(Objects.nonNull(resp.getData()) && Objects.nonNull(resp.getData().getEntityList()) ){
                return resp.getData().getEntityList().get(0);
            }
            return null;
        }
        throw new BizException(resp.getRespCode(),resp.getRespMsg(),this.getClass());
    }

    @Override
    public ServiceResp<Integer> insert(UserOrganInfoAddReqDto dto) {

        try {
            BaseResp<Integer> resp = organClient.insert(dto);
            if(resp.isSuccess()){
                return new ServiceResp<Integer>(resp.getData());
            }
            return new ServiceResp<Integer>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("新增组织机构异常:", se);
            return new ServiceResp<Integer>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("新增组织机构异常:", e);
            return new ServiceResp<Integer>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<Boolean> modify(UserOrganInfoModifyReqDto dto) {

        try {
            BaseResp<Boolean> resp = organClient.modify(dto);
            if(resp.isSuccess()){
                return new ServiceResp<Boolean>(resp.getData());
            }
            return new ServiceResp<Boolean>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("修改组织机构异常:", se);
            return new ServiceResp<Boolean>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("修改组织机构异常:", e);
            return new ServiceResp<Boolean>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<Boolean> modifyStatus(UserOrganInfoModifyStatusReqDto dto) {

        try {
            BaseResp<Boolean> resp = organClient.modifyStatus(dto);
            if(resp.isSuccess()){
                return new ServiceResp<Boolean>(resp.getData());
            }
            return new ServiceResp<Boolean>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("修改组织机构状态异常:", se);
            return new ServiceResp<Boolean>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("修改组织机构状态异常:", e);
            return new ServiceResp<Boolean>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<Boolean> delete(UserOrganInfoDeleteReqDto dto) {

        try {
            BaseResp<Boolean> resp = organClient.delete(dto);
            if(resp.isSuccess()){
                return new ServiceResp<Boolean>(resp.getData());
            }
            return new ServiceResp<Boolean>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("删除组织机构（软删）异常:", se);
            return new ServiceResp<Boolean>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("删除组织机构（软删）异常:", e);
            return new ServiceResp<Boolean>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }

    @Override
    public ServiceResp<ZtreeSimpleModel> queryOrganTree(UserOrganTreeQueryReqDto dto) {

        try {
            BaseResp<OrganTreeNode> resp = organClient.queryOrganTree(dto);
            if(resp.isSuccess()){
                List<ZtreeSimpleModel> ztreeSimpleModelList = getZtreeSimpleDataList(resp.getData(), null);
                return new ServiceResp<ZtreeSimpleModel>(ztreeSimpleModelList);
            }
            return new ServiceResp<ZtreeSimpleModel>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("查询组织机构树异常:", se);
            return new ServiceResp<ZtreeSimpleModel>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("查询组织机构树异常:", e);
            return new ServiceResp<ZtreeSimpleModel>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }


    private List<ZtreeSimpleModel> getZtreeSimpleDataList(OrganTreeNode node,List<ZtreeSimpleModel> list){

        if(Objects.equals(null,node)){
            return null;
        }

        if(Objects.equals(null,list)){
            list = Lists.newArrayList();
        }

        ZtreeSimpleModel pojo = new ZtreeSimpleModel();
        pojo.setId(node.getId());
        pojo.setParentId(node.getParentId());
        pojo.setName(node.getName());
        pojo.setHasChild(node.isHasChild());
        pojo.setOpen(true);
        List<OrganTreeNode> childNodes = node.getChildrenNode();
        if(CollectionUtils.isNotEmpty(childNodes)){
            for(OrganTreeNode v:childNodes){
                getZtreeSimpleDataList(v,list);
            }
        }
        list.add(pojo);
        return list;
    }


    private AceTreeItem getAceTreeSimpleDataList(OrganTreeNode node){

        if(Objects.equals(null,node)){
            return null;
        }

        AceTreeItem pojo = new AceTreeItem();
        pojo.setId(node.getId());
        pojo.setParentId(node.getParentId());
        pojo.setSort(node.getSort());
        if(node.isHasChild()){
            pojo.setType("folder");
            pojo.setText(node.getName());
            List<OrganTreeNode> childNodes = node.getChildrenNode();
            AdditionalParameters additionalParameters = new AdditionalParameters();
            if(CollectionUtils.isNotEmpty(childNodes)){
                Map<String,AceTreeItem> children = new LinkedHashMap<String,AceTreeItem>();
                for(OrganTreeNode organTreeNode:childNodes){
                    children.put(organTreeNode.getName(),getAceTreeSimpleDataList(organTreeNode));
                }
                additionalParameters.setChildren(children);
            }
            pojo.setAdditionalParameters(additionalParameters);
        }else{
            pojo.setType("item");
            pojo.setText("<i class=\"icon-folder ace-icon fa fa-folder-open\"></i>"+node.getName());
        }

        return pojo;
    }

    @Override
    public ServiceResp<AceTreeItem> queryAceOrganTree(UserOrganTreeQueryReqDto dto) {
        try {
            BaseResp<OrganTreeNode> resp = organClient.queryOrganTree(dto);
            if(resp.isSuccess()){
                AceTreeItem AceTreeItem = getAceTreeSimpleDataList(resp.getData());
                return new ServiceResp<AceTreeItem>(AceTreeItem);
            }
            return new ServiceResp<AceTreeItem>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("查询组织机构树异常:", se);
            return new ServiceResp<AceTreeItem>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("查询组织机构树异常:", e);
            return new ServiceResp<AceTreeItem>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }




    @Override
    public ServiceResp<UserOrganInfoQueryListRespDto> queryOrganById(Integer id,boolean withParent) {

        try {
            UserOrganInfoQueryByIdDto dto = new UserOrganInfoQueryByIdDto();
            dto.setId(id);
            dto.setWithParent(withParent);
            BaseResp<UserOrganInfoQueryListRespDto> resp = organClient.queryOrganById(dto);
            if(resp.isSuccess()){
                return new ServiceResp<UserOrganInfoQueryListRespDto>(resp.getData());
            }
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false,resp.getRespCode(),resp.getRespMsg());
        } catch(BizException se){
            log.error("根据id查询机构异常:", se);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, se.getMsgCode(), se.getMessage());
        } catch (Exception e) {
            log.error("根据id查询机构异常:", e);
            return new ServiceResp<UserOrganInfoQueryListRespDto>(false, EnumCommonErrCode.SYSTEM_ERROR.getCode(), EnumCommonErrCode.SYSTEM_ERROR.getDescript());
        }
    }
}