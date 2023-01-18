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
__MPyObj *obj;

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
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, y, __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("num");
	retValue = __mpy_type_check(tmp_ret, x);
	goto ret;
	
	__mpy_obj_ref_dec(x);
	__mpy_obj_ref_dec(y);
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
__MPyObj *moo;
__MPyObj* func_moo(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("moo", args, kwargs, 1);
	__MPyObj *x = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(x);
	x = __mpy_type_check(x, __mpy_args_get_positional(&argHelper, 0, "x"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, x, __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("bool");
	retValue = __mpy_type_check(tmp_ret, x);
	goto ret;
	
	__mpy_obj_ref_dec(x);
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

__MPyObj *A;
__MPyObj* func_A___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 4);
	__MPyObj *self = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(self);
	self = __mpy_type_check(self, __mpy_args_get_positional(&argHelper, 0, "self"));
	__MPyObj *x = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(x);
	x = __mpy_type_check(x, __mpy_args_get_positional(&argHelper, 1, "x"));
	__MPyObj *y = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(y);
	y = __mpy_type_check(y, __mpy_args_get_positional(&argHelper, 2, "y"));
	__MPyObj *z = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(z);
	z = __mpy_type_check(z, __mpy_args_get_positional(&argHelper, 3, "z"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "number", x);
	tmp_attr_obj = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(tmp_attr_obj);
	tmp_attr_obj = __mpy_type_check(tmp_attr_obj, y);
	__mpy_obj_ref_inc(tmp_attr_obj);
	__mpy_obj_set_attr(self, "number2", tmp_attr_obj);
	tmp_attr_obj = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(tmp_attr_obj);
	tmp_attr_obj = __mpy_type_check(tmp_attr_obj, z);
	__mpy_obj_ref_inc(tmp_attr_obj);
	__mpy_obj_set_attr(self, "number3", tmp_attr_obj);
	
	__mpy_obj_ref_dec(self);
	__mpy_obj_ref_dec(x);
	__mpy_obj_ref_dec(y);
	__mpy_obj_ref_dec(z);
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
__MPyObj* func_A_test(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("test", args, kwargs, 1);
	__MPyObj *self = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(self);
	self = __mpy_type_check(self, __mpy_args_get_positional(&argHelper, 0, "self"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number2"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number3"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "number2", __mpy_obj_init_int(42));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number2"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number3"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "number", __mpy_obj_init_int(10));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "number2", __mpy_obj_init_boolean(false));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number2"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_set_attr(self, "number", __mpy_obj_init_str_static("string"));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_get_attr(self, "number"), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
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
	ret = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(ret);
	obj = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(obj);
	
	foo = __mpy_obj_init_func(&func_foo);
	__mpy_obj_ref_inc(foo);
	moo = __mpy_obj_init_func(&func_moo);
	__mpy_obj_ref_inc(moo);
	
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
		__MPyObj *test;
		test = __mpy_obj_init_func(&func_A_test);
		__mpy_obj_ref_inc(test);
		__mpy_obj_set_attr(A, "test", test);
		__mpy_obj_ref_dec(test);
	}
	
	ret = __mpy_type_check(ret, __mpy_call(foo, __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_tuple_assign(1, __mpy_obj_init_str_static("bar"), __mpy_obj_init_tuple(2))), NULL));
	__mpy_obj_ref_inc(ret);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("ret"), __mpy_tuple_assign(1, ret, __mpy_obj_init_tuple(2))), NULL));
	obj = __mpy_type_check(obj, __mpy_call(A, __mpy_tuple_assign(0, __mpy_obj_init_int(5), __mpy_tuple_assign(1, __mpy_obj_init_int(6), __mpy_tuple_assign(2, __mpy_obj_init_int(7), __mpy_obj_init_tuple(3)))), NULL));
	__mpy_obj_ref_inc(obj);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj, "test"), __mpy_obj_init_tuple(0), NULL));
	
	__mpy_obj_ref_dec(ret);
	__mpy_obj_ref_dec(obj);
	
	__mpy_obj_ref_dec(foo);
	__mpy_obj_ref_dec(moo);
	
	__mpy_obj_ref_dec(A);
	
	__mpy_builtins_cleanup();
	return 0;
}
