[y105] = xlsread('batchData.xlsx','mlab','N1:N6')
[x105] = xlsread('batchData.xlsx','mlab','M1:M6')

[y104] = xlsread('batchData.xlsx','mlab','Q1:Q4')
[x104] = xlsread('batchData.xlsx','mlab','P1:P4')



plot(x105,y105,'*',x104,y104,'*')