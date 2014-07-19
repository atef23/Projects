classdef extractionMethods
    
    methods (Static)
        
        function [obj] = rotameterToFlux(reading)
            
            obj = 1.5756*index - .0812;
            
        end
        
        function [obj] = copperPumpCal(pumpSetting)
            
            obj = .9833*pumpSetting - .5911;
            
        end
        
    end
    
end

