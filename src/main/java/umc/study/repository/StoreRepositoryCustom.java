package umc.study.repository;

import umc.study.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> findOpenStoresByRegionId(Long regionId);
}
