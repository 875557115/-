package cn.com.system.permission.mapper;

import cn.com.system.permission.entity.DmPermission;

import java.util.List;

public interface PermissionMapper {
    /**
     * 查询dm_permission表中的所有数据，根据source和operate排序
     * */
    public List<DmPermission> searchPermissions();
}
