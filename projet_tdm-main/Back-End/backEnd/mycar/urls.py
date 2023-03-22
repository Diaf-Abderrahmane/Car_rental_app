from unicodedata import name
from django.urls import path
from . import views

urlpatterns =[


path('login/',views.Login,name='login'),
path('logout/',views.logout,name='logout'),
path( 'all_objects/',views.all_objects,name='all_objects'),
path( 'Registration/',views.Registration,name='Registration'),
path('filter/',views.filter,name='filter'),
path('resrvation/',views.Reservation,name='reservation'),
path('EndReservation/',views.End_Reservation,name='endreservation'),
path('image/',views.get_image,name='get_image'),
path('simple/',views.simple,name='simple'),



]