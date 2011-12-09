//////////////////////////////////////////////
// Camera and lights
//                                                     
// Remember to use "+UA" option for alpha output   
                                                       

#include "macros.inc"
                                                       
#declare WIDTH=1;                                                       

camera {
	orthographic        
	
	// camera position and direction  
	location <WIDTH/2,WIDTH/2,100>    
	direction <0,0, -1>             
	
	// length of up and right determines view size
	right <WIDTH,0,0>
	up <0,-WIDTH,0>

}      

light_source {
	<-100,-100,200>          
	color rgb <1,1,1>
	parallel
	point_at <0,0,0>
}                            

// ordinary finish:

#macro _shinyness ( _g1 )
finish {
 ambient 0
 diffuse min (1, (1.65 - _g1))
 specular _g1
 roughness 1 / pow (500, _g1)
 reflection { 0.5 * max ( 0, _g1 - 0.65 ), 2 * max ( 0, _g1 - 0.65 ) }
}
#end

// metal finish:

#macro _metal ( _g1 )
finish {
 ambient 0
 diffuse 1 - _g1
 specular _g1 * 2
 roughness 1 / pow (250, _g1)
 metallic
 reflection { _g1 / 2, _g1 metallic }
}
#end

#if (HIGHLIGHT)	
	#local Brass_color = color rgb <0.9, 0.712, 0.25>;
	#local Grey_color = color rgb <0.7, 0.7, 0.7>;
#else 
        #local Brass_color = color rgb <0.6, 0.412, 0.05>;
        #local Grey_color = color rgb <0.5, 0.5, 0.5>;
#end	              




#local Bump0 = normal {
 granite
 scale 5
 bump_size -0.1
    slope_map {
      [ 0 <0, 1> ]
      [ 0.3 <1, 0> ]
      [ 1 <1, 0> ]
    }
}
#local Bump1 = normal { bumps scale 0.25 bump_size 0.3 }
#local Bump2 = normal { bumps scale 5 bump_size 0.3 }

#declare CastMetal_normal = normal {
 average normal_map {
  [ 1 Bump0 ]
  [ 1 Bump1 ]
  [ 1 Bump2 ]
 }
}

#declare CastMetal_texture = texture {
 pigment { Brass_color }
 normal { CastMetal_normal }
 _metal (0.4) // the macro from original post
}                  

#declare GreyMetal_texture = texture {
 pigment { Grey_color }
 normal { CastMetal_normal }
 _metal (0.4) // the macro from original post
}      

#declare CastMetal_flat = texture {
 pigment { Brass_color } 
 normal {
 	bumps 0.05
 	scale <1,0.1,0.1>
 }
 _metal (0.4) // the macro from original post
}


         
#declare T_Brass=texture {
	pigment {
		color rgb <0.7,0.5,0.1>
	}
}         


