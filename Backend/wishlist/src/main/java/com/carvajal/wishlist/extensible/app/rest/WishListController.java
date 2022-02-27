package com.carvajal.wishlist.extensible.app.rest;


import com.carvajal.wishlist.extensible.app.api.request.WishListApi;
import com.carvajal.wishlist.extensible.domain.model.Wishlist;
import com.carvajal.wishlist.extensible.domain.service.WishListService;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/services/wishlist")
public class WishListController
{
    @Autowired
    WishListService wishListService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces="application/json")
    @ApiOperation("Get All Wishlist")
    private ResponseEntity<List<Wishlist>> getAll()
    {
        List<Wishlist> wishlistArrayList = wishListService.getAll();
        return ResponseEntity.ok(wishlistArrayList);
    }

    @GetMapping("/getAll/{clientIdentification}")
    @ApiOperation("Get All Wishlist by Client Identification")
    private ResponseEntity<ArrayList<Wishlist>> getAllByClientIdentification(@RequestParam String clientIdentification)
    {
        return ResponseEntity.ok(wishListService.getAllByIdentification(clientIdentification));
    }

    @PostMapping("/save")
    @ApiOperation("Add product to Wishlist")
    public ResponseEntity<Wishlist> save(@RequestBody WishListApi request)
    {
        Wishlist wishlistsaved = wishListService.save(request);
        return new ResponseEntity<>(wishlistsaved, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ApiOperation("Delete Wishlist product by Id")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        boolean ok = wishListService.delete(id);

        if (ok) return ResponseEntity.ok("deleted with Id: " + id);
        else return ResponseEntity.badRequest().body("Can't delete Wishlist product with Id: " + id);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update a WishList product")
    private ResponseEntity<Wishlist> update(@PathVariable("id") Long id, @RequestBody WishListApi request)
    {
        Wishlist wishlistupdated = wishListService.update(id, request);
        return new ResponseEntity<>(wishlistupdated, HttpStatus.OK);
    }
}
