[hotTemp] = xlsread('heatExData.xlsx','finalData','C4:C8');
[hA] =  xlsread('heatExData.xlsx','finalData','E4:E8');
[e] = [30 30 30 30 30];

errorbar(hotTemp,hA,e,'*');