<template>
    <ul role="list" class="divide-y divide-gray-100">
        <li v-for="person in people" :key="person.email" class="flex justify-between gap-x-6 py-5">
            <div class="flex min-w-0 gap-x-4">
                <img class="h-24 w-24 flex-none  bg-gray-50" src="../../assets/default-product.png" alt="" />
                <div class="min-w-0 flex-auto">
                    <p class="text-md font-semibold leading-6 text-gray-900">{{ person.name }}
                    </p>
                    <p class="mt-1 truncate text-xs leading-5 text-gray-500">{{ person.email }}
                    </p>
                </div>
            </div>
            <div class=" shrink-0 sm:flex sm:flex-col sm:items-end">
                <button
                    class="align-middle select-none font-sans font-bold text-center transition-all disabled:opacity-50 disabled:shadow-none disabled:pointer-events-none text-xs py-3 px-1  rounded-lg bg-gradient-to-tr from-green-600 to-green-500 text-white shadow-md shadow-gray-900/10 hover:shadow-lg hover:shadow-gray-900/20 active:opacity-[0.85] flex items-center gap-1"
                    type="button">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2"
                        stroke="currentColor" class="w-5 h-5">
                        <path stroke-linecap="round" stroke-linejoin="round"
                            d="M12 16.5V9.75m0 0l3 3m-3-3l-3 3M6.75 19.5a4.5 4.5 0 01-1.41-8.775 5.25 5.25 0 0110.233-2.33 3 3 0 013.758 3.848A3.752 3.752 0 0118 19.5H6.75z">
                        </path>
                    </svg>
                    Upload Photo
                </button>
            </div>
        </li>
    </ul>
</template>

<script>
export default {


}
</script>