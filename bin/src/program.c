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

__MPyObj *ret;

__MPyObj *foo;
__MPyObj* func_foo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("foo", args, kwargs, 2);
	__MPyObj *x = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(x);
	x = __mpy_type_check(x, __mpy_args_get_positional(&argHelper, 0, "x"));
	__MPyObj *y = __mpy_obj_init_object_w_type("str");
	__mpy_obj_ref_inc(y);
	y = __mpy_type_check(y, __mpy_args_get_positional(&argHelper, 1, "y"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, y, __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("num");
	retValue = __mpy_type_check(tmp_ret, x);
	goto ret;
	
	__mpy_obj_ref_dec(x);
	__mpy_obj_ref_dec(y);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj *moo;
__MPyObj* func_moo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("moo", args, kwargs, 1);
	__MPyObj *x = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(x);
	x = __mpy_type_check(x, __mpy_args_get_positional(&argHelper, 0, "x"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, x, __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("bool");
	retValue = __mpy_type_check(tmp_ret, x);
	goto ret;
	
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
	ret = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(ret);
	
	foo = __mpy_obj_init_func(&func_foo);
	__mpy_obj_ref_inc(foo);
	moo = __mpy_obj_init_func(&func_moo);
	__mpy_obj_ref_inc(moo);
	
	
	__mpy_obj_ref_inc(ret);
	__mpy_obj_ref_dec(ret);
	ret = __mpy_type_check(ret, __mpy_call(foo, __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_tuple_assign(1, __mpy_obj_init_str_static("bar"), __mpy_obj_init_tuple(2))), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, ret, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(moo, __mpy_tuple_assign(0, __mpy_obj_init_int(42), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(ret);
	
	__mpy_obj_ref_dec(foo);
	__mpy_obj_ref_dec(moo);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
