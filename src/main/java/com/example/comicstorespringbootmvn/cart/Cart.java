package com.example.comicstorespringbootmvn.cart;

import com.example.comicstorespringbootmvn.cart_item.CartItem;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author carlvdl
 */
@Entity
@Table(name = "cart")
@NamedQueries({
        @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
        @NamedQuery(name = "Cart.findByCartId", query = "SELECT c FROM Cart c WHERE c.cartId = :cartId"),
        @NamedQuery(name = "Cart.findByCookie", query = "SELECT c FROM Cart c WHERE c.cookie = :cookie"),
        @NamedQuery(name = "Cart.findByDateAdded", query = "SELECT c FROM Cart c WHERE c.dateAdded = :dateAdded"),
        @NamedQuery(name = "Cart.findByDateUpdated", query = "SELECT c FROM Cart c WHERE c.dateUpdated = :dateUpdated")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cart_id")
    private Integer cartId;
    @Size(max = 255)
    @Column(name = "cookie")
    private String cookie;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @OneToMany(mappedBy = "cartId")
    private Collection<CartItem> cartItemCollection;

    public Cart() {
    }

    public Cart(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
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

    public Collection<CartItem> getCartItemCollection() {
        return cartItemCollection;
    }

    public void setCartItemCollection(Collection<CartItem> cartItemCollection) {
        this.cartItemCollection = cartItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.comicstore.ejb.Cart[ cartId=" + cartId + " ]";
    }

}
