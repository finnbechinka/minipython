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

__MPyObj *a;
__MPyObj *b;



int main() {
	__mpy_builtins_setup();
	a = __mpy_obj_init_object();
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object();
	__mpy_obj_ref_inc(b);
	
	
	
	__mpy_obj_ref_dec(a);
	a = __mpy_obj_init_boolean(true);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(b);
	b = __mpy_obj_init_boolean(false);
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(a, "__eq__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(a, "__ne__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(__mpy_obj_init_int(1), "__ge__"), __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(__mpy_obj_init_int(1), "__gt__"), __mpy_tuple_assign(0, __mpy_obj_init_int(0), __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_boolean(!__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(a, "__bool__"), __mpy_obj_init_tuple(0), NULL))), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_boolean(__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(a, "__bool__"), __mpy_obj_init_tuple(0), NULL)) && __mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(b, "__bool__"), __mpy_obj_init_tuple(0), NULL))), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_boolean(__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(a, "__bool__"), __mpy_obj_init_tuple(0), NULL)) || __mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(b, "__bool__"), __mpy_obj_init_tuple(0), NULL))), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
