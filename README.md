Coverage: 51.5%
# Project Title
Avi Nissim-Hart

This project is an Inventory Managment System. Its purpose is to have customers, items, and orders made by customers
all linked together. It uses a database in MYSQL with 4 tables which all connect to each other accordingly using 
foreign keys. 
The functionality of the project is that you can create customers, new items, orders and then make changes.
You can also change items, change customers, delete items and orders, add items to orders,
and of course - read orders. The purpose of this project is to showcase the skills i have learnt while
training at the academy.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

https://github.com/AviNissimHart/IMS-Starter.git
Above is a link to my github project. You will want to clone this from the master branch. Alternatively, you can always just download the ZIP file as this will contain everything you need.

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

If you have cloned the repository, you already know what you are doing. If you have downloaded the zip file, you will need some help to set up here.

Firstly, you will need to unzip / extract the files from the zip folder.
Next, you will need to open your eclipse, select file > open projects from file system
here you must find the file path of the unzipped folder and select it to open.

Once this has been opened, you will see the project in your package explorer.
Select the file "Runner" within src/main/java in hte com.qa.ims package
Before you do anything else, you must now go to mysql within the command line interface, log in, and create a table called ims

Going back to the eclipse window, go into db.properties within src/main/resources

in there, you will want to change the details to match your mysql e.g. user and password


Now, if you click on the green button at the top of the screen to run the program, it will use the ims database you created,
and it will create the required tables for the program to use.

User= root
Password = rootroot



## Running the tests


If you go into the test package, you will see various tests that can be run. You can run each one individually or you can do them all together.
This can be done by right clicking the test class you want and selecting run as JUnit test
I have a test for the customerDAO and the itemDAO that work properly. This is to test feeding in data to the system and then testing all the 
features implemented to ensure they work as intended. This actually applies to all my tests.

### Unit Tests 


These tests are used to feed in data to the system, run the program and then compare the results with the results expected (also added in) 
and the unit tests will tell you which tests passed and show the expected result against the actual results if failed

### Integration Tests 
Explain what these tests test, why and how to run them

This will test the whole project all togehter. This can be done by right clicking the package in the package explorer,
and selecting run as > junit test. This will then test everything all together and provide you with a breakdown of the 
tests that passed and failed. The failed tests will show you why in the junit console at the bottom of your screen

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

In order to make this easier for you, i have incuded a .jar file with the dependencies which should sort it all out for you.
The only issue you may have is with your MYSQL. If there is not already an ims database, you may need to create one for it to work. Furthermore, you may need to change the database properties 
so that it can connect to your sql as the current setup is to connect to my computer.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](http://github.com/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used - Chris Perrins and Jordan Harrison
* My trainer Nick for helping me when i was stuck
* Shafeeq for helping me with sql issues
