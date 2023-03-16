package yassen.salam.abdalrhmanfinalproject.data;

public class Profile {
   private String Owner;
   private String Name;
   private String PhoneNumber;
   private String Identity;
   private Boolean rbAutomatic;
   private Boolean rbManual;

   public String getOwner() {
      return Owner;
   }

   public void setOwner(String owner) {
      Owner = owner;
   }

   public String getName() {
      return Name;
   }

   public void setName(String name) {
      Name = name;
   }

   public String getPhoneNumber() {
      return PhoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      PhoneNumber = phoneNumber;
   }

   public String getIdentity() {
      return Identity;
   }

   public void setIdentity(String identity) {
      Identity = identity;
   }

   public Boolean getRbAutomatic() {
      return rbAutomatic;
   }

   public void setRbAutomatic(Boolean rbAutomatic) {
      this.rbAutomatic = rbAutomatic;
   }

   public Boolean getRbManual() {
      return rbManual;
   }

   public void setRbManual(Boolean rbManual) {
      this.rbManual = rbManual;
   }

   @Override
   public String toString() {
      return "Profile{" +
              "Owner='" + Owner + '\'' +
              ", Name='" + Name + '\'' +
              ", PhoneNumber='" + PhoneNumber + '\'' +
              ", Identity='" + Identity + '\'' +
              ", rbAutomatic=" + rbAutomatic +
              ", rbManual=" + rbManual +
              '}';
   }
}
