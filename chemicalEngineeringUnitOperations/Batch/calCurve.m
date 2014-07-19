[y] = xlsread('batchData.xlsx','mlab','A1:A11')
[x] = xlsread('batchData.xlsx','mlab','B1:B11')

e = linspace(.001,.001,11)

errorbar(y,x,e,'*')