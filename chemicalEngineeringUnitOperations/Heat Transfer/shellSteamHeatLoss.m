[U] =  xlsread('heatExData.xlsx','finalData','K13:K18');
[heatLoss] =  xlsread('heatExData.xlsx','finalData','L13:L18');
[e] = [1000 1000 1000 1000 1000 1000];

errorbar(U,heatLoss,e,'*');