[coldFlow] = xlsread('heatExData.xlsx','finalData','A13:A16');
[hA] =  xlsread('heatExData.xlsx','finalData','C13:C16');
[e] = [30 30 30 30];

errorbar(coldFlow,hA,e,'*');