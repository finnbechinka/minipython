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
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
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
__MPyObj* func_A_method_a(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("method_a", args, kwargs, 1);
	__MPyObj *self = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(self);
	self = __mpy_type_check(self, __mpy_args_get_positional(&argHelper, 0, "self"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("method a"), __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("");
	retValue = __mpy_type_check(tmp_ret, __mpy_obj_init_int(0));
	goto ret;
	
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
__MPyObj *B;
__MPyObj* func_B___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
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
__MPyObj* func_B_method_b(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("method_b", args, kwargs, 1);
	__MPyObj *self = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(self);
	self = __mpy_type_check(self, __mpy_args_get_positional(&argHelper, 0, "self"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *tmp_attr_obj = NULL;
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(self, "method_a"), __mpy_obj_init_tuple(0), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("");
	retValue = __mpy_type_check(tmp_ret, __mpy_obj_init_int(0));
	goto ret;
	
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
	obj = __mpy_obj_init_object_w_type("");
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
	{
		__MPyObj *method_a;
		method_a = __mpy_obj_init_func(&func_A_method_a);
		__mpy_obj_ref_inc(method_a);
		__mpy_obj_set_attr(A, "method_a", method_a);
		__mpy_obj_ref_dec(method_a);
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
		__MPyObj *method_b;
		method_b = __mpy_obj_init_func(&func_B_method_b);
		__mpy_obj_ref_inc(method_b);
		__mpy_obj_set_attr(B, "method_b", method_b);
		__mpy_obj_ref_dec(method_b);
	}
	
	obj = __mpy_type_check(obj, __mpy_call(B, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_inc(obj);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj, "method_b"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(obj, "method_a"), __mpy_obj_init_tuple(0), NULL));
	
	__mpy_obj_ref_dec(obj);
	
	
	__mpy_obj_ref_dec(A);
	__mpy_obj_ref_dec(B);
	
	__mpy_builtins_cleanup();
	return 0;
}
