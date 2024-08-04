import { BadRequestException, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { UserEntity } from '@/src/database/entities/user.entity';
import { Repository } from 'typeorm';
import { CreateUserParams, UserDetails } from '@/src/utils/types';
import * as argon2 from 'argon2';

@Injectable()
export class UserService {
  constructor(
    @InjectRepository(UserEntity)
    private readonly userRepository: Repository<UserEntity>,
  ) {}

  async create(createUserParams: CreateUserParams): Promise<UserDetails> {
    const existUser = await this.userRepository.findOne({
      where: [
        { username: createUserParams.username },
        { email: createUserParams.email },
      ],
    });
    if (existUser) throw new BadRequestException(`User already exists`);

    const hashedPassword = await argon2.hash(createUserParams.password);

    return await this.userRepository.save({
      ...createUserParams,
      password: hashedPassword,
    });
  }

  async getAll(): Promise<UserEntity[]> {
    return await this.userRepository.find();
  }
}
