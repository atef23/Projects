[xe] = xlsread('batchData.xlsx','mlab','A16:A30');
[ye] = xlsread('batchData.xlsx','mlab','B16:B30');

y105 = .9091*xe + .027;
y104 = .9091*xe + .028;

y45 = xe;

plot(xe,ye,xe,y105,xe,y104,xe,y45)