import * as yup from "yup";

export const registerCompanySchema = yup.object().shape({
  companyName: yup.string().required().min(3),
  email: yup.string().required().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$","Email is not validated"),
  phoneNumber: yup.string().required().min(11).max(11),
  username: yup.string().required().min(3),
  password: yup.string().required().min(3),
  confirmPassword: yup.string().required().oneOf([yup.ref("password"), null],"Password fields should be matched"),
});

export const loginCompanySchema = yup.object({
  email: yup.string().required().email().min(5),
  password: yup.string().required()
})

export const companyUpdateSchema = yup.object().shape({
  companyName: yup.string().required().min(3),
  accountUsername:yup.string().required().min(3),
  accountEmail: yup.string().required().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$","Email is not validated"),
  accountPhoneNumber:yup.string().required().min(11).max(11),
  accountPassword: yup.string().required().min(3),
  accountConfirmPassword: yup.string().required().oneOf([yup.ref("accountPassword"), null],"Password fields should be matched"),
});

