
package com.echappeebelle.users.model;

import jakarta.persistence.*;


//@JsonFilter("monFiltreDynamique")
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)

        private int id;
        private String name;
        private String firstName;
        private String birthDate;
        private String licenseNumber;
        private String licenseObtentionDate;
        private int age;

        //CONSTRUCTOR***************************************************************************************************

        public User(int id,
                    String name,
                    String firstName,
                    String birth_date,
                    String license_number,
                    String license_obtention_date,
                    int age){

            this.id = id;

            this.firstName = firstName;

            this.name = name;

            this.birthDate = birth_date;

            this.licenseNumber = license_number;

            this.licenseObtentionDate = license_obtention_date;

            this.age = age;

        }

        public User() {

        }

        //GETTER SETTER*************************************************************************************************

        //GETTER SETTER ID *********************************************************************************************

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //GETTER SETTER PRENOM *****************************************************************************************

        public String getFirst_name() {
            return firstName;
        }

        public void setFirst_name(String first_name) {
            this.firstName = first_name;
        }
        //GETTER SETTER NOM*********************************************************************************************

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //GETTER SETTER DATE NAISSANCE**********************************************************************************

        public String getBirth_date() {
            return birthDate;
        }

        public void setBirth_date(String birth_date) {
            this.birthDate = birth_date;
        }
        //GETTER SETTER LICENSE NUMBER**********************************************************************************

        public String getLicense_number() {
            return licenseNumber;
        }

        public void setLicense_number(String license_number) {
            this.licenseNumber = license_number;
        }
        //GETTER SETTER LICENSE NUMBER**********************************************************************************
        public String getLicense_obtention_date() {
            return licenseObtentionDate;
        }
        public void setLicense_obtention_date(String license_obtention_date) {
            this.licenseObtentionDate = license_obtention_date;
        }
        //GETTER SETTER AGE*********************************************************************************************
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

    }



