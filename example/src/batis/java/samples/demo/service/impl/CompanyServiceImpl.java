package samples.demo.service.impl;

import samples.demo.po.CompanyPO;
import samples.demo.mapper.CompanyMapper;
import samples.demo.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bill
 * @since 2023-06-14
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyPO> implements CompanyService {

}
