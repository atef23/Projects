[TLM] =  xlsread('heatExData.xlsx','finalData','J23:J34');
[U] =  xlsread('heatExData.xlsx','finalData','K23:K34');
[e] = [1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000];

errorbar(TLM,U,e,'*');