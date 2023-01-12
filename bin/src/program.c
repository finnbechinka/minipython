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

__MPyObj *obj;


__MPyObj *A;
__MPyObj* func_A___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 2);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__MPyObj *x = __mpy_args_get_positional(&argHelper, 1, "x");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *y = __mpy_obj_init_object();
	__mpy_obj_ref_inc(y);
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "y", x);
	__mpy_obj_ref_dec(self);
	__mpy_obj_ref_dec(x);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

int main() {
	__mpy_builtins_setup();
	obj = __mpy_obj_init_object();
	__mpy_obj_ref_inc(obj);
	
	
	A = __mpy_obj_init_type("A", __MPyType_Object);
	__mpy_obj_ref_inc(A);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_A___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(A, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	
	__mpy_obj_ref_dec(obj);
	obj = __mpy_call(A, __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(obj);
	
	__mpy_obj_ref_dec(obj);
	
	
	__mpy_obj_ref_dec(A);
	
	__mpy_builtins_cleanup();
	return 0;
}
