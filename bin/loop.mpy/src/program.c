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

__MPyObj *x;
__MPyObj *y;
__MPyObj *x;



int main() {
	__mpy_builtins_setup();
	x = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(x);
	y = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(y);
	x = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(x);
	
	
	
	__mpy_obj_ref_inc(x);
	__mpy_obj_ref_dec(x);
	x = __mpy_type_check(x, __mpy_obj_init_int(10));
	__mpy_obj_ref_inc(y);
	__mpy_obj_ref_dec(y);
	y = __mpy_type_check(y, __mpy_obj_init_int(4));
	while (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(x, "__gt__"), __mpy_tuple_assign(0, y, __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, x, __mpy_tuple_assign(1, __mpy_obj_init_str_static("is bigger than "), __mpy_tuple_assign(2, y, __mpy_obj_init_tuple(3)))), NULL));
		__mpy_obj_ref_inc(x);
	__mpy_obj_ref_dec(x);
	x = __mpy_type_check(x, __mpy_call(__mpy_obj_get_attr(x, "__sub__"), __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_obj_init_tuple(1)), NULL));
	}
	__mpy_obj_ref_dec(x);
	__mpy_obj_ref_dec(y);
	__mpy_obj_ref_dec(x);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
