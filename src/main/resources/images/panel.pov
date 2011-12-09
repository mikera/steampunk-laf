
#declare HIGHLIGHT=false;          
#declare PRESSED=false;     



#declare EDGE=0.005;  
#declare RIVET_RADIUS=0.008;
#declare RIVET_AREA=0.012;     
#declare RIVET_COUNT=25;          
#declare RIVET_GAP=(1-(2*RIVET_AREA*RIVET_COUNT)) / (RIVET_COUNT-1);     
  
 

#include "camera-lights.inc"

                      
                      
#declare Rivet = object {
	sphere {<0,0,0>,RIVET_RADIUS   }
}                      
                      
#declare Rivet_Line =union {
	#local I=0;
	#while (I<RIVET_COUNT)   
	        object {Rivet translate <RIVET_AREA+I*(RIVET_GAP+RIVET_AREA*2),RIVET_AREA,0>}
	
		#local I=I+1;	
	#end 
        translate <-0.5,-0.5,0>
}


#declare Rivets = union {
	object {Rivet_Line }      
	object {Rivet_Line rotate 90*z }    
	object {Rivet_Line rotate 180*z }
	object {Rivet_Line rotate 270*z }   
	translate <0.5,0.5,1+EDGE>
}

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



                     
union {
	object {Rounded_Box}
	object {Rivets}
	
	texture {
		CastMetal_texture   
		scale 0.05
	}      
	
	#if (PRESSED) 
		translate <0,0.2*EDGE,-2*EDGE>
	#end
	
      
}                     