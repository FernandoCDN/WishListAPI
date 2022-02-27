package com.carvajal.wishlist.extensible.domain.repository;

import com.carvajal.wishlist.extensible.domain.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface WishListRepository extends JpaRepository<Wishlist, Long>
{
    ArrayList<Wishlist> findByClientIdentification(String clientIdentification);
}
