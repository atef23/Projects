[y10] = xlsread('batchData.xlsx','mlab','T1:T6')
[x10] = xlsread('batchData.xlsx','mlab','U1:U6');

[y7] = xlsread('batchData.xlsx','mlab','W1:W5');
[x7] = xlsread('batchData.xlsx','mlab','X1:X5');

[y4] = xlsread('batchData.xlsx','mlab','Z1:Z7');
[x4] = xlsread('batchData.xlsx','mlab','AA1:AA7');

plot(x10,y10,'*',x7,y7,'*',x4,y4,'*')