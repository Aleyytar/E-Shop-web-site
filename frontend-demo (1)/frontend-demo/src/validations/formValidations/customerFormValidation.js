import * as yup from "yup";

export const registerCustomerSchema = yup.object().shape({
  firstName: yup.string().required().min(3),
  lastName: yup.string().required().min(3),
  email: yup.string().required().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
  phoneNumber: yup.string().required().min(11).max(11),
  username: yup.string().required(),
  password: yup.string().required().min(3),
  confirmPassword: yup.string().required().oneOf([yup.ref("password"), null]),
});

export const loginCustomerSchema = yup.object({
  email: yup.string().required().email().min(5),
  password: yup.string().required(),
});


export const updateCustomerSchema = yup.object().shape({
  firstName: yup.string().required().min(3),
  lastName: yup.string().required().min(3),
  accountEmail: yup.string().required().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
  accountPhoneNumber: yup.string().required().min(11).max(11),
  accountUsername: yup.string().required(),
  accountPassword: yup.string().required().min(3),
  accountConfirmPassword: yup.string().required().oneOf([yup.ref("accountPassword"), null],"Password fields should be matched"),
});
