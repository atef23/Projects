classdef calibrationMethods
    
    methods (Static)
        
        function [obj] = copperCal(index)
            
            obj = 1.5756*index - .0812;
            
        end
        
        function [obj] = copperPumpCal(pumpSetting)
            
            obj = .9833*pumpSetting - .5911;
            
        end
        
        function [obj] = LIXPumpCal(pumpSetting)
            
            obj = 1.125*pumpSetting - .2889;
            
        end
        
    end


end

