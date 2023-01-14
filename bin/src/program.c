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
__MPyObj *c;
__MPyObj *f;

int main()
{
	__mpy_builtins_setup();
	a = __mpy_obj_init_object();
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object();
	__mpy_obj_ref_inc(b);
	c = __mpy_obj_init_object();
	__mpy_obj_ref_inc(c);
	f = __mpy_obj_init_object();
	__mpy_obj_ref_inc(f);

	__mpy_obj_ref_dec(a);
	a = __mpy_obj_init_int(10);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(f);
	f = __mpy_obj_init_int(2);
	__mpy_obj_ref_inc(f);
	__mpy_obj_ref_inc(f);
	__mpy_obj_ref_dec(a);
	printf("%s", __mpy_type_name(f->__MPyFunc_type));
	a = f->__MPyFunc_type;

	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	__mpy_obj_ref_dec(c);
	__mpy_obj_ref_dec(f);

	__mpy_builtins_cleanup();
	return 0;
}
