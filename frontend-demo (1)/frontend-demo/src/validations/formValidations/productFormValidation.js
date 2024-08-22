import * as yup from "yup";

export const productAddSchema = yup.object().shape({
    productSubCategoryId: yup.number().required(),
    productName: yup.string().required(),
    productDescription: yup.string().required().min(20),
    productMinPrice:yup.number().required().min(0),
    productMaxPrice: yup.number().required().positive().moreThan(yup.ref("productMinPrice"),"Max price should be greater than min price"),
    productGenderId: yup.number().required()
});

export const productUpdateSchema = yup.object().shape({
    productSubCategoryId: yup.number().required(),
    productName: yup.string().required(),
    productDescription: yup.string().required().min(20),
    productMinPrice:yup.number().required().min(0),
    productMaxPrice: yup.number().required().positive().moreThan(yup.ref("productMinPrice"),"Max price should be greater than min price"),
    productGenderId: yup.number().required()
});



