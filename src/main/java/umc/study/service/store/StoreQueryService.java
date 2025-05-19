package umc.study.service.store;

import umc.study.domain.Store;

import java.util.List;

public interface StoreQueryService {

    List<Store> findOpenStoresByRegionId(Long regionId);
    List<Store> findAllStores();
    List<Store> findStoresByCategory(String category);
}
