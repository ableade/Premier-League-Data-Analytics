fbmodelling
===========

a predictive model for premier league soccer games

This is a predictive model for games played in any major soccer league
using a variation of a popular soccer betting strategy.
The main score metric used here is a match rating which is a measure of the goal superiority of two teams.
To calculate the match rating we take the difference of the goal difference of the home side and the away side for the 
last k games they have played in that particular season. The value chosen for k in this model is 6. 

We gather all outcomes for all match ratings we encounter and we use this to form a linear regression model. 

Our linear regression model is done in r using csv files generated from raw data preporcessing. I have included the java preprocessor
under the fb modelling java project. Data used for this experiment was obtained from the following repo by geraldb. This repo has the nice 
property of having all the matches already sorted by the date. The format of the csv files within this repo https://github.com/footballcsv is the same convention
our jarver parser expects to create the final csv for our R script.

Below is an image generated in R of all the match ratings obtained from the match ratings we genrated.
You can recognize the shape of the normal distribution.


![alt tag](https://raw.github.com/lesfleurs/fbmodelling/master/img/match distribiton.png)