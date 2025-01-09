package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inisvg extends GXProcedure
{
   public inisvg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inisvg.class ), "" );
   }

   public inisvg( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_cerrarbienve(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"15\" height=\"15\" viewBox=\"0 0 15 15\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1.77051 13.4097L13.7705 1.40967M1.77051 1.40967L13.7705 13.4097\" stroke=\"#4E4E4E\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_volver(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"30\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g id=\"arrow-back-circle-outline\"><path id=\"Vector\" d=\"M14.75 18.6083L10.4249 14.2333L14.75 9.85834M11.0259 14.2333H19.7964\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path id=\"Vector_2\" d=\"M25.5719 14.2333C25.5719 8.43646 20.8861 3.73334 15.1107 3.73334C9.33519 3.73334 4.64943 8.43646 4.64943 14.2333C4.64943 20.0302 9.33519 24.7333 15.1107 24.7333C20.8861 24.7333 25.5719 20.0302 25.5719 14.2333Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\"/></g></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_ayuda(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g id=\"help-circle-outline\"><g id=\"Group 120\"><path id=\"Vector\" d=\"M16.0591 5C13.8916 5 11.7727 5.64514 9.97041 6.85383C8.16815 8.06253 6.76346 9.7805 5.93397 11.7905C5.10448 13.8005 4.88745 16.0122 5.31032 18.146C5.73319 20.2798 6.77697 22.2398 8.30966 23.7782C9.84236 25.3166 11.7951 26.3642 13.921 26.7886C16.047 27.2131 18.2505 26.9952 20.2531 26.1627C22.2557 25.3301 23.9673 23.9202 25.1715 22.1113C26.3757 20.3023 27.0185 18.1756 27.0185 16C27.0185 13.0826 25.8639 10.2847 23.8086 8.22183C21.7533 6.15893 18.9657 5 16.0591 5Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\"/><path id=\"Vector_2\" d=\"M12.871 13.0086C12.871 13.0086 12.9233 11.9148 14.0896 10.973C14.7814 10.4136 15.6108 10.2517 16.358 10.2405C17.0386 10.2317 17.6464 10.3448 18.01 10.5186C18.6327 10.8161 19.8451 11.5423 19.8451 13.0867C19.8451 14.7117 18.7865 15.4498 17.5804 16.2617C16.3742 17.0736 16.0467 17.9548 16.0467 18.8655\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\" stroke-linecap=\"round\"/><path id=\"Vector_3\" d=\"M15.9529 23.2533C16.4812 23.2533 16.9094 22.8235 16.9094 22.2933C16.9094 21.7631 16.4812 21.3333 15.9529 21.3333C15.4247 21.3333 14.9965 21.7631 14.9965 22.2933C14.9965 22.8235 15.4247 23.2533 15.9529 23.2533Z\" fill=\"var(--colors_gray08)\"/></g></g></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avataredit(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg class= \"svgEdit\" width=\"20\" height=\"20\" viewBox=\"0 0 17 17\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7.20456 2.78767H2.77273C2.30257 2.78767 1.85167 2.97373 1.51922 3.30491C1.18677 3.6361 1 4.08528 1 4.55364V14.2665C1 14.7348 1.18677 15.184 1.51922 15.5152C1.85167 15.8464 2.30257 16.0324 2.77273 16.0324H12.5228C12.9929 16.0324 13.4438 15.8464 13.7763 15.5152C14.1087 15.184 14.2955 14.7348 14.2955 14.2665V9.85155M13.0422 1.53913C13.2057 1.37046 13.4013 1.23593 13.6176 1.14337C13.8339 1.05082 14.0665 1.0021 14.3019 1.00007C14.5372 0.998029 14.7707 1.04271 14.9885 1.13151C15.2064 1.2203 15.4043 1.35143 15.5708 1.51724C15.7372 1.68305 15.8689 1.88023 15.958 2.09726C16.0471 2.31429 16.092 2.54683 16.0899 2.78132C16.0879 3.0158 16.039 3.24753 15.9461 3.46299C15.8532 3.67844 15.7181 3.87331 15.5488 4.03621L7.93847 11.6175H5.43183V9.12044L13.0422 1.53913Z\" stroke=\"#EEEEEE\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avatarstatus(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"16\" height=\"16\" viewBox=\"0 0 14 14\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M14 7C14 10.866 10.866 14 7 14C3.13401 14 0 10.866 0 7C0 3.13401 3.13401 0 7 0C10.866 0 14 3.13401 14 7Z\" fill=\"#31D62D\" fill-opacity=\"0.33\"/><path d=\"M11 7C11 9.20914 9.20914 11 7 11C4.79086 11 3 9.20914 3 7C3 4.79086 4.79086 3 7 3C9.20914 3 11 4.79086 11 7Z\" fill=\"#31D62D\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avataremail(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"17\" height=\"14\" viewBox=\"0 0 18 15\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 3.66667L8.01333 8.34222C8.30548 8.53714 8.6488 8.64115 9 8.64115C9.3512 8.64115 9.69452 8.53714 9.98667 8.34222L17 3.66667M2.77778 13.4444H15.2222C15.6937 13.4444 16.1459 13.2571 16.4793 12.9237C16.8127 12.5903 17 12.1382 17 11.6667V2.77778C17 2.30628 16.8127 1.8541 16.4793 1.5207C16.1459 1.1873 15.6937 1 15.2222 1H2.77778C2.30628 1 1.8541 1.1873 1.5207 1.5207C1.1873 1.8541 1 2.30628 1 2.77778V11.6667C1 12.1382 1.1873 12.5903 1.5207 12.9237C1.8541 13.2571 2.30628 13.4444 2.77778 13.4444Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avatarphone(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"16\" height=\"16\" viewBox=\"0 0 18 18\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 2.77778C1 2.30628 1.1873 1.8541 1.5207 1.5207C1.8541 1.1873 2.30628 1 2.77778 1H5.69333C5.87982 1.00014 6.06153 1.05893 6.21276 1.16804C6.36399 1.27716 6.47707 1.43107 6.536 1.608L7.86756 5.60178C7.93502 5.80475 7.92704 6.02524 7.84508 6.2228C7.76312 6.42036 7.61267 6.58174 7.42133 6.67733L5.41511 7.68178C6.39851 9.85826 8.14174 11.6015 10.3182 12.5849L11.3227 10.5787C11.4183 10.3873 11.5796 10.2369 11.7772 10.1549C11.9748 10.073 12.1953 10.065 12.3982 10.1324L16.392 11.464C16.5691 11.523 16.7231 11.6362 16.8322 11.7876C16.9413 11.939 17 12.1209 17 12.3076V15.2222C17 15.6937 16.8127 16.1459 16.4793 16.4793C16.1459 16.8127 15.6937 17 15.2222 17H14.3333C6.96978 17 1 11.0302 1 3.66667V2.77778Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avataraddress(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"18\" height=\"16\" viewBox=\"0 0 18 16\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M3.12117 5.74655V14.1001C3.12117 14.3217 3.21056 14.5342 3.36968 14.6908C3.5288 14.8475 3.74461 14.9355 3.96964 14.9355H7.36351M3.12117 5.74655L8.50894 1.20054C8.66263 1.07112 8.85821 1 9.06044 1C9.26268 1 9.45826 1.07112 9.61195 1.20054L14.9997 5.74655M3.12117 5.74655L1 7.41727M7.36351 14.9355V10.7587C7.36351 10.5371 7.4529 10.3247 7.61202 10.168C7.77114 10.0114 7.98695 9.92334 8.21198 9.92334H9.90891C10.1339 9.92334 10.3498 10.0114 10.5089 10.168C10.668 10.3247 10.7574 10.5371 10.7574 10.7587V14.9355M7.36351 14.9355H10.7574M14.9997 5.74655V14.1001C14.9997 14.3217 14.9103 14.5342 14.7512 14.6908C14.5921 14.8475 14.3763 14.9355 14.1513 14.9355H10.7574M14.9997 5.74655L17.1209 7.41727\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avataringreso(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"17\" height=\"17\" viewBox=\"0 0 17 17\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M5.16667 4.33333V1M11.8333 4.33333V1M4.33333 7.66667H12.6667M2.66667 16H14.3333C14.7754 16 15.1993 15.8244 15.5118 15.5118C15.8244 15.1993 16 14.7754 16 14.3333V4.33333C16 3.89131 15.8244 3.46738 15.5118 3.15482C15.1993 2.84226 14.7754 2.66667 14.3333 2.66667H2.66667C2.22464 2.66667 1.80072 2.84226 1.48816 3.15482C1.17559 3.46738 1 3.89131 1 4.33333V14.3333C1 14.7754 1.17559 15.1993 1.48816 15.5118C1.80072 15.8244 2.22464 16 2.66667 16Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_avataregreso(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"19\" height=\"16\" viewBox=\"0 0 19 16\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M14.4419 10.8109L18 7.8251M18 7.8251L14.4419 4.83906M18 7.8251H8.11628M11.2791 11.2375V12.0906C11.2791 12.7694 11.0292 13.4204 10.5843 13.9004C10.1394 14.3804 9.5361 14.65 8.90698 14.65H3.37209C2.74297 14.65 2.13962 14.3804 1.69477 13.9004C1.24992 13.4204 1 12.7694 1 12.0906V3.55937C1 2.88059 1.24992 2.2296 1.69477 1.74962C2.13962 1.26965 2.74297 1 3.37209 1H8.90698C9.5361 1 10.1394 1.26965 10.5843 1.74962C11.0292 2.2296 11.2791 2.88059 11.2791 3.55937V4.4125\" stroke=\"#F06B4E\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_legajofiltros(remoteHandle, context).execute( GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"18\" height=\"18\" viewBox=\"0 0 17 17\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M2.83333 8.33317H1M2.83333 8.33317C2.83333 8.8194 3.02649 9.28572 3.3703 9.62953C3.71412 9.97335 4.18044 10.1665 4.66667 10.1665C5.1529 10.1665 5.61921 9.97335 5.96303 9.62953C6.30685 9.28572 6.5 8.8194 6.5 8.33317M2.83333 8.33317C2.83333 7.84694 3.02649 7.38062 3.3703 7.03681C3.71412 6.69299 4.18044 6.49984 4.66667 6.49984C5.1529 6.49984 5.61921 6.69299 5.96303 7.03681C6.30685 7.38062 6.5 7.84694 6.5 8.33317M6.5 8.33317H15.6667M13.8333 13.8332C13.8333 13.3469 13.6402 12.8806 13.2964 12.5368C12.9525 12.193 12.4862 11.9998 12 11.9998C11.5138 11.9998 11.0475 12.193 10.7036 12.5368C10.3598 12.8806 10.1667 13.3469 10.1667 13.8332M13.8333 13.8332C13.8333 14.3194 13.6402 14.7857 13.2964 15.1295C12.9525 15.4733 12.4862 15.6665 12 15.6665C11.5138 15.6665 11.0475 15.4733 10.7036 15.1295C10.3598 14.7857 10.1667 14.3194 10.1667 13.8332M13.8333 13.8332H15.6667M10.1667 13.8332H1M13.8333 2.83317C13.8333 2.34694 13.6402 1.88062 13.2964 1.53681C12.9525 1.19299 12.4862 0.999837 12 0.999837C11.5138 0.999837 11.0475 1.19299 10.7036 1.53681C10.3598 1.88062 10.1667 2.34694 10.1667 2.83317M13.8333 2.83317C13.8333 3.3194 13.6402 3.78572 13.2964 4.12953C12.9525 4.47335 12.4862 4.6665 12 4.6665C11.5138 4.6665 11.0475 4.47335 10.7036 4.12953C10.3598 3.78572 10.1667 3.3194 10.1667 2.83317M13.8333 2.83317L15.6667 2.83317M10.1667 2.83317H1\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Liquidación", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"26.44\" viewBox=\"0 0 27 25\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g clip-path=\"url(#clip0_775_1393)\"><path d=\"M20.9849 1.59473H5.74294C4.19494 1.59473 3.18278 2.45266 2.88508 4.04596L0.979839 13.3606V20.2241C0.982038 21.0035 1.28384 21.7504 1.81932 22.3015C2.35479 22.8527 3.08043 23.1633 3.8377 23.1656H22.8901C23.6474 23.1633 24.373 22.8527 24.9085 22.3015C25.444 21.7504 25.7458 21.0035 25.748 20.2241V13.3606L23.8427 4.04596C23.5451 2.39138 22.4734 1.59473 20.9849 1.59473Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linejoin=\"round\"/><path d=\"M0.979839 13.4376H9.55343C9.55343 14.5032 9.95489 15.5252 10.6695 16.2788C11.3841 17.0323 12.3533 17.4557 13.3639 17.4557C14.3745 17.4557 15.3437 17.0323 16.0583 16.2788C16.7729 15.5252 17.1744 14.5032 17.1744 13.4376H25.748M6.69557 5.40137H20.0323M5.74294 9.41947H20.9849\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></g><defs><clipPath id=\"clip0_775_1393\"><rect width=\"27\" height=\"24.2541\" fill=\"white\" transform=\"translate(0 0.214355)\"/></clipPath></defs></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Actualizaciones", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"22\" height=\"22\" viewBox=\"0 0 18 18\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1 0.999928V5.99993H1.582M1.582 5.99993C2.24585 4.35806 3.43568 2.98284 4.96503 2.08979C6.49438 1.19674 8.2768 0.836341 10.033 1.06507C11.7891 1.29379 13.4198 2.09872 14.6694 3.3537C15.919 4.60869 16.7168 6.24279 16.938 7.99993M1.582 5.99993H6M17 16.9999V11.9999H16.419M16.419 11.9999C15.7542 13.6408 14.564 15.015 13.0348 15.9072C11.5056 16.7995 9.72374 17.1594 7.9681 16.9308C6.21246 16.7022 4.5822 15.8978 3.33253 14.6437C2.08287 13.3895 1.28435 11.7564 1.062 9.99993M16.419 11.9999H12\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "AFIP2", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"92\" height=\"25\" viewBox=\"0 0 92 25\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M21 8.5L18.5029 2.25722C18.1992 1.4979 17.4637 1 16.6459 1H12.2604C11.4902 1 10.7885 1.44227 10.4562 2.13709L1.36922 21.1371C0.734343 22.4646 1.70202 24 3.17349 24H12.7087C13.4948 24 14.2079 23.5396 14.5315 22.8232L15.8065 20M21 8.5L15.8065 20M21 8.5L25.6168 18.1952C25.8465 18.6776 25.7475 19.2525 25.3697 19.6303V19.6303C25.133 19.867 24.8119 20 24.4772 20H15.8065M40.5 14H43.1745C43.978 14 44.7034 13.5192 45.0165 12.7793L48.8242 3.77928C49.3821 2.46061 48.414 1 46.9822 1H40.5M40.5 14V18C40.5 19.1046 39.6046 20 38.5 20H30.5C29.3954 20 28.5 19.1046 28.5 18V3C28.5 1.89543 29.3954 1 30.5 1H40.5M40.5 14V7.5M40.5 1V7.5M40.5 7.5H47M80 14H84.0917C84.6839 14 85.263 13.8247 85.7558 13.4962L85.7916 13.4722C86.2547 13.1635 86.6228 12.732 86.8547 12.2261L90.7014 3.83331C91.3086 2.50854 90.3406 1 88.8833 1H80M80 14V1M80 14V18C80 19.1046 79.1046 20 78 20H69.9481C68.864 20 67.9773 19.1363 67.9488 18.0526L67.554 3.05261C67.5244 1.92783 68.4281 1 69.5533 1H80M55 20H63C64.1046 20 65 19.1046 65 18V3C65 1.89543 64.1046 1 63 1H55C53.8954 1 53 1.89543 53 3V18C53 19.1046 53.8954 20 55 20Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "AFIP", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"24\" viewBox=\"0 0 29 26\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M17 21L15.5528 23.8944C15.214 24.572 14.5215 25 13.7639 25H1.5V25C1.26825 25 1.11592 24.7581 1.21606 24.5491L11.9558 2.13576C12.2884 1.44166 12.9897 1 13.7594 1H18.2152C18.9979 1 19.7087 1.45661 20.0342 2.16848L22.9286 8.5M17 21H25.7929C26.2456 21 26.6799 20.8201 27 20.5V20.5C27.3201 20.1799 27.5 19.7456 27.5 19.2929V18.9355C27.5 18.6485 27.4383 18.3649 27.3189 18.104L22.9286 8.5M17 21L22.9286 8.5\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "AFIP_Tablas", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"97\" height=\"30\" viewBox=\"0 0 92 25\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M21 8.5L18.5029 2.25722C18.1992 1.4979 17.4637 1 16.6459 1H12.2604C11.4902 1 10.7885 1.44227 10.4562 2.13709L1.36922 21.1371C0.734343 22.4646 1.70202 24 3.17349 24H12.7087C13.4948 24 14.2079 23.5396 14.5315 22.8232L15.8065 20M21 8.5L15.8065 20M21 8.5L25.6168 18.1952C25.8465 18.6776 25.7475 19.2525 25.3697 19.6303V19.6303C25.133 19.867 24.8119 20 24.4772 20H15.8065M40.5 14H43.1745C43.978 14 44.7034 13.5192 45.0165 12.7793L48.8242 3.77928C49.3821 2.46061 48.414 1 46.9822 1H40.5M40.5 14V18C40.5 19.1046 39.6046 20 38.5 20H30.5C29.3954 20 28.5 19.1046 28.5 18V3C28.5 1.89543 29.3954 1 30.5 1H40.5M40.5 14V7.5M40.5 1V7.5M40.5 7.5H47M80 14H84.0917C84.6839 14 85.263 13.8247 85.7558 13.4962L85.7916 13.4722C86.2547 13.1635 86.6228 12.732 86.8547 12.2261L90.7014 3.83331C91.3086 2.50854 90.3406 1 88.8833 1H80M80 14V1M80 14V18C80 19.1046 79.1046 20 78 20H69.9481C68.864 20 67.9773 19.1363 67.9488 18.0526L67.554 3.05261C67.5244 1.92783 68.4281 1 69.5533 1H80M55 20H63C64.1046 20 65 19.1046 65 18V3C65 1.89543 64.1046 1 63 1H55C53.8954 1 53 1.89543 53 3V18C53 19.1046 53.8954 20 55 20Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Configuración", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"26\" viewBox=\"0 0 26 26\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M12.275 16.9625L19.5625 24.25C20.1875 24.855 21.0253 25.1901 21.8951 25.1831C22.7649 25.176 23.5972 24.8273 24.2123 24.2123C24.8273 23.5972 25.176 22.765 25.1831 21.8951C25.1901 21.0253 24.855 20.1875 24.25 19.5625L16.9038 12.2163M12.275 16.9625L15.395 13.175C15.7913 12.695 16.32 12.3925 16.905 12.2175C17.5925 12.0125 18.3588 11.9825 19.0838 12.0425C20.061 12.1264 21.0433 11.9533 21.933 11.5404C22.8227 11.1275 23.589 10.4891 24.1558 9.68851C24.7226 8.88797 25.0702 7.95312 25.1641 6.97675C25.2581 6.00038 25.0951 5.01641 24.6913 4.1225L20.5963 8.21875C19.9111 8.06033 19.2843 7.71271 18.787 7.21547C18.2898 6.71824 17.9422 6.09137 17.7838 5.40625L21.8788 1.31125C20.9848 0.907454 20.0009 0.74443 19.0245 0.838354C18.0481 0.932279 17.1133 1.27989 16.3127 1.84669C15.5122 2.41348 14.8738 3.17977 14.4609 4.0695C14.0479 4.95922 13.8748 5.94147 13.9588 6.91875C14.0725 8.26375 13.87 9.74875 12.8288 10.6063L12.7013 10.7125M12.275 16.9625L6.45625 24.0288C6.17424 24.3725 5.82338 24.6534 5.42625 24.8534C5.02911 25.0534 4.59451 25.168 4.15041 25.1898C3.70632 25.2117 3.26256 25.1403 2.84771 24.9803C2.43286 24.8203 2.05611 24.5752 1.74171 24.2608C1.4273 23.9464 1.18221 23.5696 1.02221 23.1548C0.862204 22.7399 0.790835 22.2962 0.812693 21.8521C0.834551 21.408 0.949152 20.9734 1.14912 20.5763C1.34909 20.1791 1.62999 19.8283 1.97375 19.5463L10.52 12.5088L5.38625 7.375H3.625L0.8125 2.6875L2.6875 0.8125L7.375 3.625V5.38625L12.7 10.7113L10.5188 12.5075M20.9688 20.9688L17.6875 17.6875M4.08375 21.9063H4.09375V21.9163H4.08375V21.9063Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Importación", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M26 19V15.5C26 13.0147 23.9853 11 21.5 11H19.5C18.6716 11 18 10.3284 18 9.5V7.5C18 5.01472 15.9853 3 13.5 3H11M12 19L16 23M16 23L20 19M16 23L16 15M14 3H7.5C6.67157 3 6 3.67157 6 4.5V27.5C6 28.3284 6.67157 29 7.5 29H24.5C25.3284 29 26 28.3284 26 27.5V15C26 8.37258 20.6274 3 14 3Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Reportes", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"25\" height=\"25\" viewBox=\"0 0 25 25\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1.61795 13.8594C1.61795 13.1086 2.22538 12.5 2.97468 12.5H5.68814C6.43744 12.5 7.04487 13.1086 7.04487 13.8594V22.0156C7.04487 22.7664 6.43744 23.375 5.68814 23.375H2.97468C2.22538 23.375 1.61795 22.7664 1.61795 22.0156V13.8594Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M9.75833 8.42187C9.75833 7.67111 10.3658 7.0625 11.1151 7.0625H13.8285C14.5778 7.0625 15.1853 7.67111 15.1853 8.42188V22.0156C15.1853 22.7664 14.5778 23.375 13.8285 23.375H11.1151C10.3658 23.375 9.75833 22.7664 9.75833 22.0156V8.42187Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M17.8987 2.98438C17.8987 2.23361 18.5061 1.625 19.2554 1.625H21.9689C22.7182 1.625 23.3256 2.23361 23.3256 2.98438V22.0156C23.3256 22.7664 22.7182 23.375 21.9689 23.375H19.2554C18.5061 23.375 17.8987 22.7664 17.8987 22.0156V2.98438Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Exportar liquidaciones", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"27\" height=\"29\" viewBox=\"0 0 20 22\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M5.53064 12.9271L8.37809 10.2308M8.37809 10.2308L11.0691 12.9271M8.37809 10.2308L8.29987 15.7692\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.25\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M4.99988 1H14.4999L18.9999 5.5V18\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M1 18C1 19.6569 2.34315 21 4 21H14.5C15.3284 21 16 20.3284 16 19.5V7.74853C16 7.5894 15.9368 7.43679 15.8243 7.32426L12.6757 4.17574C12.5632 4.06321 12.4106 4 12.2515 4H2.5C1.67157 4 1 4.67157 1 5.5V18Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M12.0001 4V7.4C12.0001 7.73137 12.2687 8 12.6001 8H16.0001\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Legajos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"31\" height=\"23\" viewBox=\"0 0 31 23\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M24.5131 5.59601C24.3275 8.19211 22.4163 10.192 20.3321 10.192C18.248 10.192 16.3336 8.19275 16.1512 5.59601C15.9611 2.89521 17.8217 1 20.3321 1C22.8426 1 24.7031 2.94437 24.5131 5.59601Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.332 14.3701C16.1558 14.3701 12.1398 16.3022 11.1337 20.065C11.0004 20.5628 11.3356 21.0552 11.8848 21.0552H28.7799C29.329 21.0552 29.6623 20.5628 29.5309 20.065C28.5248 16.2419 24.5088 14.3701 20.332 14.3701Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M11.9329 6.42786C11.7852 8.53367 10.2465 10.1921 8.58788 10.1921C6.92927 10.1921 5.38805 8.53432 5.24289 6.42786C5.09205 4.23713 6.58972 2.67139 8.58788 2.67139C10.586 2.67139 12.0837 4.27732 11.9329 6.42786Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M11.9434 14.2834C10.8122 13.7426 9.56636 13.5347 8.24589 13.5347C4.98704 13.5347 1.84727 15.2251 1.06076 18.5177C0.95735 18.9532 1.21931 19.3841 1.64798 19.3841H8.68459\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Novedades", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"29\" height=\"30\" viewBox=\"0 0 29 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10.9945 22.5829H18.004M14.5 1.54199V3.04492M24.046 5.5037L22.9855 6.56627M28 15.0683H26.5M2.5 15.0683H1M6.0145 6.56627L4.954 5.5037M9.196 20.3826C8.1473 19.3316 7.43319 17.9926 7.14397 16.535C6.85474 15.0774 7.00338 13.5665 7.57109 12.1935C8.13881 10.8205 9.1001 9.64702 10.3334 8.82139C11.5668 7.99576 13.0167 7.55509 14.5 7.55509C15.9833 7.55509 17.4332 7.99576 18.6666 8.82139C19.8999 9.64702 20.8612 10.8205 21.4289 12.1935C21.9966 13.5665 22.1453 15.0774 21.856 16.535C21.5668 17.9926 20.8527 19.3316 19.804 20.3826L18.982 21.2047C18.5121 21.6757 18.1393 22.2348 17.885 22.85C17.6307 23.4653 17.4999 24.1248 17.5 24.7907V25.5888C17.5 26.386 17.1839 27.1505 16.6213 27.7142C16.0587 28.2779 15.2956 28.5946 14.5 28.5946C13.7044 28.5946 12.9413 28.2779 12.3787 27.7142C11.8161 27.1505 11.5 26.386 11.5 25.5888V24.7907C11.5 23.4456 10.966 22.1546 10.018 21.2047L9.196 20.3826Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Conceptos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"28\" height=\"28\" viewBox=\"0 0 28 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M2.33334 7C2.33334 5.067 3.90035 3.5 5.83334 3.5H22.1667C24.0997 3.5 25.6667 5.067 25.6667 7V21C25.6667 22.933 24.0997 24.5 22.1667 24.5H5.83334C3.90035 24.5 2.33334 22.933 2.33334 21V7ZM5.83334 5.83333C5.18901 5.83333 4.66668 6.35567 4.66668 7V21C4.66668 21.6443 5.18901 22.1667 5.83334 22.1667H22.1667C22.811 22.1667 23.3333 21.6443 23.3333 21V7C23.3333 6.35567 22.811 5.83333 22.1667 5.83333H5.83334ZM8.50839 9.67504C8.964 9.21943 9.70269 9.21943 10.1583 9.67504L13.6583 13.175C14.1139 13.6307 14.1139 14.3693 13.6583 14.825L10.1583 18.325C9.70269 18.7806 8.964 18.7806 8.50839 18.325C8.05277 17.8693 8.05277 17.1307 8.50839 16.675L11.1834 14L8.50839 11.325C8.05277 10.8693 8.05277 10.1307 8.50839 9.67504ZM14 17.5C14 16.8557 14.5223 16.3333 15.1667 16.3333H18.6667C19.311 16.3333 19.8333 16.8557 19.8333 17.5C19.8333 18.1443 19.311 18.6667 18.6667 18.6667H15.1667C14.5223 18.6667 14 18.1443 14 17.5Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Horas trabajadas y conceptos adicionales", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"21\" height=\"21\" viewBox=\"0 0 21 21\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10.5 1C5.25521 1 1 5.25521 1 10.5C1 15.7448 5.25521 20 10.5 20C15.7448 20 20 15.7448 20 10.5C20 5.25521 15.7448 1 10.5 1Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M10 5V12H15\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Faltas y llegadas tarde", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"21\" height=\"21\" viewBox=\"0 0 22 22\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M18.0163 4.25011C19.593 6.01102 20.4757 8.28507 20.5 10.6486C20.5599 16.0491 16.1506 20.49 10.75 20.5001C5.35704 20.5103 1.00001 16.1416 1.00001 10.7501C1.00001 5.44144 5.24278 1.12148 10.5215 1.00011C10.5512 0.99916 10.5808 1.0042 10.6085 1.01493C10.6362 1.02566 10.6615 1.04186 10.6828 1.06257C10.7042 1.08328 10.7211 1.10807 10.7326 1.13547C10.7442 1.16286 10.7501 1.1923 10.75 1.22203V5.46886\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M11.8987 11.8992L15.9104 6.16089C15.9659 6.08138 15.9916 5.98488 15.9831 5.88829C15.9746 5.79171 15.9324 5.7012 15.8638 5.63264C15.7952 5.56408 15.7047 5.52184 15.6081 5.51332C15.5116 5.5048 15.415 5.53054 15.3355 5.58604L9.59726 9.59776C9.24529 9.85126 9.00727 10.2331 8.93468 10.6608C8.86208 11.0884 8.96076 11.5274 9.20935 11.8829C9.45795 12.2383 9.83649 12.4816 10.2631 12.5601C10.6897 12.6386 11.13 12.546 11.4889 12.3024C11.6475 12.1924 11.7862 12.056 11.8987 11.8992Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Vacaciones y licencias", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"34\" height=\"24\" viewBox=\"0 0 34 24\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M2.24796 22.9639C3.33486 21.6976 4.95489 20.2021 6.61579 20.468C8.41783 20.7566 8.67647 22.642 10.3596 22.9639C12.2884 23.3328 13.4464 20.7657 15.9754 20.468C18.2284 20.2029 18.5066 21.9724 20.1353 22.6804C20.7778 22.9597 21.3503 22.9628 21.5912 22.9639C23.876 22.9749 24.708 20.7205 26.583 20.468C27.4124 20.3563 28.6431 20.6099 30.3269 22.34\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.7719 16.4619C26.4101 17.7496 30.1693 19.2198 32.1988 19.2198\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M1 19.5321C3.22884 19.3092 7.08302 13.9921 15.2412 15.3518C15.4478 15.3862 15.6534 15.4216 15.858 15.4579\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M27.3482 9.85303C28.0664 5.78053 25.2095 1.87269 20.9673 1.12467C16.725 0.376646 12.7039 3.07172 11.9858 7.14423L27.3482 9.85303Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M22.7395 9.0404C23.4576 4.96789 22.6641 1.42389 20.9672 1.1247C19.2703 0.825501 17.3126 3.88436 16.5945 7.95692L22.7395 9.0404Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M18.0417 17.716L19.667 8.49854\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.62902\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Deducciones y reintegros", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"35\" height=\"29\" viewBox=\"0 0 35 29\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M32.7692 8.34615C32.7692 6.71054 31.4433 5.60105 29.8077 5.60105H24.2192L26.6096 7.77503C26.925 8.09045 26.925 8.60185 26.6096 8.91728C26.2942 9.2327 25.5462 9.2327 25.2308 8.91728L21.4615 5.38462C21.1461 5.06919 21.1461 4.08465 21.4615 3.76923L25.2308 0.236568C25.5462 -0.0788558 26.2942 -0.0788558 26.6096 0.236568C26.925 0.551991 26.925 1.06339 26.6096 1.37882L24.2192 3.58333H29.8077C32.3355 3.58333 34.7163 5.81839 34.7163 8.34615C34.7163 10.8739 32.3355 13.0954 29.8077 13.0954H28.7308C28.2847 13.0954 27.9231 12.5615 27.9231 12.1154C27.9231 11.6693 28.2847 11.1097 28.7308 11.1097H29.8077C31.4433 11.1097 32.7692 9.98177 32.7692 8.34615Z\" fill=\"var(--colors_gray08)\"/><path d=\"M21.1026 14.1539V11.3847C21.1026 10.6503 20.8 9.9459 20.2614 9.42657C19.7229 8.90724 18.9924 8.61548 18.2308 8.61548H3.87179C3.11015 8.61548 2.3797 8.90724 1.84113 9.42657C1.30256 9.9459 1 10.6503 1 11.3847V19.6924C1 20.4268 1.30256 21.1312 1.84113 21.6505C2.3797 22.1699 3.11015 22.4616 3.87179 22.4616H6.74359M9.61538 28.0001H23.9744C24.736 28.0001 25.4665 27.7083 26.005 27.189C26.5436 26.6697 26.8462 25.9653 26.8462 25.2309V16.9232C26.8462 16.1887 26.5436 15.4844 26.005 14.965C25.4665 14.4457 24.736 14.1539 23.9744 14.1539H9.61538C8.85374 14.1539 8.12328 14.4457 7.58472 14.965C7.04615 15.4844 6.74359 16.1887 6.74359 16.9232V25.2309C6.74359 25.9653 7.04615 26.6697 7.58472 27.189C8.12328 27.7083 8.85374 28.0001 9.61538 28.0001ZM19.6667 21.077C19.6667 21.8115 19.3641 22.5158 18.8255 23.0352C18.287 23.5545 17.5565 23.8462 16.7949 23.8462C16.0332 23.8462 15.3028 23.5545 14.7642 23.0352C14.2256 22.5158 13.9231 21.8115 13.9231 21.077C13.9231 20.3426 14.2256 19.6382 14.7642 19.1189C15.3028 18.5995 16.0332 18.3078 16.7949 18.3078C17.5565 18.3078 18.287 18.5995 18.8255 19.1189C19.3641 19.6382 19.6667 20.3426 19.6667 21.077Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Obligaciones", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"30\" viewBox=\"0 0 30 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M18.9473 15.2632C18.9473 16.6591 19.5018 17.9978 20.4889 18.9848C21.4759 19.9718 22.8146 20.5263 24.2105 20.5263C25.6063 20.5263 26.945 19.9718 27.9321 18.9848C28.9191 17.9978 29.4736 16.6591 29.4736 15.2632C29.4736 15.0998 29.4356 14.9386 29.3625 14.7924L25.1536 6.37501C25.1392 6.34557 25.1232 6.3169 25.1058 6.28912C25.0115 6.13643 24.8798 6.01038 24.7231 5.92295C24.5664 5.83551 24.3899 5.78959 24.2105 5.78954H17.7071C17.5482 5.34924 17.2938 4.94954 16.9623 4.61908C16.6308 4.28862 16.2302 4.03557 15.7894 3.87807V0.5264L14.7368 0L13.6842 0.5264V3.87807C13.2434 4.03557 12.8428 4.28862 12.5113 4.61908C12.1798 4.94954 11.9254 5.34924 11.7665 5.78954H5.26314C5.06765 5.78952 4.87602 5.84394 4.70972 5.94669C4.54341 6.04945 4.40901 6.19649 4.32157 6.37133L0.111052 14.7924C0.0379835 14.9386 -3.78895e-05 15.0998 2.8333e-08 15.2632C2.8333e-08 16.6591 0.554508 17.9978 1.54154 18.9848C2.52857 19.9718 3.86727 20.5263 5.26314 20.5263C6.65901 20.5263 7.99771 19.9718 8.98475 18.9848C9.97178 17.9978 10.5263 16.6591 10.5263 15.2632C10.5263 15.0998 10.4883 14.9386 10.4152 14.7924L6.96651 7.8948H11.7665C11.9254 8.33503 12.1798 8.73465 12.5113 9.06503C12.8429 9.3954 13.2434 9.64835 13.6842 9.80574V27.8947H4.21051L3.6842 28.9474L4.21051 30H25.2631L25.7894 28.9474L25.2631 27.8947H15.7894V9.80627C16.2302 9.64877 16.6308 9.39573 16.9623 9.06526C17.2938 8.7348 17.5482 8.3351 17.7071 7.8948H22.5071L19.0584 14.7924C18.9853 14.9386 18.9473 15.0998 18.9473 15.2632ZM5.26314 18.4211C4.61233 18.4189 3.97816 18.2153 3.4476 17.8384C2.91705 17.4615 2.51611 16.9296 2.29978 16.3158H8.22608C8.00981 16.9296 7.60894 17.4614 7.07846 17.8383C6.54799 18.2152 5.91389 18.4188 5.26314 18.4211ZM7.77061 14.2106H2.75568L5.26314 9.19616L7.77061 14.2106ZM14.7368 7.8948C14.5286 7.8948 14.3251 7.83306 14.152 7.7174C13.9789 7.60173 13.844 7.43734 13.7643 7.24499C13.6846 7.05265 13.6638 6.841 13.7044 6.63681C13.745 6.43262 13.8453 6.24506 13.9925 6.09785C14.1397 5.95064 14.3273 5.85038 14.5314 5.80977C14.7356 5.76915 14.9473 5.79 15.1396 5.86967C15.332 5.94934 15.4964 6.08426 15.612 6.25736C15.7277 6.43047 15.7894 6.63398 15.7894 6.84217C15.7892 7.12127 15.6782 7.38886 15.4808 7.58621C15.2835 7.78357 15.0159 7.89455 14.7368 7.8948ZM24.2105 18.4211C23.5596 18.4189 22.9255 18.2153 22.3949 17.8384C21.8644 17.4615 21.4634 16.9296 21.2471 16.3158H27.1734C26.9571 16.9296 26.5562 17.4614 26.0258 17.8383C25.4953 18.2152 24.8612 18.4188 24.2105 18.4211ZM24.2105 9.19616L26.7179 14.2106H21.703L24.2105 9.19616Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Cog", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"26\" viewBox=\"0 0 26 26\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.7914 2.2534C9.91195 1.53012 10.5377 1 11.271 1H14.7296C15.4629 1 16.0887 1.53012 16.2092 2.2534L16.4939 3.96147C16.577 4.46019 16.9103 4.87562 17.3527 5.12048C17.4516 5.17522 17.5493 5.23178 17.6459 5.2901C18.0793 5.55179 18.6064 5.63315 19.0805 5.45554L20.703 4.8477C21.3896 4.59046 22.1616 4.86734 22.5282 5.50236L24.2575 8.49762C24.6242 9.13264 24.478 9.93964 23.9119 10.4057L22.5727 11.5081C22.1827 11.8292 21.9894 12.325 21.9987 12.83C21.9998 12.8866 22.0003 12.9432 22.0003 13C22.0003 13.0568 21.9998 13.1134 21.9987 13.1699C21.9894 13.675 22.1827 14.1708 22.5727 14.4919L23.9119 15.5943C24.478 16.0603 24.6242 16.8673 24.2575 17.5024L22.5282 20.4976C22.1616 21.1326 21.3896 21.4095 20.703 21.1523L19.0805 20.5444C18.6064 20.3668 18.0793 20.4482 17.6459 20.7099C17.5493 20.7682 17.4516 20.8248 17.3527 20.8795C16.9103 21.1244 16.577 21.5398 16.4939 22.0385L16.2092 23.7466C16.0887 24.4699 15.4629 25 14.7296 25H11.271C10.5377 25 9.91195 24.4699 9.7914 23.7466L9.50672 22.0385C9.4236 21.5398 9.0903 21.1244 8.64795 20.8795C8.54905 20.8248 8.45129 20.7682 8.35471 20.7099C7.92133 20.4482 7.39422 20.3668 6.92014 20.5445L5.29765 21.1523C4.611 21.4095 3.83901 21.1327 3.47238 20.4976L1.74307 17.5024C1.37644 16.8674 1.52264 16.0604 2.08875 15.5943L3.42789 14.4919C3.8179 14.1708 4.01123 13.675 4.00187 13.17C4.00083 13.1134 4.0003 13.0568 4.0003 13C4.0003 12.9432 4.00083 12.8866 4.00187 12.8301C4.01123 12.325 3.81789 11.8292 3.42789 11.5081L2.08875 10.4057C1.52264 9.93966 1.37644 9.13266 1.74307 8.49764L3.47238 5.50238C3.83901 4.86736 4.611 4.59048 5.29765 4.84772L6.92012 5.45556C7.39421 5.63316 7.92132 5.5518 8.35469 5.29011C8.45128 5.23178 8.54904 5.17523 8.64795 5.12048C9.0903 4.87562 9.4236 4.46019 9.50672 3.96147L9.7914 2.2534Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M17 12.9999C17 15.209 15.2091 16.9999 13 16.9999C10.7909 16.9999 8.99999 15.209 8.99999 12.9999C8.99999 10.7908 10.7909 8.99989 13 8.99989C15.2091 8.99989 17 10.7908 17 12.9999Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Empresa", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"34\" height=\"32\" viewBox=\"0 0 34 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M2 30H32.3333M4.33333 2V30M20.6667 2V30M30 9V30M9 7.83333H10.1667M9 12.5H10.1667M9 17.1667H10.1667M14.8333 7.83333H16M14.8333 12.5H16M14.8333 17.1667H16M9 30V24.75C9 23.7835 9.7835 23 10.75 23H14.25C15.2165 23 16 23.7835 16 24.75V30M3.16667 2H21.8333M20.6667 9H31.1667M25.3333 14.8333H25.345V14.845H25.3333V14.8333ZM25.3333 19.5H25.345V19.5117H25.3333V19.5ZM25.3333 24.1667H25.345V24.1783H25.3333V24.1667Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Datos principales", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"32\" viewBox=\"0 0 26 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M16 1H4C3.20435 1 2.44129 1.31607 1.87868 1.87868C1.31607 2.44129 1 3.20435 1 4V28C1 28.7956 1.31607 29.5587 1.87868 30.1213C2.44129 30.6839 3.20435 31 4 31H22C22.7956 31 23.5587 30.6839 24.1213 30.1213C24.6839 29.5587 25 28.7956 25 28V10L16 1Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M16 1V10H25\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M19 17.5002H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M19 23.5H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M10 11.5H8.5H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Convenios", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"33\" height=\"22\" viewBox=\"0 0 33 22\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M10.25 0C9.93662 0 9.63744 0.13071 9.42452 0.36066L7.67514 2.25H1.125C0.503685 2.25 0 2.75369 0 3.375C0 3.99632 0.503685 4.5 1.125 4.5H4.5V15.6875C4.5 16.7231 3.66054 17.5625 2.625 17.5625H1.125C0.503685 17.5625 0 18.0662 0 18.6875C0 19.3088 0.503685 19.8125 1.125 19.8125H2.625C4.35018 19.8125 5.82799 18.7535 6.44379 17.25H7.94246L14.1302 20.9064C15.6158 21.7842 17.4906 21.6446 18.8298 20.5565L22.8995 17.25H26.5561C27.172 18.7535 28.6499 19.8125 30.375 19.8125H31.875C32.4963 19.8125 33 19.3088 33 18.6875C33 18.0662 32.4963 17.5625 31.875 17.5625H30.375C29.3394 17.5625 28.5 16.7231 28.5 15.6875V4.5H31.875C32.4963 4.5 33 3.99632 33 3.375C33 2.75369 32.4963 2.25 31.875 2.25C29.6916 2.25 27.5082 2.25 25.3248 2.25L23.5755 0.36066C23.3625 0.13071 23.0634 0 22.7501 0H17.5416C17.2407 0 16.9524 0.12057 16.7409 0.334755L15.9554 1.13084L15.2421 0.36066C15.0292 0.13071 14.73 0 14.4167 0H10.25ZM8.16668 4.5H6.75V15H8.25C8.45133 15 8.64899 15.054 8.82233 15.1565L15.2748 18.9693C15.9501 19.3683 16.8022 19.3049 17.4111 18.8103L20.8779 15.9935L18.6591 13.4975C18.2465 13.0331 18.2882 12.3219 18.7526 11.9091C19.217 11.4965 19.9281 11.5382 20.3409 12.0026L23.0052 15H26.25V4.5H24.8334C24.5199 4.5 24.2208 4.36929 24.0078 4.13934L22.2585 2.25H18.012L14.0551 6.25926C13.3534 6.97035 13.3324 8.10683 14.0074 8.84325L14.1855 9.0375C14.8832 9.7986 16.0649 9.85245 16.829 9.1578L18.7432 7.41756C19.203 6.99962 19.9145 7.0335 20.3325 7.49325C20.7504 7.95299 20.7165 8.66445 20.2568 9.0825L18.3425 10.8228C16.6617 12.3507 14.0618 12.2324 12.5269 10.5579L12.3489 10.3637C10.8637 8.7435 10.9098 6.24317 12.4537 4.67877L14.3732 2.73389L13.9251 2.25H10.7415L8.99215 4.13934C8.77923 4.36929 8.48006 4.5 8.16668 4.5Z\" fill=\"var(--colors_gray08)\"/><path d=\"M32.9999 14.0635C32.9999 14.7883 32.4122 15.376 31.6874 15.376C30.9626 15.376 30.3749 14.7883 30.3749 14.0635C30.3749 13.3387 30.9626 12.751 31.6874 12.751C32.4122 12.751 32.9999 13.3387 32.9999 14.0635Z\" fill=\"var(--colors_gray08)\"/><path d=\"M2.625 14.27C2.625 14.995 2.03738 15.5825 1.3125 15.5825C0.587625 15.5825 0 14.995 0 14.27C0 13.5452 0.587625 12.9575 1.3125 12.9575C2.03738 12.9575 2.625 13.5452 2.625 14.27Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Cálculos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"26\" viewBox=\"0 0 30 26\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.22222 2H7.77778C7.0116 2 6.2768 2.25754 5.73502 2.71596C5.19325 3.17438 4.88889 3.79614 4.88889 4.44444V10.5556C4.88889 11.2039 4.58452 11.8256 4.04275 12.284C3.50098 12.7425 2.76618 13 2 13C2.76618 13 3.50098 13.2575 4.04275 13.716C4.58452 14.1744 4.88889 14.7961 4.88889 15.4444V21.5556C4.88889 22.9 6.18889 24 7.77778 24H9.22222\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.7778 24H22.2222C22.9884 24 23.7232 23.7425 24.265 23.284C24.8067 22.8256 25.1111 22.2039 25.1111 21.5556V15.4444C25.1111 14.1 26.4111 13 28 13C27.2338 13 26.499 12.7425 25.9572 12.284C25.4155 11.8256 25.1111 11.2039 25.1111 10.5556V4.44444C25.1111 3.79614 24.8067 3.17438 24.265 2.71596C23.7232 2.25754 22.9884 2 22.2222 2H20.7778\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Variables", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"27\" height=\"26\" viewBox=\"0 0 27 26\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M6.91597 2H2V24H6.91597\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.0252 2H24.9412V24H20.0252\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Usuarios", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"34\" height=\"32\" viewBox=\"0 0 34 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M5.76926 10.6152V18.1537\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M25.1539 8.46154C24.89 12.0201 22.1923 14.9231 19.2308 14.9231C16.2692 14.9231 13.5668 12.0208 13.3077 8.46154C13.0385 4.75962 15.6635 2 19.2308 2C22.7981 2 25.4231 4.82692 25.1539 8.46154Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M19.2308 19.231C13.375 19.231 7.43172 22.4617 6.33192 28.5598C6.1973 29.2948 6.61528 30.0002 7.38528 30.0002H31.0769C31.8469 30.0002 32.2629 29.2948 32.1303 28.5598C31.0298 22.4617 25.0865 19.231 19.2308 19.231Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-miterlimit=\"10\"/><path d=\"M9.53846 14.3845H2\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Bancos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"46\" height=\"39\" viewBox=\"0 0 46 39\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M23.9337 1.22773L41.3032 10.1097C42.2384 10.5878 41.8983 12 40.8479 12H23H5.32026C4.2603 12 3.92872 10.5674 4.88087 10.1017L23.039 1.21978C23.3219 1.08143 23.6534 1.08438 23.9337 1.22773Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M39.7874 34.0171H6.68128C6.4944 34.0171 6.31127 34.0695 6.15264 34.1683L2.96871 36.1512C2.11517 36.6827 2.49182 38 3.49735 38H23H42.7282C43.7149 38 44.1053 36.7225 43.2872 36.1709L40.3464 34.188C40.1813 34.0766 39.9866 34.0171 39.7874 34.0171Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M24.2418 6.46774H22.7582C22.4835 6.46774 22.2637 6.29839 22.2637 6.08065C22.2637 5.8629 22.4835 5.69355 22.7582 5.69355H24.956C25.2857 5.69355 25.5879 5.45161 25.5879 5.1371C25.5879 4.82258 25.3132 4.58065 24.956 4.58065H24.3242V4.55645C24.3242 4.26613 24.0495 4 23.6923 4C23.3626 4 23.0604 4.24194 23.0604 4.55645V4.58065H22.7308C21.7692 4.58065 21 5.25806 21 6.05645C21 6.85484 21.7692 7.53226 22.7308 7.53226H24.2143C24.489 7.53226 24.7088 7.70161 24.7088 7.91935C24.7088 8.1371 24.489 8.30645 24.2143 8.30645H21.7418C21.4121 8.30645 21.1099 8.54839 21.1099 8.8629C21.1099 9.17742 21.3846 9.41936 21.7418 9.41936H23.0879V9.44355C23.0879 9.73387 23.3626 10 23.7198 10C24.0495 10 24.3516 9.75806 24.3516 9.44355V9.41936C25.2582 9.39516 26 8.74194 26 7.94355C25.9725 7.12097 25.2033 6.46774 24.2418 6.46774Z\" fill=\"var(--colors_gray08)\"/><path d=\"M10 16H12C12.5523 16 13 16.4477 13 17V29C13 29.5523 12.5523 30 12 30H10C9.44772 30 9 29.5523 9 29V17C9 16.4477 9.44772 16 10 16Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M18 16H20C20.5523 16 21 16.4477 21 17V29C21 29.5523 20.5523 30 20 30H18C17.4477 30 17 29.5523 17 29V17C17 16.4477 17.4477 16 18 16Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M26 16H28C28.5523 16 29 16.4477 29 17V29C29 29.5523 28.5523 30 28 30H26C25.4477 30 25 29.5523 25 29V17C25 16.4477 25.4477 16 26 16Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M34 16H36C36.5523 16 37 16.4477 37 17V29C37 29.5523 36.5523 30 36 30H34C33.4477 30 33 29.5523 33 29V17C33 16.4477 33.4477 16 34 16Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Obras sociales", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"42\" height=\"42\" viewBox=\"0 0 42 42\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M32 8H39C40.1046 8 41 8.89543 41 10V41H1V10C1 8.89543 1.89543 8 3 8H10\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M17 41V31.5C17 30.6716 17.6716 30 18.5 30H23.5C24.3284 30 25 30.6716 25 31.5V41\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M14 13.0001V10.1304V3C14 1.89543 14.8954 1 16 1H26C27.1046 1 28 1.89543 28 3V13C28 14.1046 27.1046 15 26 15H16C14.8954 15 14 14.1047 14 13.0001Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M18.6666 7.99976L23.3333 7.99976\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"square\"/><path d=\"M21 5.66675V10.3334\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"square\"/><path d=\"M6 30H12C12.5523 30 13 30.4477 13 31V35C13 35.5523 12.5523 36 12 36H6C5.44772 36 5 35.5523 5 35V31C5 30.4477 5.44772 30 6 30Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M30 30H36C36.5523 30 37 30.4477 37 31V35C37 35.5523 36.5523 36 36 36H30C29.4477 36 29 35.5523 29 35V31C29 30.4477 29.4477 30 30 30Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M6 19H12C12.5523 19 13 19.4477 13 20V24C13 24.5523 12.5523 25 12 25H6C5.44772 25 5 24.5523 5 24V20C5 19.4477 5.44772 19 6 19Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M18 19H24C24.5523 19 25 19.4477 25 20V24C25 24.5523 24.5523 25 24 25H18C17.4477 25 17 24.5523 17 24V20C17 19.4477 17.4477 19 18 19Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/><path d=\"M30 19H36C36.5523 19 37 19.4477 37 20V24C37 24.5523 36.5523 25 36 25H30C29.4477 25 29 24.5523 29 24V20C29 19.4477 29.4477 19 30 19Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Sindicatos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"46\" height=\"45\" viewBox=\"0 0 46 45\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M18.1806 3.18994L7.53711 6.80292C6.49116 7.15797 5.93108 8.29371 6.28613 9.33966L8.09905 14.6803C8.4541 15.7263 9.58984 16.2864 10.6358 15.9313L21.2793 12.3183C22.3252 11.9633 22.8853 10.8276 22.5303 9.78161L20.7173 4.44092C20.3623 3.39497 19.2266 2.83489 18.1806 3.18994Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M38.6335 10.592L28.0561 7.87815C26.9862 7.60364 25.8963 8.24844 25.6218 9.31835L24.2201 14.7814C23.9456 15.8513 24.5904 16.9412 25.6603 17.2157L36.2377 19.9296C37.3077 20.2041 38.3975 19.5593 38.672 18.4893L40.0737 13.0263C40.3482 11.9564 39.7034 10.8665 38.6335 10.592Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M8.29 26.79C10.455 26.79 12.21 25.0349 12.21 22.87C12.21 20.705 10.455 18.95 8.29 18.95C6.12504 18.95 4.37 20.705 4.37 22.87C4.37 25.0349 6.12504 26.79 8.29 26.79Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M2.78003 43.9999V31.1921C2.78003 30.7193 2.94751 30.2618 3.25276 29.9008L4.15082 28.8386C4.53083 28.3891 5.08952 28.1299 5.67809 28.1299H11.5608C11.9828 28.1299 12.3939 27.9964 12.7355 27.7486L15.2846 25.8988C15.8031 25.5226 16.11 24.9207 16.11 24.2801V21.4973C16.11 20.8192 16.4536 20.1873 17.0227 19.8187L17.2877 19.647C17.5568 19.4727 17.8707 19.3799 18.1914 19.3799V19.3799C18.6616 19.3799 19.1118 19.5812 19.4269 19.9302V19.9302C19.7047 20.2378 19.86 20.6393 19.86 21.0537V25.3899V26.1589C19.86 26.8002 19.5525 27.4026 19.0331 27.7787L13.037 32.121C12.5176 32.4972 12.21 33.0996 12.21 33.7409V43.9999\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M15.76 14.0801L17.86 20.2401\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M37.63 31.83C39.795 31.83 41.55 30.0749 41.55 27.91C41.55 25.745 39.795 23.99 37.63 23.99C35.4651 23.99 33.71 25.745 33.71 27.91C33.71 30.0749 35.4651 31.83 37.63 31.83Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M43.15 43.9999V36.2321C43.15 35.7593 42.9825 35.3018 42.6773 34.9408L41.7792 33.8786C41.3992 33.4292 40.8405 33.1699 40.2519 33.1699H34.3605C33.9377 33.1699 33.5258 33.0359 33.1839 32.7872L30.6434 30.939C30.1261 30.5626 29.82 29.9614 29.82 29.3217V26.5453C29.82 25.8683 29.4776 25.2373 28.91 24.8684L28.6295 24.6861C28.3622 24.5124 28.0504 24.4199 27.7316 24.4199V24.4199C27.2658 24.4199 26.8218 24.6171 26.5094 24.9627L26.4965 24.977C26.2155 25.2878 26.06 25.6919 26.06 26.1108V30.4299V31.1989C26.06 31.8402 26.3675 32.4426 26.8869 32.8188L32.8831 37.1611C33.4025 37.5372 33.71 38.1396 33.71 38.7809V43.9999\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M30.55 18.49L28.93 24.79\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Áreas", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"44\" height=\"41\" viewBox=\"0 0 44 41\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M9.65 30.4402H2.76C1.78798 30.4402 1 31.2282 1 32.2002V37.7202C1 38.6922 1.78798 39.4802 2.76 39.4802H9.65C10.622 39.4802 11.41 38.6922 11.41 37.7202V32.2002C11.41 31.2282 10.622 30.4402 9.65 30.4402Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M25.45 30.4402H18.56C17.588 30.4402 16.8 31.2282 16.8 32.2002V37.7202C16.8 38.6922 17.588 39.4802 18.56 39.4802H25.45C26.422 39.4802 27.21 38.6922 27.21 37.7202V32.2002C27.21 31.2282 26.422 30.4402 25.45 30.4402Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M25.45 1H18.56C17.588 1 16.8 1.78798 16.8 2.76V8.28C16.8 9.25202 17.588 10.04 18.56 10.04H25.45C26.422 10.04 27.21 9.25202 27.21 8.28V2.76C27.21 1.78798 26.422 1 25.45 1Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M41.24 30.4402H34.35C33.378 30.4402 32.59 31.2282 32.59 32.2002V37.7202C32.59 38.6922 33.378 39.4802 34.35 39.4802H41.24C42.212 39.4802 43 38.6922 43 37.7202V32.2002C43 31.2282 42.212 30.4402 41.24 30.4402Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M6.97003 20.6902H37.04\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linejoin=\"round\"/><path d=\"M6.21002 19.6902V26.9202\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linejoin=\"round\"/><path d=\"M37.8 19.6902V26.9202\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"10\"/><path d=\"M22.19 13.3701L22.03 26.9202\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Puestos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"33\" height=\"33\" viewBox=\"0 0 29 29\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g clip-path=\"url(#clip0_1481_1842)\"><path d=\"M11.8227 7.66458H9.36972V1.8141H11.8227V7.66458ZM18.8383 7.66458H16.3853V1.8141H18.8383V7.66458ZM9.41876 13.5764H4.7335V11.1234H9.41876V13.5764ZM23.4746 13.5764H18.7893V11.1234H23.4746V13.5764ZM24.6189 18.2616H3.72773C3.71238 18.2619 3.69426 18.262 3.6761 18.262C1.90787 18.262 0.429674 17.0201 0.0662266 15.3609L0.0617362 15.3364L0.0543808 15.2984C0.0197798 15.1122 0 14.8979 0 14.679C0 13.1346 0.984309 11.82 2.35986 11.3286L2.38471 11.3209C2.95232 5.30232 7.98009 0.630371 14.0991 0.630371C20.2085 0.630371 25.2302 5.28781 25.8072 11.2459L25.811 11.2939C27.2518 11.7703 28.2731 13.1049 28.2731 14.6781C28.2731 14.8973 28.2533 15.1119 28.2153 15.3202L28.2186 15.2984L28.2113 15.3352C27.8453 17.012 26.3783 18.2508 24.62 18.2617H24.6188L24.6189 18.2616ZM3.70321 15.8086H24.6189C25.2003 15.8084 25.6872 15.4035 25.8131 14.8602L25.8148 14.852C25.8235 14.7998 25.8285 14.7396 25.8285 14.6783C25.8285 14.0686 25.3343 13.5744 24.7246 13.5744C24.7103 13.5744 24.696 13.5747 24.6818 13.5753L24.6839 13.5752L23.4144 13.6218V12.3511C23.4144 7.20976 19.2466 3.04186 14.1052 3.04186C8.9639 3.04186 4.79603 7.20976 4.79603 12.3511V13.5776H3.5645C2.95485 13.5776 2.46063 14.0718 2.46063 14.6815C2.46063 14.7425 2.46559 14.8024 2.4751 14.8608L2.47427 14.8544C2.60182 15.4059 3.0886 15.8108 3.67004 15.8111H3.6701L3.70321 15.8086ZM4.73352 15.8086H24.7011V18.2702C24.6986 24.121 19.9551 28.863 14.104 28.863C8.25144 28.863 3.50698 24.1185 3.50698 18.2659V18.2614V18.2616V16.9738H4.7335L4.73352 15.8086ZM22.248 18.2616H5.95998C6.00021 22.7308 9.62989 26.339 14.1035 26.3444H14.104C18.5757 26.3328 22.2017 22.7284 22.248 18.2661L22.248 18.2616Z\" fill=\"var(--colors_gray08)\"/></g><defs><clipPath id=\"clip0_1481_1842\"><rect width=\"28.2927\" height=\"29\" fill=\"white\"/></clipPath></defs></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Motivos de egreso", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"33\" height=\"30\" viewBox=\"0 0 34 31\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M18.8243 15.4997H32.5896M32.5896 15.4997L27.4914 9.38184M32.5896 15.4997L27.4914 21.6177\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.65\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.3537 7.8526V5.05916C20.3537 3.26955 18.8241 1.86216 17.0407 2.01078L4.80492 3.03042C3.21948 3.16255 2 4.48789 2 6.07882V24.9211C2 26.5121 3.2195 27.8374 4.80492 27.9695L17.0407 28.9892C18.8241 29.1379 20.3537 27.7305 20.3537 25.9408V23.1474\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Parámetros país", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"29\" viewBox=\"0 0 26 29\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M24.8137 2.70667C24.4428 2.44166 24.0141 2.26708 23.5623 2.1971C23.1106 2.12712 22.6486 2.1637 22.2138 2.30389C21.0668 2.62367 19.8788 2.77565 18.6875 2.755C16.927 2.66026 15.2008 2.23376 13.6013 1.49833C11.6253 0.592296 9.48796 0.0830623 7.31252 0C2.61627 0 0.812527 1.61111 0.487527 1.83667C0.332028 1.98778 0.208745 2.16833 0.125 2.3676C0.0412551 2.56687 -0.00124396 2.78079 2.77175e-05 2.99667V27.3889C2.77175e-05 27.8162 0.171233 28.226 0.475979 28.5281C0.780725 28.8303 1.19405 29 1.62503 29C2.056 29 2.46933 28.8303 2.77407 28.5281C3.07882 28.226 3.25002 27.8162 3.25002 27.3889V20.4611C4.54487 19.9696 5.92716 19.7448 7.31252 19.8006C9.07306 19.8953 10.7993 20.3218 12.3988 21.0572C14.3747 21.9633 16.5121 22.4725 18.6875 22.5556C20.6465 22.6289 22.5952 22.2425 24.375 21.4278C24.8547 21.2044 25.2614 20.8518 25.5487 20.4102C25.8361 19.9687 25.9924 19.456 26 18.9306V5.01056C25.9994 4.56101 25.8917 4.11798 25.6855 3.71759C25.4794 3.3172 25.1806 2.9708 24.8137 2.70667ZM22.75 18.6728C21.4547 19.1626 20.0728 19.3873 18.6875 19.3333C16.9248 19.2407 15.1972 18.8084 13.6013 18.0606C11.6215 17.1676 9.48577 16.6642 7.31252 16.5783C5.94346 16.5549 4.57733 16.7121 3.25002 17.0456V3.89889C4.54184 3.39515 5.92559 3.16467 7.31252 3.22222C9.07524 3.31483 10.8029 3.74715 12.3988 4.495C14.3785 5.38796 16.5143 5.89135 18.6875 5.97722C20.0574 5.99728 21.4238 5.83471 22.75 5.49389V18.6728Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Impuesto a las ganancias", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"45\" height=\"18\" viewBox=\"0 0 45 18\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M1.12 17.4C0.853333 17.4 0.626667 17.3067 0.44 17.12C0.28 16.9333 0.2 16.72 0.2 16.48V1.72C0.2 1.42667 0.28 1.2 0.44 1.04C0.626667 0.879999 0.853333 0.799999 1.12 0.799999C1.41333 0.799999 1.65333 0.879999 1.84 1.04C2.02667 1.2 2.12 1.42667 2.12 1.72V16.48C2.12 16.72 2.02667 16.9333 1.84 17.12C1.65333 17.3067 1.41333 17.4 1.12 17.4ZM7.44813 17.4C7.18146 17.4 6.95479 17.3067 6.76813 17.12C6.60813 16.9333 6.52813 16.72 6.52813 16.48V1.72C6.52813 1.42667 6.60813 1.2 6.76813 1.04C6.95479 0.879999 7.18146 0.799999 7.44813 0.799999C7.74146 0.799999 7.98146 0.879999 8.16813 1.04C8.35479 1.2 8.44813 1.42667 8.44813 1.72V16.48C8.44813 16.72 8.35479 16.9333 8.16813 17.12C7.98146 17.3067 7.74146 17.4 7.44813 17.4ZM19.5763 17.4C18.0563 17.4 16.6963 17.04 15.4963 16.32C14.3229 15.5733 13.3896 14.56 12.6963 13.28C12.0029 12 11.6563 10.5733 11.6563 9C11.6563 7.4 12.0029 5.98667 12.6963 4.76C13.3896 3.53333 14.3363 2.57333 15.5363 1.88C16.7629 1.16 18.1496 0.799999 19.6963 0.799999C20.7629 0.799999 21.7496 0.973332 22.6563 1.32C23.5896 1.66667 24.4296 2.12 25.1763 2.68C25.3896 2.81333 25.4963 3.02667 25.4963 3.32C25.4963 3.56 25.4029 3.78667 25.2163 4C25.0563 4.21333 24.8429 4.32 24.5763 4.32C24.4163 4.32 24.2296 4.24 24.0163 4.08C23.3496 3.46667 22.6563 3.05333 21.9363 2.84C21.2429 2.6 20.5096 2.48 19.7363 2.48C17.8696 2.48 16.3629 3.08 15.2163 4.28C14.0963 5.48 13.5363 7.05333 13.5363 9C13.5363 10.9467 14.0829 12.56 15.1763 13.84C16.2696 15.0933 17.7363 15.72 19.5763 15.72C21.1763 15.72 22.4829 15.2667 23.4963 14.36C24.5096 13.4533 25.0829 12.3067 25.2163 10.92C25.2696 10.4933 25.0696 10.28 24.6163 10.28H20.6562C20.3896 10.28 20.1763 10.2 20.0163 10.04C19.8829 9.85333 19.8163 9.66667 19.8163 9.48C19.8163 9.26667 19.8829 9.08 20.0163 8.92C20.1763 8.76 20.3896 8.68 20.6562 8.68H25.2963C26.4696 8.68 27.0563 9.25333 27.0563 10.4C27.0563 11.6267 26.7496 12.7733 26.1363 13.84C25.5229 14.9067 24.6563 15.7733 23.5363 16.44C22.4429 17.08 21.1229 17.4 19.5763 17.4ZM37.1544 17.4C35.6344 17.4 34.2744 17.04 33.0744 16.32C31.901 15.5733 30.9677 14.56 30.2744 13.28C29.581 12 29.2344 10.5733 29.2344 9C29.2344 7.4 29.581 5.98667 30.2744 4.76C30.9677 3.53333 31.9144 2.57333 33.1144 1.88C34.341 1.16 35.7277 0.799999 37.2744 0.799999C38.341 0.799999 39.3277 0.973332 40.2344 1.32C41.1677 1.66667 42.0077 2.12 42.7544 2.68C42.9677 2.81333 43.0744 3.02667 43.0744 3.32C43.0744 3.56 42.981 3.78667 42.7944 4C42.6344 4.21333 42.421 4.32 42.1544 4.32C41.9944 4.32 41.8077 4.24 41.5944 4.08C40.9277 3.46667 40.2344 3.05333 39.5144 2.84C38.821 2.6 38.0877 2.48 37.3144 2.48C35.4477 2.48 33.941 3.08 32.7944 4.28C31.6744 5.48 31.1144 7.05333 31.1144 9C31.1144 10.9467 31.661 12.56 32.7544 13.84C33.8477 15.0933 35.3144 15.72 37.1544 15.72C38.7544 15.72 40.061 15.2667 41.0744 14.36C42.0877 13.4533 42.661 12.3067 42.7944 10.92C42.8477 10.4933 42.6477 10.28 42.1944 10.28H38.2344C37.9677 10.28 37.7544 10.2 37.5944 10.04C37.461 9.85333 37.3944 9.66667 37.3944 9.48C37.3944 9.26667 37.461 9.08 37.5944 8.92C37.7544 8.76 37.9677 8.68 38.2344 8.68H42.8744C44.0477 8.68 44.6344 9.25333 44.6344 10.4C44.6344 11.6267 44.3277 12.7733 43.7144 13.84C43.101 14.9067 42.2344 15.7733 41.1144 16.44C40.021 17.08 38.701 17.4 37.1544 17.4Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Componentes de fórmula", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"43\" height=\"39\" viewBox=\"0 0 43 39\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M32.0441 22.8124C32.1259 22.3436 32.5507 22 33.0484 22H35.3961C35.8938 22 36.3186 22.3436 36.4004 22.8124L36.5936 23.9195C36.6501 24.2427 36.8763 24.512 37.1766 24.6707C37.2437 24.7062 37.3101 24.7428 37.3756 24.7806C37.6698 24.9502 38.0276 25.003 38.3494 24.8879L39.4507 24.4939C39.9168 24.3271 40.4408 24.5066 40.6897 24.9182L41.8635 26.8596C42.1124 27.2712 42.0132 27.7942 41.6289 28.0963L40.7199 28.8108C40.4552 29.0189 40.3239 29.3403 40.3303 29.6676C40.331 29.7043 40.3314 29.741 40.3314 29.7778C40.3314 29.8146 40.331 29.8513 40.3303 29.8879C40.3239 30.2153 40.4552 30.5366 40.7199 30.7447L41.6289 31.4593C42.0132 31.7613 42.1124 32.2844 41.8635 32.696L40.6897 34.6373C40.4408 35.0489 39.9168 35.2284 39.4507 35.0617L38.3494 34.6677C38.0276 34.5526 37.6698 34.6053 37.3756 34.7749C37.3101 34.8127 37.2437 34.8494 37.1766 34.8849C36.8763 35.0436 36.6501 35.3128 36.5936 35.6361L36.4004 36.7432C36.3186 37.212 35.8938 37.5556 35.3961 37.5556H33.0484C32.5507 37.5556 32.1259 37.212 32.0441 36.7432L31.8508 35.6361C31.7944 35.3128 31.5682 35.0436 31.2679 34.8849C31.2008 34.8494 31.1344 34.8127 31.0689 34.7749C30.7747 34.6053 30.4169 34.5526 30.0951 34.6677L28.9937 35.0617C28.5277 35.2284 28.0036 35.0489 27.7548 34.6374L26.5809 32.696C26.3321 32.2844 26.4313 31.7613 26.8156 31.4593L27.7246 30.7448C27.9893 30.5366 28.1205 30.2153 28.1142 29.8879C28.1135 29.8513 28.1131 29.8146 28.1131 29.7778C28.1131 29.741 28.1135 29.7043 28.1142 29.6676C28.1205 29.3403 27.9893 29.0189 27.7246 28.8108L26.8156 28.0963C26.4313 27.7942 26.3321 27.2712 26.5809 26.8596L27.7548 24.9182C28.0036 24.5066 28.5276 24.3272 28.9937 24.4939L30.0951 24.8879C30.4169 25.003 30.7747 24.9502 31.0688 24.7806C31.1344 24.7428 31.2008 24.7062 31.2679 24.6707C31.5682 24.512 31.7944 24.2427 31.8508 23.9195L32.0441 22.8124Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M32.0441 22.8124C32.1259 22.3436 32.5507 22 33.0484 22H35.3961C35.8938 22 36.3186 22.3436 36.4004 22.8124L36.5936 23.9195C36.6501 24.2427 36.8763 24.512 37.1766 24.6707C37.2437 24.7062 37.3101 24.7428 37.3756 24.7806C37.6698 24.9502 38.0276 25.003 38.3494 24.8879L39.4507 24.4939C39.9168 24.3271 40.4408 24.5066 40.6897 24.9182L41.8635 26.8596C42.1124 27.2712 42.0132 27.7942 41.6289 28.0963L40.7199 28.8108C40.4552 29.0189 40.3239 29.3403 40.3303 29.6676C40.331 29.7043 40.3314 29.741 40.3314 29.7778C40.3314 29.8146 40.331 29.8513 40.3303 29.8879C40.3239 30.2153 40.4552 30.5366 40.7199 30.7447L41.6289 31.4593C42.0132 31.7613 42.1124 32.2844 41.8635 32.696L40.6897 34.6373C40.4408 35.0489 39.9168 35.2284 39.4507 35.0617L38.3494 34.6677C38.0276 34.5526 37.6698 34.6053 37.3756 34.7749C37.3101 34.8127 37.2437 34.8494 37.1766 34.8849C36.8763 35.0436 36.6501 35.3128 36.5936 35.6361L36.4004 36.7432C36.3186 37.212 35.8938 37.5556 35.3961 37.5556H33.0484C32.5507 37.5556 32.1259 37.212 32.0441 36.7432L31.8508 35.6361C31.7944 35.3128 31.5682 35.0436 31.2679 34.8849C31.2008 34.8494 31.1344 34.8127 31.0689 34.7749C30.7747 34.6053 30.4169 34.5526 30.0951 34.6677L28.9937 35.0617C28.5277 35.2284 28.0036 35.0489 27.7548 34.6374L26.5809 32.696C26.3321 32.2844 26.4313 31.7613 26.8156 31.4593L27.7246 30.7448C27.9893 30.5366 28.1205 30.2153 28.1142 29.8879C28.1135 29.8513 28.1131 29.8146 28.1131 29.7778C28.1131 29.741 28.1135 29.7043 28.1142 29.6676C28.1205 29.3403 27.9893 29.0189 27.7246 28.8108L26.8156 28.0963C26.4313 27.7942 26.3321 27.2712 26.5809 26.8596L27.7548 24.9182C28.0036 24.5066 28.5276 24.3272 28.9937 24.4939L30.0951 24.8879C30.4169 25.003 30.7747 24.9502 31.0688 24.7806C31.1344 24.7428 31.2008 24.7062 31.2679 24.6707C31.5682 24.512 31.7944 24.2427 31.8508 23.9195L32.0441 22.8124Z\" stroke=\"black\" stroke-opacity=\"0.2\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M36.9372 29.7777C36.9372 31.2096 35.7216 32.3703 34.222 32.3703C32.7225 32.3703 31.5069 31.2096 31.5069 29.7777C31.5069 28.3459 32.7225 27.1851 34.222 27.1851C35.7216 27.1851 36.9372 28.3459 36.9372 29.7777Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M36.9372 29.7777C36.9372 31.2096 35.7216 32.3703 34.222 32.3703C32.7225 32.3703 31.5069 31.2096 31.5069 29.7777C31.5069 28.3459 32.7225 27.1851 34.222 27.1851C35.7216 27.1851 36.9372 28.3459 36.9372 29.7777Z\" stroke=\"black\" stroke-opacity=\"0.2\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M33.1111 15.8889V6C33.1111 3.79086 31.3202 2 29.1111 2H6C3.79086 2 2 3.79086 2 6V26.8889C2 29.098 3.79086 30.8889 6 30.8889H20.7739\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.7\" stroke-linecap=\"round\"/><path d=\"M10.8241 8.09927C10.0649 7.37439 8.87025 7.38623 8.11111 8.11111C7.35198 8.83599 7.90753 10.1641 8.66667 10.8889L11.4445 13.6667L8.20928 16.6367C7.45014 17.3616 7.45014 18.4892 8.20928 19.214C8.54667 19.5362 9.05276 19.7778 9.55885 19.7778C10.0649 19.7778 10.571 19.6168 10.9084 19.214L15.1259 15.1869C15.9693 14.3815 15.9693 13.0929 15.1259 12.2874L10.8241 8.09927Z\" fill=\"var(--colors_gray08)\"/><path d=\"M23.2778 18.5554H17.1256\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.7\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Religiones", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"40\" height=\"34\" viewBox=\"0 0 40 34\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M32.0909 28.6364V31.0909C32.0909 31.6432 32.5386 32.0909 33.0909 32.0909H37.9132C38.4982 32.0909 38.9583 31.5909 38.9097 31.0079L37.9249 19.1897C37.8817 18.6714 37.4484 18.2727 36.9284 18.2727H33.0909C32.5386 18.2727 32.0909 18.7204 32.0909 19.2727V19.4242M32.0909 28.6364C32.0909 28.6364 28.0606 28.6364 25.7576 28.6364C24.8305 28.6364 24.6061 28.6364 23.4545 28.6364C22.7465 28.6364 21.9577 27.758 21.7693 27.5356C21.7409 27.502 21.7159 27.4659 21.6933 27.4282L20 24.6061M32.0909 28.6364V19.4242M20 24.6061L18.5041 27.0992C18.3518 27.3531 18.1449 27.5701 17.8985 27.7343L17.0493 28.3005C16.7208 28.5195 16.3352 28.6364 15.9404 28.6364C15.4991 28.6364 14.8708 28.6364 14.2424 28.6364C13.0909 28.6364 9.63636 28.6364 9.63636 28.6364C9.63636 28.6364 9.63636 28.6364 9.63636 28.6364H7.90909M20 24.6061V1.57576M7.90909 28.6364V31.0909C7.90909 31.6432 7.46138 32.0909 6.90909 32.0909H2.0868C1.50176 32.0909 1.04167 31.5909 1.09025 31.0079L2.0751 19.1897C2.11829 18.6714 2.55156 18.2727 3.07165 18.2727H6.90909C7.46137 18.2727 7.90909 18.7204 7.90909 19.2727V19.4242M7.90909 28.6364V19.4242M7.90909 19.4242H9.95945C10.4899 19.4242 10.9986 19.2135 11.3737 18.8385L11.6257 18.5865C11.8323 18.3798 11.9912 18.1304 12.091 17.8557L14.2424 11.9394L16.4803 2.42843C16.5229 2.24741 16.6151 2.08186 16.7466 1.95036L17.2966 1.40036C17.545 1.15198 17.9055 1.05213 18.2463 1.13732L20 1.57576M20 1.57576L21.7537 1.13732C22.0945 1.05213 22.455 1.15198 22.7034 1.40036L23.2534 1.95036C23.3849 2.08185 23.4771 2.24741 23.5197 2.42843L25.7576 11.9394L27.909 17.8557C28.0088 18.1304 28.1677 18.3798 28.3743 18.5865L28.6263 18.8385C29.0014 19.2135 29.5101 19.4242 30.0405 19.4242H32.0909\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Formulario 1357", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"32\" viewBox=\"0 0 26 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M16 1H4C3.20435 1 2.44129 1.31607 1.87868 1.87868C1.31607 2.44129 1 3.20435 1 4V28C1 28.7956 1.31607 29.5587 1.87868 30.1213C2.44129 30.6839 3.20435 31 4 31H22C22.7956 31 23.5587 30.6839 24.1213 30.1213C24.6839 29.5587 25 28.7956 25 28V10L16 1Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M16 1V10H25\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M19 17.5002H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M19 23.5H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M10 11.5H8.5H7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Importar legajos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"35\" height=\"25\" viewBox=\"0 0 27 17\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M7.52817 10.3C10.1157 10.3 12.1782 8.2 12.1782 5.65C12.1782 3.1 10.0782 1 7.52817 1C4.97817 1 2.87817 3.0625 2.87817 5.65C2.87817 8.2375 4.97817 10.3 7.52817 10.3ZM7.52817 2.65C9.17817 2.65 10.4907 4 10.4907 5.6125C10.4907 7.225 9.14067 8.575 7.52817 8.575C5.87817 8.575 4.56567 7.225 4.56567 5.6125C4.56567 4 5.87817 2.65 7.52817 2.65Z\" fill=\"var(--colors_gray08)\"/><path d=\"M7.52812 11.4624C4.82812 11.4624 2.24063 12.5499 0.253125 14.5749C-0.084375 14.9124 -0.084375 15.4374 0.253125 15.7749C0.403125 15.9249 0.628125 16.0374 0.853125 16.0374C1.07812 16.0374 1.30312 15.9624 1.45312 15.7749C3.10312 14.0874 5.27812 13.1499 7.52812 13.1499C9.74062 13.1499 11.9156 14.0874 13.6031 15.7749C13.9406 16.1124 14.4656 16.1124 14.8031 15.7749C15.1406 15.4374 15.1406 14.9124 14.8031 14.5749C12.8156 12.5874 10.2281 11.4624 7.52812 11.4624Z\" fill=\"var(--colors_gray08)\"/><path d=\"M17.0906 10.3C18.5906 10.3 19.8281 9.06245 19.8281 7.56245C19.8281 6.06245 18.5906 4.82495 17.0906 4.82495C15.5906 4.82495 14.3531 6.06245 14.3531 7.56245C14.3156 9.06245 15.5531 10.3 17.0906 10.3ZM17.0906 6.47495C17.6906 6.47495 18.1406 6.96245 18.1406 7.52495C18.1406 8.12495 17.6531 8.57495 17.0906 8.57495C16.5281 8.57495 16.0406 8.08745 16.0406 7.52495C16.0031 6.96245 16.4906 6.47495 17.0906 6.47495Z\" fill=\"var(--colors_gray08)\"/><path d=\"M22.4156 13.6C20.4281 11.7625 17.6906 11.0125 14.9531 11.725C14.5031 11.8375 14.2406 12.2875 14.3531 12.7375C14.4656 13.1875 14.9531 13.45 15.3656 13.3375C17.5406 12.775 19.7156 13.3375 21.2531 14.8C21.4031 14.95 21.6281 15.025 21.8156 15.025C22.0406 15.025 22.2656 14.95 22.4156 14.7625C22.7906 14.4625 22.7531 13.9375 22.4156 13.6Z\" fill=\"var(--colors_gray08)\"/><path d=\"M23.625 1V6.24986\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M26.2499 3.625H21\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.7\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Importar liquidaciones históricas", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"25\" height=\"27\" viewBox=\"0 0 20 22\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M11.1609 13.0729L8.31344 15.7692M8.31344 15.7692L5.62243 13.0729M8.31344 15.7692L8.39166 10.2308\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.25\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M5.0918 1H14.5918L19.0918 5.5V18\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M1.0918 18C1.0918 19.6569 2.43494 21 4.0918 21H14.5918C15.4202 21 16.0918 20.3284 16.0918 19.5V7.74853C16.0918 7.5894 16.0286 7.43679 15.9161 7.32426L12.7675 4.17574C12.655 4.06321 12.5024 4 12.3433 4H2.5918C1.76337 4 1.0918 4.67157 1.0918 5.5V18Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M12.0918 4V7.4C12.0918 7.73137 12.3604 8 12.6918 8H16.0918\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Libro de sueldos digital", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"26\" viewBox=\"0 0 20 16\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M10 2.253V15.253M10 2.253C8.832 1.477 7.246 1 5.5 1C3.754 1 2.168 1.477 1 2.253V15.253C2.168 14.477 3.754 14 5.5 14C7.246 14 8.832 14.477 10 15.253M10 2.253C11.168 1.477 12.754 1 14.5 1C16.247 1 17.832 1.477 19 2.253V15.253C17.832 14.477 16.247 14 14.5 14C12.754 14 11.168 14.477 10 15.253\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "A.R.T.", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"23\" height=\"35\" viewBox=\"0 0 23 35\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M9.64288 2C10.8887 2 11.9121 3.0234 11.9121 4.2691C11.9121 5.5149 10.8887 6.5383 9.64288 6.5383C8.39718 6.5383 7.37378 5.5149 7.37378 4.2691C7.37378 3.0234 8.39718 2 9.64288 2ZM13.9121 4.2691C13.9121 1.91883 11.9933 0 9.64288 0C7.29258 0 5.37378 1.91883 5.37378 4.2691C5.37378 6.6195 7.29258 8.5383 9.64288 8.5383C11.9933 8.5383 13.9121 6.6195 13.9121 4.2691Z\" fill=\"var(--colors_gray08)\"/><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M16.1816 8.3384C15.9917 8.1232 15.7186 8 15.4317 8H4.73926V10H14.9805L20.6561 16.4324C21.1183 16.9563 21.0563 17.7585 20.519 18.2051C19.9918 18.6433 19.2089 18.5701 18.772 18.0417L15.5173 14.1046C15.4091 13.6691 15.0156 13.3464 14.5467 13.3464C13.9944 13.3464 13.5467 13.7941 13.5467 14.3464V32.0579C13.5467 32.4046 13.2589 32.6924 12.9121 32.6924C12.5654 32.6924 12.2776 32.4046 12.2776 32.0579V23.885C12.2776 23.3327 11.8299 22.885 11.2776 22.885H8.00836C7.45606 22.885 7.00836 23.3327 7.00836 23.885V32.0579C7.00836 32.4046 6.72056 32.6924 6.37376 32.6924C6.02706 32.6924 5.73926 32.4046 5.73926 32.0579V17H3.73926V32.0579C3.73926 33.5092 4.92246 34.6924 6.37376 34.6924C7.82506 34.6924 9.00836 33.5092 9.00836 32.0579V24.885H10.2776V32.0579C10.2776 33.5092 11.4608 34.6924 12.9121 34.6924C14.3634 34.6924 15.5467 33.5092 15.5467 32.0579V17.2791L17.2305 19.316C18.3725 20.6974 20.4192 20.8888 21.7975 19.7431C23.202 18.5757 23.3641 16.4786 22.1558 15.1092L16.1816 8.3384Z\" fill=\"var(--colors_gray08)\"/><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M11.6416 19.3442C11.9188 18.7897 11.7291 18.1153 11.2033 17.7867L4.90157 13.848C4.43327 13.5553 4.29087 12.9384 4.58357 12.47C4.87627 12.0017 5.49327 11.8593 5.96157 12.152L12.2634 16.0907C13.6634 16.9658 14.1688 18.7618 13.4305 20.2385C12.5748 21.95 10.4193 22.5341 8.81657 21.4889L2.26367 17.2153C0.189973 15.863 -0.570028 13.1872 0.450072 10.9429C1.25997 9.16104 3.04307 8.00014 5.00757 8.00024L9.93177 8.00064L9.93167 10.0006L5.00747 10.0002C3.83457 10.0001 2.75917 10.6961 2.27087 11.7705C1.65537 13.1246 2.11897 14.7333 3.35617 15.5401L9.90907 19.8137C10.5109 20.2061 11.3203 19.9868 11.6416 19.3442Z\" fill=\"var(--colors_gray08)\"/><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M6.08618 17.9661L12.0862 8.46606L13.7771 9.53406L7.77708 19.034L6.08618 17.9661Z\" fill=\"var(--colors_gray08)\"/><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M16.9316 23C16.9316 21.3431 18.2748 20 19.9316 20C21.5885 20 22.9316 21.3431 22.9316 23V34C22.9316 34.5523 22.4839 35 21.9316 35C21.3793 35 20.9316 34.5523 20.9316 34V23C20.9316 22.4477 20.4839 22 19.9316 22C19.3793 22 18.9316 22.4477 18.9316 23V23.5C18.9316 24.0523 18.4839 24.5 17.9316 24.5C17.3793 24.5 16.9316 24.0523 16.9316 23.5V23Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Estados civiles", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"31\" height=\"19\" viewBox=\"0 0 31 19\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M12.25 17.3125C11.3125 17.6875 10.375 17.875 9.4375 17.875C4.75 17.875 1 14.125 1 9.4375C1 4.75 4.75 1 9.4375 1C14.125 1 17.875 4.75 17.875 9.4375C17.875 10.75 17.5 12.0625 16.9375 13.1875M18.0625 1.375C18.8125 1.1875 19.75 1 20.6875 1C25.375 1 29.125 4.75 29.125 9.4375C29.125 14.125 25.375 17.875 20.6875 17.875C16 17.875 12.25 14.125 12.25 9.4375C12.25 8.125 12.625 6.8125 13.1875 5.6875\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Sexos", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"34\" height=\"30\" viewBox=\"0 0 34 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M33.6599 2.1225C33.6473 1.61907 33.2873 1.19164 32.7934 1.09349L27.3954 0.0208549C26.812 -0.0950483 26.2453 0.283841 26.1294 0.867112C26.0134 1.45039 26.3924 2.01716 26.9756 2.13311L30.3508 2.80374L27.3078 5.35718C27.0896 5.13232 26.8598 4.91741 26.619 4.7134C24.9186 3.27224 22.7733 2.46143 20.5448 2.4174C18.3163 2.37336 16.1407 3.09892 14.3847 4.47183C12.6287 5.84464 11.3996 7.78086 10.9046 9.95425C10.4096 12.1275 10.6789 14.405 11.6672 16.403C11.9308 16.9359 12.5767 17.1543 13.1097 16.8907C13.6427 16.6271 13.8611 15.9812 13.5975 15.4481C12.8288 13.8942 12.6194 12.1228 13.0044 10.4325C13.3893 8.74208 14.3453 7.23613 15.7111 6.16836C17.0768 5.10059 18.769 4.53623 20.5023 4.5705C22.2356 4.60468 23.9041 5.23541 25.2267 6.35623C26.5493 7.47714 27.445 9.0197 27.7629 10.7239C28.0809 12.4282 27.8017 14.1899 26.9723 15.7122C26.1429 17.2346 24.8141 18.4246 23.2098 19.0815C21.6055 19.7386 19.8237 19.8223 18.1647 19.3189C17.5957 19.1462 16.9944 19.4675 16.8217 20.0366C16.649 20.6057 16.9703 21.2069 17.5394 21.3796C19.6723 22.027 21.9632 21.9192 24.0259 21.0745C26.0886 20.2298 27.7971 18.6999 28.8635 16.7425C29.9297 14.7852 30.2888 12.5201 29.88 10.3289C29.6626 9.16419 29.2355 8.05811 28.6274 7.06113L31.5679 4.59379L31.6461 7.70284C31.661 8.29733 32.1551 8.76714 32.7496 8.75222C33.3441 8.73719 33.8139 8.24316 33.7989 7.64867L33.6599 2.1225Z\" fill=\"var(--colors_gray08)\"/><path d=\"M3.25924 7.76589C4.16322 6.28661 5.54946 5.1641 7.1844 4.58764C8.81944 4.01108 10.6031 4.01587 12.235 4.60097C12.7948 4.8017 13.4113 4.51065 13.6121 3.9509C13.8128 3.39114 13.5218 2.77459 12.9619 2.57386C10.8638 1.8215 8.57045 1.81542 6.46833 2.55668C4.3662 3.29782 2.58383 4.74105 1.42163 6.6431C0.259413 8.54506 -0.211617 10.7895 0.087919 12.9983C0.387455 15.2071 1.43925 17.245 3.06603 18.7688C4.59379 20.1998 6.541 21.0951 8.61411 21.3269V23.5389L5.38365 23.5391C4.78898 23.5392 4.30696 24.0213 4.30696 24.616C4.30706 25.2107 4.78916 25.6927 5.38384 25.6927L8.61411 25.6924V28.9231C8.61411 29.5177 9.09622 29.9999 9.6909 29.9999C10.2856 29.9999 10.7677 29.5177 10.7677 28.9231V25.6922L13.9979 25.692C14.5926 25.692 15.0746 25.2099 15.0746 24.6152C15.0745 24.0205 14.5924 23.5384 13.9978 23.5385L10.7677 23.5388V21.3269C12.3803 21.1465 13.9317 20.5629 15.2733 19.6175C17.0953 18.3335 18.419 16.4606 19.0213 14.3146C19.6235 12.1685 19.4677 9.8805 18.5798 7.83593C18.3429 7.29045 17.7087 7.04033 17.1632 7.27721C16.6178 7.51409 16.3676 8.14829 16.6045 8.69377C17.2951 10.2839 17.4163 12.0636 16.9479 13.7327C16.4794 15.4019 15.4499 16.8585 14.0328 17.8571C12.7715 18.7459 11.2719 19.2236 9.73793 19.2332C9.72235 19.2326 9.70667 19.2322 9.6909 19.2322C9.67503 19.2322 9.65935 19.2326 9.64367 19.2332C9.48538 19.2322 9.3268 19.2263 9.16813 19.2152C7.43865 19.0949 5.80352 18.3822 4.53821 17.1971C3.27294 16.0119 2.45489 14.4268 2.22192 12.7089C1.98895 10.991 2.35529 9.24526 3.25924 7.76589Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Bases de cálculo", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"31\" height=\"31\" viewBox=\"0 0 31 31\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M15.4172 2.09338e-07H15.5828C18.9112 -1.42093e-05 21.5195 -2.8683e-05 23.5547 0.273593C25.6377 0.55366 27.2816 1.1381 28.5718 2.42829C29.8619 3.71849 30.4463 5.36224 30.7265 7.44535C31 9.48051 31 12.0889 31 15.4172V15.5828C31 18.9112 31 21.5195 30.7265 23.5547C30.4463 25.6377 29.8619 27.2816 28.5718 28.5718C27.2816 29.8619 25.6377 30.4463 23.5547 30.7265C21.5195 31 18.9112 31 15.5828 31H15.4172C12.0889 31 9.48051 31 7.44535 30.7265C5.36224 30.4463 3.71849 29.8619 2.42829 28.5718C1.1381 27.2816 0.55366 25.6377 0.273593 23.5547C-2.8683e-05 21.5195 -1.42093e-05 18.9112 2.09338e-07 15.5828V15.4172C-1.42093e-05 12.0889 -2.8683e-05 9.48051 0.273593 7.44535C0.55366 5.36224 1.1381 3.71849 2.42829 2.42829C3.71849 1.1381 5.36224 0.55366 7.44535 0.273593C9.48051 -2.8683e-05 12.0889 -1.42093e-05 15.4172 2.09338e-07ZM7.73353 2.41709C5.89025 2.66492 4.77898 3.13625 3.95762 3.95762C3.13625 4.77898 2.66492 5.89025 2.41709 7.73353C2.16508 9.60792 2.16279 12.0709 2.16279 15.5C2.16279 18.929 2.16508 21.392 2.41709 23.2664C2.66492 25.1097 3.13625 26.221 3.95762 27.0424C4.77898 27.8638 5.89025 28.3352 7.73353 28.5829C9.60792 28.8349 12.0709 28.8372 15.5 28.8372C18.929 28.8372 21.392 28.8349 23.2664 28.5829C25.1097 28.3352 26.221 27.8638 27.0424 27.0424C27.8638 26.221 28.3352 25.1097 28.5829 23.2664C28.8349 21.392 28.8372 18.929 28.8372 15.5C28.8372 12.0709 28.8349 9.60792 28.5829 7.73353C28.3352 5.89025 27.8638 4.77898 27.0424 3.95762C26.221 3.13625 25.1097 2.66492 23.2664 2.41709C21.392 2.16508 18.929 2.16279 15.5 2.16279C12.0709 2.16279 9.60792 2.16508 7.73353 2.41709Z\" fill=\"var(--colors_gray08)\"/><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M9.73257 6.48853C10.3298 6.48853 10.814 6.97267 10.814 7.56992V9.37226H12.6163C13.2135 9.37226 13.6977 9.85642 13.6977 10.4537C13.6977 11.0509 13.2135 11.5351 12.6163 11.5351H10.814V13.3374C10.814 13.9346 10.3298 14.4188 9.73257 14.4188C9.13534 14.4188 8.65118 13.9346 8.65118 13.3374V11.5351H6.84885C6.25162 11.5351 5.76746 11.0509 5.76746 10.4537C5.76746 9.85642 6.25162 9.37226 6.84885 9.37226H8.65118V7.56992C8.65118 6.97267 9.13534 6.48853 9.73257 6.48853ZM17.3023 10.4536C17.3023 9.85639 17.7865 9.37225 18.3837 9.37225H24.1512C24.7484 9.37225 25.2326 9.85639 25.2326 10.4536C25.2326 11.0509 24.7484 11.535 24.1512 11.535H18.3837C17.7865 11.535 17.3023 11.0509 17.3023 10.4536ZM17.3023 19.1048C17.3023 18.5076 17.7865 18.0234 18.3837 18.0234H24.1512C24.7484 18.0234 25.2326 18.5076 25.2326 19.1048C25.2326 19.7021 24.7484 20.1862 24.1512 20.1862H18.3837C17.7865 20.1862 17.3023 19.7021 17.3023 19.1048ZM6.80512 18.3402C7.22743 17.9179 7.91214 17.9179 8.33444 18.3402L9.73259 19.7382L11.1307 18.3402C11.553 17.9179 12.2377 17.9179 12.66 18.3402C13.0823 18.7625 13.0823 19.4471 12.66 19.8695L11.2619 21.2676L12.66 22.6658C13.0823 23.0881 13.0823 23.7727 12.66 24.195C12.2377 24.6174 11.553 24.6174 11.1307 24.195L9.73259 22.797L8.33446 24.195C7.91215 24.6174 7.22745 24.6174 6.80513 24.195C6.38283 23.7727 6.38283 23.0881 6.80513 22.6658L8.20326 21.2676L6.80512 19.8695C6.38281 19.4471 6.38281 18.7625 6.80512 18.3402ZM17.3023 23.4304C17.3023 22.8332 17.7865 22.349 18.3837 22.349H24.1512C24.7484 22.349 25.2326 22.8332 25.2326 23.4304C25.2326 24.0276 24.7484 24.5118 24.1512 24.5118H18.3837C17.7865 24.5118 17.3023 24.0276 17.3023 23.4304Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Horas extras", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M28.5025 16.0517C28.6624 13.3672 28.0025 10.6976 26.6103 8.39679C25.2181 6.09599 23.1594 4.27276 20.7072 3.16889C18.255 2.06502 15.5251 1.73266 12.8797 2.2159C10.2343 2.69914 7.79822 3.97514 5.89463 5.87467C3.99105 7.77421 2.70987 10.2075 2.221 12.8519C1.73213 15.4964 2.05868 18.2269 3.15733 20.6815C4.25598 23.136 6.07483 25.1986 8.37266 26.5957C10.6705 27.9928 13.3387 28.6584 16.0235 28.5042\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M21.1577 25.5791H29.9997\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M25.5787 21.158V30\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M15.2631 7.89502V15.2633L19.6841 19.6843\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Horas extras extraordinarias", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"30\" viewBox=\"0 0 30 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M28.5025 16.0517C28.6624 13.3672 28.0025 10.6976 26.6103 8.39679C25.2181 6.09599 23.1594 4.27276 20.7072 3.16889C18.255 2.06502 15.5251 1.73266 12.8797 2.2159C10.2343 2.69914 7.79822 3.97514 5.89463 5.87467C3.99105 7.77421 2.70987 10.2075 2.221 12.8519C1.73213 15.4964 2.05868 18.2269 3.15733 20.6815C4.25598 23.136 6.07483 25.1986 8.37266 26.5957C10.6705 27.9928 13.3387 28.6584 16.0235 28.5042\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M15.2631 7.89502V15.2633L19.6841 19.6843\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Otros", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"34\" height=\"34\" viewBox=\"0 0 34 34\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M17 12V17M17 17V22M17 17H22M17 17H12M32 17C32 18.9698 31.612 20.9204 30.8582 22.7403C30.1044 24.5601 28.9995 26.2137 27.6066 27.6066C26.2137 28.9995 24.5601 30.1044 22.7403 30.8582C20.9204 31.612 18.9698 32 17 32C15.0302 32 13.0796 31.612 11.2597 30.8582C9.43986 30.1044 7.78628 28.9995 6.3934 27.6066C5.00052 26.2137 3.89563 24.5601 3.14181 22.7403C2.38799 20.9204 2 18.9698 2 17C2 13.0218 3.58035 9.20644 6.3934 6.3934C9.20644 3.58035 13.0218 2 17 2C20.9782 2 24.7936 3.58035 27.6066 6.3934C30.4196 9.20644 32 13.0218 32 17Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "EmpBaseCal clase jornal", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"32\" viewBox=\"0 0 30 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M28.3276 12.9794C27.8814 10.4266 26.6971 8.0604 24.9211 6.17322C23.145 4.28604 20.8549 2.96053 18.3339 2.36046C15.8128 1.76039 13.1712 1.91204 10.7353 2.79669C8.29952 3.68134 6.17622 5.26023 4.6278 7.33827C3.07937 9.41631 2.17366 11.9025 2.02257 14.4895C1.87147 17.0766 2.48161 19.6513 3.77761 21.8955C5.0736 24.1396 6.99866 25.955 9.31495 27.1172C11.6312 28.2793 14.2373 28.7375 16.811 28.435\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M15.2622 7.89526V15.2635L17.4727 17.474\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M28.5251 19.6846H24.841C24.2547 19.6846 23.6925 19.9175 23.2779 20.332C22.8634 20.7465 22.6305 21.3088 22.6305 21.895C22.6305 22.4813 22.8634 23.0435 23.2779 23.4581C23.6925 23.8726 24.2547 24.1055 24.841 24.1055H26.3146C26.9009 24.1055 27.4631 24.3384 27.8776 24.7529C28.2922 25.1675 28.5251 25.7297 28.5251 26.316C28.5251 26.9022 28.2922 27.4645 27.8776 27.879C27.4631 28.2936 26.9009 28.5264 26.3146 28.5264H22.6305\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M25.5779 28.5262V29.9999M25.5779 18.2107V19.6843\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "EmpBaseCal clase mensual", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"28\" height=\"32\" viewBox=\"0 0 28 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M26.2667 12.6167V8.06667C26.2667 6.3914 24.9086 5.03333 23.2333 5.03333H5.03333C3.35807 5.03333 2 6.3914 2 8.06667V12.6167M26.2667 12.6167H2M26.2667 12.6167V13.7542M2 12.6167V26.2667C2 27.942 3.35807 29.3 5.03333 29.3H14.1333M8.06667 2V8.06667M20.2 2V8.06667\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/><path d=\"M25.8 20.2H22.3C21.743 20.2 21.2089 20.4212 20.815 20.815C20.4212 21.2089 20.2 21.743 20.2 22.3C20.2 22.8569 20.4212 23.391 20.815 23.7849C21.2089 24.1787 21.743 24.4 22.3 24.4H23.7C24.2569 24.4 24.791 24.6212 25.1849 25.015C25.5787 25.4089 25.8 25.943 25.8 26.5C25.8 27.0569 25.5787 27.591 25.1849 27.9849C24.791 28.3787 24.2569 28.6 23.7 28.6H20.2\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M23 28.6V30M23 18.8V20.2\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Licencias en clase mensual", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"29\" height=\"32\" viewBox=\"0 0 29 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M26.791 12.846V8.19774C26.791 6.48628 25.4036 5.09887 23.6921 5.09887H5.09887C3.38741 5.09887 2 6.48628 2 8.19774V12.846M26.791 12.846H2M26.791 12.846V14.0081M2 12.846V26.791C2 28.5025 3.38741 29.8898 5.09887 29.8898H14.3955M8.19774 2V8.19774M20.5932 2V8.19774\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/><path d=\"M22.9999 20.5V24.9999M22.9999 24.9999V30M22.9999 24.9999H27.5M22.9999 24.9999H18.5\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Feriados en clase mensual", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"29\" height=\"32\" viewBox=\"0 0 29 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M26.791 12.846V8.19774C26.791 6.48628 25.4036 5.09887 23.6921 5.09887H5.09887C3.38741 5.09887 2 6.48628 2 8.19774V12.846M26.791 12.846H2M26.791 12.846V14.0081M2 12.846V26.791C2 28.5025 3.38741 29.8898 5.09887 29.8898H14.3955M8.19774 2V8.19774M20.5932 2V8.19774\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/><path d=\"M21 21H27\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M21 21V29\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M21 25L25.8 25\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Hora normal en clase mensual", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"30\" height=\"32\" viewBox=\"0 0 30 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M27.2 9.70005V7.60005C27.2 6.85744 26.905 6.14525 26.3799 5.62015C25.8548 5.09505 25.1426 4.80005 24.4 4.80005H4.8C4.05739 4.80005 3.3452 5.09505 2.8201 5.62015C2.295 6.14525 2 6.85744 2 7.60005V27.2001C2 27.9427 2.295 28.6548 2.8201 29.1799C3.3452 29.7051 4.05739 30.0001 4.8 30.0001H9.7\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M20.2 2V7.6\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M9 2V7.6\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M2 13.2H9\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M22.3 23.7L20.2 21.95V18.8\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M28.6 21.6C28.6 23.8278 27.7151 25.9643 26.1397 27.5396C24.5644 29.115 22.4279 30 20.2 30C17.9722 30 15.8357 29.115 14.2604 27.5396C12.685 25.9643 11.8 23.8278 11.8 21.6C11.8 19.3721 12.685 17.2356 14.2604 15.6603C15.8357 14.0849 17.9722 13.2 20.2 13.2C22.4279 13.2 24.5644 14.0849 26.1397 15.6603C27.7151 17.2356 28.6 19.3721 28.6 21.6Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "ReligionesEmpresa", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"40\" height=\"34\" viewBox=\"0 0 40 34\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M32.0909 28.6364V31.0909C32.0909 31.6432 32.5386 32.0909 33.0909 32.0909H37.9132C38.4982 32.0909 38.9583 31.5909 38.9097 31.0079L37.9249 19.1897C37.8817 18.6714 37.4484 18.2727 36.9284 18.2727H33.0909C32.5386 18.2727 32.0909 18.7204 32.0909 19.2727V19.4242M32.0909 28.6364C32.0909 28.6364 28.0606 28.6364 25.7576 28.6364C24.8305 28.6364 24.6061 28.6364 23.4545 28.6364C22.7465 28.6364 21.9577 27.758 21.7693 27.5356C21.7409 27.502 21.7159 27.4659 21.6933 27.4282L20 24.6061M32.0909 28.6364V19.4242M20 24.6061L18.5041 27.0992C18.3518 27.3531 18.1449 27.5701 17.8985 27.7343L17.0493 28.3005C16.7208 28.5195 16.3352 28.6364 15.9404 28.6364C15.4991 28.6364 14.8708 28.6364 14.2424 28.6364C13.0909 28.6364 9.63636 28.6364 9.63636 28.6364C9.63636 28.6364 9.63636 28.6364 9.63636 28.6364H7.90909M20 24.6061V1.57576M7.90909 28.6364V31.0909C7.90909 31.6432 7.46138 32.0909 6.90909 32.0909H2.0868C1.50176 32.0909 1.04167 31.5909 1.09025 31.0079L2.0751 19.1897C2.11829 18.6714 2.55156 18.2727 3.07165 18.2727H6.90909C7.46137 18.2727 7.90909 18.7204 7.90909 19.2727V19.4242M7.90909 28.6364V19.4242M7.90909 19.4242H9.95945C10.4899 19.4242 10.9986 19.2135 11.3737 18.8385L11.6257 18.5865C11.8323 18.3798 11.9912 18.1304 12.091 17.8557L14.2424 11.9394L16.4207 2.68163C16.5023 2.33509 16.6788 2.01816 16.9305 1.76643V1.76643C17.406 1.29094 18.0961 1.09979 18.7485 1.26288L20 1.57576M20 1.57576L21.2515 1.26288C21.9039 1.09979 22.594 1.29094 23.0695 1.76643V1.76643C23.3212 2.01816 23.4977 2.33509 23.5793 2.68163L25.7576 11.9394L27.909 17.8557C28.0088 18.1304 28.1677 18.3798 28.3743 18.5865L28.6263 18.8385C29.0014 19.2135 29.5101 19.4242 30.0405 19.4242H32.0909\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-miterlimit=\"2.32452\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "OrigenesEmpresa", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"33\" height=\"30\" viewBox=\"0 0 33 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M26.54 1.57227C27.6087 2.42456 28.3458 3.80325 28.6459 5.24743C28.6817 5.25813 28.7174 5.27266 28.7526 5.28924L32.0988 6.86604C32.4823 7.04672 32.7273 7.43459 32.7273 7.86099V28.473C32.7273 29.2026 32.0342 29.7295 31.3376 29.5294L22.0603 26.8644L11.0299 29.9597C10.831 30.0155 10.6205 30.0133 10.4229 29.9534L0.776271 27.0291C0.315443 26.8894 0 26.462 0 25.9773V4.99916C0 4.26565 0.700123 3.73822 1.3987 3.94547L10.7294 6.71356L15.4723 5.23487C15.5383 5.21431 15.6047 5.20037 15.6708 5.19267C15.8539 4.09986 16.3672 3.04923 17.2263 2.0255C18.2456 0.810954 20.0333 0.0973591 21.777 0.0119365C23.5853 -0.0766548 24.9654 0.316555 26.54 1.57227ZM2.18114 6.46779V25.1608L10.1504 27.575V8.83L2.18114 6.46779ZM15.6134 7.49185L12.3316 8.51333V27.3117L20.6198 24.9883L20.6203 19.4971C20.6203 18.8904 21.1086 18.3986 21.7109 18.3986C22.3132 18.3986 22.8015 18.8904 22.8015 19.4971L22.8011 24.7933L30.5461 27.0175V8.5598L28.7137 7.69433C28.6827 7.87734 28.6428 8.05683 28.5937 8.2317C28.2327 9.51887 27.6486 10.6904 26.8362 11.75L22.7826 16.9057C22.3261 17.4863 21.4417 17.4548 21.027 16.8431L17.2391 11.2549C16.6137 10.3657 16.1759 9.57307 15.9281 8.86185C15.7704 8.40932 15.6682 7.96176 15.6134 7.49185ZM21.883 2.20623C20.6941 2.26447 19.4725 2.75208 18.8921 3.44369C18.1928 4.27704 17.8491 5.05675 17.7815 5.84667C17.7 6.79864 17.7545 7.46944 17.9862 8.13433C18.158 8.62733 18.5015 9.24928 19.0296 10.0005L21.9927 14.3717L25.1181 10.3967C25.7514 9.5706 26.2092 8.65218 26.4947 7.63439C26.8871 6.23561 26.2944 4.17856 25.186 3.29464C24.0483 2.38735 23.1882 2.14229 21.883 2.20623ZM22.107 3.36781C23.9139 3.36781 25.3787 4.84318 25.3787 6.66315C25.3787 8.48311 23.9139 9.95848 22.107 9.95848C20.3001 9.95848 18.8353 8.48311 18.8353 6.66315C18.8353 4.84318 20.3001 3.36781 22.107 3.36781ZM22.107 5.5647C21.5047 5.5647 21.0164 6.05649 21.0164 6.66315C21.0164 7.2698 21.5047 7.76159 22.107 7.76159C22.7093 7.76159 23.1976 7.2698 23.1976 6.66315C23.1976 6.05649 22.7093 5.5647 22.107 5.5647Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Localidades", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"26\" height=\"32\" viewBox=\"0 0 26 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M17.5 13C17.5 15.651 15.3893 17.8 12.7857 17.8C10.1821 17.8 8.07143 15.651 8.07143 13C8.07143 10.349 10.1821 8.2 12.7857 8.2C15.3893 8.2 17.5 10.349 17.5 13Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M24.5714 13C24.5714 24.4274 12.7857 31 12.7857 31C12.7857 31 1 24.4274 1 13C1 6.37258 6.27664 1 12.7857 1C19.2948 1 24.5714 6.37258 24.5714 13Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Ajuste de sueldos por inflación", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"32\" height=\"28\" viewBox=\"0 0 32 28\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M15.8234 20.6475C16.3773 20.6475 16.8306 20.1942 16.8306 19.6403V19.1367H17.1831C18.8449 19.1367 20.255 17.777 20.255 16.1151C20.255 14.4532 18.8953 13.0935 17.1831 13.0935H14.5644C14.0104 13.0935 13.5068 12.6403 13.5068 12.0863C13.5068 11.5324 13.9601 11.0791 14.5644 11.0791H18.7442C19.2982 11.0791 19.7514 10.6259 19.7514 10.0719C19.7514 9.51798 19.2982 9.06475 18.7442 9.06475H16.8306V8.56115C16.8306 8.00719 16.3773 7.55396 15.8234 7.55396C15.2694 7.55396 14.8162 8.00719 14.8162 8.56115V9.06475H14.5644C12.9025 9.06475 11.4924 10.4245 11.4924 12.0863C11.4924 13.7482 12.8521 15.1079 14.5644 15.1079H17.1831C17.737 15.1079 18.2406 15.5611 18.2406 16.1151C18.2406 16.6691 17.7874 17.1223 17.1831 17.1223H12.8521C12.2982 17.1223 11.8449 17.5755 11.8449 18.1295C11.8449 18.6834 12.2982 19.1367 12.8521 19.1367H14.7658V19.6403C14.8162 20.1942 15.2694 20.6475 15.8234 20.6475Z\" fill=\"var(--colors_gray08)\"/><path d=\"M3.83788 13.8993C4.08968 13.8993 4.29112 13.7986 4.4422 13.6978L8.01774 10.8777C8.47097 10.5252 8.52133 9.92086 8.16881 9.46762C7.8163 9.01439 7.21198 8.96403 6.75874 9.31655L4.94579 10.777C6.20479 5.64029 10.7875 2.06475 16.0249 2.06475C21.3127 2.06475 25.8954 5.64029 27.2048 10.777C27.3559 11.3309 27.9098 11.6331 28.4134 11.482C28.9674 11.3309 29.2695 10.777 29.1185 10.2734C27.6077 4.23022 22.1688 0 15.9746 0C9.83068 0 4.49256 4.1295 2.9314 10.0719L1.82349 8.51079C1.47097 8.05755 0.866656 7.95683 0.413419 8.30935C-0.0398185 8.66187 -0.140538 9.26619 0.21198 9.71942L3.03212 13.4964C3.1832 13.6978 3.435 13.8489 3.6868 13.8993C3.73716 13.8993 3.78752 13.8993 3.83788 13.8993Z\" fill=\"var(--colors_gray08)\"/><path d=\"M31.3346 20.4964L29.3705 16.2158C29.2698 15.964 29.0684 15.7626 28.7662 15.6618C28.5144 15.5611 28.2123 15.6115 27.9605 15.7122L23.8813 17.7266C23.3777 17.9784 23.1763 18.5827 23.4281 19.0863C23.6799 19.5899 24.2842 19.7913 24.7878 19.5395L26.8022 18.5827C25.09 23.0647 20.8598 26.0359 16.0252 26.0359C11.0396 26.0359 6.70867 22.8633 5.14752 18.1295C4.99644 17.6259 4.39212 17.3237 3.88853 17.4748C3.38493 17.6259 3.08277 18.2302 3.23385 18.7338C5.0468 24.2733 10.1835 28 16.0252 28C21.6151 28 26.6008 24.5755 28.6151 19.3885L29.4713 21.3021C29.6223 21.6546 30.0252 21.9064 30.3777 21.9064C30.5288 21.9064 30.6799 21.8561 30.7806 21.8057C31.3849 21.6043 31.5864 21 31.3346 20.4964Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Cuenta corriente de vacaciones", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"29\" height=\"29\" viewBox=\"0 0 29 29\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M25.0202 12.0713V7.75505C25.0202 6.16584 23.7319 4.87753 22.1427 4.87753H4.87753C3.28831 4.87753 2 6.16584 2 7.75505V12.0713M25.0202 12.0713H2M25.0202 12.0713V18.25M2 12.0713V25.0202C2 26.6095 3.28831 27.8977 4.87753 27.8977H13.5101M7.75505 2V7.75505M19.2652 2V7.75505\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\"/><path d=\"M20.5715 22.4285H18.8549C18.4605 22.4285 18.0749 22.5452 17.7468 22.764V22.764C17.191 23.1345 16.8572 23.7582 16.8572 24.4262V26.0022C16.8572 26.6701 17.191 27.2939 17.7468 27.6644V27.6644C18.0749 27.8832 18.4605 27.9999 18.8549 27.9999H20.5715\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/><path d=\"M27.0715 22.4285H25.3549C24.9605 22.4285 24.5749 22.5452 24.2468 22.764V22.764C23.691 23.1345 23.3572 23.7582 23.3572 24.4262V26.0022C23.3572 26.6701 23.691 27.2939 24.2468 27.6644V27.6644C24.5749 27.8832 24.9605 27.9999 25.3549 27.9999H27.0715\" stroke=\"var(--colors_gray08)\" stroke-width=\"2\" stroke-linecap=\"round\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char1 = AV8SVGId ;
      GXv_char2[0] = GXt_char1 ;
      new web.svgid_homeiconos(remoteHandle, context).execute( httpContext.getMessage( "Egresos / Permanencias", ""), GXv_char2) ;
      inisvg.this.GXt_char1 = GXv_char2[0] ;
      AV8SVGId = GXt_char1 ;
      AV9SVGValor = httpContext.getMessage( "<svg width=\"40\" height=\"30\" viewBox=\"0 0 40 30\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M33.4622 15C33.4622 12.8647 33.3811 10.7481 33.2217 8.65323C32.9601 5.21403 30.2211 2.49788 26.753 2.23846C24.6405 2.08044 22.5062 2 20.3529 2C18.1997 2 16.0653 2.08044 13.9528 2.23846C10.4847 2.49788 7.74576 5.21403 7.48416 8.65323C7.45514 9.03477 7.42871 9.41704 7.4049 9.8M33.4622 15L38.7059 9.8M33.4622 15L28.2185 9.8M7.2437 15C7.2437 17.1353 7.32482 19.2519 7.48416 21.3468C7.74576 24.786 10.4847 27.5021 13.9528 27.7615C16.0653 27.9196 18.1997 28 20.3529 28C22.5062 28 24.6405 27.9196 26.753 27.7615C30.2211 27.5021 32.9601 24.786 33.2217 21.3468C33.2507 20.9652 33.2772 20.583 33.301 20.2M7.2437 15L12.4874 20.2M7.2437 15L2 20.2\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/><path d=\"M15.7646 27.2353V22.7398C15.7646 21.7011 16.1773 20.705 16.9117 19.9705V19.9705C17.6462 19.2361 18.6423 18.8235 19.681 18.8235H21.0248C22.0635 18.8235 23.0596 19.2361 23.7941 19.9705V19.9705C24.5285 20.705 24.9411 21.7011 24.9411 22.7398V27.2353\" stroke=\"var(--colors_gray08)\" stroke-width=\"2.2\" stroke-linecap=\"round\"/><path d=\"M16.2239 12.2733C16.2239 14.5674 18.0592 16.4027 20.3533 16.4027C22.6474 16.4027 24.4827 14.5674 24.4827 12.2733C24.4827 9.97914 22.6474 8.14385 20.3533 8.14385C18.1165 8.0865 16.2239 9.97914 16.2239 12.2733ZM22.2459 12.2733C22.2459 13.3056 21.3856 14.1086 20.4106 14.1086C19.4356 14.1086 18.5753 13.2483 18.5753 12.2733C18.5753 11.2983 19.4356 10.438 20.4106 10.438C21.3856 10.438 22.2459 11.2409 22.2459 12.2733Z\" fill=\"var(--colors_gray08)\"/></svg>", "") ;
      /* Execute user subroutine: 'NEW' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'NEW' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&SVGId ", "")+AV8SVGId+httpContext.getMessage( " &SVGValor ", "")+AV9SVGValor) ;
      AV13GXLvl303 = (byte)(0) ;
      /* Using cursor P01V12 */
      pr_default.execute(0, new Object[] {AV8SVGId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1935SVGId = P01V12_A1935SVGId[0] ;
         AV13GXLvl303 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV13GXLvl303 == 0 )
      {
         /*
            INSERT RECORD ON TABLE SVG

         */
         A1935SVGId = AV8SVGId ;
         A1936SVGValor = AV9SVGValor ;
         /* Using cursor P01V13 */
         pr_default.execute(1, new Object[] {A1935SVGId, A1936SVGValor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SVG");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inisvg");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SVGId = "" ;
      AV9SVGValor = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A1935SVGId = "" ;
      A1936SVGValor = "" ;
      AV12Pgmname = "" ;
      scmdbuf = "" ;
      P01V12_A1935SVGId = new String[] {""} ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inisvg__default(),
         new Object[] {
             new Object[] {
            P01V12_A1935SVGId
            }
            , new Object[] {
            }
         }
      );
      AV12Pgmname = "iniSVG" ;
      /* GeneXus formulas. */
      AV12Pgmname = "iniSVG" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl303 ;
   private short Gx_err ;
   private int GX_INS257 ;
   private String AV8SVGId ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A1935SVGId ;
   private String AV12Pgmname ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private boolean returnInSub ;
   private String AV9SVGValor ;
   private String A1936SVGValor ;
   private IDataStoreProvider pr_default ;
   private String[] P01V12_A1935SVGId ;
}

final  class inisvg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01V12", "SELECT SVGId FROM SVG WHERE SVGId = ( ?) ORDER BY SVGId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01V13", "SAVEPOINT gxupdate;INSERT INTO SVG(SVGId, SVGValor) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               return;
      }
   }

}

