[y10] = xlsread('batchData.xlsx','mlab','AE1:AE6');
[x10] = xlsread('batchData.xlsx','mlab','AD1:AD6');

[y7] = xlsread('batchData.xlsx','mlab','AF1:AF5');
[x7] = xlsread('batchData.xlsx','mlab','AG1:AG5');

[y4] = xlsread('batchData.xlsx','mlab','AK1:AK7');
[x4] = xlsread('batchData.xlsx','mlab','AJ1:AJ7');

plot(x10,y10,'*',x7,y7,'*',x4,y4,'*')