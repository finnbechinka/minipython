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

__MPyObj *getfive;
__MPyObj *func_getfive(__MPyObj *args, __MPyObj *kwargs)
{
	assert(args != NULL && kwargs != NULL);

	__MPyGetArgsState argHelper = __mpy_args_init("getfive", args, kwargs, 0);
	__mpy_args_finish(&argHelper);

	__MPyObj *retValue = NULL;

	goto ret;
ret:
	if (retValue == NULL)
	{
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

int main()
{
	__mpy_builtins_setup();
	a = __mpy_obj_init_object();
	__mpy_obj_ref_inc(a);

	getfive = __mpy_obj_init_func(&func_getfive);
	__mpy_obj_ref_inc(getfive);

	__mpy_obj_ref_dec(a);
	printf("%s", __mpy_type_name(__mpy_call(getfive, __mpy_obj_init_tuple(0), NULL)->__MPyFunc_type));
	a = __mpy_call(getfive, __mpy_obj_init_tuple(0), NULL);
	__mpy_obj_ref_inc(a);

	__mpy_obj_ref_dec(a);

	__mpy_obj_ref_dec(getfive);

	__mpy_builtins_cleanup();
	return 0;
}
