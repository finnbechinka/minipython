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

int main()
{
	__mpy_builtins_setup();
	a = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object_w_type("");
	__mpy_obj_ref_inc(b);

	a = __mpy_type_check(a, __mpy_obj_init_int(5));
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(b);
	b = a;
	a = __mpy_type_check(a, __mpy_obj_init_int(10));
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL));

	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);

	__mpy_builtins_cleanup();
	return 0;
}
