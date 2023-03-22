from dataclasses import dataclass
import email
from urllib import response
from django.shortcuts import render
from django.http import HttpResponse
from .models import User , car ,reservation
from django.http import JsonResponse
from django.core import serializers
from django.core.exceptions import ValidationError
from uuid import uuid4
import json
from django.views.decorators.csrf import csrf_exempt
import os
from django.conf import settings

@csrf_exempt
def Registration(request):
   
    if request.method == 'POST':
      username_test=request.POST.get('username')
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')
      phone_number_test=request.POST.get('phone_number')
      credit_card_test=request.POST.get('credit_card')
      permis_test=request.POST.get('permis')
       


   
    # username_test="amine7"
    # email_test= "amine@amine7.amine"
    # password_test = "amine7"
    # phone_number_test=234567892
    # credit_card_test=134567892
    # permis_test=12345672






    if not email_test or not  password_test or not username_test or not phone_number_test or not credit_card_test or not permis_test :
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test )
   
    if  user.exists():
                raise ValidationError("this email is already taken")
   
    

    # for object in user:
    #     object.username=username_test
    #     object.email=email_test
    #     object.password=password_test
    #     object.permis=permis_test
    #     object.credit_card=credit_card_test
    #     object.phonenumber=phone_number_test
    #     object.ifLogged = True
    #     object.token = uuid4()
    #     object.save()

    b = User(username=username_test, email=email_test ,password=password_test,permis=permis_test,credit_card=credit_card_test,phonenumber=phone_number_test,ifLogged = True,token = uuid4())
    b.save()
    b= User.objects.filter( email=email_test )
    
    data = serializers.serialize('json', b ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")

@csrf_exempt
def Login(request):
   
    if request.method == 'POST':
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')



    if not email_test or not  password_test:
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test ).filter(password=password_test)
   
    if not user.exists():
                raise ValidationError("User credentials are not correct.")
   
    
    for object in user:
        if object.ifLogged:
            raise ValidationError("User already logged in.")
        object.ifLogged = True
        object.token = uuid4()
        object.save()


    data = serializers.serialize('json',  user ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")


@csrf_exempt    
def Login(request):
   
    if request.method == 'POST':
      email_test= request.POST.get('email')
      password_test = request.POST.get('password')



    if not email_test or not  password_test:
            raise ValidationError("Details not entered.")

    if not '@' in email_test:    
         raise ValidationError("User credentials are not correct.")    
            
    user= User.objects.filter( email=email_test ).filter(password=password_test)
   
    if not user.exists():
                raise ValidationError("User credentials are not correct.")
   
    
    for object in user:
        if object.ifLogged:
            raise ValidationError("User already logged in.")
        object.ifLogged = True
        object.token = uuid4()
        object.save()


    data = serializers.serialize('json',  user ) 
    return HttpResponse(data, content_type="text/json-comment-filtered")

@csrf_exempt
def logout(request):
     

     if request.method == 'POST':
      username_test= request.POST.get('username')
     user= User.objects.filter(username=username_test )
     for object in user:
        if not object.ifLogged:
                 raise ValidationError("User is not logged in.")
        object.ifLogged = False
        object.token = ""
        object.save()
        
     return HttpResponse('User is logged out.')

@csrf_exempt
def simple(request):   
    return HttpResponse('it works')     


@csrf_exempt
def all_objects(request):
    # get method handler

    data = serializers.serialize("json", car.objects.all(), fields = ("marque","modele","acceleration","seat","x","y","price","iftaken"))
    return HttpResponse(data, content_type="text/json-comment-filtered")



# Mazal matastithach f postman
@csrf_exempt
def Reservation(request):
    
    if request.method == 'POST':
      car_id= request.POST.get('car_id')
      user_id = request.POST.get('user_id')
      date_debut=request.POST.get('date_debute')
      
    PIN_test=uuid4()
    user_test = User.objects.get(pk=user_id)
    car_test = car.objects.get(pk=car_id) 
    if  car_test.iftaken:
                 raise ValidationError("already taken")
    new_reservation=reservation( User= user_test,car= car_test,DateDebute=date_debut ) 
    new_reservation.save()
    car_test.iftaken=True
    car_test.Pin=PIN_test
    car_test.save()

    
    return HttpResponse('done')


@csrf_exempt
def End_Reservation(request):
    
    if request.method == 'POST':
      reservation_id_test= request.POST.get('reservation_id')
    reservation_test = reservation.objects.get(pk=reservation_id_test)


    # Mazal makmlthach  
    # PIN_test=uuid4()
    # user_test = User.objects.get(pk=user_id)
    # car_test = car.objects.get(pk=car_id) 
    # new_reservation=reservation( User= user_test,car= car_test,DateDebute=date_debut ) 

    
    return HttpResponse('done')    


# Mazal matastithach f postman
@csrf_exempt
def filter(request):
     # get method handler
     #  searched='IS'
     if request.method == 'POST':
      marque_test= request.POST.get('marque')
      modele_test= request.POST.get('modele')
      iftaken_test= request.POST.get('iftaken')
      acceleration_test= request.POST.get('acceleration')
      seat_test= request.POST.get('seat')
      price_test= request.POST.get('price')
      

     list1= car.objects.filter( marque__contains= marque_test)
     list2=car.objects.filter( modele__contains=modele_test)
     
    #  list3=car.objects.filter(iftaken= iftaken_test)
    #  list4=car.objects.filter( acceleration= acceleration_test)
    #  list5=car.objects.filter(seat=seat_test)
    #  list6=car.objects.filter(price=price_test)



    #  list1= car.objects.filter( marque__contains= marque_test).intersection
    #  car.objects.filter( modele__contains=modele_test)
    #  car.objects.filter(iftaken__contains= iftaken_test)
    #  car.objects.filter( acceleration__contains= acceleration_test)
    #  car.objects.filter(seat__contains=seat_test)
    #  car.objects.filter(price__contains=price_test)
     

       

    #  list=list1.intersection(list2,list3,list4,list5,list6)
     list=list1.intersection(list2)

    #  list=list1.intersection(list1).intersection(list2).intersection(list3).intersection(list4).intersection(list5).intersection(list6)


      # list= car.objects.filter( marque= marque_test).union(
      #       car.objects.filter( modele=modele_test).union(
      #       car.objects.filter(iftaken= iftaken_test).union(
      #       car.objects.filter( acceleration= acceleration_test).union(
      #       car.objects.filter(seat=seat_test).union(
      #       car.objects.filter(price=price_test))))))      

      # list= car.objects.filter( marque= marque_test,modele=modele_test,iftaken= iftaken_test,acceleration= acceleration_test,seat=seat_test,price=price_test)
                  
     
     data = serializers.serialize('json',  list ) 
     return HttpResponse(data, content_type="text/json-comment-filtered")

# @csrf_exempt
# def get_image(request):
#     # if request.method == 'POST':
#     #   image_name= request.POST.get('marque')
#     # image_path = os.path.join('static/images', image_name)
#     with open('image\ ', 'mercedes') as f:
#         image = f.read()

#     return HttpResponse(image, content_type='image/jpeg')
@csrf_exempt
def get_image(request):
    if request.method == 'POST':
      image_url_test= request.POST.get('image_url')
    image_path = os.path.join(settings.BASE_DIR, image_url_test)
    with open(image_path, "rb") as f:
        image = f.read()
    return HttpResponse(image, content_type="image/jpeg")
