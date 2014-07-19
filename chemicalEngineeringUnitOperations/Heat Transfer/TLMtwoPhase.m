[TLM] =  xlsread('heatExData.xlsx','finalData','J37:J44');
[U] =  xlsread('heatExData.xlsx','finalData','K37:K44');
[e] = [1000 1000 1000 1000 1000 1000 1000 1000];

errorbar(TLM,U,e,'*');