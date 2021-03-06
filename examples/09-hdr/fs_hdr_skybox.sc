$input v_texcoord0

/*
 * Copyright 2011-2013 Branimir Karadzic. All rights reserved.
 * License: http://www.opensource.org/licenses/BSD-2-Clause
 */

#include "common.sh"

SAMPLERCUBE(u_texCube, 0);
uniform mat4 u_mtx;

void main()
{
	vec3 dir = vec3(v_texcoord0*2.0 - 1.0, 1.0);
	dir = normalize(mul(u_mtx, vec4(dir, 0.0) ).xyz);
	gl_FragColor = encodeRGBE8(textureCube(u_texCube, dir).xyz);
}
