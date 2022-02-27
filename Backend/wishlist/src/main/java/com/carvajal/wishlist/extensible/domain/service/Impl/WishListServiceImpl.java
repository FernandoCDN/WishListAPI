package com.carvajal.wishlist.extensible.domain.service.Impl;

import com.carvajal.wishlist.extensible.app.api.request.WishListApi;
import com.carvajal.wishlist.extensible.domain.model.Product;
import com.carvajal.wishlist.extensible.domain.model.Wishlist;
import com.carvajal.wishlist.extensible.domain.repository.ProductRepository;
import com.carvajal.wishlist.extensible.domain.repository.WishListRepository;
import com.carvajal.wishlist.extensible.domain.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService
{
    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Wishlist> getAll()
    {
        return wishListRepository.findAll();
    }

    @Override
    public ArrayList<Wishlist> getAllByIdentification(String clientIdentification)
    {
        return wishListRepository.findByClientIdentification(clientIdentification);
    }

    @Override
    public Wishlist save(WishListApi wishlistproduct)
    {
        Product existingProduct = productRepository.findById(wishlistproduct.getProductId()).orElse(null);
        Wishlist wishlistsaved = new Wishlist();

        if (existingProduct != null)
        {
            Wishlist wishlist = new Wishlist();
            wishlist.setClientIdentification(wishlistproduct.getClientIdentification());
            wishlist.setProduct(existingProduct);

            wishlistsaved = wishListRepository.save(wishlist);
        }

        return wishlistsaved;
    }

    @Override
    public Wishlist update(Long id, WishListApi wishlistproduct)
    {
        Wishlist existingWishList = wishListRepository.findById(id).orElse(null);
        Wishlist wishlistupdated = new Wishlist();

        if (existingWishList != null)
        {
            wishListRepository.delete(existingWishList);

            Wishlist wishlist = new Wishlist();
            wishlist.setClientIdentification(wishlistproduct.getClientIdentification());
            wishlist.setId(id);

            Product existingProduct = new Product();
            existingProduct = productRepository.findById(wishlistproduct.getProductId()).orElse(null);

            wishlist.setProduct(existingProduct);

            return wishListRepository.save(wishlist);

        } else return null;
    }

    @Override
    public boolean delete(Long id)
    {
        Wishlist existingWishList = wishListRepository.findById(id).orElse(null);

        if (existingWishList != null)
        {
            wishListRepository.delete(existingWishList);
            return true;
        }
        else return false;
    }
}
