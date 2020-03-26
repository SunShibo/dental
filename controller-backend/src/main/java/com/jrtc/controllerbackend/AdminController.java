package com.jrtc.controllerbackend;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.entity.bo.AdminBO;
import com.jrtc.base.entity.bo.MenuBO;
import com.jrtc.base.entity.bo.RoleBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.JsonUtils;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseCotroller;
import com.jrtc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 管理员
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseCotroller {
    @Resource
    private AdminService adminService ;

    /**
     * 管理员登录
     * @param request
     * @param response
     * @param mobile 手机号
     * @param password 密码
     */
    @RequestMapping(value = "/adminLogin")
    public ResultDTO adminLogin(HttpServletRequest request, HttpServletResponse response, String mobile, String password){
        //验证参数
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            return ResultDTOBuilder.failure("00001");
        }
        //验证账号
        AdminBO adminBO = adminService.queryAdminInfoByMobile(mobile);
        if(adminBO==null){
            return ResultDTOBuilder.failure("01002");
        }
        if(!SecureUtil.md5(password).equals(adminBO.getPassword())){
            return ResultDTOBuilder.failure("01000");
        }
        adminBO.setPassword("");
        super.putLoginAdmin(adminBO,response);
        List<MenuBO> roleMenuSuccess = adminService.getRoleMenuSuccess(adminBO.getRoleId());
        Map<String,Object>  resultMap=new HashMap<String, Object>();
        resultMap.put("menu",roleMenuSuccess);
        resultMap.put("admin",adminBO);
        return ResultDTOBuilder.success(resultMap);
    }

    /**
     * 查询当前登录的管理员的权限
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAdminLoginMenus")
    public ResultDTO getAdminLoginMenus(HttpServletRequest request, HttpServletResponse response){
        AdminBO loginAdmin = super.getLoginAdmin(request);
        //验证用户
        if(loginAdmin==null){
            return ResultDTOBuilder.failure("00002");
        }
        List<MenuBO> roleMenuSuccess = adminService.getRoleMenuSuccess(loginAdmin.getRoleId());
        Map<String,Object>  resultMap=new HashMap<String, Object>();
        resultMap.put("menu",roleMenuSuccess);
        return ResultDTOBuilder.success(resultMap);
    }


    /**
     * 创建管理员
     * @param request
     * @param response
     */
    @RequestMapping("/adminRegister")
    public ResultDTO adminRegister(HttpServletRequest request, HttpServletResponse response, AdminBO admin){
        AdminBO loginAdmin = super.getLoginAdmin(request);
        //验证用户
        if(loginAdmin==null){
            return ResultDTOBuilder.failure("00002");
        }
        //验证参数
        if(!verifyParam(admin.getPassword(), admin.getPhoneNumber(),admin.getName(),admin.getRoleId())){
            return ResultDTOBuilder.failure("00001");
        }
        //判断手机号是否注册过
        int count = adminService.selectCountByMobile(admin.getPhoneNumber());
        if(count > 0 ){
            return ResultDTOBuilder.failure("01001");
        }
        //注册管理员

        adminService.adminRegister(admin);
        return ResultDTOBuilder.success();
    }

    /**
     * 根据条件查询管理员信息
     * @param request
     * @param response
     * @param userId 用戶id
     * @param roleId 角色id
     * @param userName 用戶名
     */
    @RequestMapping("/getAdminById")
    public ResultDTO getAdminById(HttpServletRequest request, HttpServletResponse response,
                             Integer userId, Integer roleId, String userName, PageUtil page){
        AdminBO loginAdmin = super.getLoginAdmin(request);
        //验证用户
        if(loginAdmin==null){
            return ResultDTOBuilder.failure("00002");
        }
        //查询信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        map.put("userName",userName);
        //分页的用户信息
        IPage<AdminBO> admins = adminService.getAdminByCond(page, map);
        return ResultDTOBuilder.success(admins);
    }
    /**
     * 批量删除用户
     * @param request
     * @param response
     * @param idArr 需要刪除的用戶的id
     */
    @RequestMapping("/delAdmins")
    public ResultDTO delAdmin(HttpServletRequest request, HttpServletResponse response, String idArr){
        // 非空判断
        if(StringUtils.isEmpty(idArr)){
            return ResultDTOBuilder.failure("00001");
        }
        //转换为数组 批量删除
        Integer[] ids= JsonUtils.getIntegerArray4Json(idArr);
        adminService.delAdminById(ids);
        return ResultDTOBuilder.success();
    }

    /**
     * 修改admin用戶信息
     * @param request
     * @param response
     * @param param
     * @param
     */
    @RequestMapping("/updateAdminUser")
    public ResultDTO updateAdminUser(HttpServletRequest request, HttpServletResponse response, AdminBO param){
        if(!verifyParam(param.getId(),param.getPhoneNumber(),param.getName())){
            return ResultDTOBuilder.failure("00001");
        }

        //验证手机号
        AdminBO adminBO = adminService.queryAdminBOById(param.getId());
        //不等于旧手机号则验证是否重复
        if(!param.getPhoneNumber().equals(adminBO.getPhoneNumber())){
            int count = adminService.selectCountByMobile(param.getPhoneNumber());
            if(count > 0 ){
                return ResultDTOBuilder.failure("01001");
            }
        }
        adminService.updateAdminUser(param);
        return ResultDTOBuilder.success();
    }


    /**
     * 修改密码
     * @param request
     * @param response
     */
    @RequestMapping("/changePassword")
    public ResultDTO changePassword(HttpServletRequest request, HttpServletResponse response, String passWord, Integer id){
        //验证参数
        if(!verifyParam(passWord,id)){
            return ResultDTOBuilder.failure("00001");
        }
        AdminBO adminBO=new AdminBO();
        adminBO.setId(id);
        adminBO.setPassword(passWord);
        adminService.updateAdminUser(adminBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 创建角色
     * 并赋予权限
     * @param request
     * @param response
     * @param roleName  角色名称
     * @param menuIds  权限ids
     */
    @RequestMapping("/addRoleGrantAuthority")
    public ResultDTO addRoleGrantAuthority(HttpServletRequest request, HttpServletResponse response,
                                      String roleName, String menuIds){
        //参数验证
        if(!verifyParam(roleName,menuIds)){
            return ResultDTOBuilder.failure("00001");
        }
        // 判断角色名称是否存在
        Integer nameCount = adminService.selectCountByRoleName(roleName);
        if(nameCount>0){
            return ResultDTOBuilder.failure("01004");
        }
        //创建角色 返回角色id
        RoleBO roleBO=new RoleBO();
        roleBO.setRoleName(roleName);
        adminService.addRole(roleBO);
        //添加权限
        List<Integer> menuIdList= new ArrayList<Integer>();
        if(menuIds!=null){
            String[] menuIdStrs=menuIds.split(",");
            for (int i=0;i<menuIdStrs.length;i++){
                menuIdList.add(new Integer(menuIdStrs[i]));
            }
        }
        adminService.addRoleMenu(roleBO.getId(),menuIdList);
        return ResultDTOBuilder.success();

    }

    /**
     * 角色信息列表查询
     * 角色名模糊查询
     * 查询角色对应的权限
     * @param request
     * @param response
     */
    @RequestMapping("/getAllRoleMenu")
    public ResultDTO getAllRoleMenu(HttpServletRequest request, HttpServletResponse response, String roleName){
        List<RoleBO> ros = adminService.getRoleByRoleName(roleName);
        return  ResultDTOBuilder.success(ros);
    }

    /**
     * 查询所有权限(菜单)
     * @return 所有菜单
     */
    @RequestMapping("/getMenuList")
    public ResultDTO MenuList(HttpServletRequest request, HttpServletResponse response){
        List<MenuBO> menuList = adminService.getMenuList();
        return  ResultDTOBuilder.success(menuList);
    }

    /**
     * 编辑对应角色的权限
     * @param request
     * @param response
     * @param roleId  角色id
     * @param menuIds  权限id
     */
    @RequestMapping("/grantAuthority")
    public ResultDTO grantAuthority(HttpServletRequest request, HttpServletResponse response, Integer roleId, String menuIds, String roleName){
        //验证参数
        if(!verifyParam(roleId,menuIds,roleName)){
            return ResultDTOBuilder.failure("00001");
        }
        //验证角色名
        RoleBO roleBO = adminService.getRoleById(roleId);
        if(roleBO==null){
            return ResultDTOBuilder.failure("00001");
        }
        if(!roleBO.getRoleName().equals(roleName)){
            // 不一致查询是否重复
            Integer nameCount = adminService.selectCountByRoleName(roleName);
            if(nameCount>0){
                return ResultDTOBuilder.failure("01004");
            }
        }
        //修改角色姓名信息
        adminService.updateRoleNameByRoleId(roleId,roleName);
        //修改角色的权限
        adminService.updRoleToMenu(roleBO,menuIds);
        return ResultDTOBuilder.success();
    }

    /**
     * 角色下拉框
     * 查询所有角色
     */
    @RequestMapping("/getRoleList")
    public ResultDTO getRoleList(String status, HttpServletRequest request, HttpServletResponse response){
        List<RoleBO> roleList = adminService.getRoleList(status);
        return ResultDTOBuilder.success(roleList);
    }

    /**
     * 删除角色信息 根据角色id
     * @param request
     * @param roleIds
     */
    @RequestMapping("/delRoleByIds")
    public ResultDTO delRoleByIds(HttpServletRequest request, HttpServletResponse response, String roleIds){

        //验证参数
        if(verifyParam(roleIds)){
            return   ResultDTOBuilder.failure("00001");
        }
        //判断该角色下是否用户
        Integer id = adminService.checkRoleUser(roleIds);
        if(id!=null){
            return   ResultDTOBuilder.failure("01005");
        }
        //删除成功
        Integer[] roleIdArr=JsonUtils.getIntegerArray4Json(roleIds);
        adminService.delRoleById(roleIdArr);
        return ResultDTOBuilder.success();
    }

    //退出登录
    @RequestMapping("/exitLogin")
    public ResultDTO exit(HttpServletResponse response, HttpServletRequest request){
        super.delLoginAdmin(request,response);
        return ResultDTOBuilder.success();
    }

    //查询所有权限菜单
    @RequestMapping("getPermissionsMenu")
    public ResultDTO getPermissionsMenu(HttpServletResponse response, HttpServletRequest request){
        //查询所有权限
        List<MenuBO> menuBOList=adminService.getMenuList();
        return  ResultDTOBuilder.success(menuBOList);
    }

}