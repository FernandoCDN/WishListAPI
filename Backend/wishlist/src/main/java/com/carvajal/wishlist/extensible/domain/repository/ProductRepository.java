package com.carvajal.wishlist.extensible.domain.repository;

import com.carvajal.wishlist.extensible.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

}
