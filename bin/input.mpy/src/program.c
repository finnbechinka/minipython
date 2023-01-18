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



int main() {
	__mpy_builtins_setup();
	a = __mpy_obj_init_object_w_type("num");
	__mpy_obj_ref_inc(a);
	
	
	
	a = __mpy_type_check(a, __mpy_obj_init_int(5));
	__mpy_obj_ref_inc(a);
	a = __mpy_type_check(a, __mpy_obj_init_boolean(true));
	__mpy_obj_ref_inc(a);
	
	__mpy_obj_ref_dec(a);
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
