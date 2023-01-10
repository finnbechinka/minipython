#include <stddef.h>

#include "assert.h"
#include "mpy_aliases.h"
#include "mpy_obj.h"
#include "builtins-setup.h"
#include "function-args.h"
#include "literals/tuple.h"
#include "literals/int.h"
#include "literals/boolean.h"
#include "literals/str.h"
#include "type-hierarchy/object.h"
#include "type-hierarchy/type.h"

__MPyObj *c;



int main() {
	__mpy_builtins_setup();
	c = __mpy_obj_init_object();
	__mpy_obj_ref_inc(c);
	
	
	
	__mpy_obj_ref_dec(c);
	c = __mpy_obj_init_str_static("clemens");
	__mpy_obj_ref_inc(c);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, c, __mpy_tuple_assign(1, __mpy_obj_init_str_static("ist ein h"), __mpy_obj_init_tuple(2))), NULL));
	
	__mpy_obj_ref_dec(c);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
