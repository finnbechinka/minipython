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




int main() {
	__mpy_builtins_setup();
	
	
	
	__mpy_obj_ref_dec(a);
	a = __mpy_obj_init_int(5);
	__mpy_obj_ref_inc(a);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("CBuilder.Reference@2eafffde"), __mpy_obj_init_tuple(1)), NULL));
	
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
