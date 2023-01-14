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

int main()
{
	__mpy_builtins_setup();
	a = __mpy_obj_init_object();
	__mpy_obj_ref_inc(a);
	b = __mpy_obj_init_object();
	__mpy_obj_ref_inc(b);
	c = __mpy_obj_init_object();
	__mpy_obj_ref_inc(c);

	__mpy_obj_ref_dec(a);
	a = __mpy_obj_init_int(5);
	printf("%s\n", __mpy_type_name(__mpy_obj_init_int(5)->__MPyFunc_type));
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(b);
	b = __mpy_obj_init_str_static("haha");
	printf("%s\n", __mpy_type_name(__mpy_obj_init_str_static("haha")->__MPyFunc_type));
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(c);
	c = __mpy_obj_init_boolean(true);
	printf("%s\n", __mpy_type_name(__mpy_obj_init_boolean(true)->__MPyFunc_type));
	__mpy_obj_ref_inc(c);

	printf("%s\n", __mpy_type_name(a->__MPyFunc_type));
	printf("%s\n", __mpy_type_name(b->__MPyFunc_type));
	printf("%s\n", __mpy_type_name(c->__MPyFunc_type));

	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	__mpy_obj_ref_dec(c);

	__mpy_builtins_cleanup();
	return 0;
}
