package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidar_sac extends GXProcedure
{
   public liquidar_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidar_sac.class ), "" );
   }

   public liquidar_sac( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             byte[] aP5 )
   {
      liquidar_sac.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        byte[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             byte[] aP5 ,
                             String[] aP6 )
   {
      liquidar_sac.this.AV9CliCod = aP0;
      liquidar_sac.this.AV22EmpCod = aP1;
      liquidar_sac.this.AV21LiqNro = aP2;
      liquidar_sac.this.AV15TLiqCod = aP3;
      liquidar_sac.this.AV12LiqPeriodo = aP4;
      liquidar_sac.this.aP5 = aP5;
      liquidar_sac.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.meses_liquidar_sac_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      liquidar_sac.this.AV10ParmValue = GXv_char1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( ! (0==AV21LiqNro) )
      {
         GXv_boolean2[0] = AV23LiqSac ;
         GXv_char1[0] = AV13LiqDLog ;
         new web.getliqsac(remoteHandle, context).execute( AV9CliCod, AV22EmpCod, AV21LiqNro, GXv_boolean2, GXv_char1) ;
         liquidar_sac.this.AV23LiqSac = GXv_boolean2[0] ;
         liquidar_sac.this.AV13LiqDLog = GXv_char1[0] ;
         if ( AV23LiqSac )
         {
            AV17liquidaSAC = (byte)(1) ;
         }
         else
         {
            AV17liquidaSAC = (byte)(0) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(GXutil.trim( AV10ParmValue), "[]") == 0 )
         {
            AV13LiqDLog = httpContext.getMessage( "No se liquida SAC", "") ;
         }
         else
         {
            GXv_boolean2[0] = AV16TliqSAC ;
            new web.gettipoliqsac(remoteHandle, context).execute( AV9CliCod, AV15TLiqCod, GXv_boolean2) ;
            liquidar_sac.this.AV16TliqSAC = GXv_boolean2[0] ;
            if ( ! AV16TliqSAC )
            {
               AV13LiqDLog = httpContext.getMessage( "No liquida SAC por tipo de liquidación", "") ;
            }
            else
            {
               GXt_char3 = AV20egresoTLiqCod ;
               GXt_char4 = AV20egresoTLiqCod ;
               GXv_char1[0] = GXt_char4 ;
               new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char1) ;
               liquidar_sac.this.GXt_char4 = GXv_char1[0] ;
               GXv_char5[0] = GXt_char3 ;
               new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char4, GXv_char5) ;
               liquidar_sac.this.GXt_char3 = GXv_char5[0] ;
               AV20egresoTLiqCod = GXt_char3 ;
               if ( GXutil.strcmp(AV15TLiqCod, AV20egresoTLiqCod) == 0 )
               {
                  AV17liquidaSAC = (byte)(1) ;
                  AV13LiqDLog = httpContext.getMessage( "Liquida SAC por ser liquidación de egreso", "") ;
               }
               else
               {
                  AV11meses.fromJSonString(AV10ParmValue, null);
                  AV19i = (short)(1) ;
                  while ( AV19i <= AV11meses.size() )
                  {
                     if ( GXutil.month( AV12LiqPeriodo) == ((Number) AV11meses.elementAt(-1+AV19i)).byteValue() )
                     {
                        AV18esMesSac = true ;
                        if (true) break;
                     }
                     AV19i = (short)(AV19i+1) ;
                  }
                  if ( AV18esMesSac )
                  {
                     AV17liquidaSAC = (byte)(1) ;
                     AV13LiqDLog = httpContext.getMessage( "Liquida SAC por aplicar el tipo de liquidación y el mes", "") ;
                  }
                  else
                  {
                     AV13LiqDLog = GXutil.trim( localUtil.cmonth( AV12LiqPeriodo, httpContext.getLanguage( ))) + httpContext.getMessage( " no es mes de liquidación de sac. Los meses de liquidación de sac son: ", "") + GXutil.trim( AV11meses.toJSonString(false)) ;
                  }
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = liquidar_sac.this.AV17liquidaSAC;
      this.aP6[0] = liquidar_sac.this.AV13LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LiqDLog = "" ;
      AV10ParmValue = "" ;
      AV26Pgmname = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV20egresoTLiqCod = "" ;
      GXt_char3 = "" ;
      GXt_char4 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char5 = new String[1] ;
      AV11meses = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV26Pgmname = "liquidar_sac" ;
      /* GeneXus formulas. */
      AV26Pgmname = "liquidar_sac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17liquidaSAC ;
   private short AV22EmpCod ;
   private short AV19i ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV21LiqNro ;
   private String AV15TLiqCod ;
   private String AV26Pgmname ;
   private String AV20egresoTLiqCod ;
   private String GXt_char3 ;
   private String GXt_char4 ;
   private String GXv_char1[] ;
   private String GXv_char5[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV23LiqSac ;
   private boolean AV16TliqSAC ;
   private boolean GXv_boolean2[] ;
   private boolean AV18esMesSac ;
   private String AV13LiqDLog ;
   private String AV10ParmValue ;
   private GXSimpleCollection<Byte> AV11meses ;
   private String[] aP6 ;
   private byte[] aP5 ;
}

