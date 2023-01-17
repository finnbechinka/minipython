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


__MPyObj *foo;
__MPyObj* func_foo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("foo", args, kwargs, 0);
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("ich bin eine Funktion"), __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("");
	retValue = __mpy_type_check(tmp_ret, __mpy_obj_init_int(1));
	goto ret;
	
	if (tmp_attr_obj != NULL){
		__mpy_obj_ref_dec(tmp_attr_obj);
	}
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}


int main() {
	__mpy_builtins_setup();
	
	foo = __mpy_obj_init_func(&func_foo);
	__mpy_obj_ref_inc(foo);
	
	
	
	
	__mpy_obj_ref_dec(foo);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
