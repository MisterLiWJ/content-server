package shop.tanjie.content.contentserver.base.service;

import org.springframework.stereotype.Service;
import shop.tanjie.content.contentserver.base.dao.BaseDao;
import shop.tanjie.content.contentserver.base.entity.ApiReuslt;
import shop.tanjie.content.contentserver.utils.StringUtil;

import javax.annotation.Resource;

/**
 * @Author Chenjz
 * @Description Date 2019/12/12 10:42
 * @Version
 */
@Service
public class BaseService {

    @Resource
    private BaseDao baseDao;

    public ApiReuslt addLogs(String uid, String params){
        int i = baseDao.addLogs(StringUtil.uuid(), uid, params);
        return ApiReuslt.success(i);
    }
}
