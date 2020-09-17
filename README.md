Coverage: 34%
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



## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

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

* Hat tip to anyone whose code was used
* My trainer Nick for helping me when i was stuck
* Shafeeq for helping me with sql issues
