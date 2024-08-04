export type CreateUserParams = {
  username: string;
  email: string;
  password: string;
};

export type UserDetails = {
  id: string;
  username: string;
  email: string;
  blocked: boolean;
  created_at: Date;
  updated_at: Date;
};
