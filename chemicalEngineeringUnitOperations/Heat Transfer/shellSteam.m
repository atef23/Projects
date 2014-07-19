[steamFlow] = xlsread('heatExData.xlsx','finalData','J13:J18');
[U] =  xlsread('heatExData.xlsx','finalData','K13:K18');
[e] = [500 500 500 500 500 500];

errorbar(steamFlow,U,e,'*');