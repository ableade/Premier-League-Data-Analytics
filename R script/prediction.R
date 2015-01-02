#Goal superiority linear regression modelling
#author: Sola Adekunle
league.tables = read.csv(url('https://raw.githubusercontent.com/lesfleurs/fbmodelling/master/final%20data/data.csv'))

#fit match ratings to home wins percentage
home_fit <- lm(home.win.pct ~Match.rating , league.tables)
away_fit <- lm(away.win.pct ~Match.rating , league.tables)
draw_fit <- lm(draw.pct ~Match.rating, league.tables)

summary(home_fit)
summary(away_fit)
summary(draw_fit)

newdata = data.frame(Match.rating=0)
predict(home_fit, newdata); predict(away_fit, newdata); predict(draw_fit, newdata)

