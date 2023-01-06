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




int main() {
	__mpy_builtins_setup();
	
	
	
	__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(5);
	__mpy_obj_ref_inc(ID: a);
	__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(3);
	__mpy_obj_ref_inc(ID: a);
	__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(1);
	__mpy_obj_ref_inc(ID: a);
	if (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_obj_init_boolean(true), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(5);
	__mpy_obj_ref_inc(ID: a);
	}else if (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_obj_init_boolean(false), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(3);
	__mpy_obj_ref_inc(ID: a);
	}else {
		__mpy_obj_ref_dec(ID: a);
	ID: a = __mpy_obj_init_int(1);
	__mpy_obj_ref_inc(ID: a);
	}
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
