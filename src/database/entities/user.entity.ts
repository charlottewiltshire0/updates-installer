import {
  Column,
  CreateDateColumn,
  Entity,
  OneToMany,
  PrimaryGeneratedColumn,
  UpdateDateColumn,
} from 'typeorm';
import { TicketEntity } from './ticket.entity';
import { DeviceEntity } from './device.entity';
import { Exclude } from 'class-transformer';

export enum UserRole {
  ADMIN = 'admin',
  TESTER = 'tester',
  GHOST = 'ghost',
}

@Entity({ name: 'users' })
export class UserEntity {
  @PrimaryGeneratedColumn('uuid')
  id!: string;

  @Column({ type: 'varchar', nullable: false })
  username!: string;

  @Column({ type: 'varchar', length: 255, nullable: false, unique: true })
  email!: string;

  @Column({ type: 'varchar', nullable: false })
  @Exclude()
  password!: string;

  @Column({
    type: 'enum',
    enum: UserRole,
    default: UserRole.GHOST,
    nullable: false,
  })
  @Exclude()
  role: UserRole;

  @Column({ type: 'boolean', nullable: false, default: false })
  blocked!: boolean;

  @CreateDateColumn({
    type: 'timestamp',
    default: () => 'CURRENT_TIMESTAMP(6)',
  })
  created_at: Date;

  @UpdateDateColumn({
    type: 'timestamp',
    default: () => 'CURRENT_TIMESTAMP(6)',
    onUpdate: 'CURRENT_TIMESTAMP(6)',
  })
  updated_at: Date;

  @OneToMany(() => DeviceEntity, (device) => device.user)
  devices: DeviceEntity[];

  @OneToMany(() => TicketEntity, (ticket) => ticket.user)
  tickets: TicketEntity[];
}
