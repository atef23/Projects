[hA] = xlsread('heatExData.xlsx','finalData','C13:C16');
[heatLoss] =  xlsread('heatExData.xlsx','finalData','D13:D16');
[e] = [30 30 30 30];

errorbar(hA,heatLoss,e,'*');