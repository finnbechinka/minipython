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
__MPyObj *c;
__MPyObj *d;
__MPyObj *e;
__MPyObj *f;



int main() {
	__mpy_builtins_setup();
	a = __mpy_obj_init_object();
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object();
	__mpy_obj_ref_inc(b);
	c = __mpy_obj_init_object();
	__mpy_obj_ref_inc(c);
	d = __mpy_obj_init_object();
	__mpy_obj_ref_inc(d);
	e = __mpy_obj_init_object();
	__mpy_obj_ref_inc(e);
	f = __mpy_obj_init_object();
	__mpy_obj_ref_inc(f);
	
	
	
	__mpy_obj_ref_dec(a);
	a = __mpy_obj_init_int(2);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(b);
	b = __mpy_obj_init_int(2);
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(c);
	c = __mpy_call(__mpy_obj_get_attr(a, "__add__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(c);
	__mpy_obj_ref_dec(d);
	d = __mpy_call(__mpy_obj_get_attr(a, "__sub__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(d);
	__mpy_obj_ref_dec(e);
	e = __mpy_call(__mpy_obj_get_attr(a, "__div__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(e);
	__mpy_obj_ref_dec(f);
	f = __mpy_call(__mpy_obj_get_attr(a, "__mul__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(f);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, c, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, d, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, e, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, f, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	__mpy_obj_ref_dec(c);
	__mpy_obj_ref_dec(d);
	__mpy_obj_ref_dec(e);
	__mpy_obj_ref_dec(f);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
