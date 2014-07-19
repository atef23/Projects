[waterFlow] = xlsread('heatExData.xlsx','finalData','I3:I7');
[U] =  xlsread('heatExData.xlsx','finalData','K3:K7');
[e] = [500 500 500 500 500];

errorbar(waterFlow,U,e,'*');