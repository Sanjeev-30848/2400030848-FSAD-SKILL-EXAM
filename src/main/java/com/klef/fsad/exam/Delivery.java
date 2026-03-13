package com.klef.fsad.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_table")
public class Delivery 
{
   @Id
   @Column(name="did")
   private String id;

   @Column(name="dname",length=50,nullable=false)
   private String name;

   @Column(name="ddate",length=20,nullable=false)
   private String date;

   @Column(name="dstatus",length=30,nullable=false)
   private String status;

   @Column(name="dlocation",length=50,nullable=false)
   private String location;

   @Column(name="dcost",nullable=false)
   private double cost;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public double getCost() {
      return cost;
   }

   public void setCost(double cost) {
      this.cost = cost;
   }

   @Override
   public String toString() {
      return "Delivery [id=" + id + ", name=" + name + ", date=" + date + 
             ", status=" + status + ", location=" + location + ", cost=" + cost + "]";
   }
}