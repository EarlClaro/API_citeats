package com.cali.citeats.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tblreview")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "RestaurantID")
    private RestaurantEntity restaurant;

    @Column(name = "Rating")
    private Integer rating;

    @Column(name = "Comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "DatePosted")
    private Date datePosted;

    public ReviewEntity() {
        super();
    }

    public ReviewEntity(int reviewId, UserEntity user, RestaurantEntity restaurant, Integer rating, String comment, Date datePosted) {
        super();
        this.reviewId = reviewId;
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.comment = comment;
        this.datePosted = datePosted;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
}
