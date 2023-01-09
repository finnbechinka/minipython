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
__MPyObj *jbo;
__MPyObj *cobj;
__MPyObj *x;


__MPyObj *A;
__MPyObj* func_A___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj* func_A_foo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("foo", args, kwargs, 2);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__MPyObj *x = __mpy_args_get_positional(&argHelper, 1, "x");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, x, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	__mpy_obj_ref_dec(x);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj *B;
__MPyObj* func_B___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj* func_B_moo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("moo", args, kwargs, 2);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__MPyObj *y = __mpy_args_get_positional(&argHelper, 1, "y");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, y, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	__mpy_obj_ref_dec(y);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj *C;
__MPyObj* func_C___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj* func_C_boo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("boo", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *x = __mpy_obj_init_object();
	__mpy_obj_ref_inc(x);
	__mpy_obj_ref_dec(x);
	x = __mpy_obj_init_int(0);
	__mpy_obj_ref_inc(x);
	while (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(x, "__lt__"), __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("boo"), __mpy_obj_init_tuple(1)), NULL));
		__mpy_obj_ref_dec(x);
	x = __mpy_call(__mpy_obj_get_attr(x, "__add__"), __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(x);
	}
	__mpy_obj_ref_dec(self);
	
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
	jbo = __mpy_obj_init_object();
	__mpy_obj_ref_inc(jbo);
	cobj = __mpy_obj_init_object();
	__mpy_obj_ref_inc(cobj);
	x = __mpy_obj_init_object();
	__mpy_obj_ref_inc(x);
	
	
	A = __mpy_obj_init_type("A", __MPyType_Object);
	__mpy_obj_ref_inc(A);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_A___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(A, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	{
		__MPyObj *foo;
		foo = __mpy_obj_init_func(&func_A_foo);
		__mpy_obj_ref_inc(foo);
		__mpy_obj_set_attr(A, "foo", foo);
		__mpy_obj_ref_dec(foo);
	}
	B = __mpy_obj_init_type("B", A);
	__mpy_obj_ref_inc(B);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_B___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(B, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	{
		__MPyObj *moo;
		moo = __mpy_obj_init_func(&func_B_moo);
		__mpy_obj_ref_inc(moo);
		__mpy_obj_set_attr(B, "moo", moo);
		__mpy_obj_ref_dec(moo);
	}
	C = __mpy_obj_init_type("C", B);
	__mpy_obj_ref_inc(C);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_C___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(C, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	{
		__MPyObj *boo;
		boo = __mpy_obj_init_func(&func_C_boo);
		__mpy_obj_ref_inc(boo);
		__mpy_obj_set_attr(C, "boo", boo);
		__mpy_obj_ref_dec(boo);
	}
	
	__mpy_obj_ref_dec(obj);
	obj = __mpy_call(A, __mpy_obj_init_tuple(0), NULL);
	__mpy_obj_ref_inc(obj);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj, "foo"), __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(jbo);
	jbo = __mpy_call(B, __mpy_obj_init_tuple(0), NULL);
	__mpy_obj_ref_inc(jbo);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(jbo, "moo"), __mpy_tuple_assign(0, __mpy_obj_init_str_static("moo"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(jbo, "foo"), __mpy_tuple_assign(0, __mpy_obj_init_str_static("foo"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(cobj);
	cobj = __mpy_call(C, __mpy_obj_init_tuple(0), NULL);
	__mpy_obj_ref_inc(cobj);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(cobj, "moo"), __mpy_tuple_assign(0, __mpy_obj_init_str_static("moo"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(cobj, "boo"), __mpy_obj_init_tuple(0), NULL));
	
	__mpy_obj_ref_dec(obj);
	__mpy_obj_ref_dec(jbo);
	__mpy_obj_ref_dec(cobj);
	__mpy_obj_ref_dec(x);
	
	
	__mpy_obj_ref_dec(A);
	__mpy_obj_ref_dec(B);
	__mpy_obj_ref_dec(C);
	
	__mpy_builtins_cleanup();
	return 0;
}
