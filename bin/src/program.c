#include <stddef.h>
#include <stdio.h>

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

int main()
{
	__mpy_builtins_setup();
	a = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(b);

	printf("here\n");
	__mpy_obj_ref_dec(a);
	printf("here\n");
	__mpy_type_check(a, __mpy_obj_init_int(5));
	printf("here\n");
	a = __mpy_obj_init_int(5);
	printf("here\n");
	__mpy_obj_ref_inc(a);
	printf("here\n");
	__mpy_obj_ref_dec(b);
	printf("here\n");
	__mpy_type_check(b, __mpy_obj_init_int(2));
	printf("here\n");
	b = __mpy_obj_init_int(2);
	printf("here\n");
	__mpy_obj_ref_inc(b);
	printf("here\n");
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, a, __mpy_obj_init_tuple(1)), NULL));
	printf("here\n");
	__mpy_obj_ref_inc(b);
	printf("here\n");
	__mpy_obj_ref_dec(a);
	printf("here\n");
	__mpy_type_check(a, b);
	printf("here\n");
	a = b;
	printf("here\n");
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL));
	printf("here\n");
	__mpy_obj_ref_dec(a);
	printf("here\n");
	__mpy_obj_ref_dec(b);
	printf("here\n");

	__mpy_builtins_cleanup();
	return 0;
}
