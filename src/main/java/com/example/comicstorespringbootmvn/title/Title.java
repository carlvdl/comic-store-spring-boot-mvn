package com.example.comicstorespringbootmvn.title;

import com.example.comicstorespringbootmvn.publisher.Publisher;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlvdl
 */
@Entity
@Table(name = "title")
public class Title implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "title_id")
    private Integer titleId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "year_first_published")
    private String yearFirstPublished;

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;

    //    @OneToMany(mappedBy = "titleId")
    //    private Collection<Book> bookCollection;

    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    @ManyToOne
    private Publisher publisherId;

    public Title() {
    }

    public Title(Integer titleId) {
        this.titleId = titleId;
    }

    public Title(Integer titleId, String code, String description, String yearFirstPublished) {
        this.titleId = titleId;
        this.code = code;
        this.description = description;
        this.yearFirstPublished = yearFirstPublished;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearFirstPublished() {
        return yearFirstPublished;
    }

    public void setYearFirstPublished(String yearFirstPublished) {
        this.yearFirstPublished = yearFirstPublished;
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
//
//    public Collection<Book> getBookCollection() {
//        return bookCollection;
//    }
//
//    public void setBookCollection(Collection<Book> bookCollection) {
//        this.bookCollection = bookCollection;
//    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titleId != null ? titleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Title)) {
            return false;
        }
        Title other = (Title) object;
        if ((this.titleId == null && other.titleId != null) || (this.titleId != null && !this.titleId.equals(other.titleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.comicstore.ejb.Title[ titleId=" + titleId + " ]";
    }

}