[heatLoss] = xlsread('heatExData.xlsx','finalData','L3:L7');
[U] =  xlsread('heatExData.xlsx','finalData','K3:K7');
[e] = [500 500 500 500 500];

errorbar(U,heatLoss,e,'*');