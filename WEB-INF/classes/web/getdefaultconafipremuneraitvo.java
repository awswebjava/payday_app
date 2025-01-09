package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdefaultconafipremuneraitvo extends GXProcedure
{
   public getdefaultconafipremuneraitvo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdefaultconafipremuneraitvo.class ), "" );
   }

   public getdefaultconafipremuneraitvo( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      getdefaultconafipremuneraitvo.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getdefaultconafipremuneraitvo.this.AV14CLICOD = aP0;
      getdefaultconafipremuneraitvo.this.AV8ConDescrip = aP1;
      getdefaultconafipremuneraitvo.this.AV12codigo_Viejo = aP2;
      getdefaultconafipremuneraitvo.this.aP3 = aP3;
      getdefaultconafipremuneraitvo.this.aP4 = aP4;
      getdefaultconafipremuneraitvo.this.aP5 = aP5;
      getdefaultconafipremuneraitvo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug3(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&codigo_Viejo ", "")+AV12codigo_Viejo) ;
      if ( GXutil.strcmp(AV12codigo_Viejo, "1253") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafiphorasextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1252") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1251") == 0 ) )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "520001" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "2811") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2816") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2817") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2adicionalgeneral(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1249") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1250") == 0 ) )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2desempleo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "6458") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponre_especiales(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2reintegroguarderia(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "6456") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "6457") == 0 ) )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponre_especiales(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2beneficioguarderia(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1414") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1415") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1416") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1409") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1417") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1408") == 0 ) )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         if ( ( GXutil.strcmp(AV12codigo_Viejo, "1417") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1408") == 0 ) )
         {
            GXt_char1 = AV10SubTipoConCod1 ;
            GXv_char2[0] = GXt_char1 ;
            new web.subtipoanticipocuotas(remoteHandle, context).execute( GXv_char2) ;
            getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
            AV10SubTipoConCod1 = GXt_char1 ;
         }
         else
         {
            GXt_char1 = AV10SubTipoConCod1 ;
            GXv_char2[0] = GXt_char1 ;
            new web.subtipoanticipodesueldo(remoteHandle, context).execute( GXv_char2) ;
            getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
            AV10SubTipoConCod1 = GXt_char1 ;
         }
         AV9SubTipoConCod2 = "" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1011") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1010") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2110") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2700") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1042") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1040") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1418") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1038") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1039") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1012") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2030") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2812") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2813") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2814") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2815") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, httpContext.getMessage( "101B", "")) == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2530") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2531") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2818") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1155") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1419") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1157") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1158") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         if ( ( GXutil.strcmp(AV12codigo_Viejo, "1040") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1038") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1039") == 0 ) )
         {
            GXt_char1 = AV9SubTipoConCod2 ;
            GXv_char2[0] = GXt_char1 ;
            new web.subtipo2feriado(remoteHandle, context).execute( GXv_char2) ;
            getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
            AV9SubTipoConCod2 = GXt_char1 ;
         }
         else
         {
            GXt_char1 = AV9SubTipoConCod2 ;
            GXv_char2[0] = GXt_char1 ;
            new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
            getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
            AV9SubTipoConCod2 = GXt_char1 ;
         }
         new web.msgdebug2(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&SubTipoConCod2 ", "")+AV9SubTipoConCod2) ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1020") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160001" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2013") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160001" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1030") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopremio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "170001" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1060") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopremio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "170001" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2014") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopremio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "170001" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1041") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1152") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         if ( GXutil.strcmp(AV12codigo_Viejo, "1041") == 0 )
         {
            AV9SubTipoConCod2 = "110005" ;
         }
         else
         {
            AV9SubTipoConCod2 = "110006" ;
         }
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1050") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1110") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1140") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1070") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1090") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1092") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1091") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3320") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3340") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510003" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1210") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1211") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "130001" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1220") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1212") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "130002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "7090") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "130002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "7110") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoextras(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "130002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1120") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "110008" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2710") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "110009" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2017") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "110007" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1150") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1151") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1091") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1153") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1154") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1156") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1158") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1231") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1232") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1233") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1234") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1235") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160004" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1236") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1237") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1227") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1228") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1229") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1224") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1225") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1226") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1221") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1222") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1223") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1238") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1239") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1241") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1242") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1243") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1244") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1245") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1246") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1247") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1254") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1255") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1256") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1257") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160003" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1180") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1248") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1181") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1182") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1200") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160000" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1230") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2076") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiponormal(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipsueldo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1240") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1410") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipadelantovacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1411") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1412") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "1413") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "1421") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, httpContext.getMessage( "142B", "")) == 0 ) )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2indemnizavacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, httpContext.getMessage( "142C", "")) == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2indemnizavacsac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1423") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2indemnizavacaciones(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "2523") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "9000") == 0 ) )
      {
         AV13ConAFIPTipo = "CAL_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocalculosac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2524") == 0 )
      {
         AV13ConAFIPTipo = "CAL_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocalculoganancias(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2gananciassac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2521") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "120000" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2522") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "120003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1301") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "120003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2520") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "120003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2530") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiposac(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "120003" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1350") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoadicional(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "160000" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2700") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         AV10SubTipoConCod1 = "" ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "2810") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "2819") == 0 ) )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopremio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         if ( GXutil.strcmp(AV12codigo_Viejo, "2810") == 0 )
         {
            AV9SubTipoConCod2 = "170000" ;
         }
         else
         {
            AV9SubTipoConCod2 = "170003" ;
         }
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4095") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipodescuentootros(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1610") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipindemnizapordespido(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1614") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipo2indemnizaantiguedad(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1630") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipindemnizapreaviso(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1631") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "520017" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1633") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "520016" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1634") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipobeneficio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "520017" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2800") == 0 )
      {
         AV13ConAFIPTipo = "REM_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopremio(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         GXt_char1 = AV9SubTipoConCod2 ;
         GXv_char2[0] = GXt_char1 ;
         new web.conceptoafipbonoproductividad(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV9SubTipoConCod2 = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3020") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510002" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3040") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510007" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3120") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510007" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "3220") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.getcodafip_asig(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "510001" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4800") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         AV10SubTipoConCod1 = "" ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         AV10SubTipoConCod1 = "" ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "9999") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiporedondeo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "9998") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtiporedondeo(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "1300") == 0 )
      {
         AV13ConAFIPTipo = "NRE_ARG" ;
         AV10SubTipoConCod1 = "" ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "2450") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipodescuentootros(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4010") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipojubilacion(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4020") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipopami(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "4030") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "5110") == 0 ) )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoobrasocial(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "4050") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "4051") == 0 ) )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoobrasocial(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4060") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoobrasocialadherentes(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4040") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocuotasindical(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "4211") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "6982") == 0 ) )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         AV10SubTipoConCod1 = "810005" ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4210") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocuotasindical(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "4090") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "4091") == 0 ) )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipodescuentootros(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4215") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocuotasindical(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "4220") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipocuotasindical(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( ( GXutil.strcmp(AV12codigo_Viejo, "6980") == 0 ) || ( GXutil.strcmp(AV12codigo_Viejo, "6981") == 0 ) )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoganancias(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = AV10SubTipoConCod1 ;
      }
      else if ( GXutil.strcmp(AV12codigo_Viejo, "6990") == 0 )
      {
         AV13ConAFIPTipo = "DES_ARG" ;
         GXt_char1 = AV10SubTipoConCod1 ;
         GXv_char2[0] = GXt_char1 ;
         new web.subtipoganancias(remoteHandle, context).execute( GXv_char2) ;
         getdefaultconafipremuneraitvo.this.GXt_char1 = GXv_char2[0] ;
         AV10SubTipoConCod1 = GXt_char1 ;
         AV9SubTipoConCod2 = "" ;
      }
      new web.msgdebug3(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "!&SubTipoConCod2 ", "")+AV9SubTipoConCod2+httpContext.getMessage( " &ConAFIPTipo ", "")+AV13ConAFIPTipo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getdefaultconafipremuneraitvo.this.AV10SubTipoConCod1;
      this.aP4[0] = getdefaultconafipremuneraitvo.this.AV9SubTipoConCod2;
      this.aP5[0] = getdefaultconafipremuneraitvo.this.AV13ConAFIPTipo;
      this.aP6[0] = getdefaultconafipremuneraitvo.this.AV11ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SubTipoConCod1 = "" ;
      AV9SubTipoConCod2 = "" ;
      AV13ConAFIPTipo = "" ;
      AV11ConCodigo = "" ;
      AV17Pgmname = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV17Pgmname = "getDefaultConAfipRemuneraitvo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getDefaultConAfipRemuneraitvo" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14CLICOD ;
   private String AV12codigo_Viejo ;
   private String AV10SubTipoConCod1 ;
   private String AV9SubTipoConCod2 ;
   private String AV13ConAFIPTipo ;
   private String AV11ConCodigo ;
   private String AV17Pgmname ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV8ConDescrip ;
   private String[] aP6 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
}

