import { Controller, Delete, Get, Param, Patch } from '@nestjs/common';

@Controller('/api/v1/users')
export class UserController {
  @Get()
  getListOfUsers() {
    console.log('123');
  }

  @Get('/:id')
  getUserDetails(@Param() id: string) {
    console.log(id);
  }

  @Delete('/:id')
  deleteUserByUserId(@Param() id: string) {
    console.log(id);
  }

  @Patch('/:id')
  updateUserFields(@Param() id: string) {
    console.log(id);
  }
}
