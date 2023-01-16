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

__MPyObj *b;
__MPyObj *c;
__MPyObj *a;

__MPyObj *sum;
__MPyObj* func_sum(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("sum", args, kwargs, 1);
	__MPyObj *x = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(x);
	x = __mpy_type_check(x, __mpy_args_get_positional(&argHelper, 0, "x"));
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *a = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(a);
	a = __mpy_type_check(a, __mpy_call(__mpy_obj_get_attr(__mpy_obj_init_int(1), "__add__"), __mpy_tuple_assign(0, x, __mpy_obj_init_tuple(1)), NULL));
	__MPyObj *tmp_ret = __mpy_obj_init_object_w_type("");
	retValue = __mpy_type_check(tmp_ret, a);
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
	b = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(b);
	c = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(c);
	a = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(a);
	
	sum = __mpy_obj_init_func(&func_sum);
	__mpy_obj_ref_inc(sum);
	
	
	__mpy_obj_ref_dec(__mpy_call(sum, __mpy_tuple_assign(0, __mpy_obj_init_int(2), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(b);
	b = __mpy_type_check(b, __mpy_obj_init_int(2));
	__mpy_obj_ref_inc(c);
	__mpy_obj_ref_dec(c);
	c = __mpy_type_check(c, __mpy_obj_init_str_static("KaNsNsT dU maL meHreRe VaRiabLEn BenUtzEN?"));
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(a);
	a = __mpy_type_check(a, __mpy_call(input, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, a, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(b);
	__mpy_obj_ref_dec(c);
	__mpy_obj_ref_dec(a);
	
	__mpy_obj_ref_dec(sum);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
