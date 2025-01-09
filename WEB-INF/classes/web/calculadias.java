package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculadias extends GXProcedure
{
   public calculadias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculadias.class ), "" );
   }

   public calculadias( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     String aP3 ,
                                     boolean aP4 ,
                                     java.util.Date aP5 ,
                                     java.util.Date aP6 ,
                                     java.util.Date aP7 ,
                                     java.util.Date aP8 ,
                                     short[] aP9 ,
                                     java.util.Date[] aP10 )
   {
      calculadias.this.aP11 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        java.util.Date aP5 ,
                        java.util.Date aP6 ,
                        java.util.Date aP7 ,
                        java.util.Date aP8 ,
                        short[] aP9 ,
                        java.util.Date[] aP10 ,
                        java.util.Date[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             java.util.Date aP5 ,
                             java.util.Date aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             short[] aP9 ,
                             java.util.Date[] aP10 ,
                             java.util.Date[] aP11 )
   {
      calculadias.this.AV18CliCod = aP0;
      calculadias.this.AV19EmpCod = aP1;
      calculadias.this.AV20LegNumero = aP2;
      calculadias.this.AV33tipo_tarifa = aP3;
      calculadias.this.AV16EstadoRemCorr = aP4;
      calculadias.this.AV13LegLicenIni = aP5;
      calculadias.this.AV14LegLicenFin = aP6;
      calculadias.this.AV15ini_periodo = aP7;
      calculadias.this.AV12fin_periodo = aP8;
      calculadias.this.aP9 = aP9;
      calculadias.this.aP10 = aP10;
      calculadias.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&LegLicenFin ", "")+GXutil.trim( localUtil.dtoc( AV14LegLicenFin, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &fin_periodo ", "")+GXutil.trim( localUtil.dtoc( AV12fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( (( GXutil.resetTime(AV14LegLicenFin).before( GXutil.resetTime( AV12fin_periodo )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV14LegLicenFin), GXutil.resetTime(AV12fin_periodo)) )) )
      {
         AV9hastaFecha = AV14LegLicenFin ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "hasta 1", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "hasta 2", "")) ;
         AV9hastaFecha = AV12fin_periodo ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&LegLicenIni ", "")+GXutil.trim( localUtil.dtoc( AV13LegLicenIni, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ini_periodo ", "")+GXutil.trim( localUtil.dtoc( AV15ini_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( (( GXutil.resetTime(AV13LegLicenIni).after( GXutil.resetTime( AV15ini_periodo )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV13LegLicenIni), GXutil.resetTime(AV15ini_periodo)) )) )
      {
         AV10desdeFecha = AV13LegLicenIni ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "desde 1", "")) ;
      }
      else
      {
         AV10desdeFecha = AV15ini_periodo ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "desde 2", "")) ;
      }
      if ( GXutil.strcmp(AV33tipo_tarifa, "H") == 0 )
      {
         GXv_int1[0] = AV8LegLicCntDias ;
         new web.diasenperiodo(remoteHandle, context).execute( AV18CliCod, AV19EmpCod, AV20LegNumero, (short)(0), AV10desdeFecha, AV9hastaFecha, AV16EstadoRemCorr, false, GXv_int1) ;
         calculadias.this.AV8LegLicCntDias = GXv_int1[0] ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&desdeFecha ", "")+GXutil.trim( localUtil.dtoc( AV10desdeFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liqperiod ", "")+GXutil.trim( localUtil.dtoc( AV15ini_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " hastafecha ", "")+GXutil.trim( localUtil.dtoc( AV9hastaFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " finperio ", "")+GXutil.trim( localUtil.dtoc( AV12fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( GXutil.dateCompare(GXutil.resetTime(AV10desdeFecha), GXutil.resetTime(AV15ini_periodo)) && GXutil.dateCompare(GXutil.resetTime(AV9hastaFecha), GXutil.resetTime(AV12fin_periodo)) )
         {
            if ( ( GXutil.day( AV9hastaFecha) == 15 ) || ( GXutil.day( AV15ini_periodo) == 16 ) )
            {
               AV8LegLicCntDias = (short)(15) ;
            }
            else
            {
               AV8LegLicCntDias = (short)(30) ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "fijo ", "")+GXutil.trim( GXutil.str( AV8LegLicCntDias, 4, 0))) ;
         }
         else
         {
            AV8LegLicCntDias = (short)((GXutil.ddiff(AV9hastaFecha,AV10desdeFecha))+1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "calcula &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV8LegLicCntDias, 4, 0))) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = calculadias.this.AV8LegLicCntDias;
      this.aP10[0] = calculadias.this.AV10desdeFecha;
      this.aP11[0] = calculadias.this.AV9hastaFecha;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10desdeFecha = GXutil.nullDate() ;
      AV9hastaFecha = GXutil.nullDate() ;
      AV36Pgmname = "" ;
      GXv_int1 = new short[1] ;
      AV36Pgmname = "CalculaDias" ;
      /* GeneXus formulas. */
      AV36Pgmname = "CalculaDias" ;
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short AV8LegLicCntDias ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private String AV33tipo_tarifa ;
   private String AV36Pgmname ;
   private java.util.Date AV13LegLicenIni ;
   private java.util.Date AV14LegLicenFin ;
   private java.util.Date AV15ini_periodo ;
   private java.util.Date AV12fin_periodo ;
   private java.util.Date AV10desdeFecha ;
   private java.util.Date AV9hastaFecha ;
   private boolean AV16EstadoRemCorr ;
   private java.util.Date[] aP11 ;
   private short[] aP9 ;
   private java.util.Date[] aP10 ;
}

