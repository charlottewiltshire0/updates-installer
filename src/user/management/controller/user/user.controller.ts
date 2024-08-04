import {
  Body,
  ClassSerializerInterceptor,
  Controller,
  Delete,
  Get,
  Param,
  Patch,
  Post,
  UseInterceptors,
  ValidationPipe,
} from '@nestjs/common';
import { CreateUserDto } from '../../dto/create-user.dto';
import { UserService } from '../../service/user/user.service';

@Controller('/api/v1/users')
export class UserController {
  constructor(private userService: UserService) {}

  @UseInterceptors(ClassSerializerInterceptor)
  @Get()
  getListOfUsers() {
    return this.userService.getAll();
  }

  @Post()
  @UseInterceptors(ClassSerializerInterceptor)
  createUser(@Body(new ValidationPipe()) createUserDto: CreateUserDto) {
    return this.userService.create(createUserDto);
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
