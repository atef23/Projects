[hA] = xlsread('heatExData.xlsx','finalData','E4:E8');
[heatLoss] =  xlsread('heatExData.xlsx','finalData','F4:F8');
[e] = [30 30 30 30 30];

errorbar(hA,heatLoss,e,'*');