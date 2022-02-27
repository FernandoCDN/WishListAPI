package com.carvajal.wishlist.extensible.domain.service;

import com.carvajal.wishlist.extensible.app.api.request.WishListApi;
import com.carvajal.wishlist.extensible.domain.model.Wishlist;

import java.util.ArrayList;
import java.util.List;

public interface WishListService
{
    List<Wishlist> getAll();

    ArrayList<Wishlist> getAllByIdentification(String clientIdentification);

    Wishlist save(WishListApi wishlistproduct);

    Wishlist update(Long id, WishListApi wishlistproduct);

    boolean delete(Long id);
}
