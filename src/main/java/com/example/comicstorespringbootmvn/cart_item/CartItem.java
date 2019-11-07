package com.example.comicstorespringbootmvn.cart_item;


import com.example.comicstorespringbootmvn.cart.Cart;
import com.example.comicstorespringbootmvn.item.Item;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlvdl
 */
@Entity
@Table(name = "cart_item")
@NamedQueries({
        @NamedQuery(name = "CartItem.findAll", query = "SELECT c FROM CartItem c"),
        @NamedQuery(name = "CartItem.findByCartItemId", query = "SELECT c FROM CartItem c WHERE c.cartItemId = :cartItemId"),
        @NamedQuery(name = "CartItem.findByQuantity", query = "SELECT c FROM CartItem c WHERE c.quantity = :quantity"),
        @NamedQuery(name = "CartItem.findByDateAdded", query = "SELECT c FROM CartItem c WHERE c.dateAdded = :dateAdded"),
        @NamedQuery(name = "CartItem.findByDateUpdated", query = "SELECT c FROM CartItem c WHERE c.dateUpdated = :dateUpdated")})
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cart_item_id")
    private Integer cartItemId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    @ManyToOne
    private Cart cartId;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item itemId;

    public CartItem() {
    }

    public CartItem(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartItemId != null ? cartItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartItem)) {
            return false;
        }
        CartItem other = (CartItem) object;
        if ((this.cartItemId == null && other.cartItemId != null) || (this.cartItemId != null && !this.cartItemId.equals(other.cartItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.comicstore.ejb.CartItem[ cartItemId=" + cartItemId + " ]";
    }

}
