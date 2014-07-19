[tIn] = xlsread('heatExData.xlsx','ferm','C2:C18');
[volIn] = xlsread('heatExData.xlsx','ferm','I2:I18');
[tOut] = xlsread('heatExData.xlsx','ferm','E2:E18');
[volOut] = xlsread('heatExData.xlsx','ferm','J2:J18');
[e] = [.5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5 .5];

plot(tIn,volIn,'*',tOut,volOut,'*');
