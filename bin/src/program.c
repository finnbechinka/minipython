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
__MPyObj *obj2;
__MPyObj *obj3;


__MPyObj *A;
__MPyObj* func_A___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	__mpy_type_check(__mpy_obj_get_attr(self, "x"),__mpy_obj_init_int(42));
	__mpy_obj_set_attr(self, "x", __mpy_obj_init_int(42));
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
	
	__MPyGetArgsState argHelper = __mpy_args_init("foo", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_type_check(__mpy_obj_get_attr(self, "x"),__mpy_obj_init_str_static("fourtytwo"));
	__mpy_obj_set_attr(self, "x", __mpy_obj_init_str_static("fourtytwo"));
	__mpy_obj_ref_dec(self);
	
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
	
	__MPyGetArgsState argHelper = __mpy_args_init("moo", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "x"), __mpy_obj_init_tuple(1)), NULL));
	
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
	obj = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(obj);
	obj2 = __mpy_obj_init_object_w_type("A");
	__mpy_obj_ref_inc(obj2);
	obj3 = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(obj3);
	
	
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
	
	__mpy_obj_ref_dec(obj);
	obj = __mpy_type_check(obj,__mpy_call(A, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_inc(obj);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj, "foo"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(obj2);
	obj2 = __mpy_type_check(obj2,__mpy_call(A, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_inc(obj2);
	__mpy_obj_ref_dec(obj3);
	obj3 = __mpy_type_check(obj3,__mpy_call(B, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_inc(obj3);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj3, "moo"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj3, "foo"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj3, "moo"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(obj2);
	obj2 = __mpy_type_check(obj2,__mpy_call(B, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_inc(obj2);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj2, "moo"), __mpy_obj_init_tuple(0), NULL));
	
	__mpy_obj_ref_dec(obj);
	__mpy_obj_ref_dec(obj2);
	__mpy_obj_ref_dec(obj3);
	
	
	__mpy_obj_ref_dec(A);
	__mpy_obj_ref_dec(B);
	
	__mpy_builtins_cleanup();
	return 0;
}
