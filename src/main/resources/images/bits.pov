
#declare HIGHLIGHT=false;          
#declare PRESSED=false;     

#declare EDGE=0.01;  

#include "camera-lights.inc"

 

#declare Bit_Box = merge {
	box {<EDGE,EDGE,0>,<1/8-EDGE,1/8-EDGE,1>}
	merge {
		sphere {<EDGE,EDGE,0>,EDGE}
		sphere {<EDGE,1/8-EDGE,0>,EDGE}
		sphere {<1/8-EDGE,EDGE,0>,EDGE}
		sphere {<1/8-EDGE,1/8-EDGE,0>,EDGE}    
		cylinder {<EDGE,EDGE,0>,<EDGE,1/8-EDGE,0>,EDGE}
		cylinder {<EDGE,EDGE,0>,<1/8-EDGE,EDGE,0>,EDGE}
		cylinder {<1/8-EDGE,1/8-EDGE,0>,<EDGE,1/8-EDGE,0>,EDGE}
		cylinder {<1/8-EDGE,1/8-EDGE,0>,<1/8-EDGE,EDGE,0>,EDGE}  
		
		translate <0,0,1-EDGE>
        }                      
        
        translate <0,0,EDGE>
}       

#declare Bit_Border = merge {
	merge {
		sphere {<EDGE,EDGE,0>,EDGE}
		sphere {<EDGE,1/8-EDGE,0>,EDGE}
		sphere {<1/8-EDGE,EDGE,0>,EDGE}
		sphere {<1/8-EDGE,1/8-EDGE,0>,EDGE}    
		cylinder {<EDGE,EDGE,0>,<EDGE,1/8-EDGE,0>,EDGE}
		cylinder {<EDGE,EDGE,0>,<1/8-EDGE,EDGE,0>,EDGE}
		cylinder {<1/8-EDGE,1/8-EDGE,0>,<EDGE,1/8-EDGE,0>,EDGE}
		cylinder {<1/8-EDGE,1/8-EDGE,0>,<1/8-EDGE,EDGE,0>,EDGE}  
		
		translate <0,0,1-EDGE>
        }                      
        
        translate <0,0,EDGE>
}          

#declare Bit_Circle = merge {
	torus {
		(1/16-EDGE), EDGE	
		rotate x*90
	}                  
        
        translate <1/16,1/16,EDGE>
}

// arrow in positive x direction, centred at origin, length 0.1

#declare Arrow = merge {
	cone { <1, 0, 0>, 0, <0.2,0,0>,0.5}    
	cone { <0.2, 0, 0>, 0.20, <-0.8,0,0>,0.2}    
	
	scale <0.05,0.05,0.03>
}                 

#declare Arrow_Button = merge {
	object {Bit_Box}
	object {Arrow translate <1/16,1/16,1+EDGE>}
}           


#declare Cross_Part = intersection {
	cone { <1, 1, 0>, 0.1, <-1,-1,0>,0.6}    
	plane {<-1,0,0>,0}    
	plane {<0,-1,0>,0}    
}         

#declare Cross= union {
	union {
		Revolve(Cross_Part,90*z,4)     
		scale 0.5	
		scale <0.1,0.1,0.2>
		translate <1/16,1/16,1+EDGE>  
	}   
}         

#declare Radio_Globe= union {
	sphere {     
		<0,0,0>,1
	}
	scale 0.35	
	scale <0.1,0.1,0.1>
	translate <1/16,1/16,1+EDGE>    
}   
          
    




// boxes to cast shadow
union {
	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <0/8,0/8,0> 
	}     
	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <1/8,1/8,0> 
	}
	
	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <2/8,2/8,0> 
	}
		
	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <3/8,3/8,0> 
	}
		
	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <4/8,4/8,0> 
	}

	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <5/8,5/8,0> 
	}

	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <6/8,6/8,0> 
	}

	union {
		box {<0,-2,0> , <0,2,1>}        
		box {<-2,0,0> , <2,0,1>} 
		translate <7/8,7/8,0> 
	}

  
}

                     
union {
	union {
		object {Arrow_Button}         
		object {Arrow_Button rotate z*90}         
		translate <1/8,0,0> 
	} 
	union {
		object {Arrow_Button rotate z*180}         
		object {Arrow_Button rotate z*270}         
		translate <3/8,1/8,0>
	} 
	
	#if (PRESSED) 
		translate <0,0.2*EDGE,-2*EDGE>
	#end          
	
	texture {
		CastMetal_texture   
		scale 0.05
	}      
	
}  

#declare Button_Bits = union {   
	// check box
	union {
		object {Cross}
		object {Bit_Border}
		translate <4/8,0/8,1>
	}    
	
	union {
		object {Bit_Border}
		translate <5/8,0/8,1>
	}  
	
	// radio button
	union {
		object {Bit_Circle}
		object {Radio_Globe} 
		
		translate <6/8,0/8,1>
	}       
	
	// radio button
	union {
		object {Bit_Circle}
		translate <7/8,0/8,1>
	}
	

}    	           

union {	
        object {
        	Button_Bits 
        	translate <0,0,0>
       	}
       	       	
	texture {
		CastMetal_texture   
		scale 0.05
	}    
}           

union {	
        object {
        	Button_Bits 
        	translate <0,1/8,0>
       	}
       	
	texture {
		GreyMetal_texture   
		scale 0.05
	}    
}         