package com.example.comicstorespringbootmvn.item;

import com.example.comicstorespringbootmvn.book.Book;
import com.example.comicstorespringbootmvn.cart_item.CartItem;
import com.example.comicstorespringbootmvn.grading.Grading;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlvdl
 */
@Entity
@Table(name = "item")
@NamedQueries({
        @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
        @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.itemId = :itemId"),
        @NamedQuery(name = "Item.findByDateAdded", query = "SELECT i FROM Item i WHERE i.dateAdded = :dateAdded"),
        @NamedQuery(name = "Item.findByDateUpdated", query = "SELECT i FROM Item i WHERE i.dateUpdated = :dateUpdated")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne
    private Book bookId;
    @JoinColumn(name = "grading_id", referencedColumnName = "grading_id")
    @ManyToOne
    private Grading gradingId;
    @OneToMany(mappedBy = "itemId")
    private Collection<CartItem> cartItemCollection;

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Grading getGradingId() {
        return gradingId;
    }

    public void setGradingId(Grading gradingId) {
        this.gradingId = gradingId;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.comicstore.ejb.Item[ itemId=" + itemId + " ]";
    }

}

