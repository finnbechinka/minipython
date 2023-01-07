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


__MPyObj *func1;
__MPyObj* func_func1(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("func1", args, kwargs, 1);
	__MPyObj *x = __mpy_args_get_positional(&argHelper, 0, "x");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, x, __mpy_obj_init_tuple(1)), NULL));
	
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
	
	func1 = __mpy_obj_init_func(&func_func1);
	__mpy_obj_ref_inc(func1);
	
	
	func1;
	__mpy_obj_ref_dec(__mpy_call(func1, __mpy_tuple_assign(0, __mpy_obj_init_str_static("wow"), __mpy_obj_init_tuple(1)), NULL));
	
	
	__mpy_obj_ref_dec(func1);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
