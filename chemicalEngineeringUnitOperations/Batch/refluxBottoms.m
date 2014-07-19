[y10] = xlsread('batchData.xlsx','mlab','AN1:AN6');
[x10] = xlsread('batchData.xlsx','mlab','AO1:AO6');

[y7] = xlsread('batchData.xlsx','mlab','AR1:AR5');
[x7] = xlsread('batchData.xlsx','mlab','AS1:AS5');

[y4] = xlsread('batchData.xlsx','mlab','AV1:AV7');
[x4] = xlsread('batchData.xlsx','mlab','AW1:AW7');

plot(x10,y10,'*',x7,y7,'*',x4,y4,'*')