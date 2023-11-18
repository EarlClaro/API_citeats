package com.cali.citeats.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblaccount")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private int accountId;

    @Column(name = "UserID")
    private int userId;

    @Column(name = "CreationDate")
    private Date creationDate;

    @Column(name = "FavoriteID")
    private int favoriteId;

    public AccountEntity() {
        super();
    }

    public AccountEntity(int accountId, int userId, Date creationDate, int favoriteId) {
        super();
        this.accountId = accountId;
        this.userId = userId;
        this.creationDate = creationDate;
        this.favoriteId = favoriteId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }
}
