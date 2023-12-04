package com.test.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.store.domain.Store;
import com.test.store.mapper.StoreMapper;
import com.test.store.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * @author 20349
 * @description 针对表【store】的数据库操作Service实现
 * @createDate 2023-11-28 14:46:52
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store>
		implements StoreService {

}




