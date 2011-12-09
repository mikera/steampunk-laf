
#declare HIGHLIGHT=true;          
#declare PRESSED=false;     
  
 

#include "camera-lights.inc"



#declare EDGE=0.02;


#declare Rounded_Box = merge {
	box {<EDGE,EDGE,0>,<1-EDGE,1-EDGE,1>}
	merge {
		sphere {<EDGE,EDGE,0>,EDGE}
		sphere {<EDGE,1-EDGE,0>,EDGE}
		sphere {<1-EDGE,EDGE,0>,EDGE}
		sphere {<1-EDGE,1-EDGE,0>,EDGE}    
		cylinder {<EDGE,EDGE,0>,<EDGE,1-EDGE,0>,EDGE}
		cylinder {<EDGE,EDGE,0>,<1-EDGE,EDGE,0>,EDGE}
		cylinder {<1-EDGE,1-EDGE,0>,<EDGE,1-EDGE,0>,EDGE}
		cylinder {<1-EDGE,1-EDGE,0>,<1-EDGE,EDGE,0>,EDGE}
		translate <0,0,1-EDGE>
        }         
        translate <0,0,EDGE>
}



// boxes to cast shadow
union {
	box {<0,0,0> , <0,2,1>}        
	box {<0,0,0> , <2,0,1>}    
}
                     
object {
	Rounded_Box       
	
	texture {
		CastMetal_texture   
		scale 0.05
	}      
	
	#if (PRESSED) 
		translate <0,0.2*EDGE,-2*EDGE>
	#end
	
      
}                     